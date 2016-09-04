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
 * Provides a wrapper for {@link TimetableCourseLocalService}.
 *
 * @author Adam Kiss
 * @see TimetableCourseLocalService
 * @generated
 */
@ProviderType
public class TimetableCourseLocalServiceWrapper
	implements TimetableCourseLocalService,
		ServiceWrapper<TimetableCourseLocalService> {
	public TimetableCourseLocalServiceWrapper(
		TimetableCourseLocalService timetableCourseLocalService) {
		_timetableCourseLocalService = timetableCourseLocalService;
	}

	@Override
	public boolean hasLecturerTimetableCourse(long lecturerId,
		long timetableCourseId) {
		return _timetableCourseLocalService.hasLecturerTimetableCourse(lecturerId,
			timetableCourseId);
	}

	@Override
	public boolean hasLecturerTimetableCourses(long lecturerId) {
		return _timetableCourseLocalService.hasLecturerTimetableCourses(lecturerId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _timetableCourseLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _timetableCourseLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _timetableCourseLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timetableCourseLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timetableCourseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the timetable course to the database. Also notifies the appropriate model listeners.
	*
	* @param timetableCourse the timetable course
	* @return the timetable course that was added
	*/
	@Override
	public hu.unideb.inf.model.TimetableCourse addTimetableCourse(
		hu.unideb.inf.model.TimetableCourse timetableCourse) {
		return _timetableCourseLocalService.addTimetableCourse(timetableCourse);
	}

	@Override
	public hu.unideb.inf.model.TimetableCourse addTimetableCourse(
		long courseId, long semesterId, java.lang.String timetableCourseCode,
		java.lang.String subjectType, int recommendedTerm, int limit,
		long[] lecturerIds, java.lang.String classScheduleInfo,
		java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.addTimetableCourse(courseId,
			semesterId, timetableCourseCode, subjectType, recommendedTerm,
			limit, lecturerIds, classScheduleInfo, description, serviceContext);
	}

	/**
	* Creates a new timetable course with the primary key. Does not add the timetable course to the database.
	*
	* @param timetableCourseId the primary key for the new timetable course
	* @return the new timetable course
	*/
	@Override
	public hu.unideb.inf.model.TimetableCourse createTimetableCourse(
		long timetableCourseId) {
		return _timetableCourseLocalService.createTimetableCourse(timetableCourseId);
	}

	/**
	* Deletes the timetable course from the database. Also notifies the appropriate model listeners.
	*
	* @param timetableCourse the timetable course
	* @return the timetable course that was removed
	*/
	@Override
	public hu.unideb.inf.model.TimetableCourse deleteTimetableCourse(
		hu.unideb.inf.model.TimetableCourse timetableCourse) {
		return _timetableCourseLocalService.deleteTimetableCourse(timetableCourse);
	}

	/**
	* Deletes the timetable course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course that was removed
	* @throws PortalException if a timetable course with the primary key could not be found
	*/
	@Override
	public hu.unideb.inf.model.TimetableCourse deleteTimetableCourse(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timetableCourseLocalService.deleteTimetableCourse(timetableCourseId);
	}

	@Override
	public hu.unideb.inf.model.TimetableCourse deleteTimetableCourse(
		long timetableCourseId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.deleteTimetableCourse(timetableCourseId,
			serviceContext);
	}

	@Override
	public hu.unideb.inf.model.TimetableCourse fetchTimetableCourse(
		long timetableCourseId) {
		return _timetableCourseLocalService.fetchTimetableCourse(timetableCourseId);
	}

	@Override
	public hu.unideb.inf.model.TimetableCourse fetchTimetableCourseByC_S_T_S(
		long courseId, long semesterId, java.lang.String timetableCourseCode,
		java.lang.String subjectType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.fetchTimetableCourseByC_S_T_S(courseId,
			semesterId, timetableCourseCode, subjectType);
	}

	/**
	* Returns the timetable course with the primary key.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course
	* @throws PortalException if a timetable course with the primary key could not be found
	*/
	@Override
	public hu.unideb.inf.model.TimetableCourse getTimetableCourse(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timetableCourseLocalService.getTimetableCourse(timetableCourseId);
	}

	/**
	* Updates the timetable course in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param timetableCourse the timetable course
	* @return the timetable course that was updated
	*/
	@Override
	public hu.unideb.inf.model.TimetableCourse updateTimetableCourse(
		hu.unideb.inf.model.TimetableCourse timetableCourse) {
		return _timetableCourseLocalService.updateTimetableCourse(timetableCourse);
	}

	@Override
	public hu.unideb.inf.model.TimetableCourse updateTimetableCourse(
		long userId, long timetableCourseId, long courseId, long semesterId,
		java.lang.String timetableCourseCode, java.lang.String subjectType,
		int recommendedTerm, int limit, long[] lecturerIds,
		java.lang.String classScheduleInfo, java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.updateTimetableCourse(userId,
			timetableCourseId, courseId, semesterId, timetableCourseCode,
			subjectType, recommendedTerm, limit, lecturerIds,
			classScheduleInfo, description, serviceContext);
	}

	@Override
	public int getLecturerTimetableCoursesCount(long lecturerId) {
		return _timetableCourseLocalService.getLecturerTimetableCoursesCount(lecturerId);
	}

	@Override
	public int getTimetableCourseCountByCourseId(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getTimetableCourseCountByCourseId(courseId);
	}

	/**
	* Returns the number of timetable courses.
	*
	* @return the number of timetable courses
	*/
	@Override
	public int getTimetableCoursesCount() {
		return _timetableCourseLocalService.getTimetableCoursesCount();
	}

	@Override
	public int getTimetableCoursesCountBySemesterId(long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getTimetableCoursesCountBySemesterId(semesterId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _timetableCourseLocalService.getOSGiServiceIdentifier();
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
		return _timetableCourseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _timetableCourseLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _timetableCourseLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getLecturerTimetableCourses(
		long lecturerId) {
		return _timetableCourseLocalService.getLecturerTimetableCourses(lecturerId);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getLecturerTimetableCourses(
		long lecturerId, int start, int end) {
		return _timetableCourseLocalService.getLecturerTimetableCourses(lecturerId,
			start, end);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getLecturerTimetableCourses(
		long lecturerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<hu.unideb.inf.model.TimetableCourse> orderByComparator) {
		return _timetableCourseLocalService.getLecturerTimetableCourses(lecturerId,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.Lecturer> getLecutersByTimetableCourseId(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getLecutersByTimetableCourseId(timetableCourseId);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getTimetableCourses();
	}

	/**
	* Returns a range of all the timetable courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @return the range of timetable courses
	*/
	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		int start, int end) {
		return _timetableCourseLocalService.getTimetableCourses(start, end);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesByC_S(
		long courseId, long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchTimetableCourseException {
		return _timetableCourseLocalService.getTimetableCoursesByC_S(courseId,
			semesterId);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesByCourseId(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getTimetableCoursesByCourseId(courseId);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesByCourseId(
		long courseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getTimetableCoursesByCourseId(courseId,
			start, end);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesBySemesterId(
		long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getTimetableCoursesBySemesterId(semesterId);
	}

	@Override
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesBySemesterId(
		long semesterId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourseLocalService.getTimetableCoursesBySemesterId(semesterId,
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
		return _timetableCourseLocalService.dynamicQueryCount(dynamicQuery);
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
		return _timetableCourseLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Returns the lecturerIds of the lecturers associated with the timetable course.
	*
	* @param timetableCourseId the timetableCourseId of the timetable course
	* @return long[] the lecturerIds of lecturers associated with the timetable course
	*/
	@Override
	public long[] getLecturerPrimaryKeys(long timetableCourseId) {
		return _timetableCourseLocalService.getLecturerPrimaryKeys(timetableCourseId);
	}

	@Override
	public void addLecturerTimetableCourse(long lecturerId,
		hu.unideb.inf.model.TimetableCourse timetableCourse) {
		_timetableCourseLocalService.addLecturerTimetableCourse(lecturerId,
			timetableCourse);
	}

	@Override
	public void addLecturerTimetableCourse(long lecturerId,
		long timetableCourseId) {
		_timetableCourseLocalService.addLecturerTimetableCourse(lecturerId,
			timetableCourseId);
	}

	@Override
	public void addLecturerTimetableCourses(long lecturerId,
		java.util.List<hu.unideb.inf.model.TimetableCourse> timetableCourses) {
		_timetableCourseLocalService.addLecturerTimetableCourses(lecturerId,
			timetableCourses);
	}

	@Override
	public void addLecturerTimetableCourses(long lecturerId,
		long[] timetableCourseIds) {
		_timetableCourseLocalService.addLecturerTimetableCourses(lecturerId,
			timetableCourseIds);
	}

	@Override
	public void clearLecturerTimetableCourses(long lecturerId) {
		_timetableCourseLocalService.clearLecturerTimetableCourses(lecturerId);
	}

	@Override
	public void deleteLecturerTimetableCourse(long lecturerId,
		hu.unideb.inf.model.TimetableCourse timetableCourse) {
		_timetableCourseLocalService.deleteLecturerTimetableCourse(lecturerId,
			timetableCourse);
	}

	@Override
	public void deleteLecturerTimetableCourse(long lecturerId,
		long timetableCourseId) {
		_timetableCourseLocalService.deleteLecturerTimetableCourse(lecturerId,
			timetableCourseId);
	}

	@Override
	public void deleteLecturerTimetableCourses(long lecturerId,
		java.util.List<hu.unideb.inf.model.TimetableCourse> timetableCourses) {
		_timetableCourseLocalService.deleteLecturerTimetableCourses(lecturerId,
			timetableCourses);
	}

	@Override
	public void deleteLecturerTimetableCourses(long lecturerId,
		long[] timetableCourseIds) {
		_timetableCourseLocalService.deleteLecturerTimetableCourses(lecturerId,
			timetableCourseIds);
	}

	@Override
	public void setLecturerTimetableCourses(long lecturerId,
		long[] timetableCourseIds) {
		_timetableCourseLocalService.setLecturerTimetableCourses(lecturerId,
			timetableCourseIds);
	}

	@Override
	public TimetableCourseLocalService getWrappedService() {
		return _timetableCourseLocalService;
	}

	@Override
	public void setWrappedService(
		TimetableCourseLocalService timetableCourseLocalService) {
		_timetableCourseLocalService = timetableCourseLocalService;
	}

	private TimetableCourseLocalService _timetableCourseLocalService;
}