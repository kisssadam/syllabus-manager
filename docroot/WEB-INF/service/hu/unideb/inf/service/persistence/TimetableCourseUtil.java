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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import hu.unideb.inf.model.TimetableCourse;

import java.util.List;

/**
 * The persistence utility for the timetable course service. This utility wraps {@link TimetableCoursePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see TimetableCoursePersistence
 * @see TimetableCoursePersistenceImpl
 * @generated
 */
public class TimetableCourseUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(TimetableCourse timetableCourse) {
		getPersistence().clearCache(timetableCourse);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TimetableCourse> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TimetableCourse> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TimetableCourse> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TimetableCourse update(TimetableCourse timetableCourse)
		throws SystemException {
		return getPersistence().update(timetableCourse);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TimetableCourse update(TimetableCourse timetableCourse,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(timetableCourse, serviceContext);
	}

	/**
	* Returns the timetable course where timetableCourseCode = &#63; or throws a {@link hu.unideb.inf.NoSuchTimetableCourseException} if it could not be found.
	*
	* @param timetableCourseCode the timetable course code
	* @return the matching timetable course
	* @throws hu.unideb.inf.NoSuchTimetableCourseException if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse findByTimetableCourseCode(
		java.lang.String timetableCourseCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException {
		return getPersistence().findByTimetableCourseCode(timetableCourseCode);
	}

	/**
	* Returns the timetable course where timetableCourseCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param timetableCourseCode the timetable course code
	* @return the matching timetable course, or <code>null</code> if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse fetchByTimetableCourseCode(
		java.lang.String timetableCourseCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTimetableCourseCode(timetableCourseCode);
	}

	/**
	* Returns the timetable course where timetableCourseCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param timetableCourseCode the timetable course code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching timetable course, or <code>null</code> if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse fetchByTimetableCourseCode(
		java.lang.String timetableCourseCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTimetableCourseCode(timetableCourseCode,
			retrieveFromCache);
	}

	/**
	* Removes the timetable course where timetableCourseCode = &#63; from the database.
	*
	* @param timetableCourseCode the timetable course code
	* @return the timetable course that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse removeByTimetableCourseCode(
		java.lang.String timetableCourseCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException {
		return getPersistence().removeByTimetableCourseCode(timetableCourseCode);
	}

	/**
	* Returns the number of timetable courses where timetableCourseCode = &#63;.
	*
	* @param timetableCourseCode the timetable course code
	* @return the number of matching timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTimetableCourseCode(
		java.lang.String timetableCourseCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTimetableCourseCode(timetableCourseCode);
	}

	/**
	* Returns all the timetable courses where courseId = &#63; and semesterId = &#63;.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @return the matching timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.TimetableCourse> findByC_S(
		long courseId, long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_S(courseId, semesterId);
	}

	/**
	* Returns a range of all the timetable courses where courseId = &#63; and semesterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @return the range of matching timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.TimetableCourse> findByC_S(
		long courseId, long semesterId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_S(courseId, semesterId, start, end);
	}

	/**
	* Returns an ordered range of all the timetable courses where courseId = &#63; and semesterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.TimetableCourse> findByC_S(
		long courseId, long semesterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_S(courseId, semesterId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first timetable course in the ordered set where courseId = &#63; and semesterId = &#63;.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timetable course
	* @throws hu.unideb.inf.NoSuchTimetableCourseException if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse findByC_S_First(
		long courseId, long semesterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException {
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
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse fetchByC_S_First(
		long courseId, long semesterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
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
	* @throws hu.unideb.inf.NoSuchTimetableCourseException if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse findByC_S_Last(
		long courseId, long semesterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException {
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
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse fetchByC_S_Last(
		long courseId, long semesterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
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
	* @throws hu.unideb.inf.NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse[] findByC_S_PrevAndNext(
		long timetableCourseId, long courseId, long semesterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException {
		return getPersistence()
				   .findByC_S_PrevAndNext(timetableCourseId, courseId,
			semesterId, orderByComparator);
	}

	/**
	* Removes all the timetable courses where courseId = &#63; and semesterId = &#63; from the database.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_S(long courseId, long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_S(courseId, semesterId);
	}

	/**
	* Returns the number of timetable courses where courseId = &#63; and semesterId = &#63;.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @return the number of matching timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_S(long courseId, long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_S(courseId, semesterId);
	}

	/**
	* Returns all the timetable courses where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the matching timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.TimetableCourse> findByCourseId(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseId(courseId);
	}

	/**
	* Returns a range of all the timetable courses where courseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @return the range of matching timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.TimetableCourse> findByCourseId(
		long courseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseId(courseId, start, end);
	}

	/**
	* Returns an ordered range of all the timetable courses where courseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseId the course ID
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.TimetableCourse> findByCourseId(
		long courseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseId(courseId, start, end, orderByComparator);
	}

	/**
	* Returns the first timetable course in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timetable course
	* @throws hu.unideb.inf.NoSuchTimetableCourseException if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse findByCourseId_First(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException {
		return getPersistence().findByCourseId_First(courseId, orderByComparator);
	}

	/**
	* Returns the first timetable course in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timetable course, or <code>null</code> if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse fetchByCourseId_First(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseId_First(courseId, orderByComparator);
	}

	/**
	* Returns the last timetable course in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timetable course
	* @throws hu.unideb.inf.NoSuchTimetableCourseException if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse findByCourseId_Last(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException {
		return getPersistence().findByCourseId_Last(courseId, orderByComparator);
	}

	/**
	* Returns the last timetable course in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timetable course, or <code>null</code> if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse fetchByCourseId_Last(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCourseId_Last(courseId, orderByComparator);
	}

	/**
	* Returns the timetable courses before and after the current timetable course in the ordered set where courseId = &#63;.
	*
	* @param timetableCourseId the primary key of the current timetable course
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timetable course
	* @throws hu.unideb.inf.NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse[] findByCourseId_PrevAndNext(
		long timetableCourseId, long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException {
		return getPersistence()
				   .findByCourseId_PrevAndNext(timetableCourseId, courseId,
			orderByComparator);
	}

	/**
	* Removes all the timetable courses where courseId = &#63; from the database.
	*
	* @param courseId the course ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCourseId(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCourseId(courseId);
	}

	/**
	* Returns the number of timetable courses where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the number of matching timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourseId(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCourseId(courseId);
	}

	/**
	* Returns all the timetable courses where semesterId = &#63;.
	*
	* @param semesterId the semester ID
	* @return the matching timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.TimetableCourse> findBySemesterId(
		long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySemesterId(semesterId);
	}

	/**
	* Returns a range of all the timetable courses where semesterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param semesterId the semester ID
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @return the range of matching timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.TimetableCourse> findBySemesterId(
		long semesterId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySemesterId(semesterId, start, end);
	}

	/**
	* Returns an ordered range of all the timetable courses where semesterId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param semesterId the semester ID
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.TimetableCourse> findBySemesterId(
		long semesterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySemesterId(semesterId, start, end, orderByComparator);
	}

	/**
	* Returns the first timetable course in the ordered set where semesterId = &#63;.
	*
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timetable course
	* @throws hu.unideb.inf.NoSuchTimetableCourseException if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse findBySemesterId_First(
		long semesterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException {
		return getPersistence()
				   .findBySemesterId_First(semesterId, orderByComparator);
	}

	/**
	* Returns the first timetable course in the ordered set where semesterId = &#63;.
	*
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timetable course, or <code>null</code> if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse fetchBySemesterId_First(
		long semesterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySemesterId_First(semesterId, orderByComparator);
	}

	/**
	* Returns the last timetable course in the ordered set where semesterId = &#63;.
	*
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timetable course
	* @throws hu.unideb.inf.NoSuchTimetableCourseException if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse findBySemesterId_Last(
		long semesterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException {
		return getPersistence()
				   .findBySemesterId_Last(semesterId, orderByComparator);
	}

	/**
	* Returns the last timetable course in the ordered set where semesterId = &#63;.
	*
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timetable course, or <code>null</code> if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse fetchBySemesterId_Last(
		long semesterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
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
	* @throws hu.unideb.inf.NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse[] findBySemesterId_PrevAndNext(
		long timetableCourseId, long semesterId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException {
		return getPersistence()
				   .findBySemesterId_PrevAndNext(timetableCourseId, semesterId,
			orderByComparator);
	}

	/**
	* Removes all the timetable courses where semesterId = &#63; from the database.
	*
	* @param semesterId the semester ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySemesterId(long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySemesterId(semesterId);
	}

	/**
	* Returns the number of timetable courses where semesterId = &#63;.
	*
	* @param semesterId the semester ID
	* @return the number of matching timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySemesterId(long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySemesterId(semesterId);
	}

	/**
	* Caches the timetable course in the entity cache if it is enabled.
	*
	* @param timetableCourse the timetable course
	*/
	public static void cacheResult(
		hu.unideb.inf.model.TimetableCourse timetableCourse) {
		getPersistence().cacheResult(timetableCourse);
	}

	/**
	* Caches the timetable courses in the entity cache if it is enabled.
	*
	* @param timetableCourses the timetable courses
	*/
	public static void cacheResult(
		java.util.List<hu.unideb.inf.model.TimetableCourse> timetableCourses) {
		getPersistence().cacheResult(timetableCourses);
	}

	/**
	* Creates a new timetable course with the primary key. Does not add the timetable course to the database.
	*
	* @param timetableCourseId the primary key for the new timetable course
	* @return the new timetable course
	*/
	public static hu.unideb.inf.model.TimetableCourse create(
		long timetableCourseId) {
		return getPersistence().create(timetableCourseId);
	}

	/**
	* Removes the timetable course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course that was removed
	* @throws hu.unideb.inf.NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse remove(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException {
		return getPersistence().remove(timetableCourseId);
	}

	public static hu.unideb.inf.model.TimetableCourse updateImpl(
		hu.unideb.inf.model.TimetableCourse timetableCourse)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(timetableCourse);
	}

	/**
	* Returns the timetable course with the primary key or throws a {@link hu.unideb.inf.NoSuchTimetableCourseException} if it could not be found.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course
	* @throws hu.unideb.inf.NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse findByPrimaryKey(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException {
		return getPersistence().findByPrimaryKey(timetableCourseId);
	}

	/**
	* Returns the timetable course with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course, or <code>null</code> if a timetable course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.TimetableCourse fetchByPrimaryKey(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(timetableCourseId);
	}

	/**
	* Returns all the timetable courses.
	*
	* @return the timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.TimetableCourse> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.TimetableCourse> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the timetable courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.TimetableCourse> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the timetable courses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of timetable courses.
	*
	* @return the number of timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the lecturers associated with the timetable course.
	*
	* @param pk the primary key of the timetable course
	* @return the lecturers associated with the timetable course
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Lecturer> getLecturers(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getLecturers(pk);
	}

	/**
	* Returns a range of all the lecturers associated with the timetable course.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the timetable course
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @return the range of lecturers associated with the timetable course
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Lecturer> getLecturers(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getLecturers(pk, start, end);
	}

	/**
	* Returns an ordered range of all the lecturers associated with the timetable course.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the timetable course
	* @param start the lower bound of the range of timetable courses
	* @param end the upper bound of the range of timetable courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lecturers associated with the timetable course
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Lecturer> getLecturers(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getLecturers(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of lecturers associated with the timetable course.
	*
	* @param pk the primary key of the timetable course
	* @return the number of lecturers associated with the timetable course
	* @throws SystemException if a system exception occurred
	*/
	public static int getLecturersSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getLecturersSize(pk);
	}

