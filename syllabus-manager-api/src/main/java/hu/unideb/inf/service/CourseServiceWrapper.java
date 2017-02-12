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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CourseService}.
 *
 * @author Adam Kiss
 * @see CourseService
 * @generated
 */
@ProviderType
public class CourseServiceWrapper implements CourseService,
	ServiceWrapper<CourseService> {
	public CourseServiceWrapper(CourseService courseService) {
		_courseService = courseService;
	}

	@Override
	public hu.unideb.inf.model.Course addCourse(long subjectId,
		int hoursPerSemester, int hoursPerWeek, long courseTypeId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseService.addCourse(subjectId, hoursPerSemester,
			hoursPerWeek, courseTypeId, serviceContext);
	}

	@Override
	public hu.unideb.inf.model.Course deleteCourse(long courseId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseService.deleteCourse(courseId, serviceContext);
	}

	@Override
	public hu.unideb.inf.model.Course fetchCourseByS_CT(long subjectId,
		long courseTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseService.fetchCourseByS_CT(subjectId, courseTypeId);
	}

	@Override
	public hu.unideb.inf.model.Course getCourse(long courseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _courseService.getCourse(courseId);
	}

	@Override
	public hu.unideb.inf.model.Course getCourseByS_CT(long subjectId,
		long courseTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchCourseException {
		return _courseService.getCourseByS_CT(subjectId, courseTypeId);
	}

	@Override
	public hu.unideb.inf.model.Course updateCourse(long userId, long courseId,
		long subjectId, int hoursPerSemester, int hoursPerWeek,
		long courseTypeId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseService.updateCourse(userId, courseId, subjectId,
			hoursPerSemester, hoursPerWeek, courseTypeId, serviceContext);
	}

	@Override
	public int getCoursesCountBySubjectId(long subjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseService.getCoursesCountBySubjectId(subjectId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _courseService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Course> getCourses()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseService.getCourses();
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Course> getCoursesByCourseTypeId(
		long courseTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseService.getCoursesByCourseTypeId(courseTypeId);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Course> getCoursesBySubjectId(
		long subjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseService.getCoursesBySubjectId(subjectId);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Course> getCoursesBySubjectId(
		long subjectId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseService.getCoursesBySubjectId(subjectId, start, end);
	}

	@Override
	public CourseService getWrappedService() {
		return _courseService;
	}

	@Override
	public void setWrappedService(CourseService courseService) {
		_courseService = courseService;
	}

	private CourseService _courseService;
}