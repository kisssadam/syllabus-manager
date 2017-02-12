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
 * Provides a wrapper for {@link SubjectService}.
 *
 * @author Adam Kiss
 * @see SubjectService
 * @generated
 */
@ProviderType
public class SubjectServiceWrapper implements SubjectService,
	ServiceWrapper<SubjectService> {
	public SubjectServiceWrapper(SubjectService subjectService) {
		_subjectService = subjectService;
	}

	@Override
	public hu.unideb.inf.model.Subject addSubject(
		java.lang.String subjectCode, java.lang.String subjectName, int credit,
		long curriculumId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subjectService.addSubject(subjectCode, subjectName, credit,
			curriculumId, serviceContext);
	}

	@Override
	public hu.unideb.inf.model.Subject deleteSubject(long subjectId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subjectService.deleteSubject(subjectId, serviceContext);
	}

	@Override
	public hu.unideb.inf.model.Subject fetchSubjectByC_S(long curriculumId,
		java.lang.String subjectCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectService.fetchSubjectByC_S(curriculumId, subjectCode);
	}

	@Override
	public hu.unideb.inf.model.Subject getSubject(long subjectId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _subjectService.getSubject(subjectId);
	}

	@Override
	public hu.unideb.inf.model.Subject getSubjectByC_S(long curriculumId,
		java.lang.String subjectCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchSubjectException {
		return _subjectService.getSubjectByC_S(curriculumId, subjectCode);
	}

	@Override
	public hu.unideb.inf.model.Subject updateSubject(long userId,
		long subjectId, java.lang.String subjectCode,
		java.lang.String subjectName, int credit, long curriculumId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subjectService.updateSubject(userId, subjectId, subjectCode,
			subjectName, credit, curriculumId, serviceContext);
	}

	@Override
	public int getSubjectsCountByCurriculumId(long curriculumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectService.getSubjectsCountByCurriculumId(curriculumId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _subjectService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Subject> getSubjects()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectService.getSubjects();
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Subject> getSubjectsByCurriculumId(
		long curriculumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectService.getSubjectsByCurriculumId(curriculumId);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Subject> getSubjectsByCurriculumId(
		long curriculumId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectService.getSubjectsByCurriculumId(curriculumId, start,
			end);
	}

	@Override
	public SubjectService getWrappedService() {
		return _subjectService;
	}

	@Override
	public void setWrappedService(SubjectService subjectService) {
		_subjectService = subjectService;
	}

	private SubjectService _subjectService;
}