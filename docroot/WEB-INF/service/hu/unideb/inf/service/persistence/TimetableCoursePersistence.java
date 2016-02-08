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

import hu.unideb.inf.model.TimetableCourse;

/**
 * The persistence interface for the timetable course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see TimetableCoursePersistenceImpl
 * @see TimetableCourseUtil
 * @generated
 */
public interface TimetableCoursePersistence extends BasePersistence<TimetableCourse> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TimetableCourseUtil} to access the timetable course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the timetable course where timetableCourseCode = &#63; or throws a {@link hu.unideb.inf.NoSuchTimetableCourseException} if it could not be found.
	*
	* @param timetableCourseCode the timetable course code
	* @return the matching timetable course
	* @throws hu.unideb.inf.NoSuchTimetableCourseException if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.TimetableCourse findByTimetableCourseCode(
		java.lang.String timetableCourseCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException;

	/**
	* Returns the timetable course where timetableCourseCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param timetableCourseCode the timetable course code
	* @return the matching timetable course, or <code>null</code> if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.TimetableCourse fetchByTimetableCourseCode(
		java.lang.String timetableCourseCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the timetable course where timetableCourseCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param timetableCourseCode the timetable course code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching timetable course, or <code>null</code> if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.TimetableCourse fetchByTimetableCourseCode(
		java.lang.String timetableCourseCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the timetable course where timetableCourseCode = &#63; from the database.
	*
	* @param timetableCourseCode the timetable course code
	* @return the timetable course that was removed
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.TimetableCourse removeByTimetableCourseCode(
		java.lang.String timetableCourseCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException;

	/**
	* Returns the number of timetable courses where timetableCourseCode = &#63;.
	*
	* @param timetableCourseCode the timetable course code
	* @return the number of matching timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public int countByTimetableCourseCode(java.lang.String timetableCourseCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the timetable course where courseId = &#63; and semesterId = &#63; or throws a {@link hu.unideb.inf.NoSuchTimetableCourseException} if it could not be found.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @return the matching timetable course
	* @throws hu.unideb.inf.NoSuchTimetableCourseException if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.TimetableCourse findByC_S(long courseId,
		long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException;

	/**
	* Returns the timetable course where courseId = &#63; and semesterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @return the matching timetable course, or <code>null</code> if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.TimetableCourse fetchByC_S(long courseId,
		long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the timetable course where courseId = &#63; and semesterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching timetable course, or <code>null</code> if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.TimetableCourse fetchByC_S(long courseId,
		long semesterId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the timetable course where courseId = &#63; and semesterId = &#63; from the database.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @return the timetable course that was removed
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.TimetableCourse removeByC_S(long courseId,
		long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException;

	/**
	* Returns the number of timetable courses where courseId = &#63; and semesterId = &#63;.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @return the number of matching timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_S(long courseId, long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the timetable courses where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the matching timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.unideb.inf.model.TimetableCourse> findByCourseId(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.unideb.inf.model.TimetableCourse> findByCourseId(
		long courseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.unideb.inf.model.TimetableCourse> findByCourseId(
		long courseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first timetable course in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timetable course
	* @throws hu.unideb.inf.NoSuchTimetableCourseException if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.TimetableCourse findByCourseId_First(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException;

	/**
	* Returns the first timetable course in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timetable course, or <code>null</code> if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.TimetableCourse fetchByCourseId_First(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last timetable course in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timetable course
	* @throws hu.unideb.inf.NoSuchTimetableCourseException if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.TimetableCourse findByCourseId_Last(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException;

	/**
	* Returns the last timetable course in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timetable course, or <code>null</code> if a matching timetable course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.TimetableCourse fetchByCourseId_Last(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.unideb.inf.model.TimetableCourse[] findByCourseId_PrevAndNext(
		long timetableCourseId, long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException;

	/**
	* Removes all the timetable courses where courseId = &#63; from the database.
	*
	* @param courseId the course ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCourseId(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of timetable courses where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the number of matching timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourseId(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the timetable course in the entity cache if it is enabled.
	*
	* @param timetableCourse the timetable course
	*/
	public void cacheResult(hu.unideb.inf.model.TimetableCourse timetableCourse);

	/**
	* Caches the timetable courses in the entity cache if it is enabled.
	*
	* @param timetableCourses the timetable courses
	*/
	public void cacheResult(
		java.util.List<hu.unideb.inf.model.TimetableCourse> timetableCourses);

	/**
	* Creates a new timetable course with the primary key. Does not add the timetable course to the database.
	*
	* @param timetableCourseId the primary key for the new timetable course
	* @return the new timetable course
	*/
	public hu.unideb.inf.model.TimetableCourse create(long timetableCourseId);

	/**
	* Removes the timetable course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course that was removed
	* @throws hu.unideb.inf.NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.TimetableCourse remove(long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException;

	public hu.unideb.inf.model.TimetableCourse updateImpl(
		hu.unideb.inf.model.TimetableCourse timetableCourse)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the timetable course with the primary key or throws a {@link hu.unideb.inf.NoSuchTimetableCourseException} if it could not be found.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course
	* @throws hu.unideb.inf.NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.TimetableCourse findByPrimaryKey(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchTimetableCourseException;

	/**
	* Returns the timetable course with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course, or <code>null</code> if a timetable course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.TimetableCourse fetchByPrimaryKey(
		long timetableCourseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the timetable courses.
	*
	* @return the timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.unideb.inf.model.TimetableCourse> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.unideb.inf.model.TimetableCourse> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.unideb.inf.model.TimetableCourse> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the timetable courses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of timetable courses.
	*
	* @return the number of timetable courses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lecturers associated with the timetable course.
	*
	* @param pk the primary key of the timetable course
	* @return the lecturers associated with the timetable course
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.unideb.inf.model.Lecturer> getLecturers(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.unideb.inf.model.Lecturer> getLecturers(long pk,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.unideb.inf.model.Lecturer> getLecturers(long pk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lecturers associated with the timetable course.
	*
	* @param pk the primary key of the timetable course
	* @return the number of lecturers associated with the timetable course
	* @throws SystemException if a system exception occurred
	*/
	public int getLecturersSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the lecturer is associated with the timetable course.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPK the primary key of the lecturer
	* @return <code>true</code> if the lecturer is associated with the timetable course; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsLecturer(long pk, long lecturerPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the timetable course has any lecturers associated with it.
	*
	* @param pk the primary key of the timetable course to check for associations with lecturers
	* @return <code>true</code> if the timetable course has any lecturers associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsLecturers(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPK the primary key of the lecturer
	* @throws SystemException if a system exception occurred
	*/
	public void addLecturer(long pk, long lecturerPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturer the lecturer
	* @throws SystemException if a system exception occurred
	*/
	public void addLecturer(long pk, hu.unideb.inf.model.Lecturer lecturer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPKs the primary keys of the lecturers
	* @throws SystemException if a system exception occurred
	*/
	public void addLecturers(long pk, long[] lecturerPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturers the lecturers
	* @throws SystemException if a system exception occurred
	*/
	public void addLecturers(long pk,
		java.util.List<hu.unideb.inf.model.Lecturer> lecturers)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the timetable course and its lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course to clear the associated lecturers from
	* @throws SystemException if a system exception occurred
	*/
	public void clearLecturers(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPK the primary key of the lecturer
	* @throws SystemException if a system exception occurred
	*/
	public void removeLecturer(long pk, long lecturerPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturer the lecturer
	* @throws SystemException if a system exception occurred
	*/
	public void removeLecturer(long pk, hu.unideb.inf.model.Lecturer lecturer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPKs the primary keys of the lecturers
	* @throws SystemException if a system exception occurred
	*/
	public void removeLecturers(long pk, long[] lecturerPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturers the lecturers
	* @throws SystemException if a system exception occurred
	*/
	public void removeLecturers(long pk,
		java.util.List<hu.unideb.inf.model.Lecturer> lecturers)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the lecturers associated with the timetable course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPKs the primary keys of the lecturers to be associated with the timetable course
	* @throws SystemException if a system exception occurred
	*/
	public void setLecturers(long pk, long[] lecturerPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the lecturers associated with the timetable course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturers the lecturers to be associated with the timetable course
	* @throws SystemException if a system exception occurred
	*/
	public void setLecturers(long pk,
		java.util.List<hu.unideb.inf.model.Lecturer> lecturers)
		throws com.liferay.portal.kernel.exception.SystemException;
}