	/**
	* Returns <code>true</code> if the lecturer is associated with the timetable course.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPK the primary key of the lecturer
	* @return <code>true</code> if the lecturer is associated with the timetable course; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsLecturer(long pk, long lecturerPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsLecturer(pk, lecturerPK);
	}

	/**
	* Returns <code>true</code> if the timetable course has any lecturers associated with it.
	*
	* @param pk the primary key of the timetable course to check for associations with lecturers
	* @return <code>true</code> if the timetable course has any lecturers associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsLecturers(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsLecturers(pk);
	}

	/**
	* Adds an association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPK the primary key of the lecturer
	* @throws SystemException if a system exception occurred
	*/
	public static void addLecturer(long pk, long lecturerPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addLecturer(pk, lecturerPK);
	}

	/**
	* Adds an association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturer the lecturer
	* @throws SystemException if a system exception occurred
	*/
	public static void addLecturer(long pk,
		hu.unideb.inf.model.Lecturer lecturer)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addLecturer(pk, lecturer);
	}

	/**
	* Adds an association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPKs the primary keys of the lecturers
	* @throws SystemException if a system exception occurred
	*/
	public static void addLecturers(long pk, long[] lecturerPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addLecturers(pk, lecturerPKs);
	}

	/**
	* Adds an association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturers the lecturers
	* @throws SystemException if a system exception occurred
	*/
	public static void addLecturers(long pk,
		java.util.List<hu.unideb.inf.model.Lecturer> lecturers)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addLecturers(pk, lecturers);
	}

	/**
	* Clears all associations between the timetable course and its lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course to clear the associated lecturers from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearLecturers(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearLecturers(pk);
	}

	/**
	* Removes the association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPK the primary key of the lecturer
	* @throws SystemException if a system exception occurred
	*/
	public static void removeLecturer(long pk, long lecturerPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeLecturer(pk, lecturerPK);
	}

	/**
	* Removes the association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturer the lecturer
	* @throws SystemException if a system exception occurred
	*/
	public static void removeLecturer(long pk,
		hu.unideb.inf.model.Lecturer lecturer)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeLecturer(pk, lecturer);
	}

	/**
	* Removes the association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPKs the primary keys of the lecturers
	* @throws SystemException if a system exception occurred
	*/
	public static void removeLecturers(long pk, long[] lecturerPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeLecturers(pk, lecturerPKs);
	}

	/**
	* Removes the association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturers the lecturers
	* @throws SystemException if a system exception occurred
	*/
	public static void removeLecturers(long pk,
		java.util.List<hu.unideb.inf.model.Lecturer> lecturers)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeLecturers(pk, lecturers);
	}

	/**
	* Sets the lecturers associated with the timetable course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPKs the primary keys of the lecturers to be associated with the timetable course
	* @throws SystemException if a system exception occurred
	*/
	public static void setLecturers(long pk, long[] lecturerPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setLecturers(pk, lecturerPKs);
	}

	/**
	* Sets the lecturers associated with the timetable course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturers the lecturers to be associated with the timetable course
	* @throws SystemException if a system exception occurred
	*/
	public static void setLecturers(long pk,
		java.util.List<hu.unideb.inf.model.Lecturer> lecturers)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setLecturers(pk, lecturers);
	}

	public static TimetableCoursePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TimetableCoursePersistence)PortletBeanLocatorUtil.locate(hu.unideb.inf.service.ClpSerializer.getServletContextName(),
					TimetableCoursePersistence.class.getName());

			ReferenceRegistry.registerReference(TimetableCourseUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TimetableCoursePersistence persistence) {
	}

	private static TimetableCoursePersistence _persistence;
}