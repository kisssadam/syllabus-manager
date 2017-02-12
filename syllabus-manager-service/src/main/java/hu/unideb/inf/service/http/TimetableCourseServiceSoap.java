/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package hu.unideb.inf.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import hu.unideb.inf.service.TimetableCourseServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link TimetableCourseServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link hu.unideb.inf.model.TimetableCourseSoap}.
 * If the method in the service utility returns a
 * {@link hu.unideb.inf.model.TimetableCourse}, that is translated to a
 * {@link hu.unideb.inf.model.TimetableCourseSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Adam Kiss
 * @see TimetableCourseServiceHttp
 * @see hu.unideb.inf.model.TimetableCourseSoap
 * @see TimetableCourseServiceUtil
 * @generated
 */
@ProviderType
public class TimetableCourseServiceSoap {
	public static hu.unideb.inf.model.TimetableCourseSoap getTimetableCourse(
		long timetableCourseId) throws RemoteException {
		try {
			hu.unideb.inf.model.TimetableCourse returnValue = TimetableCourseServiceUtil.getTimetableCourse(timetableCourseId);

			return hu.unideb.inf.model.TimetableCourseSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.TimetableCourseSoap[] getTimetableCourses()
		throws RemoteException {
		try {
			java.util.List<hu.unideb.inf.model.TimetableCourse> returnValue = TimetableCourseServiceUtil.getTimetableCourses();

			return hu.unideb.inf.model.TimetableCourseSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.TimetableCourseSoap[] getTimetableCoursesBySemesterId(
		long semesterId) throws RemoteException {
		try {
			java.util.List<hu.unideb.inf.model.TimetableCourse> returnValue = TimetableCourseServiceUtil.getTimetableCoursesBySemesterId(semesterId);

			return hu.unideb.inf.model.TimetableCourseSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.TimetableCourseSoap[] getTimetableCoursesBySemesterId(
		long semesterId, int start, int end) throws RemoteException {
		try {
			java.util.List<hu.unideb.inf.model.TimetableCourse> returnValue = TimetableCourseServiceUtil.getTimetableCoursesBySemesterId(semesterId,
					start, end);

			return hu.unideb.inf.model.TimetableCourseSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getTimetableCoursesCountBySemesterId(long semesterId)
		throws RemoteException {
		try {
			int returnValue = TimetableCourseServiceUtil.getTimetableCoursesCountBySemesterId(semesterId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.TimetableCourseSoap fetchTimetableCourseByC_S_T_S(
		long courseId, long semesterId, java.lang.String timetableCourseCode,
		java.lang.String subjectType) throws RemoteException {
		try {
			hu.unideb.inf.model.TimetableCourse returnValue = TimetableCourseServiceUtil.fetchTimetableCourseByC_S_T_S(courseId,
					semesterId, timetableCourseCode, subjectType);

			return hu.unideb.inf.model.TimetableCourseSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.TimetableCourseSoap[] getTimetableCoursesByC_S(
		long courseId, long semesterId) throws RemoteException {
		try {
			java.util.List<hu.unideb.inf.model.TimetableCourse> returnValue = TimetableCourseServiceUtil.getTimetableCoursesByC_S(courseId,
					semesterId);

			return hu.unideb.inf.model.TimetableCourseSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.TimetableCourseSoap[] getTimetableCoursesByCourseId(
		long courseId) throws RemoteException {
		try {
			java.util.List<hu.unideb.inf.model.TimetableCourse> returnValue = TimetableCourseServiceUtil.getTimetableCoursesByCourseId(courseId);

			return hu.unideb.inf.model.TimetableCourseSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.TimetableCourseSoap[] getTimetableCoursesByCourseId(
		long courseId, int start, int end) throws RemoteException {
		try {
			java.util.List<hu.unideb.inf.model.TimetableCourse> returnValue = TimetableCourseServiceUtil.getTimetableCoursesByCourseId(courseId,
					start, end);

			return hu.unideb.inf.model.TimetableCourseSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getTimetableCourseCountByCourseId(long courseId)
		throws RemoteException {
		try {
			int returnValue = TimetableCourseServiceUtil.getTimetableCourseCountByCourseId(courseId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.LecturerSoap[] getLecutersByTimetableCourseId(
		long timetableCourseId) throws RemoteException {
		try {
			java.util.List<hu.unideb.inf.model.Lecturer> returnValue = TimetableCourseServiceUtil.getLecutersByTimetableCourseId(timetableCourseId);

			return hu.unideb.inf.model.LecturerSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.TimetableCourseSoap addTimetableCourse(
		long courseId, long semesterId, java.lang.String timetableCourseCode,
		java.lang.String subjectType, int recommendedTerm, int limit,
		long[] lecturerIds, java.lang.String classScheduleInfo,
		java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.unideb.inf.model.TimetableCourse returnValue = TimetableCourseServiceUtil.addTimetableCourse(courseId,
					semesterId, timetableCourseCode, subjectType,
					recommendedTerm, limit, lecturerIds, classScheduleInfo,
					description, serviceContext);

			return hu.unideb.inf.model.TimetableCourseSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.TimetableCourseSoap updateTimetableCourse(
		long userId, long timetableCourseId, long courseId, long semesterId,
		java.lang.String timetableCourseCode, java.lang.String subjectType,
		int recommendedTerm, int limit, long[] lecturerIds,
		java.lang.String classScheduleInfo, java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.unideb.inf.model.TimetableCourse returnValue = TimetableCourseServiceUtil.updateTimetableCourse(userId,
					timetableCourseId, courseId, semesterId,
					timetableCourseCode, subjectType, recommendedTerm, limit,
					lecturerIds, classScheduleInfo, description, serviceContext);

			return hu.unideb.inf.model.TimetableCourseSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static hu.unideb.inf.model.TimetableCourseSoap deleteTimetableCourse(
		long timetableCourseId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			hu.unideb.inf.model.TimetableCourse returnValue = TimetableCourseServiceUtil.deleteTimetableCourse(timetableCourseId,
					serviceContext);

			return hu.unideb.inf.model.TimetableCourseSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TimetableCourseServiceSoap.class);
}