package hu.unideb.inf.util;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;

import hu.unideb.inf.model.Course;
import hu.unideb.inf.model.CourseType;
import hu.unideb.inf.model.Curriculum;
import hu.unideb.inf.model.Subject;
import hu.unideb.inf.service.CourseLocalServiceUtil;
import hu.unideb.inf.service.CourseTypeLocalServiceUtil;
import hu.unideb.inf.service.CurriculumLocalServiceUtil;
import hu.unideb.inf.service.SubjectLocalServiceUtil;

public class SyllabusCSVParser {

	public static void parseLine(String line, ActionRequest request) throws PortalException, SystemException {
		String[] tokens = line.split(";");

		String subjectName = tokens[0];
		String subjectCode = tokens[1];
		int credit = Integer.parseInt(tokens[2]);
		String curriculumName = tokens[3];
		String curriculumCode = tokens[4];

		Curriculum curriculum = parseCurriculum(curriculumCode, curriculumName, request);
		Subject subject = parseSubject(curriculum, subjectCode, subjectName, credit, request);

		int i;
		for (i = 5; i <= tokens.length - 3; i += 3) {
			String hoursPerSemesterField = tokens[i];
			String hoursPerWeekField = tokens[i + 1];
			String typeOfCourse = tokens[i + 2];

			if (Validator.isNull(typeOfCourse)) {
				continue;
			}

			parseCourse(subject, hoursPerSemesterField, hoursPerWeekField, typeOfCourse, request);
		}
		System.out.println("i: " + i);
		if (i != tokens.length) {
			throw new RuntimeException("Failed to parse some Courses.");
		}
	}

	private static Curriculum parseCurriculum(String curriculumCode, String curriculumName, ActionRequest request)
			throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Curriculum.class.getName(), request);

		Curriculum curriculum = CurriculumLocalServiceUtil.fetchCurriculumByCode(curriculumCode);
		if (Validator.isNull(curriculum)) {
			curriculum = CurriculumLocalServiceUtil.addCurriculum(curriculumCode, curriculumName, serviceContext);
		} else {
			curriculum = CurriculumLocalServiceUtil.updateCurriculum(serviceContext.getUserId(),
					curriculum.getCurriculumId(), curriculumCode, curriculumName, serviceContext);
		}

		return curriculum;
	}

	private static Subject parseSubject(Curriculum curriculum, String subjectCode, String subjectName, int credit,
			ActionRequest request) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Subject.class.getName(), request);

		Subject subject = SubjectLocalServiceUtil.fetchSubjectByC_S(curriculum.getCurriculumId(), subjectCode);
		if (Validator.isNull(subject)) {
			subject = SubjectLocalServiceUtil.addSubject(subjectCode, subjectName, credit, curriculum.getCurriculumId(),
					serviceContext);
		} else {
			subject = SubjectLocalServiceUtil.updateSubject(serviceContext.getUserId(), subject.getSubjectId(),
					subjectCode, subjectName, credit, curriculum.getCurriculumId(), serviceContext);
		}

		return subject;
	}

	private static void parseCourse(Subject subject, String hoursPerSemesterField, String hoursPerWeekField,
			String typeOfCourse, ActionRequest request) throws PortalException, SystemException {
		int hoursPerSemester = Validator.isNull(hoursPerSemesterField) ? 0 : Integer.parseInt(hoursPerSemesterField);
		int hoursPerWeek = Validator.isNull(hoursPerWeekField) ? 0 : Integer.parseInt(hoursPerWeekField);

		CourseType courseType = parseCourseType(typeOfCourse, request);
		Course course = parseCourse(subject, courseType, hoursPerSemester, hoursPerWeek, request);

		System.out.println("Success: " + course);
	}

	private static CourseType parseCourseType(String courseTypeName, ActionRequest request)
			throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(CourseType.class.getName(), request);

		CourseType courseType = CourseTypeLocalServiceUtil.fetchCourseTypeByTypeName(courseTypeName);
		if (Validator.isNull(courseType)) {
			courseType = CourseTypeLocalServiceUtil.addCourseType(courseTypeName, serviceContext);
		} else {
			courseType = CourseTypeLocalServiceUtil.updateCourseType(serviceContext.getUserId(),
					courseType.getCourseTypeId(), courseTypeName, serviceContext);
		}

		return courseType;
	}

	private static Course parseCourse(Subject subject, CourseType courseType, int hoursPerSemester, int hoursPerWeek,
			ActionRequest request) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Course.class.getName(), request);

		Course course = CourseLocalServiceUtil.fetchCourseByS_CT(subject.getSubjectId(), courseType.getCourseTypeId());
		if (Validator.isNull(course)) {
			course = CourseLocalServiceUtil.addCourse(subject.getSubjectId(), hoursPerSemester, hoursPerWeek,
					courseType.getCourseTypeId(), serviceContext);
		} else {
			course = CourseLocalServiceUtil.updateCourse(serviceContext.getUserId(), course.getCourseId(),
					subject.getSubjectId(), hoursPerSemester, hoursPerWeek, courseType.getCourseTypeId(),
					serviceContext);
		}

		return course;
	}

}
