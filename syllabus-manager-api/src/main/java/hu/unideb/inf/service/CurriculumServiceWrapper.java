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
 * Provides a wrapper for {@link CurriculumService}.
 *
 * @author Adam Kiss
 * @see CurriculumService
 * @generated
 */
@ProviderType
public class CurriculumServiceWrapper implements CurriculumService,
	ServiceWrapper<CurriculumService> {
	public CurriculumServiceWrapper(CurriculumService curriculumService) {
		_curriculumService = curriculumService;
	}

	@Override
	public hu.unideb.inf.model.Curriculum addCurriculum(
		java.lang.String curriculumCode, java.lang.String curriculumName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _curriculumService.addCurriculum(curriculumCode, curriculumName,
			serviceContext);
	}

	@Override
	public hu.unideb.inf.model.Curriculum deleteCurriculum(long curriculumId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _curriculumService.deleteCurriculum(curriculumId, serviceContext);
	}

	@Override
	public hu.unideb.inf.model.Curriculum fetchCurriculumByCode(
		java.lang.String curriculumCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _curriculumService.fetchCurriculumByCode(curriculumCode);
	}

	@Override
	public hu.unideb.inf.model.Curriculum getCurriculum(long curriculumId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _curriculumService.getCurriculum(curriculumId);
	}

	@Override
	public hu.unideb.inf.model.Curriculum getCurriculumByCode(
		java.lang.String curriculumCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchCurriculumException {
		return _curriculumService.getCurriculumByCode(curriculumCode);
	}

	@Override
	public hu.unideb.inf.model.Curriculum updateCurriculum(long userId,
		long curriculumId, java.lang.String curriculumCode,
		java.lang.String curriculumName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _curriculumService.updateCurriculum(userId, curriculumId,
			curriculumCode, curriculumName, serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _curriculumService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Curriculum> getCurriculums()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _curriculumService.getCurriculums();
	}

	@Override
	public CurriculumService getWrappedService() {
		return _curriculumService;
	}

	@Override
	public void setWrappedService(CurriculumService curriculumService) {
		_curriculumService = curriculumService;
	}

	private CurriculumService _curriculumService;
}