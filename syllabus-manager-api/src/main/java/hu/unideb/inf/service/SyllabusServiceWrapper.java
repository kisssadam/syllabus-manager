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
 * Provides a wrapper for {@link SyllabusService}.
 *
 * @author Adam Kiss
 * @see SyllabusService
 * @generated
 */
@ProviderType
public class SyllabusServiceWrapper implements SyllabusService,
	ServiceWrapper<SyllabusService> {
	public SyllabusServiceWrapper(SyllabusService syllabusService) {
		_syllabusService = syllabusService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _syllabusService.getOSGiServiceIdentifier();
	}

	@Override
	public SyllabusService getWrappedService() {
		return _syllabusService;
	}

	@Override
	public void setWrappedService(SyllabusService syllabusService) {
		_syllabusService = syllabusService;
	}

	private SyllabusService _syllabusService;
}