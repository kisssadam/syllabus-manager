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

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;

import aQute.bnd.annotation.ProviderType;
import hu.unideb.inf.model.Syllabus;
import hu.unideb.inf.service.base.SyllabusServiceBaseImpl;
import hu.unideb.inf.service.permission.ModelPermission;
import hu.unideb.inf.service.permission.SyllabusPermission;
import hu.unideb.inf.util.SyllabusActionKeys;

/**
 * The implementation of the syllabus remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the {@link hu.unideb.inf.service.SyllabusService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Adam Kiss
 * @see SyllabusServiceBaseImpl
 * @see hu.unideb.inf.service.SyllabusServiceUtil
 */
@ProviderType
public class SyllabusServiceImpl extends SyllabusServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link hu.unideb.inf.service.SyllabusServiceUtil} to access the
	 * syllabus remote service.
	 */

	public List<Syllabus> getSyllabuses() {
		return syllabusLocalService.getSyllabuses();
	}

	public List<Syllabus> getSyllabusesByTimetableCourseId(long timetableCourseId) {
		return syllabusLocalService.getSyllabusesByTimetableCourseId(timetableCourseId);
	}

	public List<Syllabus> getSyllabusesByTimetableCourseId(long timetableCourseId, int start, int end) {
		return syllabusLocalService.getSyllabusesByTimetableCourseId(timetableCourseId, start, end);
	}

	public int getSyllabusesCountByTimetableCourseId(long timetableCourseId) {
		return syllabusLocalService.getSyllabusesCountByTimetableCourseId(timetableCourseId);
	}

	public Syllabus getSyllabus(long syllabusId) throws PortalException {
		SyllabusPermission.check(getPermissionChecker(), syllabusId, SyllabusActionKeys.VIEW);

		return syllabusLocalService.getSyllabus(syllabusId);
	}

	public Syllabus addSyllabus(long timetableCourseId, String competence, String ethicalStandards, String topics,
			String educationalMaterials, String recommendedLiterature, String weeklyTasks,
			ServiceContext serviceContext) throws PortalException, SystemException {
		ModelPermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(),
				SyllabusActionKeys.ADD_SYLLABUS);

		return syllabusLocalService.addSyllabus(timetableCourseId, competence, ethicalStandards, topics,
				educationalMaterials, recommendedLiterature, weeklyTasks, serviceContext);
	}

	public Syllabus updateSyllabus(long userId, long syllabusId, long timetableCourseId, String competence,
			String ethicalStandards, String topics, String educationalMaterials, String recommendedLiterature,
			String weeklyTasks, ServiceContext serviceContext) throws PortalException, SystemException {
		SyllabusPermission.check(getPermissionChecker(), syllabusId, SyllabusActionKeys.UPDATE);

		return syllabusLocalService.updateSyllabus(userId, syllabusId, timetableCourseId, competence, ethicalStandards,
				topics, educationalMaterials, recommendedLiterature, weeklyTasks, serviceContext);
	}

	public Syllabus deleteSyllabus(long syllabusId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		SyllabusPermission.check(getPermissionChecker(), syllabusId, SyllabusActionKeys.DELETE);

		return syllabusLocalService.deleteSyllabus(syllabusId, serviceContext);
	}

	public Syllabus updateStatus(long userId, long classPK, int status, ServiceContext serviceContext,
			Map<String, Serializable> workflowContext) throws PortalException {
		SyllabusPermission.check(getPermissionChecker(), classPK, SyllabusActionKeys.UPDATE);

		return syllabusLocalService.updateStatus(userId, classPK, status, serviceContext, workflowContext);
	}

}