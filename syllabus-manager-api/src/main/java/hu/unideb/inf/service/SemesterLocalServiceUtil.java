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
 * Provides the local service utility for Semester. This utility wraps
 * {@link hu.unideb.inf.service.impl.SemesterLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Adam Kiss
 * @see SemesterLocalService
 * @see hu.unideb.inf.service.base.SemesterLocalServiceBaseImpl
 * @see hu.unideb.inf.service.impl.SemesterLocalServiceImpl
 * @generated
 */
@ProviderType
public class SemesterLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.unideb.inf.service.impl.SemesterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static hu.unideb.inf.model.Semester addCurrentSemester(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addCurrentSemester(serviceContext);
	}

	public static hu.unideb.inf.model.Semester addNextSemester(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addNextSemester(serviceContext);
	}

	/**
	* Adds the semester to the database. Also notifies the appropriate model listeners.
	*
	* @param semester the semester
	* @return the semester that was added
	*/
	public static hu.unideb.inf.model.Semester addSemester(
		hu.unideb.inf.model.Semester semester) {
		return getService().addSemester(semester);
	}

	public static hu.unideb.inf.model.Semester addSemester(int beginYear,
		int endYear, int division,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSemester(beginYear, endYear, division, serviceContext);
	}

	/**
	* Creates a new semester with the primary key. Does not add the semester to the database.
	*
	* @param semesterId the primary key for the new semester
	* @return the new semester
	*/
	public static hu.unideb.inf.model.Semester createSemester(long semesterId) {
		return getService().createSemester(semesterId);
	}

	/**
	* Deletes the semester from the database. Also notifies the appropriate model listeners.
	*
	* @param semester the semester
	* @return the semester that was removed
	*/
	public static hu.unideb.inf.model.Semester deleteSemester(
		hu.unideb.inf.model.Semester semester) {
		return getService().deleteSemester(semester);
	}

	/**
	* Deletes the semester with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param semesterId the primary key of the semester
	* @return the semester that was removed
	* @throws PortalException if a semester with the primary key could not be found
	*/
	public static hu.unideb.inf.model.Semester deleteSemester(long semesterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSemester(semesterId);
	}

	public static hu.unideb.inf.model.Semester deleteSemester(long semesterId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSemester(semesterId, serviceContext);
	}

	public static hu.unideb.inf.model.Semester fetchSemester(long semesterId) {
		return getService().fetchSemester(semesterId);
	}

	public static hu.unideb.inf.model.Semester fetchSemesterByB_E_D(
		int beginYear, int endYear, int division) {
		return getService().fetchSemesterByB_E_D(beginYear, endYear, division);
	}

	public static hu.unideb.inf.model.Semester getLatestSemester()
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchSemesterException {
		return getService().getLatestSemester();
	}

	/**
	* Returns the semester with the primary key.
	*
	* @param semesterId the primary key of the semester
	* @return the semester
	* @throws PortalException if a semester with the primary key could not be found
	*/
	public static hu.unideb.inf.model.Semester getSemester(long semesterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSemester(semesterId);
	}

	public static hu.unideb.inf.model.Semester getSemesterByB_E_D(
		int beginYear, int endYear, int division)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchSemesterException {
		return getService().getSemesterByB_E_D(beginYear, endYear, division);
	}

	/**
	* Updates the semester in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param semester the semester
	* @return the semester that was updated
	*/
	public static hu.unideb.inf.model.Semester updateSemester(
		hu.unideb.inf.model.Semester semester) {
		return getService().updateSemester(semester);
	}

	public static hu.unideb.inf.model.Semester updateSemester(long userId,
		long semesterId, int beginYear, int endYear, int division,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSemester(userId, semesterId, beginYear, endYear,
			division, serviceContext);
	}

	/**
	* Returns the number of semesters.
	*
	* @return the number of semesters
	*/
	public static int getSemestersCount() {
		return getService().getSemestersCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<hu.unideb.inf.model.Semester> getSemesters()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSemesters();
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
	public static java.util.List<hu.unideb.inf.model.Semester> getSemesters(
		int start, int end) {
		return getService().getSemesters(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static SemesterLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SemesterLocalService, SemesterLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SemesterLocalService.class);
}