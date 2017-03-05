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
 * Provides the remote service utility for Lecturer. This utility wraps
 * {@link hu.unideb.inf.service.impl.LecturerServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Adam Kiss
 * @see LecturerService
 * @see hu.unideb.inf.service.base.LecturerServiceBaseImpl
 * @see hu.unideb.inf.service.impl.LecturerServiceImpl
 * @generated
 */
@ProviderType
public class LecturerServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.unideb.inf.service.impl.LecturerServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static hu.unideb.inf.model.Lecturer addLecturer(
		java.lang.String lecturerName, long lecturerUserId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addLecturer(lecturerName, lecturerUserId, serviceContext);
	}

	public static hu.unideb.inf.model.Lecturer deleteLecturer(long lecturerId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLecturer(lecturerId, serviceContext);
	}

	public static hu.unideb.inf.model.Lecturer fetchLecturerByN_U(
		java.lang.String lecturerName, long lecturerUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLecturerByN_U(lecturerName, lecturerUserId);
	}

	public static hu.unideb.inf.model.Lecturer getLecturer(long lecturerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLecturer(lecturerId);
	}

	public static hu.unideb.inf.model.Lecturer getLecturerByN_U(
		java.lang.String lecturerName, long lecturerUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchLecturerException {
		return getService().getLecturerByN_U(lecturerName, lecturerUserId);
	}

	public static hu.unideb.inf.model.Lecturer updateLecturer(long userId,
		long lecturerId, java.lang.String lecturerName, long lecturerUserId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateLecturer(userId, lecturerId, lecturerName,
			lecturerUserId, serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<hu.unideb.inf.model.Lecturer> getLecturers()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLecturers();
	}

	public static java.util.List<hu.unideb.inf.model.Lecturer> getLecturersByIds(
		long[] lecturerIds)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchLecturerException {
		return getService().getLecturersByIds(lecturerIds);
	}

	public static LecturerService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LecturerService, LecturerService> _serviceTracker =
		ServiceTrackerFactory.open(LecturerService.class);
}