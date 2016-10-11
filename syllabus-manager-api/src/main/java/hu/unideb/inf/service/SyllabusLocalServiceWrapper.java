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
 * Provides a wrapper for {@link SyllabusLocalService}.
 *
 * @author Adam Kiss
 * @see SyllabusLocalService
 * @generated
 */
@ProviderType
public class SyllabusLocalServiceWrapper implements SyllabusLocalService,
	ServiceWrapper<SyllabusLocalService> {
	public SyllabusLocalServiceWrapper(
		SyllabusLocalService syllabusLocalService) {
		_syllabusLocalService = syllabusLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _syllabusLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _syllabusLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _syllabusLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _syllabusLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _syllabusLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the syllabus to the database. Also notifies the appropriate model listeners.
	*
	* @param syllabus the syllabus
	* @return the syllabus that was added
	*/
	@Override
	public hu.unideb.inf.model.Syllabus addSyllabus(
		hu.unideb.inf.model.Syllabus syllabus) {
		return _syllabusLocalService.addSyllabus(syllabus);
	}

	/**
	* Creates a new syllabus with the primary key. Does not add the syllabus to the database.
	*
	* @param syllabusId the primary key for the new syllabus
	* @return the new syllabus
	*/
	@Override
	public hu.unideb.inf.model.Syllabus createSyllabus(long syllabusId) {
		return _syllabusLocalService.createSyllabus(syllabusId);
	}

	/**
	* Deletes the syllabus from the database. Also notifies the appropriate model listeners.
	*
	* @param syllabus the syllabus
	* @return the syllabus that was removed
	*/
	@Override
	public hu.unideb.inf.model.Syllabus deleteSyllabus(
		hu.unideb.inf.model.Syllabus syllabus) {
		return _syllabusLocalService.deleteSyllabus(syllabus);
	}

	/**
	* Deletes the syllabus with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param syllabusId the primary key of the syllabus
	* @return the syllabus that was removed
	* @throws PortalException if a syllabus with the primary key could not be found
	*/
	@Override
	public hu.unideb.inf.model.Syllabus deleteSyllabus(long syllabusId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _syllabusLocalService.deleteSyllabus(syllabusId);
	}

	@Override
	public hu.unideb.inf.model.Syllabus fetchSyllabus(long syllabusId) {
		return _syllabusLocalService.fetchSyllabus(syllabusId);
	}

	@Override
	public hu.unideb.inf.model.Syllabus fetchSyllabusByT_S(
		long timetableCourseId, long semesterId) {
		return _syllabusLocalService.fetchSyllabusByT_S(timetableCourseId,
			semesterId);
	}

	/**
	* Returns the syllabus with the primary key.
	*
	* @param syllabusId the primary key of the syllabus
	* @return the syllabus
	* @throws PortalException if a syllabus with the primary key could not be found
	*/
	@Override
	public hu.unideb.inf.model.Syllabus getSyllabus(long syllabusId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _syllabusLocalService.getSyllabus(syllabusId);
	}

	@Override
	public hu.unideb.inf.model.Syllabus getSyllabusByT_S(
		long timetableCourseId, long semesterId)
		throws hu.unideb.inf.exception.NoSuchSyllabusException {
		return _syllabusLocalService.getSyllabusByT_S(timetableCourseId,
			semesterId);
	}

	/**
	* Updates the syllabus in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param syllabus the syllabus
	* @return the syllabus that was updated
	*/
	@Override
	public hu.unideb.inf.model.Syllabus updateSyllabus(
		hu.unideb.inf.model.Syllabus syllabus) {
		return _syllabusLocalService.updateSyllabus(syllabus);
	}

	/**
	* Returns the number of syllabuses.
	*
	* @return the number of syllabuses
	*/
	@Override
	public int getSyllabusesCount() {
		return _syllabusLocalService.getSyllabusesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _syllabusLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _syllabusLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _syllabusLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _syllabusLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Syllabus> getSyllabuses()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _syllabusLocalService.getSyllabuses();
	}

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
	@Override
	public java.util.List<hu.unideb.inf.model.Syllabus> getSyllabuses(
		int start, int end) {
		return _syllabusLocalService.getSyllabuses(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _syllabusLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _syllabusLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public SyllabusLocalService getWrappedService() {
		return _syllabusLocalService;
	}

	@Override
	public void setWrappedService(SyllabusLocalService syllabusLocalService) {
		_syllabusLocalService = syllabusLocalService;
	}

	private SyllabusLocalService _syllabusLocalService;
}