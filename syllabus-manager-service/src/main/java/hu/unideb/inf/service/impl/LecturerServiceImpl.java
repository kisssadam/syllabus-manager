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
import hu.unideb.inf.exception.NoSuchLecturerException;
import hu.unideb.inf.model.Lecturer;
import hu.unideb.inf.service.base.LecturerServiceBaseImpl;
import hu.unideb.inf.service.permission.LecturerPermission;
import hu.unideb.inf.service.permission.ModelPermission;
import hu.unideb.inf.util.SyllabusActionKeys;

/**
 * The implementation of the lecturer remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the {@link hu.unideb.inf.service.LecturerService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Adam Kiss
 * @see LecturerServiceBaseImpl
 * @see hu.unideb.inf.service.LecturerServiceUtil
 */
@ProviderType
public class LecturerServiceImpl extends LecturerServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link hu.unideb.inf.service.LecturerServiceUtil} to access the
	 * lecturer remote service.
	 */

	public Lecturer getLecturer(long lecturerId) throws PortalException {
		LecturerPermission.check(getPermissionChecker(), lecturerId, SyllabusActionKeys.VIEW);

		return lecturerLocalService.getLecturer(lecturerId);
	}

	public List<Lecturer> getLecturers() throws SystemException {
		return lecturerLocalService.getLecturers();
	}

	public List<Lecturer> getLecturersByIds(long[] lecturerIds) throws NoSuchLecturerException, SystemException {
		return lecturerLocalService.getLecturersByIds(lecturerIds);
	}

	public Lecturer getLecturerByName(String lecturerName) throws NoSuchLecturerException, SystemException {
		return lecturerLocalService.getLecturerByName(lecturerName);
	}

	public Lecturer fetchLecturerByName(String lecturerName) throws SystemException {
		return lecturerLocalService.fetchLecturerByName(lecturerName);
	}

	public Lecturer addLecturer(String lecturerName, long lecturerUserId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		ModelPermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(),
				SyllabusActionKeys.ADD_LECTURER);

		return lecturerLocalService.addLecturer(lecturerName, lecturerUserId, serviceContext);
	}

	public Lecturer deleteLecturer(long lecturerId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		LecturerPermission.check(getPermissionChecker(), lecturerId, SyllabusActionKeys.DELETE);

		return lecturerLocalService.deleteLecturer(lecturerId, serviceContext);
	}

	public Lecturer updateLecturer(long userId, long lecturerId, String lecturerName, long lecturerUserId,
			ServiceContext serviceContext) throws PortalException, SystemException {
		LecturerPermission.check(getPermissionChecker(), lecturerId, SyllabusActionKeys.UPDATE);

		return lecturerLocalService.updateLecturer(userId, lecturerId, lecturerName, lecturerUserId, serviceContext);
	}

}