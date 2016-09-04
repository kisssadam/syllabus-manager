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

import hu.unideb.inf.model.TimetableCourse;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the timetable course service. This utility wraps {@link hu.unideb.inf.service.persistence.impl.TimetableCoursePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see TimetableCoursePersistence
 * @see hu.unideb.inf.service.persistence.impl.TimetableCoursePersistenceImpl
 * @generated
 */
@ProviderType
public class TimetableCourseUtil {
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
	public static void clearCache(TimetableCourse timetableCourse) {
		getPersistence().clearCache(timetableCourse);
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
	public static List<TimetableCourse> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TimetableCourse> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TimetableCourse> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TimetableCourse> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TimetableCourse update(TimetableCourse timetableCourse) {
		return getPersistence().update(timetableCourse);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TimetableCourse update(TimetableCourse timetableCourse,
		ServiceContext serviceContext) {
		return getPersistence().update(timetableCourse, serviceContext);
	}

	/**
	* Returns all the timetable courses where courseId = &#63; and semesterId = &#63;.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @return the matching timetable courses
	*/
	public static List<TimetableCourse> findByC_S(long courseId, long semesterId) {
		return getPersistence().findByC_S(courseId, semesterId);
	}

	/**
	* Returns a range of all the timetable courses where courseId = &#63; and semesterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @return the range of matching timetable courses
	*/
	public static List<TimetableCourse> findByC_S(long courseId,
		long semesterId, int start, int end) {
		return getPersistence().findByC_S(courseId, semesterId, start, end);
	}

	/**
	* Returns an ordered range of all the timetable courses where courseId = &#63; and semesterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timetable courses
	*/
	public static List<TimetableCourse> findByC_S(long courseId,
		long semesterId, int start, int end,
		OrderByComparator<TimetableCourse> orderByComparator) {
		return getPersistence()
				   .findByC_S(courseId, semesterId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the timetable courses where courseId = &#63; and semesterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching timetable courses
	*/
	public static List<TimetableCourse> findByC_S(long courseId,
		long semesterId, int start, int end,
		OrderByComparator<TimetableCourse> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_S(courseId, semesterId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first timetable course in the ordered set where courseId = &#63; and semesterId = &#63;.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timetable course
	* @throws NoSuchTimetableCourseException if a matching timetable course could not be found
	*/
	public static TimetableCourse findByC_S_First(long courseId,
		long semesterId, OrderByComparator<TimetableCourse> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchTimetableCourseException {
		return getPersistence()
				   .findByC_S_First(courseId, semesterId, orderByComparator);
	}

	/**
	* Returns the first timetable course in the ordered set where courseId = &#63; and semesterId = &#63;.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timetable course, or <code>null</code> if a matching timetable course could not be found
	*/
	public static TimetableCourse fetchByC_S_First(long courseId,
		long semesterId, OrderByComparator<TimetableCourse> orderByComparator) {
		return getPersistence()
				   .fetchByC_S_First(courseId, semesterId, orderByComparator);
	}

	/**
	* Returns the last timetable course in the ordered set where courseId = &#63; and semesterId = &#63;.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timetable course
	* @throws NoSuchTimetableCourseException if a matching timetable course could not be found
	*/
	public static TimetableCourse findByC_S_Last(long courseId,
		long semesterId, OrderByComparator<TimetableCourse> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchTimetableCourseException {
		return getPersistence()
				   .findByC_S_Last(courseId, semesterId, orderByComparator);
	}

	/**
	* Returns the last timetable course in the ordered set where courseId = &#63; and semesterId = &#63;.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timetable course, or <code>null</code> if a matching timetable course could not be found
	*/
	public static TimetableCourse fetchByC_S_Last(long courseId,
		long semesterId, OrderByComparator<TimetableCourse> orderByComparator) {
		return getPersistence()
				   .fetchByC_S_Last(courseId, semesterId, orderByComparator);
	}

	/**
	* Returns the timetable courses before and after the current timetable course in the ordered set where courseId = &#63; and semesterId = &#63;.
	*
	* @param timetableCourseId the primary key of the current timetable course
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timetable course
	* @throws NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	*/
	public static TimetableCourse[] findByC_S_PrevAndNext(
		long timetableCourseId, long courseId, long semesterId,
		OrderByComparator<TimetableCourse> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchTimetableCourseException {
		return getPersistence()
				   .findByC_S_PrevAndNext(timetableCourseId, courseId,
			semesterId, orderByComparator);
	}

	/**
	* Removes all the timetable courses where courseId = &#63; and semesterId = &#63; from the database.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	*/
	public static void removeByC_S(long courseId, long semesterId) {
		getPersistence().removeByC_S(courseId, semesterId);
	}

	/**
	* Returns the number of timetable courses where courseId = &#63; and semesterId = &#63;.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @return the number of matching timetable courses
	*/
	public static int countByC_S(long courseId, long semesterId) {
		return getPersistence().countByC_S(courseId, semesterId);
	}

	/**
	* Returns all the timetable courses where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the matching timetable courses
	*/
	public static List<TimetableCourse> findByCourseId(long courseId) {
		return getPersistence().findByCourseId(courseId);
	}

	/**
	* Returns a range of all the timetable courses where courseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @return the range of matching timetable courses
	*/
	public static List<TimetableCourse> findByCourseId(long courseId,
		int start, int end) {
		return getPersistence().findByCourseId(courseId, start, end);
	}

	/**
	* Returns an ordered range of all the timetable courses where courseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timetable courses
	*/
	public static List<TimetableCourse> findByCourseId(long courseId,
		int start, int end, OrderByComparator<TimetableCourse> orderByComparator) {
		return getPersistence()
				   .findByCourseId(courseId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the timetable courses where courseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching timetable courses
	*/
	public static List<TimetableCourse> findByCourseId(long courseId,
		int start, int end,
		OrderByComparator<TimetableCourse> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCourseId(courseId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first timetable course in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timetable course
	* @throws NoSuchTimetableCourseException if a matching timetable course could not be found
	*/
	public static TimetableCourse findByCourseId_First(long courseId,
		OrderByComparator<TimetableCourse> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchTimetableCourseException {
		return getPersistence().findByCourseId_First(courseId, orderByComparator);
	}

	/**
	* Returns the first timetable course in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timetable course, or <code>null</code> if a matching timetable course could not be found
	*/
	public static TimetableCourse fetchByCourseId_First(long courseId,
		OrderByComparator<TimetableCourse> orderByComparator) {
		return getPersistence()
				   .fetchByCourseId_First(courseId, orderByComparator);
	}

	/**
	* Returns the last timetable course in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timetable course
	* @throws NoSuchTimetableCourseException if a matching timetable course could not be found
	*/
	public static TimetableCourse findByCourseId_Last(long courseId,
		OrderByComparator<TimetableCourse> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchTimetableCourseException {
		return getPersistence().findByCourseId_Last(courseId, orderByComparator);
	}

	/**
	* Returns the last timetable course in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timetable course, or <code>null</code> if a matching timetable course could not be found
	*/
	public static TimetableCourse fetchByCourseId_Last(long courseId,
		OrderByComparator<TimetableCourse> orderByComparator) {
		return getPersistence().fetchByCourseId_Last(courseId, orderByComparator);
	}

	/**
	* Returns the timetable courses before and after the current timetable course in the ordered set where courseId = &#63;.
	*
	* @param timetableCourseId the primary key of the current timetable course
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timetable course
	* @throws NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	*/
	public static TimetableCourse[] findByCourseId_PrevAndNext(
		long timetableCourseId, long courseId,
		OrderByComparator<TimetableCourse> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchTimetableCourseException {
		return getPersistence()
				   .findByCourseId_PrevAndNext(timetableCourseId, courseId,
			orderByComparator);
	}

	/**
	* Removes all the timetable courses where courseId = &#63; from the database.
	*
	* @param courseId the course ID
	*/
	public static void removeByCourseId(long courseId) {
		getPersistence().removeByCourseId(courseId);
	}

	/**
	* Returns the number of timetable courses where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the number of matching timetable courses
	*/
	public static int countByCourseId(long courseId) {
		return getPersistence().countByCourseId(courseId);
	}

	/**
	* Returns all the timetable courses where semesterId = &#63;.
	*
	* @param semesterId the semester ID
	* @return the matching timetable courses
	*/
	public static List<TimetableCourse> findBySemesterId(long semesterId) {
		return getPersistence().findBySemesterId(semesterId);
	}

	/**
	* Returns a range of all the timetable courses where semesterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param semesterId the semester ID
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @return the range of matching timetable courses
	*/
	public static List<TimetableCourse> findBySemesterId(long semesterId,
		int start, int end) {
		return getPersistence().findBySemesterId(semesterId, start, end);
	}

	/**
	* Returns an ordered range of all the timetable courses where semesterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param semesterId the semester ID
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timetable courses
	*/
	public static List<TimetableCourse> findBySemesterId(long semesterId,
		int start, int end, OrderByComparator<TimetableCourse> orderByComparator) {
		return getPersistence()
				   .findBySemesterId(semesterId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the timetable courses where semesterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param semesterId the semester ID
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching timetable courses
	*/
	public static List<TimetableCourse> findBySemesterId(long semesterId,
		int start, int end,
		OrderByComparator<TimetableCourse> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBySemesterId(semesterId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first timetable course in the ordered set where semesterId = &#63;.
	*
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timetable course
	* @throws NoSuchTimetableCourseException if a matching timetable course could not be found
	*/
	public static TimetableCourse findBySemesterId_First(long semesterId,
		OrderByComparator<TimetableCourse> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchTimetableCourseException {
		return getPersistence()
				   .findBySemesterId_First(semesterId, orderByComparator);
	}

	/**
	* Returns the first timetable course in the ordered set where semesterId = &#63;.
	*
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timetable course, or <code>null</code> if a matching timetable course could not be found
	*/
	public static TimetableCourse fetchBySemesterId_First(long semesterId,
		OrderByComparator<TimetableCourse> orderByComparator) {
		return getPersistence()
				   .fetchBySemesterId_First(semesterId, orderByComparator);
	}

	/**
	* Returns the last timetable course in the ordered set where semesterId = &#63;.
	*
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timetable course
	* @throws NoSuchTimetableCourseException if a matching timetable course could not be found
	*/
	public static TimetableCourse findBySemesterId_Last(long semesterId,
		OrderByComparator<TimetableCourse> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchTimetableCourseException {
		return getPersistence()
				   .findBySemesterId_Last(semesterId, orderByComparator);
	}

	/**
	* Returns the last timetable course in the ordered set where semesterId = &#63;.
	*
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timetable course, or <code>null</code> if a matching timetable course could not be found
	*/
	public static TimetableCourse fetchBySemesterId_Last(long semesterId,
		OrderByComparator<TimetableCourse> orderByComparator) {
		return getPersistence()
				   .fetchBySemesterId_Last(semesterId, orderByComparator);
	}

	/**
	* Returns the timetable courses before and after the current timetable course in the ordered set where semesterId = &#63;.
	*
	* @param timetableCourseId the primary key of the current timetable course
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timetable course
	* @throws NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	*/
	public static TimetableCourse[] findBySemesterId_PrevAndNext(
		long timetableCourseId, long semesterId,
		OrderByComparator<TimetableCourse> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchTimetableCourseException {
		return getPersistence()
				   .findBySemesterId_PrevAndNext(timetableCourseId, semesterId,
			orderByComparator);
	}

	/**
	* Removes all the timetable courses where semesterId = &#63; from the database.
	*
	* @param semesterId the semester ID
	*/
	public static void removeBySemesterId(long semesterId) {
		getPersistence().removeBySemesterId(semesterId);
	}

	/**
	* Returns the number of timetable courses where semesterId = &#63;.
	*
	* @param semesterId the semester ID
	* @return the number of matching timetable courses
	*/
	public static int countBySemesterId(long semesterId) {
		return getPersistence().countBySemesterId(semesterId);
	}

	/**
	* Returns the timetable course where courseId = &#63; and semesterId = &#63; and timetableCourseCode = &#63; and subjectType = &#63; or throws a {@link NoSuchTimetableCourseException} if it could not be found.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param timetableCourseCode the timetable course code
	* @param subjectType the subject type
	* @return the matching timetable course
	* @throws NoSuchTimetableCourseException if a matching timetable course could not be found
	*/
	public static TimetableCourse findByC_S_T_S(long courseId, long semesterId,
		java.lang.String timetableCourseCode, java.lang.String subjectType)
		throws hu.unideb.inf.exception.NoSuchTimetableCourseException {
		return getPersistence()
				   .findByC_S_T_S(courseId, semesterId, timetableCourseCode,
			subjectType);
	}

	/**
	* Returns the timetable course where courseId = &#63; and semesterId = &#63; and timetableCourseCode = &#63; and subjectType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param timetableCourseCode the timetable course code
	* @param subjectType the subject type
	* @return the matching timetable course, or <code>null</code> if a matching timetable course could not be found
	*/
	public static TimetableCourse fetchByC_S_T_S(long courseId,
		long semesterId, java.lang.String timetableCourseCode,
		java.lang.String subjectType) {
		return getPersistence()
				   .fetchByC_S_T_S(courseId, semesterId, timetableCourseCode,
			subjectType);
	}

	/**
	* Returns the timetable course where courseId = &#63; and semesterId = &#63; and timetableCourseCode = &#63; and subjectType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param timetableCourseCode the timetable course code
	* @param subjectType the subject type
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching timetable course, or <code>null</code> if a matching timetable course could not be found
	*/
	public static TimetableCourse fetchByC_S_T_S(long courseId,
		long semesterId, java.lang.String timetableCourseCode,
		java.lang.String subjectType, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByC_S_T_S(courseId, semesterId, timetableCourseCode,
			subjectType, retrieveFromCache);
	}

	/**
	* Removes the timetable course where courseId = &#63; and semesterId = &#63; and timetableCourseCode = &#63; and subjectType = &#63; from the database.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param timetableCourseCode the timetable course code
	* @param subjectType the subject type
	* @return the timetable course that was removed
	*/
	public static TimetableCourse removeByC_S_T_S(long courseId,
		long semesterId, java.lang.String timetableCourseCode,
		java.lang.String subjectType)
		throws hu.unideb.inf.exception.NoSuchTimetableCourseException {
		return getPersistence()
				   .removeByC_S_T_S(courseId, semesterId, timetableCourseCode,
			subjectType);
	}

	/**
	* Returns the number of timetable courses where courseId = &#63; and semesterId = &#63; and timetableCourseCode = &#63; and subjectType = &#63;.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param timetableCourseCode the timetable course code
	* @param subjectType the subject type
	* @return the number of matching timetable courses
	*/
	public static int countByC_S_T_S(long courseId, long semesterId,
		java.lang.String timetableCourseCode, java.lang.String subjectType) {
		return getPersistence()
				   .countByC_S_T_S(courseId, semesterId, timetableCourseCode,
			subjectType);
	}

	/**
	* Caches the timetable course in the entity cache if it is enabled.
	*
	* @param timetableCourse the timetable course
	*/
	public static void cacheResult(TimetableCourse timetableCourse) {
		getPersistence().cacheResult(timetableCourse);
	}

	/**
	* Caches the timetable courses in the entity cache if it is enabled.
	*
	* @param timetableCourses the timetable courses
	*/
	public static void cacheResult(List<TimetableCourse> timetableCourses) {
		getPersistence().cacheResult(timetableCourses);
	}

	/**
	* Creates a new timetable course with the primary key. Does not add the timetable course to the database.
	*
	* @param timetableCourseId the primary key for the new timetable course
	* @return the new timetable course
	*/
	public static TimetableCourse create(long timetableCourseId) {
		return getPersistence().create(timetableCourseId);
	}

	/**
	* Removes the timetable course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course that was removed
	* @throws NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	*/
	public static TimetableCourse remove(long timetableCourseId)
		throws hu.unideb.inf.exception.NoSuchTimetableCourseException {
		return getPersistence().remove(timetableCourseId);
	}

	public static TimetableCourse updateImpl(TimetableCourse timetableCourse) {
		return getPersistence().updateImpl(timetableCourse);
	}

	/**
	* Returns the timetable course with the primary key or throws a {@link NoSuchTimetableCourseException} if it could not be found.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course
	* @throws NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	*/
	public static TimetableCourse findByPrimaryKey(long timetableCourseId)
		throws hu.unideb.inf.exception.NoSuchTimetableCourseException {
		return getPersistence().findByPrimaryKey(timetableCourseId);
	}

	/**
	* Returns the timetable course with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course, or <code>null</code> if a timetable course with the primary key could not be found
	*/
	public static TimetableCourse fetchByPrimaryKey(long timetableCourseId) {
		return getPersistence().fetchByPrimaryKey(timetableCourseId);
	}

	public static java.util.Map<java.io.Serializable, TimetableCourse> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the timetable courses.
	*
	* @return the timetable courses
	*/
	public static List<TimetableCourse> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the timetable courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @return the range of timetable courses
	*/
	public static List<TimetableCourse> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the timetable courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of timetable courses
	*/
	public static List<TimetableCourse> findAll(int start, int end,
		OrderByComparator<TimetableCourse> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the timetable courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of timetable courses
	*/
	public static List<TimetableCourse> findAll(int start, int end,
		OrderByComparator<TimetableCourse> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the timetable courses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of timetable courses.
	*
	* @return the number of timetable courses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	* Returns the primaryKeys of lecturers associated with the timetable course.
	*
	* @param pk the primary key of the timetable course
	* @return long[] of the primaryKeys of lecturers associated with the timetable course
	*/
	public static long[] getLecturerPrimaryKeys(long pk) {
		return getPersistence().getLecturerPrimaryKeys(pk);
	}

	/**
	* Returns all the lecturers associated with the timetable course.
	*
	* @param pk the primary key of the timetable course
	* @return the lecturers associated with the timetable course
	*/
	public static List<hu.unideb.inf.model.Lecturer> getLecturers(long pk) {
		return getPersistence().getLecturers(pk);
	}

	/**
	* Returns a range of all the lecturers associated with the timetable course.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the timetable course
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @return the range of lecturers associated with the timetable course
	*/
	public static List<hu.unideb.inf.model.Lecturer> getLecturers(long pk,
		int start, int end) {
		return getPersistence().getLecturers(pk, start, end);
	}

	/**
	* Returns an ordered range of all the lecturers associated with the timetable course.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the timetable course
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lecturers associated with the timetable course
	*/
	public static List<hu.unideb.inf.model.Lecturer> getLecturers(long pk,
		int start, int end,
		OrderByComparator<hu.unideb.inf.model.Lecturer> orderByComparator) {
		return getPersistence().getLecturers(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of lecturers associated with the timetable course.
	*
	* @param pk the primary key of the timetable course
	* @return the number of lecturers associated with the timetable course
	*/
	public static int getLecturersSize(long pk) {
		return getPersistence().getLecturersSize(pk);
	}

	/**
	* Returns <code>true</code> if the lecturer is associated with the timetable course.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPK the primary key of the lecturer
	* @return <code>true</code> if the lecturer is associated with the timetable course; <code>false</code> otherwise
	*/
	public static boolean containsLecturer(long pk, long lecturerPK) {
		return getPersistence().containsLecturer(pk, lecturerPK);
	}

	/**
	* Returns <code>true</code> if the timetable course has any lecturers associated with it.
	*
	* @param pk the primary key of the timetable course to check for associations with lecturers
	* @return <code>true</code> if the timetable course has any lecturers associated with it; <code>false</code> otherwise
	*/
	public static boolean containsLecturers(long pk) {
		return getPersistence().containsLecturers(pk);
	}

	/**
	* Adds an association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPK the primary key of the lecturer
	*/
	public static void addLecturer(long pk, long lecturerPK) {
		getPersistence().addLecturer(pk, lecturerPK);
	}

	/**
	* Adds an association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturer the lecturer
	*/
	public static void addLecturer(long pk,
		hu.unideb.inf.model.Lecturer lecturer) {
		getPersistence().addLecturer(pk, lecturer);
	}

	/**
	* Adds an association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPKs the primary keys of the lecturers
	*/
	public static void addLecturers(long pk, long[] lecturerPKs) {
		getPersistence().addLecturers(pk, lecturerPKs);
	}

	/**
	* Adds an association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturers the lecturers
	*/
	public static void addLecturers(long pk,
		List<hu.unideb.inf.model.Lecturer> lecturers) {
		getPersistence().addLecturers(pk, lecturers);
	}

	/**
	* Clears all associations between the timetable course and its lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course to clear the associated lecturers from
	*/
	public static void clearLecturers(long pk) {
		getPersistence().clearLecturers(pk);
	}

	/**
	* Removes the association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPK the primary key of the lecturer
	*/
	public static void removeLecturer(long pk, long lecturerPK) {
		getPersistence().removeLecturer(pk, lecturerPK);
	}

	/**
	* Removes the association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturer the lecturer
	*/
	public static void removeLecturer(long pk,
		hu.unideb.inf.model.Lecturer lecturer) {
		getPersistence().removeLecturer(pk, lecturer);
	}

	/**
	* Removes the association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPKs the primary keys of the lecturers
	*/
	public static void removeLecturers(long pk, long[] lecturerPKs) {
		getPersistence().removeLecturers(pk, lecturerPKs);
	}

	/**
	* Removes the association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturers the lecturers
	*/
	public static void removeLecturers(long pk,
		List<hu.unideb.inf.model.Lecturer> lecturers) {
		getPersistence().removeLecturers(pk, lecturers);
	}

	/**
	* Sets the lecturers associated with the timetable course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPKs the primary keys of the lecturers to be associated with the timetable course
	*/
	public static void setLecturers(long pk, long[] lecturerPKs) {
		getPersistence().setLecturers(pk, lecturerPKs);
	}

	/**
	* Sets the lecturers associated with the timetable course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturers the lecturers to be associated with the timetable course
	*/
	public static void setLecturers(long pk,
		List<hu.unideb.inf.model.Lecturer> lecturers) {
		getPersistence().setLecturers(pk, lecturers);
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static TimetableCoursePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TimetableCoursePersistence, TimetableCoursePersistence> _serviceTracker =
		ServiceTrackerFactory.open(TimetableCoursePersistence.class);
}