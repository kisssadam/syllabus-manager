package hu.unideb.inf.importexport.common;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;

import hu.unideb.inf.model.Course;
import hu.unideb.inf.model.CourseType;
import hu.unideb.inf.model.Curriculum;
import hu.unideb.inf.model.Lecturer;
import hu.unideb.inf.model.Semester;
import hu.unideb.inf.model.Subject;
import hu.unideb.inf.model.Syllabus;
import hu.unideb.inf.model.TimetableCourse;
import hu.unideb.inf.service.CourseLocalServiceUtil;
import hu.unideb.inf.service.CourseTypeLocalServiceUtil;
import hu.unideb.inf.service.CurriculumLocalServiceUtil;
import hu.unideb.inf.service.LecturerLocalServiceUtil;
import hu.unideb.inf.service.SemesterLocalServiceUtil;
import hu.unideb.inf.service.SubjectLocalServiceUtil;
import hu.unideb.inf.service.SyllabusLocalServiceUtil;
import hu.unideb.inf.service.TimetableCourseLocalServiceUtil;
import hu.unideb.inf.web.constants.WebKeys;

public abstract class AbstractDataImporter implements DataImporter {

	private static final Log log = LogFactoryUtil.getLog(AbstractDataImporter.class);

	private ActionRequest actionRequest;

	private BufferedReader bufferedReader;

