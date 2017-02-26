package hu.unideb.inf.web.portlet.action;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
import com.liferay.portal.kernel.util.Validator;

import hu.unideb.inf.exception.ExportDataContentTypeException;
import hu.unideb.inf.exception.ExportDataEntityTypeException;
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
		"mvc.command.name=" + WebKeys.MVC_RESOURCE_EXPORT_DATA
	},
	service = MVCResourceCommand.class
)
public class ExportDataMVCResourceCommand extends BaseMVCResourceCommand {

	private static final Log log = LogFactoryUtil.getLog(ExportDataMVCResourceCommand.class);
	
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
			String entityType = ParamUtil.getString(resourceRequest, "entityType", StringPool.BLANK);
			
			if (log.isDebugEnabled()) {
				log.debug(String.format("doServeResource() contentType: '%s', entityType: '%s'", contentType, entityType));
			}
			
			if (Validator.isBlank(contentType)) {
				throw new ExportDataContentTypeException(String.format("Unknown content type: '%s'", contentType));
			}
			
			if (Validator.isBlank(entityType)) {
				throw new ExportDataEntityTypeException(String.format("Unknown entity type: '%s'", entityType));
			}
			
			String filename = null;
			String content = null;
			
			switch (entityType) {
			case WebKeys.SYLLABUS:
				filename = getFilename("syllabus_data_", contentType);
				content = getSyllabusData(contentType);
				break;
			
			case WebKeys.LECTURER:
				filename = getFilename("lecturer_data_", contentType);
				content = getLecturerData(contentType);
				break;
			
			case WebKeys.SEMESTER:
				filename = getFilename("semester_data_", contentType);
				content = getSemesterData(contentType);
				break;
			
			case WebKeys.COURSE_TYPE:
				filename = getFilename("course_type_data_", contentType);
				content = getCourseTypeData(contentType);
				break;
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

	protected String getFilename(String prefix, String contentType) {
		String extension = "";
		
		switch (contentType) {
		case ContentTypes.TEXT_CSV:
		case ContentTypes.TEXT_CSV_UTF8:
			extension = "csv";
			break;
		
		case ContentTypes.TEXT_XML:
		case ContentTypes.TEXT_XML_UTF8:
			extension = "xml";
			break;
		
		default:
			extension = "dat";
			break;
		}
		
		return prefix + String.valueOf(new Date().getTime()) + "." + extension;
	}

	protected String getSyllabusData(String contentType) throws Exception {
		String data = null;
		
		switch (contentType) {
		case ContentTypes.TEXT_CSV_UTF8:
			data = getSyllabusDataCSV();
			break;
		
		case ContentTypes.TEXT_XML_UTF8:
			data = getSyllabusDataXML();
			break;
		}
		
		return data;
	}

	protected String getLecturerData(String contentType) throws Exception {
		String data = null;
		
		switch (contentType) {
		case ContentTypes.TEXT_CSV_UTF8:
			data = getLecturerDataCSV();
			break;
		
		case ContentTypes.TEXT_XML_UTF8:
			data = getLecturerDataXML();
			break;
		}
		
		return data;
	}
	
	protected String getSemesterData(String contentType) throws Exception {
		String data = null;
		
		switch (contentType) {
		case ContentTypes.TEXT_CSV_UTF8:
			data = getSemesterDataCSV();
			break;
		
		case ContentTypes.TEXT_XML_UTF8:
			data = getSemesterDataXML();
			break;
		}
		
		return data;
	}
	
	protected String getCourseTypeData(String contentType) throws Exception {
		String data = null;
		
		switch (contentType) {
		case ContentTypes.TEXT_CSV_UTF8:
			data = getCourseTypeDataCSV();
			break;
		
		case ContentTypes.TEXT_XML_UTF8:
			data = getCourseTypeDataXML();
			break;
		}
		
		return data;
	}
	
	protected String getCourseTypeDataCSV() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("courseType");
		sb.append(StringPool.NEW_LINE);
		
		for (CourseType courseType : courseTypeLocalService.getCourseTypes()) {
			sb.append(courseType.getTypeName());
			sb.append(StringPool.NEW_LINE);
		}
		
		return sb.toString();
	}

	protected String getCourseTypeDataXML() throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.newDocument();
		
		document.appendChild(getCourseTypesElement(document, courseTypeLocalService.getCourseTypes()));
		
