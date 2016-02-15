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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import hu.unideb.inf.CourseTypeException;
import hu.unideb.inf.DuplicateCourseTypeException;
import hu.unideb.inf.NoSuchCourseTypeException;
import hu.unideb.inf.model.Course;
import hu.unideb.inf.model.CourseType;
import hu.unideb.inf.service.CourseLocalServiceUtil;
import hu.unideb.inf.service.CourseTypeLocalServiceUtil;
import hu.unideb.inf.service.base.CourseTypeLocalServiceBaseImpl;

/**
 * The implementation of the course type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the {@link hu.unideb.inf.service.CourseTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Adam Kiss
 * @see hu.unideb.inf.service.base.CourseTypeLocalServiceBaseImpl
 * @see hu.unideb.inf.service.CourseTypeLocalServiceUtil
 */
public class CourseTypeLocalServiceImpl extends CourseTypeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link hu.unideb.inf.service.CourseTypeLocalServiceUtil} to
	 * access the course type local service.
	 */

	public List<CourseType> getCourseTypes() throws SystemException {
		return courseTypePersistence.findAll();
	}

	public CourseType getCourseTypeByTypeName(String typeName) throws NoSuchCourseTypeException, SystemException {
		return courseTypePersistence.findByTypeName(typeName);
	}

	public CourseType fetchCourseTypeByTypeName(String typeName) throws SystemException {
		return courseTypePersistence.fetchByTypeName(typeName);
	}

	public boolean isCourseExistsWithTypeName(String typeName) throws SystemException {
		return courseTypePersistence.countByTypeName(typeName) > 0;
	}

	public CourseType addCourseType(String typeName, ServiceContext serviceContext)
			throws SystemException, PortalException {
		Date now = new Date();

		long courseTypeId = counterLocalService.increment();
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		long userId = serviceContext.getUserId();
		User user = userPersistence.findByPrimaryKey(userId);
		String userName = user.getFullName();

		validate(courseTypeId, typeName);

		CourseType courseType = courseTypePersistence.create(courseTypeId);

		courseType.setGroupId(groupId);
		courseType.setCompanyId(companyId);
		courseType.setUserId(userId);
		courseType.setUserName(userName);
		courseType.setCreateDate(serviceContext.getCreateDate(now));
		courseType.setModifiedDate(serviceContext.getModifiedDate(now));
		courseType.setTypeName(typeName);

		courseTypePersistence.update(courseType);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, CourseType.class.getName(),
				courseTypeId, false, true, true);

		return courseType;
	}

	public CourseType deleteCourseType(long courseTypeId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		CourseType courseType = CourseTypeLocalServiceUtil.getCourseType(courseTypeId);

		List<Course> coursesToDelete = CourseLocalServiceUtil.getCoursesByCourseTypeId(courseTypeId);
		for (Course course : coursesToDelete) {
			CourseLocalServiceUtil.deleteCourse(course.getCourseId(), serviceContext);
		}

		resourceLocalService.deleteResource(courseType.getCompanyId(), courseType.getClass().getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, courseTypeId);

		return deleteCourseType(courseType);
	}

	public CourseType updateCourseType(long userId, long courseTypeId, String typeName, ServiceContext serviceContext)
			throws SystemException, PortalException {
		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(courseTypeId, typeName);

		CourseType courseType = getCourseType(courseTypeId);

		courseType.setUserId(userId);
		courseType.setUserName(user.getFullName());
		courseType.setModifiedDate(serviceContext.getModifiedDate(now));
		courseType.setTypeName(typeName);

		courseTypePersistence.update(courseType);

		resourceLocalService.updateResources(user.getCompanyId(), groupId, CourseType.class.getName(), courseTypeId,
				serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());

		return courseType;
	}

	protected void validate(long courseTypeId, String typeName) throws PortalException, SystemException {
		if (Validator.isNull(typeName)) {
			throw new CourseTypeException();
		}

		CourseType courseType = CourseTypeLocalServiceUtil.fetchCourseTypeByTypeName(typeName);
		if (Validator.isNotNull(courseType)) {
			if (!Validator.equals(courseType.getCourseTypeId(), courseTypeId)) {
				throw new DuplicateCourseTypeException();
			}
		}
	}

}