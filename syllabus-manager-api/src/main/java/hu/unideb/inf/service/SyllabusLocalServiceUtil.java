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

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
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

	public static hu.unideb.inf.model.Syllabus addSyllabus(
		long timetableCourseId, java.lang.String competence,
		java.lang.String ethicalStandards, java.lang.String topics,
		java.lang.String educationalMaterials,
		java.lang.String recommendedLiterature, java.lang.String weeklyTasks,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSyllabus(timetableCourseId, competence,
			ethicalStandards, topics, educationalMaterials,
			recommendedLiterature, weeklyTasks, serviceContext);
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

	public static hu.unideb.inf.model.Syllabus deleteSyllabus(long syllabusId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSyllabus(syllabusId, serviceContext);
	}

	public static hu.unideb.inf.model.Syllabus fetchSyllabus(long syllabusId) {
		return getService().fetchSyllabus(syllabusId);
	}

	/**
	* Returns the syllabus matching the UUID and group.
	*
	* @param uuid the syllabus's UUID
	* @param groupId the primary key of the group
	* @return the matching syllabus, or <code>null</code> if a matching syllabus could not be found
	*/
	public static hu.unideb.inf.model.Syllabus fetchSyllabusByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchSyllabusByUuidAndGroupId(uuid, groupId);
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

	/**
	* Returns the syllabus matching the UUID and group.
	*
	* @param uuid the syllabus's UUID
	* @param groupId the primary key of the group
	* @return the matching syllabus
	* @throws PortalException if a matching syllabus could not be found
	*/
	public static hu.unideb.inf.model.Syllabus getSyllabusByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSyllabusByUuidAndGroupId(uuid, groupId);
	}

	public static hu.unideb.inf.model.Syllabus updateStatus(long userId,
		long classPK, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		java.util.Map<java.lang.String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateStatus(userId, classPK, status, serviceContext,
			workflowContext);
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

	public static hu.unideb.inf.model.Syllabus updateSyllabus(long userId,
		long syllabusId, long timetableCourseId, java.lang.String competence,
		java.lang.String ethicalStandards, java.lang.String topics,
		java.lang.String educationalMaterials,
		java.lang.String recommendedLiterature, java.lang.String weeklyTasks,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSyllabus(userId, syllabusId, timetableCourseId,
			competence, ethicalStandards, topics, educationalMaterials,
			recommendedLiterature, weeklyTasks, serviceContext);
	}

	/**
	* Returns the number of syllabuses.
	*
	* @return the number of syllabuses
	*/
	public static int getSyllabusesCount() {
		return getService().getSyllabusesCount();
	}

	public static int getSyllabusesCountByTimetableCourseId(
		long timetableCourseId) {
		return getService()
				   .getSyllabusesCountByTimetableCourseId(timetableCourseId);
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

	public static java.util.List<hu.unideb.inf.model.Syllabus> getSyllabusesByTimetableCourseId(
		long timetableCourseId) {
		return getService().getSyllabusesByTimetableCourseId(timetableCourseId);
	}

	public static java.util.List<hu.unideb.inf.model.Syllabus> getSyllabusesByTimetableCourseId(
		long timetableCourseId, int start, int end) {
		return getService()
				   .getSyllabusesByTimetableCourseId(timetableCourseId, start,
			end);
	}

	/**
	* Returns all the syllabuses matching the UUID and company.
	*
	* @param uuid the UUID of the syllabuses
	* @param companyId the primary key of the company
	* @return the matching syllabuses, or an empty list if no matches were found
	*/
	public static java.util.List<hu.unideb.inf.model.Syllabus> getSyllabusesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getSyllabusesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of syllabuses matching the UUID and company.
	*
	* @param uuid the UUID of the syllabuses
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of syllabuses
	* @param end the upper bound of the range of syllabuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching syllabuses, or an empty list if no matches were found
	*/
	public static java.util.List<hu.unideb.inf.model.Syllabus> getSyllabusesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<hu.unideb.inf.model.Syllabus> orderByComparator) {
		return getService()
				   .getSyllabusesByUuidAndCompanyId(uuid, companyId, start,
			end, orderByComparator);
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