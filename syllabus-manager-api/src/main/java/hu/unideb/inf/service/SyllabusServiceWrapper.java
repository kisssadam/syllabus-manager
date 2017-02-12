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

	@Override
	public hu.unideb.inf.model.Syllabus addSyllabus(long timetableCourseId,
		java.lang.String competence, java.lang.String ethicalStandards,
		java.lang.String topics, java.lang.String educationalMaterials,
		java.lang.String recommendedLiterature, java.lang.String weeklyTasks,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _syllabusService.addSyllabus(timetableCourseId, competence,
			ethicalStandards, topics, educationalMaterials,
			recommendedLiterature, weeklyTasks, serviceContext);
	}

	@Override
	public hu.unideb.inf.model.Syllabus deleteSyllabus(long syllabusId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _syllabusService.deleteSyllabus(syllabusId, serviceContext);
	}

	@Override
	public hu.unideb.inf.model.Syllabus getSyllabus(long syllabusId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _syllabusService.getSyllabus(syllabusId);
	}

	@Override
	public hu.unideb.inf.model.Syllabus updateStatus(long userId, long classPK,
		int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		java.util.Map<java.lang.String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _syllabusService.updateStatus(userId, classPK, status,
			serviceContext, workflowContext);
	}

	@Override
	public hu.unideb.inf.model.Syllabus updateSyllabus(long userId,
		long syllabusId, long timetableCourseId, java.lang.String competence,
		java.lang.String ethicalStandards, java.lang.String topics,
		java.lang.String educationalMaterials,
		java.lang.String recommendedLiterature, java.lang.String weeklyTasks,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _syllabusService.updateSyllabus(userId, syllabusId,
			timetableCourseId, competence, ethicalStandards, topics,
			educationalMaterials, recommendedLiterature, weeklyTasks,
			serviceContext);
	}

	@Override
	public int getSyllabusesCountByTimetableCourseId(long timetableCourseId) {
		return _syllabusService.getSyllabusesCountByTimetableCourseId(timetableCourseId);
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
	public java.util.List<hu.unideb.inf.model.Syllabus> getSyllabuses() {
		return _syllabusService.getSyllabuses();
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Syllabus> getSyllabusesByTimetableCourseId(
		long timetableCourseId) {
		return _syllabusService.getSyllabusesByTimetableCourseId(timetableCourseId);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Syllabus> getSyllabusesByTimetableCourseId(
		long timetableCourseId, int start, int end) {
		return _syllabusService.getSyllabusesByTimetableCourseId(timetableCourseId,
			start, end);
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