		return documentToString(document);
	}

	protected String getLecturerDataCSV() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("lecturerName");
		sb.append(StringPool.SEMICOLON);
		sb.append("lecturerLiferayUserId");
		sb.append(StringPool.NEW_LINE);
		
		for (Lecturer lecturer : lecturerLocalService.getLecturers()) {
			sb.append(lecturer.getLecturerName());
			sb.append(StringPool.SEMICOLON);
			sb.append(lecturer.getLecturerUserId());
			sb.append(StringPool.NEW_LINE);
		}
		
		return sb.toString();
	}
	
	protected String getLecturerDataXML() throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.newDocument();
		
		document.appendChild(getLecturersElement(document, lecturerLocalService.getLecturers()));
		
		return documentToString(document);
	}

	protected String getSemesterDataCSV() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("semester");
		sb.append(StringPool.NEW_LINE);
		
		for (Semester semester : semesterLocalService.getSemesters()) {
			sb.append(getSemesterValue(semester));
			sb.append(StringPool.NEW_LINE);
		}
		
		return sb.toString();
	}
	
	protected String getSemesterDataXML() throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.newDocument();
		
		document.appendChild(getSemestersElement(document, semesterLocalService.getSemesters()));
		
		return documentToString(document);
	}

	protected String getSyllabusDataCSV() throws PortalException {
		StringBuilder sb = new StringBuilder();
		
		sb.append(getSyllabusCSVHeader());
		
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

	protected Object getSyllabusCSVHeader() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("curriculumCode");
		sb.append(StringPool.SEMICOLON);
		sb.append("curriculumName");
		sb.append(StringPool.SEMICOLON);
		sb.append("subjectCode");
		sb.append(StringPool.SEMICOLON);
		sb.append("subjectName");
		sb.append(StringPool.SEMICOLON);
		sb.append("credit");
		sb.append(StringPool.SEMICOLON);
		sb.append("courseTypeName");
		sb.append(StringPool.SEMICOLON);
		sb.append("hoursPerSemester");
		sb.append(StringPool.SEMICOLON);
		sb.append("hoursPerWeek");
		sb.append(StringPool.SEMICOLON);
		sb.append("semester");
		sb.append(StringPool.SEMICOLON);
		sb.append("lecturers");
		sb.append(StringPool.SEMICOLON);
		sb.append("timetableCourseCode");
		sb.append(StringPool.SEMICOLON);
		sb.append("subjectType");
		sb.append(StringPool.SEMICOLON);
		sb.append("recommendedTerm");
		sb.append(StringPool.SEMICOLON);
		sb.append("limit");
		sb.append(StringPool.SEMICOLON);
		sb.append("classScheduleInfo");
		sb.append(StringPool.SEMICOLON);
		sb.append("description");
		sb.append(StringPool.SEMICOLON);
		sb.append("competence");
		sb.append(StringPool.SEMICOLON);
		sb.append("ethicalStandards");
		sb.append(StringPool.SEMICOLON);
		sb.append("topics");
		sb.append(StringPool.SEMICOLON);
		sb.append("educationalMaterials");
		sb.append(StringPool.SEMICOLON);
		sb.append("recommendedLiterature");
		sb.append(StringPool.SEMICOLON);
		sb.append("weeklyTasks");
		sb.append(StringPool.NEW_LINE);
		
		return sb.toString();
	}

	protected String getCSVLine(String curriculumCode, String curriculumName) {
		return getCSVLine(curriculumCode, curriculumName, null, null, null);
	}
	
	protected String getCSVLine(String curriculumCode, String curriculumName, String subjectCode, String subjectName,
			Integer credit) {
		return getCSVLine(curriculumCode, curriculumName, subjectCode, subjectName, credit, null, null, null);
	}
	
	protected String getCSVLine(String curriculumCode, String curriculumName, String subjectCode, String subjectName,
			Integer credit, String courseTypeName, Integer hoursPerSemester, Integer hoursPerWeek) {
		return getCSVLine(curriculumCode, curriculumName, subjectCode, subjectName, credit, courseTypeName,
				hoursPerSemester, hoursPerWeek, null, null, null, null, null, null, null, null, null, null);
	}
	
	protected String getCSVLine(String curriculumCode, String curriculumName, String subjectCode, String subjectName,
			Integer credit, String courseTypeName, Integer hoursPerSemester, Integer hoursPerWeek,
			Integer semesterBeginYear, Integer semesterEndYear, Integer semesterDivision, List<Lecturer> lecturers,
			String timetableCourseCode, String subjectType, Integer recommendedTerm, Integer limit,
			String classScheduleInfo, String description) {
		return getCSVLine(curriculumCode, curriculumName, subjectCode, subjectName, credit, courseTypeName,
				hoursPerSemester, hoursPerWeek, semesterBeginYear, semesterEndYear, semesterDivision, lecturers,
				timetableCourseCode, subjectType, recommendedTerm, limit, classScheduleInfo, description, null, null,
				null, null, null, null);
	}
	
	protected String getCSVLine(String curriculumCode, String curriculumName, String subjectCode, String subjectName,
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
		
		sb.append(SyllabusCSVUtil.encode(getSemesterValue(semesterBeginYear, semesterEndYear, semesterDivision)));
		
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

	protected String getSyllabusDataXML() throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.newDocument();
		
		Element curriculums = document.createElement("curriculums");
		document.appendChild(curriculums);
		
		for (Curriculum curriculum : curriculumLocalService.getCurriculums()) {
			Element curriculumElement = document.createElement("curriculum");
			curriculums.appendChild(curriculumElement);
			
			Element curriculumCode = document.createElement("curriculumCode");
			curriculumCode.appendChild(document.createTextNode(curriculum.getCurriculumCode()));
			curriculumElement.appendChild(curriculumCode);
			
			Element curriculumName = document.createElement("curriculumName");
			curriculumName.appendChild(document.createTextNode(curriculum.getCurriculumName()));
			curriculumElement.appendChild(curriculumName);
			
			Element subjects = document.createElement("subjects");
			curriculumElement.appendChild(subjects);
			
			for (Subject subject : subjectLocalService.getSubjectsByCurriculumId(curriculum.getCurriculumId())) {
				Element subjectElement = document.createElement("subject");
				subjects.appendChild(subjectElement);
				
				Element subjectCode = document.createElement("subjectCode");
				subjectCode.appendChild(document.createTextNode(subject.getSubjectCode()));
				subjectElement.appendChild(subjectCode);
				
				Element subjectName = document.createElement("subjectName");
				subjectName.appendChild(document.createTextNode(subject.getSubjectName()));
				subjectElement.appendChild(subjectName);
				
				Element credit = document.createElement("credit");
				credit.appendChild(document.createTextNode(String.valueOf(subject.getCredit())));
				subjectElement.appendChild(credit);
				
				Element courses = document.createElement("courses");
				subjectElement.appendChild(courses);
				
				for (Course course : courseLocalService.getCoursesBySubjectId(subject.getSubjectId())) {
					Element courseElement = document.createElement("course");
					courses.appendChild(courseElement);
					
					CourseType courseType = courseTypeLocalService.getCourseType(course.getCourseTypeId());
					courseElement.setAttribute("courseType", courseType.getTypeName());
					
					Element hoursPerSemester = document.createElement("hoursPerSemester");
					hoursPerSemester.appendChild(document.createTextNode(String.valueOf(course.getHoursPerSemester())));
					courseElement.appendChild(hoursPerSemester);
					
					Element hoursPerWeek = document.createElement("hoursPerWeek");
					hoursPerWeek.appendChild(document.createTextNode(String.valueOf(course.getHoursPerWeek())));
					courseElement.appendChild(hoursPerWeek);
					
					Element timetableCourses = document.createElement("timetableCourses");
					courseElement.appendChild(timetableCourses);
					
					for (TimetableCourse timetableCourse : timetableCourseLocalService.getTimetableCoursesByCourseId(course.getCourseId())) {
						Element timetableCourseElement = document.createElement("timetableCourse");
						timetableCourses.appendChild(timetableCourseElement);
						
						Semester semester = semesterLocalService.getSemester(timetableCourse.getSemesterId());
						timetableCourseElement.setAttribute("semester", getSemesterValue(semester));
						
						Element timetableCourseCode = document.createElement("timetableCourseCode");
						timetableCourseCode.appendChild(document.createTextNode(timetableCourse.getTimetableCourseCode()));
						timetableCourseElement.appendChild(timetableCourseCode);
						
						Element subjectType = document.createElement("subjectType");
						subjectType.appendChild(document.createTextNode(timetableCourse.getSubjectType()));
						timetableCourseElement.appendChild(subjectType);
						
						Element recommendedTerm = document.createElement("recommendedTerm");
						recommendedTerm.appendChild(document.createTextNode(String.valueOf(timetableCourse.getRecommendedTerm())));
						timetableCourseElement.appendChild(recommendedTerm);
						
						Element limit = document.createElement("limit");
						limit.appendChild(document.createTextNode(String.valueOf(timetableCourse.getLimit())));
						timetableCourseElement.appendChild(limit);
						
						Element classShceduleInfo = document.createElement("classScheduleInfo");
						classShceduleInfo.appendChild(document.createTextNode(timetableCourse.getClassScheduleInfo()));
						timetableCourseElement.appendChild(classShceduleInfo);
						
						Element description = document.createElement("description");
						description.appendChild(document.createTextNode(timetableCourse.getDescription()));
						timetableCourseElement.appendChild(description);
						
						Element lecturers = getLecturersElement(document, lecturerLocalService.getTimetableCourseLecturers(timetableCourse.getTimetableCourseId()));
						timetableCourseElement.appendChild(lecturers);
						
						Element syllabuses = document.createElement("syllabuses");
						timetableCourseElement.appendChild(syllabuses);
						
						for (Syllabus syllabus : syllabusLocalService.getSyllabusesByTimetableCourseId(timetableCourse.getTimetableCourseId())) {
							Element syllabusElement = document.createElement("syllabus");
							syllabuses.appendChild(syllabusElement);
							
							Element competence = document.createElement("competence");
							competence.appendChild(document.createTextNode(syllabus.getCompetence()));
							syllabusElement.appendChild(competence);
							
							Element ethicalStandards = document.createElement("ethicalStandards");
							ethicalStandards.appendChild(document.createTextNode(syllabus.getEthicalStandards()));
							syllabusElement.appendChild(ethicalStandards);
							
							Element topics = document.createElement("topics");
							topics.appendChild(document.createTextNode(syllabus.getTopics()));
							syllabusElement.appendChild(topics);
							
							Element educationalMaterials = document.createElement("educationalMaterials");
							educationalMaterials.appendChild(document.createTextNode(syllabus.getEducationalMaterials()));
							syllabusElement.appendChild(educationalMaterials);
							
							Element weeklyTasks = document.createElement("weeklyTasks");
							weeklyTasks.appendChild(document.createCDATASection(syllabus.getWeeklyTasks()));
							syllabusElement.appendChild(weeklyTasks);
						}
					}
				}
			}
		}
		
		return documentToString(document);
	}

	protected Element getSemestersElement(Document document, List<Semester> semesterList) {
		Element semesters = document.createElement("semesters");
		
		for (Semester semester : semesterList) {
			Element semesterElement = document.createElement("semester");
			semesterElement.appendChild(document.createTextNode(getSemesterValue(semester)));
			semesters.appendChild(semesterElement);
		}
		
		return semesters;
	}

	protected Element getLecturersElement(Document document, List<Lecturer> lecturerList) {
		Element lecturers = document.createElement("lecturers");

		for (Lecturer lecturer : lecturerList) {
			Element lecturerElement = document.createElement("lecturer");
			lecturers.appendChild(lecturerElement);
			
			Element lecturerName = document.createElement("lecturerName");
			lecturerName.appendChild(document.createTextNode(lecturer.getLecturerName()));
			lecturerElement.appendChild(lecturerName);
			
			Element lecturerLiferayUserId = document.createElement("lecturerLiferayUserId");
			lecturerLiferayUserId.appendChild(document.createTextNode(String.valueOf(lecturer.getLecturerUserId())));
			lecturerElement.appendChild(lecturerLiferayUserId);
		}

		return lecturers;
	}
	
	protected Element getCourseTypesElement(Document document, List<CourseType> courseTypeList) {
		Element courseTypes = document.createElement("courseTypes");
		
		for (CourseType courseType : courseTypeList) {
			Element courseTypeElement = document.createElement("courseType");
			courseTypeElement.appendChild(document.createTextNode(courseType.getTypeName()));
			courseTypes.appendChild(courseTypeElement);
		}
		
		return courseTypes;
	}

	protected String getSemesterValue(Semester semester) {
		return getSemesterValue(semester.getBeginYear(), semester.getEndYear(), semester.getDivision());
	}
	
	protected String getSemesterValue(Integer beginYear, Integer endYear, Integer division) {
		return beginYear == null || endYear == null || division == null ? StringPool.BLANK : beginYear + "/" + endYear + "/" + division;
	}

	protected String documentToString(Document document) throws TransformerException {
		TransformerFactory tf = TransformerFactory.newInstance();
		tf.setAttribute("indent-number", Integer.valueOf(4));
		
		Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, StandardCharsets.UTF_8.toString());
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		
		StringWriter sw = new StringWriter();
		StreamResult sr = new StreamResult(sw);
		transformer.transform(new DOMSource(document), sr);
		sw.flush();
		return sw.toString();
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
