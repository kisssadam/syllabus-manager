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
 * Provides the remote service utility for Subject. This utility wraps
 * {@link hu.unideb.inf.service.impl.SubjectServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Adam Kiss
 * @see SubjectService
 * @see hu.unideb.inf.service.base.SubjectServiceBaseImpl
 * @see hu.unideb.inf.service.impl.SubjectServiceImpl
 * @generated
 */
@ProviderType
public class SubjectServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.unideb.inf.service.impl.SubjectServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static hu.unideb.inf.model.Subject addSubject(
		java.lang.String subjectCode, java.lang.String subjectName, int credit,
		long curriculumId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSubject(subjectCode, subjectName, credit, curriculumId,
			serviceContext);
	}

	public static hu.unideb.inf.model.Subject deleteSubject(long subjectId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSubject(subjectId, serviceContext);
	}

	public static hu.unideb.inf.model.Subject fetchSubjectByC_S(
		long curriculumId, java.lang.String subjectCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSubjectByC_S(curriculumId, subjectCode);
	}

	public static hu.unideb.inf.model.Subject getSubject(long subjectId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSubject(subjectId);
	}

	public static hu.unideb.inf.model.Subject getSubjectByC_S(
		long curriculumId, java.lang.String subjectCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchSubjectException {
		return getService().getSubjectByC_S(curriculumId, subjectCode);
	}

	public static hu.unideb.inf.model.Subject updateSubject(long userId,
		long subjectId, java.lang.String subjectCode,
		java.lang.String subjectName, int credit, long curriculumId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSubject(userId, subjectId, subjectCode, subjectName,
			credit, curriculumId, serviceContext);
	}

	public static int getSubjectsCountByCurriculumId(long curriculumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubjectsCountByCurriculumId(curriculumId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<hu.unideb.inf.model.Subject> getSubjects()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubjects();
	}

	public static java.util.List<hu.unideb.inf.model.Subject> getSubjectsByCurriculumId(
		long curriculumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubjectsByCurriculumId(curriculumId);
	}

	public static java.util.List<hu.unideb.inf.model.Subject> getSubjectsByCurriculumId(
		long curriculumId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubjectsByCurriculumId(curriculumId, start, end);
	}

	public static SubjectService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SubjectService, SubjectService> _serviceTracker =
		ServiceTrackerFactory.open(SubjectService.class);
}