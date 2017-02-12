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

import hu.unideb.inf.exception.NoSuchSemesterException;
import hu.unideb.inf.model.Semester;

import java.util.List;

/**
 * Provides the remote service interface for Semester. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Adam Kiss
 * @see SemesterServiceUtil
 * @see hu.unideb.inf.service.base.SemesterServiceBaseImpl
 * @see hu.unideb.inf.service.impl.SemesterServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=syllabus_manager", "json.web.service.context.path=Semester"}, service = SemesterService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SemesterService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SemesterServiceUtil} to access the semester remote service. Add custom service methods to {@link hu.unideb.inf.service.impl.SemesterServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public Semester addCurrentSemester(ServiceContext serviceContext)
		throws PortalException, SystemException;

	public Semester addNextSemester(ServiceContext serviceContext)
		throws PortalException, SystemException;

	public Semester addSemester(int beginYear, int endYear, int division,
		ServiceContext serviceContext) throws PortalException, SystemException;

	public Semester deleteSemester(long semesterId,
		ServiceContext serviceContext) throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Semester getLatestSemester()
		throws SystemException, NoSuchSemesterException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Semester getSemester(long semesterId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Semester getSemesterByB_E_D(int beginYear, int endYear, int division)
		throws SystemException, NoSuchSemesterException;

	public Semester updateSemester(long userId, long semesterId, int beginYear,
		int endYear, int division, ServiceContext serviceContext)
		throws PortalException, SystemException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Semester> getSemesters() throws SystemException;
}