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
import hu.unideb.inf.exception.NoSuchCurriculumException;
import hu.unideb.inf.model.Curriculum;
import hu.unideb.inf.service.base.CurriculumServiceBaseImpl;
import hu.unideb.inf.service.permission.CurriculumPermission;
import hu.unideb.inf.service.permission.ModelPermission;
import hu.unideb.inf.util.SyllabusActionKeys;

/**
 * The implementation of the curriculum remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the {@link hu.unideb.inf.service.CurriculumService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Adam Kiss
 * @see CurriculumServiceBaseImpl
 * @see hu.unideb.inf.service.CurriculumServiceUtil
 */
@ProviderType
public class CurriculumServiceImpl extends CurriculumServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link hu.unideb.inf.service.CurriculumServiceUtil} to access the
	 * curriculum remote service.
	 */

	public Curriculum getCurriculum(long curriculumId) throws PortalException {
		CurriculumPermission.check(getPermissionChecker(), curriculumId, SyllabusActionKeys.VIEW);

		return curriculumLocalService.getCurriculum(curriculumId);
	}

	public List<Curriculum> getCurriculums() throws SystemException {
		return curriculumLocalService.getCurriculums();
	}

	public Curriculum getCurriculumByCode(String curriculumCode) throws SystemException, NoSuchCurriculumException {
		return curriculumLocalService.getCurriculumByCode(curriculumCode);
	}

	public Curriculum fetchCurriculumByCode(String curriculumCode) throws SystemException {
		return curriculumLocalService.fetchCurriculumByCode(curriculumCode);
	}

	public Curriculum addCurriculum(String curriculumCode, String curriculumName, ServiceContext serviceContext)
			throws PortalException, SystemException {
		ModelPermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(),
				SyllabusActionKeys.ADD_CURRICULUM);

		return curriculumLocalService.addCurriculum(curriculumCode, curriculumName, serviceContext);
	}

	public Curriculum deleteCurriculum(long curriculumId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		CurriculumPermission.check(getPermissionChecker(), curriculumId, SyllabusActionKeys.DELETE);

		return curriculumLocalService.deleteCurriculum(curriculumId, serviceContext);
	}

	public Curriculum updateCurriculum(long userId, long curriculumId, String curriculumCode, String curriculumName,
			ServiceContext serviceContext) throws SystemException, PortalException {
		CurriculumPermission.check(getPermissionChecker(), curriculumId, SyllabusActionKeys.UPDATE);

		return curriculumLocalService.updateCurriculum(userId, curriculumId, curriculumCode, curriculumName,
				serviceContext);
	}

}