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
 * Provides the local service utility for TimetableCourse. This utility wraps
 * {@link hu.unideb.inf.service.impl.TimetableCourseLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Adam Kiss
 * @see TimetableCourseLocalService
 * @see hu.unideb.inf.service.base.TimetableCourseLocalServiceBaseImpl
 * @see hu.unideb.inf.service.impl.TimetableCourseLocalServiceImpl
 * @generated
 */
@ProviderType
public class TimetableCourseLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link hu.unideb.inf.service.impl.TimetableCourseLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean hasLecturerTimetableCourse(long lecturerId,
		long timetableCourseId) {
		return getService()
				   .hasLecturerTimetableCourse(lecturerId, timetableCourseId);
	}

	public static boolean hasLecturerTimetableCourses(long lecturerId) {
		return getService().hasLecturerTimetableCourses(lecturerId);
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
	* Adds the timetable course to the database. Also notifies the appropriate model listeners.
	*
	* @param timetableCourse the timetable course
	* @return the timetable course that was added
	*/
	public static hu.unideb.inf.model.TimetableCourse addTimetableCourse(
		hu.unideb.inf.model.TimetableCourse timetableCourse) {
		return getService().addTimetableCourse(timetableCourse);
	}

	public static hu.unideb.inf.model.TimetableCourse addTimetableCourse(
		long courseId, long semesterId, java.lang.String timetableCourseCode,
		java.lang.String subjectType, int recommendedTerm, int limit,
		long[] lecturerIds, java.lang.String classScheduleInfo,
		java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addTimetableCourse(courseId, semesterId,
			timetableCourseCode, subjectType, recommendedTerm, limit,
			lecturerIds, classScheduleInfo, description, serviceContext);
	}

	/**
	* Creates a new timetable course with the primary key. Does not add the timetable course to the database.
	*
	* @param timetableCourseId the primary key for the new timetable course
	* @return the new timetable course
	*/
	public static hu.unideb.inf.model.TimetableCourse createTimetableCourse(
		long timetableCourseId) {
		return getService().createTimetableCourse(timetableCourseId);
	}

	/**
	* Deletes the timetable course from the database. Also notifies the appropriate model listeners.
	*
	* @param timetableCourse the timetable course
	* @return the timetable course that was removed
	*/
	public static hu.unideb.inf.model.TimetableCourse deleteTimetableCourse(
		hu.unideb.inf.model.TimetableCourse timetableCourse) {
		return getService().deleteTimetableCourse(timetableCourse);
	}

	/**
	* Deletes the timetable course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course that was removed
	* @throws PortalException if a timetable course with the primary key could not be found
	*/
	public static hu.unideb.inf.model.TimetableCourse deleteTimetableCourse(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTimetableCourse(timetableCourseId);
	}

	public static hu.unideb.inf.model.TimetableCourse deleteTimetableCourse(
		long timetableCourseId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteTimetableCourse(timetableCourseId, serviceContext);
	}

	public static hu.unideb.inf.model.TimetableCourse fetchTimetableCourse(
		long timetableCourseId) {
		return getService().fetchTimetableCourse(timetableCourseId);
	}

	public static hu.unideb.inf.model.TimetableCourse fetchTimetableCourseByC_S_T_S(
		long courseId, long semesterId, java.lang.String timetableCourseCode,
		java.lang.String subjectType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchTimetableCourseByC_S_T_S(courseId, semesterId,
			timetableCourseCode, subjectType);
	}

	/**
	* Returns the timetable course with the primary key.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course
	* @throws PortalException if a timetable course with the primary key could not be found
	*/
	public static hu.unideb.inf.model.TimetableCourse getTimetableCourse(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTimetableCourse(timetableCourseId);
	}

	/**
	* Updates the timetable course in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param timetableCourse the timetable course
	* @return the timetable course that was updated
	*/
	public static hu.unideb.inf.model.TimetableCourse updateTimetableCourse(
		hu.unideb.inf.model.TimetableCourse timetableCourse) {
		return getService().updateTimetableCourse(timetableCourse);
	}

	public static hu.unideb.inf.model.TimetableCourse updateTimetableCourse(
		long userId, long timetableCourseId, long courseId, long semesterId,
		java.lang.String timetableCourseCode, java.lang.String subjectType,
		int recommendedTerm, int limit, long[] lecturerIds,
		java.lang.String classScheduleInfo, java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateTimetableCourse(userId, timetableCourseId, courseId,
			semesterId, timetableCourseCode, subjectType, recommendedTerm,
			limit, lecturerIds, classScheduleInfo, description, serviceContext);
	}

	public static int getLecturerTimetableCoursesCount(long lecturerId) {
		return getService().getLecturerTimetableCoursesCount(lecturerId);
	}

	public static int getTimetableCourseCountByCourseId(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCourseCountByCourseId(courseId);
	}

	/**
	* Returns the number of timetable courses.
	*
	* @return the number of timetable courses
	*/
	public static int getTimetableCoursesCount() {
		return getService().getTimetableCoursesCount();
	}

	public static int getTimetableCoursesCountBySemesterId(long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCoursesCountBySemesterId(semesterId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getLecturerTimetableCourses(
		long lecturerId) {
		return getService().getLecturerTimetableCourses(lecturerId);
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getLecturerTimetableCourses(
		long lecturerId, int start, int end) {
		return getService().getLecturerTimetableCourses(lecturerId, start, end);
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getLecturerTimetableCourses(
		long lecturerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<hu.unideb.inf.model.TimetableCourse> orderByComparator) {
		return getService()
				   .getLecturerTimetableCourses(lecturerId, start, end,
			orderByComparator);
	}

	public static java.util.List<hu.unideb.inf.model.Lecturer> getLecutersByTimetableCourseId(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLecutersByTimetableCourseId(timetableCourseId);
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCourses();
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
	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		int start, int end) {
		return getService().getTimetableCourses(start, end);
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesByC_S(
		long courseId, long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.exception.NoSuchTimetableCourseException {
		return getService().getTimetableCoursesByC_S(courseId, semesterId);
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesByCourseId(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCoursesByCourseId(courseId);
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesByCourseId(
		long courseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCoursesByCourseId(courseId, start, end);
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesBySemesterId(
		long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimetableCoursesBySemesterId(semesterId);
	}

	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCoursesBySemesterId(
		long semesterId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTimetableCoursesBySemesterId(semesterId, start, end);
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
	* Returns the lecturerIds of the lecturers associated with the timetable course.
	*
	* @param timetableCourseId the timetableCourseId of the timetable course
	* @return long[] the lecturerIds of lecturers associated with the timetable course
	*/
	public static long[] getLecturerPrimaryKeys(long timetableCourseId) {
		return getService().getLecturerPrimaryKeys(timetableCourseId);
	}

	public static void addLecturerTimetableCourse(long lecturerId,
		hu.unideb.inf.model.TimetableCourse timetableCourse) {
		getService().addLecturerTimetableCourse(lecturerId, timetableCourse);
	}

	public static void addLecturerTimetableCourse(long lecturerId,
		long timetableCourseId) {
		getService().addLecturerTimetableCourse(lecturerId, timetableCourseId);
	}

	public static void addLecturerTimetableCourses(long lecturerId,
		java.util.List<hu.unideb.inf.model.TimetableCourse> timetableCourses) {
		getService().addLecturerTimetableCourses(lecturerId, timetableCourses);
	}

	public static void addLecturerTimetableCourses(long lecturerId,
		long[] timetableCourseIds) {
		getService().addLecturerTimetableCourses(lecturerId, timetableCourseIds);
	}

	public static void clearLecturerTimetableCourses(long lecturerId) {
		getService().clearLecturerTimetableCourses(lecturerId);
	}

	public static void deleteLecturerTimetableCourse(long lecturerId,
		hu.unideb.inf.model.TimetableCourse timetableCourse) {
		getService().deleteLecturerTimetableCourse(lecturerId, timetableCourse);
	}

	public static void deleteLecturerTimetableCourse(long lecturerId,
		long timetableCourseId) {
		getService().deleteLecturerTimetableCourse(lecturerId, timetableCourseId);
	}

	public static void deleteLecturerTimetableCourses(long lecturerId,
		java.util.List<hu.unideb.inf.model.TimetableCourse> timetableCourses) {
		getService().deleteLecturerTimetableCourses(lecturerId, timetableCourses);
	}

	public static void deleteLecturerTimetableCourses(long lecturerId,
		long[] timetableCourseIds) {
		getService()
			.deleteLecturerTimetableCourses(lecturerId, timetableCourseIds);
	}

	public static void setLecturerTimetableCourses(long lecturerId,
		long[] timetableCourseIds) {
		getService().setLecturerTimetableCourses(lecturerId, timetableCourseIds);
	}

	public static TimetableCourseLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TimetableCourseLocalService, TimetableCourseLocalService> _serviceTracker =
		ServiceTrackerFactory.open(TimetableCourseLocalService.class);
}