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
 * Provides a wrapper for {@link CurriculumLocalService}.
 *
 * @author Adam Kiss
 * @see CurriculumLocalService
 * @generated
 */
@ProviderType
public class CurriculumLocalServiceWrapper implements CurriculumLocalService,
	ServiceWrapper<CurriculumLocalService> {
	public CurriculumLocalServiceWrapper(
		CurriculumLocalService curriculumLocalService) {
		_curriculumLocalService = curriculumLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _curriculumLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _curriculumLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _curriculumLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _curriculumLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _curriculumLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the curriculum to the database. Also notifies the appropriate model listeners.
	*
	* @param curriculum the curriculum
	* @return the curriculum that was added
	*/
	@Override
	public hu.unideb.inf.model.Curriculum addCurriculum(
		hu.unideb.inf.model.Curriculum curriculum) {
		return _curriculumLocalService.addCurriculum(curriculum);
	}

	@Override
	public hu.unideb.inf.model.Curriculum addCurriculum(
		java.lang.String curriculumCode, java.lang.String curriculumName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _curriculumLocalService.addCurriculum(curriculumCode,
			curriculumName, serviceContext);
	}

	/**
	* Creates a new curriculum with the primary key. Does not add the curriculum to the database.
	*
	* @param curriculumId the primary key for the new curriculum
	* @return the new curriculum
	*/
	@Override
	public hu.unideb.inf.model.Curriculum createCurriculum(long curriculumId) {
		return _curriculumLocalService.createCurriculum(curriculumId);
	}

	/**
	* Deletes the curriculum from the database. Also notifies the appropriate model listeners.
	*
	* @param curriculum the curriculum
	* @return the curriculum that was removed
	*/
	@Override
	public hu.unideb.inf.model.Curriculum deleteCurriculum(
		hu.unideb.inf.model.Curriculum curriculum) {
		return _curriculumLocalService.deleteCurriculum(curriculum);
	}

	/**
	* Deletes the curriculum with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param curriculumId the primary key of the curriculum
	* @return the curriculum that was removed
	* @throws PortalException if a curriculum with the primary key could not be found
	*/
	@Override
	public hu.unideb.inf.model.Curriculum deleteCurriculum(long curriculumId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _curriculumLocalService.deleteCurriculum(curriculumId);
	}

	@Override
	public hu.unideb.inf.model.Curriculum deleteCurriculum(long curriculumId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _curriculumLocalService.deleteCurriculum(curriculumId,
			serviceContext);
	}

	@Override
	public hu.unideb.inf.model.Curriculum fetchCurriculum(long curriculumId) {
		return _curriculumLocalService.fetchCurriculum(curriculumId);
	}

	@Override
	public hu.unideb.inf.model.Curriculum fetchCurriculumByCode(
		java.lang.String curriculumCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _curriculumLocalService.fetchCurriculumByCode(curriculumCode);
	}

	/**
	* Returns the curriculum with the primary key.
	*
	* @param curriculumId the primary key of the curriculum
	* @return the curriculum
	* @throws PortalException if a curriculum with the primary key could not be found
	*/
	@Override
	public hu.unideb.inf.model.Curriculum getCurriculum(long curriculumId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _curriculumLocalService.getCurriculum(curriculumId);
	}

	@Override
	public hu.unideb.inf.model.Curriculum getCurriculumByCode(
		java.lang.String curriculumCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchCurriculumException {
		return _curriculumLocalService.getCurriculumByCode(curriculumCode);
	}

	/**
	* Updates the curriculum in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param curriculum the curriculum
	* @return the curriculum that was updated
	*/
	@Override
	public hu.unideb.inf.model.Curriculum updateCurriculum(
		hu.unideb.inf.model.Curriculum curriculum) {
		return _curriculumLocalService.updateCurriculum(curriculum);
	}

	@Override
	public hu.unideb.inf.model.Curriculum updateCurriculum(long userId,
		long curriculumId, java.lang.String curriculumCode,
		java.lang.String curriculumName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _curriculumLocalService.updateCurriculum(userId, curriculumId,
			curriculumCode, curriculumName, serviceContext);
	}

	/**
	* Returns the number of curriculums.
	*
	* @return the number of curriculums
	*/
	@Override
	public int getCurriculumsCount() {
		return _curriculumLocalService.getCurriculumsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _curriculumLocalService.getOSGiServiceIdentifier();
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
		return _curriculumLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.CurriculumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _curriculumLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.CurriculumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _curriculumLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Curriculum> getCurriculums()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _curriculumLocalService.getCurriculums();
	}

	/**
	* Returns a range of all the curriculums.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.CurriculumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of curriculums
	* @param end the upper bound of the range of curriculums (not inclusive)
	* @return the range of curriculums
	*/
	@Override
	public java.util.List<hu.unideb.inf.model.Curriculum> getCurriculums(
		int start, int end) {
		return _curriculumLocalService.getCurriculums(start, end);
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
		return _curriculumLocalService.dynamicQueryCount(dynamicQuery);
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
		return _curriculumLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public CurriculumLocalService getWrappedService() {
		return _curriculumLocalService;
	}

	@Override
	public void setWrappedService(CurriculumLocalService curriculumLocalService) {
		_curriculumLocalService = curriculumLocalService;
	}

	private CurriculumLocalService _curriculumLocalService;
}