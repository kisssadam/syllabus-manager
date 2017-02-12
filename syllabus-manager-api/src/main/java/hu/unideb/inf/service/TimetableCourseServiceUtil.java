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

package hu.unideb.inf.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for TimetableCourse. This utility wraps
 * {@link hu.unideb.inf.service.impl.TimetableCourseServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Adam Kiss
 * @see TimetableCourseService
 * @see hu.unideb.inf.service.base.TimetableCourseServiceBaseImpl
 * @see hu.unideb.inf.service.impl.TimetableCourseServiceImpl
 * @generated
 */
@ProviderType
public class TimetableCourseServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.unideb.inf.service.impl.TimetableCourseServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static hu.unideb.inf.model.TimetableCourse addTimetableCourse(
		long courseId, long semesterId, java.lang.String timetableCourseCode,
		java.lang.String subjectType, int recommendedTerm, int limit,
		long[] lecturerIds, java.lang.String classScheduleInfo,
		java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addTimetableCourse(courseId, semesterId,
			timetableCourseCode, subjectType, recommendedTerm, limit,
			lecturerIds, classScheduleInfo, description, serviceContext);
	}

	public static hu.unideb.inf.model.TimetableCourse deleteTimetableCourse(
		long timetableCourseId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteTimetableCourse(timetableCourseId, serviceContext);
	}

	public static hu.unideb.inf.model.TimetableCourse fetchTimetableCourseByC_S_T_S(
		long courseId, long semesterId, java.lang.String timetableCourseCode,
		java.lang.String subjectType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchTimetableCourseByC_S_T_S(courseId, semesterId,
			timetableCourseCode, subjectType);
	}

	public static hu.unideb.inf.model.TimetableCourse getTimetableCourse(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTimetableCourse(timetableCourseId);
	}

	public static hu.unideb.inf.model.TimetableCourse updateTimetableCourse(
		long userId, long timetableCourseId, long courseId, long semesterId,
		java.lang.String timetableCourseCode, java.lang.String subjectType,
		int recommendedTerm, int limit, long[] lecturerIds,
		java.lang.String classScheduleInfo, java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateTimetableCourse(userId, timetableCourseId, courseId,
			semesterId, timetableCourseCode, subjectType, recommendedTerm,
			limit, lecturerIds, classScheduleInfo, description, serviceContext);
	}

	public static int getTimetableCourseCountByCourseId(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCourseCountByCourseId(courseId);
	}

	public static int getTimetableCoursesCountBySemesterId(long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCoursesCountBySemesterId(semesterId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<hu.unideb.inf.model.Lecturer> getLecutersByTimetableCourseId(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLecutersByTimetableCourseId(timetableCourseId);
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCourses();
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesByC_S(
		long courseId, long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchTimetableCourseException {
		return getService().getTimetableCoursesByC_S(courseId, semesterId);
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesByCourseId(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCoursesByCourseId(courseId);
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesByCourseId(
		long courseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCoursesByCourseId(courseId, start, end);
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesBySemesterId(
		long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCoursesBySemesterId(semesterId);
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesBySemesterId(
		long semesterId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTimetableCoursesBySemesterId(semesterId, start, end);
	}

	public static TimetableCourseService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TimetableCourseService, TimetableCourseService> _serviceTracker =
		ServiceTrackerFactory.open(TimetableCourseService.class);
}