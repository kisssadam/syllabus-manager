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

import hu.unideb.inf.exception.NoSuchTimetableCourseException;
import hu.unideb.inf.model.Lecturer;
import hu.unideb.inf.model.TimetableCourse;

import java.util.List;

/**
 * Provides the remote service interface for TimetableCourse. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Adam Kiss
 * @see TimetableCourseServiceUtil
 * @see hu.unideb.inf.service.base.TimetableCourseServiceBaseImpl
 * @see hu.unideb.inf.service.impl.TimetableCourseServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=syllabus_manager", "json.web.service.context.path=TimetableCourse"}, service = TimetableCourseService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface TimetableCourseService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TimetableCourseServiceUtil} to access the timetable course remote service. Add custom service methods to {@link hu.unideb.inf.service.impl.TimetableCourseServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public TimetableCourse addTimetableCourse(long courseId, long semesterId,
		java.lang.String timetableCourseCode, java.lang.String subjectType,
		int recommendedTerm, int limit, long[] lecturerIds,
		java.lang.String classScheduleInfo, java.lang.String description,
		ServiceContext serviceContext) throws PortalException, SystemException;

	public TimetableCourse deleteTimetableCourse(long timetableCourseId,
		ServiceContext serviceContext) throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TimetableCourse fetchTimetableCourseByC_S_T_S(long courseId,
		long semesterId, java.lang.String timetableCourseCode,
		java.lang.String subjectType) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TimetableCourse getTimetableCourse(long timetableCourseId)
		throws PortalException;

	public TimetableCourse updateTimetableCourse(long userId,
		long timetableCourseId, long courseId, long semesterId,
		java.lang.String timetableCourseCode, java.lang.String subjectType,
		int recommendedTerm, int limit, long[] lecturerIds,
		java.lang.String classScheduleInfo, java.lang.String description,
		ServiceContext serviceContext) throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTimetableCourseCountByCourseId(long courseId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTimetableCoursesCountBySemesterId(long semesterId)
		throws SystemException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lecturer> getLecutersByTimetableCourseId(long timetableCourseId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TimetableCourse> getTimetableCourses()
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TimetableCourse> getTimetableCoursesByC_S(long courseId,
		long semesterId) throws SystemException, NoSuchTimetableCourseException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TimetableCourse> getTimetableCoursesByCourseId(long courseId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TimetableCourse> getTimetableCoursesByCourseId(long courseId,
		int start, int end) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TimetableCourse> getTimetableCoursesBySemesterId(
		long semesterId) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TimetableCourse> getTimetableCoursesBySemesterId(
		long semesterId, int start, int end) throws SystemException;
}