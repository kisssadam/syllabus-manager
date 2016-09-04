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
 * Provides the local service utility for Subject. This utility wraps
 * {@link hu.unideb.inf.service.impl.SubjectLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Adam Kiss
 * @see SubjectLocalService
 * @see hu.unideb.inf.service.base.SubjectLocalServiceBaseImpl
 * @see hu.unideb.inf.service.impl.SubjectLocalServiceImpl
 * @generated
 */
@ProviderType
public class SubjectLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.unideb.inf.service.impl.SubjectLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Adds the subject to the database. Also notifies the appropriate model listeners.
	*
	* @param subject the subject
	* @return the subject that was added
	*/
	public static hu.unideb.inf.model.Subject addSubject(
		hu.unideb.inf.model.Subject subject) {
		return getService().addSubject(subject);
	}

	public static hu.unideb.inf.model.Subject addSubject(
		java.lang.String subjectCode, java.lang.String subjectName, int credit,
		long curriculumId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSubject(subjectCode, subjectName, credit, curriculumId,
			serviceContext);
	}

	/**
	* Creates a new subject with the primary key. Does not add the subject to the database.
	*
	* @param subjectId the primary key for the new subject
	* @return the new subject
	*/
	public static hu.unideb.inf.model.Subject createSubject(long subjectId) {
		return getService().createSubject(subjectId);
	}

	/**
	* Deletes the subject from the database. Also notifies the appropriate model listeners.
	*
	* @param subject the subject
	* @return the subject that was removed
	*/
	public static hu.unideb.inf.model.Subject deleteSubject(
		hu.unideb.inf.model.Subject subject) {
		return getService().deleteSubject(subject);
	}

	/**
	* Deletes the subject with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subjectId the primary key of the subject
	* @return the subject that was removed
	* @throws PortalException if a subject with the primary key could not be found
	*/
	public static hu.unideb.inf.model.Subject deleteSubject(long subjectId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSubject(subjectId);
	}

	public static hu.unideb.inf.model.Subject deleteSubject(long subjectId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSubject(subjectId, serviceContext);
	}

	public static hu.unideb.inf.model.Subject fetchSubject(long subjectId) {
		return getService().fetchSubject(subjectId);
	}

	public static hu.unideb.inf.model.Subject fetchSubjectByC_S(
		long curriculumId, java.lang.String subjectCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSubjectByC_S(curriculumId, subjectCode);
	}

	/**
	* Returns the subject with the primary key.
	*
	* @param subjectId the primary key of the subject
	* @return the subject
	* @throws PortalException if a subject with the primary key could not be found
	*/
	public static hu.unideb.inf.model.Subject getSubject(long subjectId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSubject(subjectId);
	}

	public static hu.unideb.inf.model.Subject getSubjectByC_S(
		long curriculumId, java.lang.String subjectCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchSubjectException {
		return getService().getSubjectByC_S(curriculumId, subjectCode);
	}

	/**
	* Updates the subject in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param subject the subject
	* @return the subject that was updated
	*/
	public static hu.unideb.inf.model.Subject updateSubject(
		hu.unideb.inf.model.Subject subject) {
		return getService().updateSubject(subject);
	}

	public static hu.unideb.inf.model.Subject updateSubject(long userId,
		long subjectId, java.lang.String subjectCode,
		java.lang.String subjectName, int credit, long curriculumId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSubject(userId, subjectId, subjectCode, subjectName,
			credit, curriculumId, serviceContext);
	}

	/**
	* Returns the number of subjects.
	*
	* @return the number of subjects
	*/
	public static int getSubjectsCount() {
		return getService().getSubjectsCount();
	}

	public static int getSubjectsCountByCurriculumId(long curriculumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubjectsCountByCurriculumId(curriculumId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<hu.unideb.inf.model.Subject> getSubjects()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubjects();
	}

	/**
	* Returns a range of all the subjects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subjects
	* @param end the upper bound of the range of subjects (not inclusive)
	* @return the range of subjects
	*/
	public static java.util.List<hu.unideb.inf.model.Subject> getSubjects(
		int start, int end) {
		return getService().getSubjects(start, end);
	}

	public static java.util.List<hu.unideb.inf.model.Subject> getSubjectsByCurriculumId(
		long curriculumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubjectsByCurriculumId(curriculumId);
	}

	public static java.util.List<hu.unideb.inf.model.Subject> getSubjectsByCurriculumId(
		long curriculumId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubjectsByCurriculumId(curriculumId, start, end);
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

	public static SubjectLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SubjectLocalService, SubjectLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SubjectLocalService.class);
}