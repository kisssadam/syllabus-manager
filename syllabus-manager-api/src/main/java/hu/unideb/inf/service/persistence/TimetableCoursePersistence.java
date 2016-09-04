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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import hu.unideb.inf.exception.NoSuchTimetableCourseException;
import hu.unideb.inf.model.TimetableCourse;

/**
 * The persistence interface for the timetable course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see hu.unideb.inf.service.persistence.impl.TimetableCoursePersistenceImpl
 * @see TimetableCourseUtil
 * @generated
 */
@ProviderType
public interface TimetableCoursePersistence extends BasePersistence<TimetableCourse> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TimetableCourseUtil} to access the timetable course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the timetable courses where courseId = &#63; and semesterId = &#63;.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @return the matching timetable courses
	*/
	public java.util.List<TimetableCourse> findByC_S(long courseId,
		long semesterId);

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
	public java.util.List<TimetableCourse> findByC_S(long courseId,
		long semesterId, int start, int end);

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
	public java.util.List<TimetableCourse> findByC_S(long courseId,
		long semesterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator);

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
	public java.util.List<TimetableCourse> findByC_S(long courseId,
		long semesterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first timetable course in the ordered set where courseId = &#63; and semesterId = &#63;.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timetable course
	* @throws NoSuchTimetableCourseException if a matching timetable course could not be found
	*/
	public TimetableCourse findByC_S_First(long courseId, long semesterId,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator)
		throws NoSuchTimetableCourseException;

	/**
	* Returns the first timetable course in the ordered set where courseId = &#63; and semesterId = &#63;.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timetable course, or <code>null</code> if a matching timetable course could not be found
	*/
	public TimetableCourse fetchByC_S_First(long courseId, long semesterId,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator);

	/**
	* Returns the last timetable course in the ordered set where courseId = &#63; and semesterId = &#63;.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timetable course
	* @throws NoSuchTimetableCourseException if a matching timetable course could not be found
	*/
	public TimetableCourse findByC_S_Last(long courseId, long semesterId,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator)
		throws NoSuchTimetableCourseException;

	/**
	* Returns the last timetable course in the ordered set where courseId = &#63; and semesterId = &#63;.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timetable course, or <code>null</code> if a matching timetable course could not be found
	*/
	public TimetableCourse fetchByC_S_Last(long courseId, long semesterId,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator);

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
	public TimetableCourse[] findByC_S_PrevAndNext(long timetableCourseId,
		long courseId, long semesterId,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator)
		throws NoSuchTimetableCourseException;

	/**
	* Removes all the timetable courses where courseId = &#63; and semesterId = &#63; from the database.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	*/
	public void removeByC_S(long courseId, long semesterId);

	/**
	* Returns the number of timetable courses where courseId = &#63; and semesterId = &#63;.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @return the number of matching timetable courses
	*/
	public int countByC_S(long courseId, long semesterId);

	/**
	* Returns all the timetable courses where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the matching timetable courses
	*/
	public java.util.List<TimetableCourse> findByCourseId(long courseId);

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
	public java.util.List<TimetableCourse> findByCourseId(long courseId,
		int start, int end);

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
	public java.util.List<TimetableCourse> findByCourseId(long courseId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator);

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
	public java.util.List<TimetableCourse> findByCourseId(long courseId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first timetable course in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timetable course
	* @throws NoSuchTimetableCourseException if a matching timetable course could not be found
	*/
	public TimetableCourse findByCourseId_First(long courseId,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator)
		throws NoSuchTimetableCourseException;

	/**
	* Returns the first timetable course in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timetable course, or <code>null</code> if a matching timetable course could not be found
	*/
	public TimetableCourse fetchByCourseId_First(long courseId,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator);

	/**
	* Returns the last timetable course in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timetable course
	* @throws NoSuchTimetableCourseException if a matching timetable course could not be found
	*/
	public TimetableCourse findByCourseId_Last(long courseId,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator)
		throws NoSuchTimetableCourseException;

	/**
	* Returns the last timetable course in the ordered set where courseId = &#63;.
	*
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timetable course, or <code>null</code> if a matching timetable course could not be found
	*/
	public TimetableCourse fetchByCourseId_Last(long courseId,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator);

	/**
	* Returns the timetable courses before and after the current timetable course in the ordered set where courseId = &#63;.
	*
	* @param timetableCourseId the primary key of the current timetable course
	* @param courseId the course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timetable course
	* @throws NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	*/
	public TimetableCourse[] findByCourseId_PrevAndNext(
		long timetableCourseId, long courseId,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator)
		throws NoSuchTimetableCourseException;

	/**
	* Removes all the timetable courses where courseId = &#63; from the database.
	*
	* @param courseId the course ID
	*/
	public void removeByCourseId(long courseId);

	/**
	* Returns the number of timetable courses where courseId = &#63;.
	*
	* @param courseId the course ID
	* @return the number of matching timetable courses
	*/
	public int countByCourseId(long courseId);

	/**
	* Returns all the timetable courses where semesterId = &#63;.
	*
	* @param semesterId the semester ID
	* @return the matching timetable courses
	*/
	public java.util.List<TimetableCourse> findBySemesterId(long semesterId);

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
	public java.util.List<TimetableCourse> findBySemesterId(long semesterId,
		int start, int end);

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
	public java.util.List<TimetableCourse> findBySemesterId(long semesterId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator);

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
	public java.util.List<TimetableCourse> findBySemesterId(long semesterId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first timetable course in the ordered set where semesterId = &#63;.
	*
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timetable course
	* @throws NoSuchTimetableCourseException if a matching timetable course could not be found
	*/
	public TimetableCourse findBySemesterId_First(long semesterId,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator)
		throws NoSuchTimetableCourseException;

	/**
	* Returns the first timetable course in the ordered set where semesterId = &#63;.
	*
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timetable course, or <code>null</code> if a matching timetable course could not be found
	*/
	public TimetableCourse fetchBySemesterId_First(long semesterId,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator);

	/**
	* Returns the last timetable course in the ordered set where semesterId = &#63;.
	*
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timetable course
	* @throws NoSuchTimetableCourseException if a matching timetable course could not be found
	*/
	public TimetableCourse findBySemesterId_Last(long semesterId,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator)
		throws NoSuchTimetableCourseException;

	/**
	* Returns the last timetable course in the ordered set where semesterId = &#63;.
	*
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timetable course, or <code>null</code> if a matching timetable course could not be found
	*/
	public TimetableCourse fetchBySemesterId_Last(long semesterId,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator);

	/**
	* Returns the timetable courses before and after the current timetable course in the ordered set where semesterId = &#63;.
	*
	* @param timetableCourseId the primary key of the current timetable course
	* @param semesterId the semester ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timetable course
	* @throws NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	*/
	public TimetableCourse[] findBySemesterId_PrevAndNext(
		long timetableCourseId, long semesterId,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator)
		throws NoSuchTimetableCourseException;

	/**
	* Removes all the timetable courses where semesterId = &#63; from the database.
	*
	* @param semesterId the semester ID
	*/
	public void removeBySemesterId(long semesterId);

	/**
	* Returns the number of timetable courses where semesterId = &#63;.
	*
	* @param semesterId the semester ID
	* @return the number of matching timetable courses
	*/
	public int countBySemesterId(long semesterId);

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
	public TimetableCourse findByC_S_T_S(long courseId, long semesterId,
		java.lang.String timetableCourseCode, java.lang.String subjectType)
		throws NoSuchTimetableCourseException;

	/**
	* Returns the timetable course where courseId = &#63; and semesterId = &#63; and timetableCourseCode = &#63; and subjectType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param timetableCourseCode the timetable course code
	* @param subjectType the subject type
	* @return the matching timetable course, or <code>null</code> if a matching timetable course could not be found
	*/
	public TimetableCourse fetchByC_S_T_S(long courseId, long semesterId,
		java.lang.String timetableCourseCode, java.lang.String subjectType);

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
	public TimetableCourse fetchByC_S_T_S(long courseId, long semesterId,
		java.lang.String timetableCourseCode, java.lang.String subjectType,
		boolean retrieveFromCache);

	/**
	* Removes the timetable course where courseId = &#63; and semesterId = &#63; and timetableCourseCode = &#63; and subjectType = &#63; from the database.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param timetableCourseCode the timetable course code
	* @param subjectType the subject type
	* @return the timetable course that was removed
	*/
	public TimetableCourse removeByC_S_T_S(long courseId, long semesterId,
		java.lang.String timetableCourseCode, java.lang.String subjectType)
		throws NoSuchTimetableCourseException;

	/**
	* Returns the number of timetable courses where courseId = &#63; and semesterId = &#63; and timetableCourseCode = &#63; and subjectType = &#63;.
	*
	* @param courseId the course ID
	* @param semesterId the semester ID
	* @param timetableCourseCode the timetable course code
	* @param subjectType the subject type
	* @return the number of matching timetable courses
	*/
	public int countByC_S_T_S(long courseId, long semesterId,
		java.lang.String timetableCourseCode, java.lang.String subjectType);

	/**
	* Caches the timetable course in the entity cache if it is enabled.
	*
	* @param timetableCourse the timetable course
	*/
	public void cacheResult(TimetableCourse timetableCourse);

	/**
	* Caches the timetable courses in the entity cache if it is enabled.
	*
	* @param timetableCourses the timetable courses
	*/
	public void cacheResult(java.util.List<TimetableCourse> timetableCourses);

	/**
	* Creates a new timetable course with the primary key. Does not add the timetable course to the database.
	*
	* @param timetableCourseId the primary key for the new timetable course
	* @return the new timetable course
	*/
	public TimetableCourse create(long timetableCourseId);

	/**
	* Removes the timetable course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course that was removed
	* @throws NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	*/
	public TimetableCourse remove(long timetableCourseId)
		throws NoSuchTimetableCourseException;

	public TimetableCourse updateImpl(TimetableCourse timetableCourse);

	/**
	* Returns the timetable course with the primary key or throws a {@link NoSuchTimetableCourseException} if it could not be found.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course
	* @throws NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	*/
	public TimetableCourse findByPrimaryKey(long timetableCourseId)
		throws NoSuchTimetableCourseException;

	/**
	* Returns the timetable course with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param timetableCourseId the primary key of the timetable course
	* @return the timetable course, or <code>null</code> if a timetable course with the primary key could not be found
	*/
	public TimetableCourse fetchByPrimaryKey(long timetableCourseId);

	@Override
	public java.util.Map<java.io.Serializable, TimetableCourse> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the timetable courses.
	*
	* @return the timetable courses
	*/
	public java.util.List<TimetableCourse> findAll();

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
	public java.util.List<TimetableCourse> findAll(int start, int end);

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
	public java.util.List<TimetableCourse> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator);

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
	public java.util.List<TimetableCourse> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimetableCourse> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the timetable courses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of timetable courses.
	*
	* @return the number of timetable courses
	*/
	public int countAll();

	/**
	* Returns the primaryKeys of lecturers associated with the timetable course.
	*
	* @param pk the primary key of the timetable course
	* @return long[] of the primaryKeys of lecturers associated with the timetable course
	*/
	public long[] getLecturerPrimaryKeys(long pk);

	/**
	* Returns all the lecturers associated with the timetable course.
	*
	* @param pk the primary key of the timetable course
	* @return the lecturers associated with the timetable course
	*/
	public java.util.List<hu.unideb.inf.model.Lecturer> getLecturers(long pk);

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
	public java.util.List<hu.unideb.inf.model.Lecturer> getLecturers(long pk,
		int start, int end);

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
	public java.util.List<hu.unideb.inf.model.Lecturer> getLecturers(long pk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<hu.unideb.inf.model.Lecturer> orderByComparator);

	/**
	* Returns the number of lecturers associated with the timetable course.
	*
	* @param pk the primary key of the timetable course
	* @return the number of lecturers associated with the timetable course
	*/
	public int getLecturersSize(long pk);

	/**
	* Returns <code>true</code> if the lecturer is associated with the timetable course.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPK the primary key of the lecturer
	* @return <code>true</code> if the lecturer is associated with the timetable course; <code>false</code> otherwise
	*/
	public boolean containsLecturer(long pk, long lecturerPK);

	/**
	* Returns <code>true</code> if the timetable course has any lecturers associated with it.
	*
	* @param pk the primary key of the timetable course to check for associations with lecturers
	* @return <code>true</code> if the timetable course has any lecturers associated with it; <code>false</code> otherwise
	*/
	public boolean containsLecturers(long pk);

	/**
	* Adds an association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPK the primary key of the lecturer
	*/
	public void addLecturer(long pk, long lecturerPK);

	/**
	* Adds an association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturer the lecturer
	*/
	public void addLecturer(long pk, hu.unideb.inf.model.Lecturer lecturer);

	/**
	* Adds an association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPKs the primary keys of the lecturers
	*/
	public void addLecturers(long pk, long[] lecturerPKs);

	/**
	* Adds an association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturers the lecturers
	*/
	public void addLecturers(long pk,
		java.util.List<hu.unideb.inf.model.Lecturer> lecturers);

	/**
	* Clears all associations between the timetable course and its lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course to clear the associated lecturers from
	*/
	public void clearLecturers(long pk);

	/**
	* Removes the association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPK the primary key of the lecturer
	*/
	public void removeLecturer(long pk, long lecturerPK);

	/**
	* Removes the association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturer the lecturer
	*/
	public void removeLecturer(long pk, hu.unideb.inf.model.Lecturer lecturer);

	/**
	* Removes the association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPKs the primary keys of the lecturers
	*/
	public void removeLecturers(long pk, long[] lecturerPKs);

	/**
	* Removes the association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturers the lecturers
	*/
	public void removeLecturers(long pk,
		java.util.List<hu.unideb.inf.model.Lecturer> lecturers);

	/**
	* Sets the lecturers associated with the timetable course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturerPKs the primary keys of the lecturers to be associated with the timetable course
	*/
	public void setLecturers(long pk, long[] lecturerPKs);

	/**
	* Sets the lecturers associated with the timetable course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the timetable course
	* @param lecturers the lecturers to be associated with the timetable course
	*/
	public void setLecturers(long pk,
		java.util.List<hu.unideb.inf.model.Lecturer> lecturers);

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}