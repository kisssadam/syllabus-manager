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
 * Provides the local service utility for Lecturer. This utility wraps
 * {@link hu.unideb.inf.service.impl.LecturerLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Adam Kiss
 * @see LecturerLocalService
 * @see hu.unideb.inf.service.base.LecturerLocalServiceBaseImpl
 * @see hu.unideb.inf.service.impl.LecturerLocalServiceImpl
 * @generated
 */
@ProviderType
public class LecturerLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.unideb.inf.service.impl.LecturerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean hasTimetableCourseLecturer(long timetableCourseId,
		long lecturerId) {
		return getService()
				   .hasTimetableCourseLecturer(timetableCourseId, lecturerId);
	}

	public static boolean hasTimetableCourseLecturers(long timetableCourseId) {
		return getService().hasTimetableCourseLecturers(timetableCourseId);
	}

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
	* Adds the lecturer to the database. Also notifies the appropriate model listeners.
	*
	* @param lecturer the lecturer
	* @return the lecturer that was added
	*/
	public static hu.unideb.inf.model.Lecturer addLecturer(
		hu.unideb.inf.model.Lecturer lecturer) {
		return getService().addLecturer(lecturer);
	}

	public static hu.unideb.inf.model.Lecturer addLecturer(
		java.lang.String lecturerName, long lecturerUserId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addLecturer(lecturerName, lecturerUserId, serviceContext);
	}

	/**
	* Creates a new lecturer with the primary key. Does not add the lecturer to the database.
	*
	* @param lecturerId the primary key for the new lecturer
	* @return the new lecturer
	*/
	public static hu.unideb.inf.model.Lecturer createLecturer(long lecturerId) {
		return getService().createLecturer(lecturerId);
	}

	/**
	* Deletes the lecturer from the database. Also notifies the appropriate model listeners.
	*
	* @param lecturer the lecturer
	* @return the lecturer that was removed
	*/
	public static hu.unideb.inf.model.Lecturer deleteLecturer(
		hu.unideb.inf.model.Lecturer lecturer) {
		return getService().deleteLecturer(lecturer);
	}

	/**
	* Deletes the lecturer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer that was removed
	* @throws PortalException if a lecturer with the primary key could not be found
	*/
	public static hu.unideb.inf.model.Lecturer deleteLecturer(long lecturerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteLecturer(lecturerId);
	}

	public static hu.unideb.inf.model.Lecturer deleteLecturer(long lecturerId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLecturer(lecturerId, serviceContext);
	}

	public static hu.unideb.inf.model.Lecturer fetchLecturer(long lecturerId) {
		return getService().fetchLecturer(lecturerId);
	}

	public static hu.unideb.inf.model.Lecturer fetchLecturerByN_U(
		java.lang.String lecturerName, long lecturerUserId) {
		return getService().fetchLecturerByN_U(lecturerName, lecturerUserId);
	}

	/**
	* Returns the lecturer with the primary key.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer
	* @throws PortalException if a lecturer with the primary key could not be found
	*/
	public static hu.unideb.inf.model.Lecturer getLecturer(long lecturerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLecturer(lecturerId);
	}

	public static hu.unideb.inf.model.Lecturer getLecturerByN_U(
		java.lang.String lecturerName, long lecturerUserId)
		throws hu.unideb.inf.exception.NoSuchLecturerException {
		return getService().getLecturerByN_U(lecturerName, lecturerUserId);
	}

	/**
	* Updates the lecturer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lecturer the lecturer
	* @return the lecturer that was updated
	*/
	public static hu.unideb.inf.model.Lecturer updateLecturer(
		hu.unideb.inf.model.Lecturer lecturer) {
		return getService().updateLecturer(lecturer);
	}

	public static hu.unideb.inf.model.Lecturer updateLecturer(long userId,
		long lecturerId, java.lang.String lecturerName, long lecturerUserId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateLecturer(userId, lecturerId, lecturerName,
			lecturerUserId, serviceContext);
	}

	/**
	* Returns the number of lecturers.
	*
	* @return the number of lecturers
	*/
	public static int getLecturersCount() {
		return getService().getLecturersCount();
	}

	public static int getTimetableCourseLecturersCount(long timetableCourseId) {
		return getService().getTimetableCourseLecturersCount(timetableCourseId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<hu.unideb.inf.model.Lecturer> getLecturers()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLecturers();
	}

	/**
	* Returns a range of all the lecturers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lecturers
	* @param end the upper bound of the range of lecturers (not inclusive)
	* @return the range of lecturers
	*/
	public static java.util.List<hu.unideb.inf.model.Lecturer> getLecturers(
		int start, int end) {
		return getService().getLecturers(start, end);
	}

	public static java.util.List<hu.unideb.inf.model.Lecturer> getLecturersByIds(
		long[] lecturerIds)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchLecturerException {
		return getService().getLecturersByIds(lecturerIds);
	}

	public static java.util.List<hu.unideb.inf.model.Lecturer> getTimetableCourseLecturers(
		long timetableCourseId) {
		return getService().getTimetableCourseLecturers(timetableCourseId);
	}

	public static java.util.List<hu.unideb.inf.model.Lecturer> getTimetableCourseLecturers(
		long timetableCourseId, int start, int end) {
		return getService()
				   .getTimetableCourseLecturers(timetableCourseId, start, end);
	}

	public static java.util.List<hu.unideb.inf.model.Lecturer> getTimetableCourseLecturers(
		long timetableCourseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<hu.unideb.inf.model.Lecturer> orderByComparator) {
		return getService()
				   .getTimetableCourseLecturers(timetableCourseId, start, end,
			orderByComparator);
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

	/**
	* Returns the timetableCourseIds of the timetable courses associated with the lecturer.
	*
	* @param lecturerId the lecturerId of the lecturer
	* @return long[] the timetableCourseIds of timetable courses associated with the lecturer
	*/
	public static long[] getTimetableCoursePrimaryKeys(long lecturerId) {
		return getService().getTimetableCoursePrimaryKeys(lecturerId);
	}

	public static void addTimetableCourseLecturer(long timetableCourseId,
		hu.unideb.inf.model.Lecturer lecturer) {
		getService().addTimetableCourseLecturer(timetableCourseId, lecturer);
	}

	public static void addTimetableCourseLecturer(long timetableCourseId,
		long lecturerId) {
		getService().addTimetableCourseLecturer(timetableCourseId, lecturerId);
	}

	public static void addTimetableCourseLecturers(long timetableCourseId,
		java.util.List<hu.unideb.inf.model.Lecturer> lecturers) {
		getService().addTimetableCourseLecturers(timetableCourseId, lecturers);
	}

	public static void addTimetableCourseLecturers(long timetableCourseId,
		long[] lecturerIds) {
		getService().addTimetableCourseLecturers(timetableCourseId, lecturerIds);
	}

	public static void clearTimetableCourseLecturers(long timetableCourseId) {
		getService().clearTimetableCourseLecturers(timetableCourseId);
	}

	public static void deleteTimetableCourseLecturer(long timetableCourseId,
		hu.unideb.inf.model.Lecturer lecturer) {
		getService().deleteTimetableCourseLecturer(timetableCourseId, lecturer);
	}

	public static void deleteTimetableCourseLecturer(long timetableCourseId,
		long lecturerId) {
		getService().deleteTimetableCourseLecturer(timetableCourseId, lecturerId);
	}

	public static void deleteTimetableCourseLecturers(long timetableCourseId,
		java.util.List<hu.unideb.inf.model.Lecturer> lecturers) {
		getService().deleteTimetableCourseLecturers(timetableCourseId, lecturers);
	}

	public static void deleteTimetableCourseLecturers(long timetableCourseId,
		long[] lecturerIds) {
		getService()
			.deleteTimetableCourseLecturers(timetableCourseId, lecturerIds);
	}

	public static void setTimetableCourseLecturers(long timetableCourseId,
		long[] lecturerIds) {
		getService().setTimetableCourseLecturers(timetableCourseId, lecturerIds);
	}

	public static LecturerLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LecturerLocalService, LecturerLocalService> _serviceTracker =
		ServiceTrackerFactory.open(LecturerLocalService.class);
}