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
 * Provides the remote service utility for Semester. This utility wraps
 * {@link hu.unideb.inf.service.impl.SemesterServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Adam Kiss
 * @see SemesterService
 * @see hu.unideb.inf.service.base.SemesterServiceBaseImpl
 * @see hu.unideb.inf.service.impl.SemesterServiceImpl
 * @generated
 */
@ProviderType
public class SemesterServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.unideb.inf.service.impl.SemesterServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static hu.unideb.inf.model.Semester addCurrentSemester(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addCurrentSemester(serviceContext);
	}

	public static hu.unideb.inf.model.Semester addNextSemester(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addNextSemester(serviceContext);
	}

	public static hu.unideb.inf.model.Semester addSemester(int beginYear,
		int endYear, int division,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSemester(beginYear, endYear, division, serviceContext);
	}

	public static hu.unideb.inf.model.Semester deleteSemester(long semesterId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSemester(semesterId, serviceContext);
	}

	public static hu.unideb.inf.model.Semester getLatestSemester()
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchSemesterException {
		return getService().getLatestSemester();
	}

	public static hu.unideb.inf.model.Semester getSemester(long semesterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSemester(semesterId);
	}

	public static hu.unideb.inf.model.Semester getSemesterByB_E_D(
		int beginYear, int endYear, int division)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchSemesterException {
		return getService().getSemesterByB_E_D(beginYear, endYear, division);
	}

	public static hu.unideb.inf.model.Semester updateSemester(long userId,
		long semesterId, int beginYear, int endYear, int division,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSemester(userId, semesterId, beginYear, endYear,
			division, serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<hu.unideb.inf.model.Semester> getSemesters()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSemesters();
	}

	public static SemesterService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SemesterService, SemesterService> _serviceTracker =
		ServiceTrackerFactory.open(SemesterService.class);
}