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

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import aQute.bnd.annotation.ProviderType;
import hu.unideb.inf.exception.CourseHoursException;
import hu.unideb.inf.exception.DeleteTimetableCoursesFirstException;
import hu.unideb.inf.exception.DuplicateCourseException;
import hu.unideb.inf.exception.NoSuchCourseException;
import hu.unideb.inf.exception.NoSuchCourseTypeException;
import hu.unideb.inf.exception.NoSuchSubjectException;
import hu.unideb.inf.model.Course;
import hu.unideb.inf.service.CourseLocalServiceUtil;
import hu.unideb.inf.service.CourseTypeLocalServiceUtil;
import hu.unideb.inf.service.SubjectLocalServiceUtil;
import hu.unideb.inf.service.TimetableCourseLocalServiceUtil;
import hu.unideb.inf.service.base.CourseLocalServiceBaseImpl;

/**
 * The implementation of the course local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.unideb.inf.service.CourseLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Adam Kiss
 * @see CourseLocalServiceBaseImpl
 * @see hu.unideb.inf.service.CourseLocalServiceUtil
 */
@ProviderType
public class CourseLocalServiceImpl extends CourseLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link hu.unideb.inf.service.CourseLocalServiceUtil} to access the course local service.
	 */

	public List<Course> getCourses() throws SystemException {
		return coursePersistence.findAll();
	}

	public Course getCourseByS_CT(long subjectId, long courseTypeId) throws NoSuchCourseException, SystemException {
		return coursePersistence.findByS_CT(subjectId, courseTypeId);
	}

	public Course fetchCourseByS_CT(long subjectId, long courseTypeId) throws SystemException {
		return coursePersistence.fetchByS_CT(subjectId, courseTypeId);
	}

	public List<Course> getCoursesBySubjectId(long subjectId) throws SystemException {
		return coursePersistence.findBySubjectId(subjectId);
	}

	public List<Course> getCoursesBySubjectId(long subjectId, int start, int end) throws SystemException {
		return coursePersistence.findBySubjectId(subjectId, start, end);
	}

	public int getCoursesCountBySubjectId(long subjectId) throws SystemException {
		return coursePersistence.countBySubjectId(subjectId);
	}

	public List<Course> getCoursesByCourseTypeId(long courseTypeId) throws SystemException {
		return coursePersistence.findByCourseType(courseTypeId);
	}

	public Course addCourse(long subjectId, int hoursPerSemester, int hoursPerWeek, long courseTypeId,
			ServiceContext serviceContext) throws SystemException, PortalException {
		Date now = new Date();

		long courseId = counterLocalService.increment();
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		long userId = serviceContext.getUserId();
		User user = userPersistence.findByPrimaryKey(userId);
		String userName = user.getFullName();

		validate(courseId, subjectId, hoursPerSemester, hoursPerWeek, courseTypeId);

		Course course = coursePersistence.create(courseId);

		course.setGroupId(groupId);
		course.setCompanyId(companyId);
		course.setUserId(userId);
		course.setUserName(userName);
		course.setCreateDate(serviceContext.getCreateDate(now));
		course.setModifiedDate(serviceContext.getModifiedDate(now));
		course.setSubjectId(subjectId);
		course.setHoursPerSemester(hoursPerSemester);
		course.setHoursPerWeek(hoursPerWeek);
		course.setCourseTypeId(courseTypeId);

		coursePersistence.update(course);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, Course.class.getName(), courseId, false,
				true, true);

		return course;
	}

	public Course deleteCourse(long courseId, ServiceContext serviceContext) throws PortalException, SystemException {
		if (!TimetableCourseLocalServiceUtil.getTimetableCoursesByCourseId(courseId).isEmpty()) {
			throw new DeleteTimetableCoursesFirstException();
		}
		
		Course course = CourseLocalServiceUtil.getCourse(courseId);

		resourceLocalService.deleteResource(course.getCompanyId(), course.getClass().getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, courseId);

		return deleteCourse(course);
	}

	public Course updateCourse(long userId, long courseId, long subjectId, int hoursPerSemester, int hoursPerWeek,
			long courseTypeId, ServiceContext serviceContext) throws PortalException, SystemException {
		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(courseId, subjectId, hoursPerSemester, hoursPerWeek, courseTypeId);

		Course course = getCourse(courseId);

		course.setUserId(userId);
		course.setUserName(user.getFullName());
		course.setModifiedDate(serviceContext.getModifiedDate(now));
		course.setSubjectId(subjectId);
		course.setHoursPerSemester(hoursPerSemester);
		course.setHoursPerWeek(hoursPerWeek);
		course.setCourseTypeId(courseTypeId);

		coursePersistence.update(course);

		resourceLocalService.updateResources(user.getCompanyId(), groupId, Course.class.getName(), courseId,
				serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());

		return course;
	}

	private void validate(long courseId, long subjectId, int hoursPerSemester, int hoursPerWeek, long courseTypeId)
			throws SystemException, PortalException {
		try {
			SubjectLocalServiceUtil.getSubject(subjectId);
		} catch (PortalException e) {
			throw new NoSuchSubjectException();
		}

		if (hoursPerSemester < 0) {
			throw new CourseHoursException();
		}

		if (hoursPerWeek < 0) {
			throw new CourseHoursException();
		}

		try {
			CourseTypeLocalServiceUtil.getCourseType(courseTypeId);
		} catch (PortalException e) {
			throw new NoSuchCourseTypeException();
		}

		Course course = CourseLocalServiceUtil.fetchCourseByS_CT(subjectId, courseTypeId);
		if (Validator.isNotNull(course)) {
			if (course.getCourseId() != courseId) {
				throw new DuplicateCourseException();
			}
		}
	}
	
}