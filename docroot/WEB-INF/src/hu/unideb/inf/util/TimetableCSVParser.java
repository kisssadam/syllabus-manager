package hu.unideb.inf.util;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;

import hu.unideb.inf.model.Course;
import hu.unideb.inf.model.CourseType;
import hu.unideb.inf.model.Lecturer;
import hu.unideb.inf.model.Subject;
import hu.unideb.inf.model.TimetableCourse;
import hu.unideb.inf.service.CourseLocalServiceUtil;
import hu.unideb.inf.service.CourseTypeLocalServiceUtil;
import hu.unideb.inf.service.LecturerLocalServiceUtil;
import hu.unideb.inf.service.SubjectLocalServiceUtil;
import hu.unideb.inf.service.TimetableCourseLocalServiceUtil;

public class TimetableCSVParser {

	public static void parseLine(String line, ActionRequest request) throws PortalException, SystemException {
		long semesterId = ParamUtil.getLong(request, "semesterId");

		String[] tokens = line.split(";(?! \")", 12);

		// System.out.println("tokens.length: " + tokens.length);
		// for (int i = 0; i < tokens.length; i++) {
		// System.out.println("token: " + tokens[i]);
		// }

		String subjectCode = tokens[0];
		String subjectName = tokens[1];
		String timetableCourseCode = tokens[2];
		String subjectType = tokens[3];
		//
		// // String jobb lenne, de a service layerben is modositani kellene meg a tobbi jsp-ben.
		int recommendedTerm = 0;
		if (Validator.isNotNull(tokens[4])) {
			Integer.parseInt(tokens[4]);
		}

		int credit = Integer.parseInt(tokens[5]);
		String courseTypeString = tokens[6];
		int limit = Integer.parseInt(tokens[7]);
		int studentCount = Integer.parseInt(tokens[8]); // DO NOT STORE!

		String[] lecturerNames = tokens[9].split(",");
		for (int i = 0; i < lecturerNames.length; i++) {
			lecturerNames[i] = lecturerNames[i].trim();
		}

		String classScheduleInfo = tokens[10];
		if (classScheduleInfo.length() > 0) {
			if (classScheduleInfo.charAt(0) == '"') {
				classScheduleInfo = classScheduleInfo.substring(1);
			}

			if (classScheduleInfo.charAt(classScheduleInfo.length() - 1) == '"') {
				classScheduleInfo = classScheduleInfo.substring(0, classScheduleInfo.length() - 2);
			}
		}

		String description = tokens[11];

		Subject subject = SubjectLocalServiceUtil.getSubjectByCode(subjectCode);

		CourseType courseType = CourseTypeLocalServiceUtil.fetchCourseTypeByType(courseTypeString);
		if (Validator.isNull(courseType)) {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(CourseType.class.getName(), request);
			courseType = CourseTypeLocalServiceUtil.addCourseType(courseTypeString, serviceContext);
		}

		// ha egy course type nincs bent a db-ben, akkor ez NoSuchCourseException-t valt ki...
		Course course = CourseLocalServiceUtil.getCourseByS_CT(subject.getSubjectId(), courseType.getCourseTypeId());

		long[] lecturerIds = new long[lecturerNames.length];

		for (int i = 0; i < lecturerNames.length; i++) {
			String lecturerName = lecturerNames[i];

			Lecturer lecturer = LecturerLocalServiceUtil.fetchLecturerByName(lecturerName);

			if (Validator.isNull(lecturer)) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(Lecturer.class.getName(), request);
				lecturer = LecturerLocalServiceUtil.addLecturer(lecturerName, 0, serviceContext);
			}

			lecturerIds[i] = lecturer.getLecturerId();
		}

		// System.out.println("subjectCode: " + subjectCode);
		// System.out.println("subjectName: " + subjectName);
		// System.out.println("courseCode: " + timetableCourseCode);
		// System.out.println("subjectType: " + subjectType);
		// System.out.println("recommendedTerm: " + recommendedTerm);
		// System.out.println("credit: " + credit);
		// System.out.println("courseType: " + courseTypeString);
		// System.out.println("limit: " + limit);
		// System.out.println("studentCount: " + studentCount);
		// for (int i = 0; i < lecturerNames.length; i++) {
		// System.out.printf("lecturerNames[%d]: %s\n", i, lecturerNames[i]);
		// }
		// System.out.println("classScheduleInfo: " + classScheduleInfo);
		// System.out.println("description: " + description);
		// System.out.println();

		ServiceContext serviceContext = ServiceContextFactory.getInstance(TimetableCourse.class.getName(), request);

		TimetableCourseLocalServiceUtil.addTimetableCourse(course.getCourseId(), semesterId, timetableCourseCode,
				subjectType, recommendedTerm, limit, lecturerIds, classScheduleInfo, description, serviceContext);
	}

}
