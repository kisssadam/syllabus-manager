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
 * Provides a wrapper for {@link LecturerService}.
 *
 * @author Adam Kiss
 * @see LecturerService
 * @generated
 */
@ProviderType
public class LecturerServiceWrapper implements LecturerService,
	ServiceWrapper<LecturerService> {
	public LecturerServiceWrapper(LecturerService lecturerService) {
		_lecturerService = lecturerService;
	}

	@Override
	public hu.unideb.inf.model.Lecturer addLecturer(
		java.lang.String lecturerName, long lecturerUserId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lecturerService.addLecturer(lecturerName, lecturerUserId,
			serviceContext);
	}

	@Override
	public hu.unideb.inf.model.Lecturer deleteLecturer(long lecturerId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lecturerService.deleteLecturer(lecturerId, serviceContext);
	}

	@Override
	public hu.unideb.inf.model.Lecturer fetchLecturerByN_U(
		java.lang.String lecturerName, long lecturerUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lecturerService.fetchLecturerByN_U(lecturerName, lecturerUserId);
	}

	@Override
	public hu.unideb.inf.model.Lecturer getLecturer(long lecturerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _lecturerService.getLecturer(lecturerId);
	}

	@Override
	public hu.unideb.inf.model.Lecturer getLecturerByN_U(
		java.lang.String lecturerName, long lecturerUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchLecturerException {
		return _lecturerService.getLecturerByN_U(lecturerName, lecturerUserId);
	}

	@Override
	public hu.unideb.inf.model.Lecturer updateLecturer(long userId,
		long lecturerId, java.lang.String lecturerName, long lecturerUserId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _lecturerService.updateLecturer(userId, lecturerId,
			lecturerName, lecturerUserId, serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _lecturerService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Lecturer> getLecturers()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _lecturerService.getLecturers();
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Lecturer> getLecturersByIds(
		long[] lecturerIds)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchLecturerException {
		return _lecturerService.getLecturersByIds(lecturerIds);
	}

	@Override
	public LecturerService getWrappedService() {
		return _lecturerService;
	}

	@Override
	public void setWrappedService(LecturerService lecturerService) {
		_lecturerService = lecturerService;
	}

	private LecturerService _lecturerService;
}