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
 * Provides the remote service utility for Syllabus. This utility wraps
 * {@link hu.unideb.inf.service.impl.SyllabusServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Adam Kiss
 * @see SyllabusService
 * @see hu.unideb.inf.service.base.SyllabusServiceBaseImpl
 * @see hu.unideb.inf.service.impl.SyllabusServiceImpl
 * @generated
 */
@ProviderType
public class SyllabusServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.unideb.inf.service.impl.SyllabusServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static hu.unideb.inf.model.Syllabus addSyllabus(
		long timetableCourseId, java.lang.String competence,
		java.lang.String ethicalStandards, java.lang.String topics,
		java.lang.String educationalMaterials,
		java.lang.String recommendedLiterature, java.lang.String weeklyTasks,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSyllabus(timetableCourseId, competence,
			ethicalStandards, topics, educationalMaterials,
			recommendedLiterature, weeklyTasks, serviceContext);
	}

	public static hu.unideb.inf.model.Syllabus deleteSyllabus(long syllabusId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSyllabus(syllabusId, serviceContext);
	}

	public static hu.unideb.inf.model.Syllabus getSyllabus(long syllabusId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSyllabus(syllabusId);
	}

	public static hu.unideb.inf.model.Syllabus updateStatus(long userId,
		long classPK, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		java.util.Map<java.lang.String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateStatus(userId, classPK, status, serviceContext,
			workflowContext);
	}

	public static hu.unideb.inf.model.Syllabus updateSyllabus(long userId,
		long syllabusId, long timetableCourseId, java.lang.String competence,
		java.lang.String ethicalStandards, java.lang.String topics,
		java.lang.String educationalMaterials,
		java.lang.String recommendedLiterature, java.lang.String weeklyTasks,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSyllabus(userId, syllabusId, timetableCourseId,
			competence, ethicalStandards, topics, educationalMaterials,
			recommendedLiterature, weeklyTasks, serviceContext);
	}

	public static int getSyllabusesCountByTimetableCourseId(
		long timetableCourseId) {
		return getService()
				   .getSyllabusesCountByTimetableCourseId(timetableCourseId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<hu.unideb.inf.model.Syllabus> getSyllabuses() {
		return getService().getSyllabuses();
	}

	public static java.util.List<hu.unideb.inf.model.Syllabus> getSyllabusesByTimetableCourseId(
		long timetableCourseId) {
		return getService().getSyllabusesByTimetableCourseId(timetableCourseId);
	}

	public static java.util.List<hu.unideb.inf.model.Syllabus> getSyllabusesByTimetableCourseId(
		long timetableCourseId, int start, int end) {
		return getService()
				   .getSyllabusesByTimetableCourseId(timetableCourseId, start,
			end);
	}

	public static SyllabusService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SyllabusService, SyllabusService> _serviceTracker =
		ServiceTrackerFactory.open(SyllabusService.class);
}