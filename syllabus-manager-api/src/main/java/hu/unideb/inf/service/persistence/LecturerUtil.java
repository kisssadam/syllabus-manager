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

package hu.unideb.inf.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import hu.unideb.inf.model.Lecturer;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the lecturer service. This utility wraps {@link hu.unideb.inf.service.persistence.impl.LecturerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see LecturerPersistence
 * @see hu.unideb.inf.service.persistence.impl.LecturerPersistenceImpl
 * @generated
 */
@ProviderType
public class LecturerUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Lecturer lecturer) {
		getPersistence().clearCache(lecturer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Lecturer> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Lecturer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Lecturer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Lecturer> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Lecturer update(Lecturer lecturer) {
		return getPersistence().update(lecturer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Lecturer update(Lecturer lecturer,
		ServiceContext serviceContext) {
		return getPersistence().update(lecturer, serviceContext);
	}

	/**
	* Returns the lecturer where lecturerName = &#63; or throws a {@link NoSuchLecturerException} if it could not be found.
	*
	* @param lecturerName the lecturer name
	* @return the matching lecturer
	* @throws NoSuchLecturerException if a matching lecturer could not be found
	*/
	public static Lecturer findByLecturerName(java.lang.String lecturerName)
		throws hu.unideb.inf.exception.NoSuchLecturerException {
		return getPersistence().findByLecturerName(lecturerName);
	}

	/**
	* Returns the lecturer where lecturerName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param lecturerName the lecturer name
	* @return the matching lecturer, or <code>null</code> if a matching lecturer could not be found
	*/
	public static Lecturer fetchByLecturerName(java.lang.String lecturerName) {
		return getPersistence().fetchByLecturerName(lecturerName);
	}

	/**
	* Returns the lecturer where lecturerName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param lecturerName the lecturer name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching lecturer, or <code>null</code> if a matching lecturer could not be found
	*/
	public static Lecturer fetchByLecturerName(java.lang.String lecturerName,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByLecturerName(lecturerName, retrieveFromCache);
	}

	/**
	* Removes the lecturer where lecturerName = &#63; from the database.
	*
	* @param lecturerName the lecturer name
	* @return the lecturer that was removed
	*/
	public static Lecturer removeByLecturerName(java.lang.String lecturerName)
		throws hu.unideb.inf.exception.NoSuchLecturerException {
		return getPersistence().removeByLecturerName(lecturerName);
	}

	/**
	* Returns the number of lecturers where lecturerName = &#63;.
	*
	* @param lecturerName the lecturer name
	* @return the number of matching lecturers
	*/
	public static int countByLecturerName(java.lang.String lecturerName) {
		return getPersistence().countByLecturerName(lecturerName);
	}

	/**
	* Caches the lecturer in the entity cache if it is enabled.
	*
	* @param lecturer the lecturer
	*/
	public static void cacheResult(Lecturer lecturer) {
		getPersistence().cacheResult(lecturer);
	}

	/**
	* Caches the lecturers in the entity cache if it is enabled.
	*
	* @param lecturers the lecturers
	*/
	public static void cacheResult(List<Lecturer> lecturers) {
		getPersistence().cacheResult(lecturers);
	}

	/**
	* Creates a new lecturer with the primary key. Does not add the lecturer to the database.
	*
	* @param lecturerId the primary key for the new lecturer
	* @return the new lecturer
	*/
	public static Lecturer create(long lecturerId) {
		return getPersistence().create(lecturerId);
	}

	/**
	* Removes the lecturer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer that was removed
	* @throws NoSuchLecturerException if a lecturer with the primary key could not be found
	*/
	public static Lecturer remove(long lecturerId)
		throws hu.unideb.inf.exception.NoSuchLecturerException {
		return getPersistence().remove(lecturerId);
	}

	public static Lecturer updateImpl(Lecturer lecturer) {
		return getPersistence().updateImpl(lecturer);
	}

	/**
	* Returns the lecturer with the primary key or throws a {@link NoSuchLecturerException} if it could not be found.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer
	* @throws NoSuchLecturerException if a lecturer with the primary key could not be found
	*/
	public static Lecturer findByPrimaryKey(long lecturerId)
		throws hu.unideb.inf.exception.NoSuchLecturerException {
		return getPersistence().findByPrimaryKey(lecturerId);
	}

	/**
	* Returns the lecturer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer, or <code>null</code> if a lecturer with the primary key could not be found
	*/
	public static Lecturer fetchByPrimaryKey(long lecturerId) {
		return getPersistence().fetchByPrimaryKey(lecturerId);
	}

	public static java.util.Map<java.io.Serializable, Lecturer> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the lecturers.
	*
	* @return the lecturers
	*/
	public static List<Lecturer> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the lecturers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lecturers
	* @param end the upper bound of the range of lecturers (not inclusive)
	* @return the range of lecturers
	*/
	public static List<Lecturer> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the lecturers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lecturers
	* @param end the upper bound of the range of lecturers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lecturers
	*/
	public static List<Lecturer> findAll(int start, int end,
		OrderByComparator<Lecturer> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the lecturers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lecturers
	* @param end the upper bound of the range of lecturers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of lecturers
	*/
	public static List<Lecturer> findAll(int start, int end,
		OrderByComparator<Lecturer> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the lecturers from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lecturers.
	*
	* @return the number of lecturers
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	* Returns the primaryKeys of timetable courses associated with the lecturer.
	*
	* @param pk the primary key of the lecturer
	* @return long[] of the primaryKeys of timetable courses associated with the lecturer
	*/
	public static long[] getTimetableCoursePrimaryKeys(long pk) {
		return getPersistence().getTimetableCoursePrimaryKeys(pk);
	}

	/**
	* Returns all the timetable courses associated with the lecturer.
	*
	* @param pk the primary key of the lecturer
	* @return the timetable courses associated with the lecturer
	*/
	public static List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		long pk) {
		return getPersistence().getTimetableCourses(pk);
	}

	/**
	* Returns a range of all the timetable courses associated with the lecturer.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the lecturer
	* @param start the lower bound of the range of lecturers
	* @param end the upper bound of the range of lecturers (not inclusive)
	* @return the range of timetable courses associated with the lecturer
	*/
	public static List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		long pk, int start, int end) {
		return getPersistence().getTimetableCourses(pk, start, end);
	}

	/**
	* Returns an ordered range of all the timetable courses associated with the lecturer.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the lecturer
	* @param start the lower bound of the range of lecturers
	* @param end the upper bound of the range of lecturers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of timetable courses associated with the lecturer
	*/
	public static List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		long pk, int start, int end,
		OrderByComparator<hu.unideb.inf.model.TimetableCourse> orderByComparator) {
		return getPersistence()
				   .getTimetableCourses(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of timetable courses associated with the lecturer.
	*
	* @param pk the primary key of the lecturer
	* @return the number of timetable courses associated with the lecturer
	*/
	public static int getTimetableCoursesSize(long pk) {
		return getPersistence().getTimetableCoursesSize(pk);
	}

	/**
	* Returns <code>true</code> if the timetable course is associated with the lecturer.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePK the primary key of the timetable course
	* @return <code>true</code> if the timetable course is associated with the lecturer; <code>false</code> otherwise
	*/
	public static boolean containsTimetableCourse(long pk,
		long timetableCoursePK) {
		return getPersistence().containsTimetableCourse(pk, timetableCoursePK);
	}

	/**
	* Returns <code>true</code> if the lecturer has any timetable courses associated with it.
	*
	* @param pk the primary key of the lecturer to check for associations with timetable courses
	* @return <code>true</code> if the lecturer has any timetable courses associated with it; <code>false</code> otherwise
	*/
	public static boolean containsTimetableCourses(long pk) {
		return getPersistence().containsTimetableCourses(pk);
	}

	/**
	* Adds an association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePK the primary key of the timetable course
	*/
	public static void addTimetableCourse(long pk, long timetableCoursePK) {
		getPersistence().addTimetableCourse(pk, timetableCoursePK);
	}

	/**
	* Adds an association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCourse the timetable course
	*/
	public static void addTimetableCourse(long pk,
		hu.unideb.inf.model.TimetableCourse timetableCourse) {
		getPersistence().addTimetableCourse(pk, timetableCourse);
	}

	/**
	* Adds an association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePKs the primary keys of the timetable courses
	*/
	public static void addTimetableCourses(long pk, long[] timetableCoursePKs) {
		getPersistence().addTimetableCourses(pk, timetableCoursePKs);
	}

	/**
	* Adds an association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCourses the timetable courses
	*/
	public static void addTimetableCourses(long pk,
		List<hu.unideb.inf.model.TimetableCourse> timetableCourses) {
		getPersistence().addTimetableCourses(pk, timetableCourses);
	}

	/**
	* Clears all associations between the lecturer and its timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer to clear the associated timetable courses from
	*/
	public static void clearTimetableCourses(long pk) {
		getPersistence().clearTimetableCourses(pk);
	}

	/**
	* Removes the association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePK the primary key of the timetable course
	*/
	public static void removeTimetableCourse(long pk, long timetableCoursePK) {
		getPersistence().removeTimetableCourse(pk, timetableCoursePK);
	}

	/**
	* Removes the association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCourse the timetable course
	*/
	public static void removeTimetableCourse(long pk,
		hu.unideb.inf.model.TimetableCourse timetableCourse) {
		getPersistence().removeTimetableCourse(pk, timetableCourse);
	}

	/**
	* Removes the association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePKs the primary keys of the timetable courses
	*/
	public static void removeTimetableCourses(long pk, long[] timetableCoursePKs) {
		getPersistence().removeTimetableCourses(pk, timetableCoursePKs);
	}

	/**
	* Removes the association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCourses the timetable courses
	*/
	public static void removeTimetableCourses(long pk,
		List<hu.unideb.inf.model.TimetableCourse> timetableCourses) {
		getPersistence().removeTimetableCourses(pk, timetableCourses);
	}

	/**
	* Sets the timetable courses associated with the lecturer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePKs the primary keys of the timetable courses to be associated with the lecturer
	*/
	public static void setTimetableCourses(long pk, long[] timetableCoursePKs) {
		getPersistence().setTimetableCourses(pk, timetableCoursePKs);
	}

	/**
	* Sets the timetable courses associated with the lecturer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCourses the timetable courses to be associated with the lecturer
	*/
	public static void setTimetableCourses(long pk,
		List<hu.unideb.inf.model.TimetableCourse> timetableCourses) {
		getPersistence().setTimetableCourses(pk, timetableCourses);
	}

	public static LecturerPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LecturerPersistence, LecturerPersistence> _serviceTracker =
		ServiceTrackerFactory.open(LecturerPersistence.class);
}