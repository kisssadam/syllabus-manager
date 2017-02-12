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
 * Provides a wrapper for {@link TimetableCourseService}.
 *
 * @author Adam Kiss
 * @see TimetableCourseService
 * @generated
 */
@ProviderType
public class TimetableCourseServiceWrapper implements TimetableCourseService,
	ServiceWrapper<TimetableCourseService> {
	public TimetableCourseServiceWrapper(
		TimetableCourseService timetableCourseService) {
		_timetableCourseService = timetableCourseService;
	}

	@Override
	public hu.unideb.inf.model.TimetableCourse addTimetableCourse(
		long courseId, long semesterId, java.lang.String timetableCourseCode,
		java.lang.String subjectType, int recommendedTerm, int limit,
		long[] lecturerIds, java.lang.String classScheduleInfo,
		java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseService.addTimetableCourse(courseId, semesterId,
			timetableCourseCode, subjectType, recommendedTerm, limit,
			lecturerIds, classScheduleInfo, description, serviceContext);
	}

	@Override
	public hu.unideb.inf.model.TimetableCourse deleteTimetableCourse(
		long timetableCourseId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseService.deleteTimetableCourse(timetableCourseId,
			serviceContext);
	}

	@Override
	public hu.unideb.inf.model.TimetableCourse fetchTimetableCourseByC_S_T_S(
		long courseId, long semesterId, java.lang.String timetableCourseCode,
		java.lang.String subjectType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseService.fetchTimetableCourseByC_S_T_S(courseId,
			semesterId, timetableCourseCode, subjectType);
	}

	@Override
	public hu.unideb.inf.model.TimetableCourse getTimetableCourse(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timetableCourseService.getTimetableCourse(timetableCourseId);
	}

	@Override
	public hu.unideb.inf.model.TimetableCourse updateTimetableCourse(
		long userId, long timetableCourseId, long courseId, long semesterId,
		java.lang.String timetableCourseCode, java.lang.String subjectType,
		int recommendedTerm, int limit, long[] lecturerIds,
		java.lang.String classScheduleInfo, java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseService.updateTimetableCourse(userId,
			timetableCourseId, courseId, semesterId, timetableCourseCode,
			subjectType, recommendedTerm, limit, lecturerIds,
			classScheduleInfo, description, serviceContext);
	}

	@Override
	public int getTimetableCourseCountByCourseId(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseService.getTimetableCourseCountByCourseId(courseId);
	}

	@Override
	public int getTimetableCoursesCountBySemesterId(long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseService.getTimetableCoursesCountBySemesterId(semesterId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _timetableCourseService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Lecturer> getLecutersByTimetableCourseId(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseService.getLecutersByTimetableCourseId(timetableCourseId);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseService.getTimetableCourses();
	}

	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesByC_S(
		long courseId, long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchTimetableCourseException {
		return _timetableCourseService.getTimetableCoursesByC_S(courseId,
			semesterId);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesByCourseId(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseService.getTimetableCoursesByCourseId(courseId);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesByCourseId(
		long courseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseService.getTimetableCoursesByCourseId(courseId,
			start, end);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesBySemesterId(
		long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseService.getTimetableCoursesBySemesterId(semesterId);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesBySemesterId(
		long semesterId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseService.getTimetableCoursesBySemesterId(semesterId,
			start, end);
	}

	@Override
	public TimetableCourseService getWrappedService() {
		return _timetableCourseService;
	}

	@Override
	public void setWrappedService(TimetableCourseService timetableCourseService) {
		_timetableCourseService = timetableCourseService;
	}

	private TimetableCourseService _timetableCourseService;
}