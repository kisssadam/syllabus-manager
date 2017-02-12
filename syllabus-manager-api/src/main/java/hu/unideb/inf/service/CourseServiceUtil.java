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
 * Provides the remote service utility for Course. This utility wraps
 * {@link hu.unideb.inf.service.impl.CourseServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Adam Kiss
 * @see CourseService
 * @see hu.unideb.inf.service.base.CourseServiceBaseImpl
 * @see hu.unideb.inf.service.impl.CourseServiceImpl
 * @generated
 */
@ProviderType
public class CourseServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.unideb.inf.service.impl.CourseServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static hu.unideb.inf.model.Course addCourse(long subjectId,
		int hoursPerSemester, int hoursPerWeek, long courseTypeId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCourse(subjectId, hoursPerSemester, hoursPerWeek,
			courseTypeId, serviceContext);
	}

	public static hu.unideb.inf.model.Course deleteCourse(long courseId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCourse(courseId, serviceContext);
	}

	public static hu.unideb.inf.model.Course fetchCourseByS_CT(long subjectId,
		long courseTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCourseByS_CT(subjectId, courseTypeId);
	}

	public static hu.unideb.inf.model.Course getCourse(long courseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCourse(courseId);
	}

	public static hu.unideb.inf.model.Course getCourseByS_CT(long subjectId,
		long courseTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchCourseException {
		return getService().getCourseByS_CT(subjectId, courseTypeId);
	}

	public static hu.unideb.inf.model.Course updateCourse(long userId,
		long courseId, long subjectId, int hoursPerSemester, int hoursPerWeek,
		long courseTypeId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCourse(userId, courseId, subjectId, hoursPerSemester,
			hoursPerWeek, courseTypeId, serviceContext);
	}

	public static int getCoursesCountBySubjectId(long subjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCoursesCountBySubjectId(subjectId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<hu.unideb.inf.model.Course> getCourses()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCourses();
	}

	public static java.util.List<hu.unideb.inf.model.Course> getCoursesByCourseTypeId(
		long courseTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCoursesByCourseTypeId(courseTypeId);
	}

	public static java.util.List<hu.unideb.inf.model.Course> getCoursesBySubjectId(
		long subjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCoursesBySubjectId(subjectId);
	}

	public static java.util.List<hu.unideb.inf.model.Course> getCoursesBySubjectId(
		long subjectId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCoursesBySubjectId(subjectId, start, end);
	}

	public static CourseService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CourseService, CourseService> _serviceTracker = ServiceTrackerFactory.open(CourseService.class);
}