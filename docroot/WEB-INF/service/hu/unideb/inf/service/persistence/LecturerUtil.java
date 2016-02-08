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

import hu.unideb.inf.model.Lecturer;

import java.util.List;

/**
 * The persistence utility for the lecturer service. This utility wraps {@link LecturerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see LecturerPersistence
 * @see LecturerPersistenceImpl
 * @generated
 */
public class LecturerUtil {
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
	public static void clearCache(Lecturer lecturer) {
		getPersistence().clearCache(lecturer);
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
	public static List<Lecturer> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Lecturer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Lecturer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Lecturer update(Lecturer lecturer) throws SystemException {
		return getPersistence().update(lecturer);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Lecturer update(Lecturer lecturer,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(lecturer, serviceContext);
	}

	/**
	* Returns the lecturer where lecturerName = &#63; or throws a {@link hu.unideb.inf.NoSuchLecturerException} if it could not be found.
	*
	* @param lecturerName the lecturer name
	* @return the matching lecturer
	* @throws hu.unideb.inf.NoSuchLecturerException if a matching lecturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Lecturer findByLecturerName(
		java.lang.String lecturerName)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchLecturerException {
		return getPersistence().findByLecturerName(lecturerName);
	}

	/**
	* Returns the lecturer where lecturerName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param lecturerName the lecturer name
	* @return the matching lecturer, or <code>null</code> if a matching lecturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Lecturer fetchByLecturerName(
		java.lang.String lecturerName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLecturerName(lecturerName);
	}

	/**
	* Returns the lecturer where lecturerName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param lecturerName the lecturer name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching lecturer, or <code>null</code> if a matching lecturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Lecturer fetchByLecturerName(
		java.lang.String lecturerName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLecturerName(lecturerName, retrieveFromCache);
	}

	/**
	* Removes the lecturer where lecturerName = &#63; from the database.
	*
	* @param lecturerName the lecturer name
	* @return the lecturer that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Lecturer removeByLecturerName(
		java.lang.String lecturerName)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchLecturerException {
		return getPersistence().removeByLecturerName(lecturerName);
	}

	/**
	* Returns the number of lecturers where lecturerName = &#63;.
	*
	* @param lecturerName the lecturer name
	* @return the number of matching lecturers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLecturerName(java.lang.String lecturerName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLecturerName(lecturerName);
	}

	/**
	* Caches the lecturer in the entity cache if it is enabled.
	*
	* @param lecturer the lecturer
	*/
	public static void cacheResult(hu.unideb.inf.model.Lecturer lecturer) {
		getPersistence().cacheResult(lecturer);
	}

	/**
	* Caches the lecturers in the entity cache if it is enabled.
	*
	* @param lecturers the lecturers
	*/
	public static void cacheResult(
		java.util.List<hu.unideb.inf.model.Lecturer> lecturers) {
		getPersistence().cacheResult(lecturers);
	}

	/**
	* Creates a new lecturer with the primary key. Does not add the lecturer to the database.
	*
	* @param lecturerId the primary key for the new lecturer
	* @return the new lecturer
	*/
	public static hu.unideb.inf.model.Lecturer create(long lecturerId) {
		return getPersistence().create(lecturerId);
	}

	/**
	* Removes the lecturer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer that was removed
	* @throws hu.unideb.inf.NoSuchLecturerException if a lecturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Lecturer remove(long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchLecturerException {
		return getPersistence().remove(lecturerId);
	}

	public static hu.unideb.inf.model.Lecturer updateImpl(
		hu.unideb.inf.model.Lecturer lecturer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(lecturer);
	}

	/**
	* Returns the lecturer with the primary key or throws a {@link hu.unideb.inf.NoSuchLecturerException} if it could not be found.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer
	* @throws hu.unideb.inf.NoSuchLecturerException if a lecturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Lecturer findByPrimaryKey(long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchLecturerException {
		return getPersistence().findByPrimaryKey(lecturerId);
	}

	/**
	* Returns the lecturer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer, or <code>null</code> if a lecturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Lecturer fetchByPrimaryKey(
		long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(lecturerId);
	}

	/**
	* Returns all the lecturers.
	*
	* @return the lecturers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Lecturer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Lecturer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the lecturers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lecturers
	* @param end the upper bound of the range of lecturers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lecturers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Lecturer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the lecturers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lecturers.
	*
	* @return the number of lecturers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the timetable courses associated with the lecturer.
	*
	* @param pk the primary key of the lecturer
	* @return the timetable courses associated with the lecturer
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getTimetableCourses(pk);
	}

	/**
	* Returns a range of all the timetable courses associated with the lecturer.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the lecturer
	* @param start the lower bound of the range of lecturers
	* @param end the upper bound of the range of lecturers (not inclusive)
	* @return the range of timetable courses associated with the lecturer
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getTimetableCourses(pk, start, end);
	}

	/**
	* Returns an ordered range of all the timetable courses associated with the lecturer.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the lecturer
	* @param start the lower bound of the range of lecturers
	* @param end the upper bound of the range of lecturers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of timetable courses associated with the lecturer
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .getTimetableCourses(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of timetable courses associated with the lecturer.
	*
	* @param pk the primary key of the lecturer
	* @return the number of timetable courses associated with the lecturer
	* @throws SystemException if a system exception occurred
	*/
	public static int getTimetableCoursesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getTimetableCoursesSize(pk);
	}

	/**
	* Returns <code>true</code> if the timetable course is associated with the lecturer.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePK the primary key of the timetable course
	* @return <code>true</code> if the timetable course is associated with the lecturer; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsTimetableCourse(long pk,
		long timetableCoursePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsTimetableCourse(pk, timetableCoursePK);
	}

	/**
	* Returns <code>true</code> if the lecturer has any timetable courses associated with it.
	*
	* @param pk the primary key of the lecturer to check for associations with timetable courses
	* @return <code>true</code> if the lecturer has any timetable courses associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsTimetableCourses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsTimetableCourses(pk);
	}

	/**
	* Adds an association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePK the primary key of the timetable course
	* @throws SystemException if a system exception occurred
	*/
	public static void addTimetableCourse(long pk, long timetableCoursePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addTimetableCourse(pk, timetableCoursePK);
	}

	/**
	* Adds an association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCourse the timetable course
	* @throws SystemException if a system exception occurred
	*/
	public static void addTimetableCourse(long pk,
		hu.unideb.inf.model.TimetableCourse timetableCourse)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addTimetableCourse(pk, timetableCourse);
	}

