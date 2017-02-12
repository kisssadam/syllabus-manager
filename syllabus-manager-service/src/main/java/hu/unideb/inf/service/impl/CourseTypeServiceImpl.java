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
import hu.unideb.inf.exception.NoSuchCourseTypeException;
import hu.unideb.inf.model.CourseType;
import hu.unideb.inf.service.base.CourseTypeServiceBaseImpl;
import hu.unideb.inf.service.permission.CourseTypePermission;
import hu.unideb.inf.service.permission.ModelPermission;
import hu.unideb.inf.util.SyllabusActionKeys;

/**
 * The implementation of the course type remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the {@link hu.unideb.inf.service.CourseTypeService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Adam Kiss
 * @see CourseTypeServiceBaseImpl
 * @see hu.unideb.inf.service.CourseTypeServiceUtil
 */
@ProviderType
public class CourseTypeServiceImpl extends CourseTypeServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link hu.unideb.inf.service.CourseTypeServiceUtil} to access the
	 * course type remote service.
	 */

	public CourseType getCourseType(long courseTypeId) throws PortalException {
		CourseTypePermission.check(getPermissionChecker(), courseTypeId, SyllabusActionKeys.VIEW);

		return courseTypeLocalService.getCourseType(courseTypeId);
	}

	public List<CourseType> getCourseTypes() throws SystemException {
		return courseTypeLocalService.getCourseTypes();
	}

	public CourseType getCourseTypeByTypeName(String typeName) throws NoSuchCourseTypeException, SystemException {
		return courseTypeLocalService.getCourseTypeByTypeName(typeName);
	}

	public CourseType fetchCourseTypeByTypeName(String typeName) throws SystemException {
		return courseTypeLocalService.fetchCourseTypeByTypeName(typeName);
	}

	public CourseType addCourseType(String typeName, ServiceContext serviceContext)
			throws SystemException, PortalException {
		ModelPermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(),
				SyllabusActionKeys.ADD_COURSE_TYPE);

		return courseTypeLocalService.addCourseType(typeName, serviceContext);
	}

	public CourseType deleteCourseType(long courseTypeId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		CourseTypePermission.check(getPermissionChecker(), courseTypeId, SyllabusActionKeys.DELETE);

		return courseTypeLocalService.deleteCourseType(courseTypeId, serviceContext);
	}

	public CourseType updateCourseType(long userId, long courseTypeId, String typeName, ServiceContext serviceContext)
			throws SystemException, PortalException {
		CourseTypePermission.check(getPermissionChecker(), courseTypeId, SyllabusActionKeys.UPDATE);

		return courseTypeLocalService.updateCourseType(userId, courseTypeId, typeName, serviceContext);
	}

}