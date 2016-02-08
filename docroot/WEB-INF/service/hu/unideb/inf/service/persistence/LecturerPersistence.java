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

import com.liferay.portal.service.persistence.BasePersistence;

import hu.unideb.inf.model.Lecturer;

/**
 * The persistence interface for the lecturer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see LecturerPersistenceImpl
 * @see LecturerUtil
 * @generated
 */
public interface LecturerPersistence extends BasePersistence<Lecturer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LecturerUtil} to access the lecturer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the lecturer where lecturerName = &#63; or throws a {@link hu.unideb.inf.NoSuchLecturerException} if it could not be found.
	*
	* @param lecturerName the lecturer name
	* @return the matching lecturer
	* @throws hu.unideb.inf.NoSuchLecturerException if a matching lecturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.Lecturer findByLecturerName(
		java.lang.String lecturerName)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchLecturerException;

	/**
	* Returns the lecturer where lecturerName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param lecturerName the lecturer name
	* @return the matching lecturer, or <code>null</code> if a matching lecturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.Lecturer fetchByLecturerName(
		java.lang.String lecturerName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lecturer where lecturerName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param lecturerName the lecturer name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching lecturer, or <code>null</code> if a matching lecturer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.Lecturer fetchByLecturerName(
		java.lang.String lecturerName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the lecturer where lecturerName = &#63; from the database.
	*
	* @param lecturerName the lecturer name
	* @return the lecturer that was removed
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.Lecturer removeByLecturerName(
		java.lang.String lecturerName)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchLecturerException;

	/**
	* Returns the number of lecturers where lecturerName = &#63;.
	*
	* @param lecturerName the lecturer name
	* @return the number of matching lecturers
	* @throws SystemException if a system exception occurred
	*/
	public int countByLecturerName(java.lang.String lecturerName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the lecturer in the entity cache if it is enabled.
	*
	* @param lecturer the lecturer
	*/
	public void cacheResult(hu.unideb.inf.model.Lecturer lecturer);

	/**
	* Caches the lecturers in the entity cache if it is enabled.
	*
	* @param lecturers the lecturers
	*/
	public void cacheResult(
		java.util.List<hu.unideb.inf.model.Lecturer> lecturers);

	/**
	* Creates a new lecturer with the primary key. Does not add the lecturer to the database.
	*
	* @param lecturerId the primary key for the new lecturer
	* @return the new lecturer
	*/
	public hu.unideb.inf.model.Lecturer create(long lecturerId);

	/**
	* Removes the lecturer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer that was removed
	* @throws hu.unideb.inf.NoSuchLecturerException if a lecturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.Lecturer remove(long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchLecturerException;

	public hu.unideb.inf.model.Lecturer updateImpl(
		hu.unideb.inf.model.Lecturer lecturer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lecturer with the primary key or throws a {@link hu.unideb.inf.NoSuchLecturerException} if it could not be found.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer
	* @throws hu.unideb.inf.NoSuchLecturerException if a lecturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.Lecturer findByPrimaryKey(long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchLecturerException;

	/**
	* Returns the lecturer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer, or <code>null</code> if a lecturer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.Lecturer fetchByPrimaryKey(long lecturerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lecturers.
	*
	* @return the lecturers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.unideb.inf.model.Lecturer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.unideb.inf.model.Lecturer> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.unideb.inf.model.Lecturer> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the lecturers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lecturers.
	*
	* @return the number of lecturers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the timetable courses associated with the lecturer.
	*
	* @param pk the primary key of the lecturer
	* @return the timetable courses associated with the lecturer
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of timetable courses associated with the lecturer.
	*
	* @param pk the primary key of the lecturer
	* @return the number of timetable courses associated with the lecturer
	* @throws SystemException if a system exception occurred
	*/
	public int getTimetableCoursesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the timetable course is associated with the lecturer.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePK the primary key of the timetable course
	* @return <code>true</code> if the timetable course is associated with the lecturer; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsTimetableCourse(long pk, long timetableCoursePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the lecturer has any timetable courses associated with it.
	*
	* @param pk the primary key of the lecturer to check for associations with timetable courses
	* @return <code>true</code> if the lecturer has any timetable courses associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsTimetableCourses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePK the primary key of the timetable course
	* @throws SystemException if a system exception occurred
	*/
	public void addTimetableCourse(long pk, long timetableCoursePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCourse the timetable course
	* @throws SystemException if a system exception occurred
	*/
	public void addTimetableCourse(long pk,
		hu.unideb.inf.model.TimetableCourse timetableCourse)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePKs the primary keys of the timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public void addTimetableCourses(long pk, long[] timetableCoursePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCourses the timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public void addTimetableCourses(long pk,
		java.util.List<hu.unideb.inf.model.TimetableCourse> timetableCourses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the lecturer and its timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer to clear the associated timetable courses from
	* @throws SystemException if a system exception occurred
	*/
	public void clearTimetableCourses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePK the primary key of the timetable course
	* @throws SystemException if a system exception occurred
	*/
	public void removeTimetableCourse(long pk, long timetableCoursePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCourse the timetable course
	* @throws SystemException if a system exception occurred
	*/
	public void removeTimetableCourse(long pk,
		hu.unideb.inf.model.TimetableCourse timetableCourse)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePKs the primary keys of the timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public void removeTimetableCourses(long pk, long[] timetableCoursePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCourses the timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public void removeTimetableCourses(long pk,
		java.util.List<hu.unideb.inf.model.TimetableCourse> timetableCourses)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the timetable courses associated with the lecturer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePKs the primary keys of the timetable courses to be associated with the lecturer
	* @throws SystemException if a system exception occurred
	*/
	public void setTimetableCourses(long pk, long[] timetableCoursePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the timetable courses associated with the lecturer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCourses the timetable courses to be associated with the lecturer
	* @throws SystemException if a system exception occurred
	*/
	public void setTimetableCourses(long pk,
		java.util.List<hu.unideb.inf.model.TimetableCourse> timetableCourses)
		throws com.liferay.portal.kernel.exception.SystemException;
}