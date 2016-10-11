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
 * Provides the local service utility for Syllabus. This utility wraps
 * {@link hu.unideb.inf.service.impl.SyllabusLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Adam Kiss
 * @see SyllabusLocalService
 * @see hu.unideb.inf.service.base.SyllabusLocalServiceBaseImpl
 * @see hu.unideb.inf.service.impl.SyllabusLocalServiceImpl
 * @generated
 */
@ProviderType
public class SyllabusLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.unideb.inf.service.impl.SyllabusLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	/**
	* Adds the syllabus to the database. Also notifies the appropriate model listeners.
	*
	* @param syllabus the syllabus
	* @return the syllabus that was added
	*/
	public static hu.unideb.inf.model.Syllabus addSyllabus(
		hu.unideb.inf.model.Syllabus syllabus) {
		return getService().addSyllabus(syllabus);
	}

	/**
	* Creates a new syllabus with the primary key. Does not add the syllabus to the database.
	*
	* @param syllabusId the primary key for the new syllabus
	* @return the new syllabus
	*/
	public static hu.unideb.inf.model.Syllabus createSyllabus(long syllabusId) {
		return getService().createSyllabus(syllabusId);
	}

	/**
	* Deletes the syllabus from the database. Also notifies the appropriate model listeners.
	*
	* @param syllabus the syllabus
	* @return the syllabus that was removed
	*/
	public static hu.unideb.inf.model.Syllabus deleteSyllabus(
		hu.unideb.inf.model.Syllabus syllabus) {
		return getService().deleteSyllabus(syllabus);
	}

	/**
	* Deletes the syllabus with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param syllabusId the primary key of the syllabus
	* @return the syllabus that was removed
	* @throws PortalException if a syllabus with the primary key could not be found
	*/
	public static hu.unideb.inf.model.Syllabus deleteSyllabus(long syllabusId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSyllabus(syllabusId);
	}

	public static hu.unideb.inf.model.Syllabus fetchSyllabus(long syllabusId) {
		return getService().fetchSyllabus(syllabusId);
	}

	public static hu.unideb.inf.model.Syllabus fetchSyllabusByT_S(
		long timetableCourseId, long semesterId) {
		return getService().fetchSyllabusByT_S(timetableCourseId, semesterId);
	}

	/**
	* Returns the syllabus with the primary key.
	*
	* @param syllabusId the primary key of the syllabus
	* @return the syllabus
	* @throws PortalException if a syllabus with the primary key could not be found
	*/
	public static hu.unideb.inf.model.Syllabus getSyllabus(long syllabusId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSyllabus(syllabusId);
	}

	public static hu.unideb.inf.model.Syllabus getSyllabusByT_S(
		long timetableCourseId, long semesterId)
		throws hu.unideb.inf.exception.NoSuchSyllabusException {
		return getService().getSyllabusByT_S(timetableCourseId, semesterId);
	}

	/**
	* Updates the syllabus in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param syllabus the syllabus
	* @return the syllabus that was updated
	*/
	public static hu.unideb.inf.model.Syllabus updateSyllabus(
		hu.unideb.inf.model.Syllabus syllabus) {
		return getService().updateSyllabus(syllabus);
	}

	/**
	* Returns the number of syllabuses.
	*
	* @return the number of syllabuses
	*/
	public static int getSyllabusesCount() {
		return getService().getSyllabusesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<hu.unideb.inf.model.Syllabus> getSyllabuses()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSyllabuses();
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
	public static java.util.List<hu.unideb.inf.model.Syllabus> getSyllabuses(
		int start, int end) {
		return getService().getSyllabuses(start, end);
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

	public static SyllabusLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SyllabusLocalService, SyllabusLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SyllabusLocalService.class);
}