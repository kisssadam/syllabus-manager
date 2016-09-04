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
 * Provides a wrapper for {@link SubjectLocalService}.
 *
 * @author Adam Kiss
 * @see SubjectLocalService
 * @generated
 */
@ProviderType
public class SubjectLocalServiceWrapper implements SubjectLocalService,
	ServiceWrapper<SubjectLocalService> {
	public SubjectLocalServiceWrapper(SubjectLocalService subjectLocalService) {
		_subjectLocalService = subjectLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _subjectLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _subjectLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _subjectLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _subjectLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _subjectLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the subject to the database. Also notifies the appropriate model listeners.
	*
	* @param subject the subject
	* @return the subject that was added
	*/
	@Override
	public hu.unideb.inf.model.Subject addSubject(
		hu.unideb.inf.model.Subject subject) {
		return _subjectLocalService.addSubject(subject);
	}

	@Override
	public hu.unideb.inf.model.Subject addSubject(
		java.lang.String subjectCode, java.lang.String subjectName, int credit,
		long curriculumId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subjectLocalService.addSubject(subjectCode, subjectName,
			credit, curriculumId, serviceContext);
	}

	/**
	* Creates a new subject with the primary key. Does not add the subject to the database.
	*
	* @param subjectId the primary key for the new subject
	* @return the new subject
	*/
	@Override
	public hu.unideb.inf.model.Subject createSubject(long subjectId) {
		return _subjectLocalService.createSubject(subjectId);
	}

	/**
	* Deletes the subject from the database. Also notifies the appropriate model listeners.
	*
	* @param subject the subject
	* @return the subject that was removed
	*/
	@Override
	public hu.unideb.inf.model.Subject deleteSubject(
		hu.unideb.inf.model.Subject subject) {
		return _subjectLocalService.deleteSubject(subject);
	}

	/**
	* Deletes the subject with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subjectId the primary key of the subject
	* @return the subject that was removed
	* @throws PortalException if a subject with the primary key could not be found
	*/
	@Override
	public hu.unideb.inf.model.Subject deleteSubject(long subjectId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _subjectLocalService.deleteSubject(subjectId);
	}

	@Override
	public hu.unideb.inf.model.Subject deleteSubject(long subjectId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subjectLocalService.deleteSubject(subjectId, serviceContext);
	}

	@Override
	public hu.unideb.inf.model.Subject fetchSubject(long subjectId) {
		return _subjectLocalService.fetchSubject(subjectId);
	}

	@Override
	public hu.unideb.inf.model.Subject fetchSubjectByC_S(long curriculumId,
		java.lang.String subjectCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectLocalService.fetchSubjectByC_S(curriculumId, subjectCode);
	}

	/**
	* Returns the subject with the primary key.
	*
	* @param subjectId the primary key of the subject
	* @return the subject
	* @throws PortalException if a subject with the primary key could not be found
	*/
	@Override
	public hu.unideb.inf.model.Subject getSubject(long subjectId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _subjectLocalService.getSubject(subjectId);
	}

	@Override
	public hu.unideb.inf.model.Subject getSubjectByC_S(long curriculumId,
		java.lang.String subjectCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchSubjectException {
		return _subjectLocalService.getSubjectByC_S(curriculumId, subjectCode);
	}

	/**
	* Updates the subject in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param subject the subject
	* @return the subject that was updated
	*/
	@Override
	public hu.unideb.inf.model.Subject updateSubject(
		hu.unideb.inf.model.Subject subject) {
		return _subjectLocalService.updateSubject(subject);
	}

	@Override
	public hu.unideb.inf.model.Subject updateSubject(long userId,
		long subjectId, java.lang.String subjectCode,
		java.lang.String subjectName, int credit, long curriculumId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subjectLocalService.updateSubject(userId, subjectId,
			subjectCode, subjectName, credit, curriculumId, serviceContext);
	}

	/**
	* Returns the number of subjects.
	*
	* @return the number of subjects
	*/
	@Override
	public int getSubjectsCount() {
		return _subjectLocalService.getSubjectsCount();
	}

	@Override
	public int getSubjectsCountByCurriculumId(long curriculumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectLocalService.getSubjectsCountByCurriculumId(curriculumId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _subjectLocalService.getOSGiServiceIdentifier();
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
		return _subjectLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _subjectLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _subjectLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Subject> getSubjects()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectLocalService.getSubjects();
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
	@Override
	public java.util.List<hu.unideb.inf.model.Subject> getSubjects(int start,
		int end) {
		return _subjectLocalService.getSubjects(start, end);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Subject> getSubjectsByCurriculumId(
		long curriculumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectLocalService.getSubjectsByCurriculumId(curriculumId);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Subject> getSubjectsByCurriculumId(
		long curriculumId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectLocalService.getSubjectsByCurriculumId(curriculumId,
			start, end);
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
		return _subjectLocalService.dynamicQueryCount(dynamicQuery);
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
		return _subjectLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public SubjectLocalService getWrappedService() {
		return _subjectLocalService;
	}

	@Override
	public void setWrappedService(SubjectLocalService subjectLocalService) {
		_subjectLocalService = subjectLocalService;
	}

	private SubjectLocalService _subjectLocalService;
}