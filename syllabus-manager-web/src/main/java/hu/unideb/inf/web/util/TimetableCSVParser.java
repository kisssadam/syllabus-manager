package hu.unideb.inf.web.util;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

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

	private static final Log log = LogFactoryUtil.getLog(TimetableCSVParser.class);

	public static void parseLine(String line, ActionRequest request) throws PortalException, SystemException {
//		long semesterId = ParamUtil.getLong(request, "semesterId");
//
//		String[] tokens = line.split(";(?! \")", 12);
//
//		if (log.isDebugEnabled()) {
//			log.debug("tokens.length: " + tokens.length);
//		}
//		if (log.isTraceEnabled()) {
//			for (int i = 0; i < tokens.length; i++) {
//				log.trace("token: " + tokens[i]);
//			}
//		}
//
//		String subjectCode = tokens[0];
//		String subjectName = tokens[1];
//		String timetableCourseCode = tokens[2];
//		String subjectType = tokens[3];
//		//
//		// // String jobb lenne, de a service layerben is modositani kellene meg
//		// a tobbi jsp-ben.
//		int recommendedTerm = 0;
//		if (Validator.isNotNull(tokens[4])) {
//			Integer.parseInt(tokens[4]);
//		}
//
//		int credit = Integer.parseInt(tokens[5]);
//		String courseTypeName = tokens[6];
//		int limit = Integer.parseInt(tokens[7]);
//		int studentCount = Integer.parseInt(tokens[8]); // DO NOT STORE!
//
//		String[] lecturerNames = tokens[9].split(",");
//		for (int i = 0; i < lecturerNames.length; i++) {
//			lecturerNames[i] = lecturerNames[i].trim();
//		}
//
//		String classScheduleInfo = tokens[10];
//		if (classScheduleInfo.length() > 0) {
//			if (classScheduleInfo.charAt(0) == '"') {
//				classScheduleInfo = classScheduleInfo.substring(1);
//			}
//
//			if (classScheduleInfo.charAt(classScheduleInfo.length() - 1) == '"') {
//				classScheduleInfo = classScheduleInfo.substring(0, classScheduleInfo.length() - 2);
//			}
//		}
//
//		String description = tokens[11];
//
//		// A curriculumId vagy curriculum sajnos nincs benne a csv-ben
//		Subject subject = SubjectLocalServiceUtil.getSubjectByC_S(curriculumId, subjectCode);
//
//		CourseType courseType = CourseTypeLocalServiceUtil.fetchCourseTypeByTypeName(courseTypeName);
//		if (Validator.isNull(courseType)) {
//			ServiceContext serviceContext = ServiceContextFactory.getInstance(CourseType.class.getName(), request);
//			courseType = CourseTypeLocalServiceUtil.addCourseType(courseTypeName, serviceContext);
//		}
//
//		// ha egy course type nincs bent a db-ben, akkor ez
//		// NoSuchCourseException-t valt ki...
//		Course course = CourseLocalServiceUtil.getCourseByS_CT(subject.getSubjectId(), courseType.getCourseTypeId());
//
//		long[] lecturerIds = new long[lecturerNames.length];
//
//		for (int i = 0; i < lecturerNames.length; i++) {
//			String lecturerName = lecturerNames[i];
//
//			Lecturer lecturer = LecturerLocalServiceUtil.fetchLecturerByName(lecturerName);
//
//			if (Validator.isNull(lecturer)) {
//				ServiceContext serviceContext = ServiceContextFactory.getInstance(Lecturer.class.getName(), request);
//				lecturer = LecturerLocalServiceUtil.addLecturer(lecturerName, 0, serviceContext);
//			}
//
//			lecturerIds[i] = lecturer.getLecturerId();
//		}
//
//		if (log.isDebugEnabled()) {
//			log.debug("subjectCode: " + subjectCode);
//			log.debug("subjectName: " + subjectName);
//			log.debug("courseCode: " + timetableCourseCode);
//			log.debug("subjectType: " + subjectType);
//			log.debug("recommendedTerm: " + recommendedTerm);
//			log.debug("credit: " + credit);
//			log.debug("courseTypeName: " + courseTypeName);
//			log.debug("limit: " + limit);
//			log.debug("studentCount: " + studentCount);
//			for (int i = 0; i < lecturerNames.length; i++) {
//				log.debug(String.format("lecturerNames[%d]: %s", i, lecturerNames[i]));
//			}
//			log.debug("classScheduleInfo: " + classScheduleInfo);
//			log.debug("description: " + description);
//		}
//
//		ServiceContext serviceContext = ServiceContextFactory.getInstance(TimetableCourse.class.getName(), request);
//
//		TimetableCourse timetableCourse = TimetableCourseLocalServiceUtil
//				.fetchTimetableCourseByC_S_T_S(course.getCourseId(), semesterId, timetableCourseCode, subjectType);
//
//		if (Validator.isNull(timetableCourse)) {
//			timetableCourse = TimetableCourseLocalServiceUtil.addTimetableCourse(course.getCourseId(), semesterId,
//					timetableCourseCode, subjectType, recommendedTerm, limit, lecturerIds, classScheduleInfo,
//					description, serviceContext);
//		} else {
//			timetableCourse = TimetableCourseLocalServiceUtil.updateTimetableCourse(serviceContext.getUserId(),
//					timetableCourse.getTimetableCourseId(), course.getCourseId(), semesterId, timetableCourseCode,
//					subjectType, recommendedTerm, limit, lecturerIds, classScheduleInfo, description, serviceContext);
//		}
//
//		if (log.isTraceEnabled()) {
//			log.trace("Successfully parsed: " + timetableCourse);
//		}
	}

}
