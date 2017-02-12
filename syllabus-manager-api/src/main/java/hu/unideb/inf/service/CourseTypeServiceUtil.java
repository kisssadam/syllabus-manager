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
 * Provides the remote service utility for CourseType. This utility wraps
 * {@link hu.unideb.inf.service.impl.CourseTypeServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Adam Kiss
 * @see CourseTypeService
 * @see hu.unideb.inf.service.base.CourseTypeServiceBaseImpl
 * @see hu.unideb.inf.service.impl.CourseTypeServiceImpl
 * @generated
 */
@ProviderType
public class CourseTypeServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.unideb.inf.service.impl.CourseTypeServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static hu.unideb.inf.model.CourseType addCourseType(
		java.lang.String typeName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addCourseType(typeName, serviceContext);
	}

	public static hu.unideb.inf.model.CourseType deleteCourseType(
		long courseTypeId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCourseType(courseTypeId, serviceContext);
	}

	public static hu.unideb.inf.model.CourseType fetchCourseTypeByTypeName(
		java.lang.String typeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCourseTypeByTypeName(typeName);
	}

	public static hu.unideb.inf.model.CourseType getCourseType(
		long courseTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCourseType(courseTypeId);
	}

	public static hu.unideb.inf.model.CourseType getCourseTypeByTypeName(
		java.lang.String typeName)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchCourseTypeException {
		return getService().getCourseTypeByTypeName(typeName);
	}

	public static hu.unideb.inf.model.CourseType updateCourseType(long userId,
		long courseTypeId, java.lang.String typeName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCourseType(userId, courseTypeId, typeName,
			serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<hu.unideb.inf.model.CourseType> getCourseTypes()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCourseTypes();
	}

	public static CourseTypeService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CourseTypeService, CourseTypeService> _serviceTracker =
		ServiceTrackerFactory.open(CourseTypeService.class);
}