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

import hu.unideb.inf.model.Syllabus;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service interface for Syllabus. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Adam Kiss
 * @see SyllabusLocalServiceUtil
 * @see hu.unideb.inf.service.base.SyllabusLocalServiceBaseImpl
 * @see hu.unideb.inf.service.impl.SyllabusLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SyllabusLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SyllabusLocalServiceUtil} to access the syllabus local service. Add custom service methods to {@link hu.unideb.inf.service.impl.SyllabusLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
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
	* Adds the syllabus to the database. Also notifies the appropriate model listeners.
	*
	* @param syllabus the syllabus
	* @return the syllabus that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Syllabus addSyllabus(Syllabus syllabus);

	public Syllabus addSyllabus(long timetableCourseId,
		java.lang.String competence, java.lang.String ethicalStandards,
		java.lang.String topics, java.lang.String educationalMaterials,
		java.lang.String recommendedLiterature, java.lang.String weeklyTasks,
		ServiceContext serviceContext) throws PortalException, SystemException;

	/**
	* Creates a new syllabus with the primary key. Does not add the syllabus to the database.
	*
	* @param syllabusId the primary key for the new syllabus
	* @return the new syllabus
	*/
	public Syllabus createSyllabus(long syllabusId);

	/**
	* Deletes the syllabus from the database. Also notifies the appropriate model listeners.
	*
	* @param syllabus the syllabus
	* @return the syllabus that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Syllabus deleteSyllabus(Syllabus syllabus);

	/**
	* Deletes the syllabus with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param syllabusId the primary key of the syllabus
	* @return the syllabus that was removed
	* @throws PortalException if a syllabus with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Syllabus deleteSyllabus(long syllabusId) throws PortalException;

	public Syllabus deleteSyllabus(long syllabusId,
		ServiceContext serviceContext) throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Syllabus fetchSyllabus(long syllabusId);

	/**
	* Returns the syllabus with the primary key.
	*
	* @param syllabusId the primary key of the syllabus
	* @return the syllabus
	* @throws PortalException if a syllabus with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Syllabus getSyllabus(long syllabusId) throws PortalException;

	public Syllabus updateStatus(long userId, long classPK, int status,
		ServiceContext serviceContext,
		Map<java.lang.String, Serializable> workflowContext)
		throws PortalException;

	/**
	* Updates the syllabus in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param syllabus the syllabus
	* @return the syllabus that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Syllabus updateSyllabus(Syllabus syllabus);

	public Syllabus updateSyllabus(long userId, long syllabusId,
		long timetableCourseId, java.lang.String competence,
		java.lang.String ethicalStandards, java.lang.String topics,
		java.lang.String educationalMaterials,
		java.lang.String recommendedLiterature, java.lang.String weeklyTasks,
		ServiceContext serviceContext) throws PortalException, SystemException;

	/**
	* Returns the number of syllabuses.
	*
	* @return the number of syllabuses
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSyllabusesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSyllabusesCountByTimetableCourseId(long timetableCourseId);

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List<Syllabus> getSyllabuses() throws SystemException;

	/**
	* Returns a range of all the syllabuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of syllabuses
	* @param end the upper bound of the range of syllabuses (not inclusive)
	* @return the range of syllabuses
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Syllabus> getSyllabuses(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Syllabus> getSyllabusesByTimetableCourseId(
		long timetableCourseId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Syllabus> getSyllabusesByTimetableCourseId(
		long timetableCourseId, int start, int end);

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
}