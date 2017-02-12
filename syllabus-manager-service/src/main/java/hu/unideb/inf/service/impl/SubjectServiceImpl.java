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
import hu.unideb.inf.exception.NoSuchSubjectException;
import hu.unideb.inf.model.Subject;
import hu.unideb.inf.service.base.SubjectServiceBaseImpl;
import hu.unideb.inf.service.permission.ModelPermission;
import hu.unideb.inf.service.permission.SubjectPermission;
import hu.unideb.inf.util.SyllabusActionKeys;

/**
 * The implementation of the subject remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the {@link hu.unideb.inf.service.SubjectService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Adam Kiss
 * @see SubjectServiceBaseImpl
 * @see hu.unideb.inf.service.SubjectServiceUtil
 */
@ProviderType
public class SubjectServiceImpl extends SubjectServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link hu.unideb.inf.service.SubjectServiceUtil} to access the
	 * subject remote service.
	 */

	public Subject getSubject(long subjectId) throws PortalException {
		SubjectPermission.check(getPermissionChecker(), subjectId, SyllabusActionKeys.VIEW);

		return subjectLocalService.getSubject(subjectId);
	}

	public List<Subject> getSubjects() throws SystemException {
		return subjectLocalService.getSubjects();
	}

	public Subject getSubjectByC_S(long curriculumId, String subjectCode)
			throws SystemException, NoSuchSubjectException {
		return subjectLocalService.getSubjectByC_S(curriculumId, subjectCode);
	}

	public Subject fetchSubjectByC_S(long curriculumId, String subjectCode) throws SystemException {
		return subjectLocalService.fetchSubjectByC_S(curriculumId, subjectCode);
	}

	public List<Subject> getSubjectsByCurriculumId(long curriculumId) throws SystemException {
		return subjectLocalService.getSubjectsByCurriculumId(curriculumId);
	}

	public List<Subject> getSubjectsByCurriculumId(long curriculumId, int start, int end) throws SystemException {
		return subjectLocalService.getSubjectsByCurriculumId(curriculumId, start, end);
	}

	public int getSubjectsCountByCurriculumId(long curriculumId) throws SystemException {
		return subjectLocalService.getSubjectsCountByCurriculumId(curriculumId);
	}

	public Subject addSubject(String subjectCode, String subjectName, int credit, long curriculumId,
			ServiceContext serviceContext) throws SystemException, PortalException {
		ModelPermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(), SyllabusActionKeys.ADD_SUBJECT);

		return subjectLocalService.addSubject(subjectCode, subjectName, credit, curriculumId, serviceContext);
	}

	public Subject deleteSubject(long subjectId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		SubjectPermission.check(getPermissionChecker(), subjectId, SyllabusActionKeys.DELETE);

		return subjectLocalService.deleteSubject(subjectId, serviceContext);
	}

	public Subject updateSubject(long userId, long subjectId, String subjectCode, String subjectName, int credit,
			long curriculumId, ServiceContext serviceContext) throws SystemException, PortalException {
		SubjectPermission.check(getPermissionChecker(), subjectId, SyllabusActionKeys.UPDATE);

		return subjectLocalService.updateSubject(userId, subjectId, subjectCode, subjectName, credit, curriculumId,
				serviceContext);
	}

}