	public AbstractDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		this.actionRequest = actionRequest;

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		this.bufferedReader = new BufferedReader(new InputStreamReader(
				new FileInputStream(uploadRequest.getFile(WebKeys.FILE_INPUT_NAME)), StandardCharsets.UTF_8));
	}

	protected ActionRequest getActionRequest() {
		return actionRequest;
	}

	protected BufferedReader getBufferedReader() {
		return bufferedReader;
	}

	public void close() throws IOException {
		if (bufferedReader != null) {
			bufferedReader.close();
		}
	}

	protected CourseType parseCourseType(String courseTypeName) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(CourseType.class.getName(), actionRequest);

		CourseType courseType = CourseTypeLocalServiceUtil.fetchCourseTypeByTypeName(courseTypeName);
		if (courseType == null) {
			if (log.isTraceEnabled()) {
				log.trace(String.format("Adding new courseType: '%s'", courseTypeName));
			}
			courseType = CourseTypeLocalServiceUtil.addCourseType(courseTypeName, serviceContext);
		} else {
			if (log.isTraceEnabled()) {
				log.trace(String.format("Updating courseType: '%s'", courseTypeName));
			}
			courseType = CourseTypeLocalServiceUtil.updateCourseType(serviceContext.getUserId(),
					courseType.getCourseTypeId(), courseTypeName, serviceContext);
		}

		if (log.isTraceEnabled()) {
			log.trace(String.format("Parsed courseType: '%s'", courseType));
		}

		return courseType;
	}

	protected Semester parseSemester(String semester) throws PortalException {
		String[] semesterTokens = semester.split("/");

		int beginYear = Integer.parseInt(semesterTokens[0]);
		int endYear = Integer.parseInt(semesterTokens[1]);
		int division = Integer.parseInt(semesterTokens[2]);

		return parseSemester(beginYear, endYear, division);
	}

	protected Semester parseSemester(int beginYear, int endYear, int division) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Semester.class.getName(), actionRequest);

		Semester semester = SemesterLocalServiceUtil.fetchSemesterByB_E_D(beginYear, endYear, division);
		if (semester == null) {
			if (log.isTraceEnabled()) {
				log.trace(String.format("Adding new semester: beginYear: %d, endYear: %d, division: %d", beginYear,
						endYear, division));
			}
			semester = SemesterLocalServiceUtil.addSemester(beginYear, endYear, division, serviceContext);
		} else {
			if (log.isTraceEnabled()) {
				log.trace(String.format("Updating semester: beginYear: %d, endYear: %d, division: %d", beginYear,
						endYear, division));
			}
			semester = SemesterLocalServiceUtil.updateSemester(serviceContext.getUserId(), semester.getSemesterId(),
					beginYear, endYear, division, serviceContext);
		}

		if (log.isTraceEnabled()) {
			log.trace(String.format("Parsed semester: '%s'", semester));
		}

		return semester;
	}

	protected Lecturer parseLecturer(String lecturerName, long lecturerLiferayUserId) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Lecturer.class.getName(), actionRequest);

		Lecturer lecturer = LecturerLocalServiceUtil.fetchLecturerByN_U(lecturerName, lecturerLiferayUserId);
		if (lecturer == null) {
			if (log.isTraceEnabled()) {
				log.trace(String.format("Adding new lecturer: lecturerName: '%s', lecturerLiferayUserId: %d",
						lecturerName, lecturerLiferayUserId));
			}
			lecturer = LecturerLocalServiceUtil.addLecturer(lecturerName, lecturerLiferayUserId, serviceContext);
		} else {
			if (log.isTraceEnabled()) {
				log.trace(String.format("Updating lecturer: lecturerName: '%s', lecturerLiferayUserId: %d",
						lecturerName, lecturerLiferayUserId));
			}
			lecturer = LecturerLocalServiceUtil.updateLecturer(serviceContext.getUserId(), lecturer.getLecturerId(),
					lecturerName, lecturer.getLecturerUserId(), serviceContext);
		}

		if (log.isTraceEnabled()) {
			log.trace(String.format("Parsed lecturer: '%s'", lecturer));
		}

		return lecturer;
	}

	protected Curriculum parseCurriculum(String curriculumCode, String curriculumName) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Curriculum.class.getName(), actionRequest);

		Curriculum curriculum = CurriculumLocalServiceUtil.fetchCurriculumByCode(curriculumCode);
		if (curriculum == null) {
			if (log.isTraceEnabled()) {
				log.trace(String.format("Adding new curriculum: curriculumCode: '%s', curriculumName: '%s'",
						curriculumCode, curriculumName));
			}
			curriculum = CurriculumLocalServiceUtil.addCurriculum(curriculumCode, curriculumName, serviceContext);
		} else {
			if (log.isTraceEnabled()) {
				log.trace(String.format("Updating curriculum: curriculumCode: '%s', curriculumName: '%s'",
						curriculumCode, curriculumName));
			}
			curriculum = CurriculumLocalServiceUtil.updateCurriculum(serviceContext.getUserId(),
					curriculum.getCurriculumId(), curriculumCode, curriculumName, serviceContext);
		}

		if (log.isTraceEnabled()) {
			log.trace(String.format("Parsed curriculum: '%s'", curriculum));
		}

		return curriculum;
	}

	protected Subject parseSubject(Curriculum curriculum, String subjectCode, String subjectName, int credit)
			throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Subject.class.getName(), actionRequest);

		long curriculumId = curriculum.getCurriculumId();

		Subject subject = SubjectLocalServiceUtil.fetchSubjectByC_S(curriculumId, subjectCode);
		if (subject == null) {
			if (log.isTraceEnabled()) {
				log.trace(String.format(
						"Adding new subject: subjectCode: '%s', subjectName: '%s', credit: %d, curriculumId: %d",
						subjectCode, subjectName, credit, curriculumId));
			}
			subject = SubjectLocalServiceUtil.addSubject(subjectCode, subjectName, credit, curriculumId,
					serviceContext);
		} else {
			if (log.isTraceEnabled()) {
				log.trace(String.format(
						"Updating subject: subjectCode: '%s', subjectName: '%s', credit: %d, curriculumId: %d",
						subjectCode, subjectName, credit, curriculumId));
			}
			subject = SubjectLocalServiceUtil.updateSubject(serviceContext.getUserId(), subject.getSubjectId(),
					subjectCode, subjectName, credit, curriculumId, serviceContext);
		}

		if (log.isTraceEnabled()) {
			log.trace(String.format("Parsed subject: '%s'", subject));
		}

		return subject;
	}

	protected Course parseCourse(Subject subject, CourseType courseType, int hoursPerSemester, int hoursPerWeek)
			throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Course.class.getName(), actionRequest);

		long subjectId = subject.getSubjectId();
		long courseTypeId = courseType.getCourseTypeId();

		Course course = CourseLocalServiceUtil.fetchCourseByS_CT(subjectId, courseTypeId);
		if (course == null) {
			if (log.isTraceEnabled()) {
				log.trace(String.format(
						"Adding new course: subjectId: %d, courseTypeId: %d, hoursPerSemester: %d, hoursPerWeek: %d",
						subjectId, courseTypeId, hoursPerSemester, hoursPerWeek));
			}
			course = CourseLocalServiceUtil.addCourse(subjectId, hoursPerSemester, hoursPerWeek, courseTypeId,
					serviceContext);
		} else {
			if (log.isTraceEnabled()) {
				log.trace(String.format(
						"Updating course: subjectId: %d, courseTypeId: %d, hoursPerSemester: %d, hoursPerWeek: %d",
						subjectId, courseTypeId, hoursPerSemester, hoursPerWeek));
			}
			course = CourseLocalServiceUtil.updateCourse(serviceContext.getUserId(), course.getCourseId(), subjectId,
					hoursPerSemester, hoursPerWeek, courseTypeId, serviceContext);
		}

		if (log.isTraceEnabled()) {
			log.trace(String.format("Parsed course: '%s'", course));
		}

		return course;
	}

	protected TimetableCourse parseTimetableCourse(Course course, Semester semester, String timetableCourseCode,
			String subjectType, int recommendedTerm, int limit, long[] lecturerIds, String classScheduleInfo,
			String description) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(TimetableCourse.class.getName(),
				actionRequest);

		long courseId = course.getCourseId();
		long semesterId = semester.getSemesterId();

		TimetableCourse timetableCourse = TimetableCourseLocalServiceUtil.fetchTimetableCourseByC_S_T_S(courseId,
				semesterId, timetableCourseCode, subjectType);
		if (timetableCourse == null) {
			if (log.isTraceEnabled()) {
				log.trace(String.format(
						"Adding new timetableCourse: courseId: %d, semesterId: %d, timetableCourseCode: '%s', subjectType: '%s', recommendedTerm: %d, limit: %d, classScheduleInfo: '%s', description: '%s'",
						courseId, semesterId, timetableCourseCode, subjectType, recommendedTerm, limit,
						classScheduleInfo, description));
			}
			timetableCourse = TimetableCourseLocalServiceUtil.addTimetableCourse(courseId, semesterId,
					timetableCourseCode, subjectType, recommendedTerm, limit, lecturerIds, classScheduleInfo,
					description, serviceContext);
		} else {
			if (log.isTraceEnabled()) {
				log.trace(String.format(
						"Updating timetableCourse: courseId: %d, semesterId: %d, timetableCourseCode: '%s', subjectType: '%s', recommendedTerm: %d, limit: %d, classScheduleInfo: '%s', description: '%s'",
						courseId, semesterId, timetableCourseCode, subjectType, recommendedTerm, limit,
						classScheduleInfo, description));
				timetableCourse = TimetableCourseLocalServiceUtil.updateTimetableCourse(serviceContext.getUserId(),
						timetableCourse.getTimetableCourseId(), courseId, semesterId, timetableCourseCode, subjectType,
						recommendedTerm, limit, lecturerIds, classScheduleInfo, description, serviceContext);
			}
		}

		if (log.isTraceEnabled()) {
			log.trace(String.format("Parsed timetableCourse: '%s'", timetableCourse));
		}

		return timetableCourse;
	}

	protected Syllabus parseSyllabus(TimetableCourse timetableCourse, String competence, String ethicalStandards,
			String topics, String educationalMaterials, String recommendedLiterature, String weeklyTasks)
			throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(TimetableCourse.class.getName(),
				actionRequest);

		List<Syllabus> syllabuses = SyllabusLocalServiceUtil
				.getSyllabusesByTimetableCourseId(timetableCourse.getTimetableCourseId());

		Syllabus syllabus = null;

		for (Syllabus s : syllabuses) {
			if (StringUtil.equalsIgnoreCase(s.getCompetence(), competence)
					&& StringUtil.equalsIgnoreCase(s.getEthicalStandards(), ethicalStandards)
					&& StringUtil.equalsIgnoreCase(s.getTopics(), topics)
					&& StringUtil.equalsIgnoreCase(s.getEducationalMaterials(), educationalMaterials)
					&& StringUtil.equalsIgnoreCase(s.getRecommendedLiterature(), recommendedLiterature)
					&& StringUtil.equalsIgnoreCase(s.getWeeklyTasks(), weeklyTasks)) {
				syllabus = s;
				break;
			}
		}

		if (syllabus == null) {
			if (log.isTraceEnabled()) {
				log.trace(String.format(
						"Adding new syllabus: timetableCourseId: %d, competence: '%s', ethicalStandards: '%s', topics: '%s', educationalMaterials: '%s', recommendedLiteature: '%s', weeklyTasks: '%s'",
						timetableCourse.getTimetableCourseId(), competence, ethicalStandards, topics,
						educationalMaterials, recommendedLiterature, weeklyTasks));
			}
			syllabus = SyllabusLocalServiceUtil.addSyllabus(timetableCourse.getTimetableCourseId(), competence,
					ethicalStandards, topics, educationalMaterials, recommendedLiterature, weeklyTasks, serviceContext);
		}

		if (log.isTraceEnabled()) {
			log.trace(String.format("Parsed syllabus: '%s'", syllabus));
		}

		return syllabus;
	}

}
