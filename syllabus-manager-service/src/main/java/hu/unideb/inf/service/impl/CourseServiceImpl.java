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
import hu.unideb.inf.exception.NoSuchCourseException;
import hu.unideb.inf.model.Course;
import hu.unideb.inf.service.base.CourseServiceBaseImpl;
import hu.unideb.inf.service.permission.CoursePermission;
import hu.unideb.inf.service.permission.ModelPermission;
import hu.unideb.inf.util.SyllabusActionKeys;

/**
 * The implementation of the course remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the {@link hu.unideb.inf.service.CourseService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Adam Kiss
 * @see CourseServiceBaseImpl
 * @see hu.unideb.inf.service.CourseServiceUtil
 */
@ProviderType
public class CourseServiceImpl extends CourseServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link hu.unideb.inf.service.CourseServiceUtil} to access the
	 * course remote service.
	 */

	public Course getCourse(long courseId) throws PortalException {
		CoursePermission.check(getPermissionChecker(), courseId, SyllabusActionKeys.VIEW);

		return courseLocalService.getCourse(courseId);
	}

	public List<Course> getCourses() throws SystemException {
		return courseLocalService.getCourses();
	}

	public Course getCourseByS_CT(long subjectId, long courseTypeId) throws NoSuchCourseException, SystemException {
		return courseLocalService.getCourseByS_CT(subjectId, courseTypeId);
	}

	public Course fetchCourseByS_CT(long subjectId, long courseTypeId) throws SystemException {
		return courseLocalService.fetchCourseByS_CT(subjectId, courseTypeId);
	}

	public List<Course> getCoursesBySubjectId(long subjectId) throws SystemException {
		return courseLocalService.getCoursesBySubjectId(subjectId);
	}

	public List<Course> getCoursesBySubjectId(long subjectId, int start, int end) throws SystemException {
		return courseLocalService.getCoursesBySubjectId(subjectId, start, end);
	}

	public int getCoursesCountBySubjectId(long subjectId) throws SystemException {
		return courseLocalService.getCoursesCountBySubjectId(subjectId);
	}

	public List<Course> getCoursesByCourseTypeId(long courseTypeId) throws SystemException {
		return courseLocalService.getCoursesByCourseTypeId(courseTypeId);
	}

	public Course addCourse(long subjectId, int hoursPerSemester, int hoursPerWeek, long courseTypeId,
			ServiceContext serviceContext) throws SystemException, PortalException {
		ModelPermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(), SyllabusActionKeys.ADD_COURSE);

		return courseLocalService.addCourse(subjectId, hoursPerSemester, hoursPerWeek, courseTypeId, serviceContext);
	}

	public Course deleteCourse(long courseId, ServiceContext serviceContext) throws PortalException, SystemException {
		CoursePermission.check(getPermissionChecker(), courseId, SyllabusActionKeys.DELETE);

		return courseLocalService.deleteCourse(courseId, serviceContext);
	}

	public Course updateCourse(long userId, long courseId, long subjectId, int hoursPerSemester, int hoursPerWeek,
			long courseTypeId, ServiceContext serviceContext) throws PortalException, SystemException {
		CoursePermission.check(getPermissionChecker(), courseId, SyllabusActionKeys.UPDATE);

		return courseLocalService.updateCourse(userId, courseId, subjectId, hoursPerSemester, hoursPerWeek,
				courseTypeId, serviceContext);
	}

}