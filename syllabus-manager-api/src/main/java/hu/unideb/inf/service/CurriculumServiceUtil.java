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
 * Provides the remote service utility for Curriculum. This utility wraps
 * {@link hu.unideb.inf.service.impl.CurriculumServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Adam Kiss
 * @see CurriculumService
 * @see hu.unideb.inf.service.base.CurriculumServiceBaseImpl
 * @see hu.unideb.inf.service.impl.CurriculumServiceImpl
 * @generated
 */
@ProviderType
public class CurriculumServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.unideb.inf.service.impl.CurriculumServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static hu.unideb.inf.model.Curriculum addCurriculum(
		java.lang.String curriculumCode, java.lang.String curriculumName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCurriculum(curriculumCode, curriculumName, serviceContext);
	}

	public static hu.unideb.inf.model.Curriculum deleteCurriculum(
		long curriculumId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCurriculum(curriculumId, serviceContext);
	}

	public static hu.unideb.inf.model.Curriculum fetchCurriculumByCode(
		java.lang.String curriculumCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCurriculumByCode(curriculumCode);
	}

	public static hu.unideb.inf.model.Curriculum getCurriculum(
		long curriculumId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCurriculum(curriculumId);
	}

	public static hu.unideb.inf.model.Curriculum getCurriculumByCode(
		java.lang.String curriculumCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchCurriculumException {
		return getService().getCurriculumByCode(curriculumCode);
	}

	public static hu.unideb.inf.model.Curriculum updateCurriculum(long userId,
		long curriculumId, java.lang.String curriculumCode,
		java.lang.String curriculumName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCurriculum(userId, curriculumId, curriculumCode,
			curriculumName, serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<hu.unideb.inf.model.Curriculum> getCurriculums()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCurriculums();
	}

	public static CurriculumService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CurriculumService, CurriculumService> _serviceTracker =
		ServiceTrackerFactory.open(CurriculumService.class);
}