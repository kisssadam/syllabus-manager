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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import hu.unideb.inf.exception.NoSuchTimetableCourseException;
import hu.unideb.inf.model.Lecturer;
import hu.unideb.inf.model.TimetableCourse;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for TimetableCourse. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Adam Kiss
 * @see TimetableCourseLocalServiceUtil
 * @see hu.unideb.inf.service.base.TimetableCourseLocalServiceBaseImpl
 * @see hu.unideb.inf.service.impl.TimetableCourseLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface TimetableCourseLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TimetableCourseLocalServiceUtil} to access the timetable course local service. Add custom service methods to {@link hu.unideb.inf.service.impl.TimetableCourseLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasLecturerTimetableCourse(long lecturerId,
		long timetableCourseId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasLecturerTimetableCourses(long lecturerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Adds the timetable course to the database. Also notifies the appropriate model listeners.
	*
	* @param timetableCourse the timetable course
	* @return the timetable course that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public TimetableCourse addTimetableCourse(TimetableCourse timetableCourse);

	public TimetableCourse addTimetableCourse(long courseId, long semesterId,
		java.lang.String timetableCourseCode, java.lang.String subjectType,
		int recommendedTerm, int limit, long[] lecturerIds,
		java.lang.String classScheduleInfo, java.lang.String description,
		ServiceContext serviceContext) throws PortalException, SystemException;

	/**
	* Creates a new timetable course with the primary key. Does not add the timetable course to the database.
	*
	* @param timetableCourseId the primary key for the new timetable course
	* @return the new timetable course
	*/
	public TimetableCourse createTimetableCourse(long timetableCourseId);

	/**
	* Deletes the timetable course from the database. Also notifies the appropriate model listeners.
	*
	* @param timetableCourse the timetable course
	* @return the timetable course that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public TimetableCourse deleteTimetableCourse(
		TimetableCourse timetableCourse);

	/**
	* Deletes the timetable course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course that was removed
	* @throws PortalException if a timetable course with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public TimetableCourse deleteTimetableCourse(long timetableCourseId)
		throws PortalException;

	public TimetableCourse deleteTimetableCourse(long timetableCourseId,
		ServiceContext serviceContext) throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TimetableCourse fetchTimetableCourse(long timetableCourseId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TimetableCourse fetchTimetableCourseByC_S_T_S(long courseId,
		long semesterId, java.lang.String timetableCourseCode,
		java.lang.String subjectType) throws SystemException;

	/**
	* Returns the timetable course with the primary key.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course
	* @throws PortalException if a timetable course with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TimetableCourse getTimetableCourse(long timetableCourseId)
		throws PortalException;

	/**
	* Updates the timetable course in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param timetableCourse the timetable course
	* @return the timetable course that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public TimetableCourse updateTimetableCourse(
		TimetableCourse timetableCourse);

	public TimetableCourse updateTimetableCourse(long userId,
		long timetableCourseId, long courseId, long semesterId,
		java.lang.String timetableCourseCode, java.lang.String subjectType,
		int recommendedTerm, int limit, long[] lecturerIds,
		java.lang.String classScheduleInfo, java.lang.String description,
		ServiceContext serviceContext) throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLecturerTimetableCoursesCount(long lecturerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTimetableCourseCountByCourseId(long courseId)
		throws SystemException;

	/**
	* Returns the number of timetable courses.
	*
	* @return the number of timetable courses
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTimetableCoursesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTimetableCoursesCountBySemesterId(long semesterId)
		throws SystemException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TimetableCourse> getLecturerTimetableCourses(long lecturerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TimetableCourse> getLecturerTimetableCourses(long lecturerId,
		int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TimetableCourse> getLecturerTimetableCourses(long lecturerId,
		int start, int end, OrderByComparator<TimetableCourse> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lecturer> getLecutersByTimetableCourseId(long timetableCourseId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TimetableCourse> getTimetableCourses()
		throws SystemException;

	/**
	* Returns a range of all the timetable courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @return the range of timetable courses
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TimetableCourse> getTimetableCourses(int start, int end);

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

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	/**
	* Returns the lecturerIds of the lecturers associated with the timetable course.
	*
	* @param timetableCourseId the timetableCourseId of the timetable course
	* @return long[] the lecturerIds of lecturers associated with the timetable course
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getLecturerPrimaryKeys(long timetableCourseId);

	public void addLecturerTimetableCourse(long lecturerId,
		TimetableCourse timetableCourse);

	public void addLecturerTimetableCourse(long lecturerId,
		long timetableCourseId);

	public void addLecturerTimetableCourses(long lecturerId,
		List<TimetableCourse> timetableCourses);

	public void addLecturerTimetableCourses(long lecturerId,
		long[] timetableCourseIds);

	public void clearLecturerTimetableCourses(long lecturerId);

	public void deleteLecturerTimetableCourse(long lecturerId,
		TimetableCourse timetableCourse);

	public void deleteLecturerTimetableCourse(long lecturerId,
		long timetableCourseId);

	public void deleteLecturerTimetableCourses(long lecturerId,
		List<TimetableCourse> timetableCourses);

	public void deleteLecturerTimetableCourses(long lecturerId,
		long[] timetableCourseIds);

	public void setLecturerTimetableCourses(long lecturerId,
		long[] timetableCourseIds);
}