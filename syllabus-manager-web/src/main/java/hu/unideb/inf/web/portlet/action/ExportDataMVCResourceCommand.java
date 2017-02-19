package hu.unideb.inf.web.portlet.action;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;

import hu.unideb.inf.exception.ExportDataContentTypeException;
import hu.unideb.inf.model.Course;
import hu.unideb.inf.model.CourseType;
import hu.unideb.inf.model.Curriculum;
import hu.unideb.inf.model.Lecturer;
import hu.unideb.inf.model.Semester;
import hu.unideb.inf.model.Subject;
import hu.unideb.inf.model.Syllabus;
import hu.unideb.inf.model.TimetableCourse;
import hu.unideb.inf.service.CourseLocalService;
import hu.unideb.inf.service.CourseTypeLocalService;
import hu.unideb.inf.service.CurriculumLocalService;
import hu.unideb.inf.service.LecturerLocalService;
import hu.unideb.inf.service.SemesterLocalService;
import hu.unideb.inf.service.SubjectLocalService;
import hu.unideb.inf.service.SyllabusLocalService;
import hu.unideb.inf.service.TimetableCourseLocalService;
import hu.unideb.inf.web.constants.SyllabusManagerPortletKeys;
import hu.unideb.inf.web.constants.WebKeys;
import hu.unideb.inf.web.util.SyllabusCSVUtil;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SyllabusManagerPortletKeys.SYLLABUS_MANAGER_ADMIN,
		"mvc.command.name=" + WebKeys.MVC_RESOURCE_EXPORT_SYLLABUS_DATA
	},
	service = MVCResourceCommand.class
)
public class ExportDataMVCResourceCommand extends BaseMVCResourceCommand {

	private static final Log log = LogFactoryUtil.getLog(ExportDataMVCResourceCommand.class);
	
	private static final String FILENAME_PREFIX = "syllabus_manager_data_";
	
	private CurriculumLocalService curriculumLocalService;

	private SubjectLocalService subjectLocalService;
	
	private CourseLocalService courseLocalService;
	
	private TimetableCourseLocalService timetableCourseLocalService;
	
	private SyllabusLocalService syllabusLocalService;
	
	private CourseTypeLocalService courseTypeLocalService;
	
	private SemesterLocalService semesterLocalService;
	
	private LecturerLocalService lecturerLocalService;
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			String contentType = ParamUtil.getString(resourceRequest, "contentType", StringPool.BLANK);
			
			if (log.isDebugEnabled()) {
				log.debug(String.format("doServeResource() contentType: '%s'", contentType));
			}
			
			String filename = null;
			String content = null;
			
			switch (contentType) {
			case ContentTypes.TEXT_CSV_UTF8:
				content = getSyllabusManagerDataCSV();
				filename = getFilename("csv");
				break;

			case ContentTypes.TEXT_XML_UTF8:
				content = getSyllabusManagerDataXML();
				filename = getFilename("xml");
				break;

			default:
				throw new ExportDataContentTypeException(String.format("Unkown content type: '%s'", contentType));
			}
			
			if (log.isTraceEnabled()) {
				log.trace(String.format("doServeResource() filename: '%s', content: '%s'", filename, content));
			}
			
			byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);
			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, filename, contentBytes, contentType);
		} catch (Exception e) {
			SessionErrors.add(resourceRequest, e.getClass());
			log.error(e);
		}
	}

	protected String getFilename(String extension) {
		return FILENAME_PREFIX + String.valueOf(new Date().getTime()) + "." + extension;
	}

	protected String getSyllabusManagerDataCSV() throws PortalException {
		StringBuilder sb = new StringBuilder();
		
		for (Curriculum curriculum : curriculumLocalService.getCurriculums()) {
			String curriculumCode = curriculum.getCurriculumCode();
			String curriculumName = curriculum.getCurriculumName();
			
			List<Subject> subjects = subjectLocalService.getSubjectsByCurriculumId(curriculum.getCurriculumId());
			if (subjects == null || subjects.isEmpty()) {
				sb.append(getCSVLine(curriculumCode, curriculumName));
			} else {
				for (Subject subject : subjects) {
					String subjectCode = subject.getSubjectCode();
					String subjectName = subject.getSubjectName();
					Integer credit = subject.getCredit();
					
					List<Course> courses = courseLocalService.getCoursesBySubjectId(subject.getSubjectId());
					if (courses == null || courses.isEmpty()) {
						sb.append(getCSVLine(curriculumCode, curriculumName, subjectCode, subjectName, credit));
					} else {
						for (Course course : courses) {
							CourseType courseType = courseTypeLocalService.getCourseType(course.getCourseTypeId());
							String courseTypeName = courseType.getTypeName();
							
							Integer hoursPerSemester = course.getHoursPerSemester();
							Integer hoursPerWeek = course.getHoursPerWeek();
							
							List<TimetableCourse> timetableCourses = timetableCourseLocalService.getTimetableCoursesByCourseId(course.getCourseId());
							if (timetableCourses == null || timetableCourses.isEmpty()) {
								sb.append(getCSVLine(curriculumCode, curriculumName, subjectCode, subjectName, credit,
										courseTypeName, hoursPerSemester, hoursPerWeek));
							} else {
								for (TimetableCourse timetableCourse : timetableCourses) {
									Semester semester = semesterLocalService.getSemester(timetableCourse.getSemesterId());
									Integer semesterBeginYear = semester.getBeginYear();
									Integer semesterEndYear = semester.getEndYear();
									Integer semesterDivision = semester.getDivision();
									
									List<Lecturer> lecturers = lecturerLocalService.getTimetableCourseLecturers(timetableCourse.getTimetableCourseId());
									
									String timetableCourseCode = timetableCourse.getTimetableCourseCode();
									String subjectType = timetableCourse.getSubjectType();
									Integer recommendedTerm = timetableCourse.getRecommendedTerm();
									Integer limit = timetableCourse.getLimit();
									String classScheduleInfo = timetableCourse.getClassScheduleInfo();
									String description = timetableCourse.getDescription();
									
									List<Syllabus> syllabuses = syllabusLocalService.getSyllabusesByTimetableCourseId(timetableCourse.getTimetableCourseId());
									if (syllabuses == null || syllabuses.isEmpty()) {
										sb.append(getCSVLine(curriculumCode, curriculumName, subjectCode, subjectName,
												credit, courseTypeName, hoursPerSemester, hoursPerWeek,
												semesterBeginYear, semesterEndYear, semesterDivision, lecturers,
												timetableCourseCode, subjectType, recommendedTerm, limit,
												classScheduleInfo, description));
									} else {
										for (Syllabus syllabus : syllabuses) {
											String competence = syllabus.getCompetence();
											String ethicalStandards = syllabus.getEthicalStandards();
											String topics = syllabus.getTopics();
											String educationalMaterials = syllabus.getEducationalMaterials();
											String recommendedLiterature = syllabus.getRecommendedLiterature();
											String weeklyTasks = syllabus.getWeeklyTasks();
											
											sb.append(getCSVLine(curriculumCode, curriculumName, subjectCode,
													subjectName, credit, courseTypeName, hoursPerSemester, hoursPerWeek,
													semesterBeginYear, semesterEndYear, semesterDivision, lecturers,
													timetableCourseCode, subjectType, recommendedTerm, limit,
													classScheduleInfo, description, competence, ethicalStandards,
													topics, educationalMaterials, recommendedLiterature, weeklyTasks));
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		return sb.toString();
	}

	private String getCSVLine(String curriculumCode, String curriculumName) {
		return getCSVLine(curriculumCode, curriculumName, null, null, null);
	}
	
	private String getCSVLine(String curriculumCode, String curriculumName, String subjectCode, String subjectName,
			Integer credit) {
		return getCSVLine(curriculumCode, curriculumName, subjectCode, subjectName, credit, null, null, null);
	}
	
	private String getCSVLine(String curriculumCode, String curriculumName, String subjectCode, String subjectName,
			Integer credit, String courseTypeName, Integer hoursPerSemester, Integer hoursPerWeek) {
		return getCSVLine(curriculumCode, curriculumName, subjectCode, subjectName, credit, courseTypeName,
				hoursPerSemester, hoursPerWeek, null, null, null, null, null, null, null, null, null, null);
	}
	
	private String getCSVLine(String curriculumCode, String curriculumName, String subjectCode, String subjectName,
			Integer credit, String courseTypeName, Integer hoursPerSemester, Integer hoursPerWeek,
			Integer semesterBeginYear, Integer semesterEndYear, Integer semesterDivision, List<Lecturer> lecturers,
			String timetableCourseCode, String subjectType, Integer recommendedTerm, Integer limit,
			String classScheduleInfo, String description) {
		return getCSVLine(curriculumCode, curriculumName, subjectCode, subjectName, credit, courseTypeName,
				hoursPerSemester, hoursPerWeek, semesterBeginYear, semesterEndYear, semesterDivision, lecturers,
				timetableCourseCode, subjectType, recommendedTerm, limit, classScheduleInfo, description, null, null,
				null, null, null, null);
	}
	
	private String getCSVLine(String curriculumCode, String curriculumName, String subjectCode, String subjectName,
			Integer credit, String courseTypeName, Integer hoursPerSemester, Integer hoursPerWeek,
			Integer semesterBeginYear, Integer semesterEndYear, Integer semesterDivision, List<Lecturer> lecturers,
			String timetableCourseCode, String subjectType, Integer recommendedTerm, Integer limit,
			String classScheduleInfo, String description, String competence, String ethicalStandards, String topics,
			String educationalMaterials, String recommendedLiterature, String weeklyTasks) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(SyllabusCSVUtil.encode(curriculumCode));
		sb.append(StringPool.SEMICOLON);
		sb.append(SyllabusCSVUtil.encode(curriculumName));
		
		sb.append(StringPool.SEMICOLON);
		
		sb.append(SyllabusCSVUtil.encode(subjectCode));
		sb.append(StringPool.SEMICOLON);
		sb.append(SyllabusCSVUtil.encode(subjectName));
		sb.append(StringPool.SEMICOLON);
		sb.append(SyllabusCSVUtil.encode(credit));
		
		sb.append(StringPool.SEMICOLON);
		
		sb.append(SyllabusCSVUtil.encode(courseTypeName));
		
		sb.append(StringPool.SEMICOLON);
		
		sb.append(SyllabusCSVUtil.encode(hoursPerSemester));
		sb.append(StringPool.SEMICOLON);
		sb.append(SyllabusCSVUtil.encode(hoursPerWeek));
		
		sb.append(StringPool.SEMICOLON);
		
		sb.append(SyllabusCSVUtil.encode(semesterBeginYear));
		sb.append(StringPool.SEMICOLON);
		sb.append(SyllabusCSVUtil.encode(semesterEndYear));
		sb.append(StringPool.SEMICOLON);
		sb.append(SyllabusCSVUtil.encode(semesterDivision));
		
		sb.append(StringPool.SEMICOLON);
		
		if (lecturers != null) {
			for (int i = 0; i < lecturers.size(); i++) {
				sb.append(SyllabusCSVUtil.encode(lecturers.get(i).getLecturerName()));
				if (i + 1 < lecturers.size()) {
					sb.append(StringPool.COMMA);
				}
			}
		}
		
		sb.append(StringPool.SEMICOLON);
		
		sb.append(SyllabusCSVUtil.encode(timetableCourseCode));
		sb.append(StringPool.SEMICOLON);
		sb.append(SyllabusCSVUtil.encode(subjectType));
		sb.append(StringPool.SEMICOLON);
		sb.append(SyllabusCSVUtil.encode(recommendedTerm));
		sb.append(StringPool.SEMICOLON);
		sb.append(SyllabusCSVUtil.encode(limit));
		sb.append(StringPool.SEMICOLON);
		sb.append(SyllabusCSVUtil.encode(classScheduleInfo));
		sb.append(StringPool.SEMICOLON);
		sb.append(SyllabusCSVUtil.encode(description));
		
		sb.append(StringPool.SEMICOLON);
		
		sb.append(SyllabusCSVUtil.encode(competence));
		sb.append(StringPool.SEMICOLON);
		sb.append(SyllabusCSVUtil.encode(ethicalStandards));
		sb.append(StringPool.SEMICOLON);
		sb.append(SyllabusCSVUtil.encode(topics));
		sb.append(StringPool.SEMICOLON);
		sb.append(SyllabusCSVUtil.encode(educationalMaterials));
		sb.append(StringPool.SEMICOLON);
		sb.append(SyllabusCSVUtil.encode(recommendedLiterature));
		sb.append(StringPool.SEMICOLON);
		sb.append(SyllabusCSVUtil.encode(weeklyTasks));
		
		sb.append(StringPool.NEW_LINE);
		
		return sb.toString();
	}

	protected String getSyllabusManagerDataXML() {
		// TODO java-s dom cucc jo lesz ide
		return "sample xml text";
	}
	

	@Reference(unbind = "-")
	protected void setCurriculumService(CurriculumLocalService curriculumLocalService) {
		this.curriculumLocalService = curriculumLocalService;
	}
	
	@Reference(unbind = "-")
	protected void setSubjectService(SubjectLocalService subjectLocalService) {
		this.subjectLocalService = subjectLocalService;
	}
	
	@Reference(unbind = "-")
	protected void setCourseService(CourseLocalService courseLocalService) {
		this.courseLocalService = courseLocalService;
	}
	
	@Reference(unbind = "-")
	protected void setTimetableCourseService(TimetableCourseLocalService timetableCourseLocalService) {
		this.timetableCourseLocalService = timetableCourseLocalService;
	}
	
	@Reference(unbind = "-")
	protected void setSyllabusService(SyllabusLocalService syllabusLocalService) {
		this.syllabusLocalService = syllabusLocalService;
	}
	
	@Reference(unbind = "-")
	protected void setCourseTypeService(CourseTypeLocalService courseTypeLocalService) {
		this.courseTypeLocalService = courseTypeLocalService;
	}
	
	@Reference(unbind = "-")
	protected void setSemesterService(SemesterLocalService semesterLocalService) {
		this.semesterLocalService = semesterLocalService;
	}
	
	@Reference(unbind = "-")
	protected void setLecturerService(LecturerLocalService lecturerLocalService) {
		this.lecturerLocalService = lecturerLocalService;
	}
	
}
