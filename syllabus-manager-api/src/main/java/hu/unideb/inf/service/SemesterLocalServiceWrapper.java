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
 * Provides a wrapper for {@link SemesterLocalService}.
 *
 * @author Adam Kiss
 * @see SemesterLocalService
 * @generated
 */
@ProviderType
public class SemesterLocalServiceWrapper implements SemesterLocalService,
	ServiceWrapper<SemesterLocalService> {
	public SemesterLocalServiceWrapper(
		SemesterLocalService semesterLocalService) {
		_semesterLocalService = semesterLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _semesterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _semesterLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _semesterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _semesterLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _semesterLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public hu.unideb.inf.model.Semester addCurrentSemester(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _semesterLocalService.addCurrentSemester(serviceContext);
	}

	@Override
	public hu.unideb.inf.model.Semester addNextSemester(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _semesterLocalService.addNextSemester(serviceContext);
	}

	/**
	* Adds the semester to the database. Also notifies the appropriate model listeners.
	*
	* @param semester the semester
	* @return the semester that was added
	*/
	@Override
	public hu.unideb.inf.model.Semester addSemester(
		hu.unideb.inf.model.Semester semester) {
		return _semesterLocalService.addSemester(semester);
	}

	@Override
	public hu.unideb.inf.model.Semester addSemester(int beginYear, int endYear,
		int division,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _semesterLocalService.addSemester(beginYear, endYear, division,
			serviceContext);
	}

	/**
	* Creates a new semester with the primary key. Does not add the semester to the database.
	*
	* @param semesterId the primary key for the new semester
	* @return the new semester
	*/
	@Override
	public hu.unideb.inf.model.Semester createSemester(long semesterId) {
		return _semesterLocalService.createSemester(semesterId);
	}

	/**
	* Deletes the semester from the database. Also notifies the appropriate model listeners.
	*
	* @param semester the semester
	* @return the semester that was removed
	*/
	@Override
	public hu.unideb.inf.model.Semester deleteSemester(
		hu.unideb.inf.model.Semester semester) {
		return _semesterLocalService.deleteSemester(semester);
	}

	/**
	* Deletes the semester with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param semesterId the primary key of the semester
	* @return the semester that was removed
	* @throws PortalException if a semester with the primary key could not be found
	*/
	@Override
	public hu.unideb.inf.model.Semester deleteSemester(long semesterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _semesterLocalService.deleteSemester(semesterId);
	}

	@Override
	public hu.unideb.inf.model.Semester deleteSemester(long semesterId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _semesterLocalService.deleteSemester(semesterId, serviceContext);
	}

	@Override
	public hu.unideb.inf.model.Semester fetchSemester(long semesterId) {
		return _semesterLocalService.fetchSemester(semesterId);
	}

	@Override
	public hu.unideb.inf.model.Semester getLatestSemester()
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchSemesterException {
		return _semesterLocalService.getLatestSemester();
	}

	/**
	* Returns the semester with the primary key.
	*
	* @param semesterId the primary key of the semester
	* @return the semester
	* @throws PortalException if a semester with the primary key could not be found
	*/
	@Override
	public hu.unideb.inf.model.Semester getSemester(long semesterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _semesterLocalService.getSemester(semesterId);
	}

	@Override
	public hu.unideb.inf.model.Semester getSemesterByB_E_D(int beginYear,
		int endYear, int division)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchSemesterException {
		return _semesterLocalService.getSemesterByB_E_D(beginYear, endYear,
			division);
	}

	/**
	* Updates the semester in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param semester the semester
	* @return the semester that was updated
	*/
	@Override
	public hu.unideb.inf.model.Semester updateSemester(
		hu.unideb.inf.model.Semester semester) {
		return _semesterLocalService.updateSemester(semester);
	}

	@Override
	public hu.unideb.inf.model.Semester updateSemester(long userId,
		long semesterId, int beginYear, int endYear, int division,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _semesterLocalService.updateSemester(userId, semesterId,
			beginYear, endYear, division, serviceContext);
	}

	/**
	* Returns the number of semesters.
	*
	* @return the number of semesters
	*/
	@Override
	public int getSemestersCount() {
		return _semesterLocalService.getSemestersCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _semesterLocalService.getOSGiServiceIdentifier();
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
		return _semesterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SemesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _semesterLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SemesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _semesterLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Semester> getSemesters()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _semesterLocalService.getSemesters();
	}

	/**
	* Returns a range of all the semesters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SemesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of semesters
	* @param end the upper bound of the range of semesters (not inclusive)
	* @return the range of semesters
	*/
	@Override
	public java.util.List<hu.unideb.inf.model.Semester> getSemesters(
		int start, int end) {
		return _semesterLocalService.getSemesters(start, end);
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
		return _semesterLocalService.dynamicQueryCount(dynamicQuery);
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
		return _semesterLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public SemesterLocalService getWrappedService() {
		return _semesterLocalService;
	}

	@Override
	public void setWrappedService(SemesterLocalService semesterLocalService) {
		_semesterLocalService = semesterLocalService;
	}

	private SemesterLocalService _semesterLocalService;
}