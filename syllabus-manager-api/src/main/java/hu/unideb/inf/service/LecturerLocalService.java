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

import hu.unideb.inf.exception.NoSuchLecturerException;
import hu.unideb.inf.model.Lecturer;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for Lecturer. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Adam Kiss
 * @see LecturerLocalServiceUtil
 * @see hu.unideb.inf.service.base.LecturerLocalServiceBaseImpl
 * @see hu.unideb.inf.service.impl.LecturerLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LecturerLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LecturerLocalServiceUtil} to access the lecturer local service. Add custom service methods to {@link hu.unideb.inf.service.impl.LecturerLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasTimetableCourseLecturer(long timetableCourseId,
		long lecturerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasTimetableCourseLecturers(long timetableCourseId);

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
	* Adds the lecturer to the database. Also notifies the appropriate model listeners.
	*
	* @param lecturer the lecturer
	* @return the lecturer that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Lecturer addLecturer(Lecturer lecturer);

	public Lecturer addLecturer(java.lang.String lecturerName,
		long lecturerUserId, ServiceContext serviceContext)
		throws PortalException, SystemException;

	/**
	* Creates a new lecturer with the primary key. Does not add the lecturer to the database.
	*
	* @param lecturerId the primary key for the new lecturer
	* @return the new lecturer
	*/
	public Lecturer createLecturer(long lecturerId);

	/**
	* Deletes the lecturer from the database. Also notifies the appropriate model listeners.
	*
	* @param lecturer the lecturer
	* @return the lecturer that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Lecturer deleteLecturer(Lecturer lecturer);

	/**
	* Deletes the lecturer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer that was removed
	* @throws PortalException if a lecturer with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Lecturer deleteLecturer(long lecturerId) throws PortalException;

	public Lecturer deleteLecturer(long lecturerId,
		ServiceContext serviceContext) throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Lecturer fetchLecturer(long lecturerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Lecturer fetchLecturerByN_U(java.lang.String lecturerName,
		long lecturerUserId);

	/**
	* Returns the lecturer with the primary key.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer
	* @throws PortalException if a lecturer with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Lecturer getLecturer(long lecturerId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Lecturer getLecturerByN_U(java.lang.String lecturerName,
		long lecturerUserId) throws NoSuchLecturerException;

	/**
	* Updates the lecturer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lecturer the lecturer
	* @return the lecturer that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Lecturer updateLecturer(Lecturer lecturer);

	public Lecturer updateLecturer(long userId, long lecturerId,
		java.lang.String lecturerName, long lecturerUserId,
		ServiceContext serviceContext) throws PortalException, SystemException;

	/**
	* Returns the number of lecturers.
	*
	* @return the number of lecturers
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLecturersCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTimetableCourseLecturersCount(long timetableCourseId);

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List<Lecturer> getLecturers() throws SystemException;

	/**
	* Returns a range of all the lecturers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lecturers
	* @param end the upper bound of the range of lecturers (not inclusive)
	* @return the range of lecturers
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lecturer> getLecturers(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lecturer> getLecturersByIds(long[] lecturerIds)
		throws SystemException, NoSuchLecturerException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lecturer> getTimetableCourseLecturers(long timetableCourseId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lecturer> getTimetableCourseLecturers(long timetableCourseId,
		int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Lecturer> getTimetableCourseLecturers(long timetableCourseId,
		int start, int end, OrderByComparator<Lecturer> orderByComparator);

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
	* Returns the timetableCourseIds of the timetable courses associated with the lecturer.
	*
	* @param lecturerId the lecturerId of the lecturer
	* @return long[] the timetableCourseIds of timetable courses associated with the lecturer
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getTimetableCoursePrimaryKeys(long lecturerId);

	public void addTimetableCourseLecturer(long timetableCourseId,
		Lecturer lecturer);

	public void addTimetableCourseLecturer(long timetableCourseId,
		long lecturerId);

	public void addTimetableCourseLecturers(long timetableCourseId,
		List<Lecturer> lecturers);

	public void addTimetableCourseLecturers(long timetableCourseId,
		long[] lecturerIds);

	public void clearTimetableCourseLecturers(long timetableCourseId);

	public void deleteTimetableCourseLecturer(long timetableCourseId,
		Lecturer lecturer);

	public void deleteTimetableCourseLecturer(long timetableCourseId,
		long lecturerId);

	public void deleteTimetableCourseLecturers(long timetableCourseId,
		List<Lecturer> lecturers);

	public void deleteTimetableCourseLecturers(long timetableCourseId,
		long[] lecturerIds);

	public void setTimetableCourseLecturers(long timetableCourseId,
		long[] lecturerIds);
}