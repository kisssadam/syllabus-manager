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
 * Provides a wrapper for {@link SemesterService}.
 *
 * @author Adam Kiss
 * @see SemesterService
 * @generated
 */
@ProviderType
public class SemesterServiceWrapper implements SemesterService,
	ServiceWrapper<SemesterService> {
	public SemesterServiceWrapper(SemesterService semesterService) {
		_semesterService = semesterService;
	}

	@Override
	public hu.unideb.inf.model.Semester addCurrentSemester(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _semesterService.addCurrentSemester(serviceContext);
	}

	@Override
	public hu.unideb.inf.model.Semester addNextSemester(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _semesterService.addNextSemester(serviceContext);
	}

	@Override
	public hu.unideb.inf.model.Semester addSemester(int beginYear, int endYear,
		int division,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _semesterService.addSemester(beginYear, endYear, division,
			serviceContext);
	}

	@Override
	public hu.unideb.inf.model.Semester deleteSemester(long semesterId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _semesterService.deleteSemester(semesterId, serviceContext);
	}

	@Override
	public hu.unideb.inf.model.Semester getLatestSemester()
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchSemesterException {
		return _semesterService.getLatestSemester();
	}

	@Override
	public hu.unideb.inf.model.Semester getSemester(long semesterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _semesterService.getSemester(semesterId);
	}

	@Override
	public hu.unideb.inf.model.Semester getSemesterByB_E_D(int beginYear,
		int endYear, int division)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchSemesterException {
		return _semesterService.getSemesterByB_E_D(beginYear, endYear, division);
	}

	@Override
	public hu.unideb.inf.model.Semester updateSemester(long userId,
		long semesterId, int beginYear, int endYear, int division,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _semesterService.updateSemester(userId, semesterId, beginYear,
			endYear, division, serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _semesterService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Semester> getSemesters()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _semesterService.getSemesters();
	}

	@Override
	public SemesterService getWrappedService() {
		return _semesterService;
	}

	@Override
	public void setWrappedService(SemesterService semesterService) {
		_semesterService = semesterService;
	}

	private SemesterService _semesterService;
}