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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import hu.unideb.inf.model.Syllabus;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the remote service interface for Syllabus. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Adam Kiss
 * @see SyllabusServiceUtil
 * @see hu.unideb.inf.service.base.SyllabusServiceBaseImpl
 * @see hu.unideb.inf.service.impl.SyllabusServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=syllabus_manager", "json.web.service.context.path=Syllabus"}, service = SyllabusService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SyllabusService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SyllabusServiceUtil} to access the syllabus remote service. Add custom service methods to {@link hu.unideb.inf.service.impl.SyllabusServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public Syllabus addSyllabus(long timetableCourseId,
		java.lang.String competence, java.lang.String ethicalStandards,
		java.lang.String topics, java.lang.String educationalMaterials,
		java.lang.String recommendedLiterature, java.lang.String weeklyTasks,
		ServiceContext serviceContext) throws PortalException, SystemException;

	public Syllabus deleteSyllabus(long syllabusId,
		ServiceContext serviceContext) throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Syllabus getSyllabus(long syllabusId) throws PortalException;

	public Syllabus updateStatus(long userId, long classPK, int status,
		ServiceContext serviceContext,
		Map<java.lang.String, Serializable> workflowContext)
		throws PortalException;

	public Syllabus updateSyllabus(long userId, long syllabusId,
		long timetableCourseId, java.lang.String competence,
		java.lang.String ethicalStandards, java.lang.String topics,
		java.lang.String educationalMaterials,
		java.lang.String recommendedLiterature, java.lang.String weeklyTasks,
		ServiceContext serviceContext) throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSyllabusesCountByTimetableCourseId(long timetableCourseId);

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Syllabus> getSyllabuses();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Syllabus> getSyllabusesByTimetableCourseId(
		long timetableCourseId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Syllabus> getSyllabusesByTimetableCourseId(
		long timetableCourseId, int start, int end);
}