	/**
	* Adds an association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePKs the primary keys of the timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static void addTimetableCourses(long pk, long[] timetableCoursePKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addTimetableCourses(pk, timetableCoursePKs);
	}

	/**
	* Adds an association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCourses the timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static void addTimetableCourses(long pk,
		java.util.List<hu.unideb.inf.model.TimetableCourse> timetableCourses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addTimetableCourses(pk, timetableCourses);
	}

	/**
	* Clears all associations between the lecturer and its timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer to clear the associated timetable courses from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearTimetableCourses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearTimetableCourses(pk);
	}

	/**
	* Removes the association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePK the primary key of the timetable course
	* @throws SystemException if a system exception occurred
	*/
	public static void removeTimetableCourse(long pk, long timetableCoursePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeTimetableCourse(pk, timetableCoursePK);
	}

	/**
	* Removes the association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCourse the timetable course
	* @throws SystemException if a system exception occurred
	*/
	public static void removeTimetableCourse(long pk,
		hu.unideb.inf.model.TimetableCourse timetableCourse)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeTimetableCourse(pk, timetableCourse);
	}

	/**
	* Removes the association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePKs the primary keys of the timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static void removeTimetableCourses(long pk, long[] timetableCoursePKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeTimetableCourses(pk, timetableCoursePKs);
	}

	/**
	* Removes the association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCourses the timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public static void removeTimetableCourses(long pk,
		java.util.List<hu.unideb.inf.model.TimetableCourse> timetableCourses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeTimetableCourses(pk, timetableCourses);
	}

	/**
	* Sets the timetable courses associated with the lecturer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePKs the primary keys of the timetable courses to be associated with the lecturer
	* @throws SystemException if a system exception occurred
	*/
	public static void setTimetableCourses(long pk, long[] timetableCoursePKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setTimetableCourses(pk, timetableCoursePKs);
	}

	/**
	* Sets the timetable courses associated with the lecturer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCourses the timetable courses to be associated with the lecturer
	* @throws SystemException if a system exception occurred
	*/
	public static void setTimetableCourses(long pk,
		java.util.List<hu.unideb.inf.model.TimetableCourse> timetableCourses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setTimetableCourses(pk, timetableCourses);
	}

	public static LecturerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LecturerPersistence)PortletBeanLocatorUtil.locate(hu.unideb.inf.service.ClpSerializer.getServletContextName(),
					LecturerPersistence.class.getName());

			ReferenceRegistry.registerReference(LecturerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LecturerPersistence persistence) {
	}

	private static LecturerPersistence _persistence;
}