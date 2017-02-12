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
import hu.unideb.inf.exception.NoSuchSemesterException;
import hu.unideb.inf.model.Semester;
import hu.unideb.inf.service.base.SemesterServiceBaseImpl;
import hu.unideb.inf.service.permission.ModelPermission;
import hu.unideb.inf.service.permission.SemesterPermission;
import hu.unideb.inf.util.SyllabusActionKeys;

/**
 * The implementation of the semester remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the {@link hu.unideb.inf.service.SemesterService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Adam Kiss
 * @see SemesterServiceBaseImpl
 * @see hu.unideb.inf.service.SemesterServiceUtil
 */
@ProviderType
public class SemesterServiceImpl extends SemesterServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link hu.unideb.inf.service.SemesterServiceUtil} to access the
	 * semester remote service.
	 */

	public Semester getSemester(long semesterId) throws PortalException {
		SemesterPermission.check(getPermissionChecker(), semesterId, SyllabusActionKeys.VIEW);

		return semesterLocalService.getSemester(semesterId);
	}

	public List<Semester> getSemesters() throws SystemException {
		return semesterLocalService.getSemesters();
	}

	public Semester getSemesterByB_E_D(int beginYear, int endYear, int division)
			throws NoSuchSemesterException, SystemException {
		return semesterLocalService.getSemesterByB_E_D(beginYear, endYear, division);
	}

	public Semester getLatestSemester() throws SystemException, NoSuchSemesterException {
		return semesterLocalService.getLatestSemester();
	}

	public Semester addNextSemester(ServiceContext serviceContext) throws SystemException, PortalException {
		ModelPermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(),
				SyllabusActionKeys.ADD_SEMESTER);

		return semesterLocalService.addNextSemester(serviceContext);
	}

	public Semester addCurrentSemester(ServiceContext serviceContext) throws SystemException, PortalException {
		ModelPermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(),
				SyllabusActionKeys.ADD_SEMESTER);

		return semesterLocalService.addCurrentSemester(serviceContext);
	}

	public Semester addSemester(int beginYear, int endYear, int division, ServiceContext serviceContext)
			throws SystemException, PortalException {
		ModelPermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(),
				SyllabusActionKeys.ADD_SEMESTER);

		return semesterLocalService.addSemester(beginYear, endYear, division, serviceContext);
	}

	public Semester deleteSemester(long semesterId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		SemesterPermission.check(getPermissionChecker(), semesterId, SyllabusActionKeys.DELETE);

		return semesterLocalService.deleteSemester(semesterId, serviceContext);
	}

	public Semester updateSemester(long userId, long semesterId, int beginYear, int endYear, int division,
			ServiceContext serviceContext) throws PortalException, SystemException {
		SemesterPermission.check(getPermissionChecker(), semesterId, SyllabusActionKeys.UPDATE);

		return semesterLocalService.updateSemester(userId, semesterId, beginYear, endYear, division, serviceContext);
	}

}