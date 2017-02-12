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

package hu.unideb.inf.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;

import aQute.bnd.annotation.ProviderType;
import hu.unideb.inf.exception.NoSuchTimetableCourseException;
import hu.unideb.inf.model.Lecturer;
import hu.unideb.inf.model.TimetableCourse;
import hu.unideb.inf.service.base.TimetableCourseServiceBaseImpl;
import hu.unideb.inf.service.permission.ModelPermission;
import hu.unideb.inf.service.permission.TimetableCoursePermission;
import hu.unideb.inf.util.SyllabusActionKeys;

/**
 * The implementation of the timetable course remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the {@link hu.unideb.inf.service.TimetableCourseService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Adam Kiss
 * @see TimetableCourseServiceBaseImpl
 * @see hu.unideb.inf.service.TimetableCourseServiceUtil
 */
@ProviderType
public class TimetableCourseServiceImpl extends TimetableCourseServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link hu.unideb.inf.service.TimetableCourseServiceUtil} to
	 * access the timetable course remote service.
	 */

	public TimetableCourse getTimetableCourse(long timetableCourseId) throws PortalException {
		TimetableCoursePermission.check(getPermissionChecker(), timetableCourseId, SyllabusActionKeys.VIEW);

		return timetableCourseLocalService.getTimetableCourse(timetableCourseId);
	}

	public List<TimetableCourse> getTimetableCourses() throws SystemException {
		return timetableCourseLocalService.getTimetableCourses();
	}

	public List<TimetableCourse> getTimetableCoursesBySemesterId(long semesterId) throws SystemException {
		return timetableCourseLocalService.getTimetableCoursesBySemesterId(semesterId);
	}

	public List<TimetableCourse> getTimetableCoursesBySemesterId(long semesterId, int start, int end)
			throws SystemException {
		return timetableCourseLocalService.getTimetableCoursesBySemesterId(semesterId, start, end);
	}

	public int getTimetableCoursesCountBySemesterId(long semesterId) throws SystemException {
		return timetableCourseLocalService.getTimetableCoursesCountBySemesterId(semesterId);
	}

	public TimetableCourse fetchTimetableCourseByC_S_T_S(long courseId, long semesterId, String timetableCourseCode,
			String subjectType) throws SystemException {
		return timetableCourseLocalService.fetchTimetableCourseByC_S_T_S(courseId, semesterId, timetableCourseCode,
				subjectType);
	}

	public List<TimetableCourse> getTimetableCoursesByC_S(long courseId, long semesterId)
			throws NoSuchTimetableCourseException, SystemException {
		return timetableCourseLocalService.getTimetableCoursesByC_S(courseId, semesterId);
	}

	public List<TimetableCourse> getTimetableCoursesByCourseId(long courseId) throws SystemException {
		return timetableCourseLocalService.getTimetableCoursesByCourseId(courseId);
	}

	public List<TimetableCourse> getTimetableCoursesByCourseId(long courseId, int start, int end)
			throws SystemException {
		return timetableCourseLocalService.getTimetableCoursesByCourseId(courseId, start, end);
	}

	public int getTimetableCourseCountByCourseId(long courseId) throws SystemException {
		return timetableCourseLocalService.getTimetableCourseCountByCourseId(courseId);
	}

	public List<Lecturer> getLecutersByTimetableCourseId(long timetableCourseId) throws SystemException {
		return timetableCourseLocalService.getLecutersByTimetableCourseId(timetableCourseId);
	}

	public TimetableCourse addTimetableCourse(long courseId, long semesterId, String timetableCourseCode,
			String subjectType, int recommendedTerm, int limit, long[] lecturerIds, String classScheduleInfo,
			String description, ServiceContext serviceContext) throws PortalException, SystemException {
		ModelPermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(),
				SyllabusActionKeys.ADD_TIMETABLE_COURSE);

		return timetableCourseLocalService.addTimetableCourse(courseId, semesterId, timetableCourseCode, subjectType,
				recommendedTerm, limit, lecturerIds, classScheduleInfo, description, serviceContext);
	}

	public TimetableCourse updateTimetableCourse(long userId, long timetableCourseId, long courseId, long semesterId,
			String timetableCourseCode, String subjectType, int recommendedTerm, int limit, long[] lecturerIds,
			String classScheduleInfo, String description, ServiceContext serviceContext)
			throws PortalException, SystemException {
		TimetableCoursePermission.check(getPermissionChecker(), timetableCourseId, SyllabusActionKeys.UPDATE);

		return timetableCourseLocalService.updateTimetableCourse(userId, timetableCourseId, courseId, semesterId,
				timetableCourseCode, subjectType, recommendedTerm, limit, lecturerIds, classScheduleInfo, description,
				serviceContext);
	}

	public TimetableCourse deleteTimetableCourse(long timetableCourseId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		TimetableCoursePermission.check(getPermissionChecker(), timetableCourseId, SyllabusActionKeys.DELETE);

		return timetableCourseLocalService.deleteTimetableCourse(timetableCourseId, serviceContext);
	}

}