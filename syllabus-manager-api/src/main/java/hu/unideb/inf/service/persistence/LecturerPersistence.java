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

import hu.unideb.inf.exception.NoSuchLecturerException;
import hu.unideb.inf.model.Lecturer;

/**
 * The persistence interface for the lecturer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see hu.unideb.inf.service.persistence.impl.LecturerPersistenceImpl
 * @see LecturerUtil
 * @generated
 */
@ProviderType
public interface LecturerPersistence extends BasePersistence<Lecturer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LecturerUtil} to access the lecturer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the lecturer where lecturerName = &#63; and lecturerUserId = &#63; or throws a {@link NoSuchLecturerException} if it could not be found.
	*
	* @param lecturerName the lecturer name
	* @param lecturerUserId the lecturer user ID
	* @return the matching lecturer
	* @throws NoSuchLecturerException if a matching lecturer could not be found
	*/
	public Lecturer findByN_U(java.lang.String lecturerName, long lecturerUserId)
		throws NoSuchLecturerException;

	/**
	* Returns the lecturer where lecturerName = &#63; and lecturerUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param lecturerName the lecturer name
	* @param lecturerUserId the lecturer user ID
	* @return the matching lecturer, or <code>null</code> if a matching lecturer could not be found
	*/
	public Lecturer fetchByN_U(java.lang.String lecturerName,
		long lecturerUserId);

	/**
	* Returns the lecturer where lecturerName = &#63; and lecturerUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param lecturerName the lecturer name
	* @param lecturerUserId the lecturer user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching lecturer, or <code>null</code> if a matching lecturer could not be found
	*/
	public Lecturer fetchByN_U(java.lang.String lecturerName,
		long lecturerUserId, boolean retrieveFromCache);

	/**
	* Removes the lecturer where lecturerName = &#63; and lecturerUserId = &#63; from the database.
	*
	* @param lecturerName the lecturer name
	* @param lecturerUserId the lecturer user ID
	* @return the lecturer that was removed
	*/
	public Lecturer removeByN_U(java.lang.String lecturerName,
		long lecturerUserId) throws NoSuchLecturerException;

	/**
	* Returns the number of lecturers where lecturerName = &#63; and lecturerUserId = &#63;.
	*
	* @param lecturerName the lecturer name
	* @param lecturerUserId the lecturer user ID
	* @return the number of matching lecturers
	*/
	public int countByN_U(java.lang.String lecturerName, long lecturerUserId);

	/**
	* Caches the lecturer in the entity cache if it is enabled.
	*
	* @param lecturer the lecturer
	*/
	public void cacheResult(Lecturer lecturer);

	/**
	* Caches the lecturers in the entity cache if it is enabled.
	*
	* @param lecturers the lecturers
	*/
	public void cacheResult(java.util.List<Lecturer> lecturers);

	/**
	* Creates a new lecturer with the primary key. Does not add the lecturer to the database.
	*
	* @param lecturerId the primary key for the new lecturer
	* @return the new lecturer
	*/
	public Lecturer create(long lecturerId);

	/**
	* Removes the lecturer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer that was removed
	* @throws NoSuchLecturerException if a lecturer with the primary key could not be found
	*/
	public Lecturer remove(long lecturerId) throws NoSuchLecturerException;

	public Lecturer updateImpl(Lecturer lecturer);

	/**
	* Returns the lecturer with the primary key or throws a {@link NoSuchLecturerException} if it could not be found.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer
	* @throws NoSuchLecturerException if a lecturer with the primary key could not be found
	*/
	public Lecturer findByPrimaryKey(long lecturerId)
		throws NoSuchLecturerException;

	/**
	* Returns the lecturer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lecturerId the primary key of the lecturer
	* @return the lecturer, or <code>null</code> if a lecturer with the primary key could not be found
	*/
	public Lecturer fetchByPrimaryKey(long lecturerId);

	@Override
	public java.util.Map<java.io.Serializable, Lecturer> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the lecturers.
	*
	* @return the lecturers
	*/
	public java.util.List<Lecturer> findAll();

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
	public java.util.List<Lecturer> findAll(int start, int end);

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
	public java.util.List<Lecturer> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lecturer> orderByComparator);

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
	public java.util.List<Lecturer> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lecturer> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the lecturers from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of lecturers.
	*
	* @return the number of lecturers
	*/
	public int countAll();

	/**
	* Returns the primaryKeys of timetable courses associated with the lecturer.
	*
	* @param pk the primary key of the lecturer
	* @return long[] of the primaryKeys of timetable courses associated with the lecturer
	*/
	public long[] getTimetableCoursePrimaryKeys(long pk);

	/**
	* Returns all the timetable courses associated with the lecturer.
	*
	* @param pk the primary key of the lecturer
	* @return the timetable courses associated with the lecturer
	*/
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		long pk);

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
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		long pk, int start, int end);

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
	public java.util.List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<hu.unideb.inf.model.TimetableCourse> orderByComparator);

	/**
	* Returns the number of timetable courses associated with the lecturer.
	*
	* @param pk the primary key of the lecturer
	* @return the number of timetable courses associated with the lecturer
	*/
	public int getTimetableCoursesSize(long pk);

	/**
	* Returns <code>true</code> if the timetable course is associated with the lecturer.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePK the primary key of the timetable course
	* @return <code>true</code> if the timetable course is associated with the lecturer; <code>false</code> otherwise
	*/
	public boolean containsTimetableCourse(long pk, long timetableCoursePK);

	/**
	* Returns <code>true</code> if the lecturer has any timetable courses associated with it.
	*
	* @param pk the primary key of the lecturer to check for associations with timetable courses
	* @return <code>true</code> if the lecturer has any timetable courses associated with it; <code>false</code> otherwise
	*/
	public boolean containsTimetableCourses(long pk);

	/**
	* Adds an association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePK the primary key of the timetable course
	*/
	public void addTimetableCourse(long pk, long timetableCoursePK);

	/**
	* Adds an association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCourse the timetable course
	*/
	public void addTimetableCourse(long pk,
		hu.unideb.inf.model.TimetableCourse timetableCourse);

	/**
	* Adds an association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePKs the primary keys of the timetable courses
	*/
	public void addTimetableCourses(long pk, long[] timetableCoursePKs);

	/**
	* Adds an association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCourses the timetable courses
	*/
	public void addTimetableCourses(long pk,
		java.util.List<hu.unideb.inf.model.TimetableCourse> timetableCourses);

	/**
	* Clears all associations between the lecturer and its timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer to clear the associated timetable courses from
	*/
	public void clearTimetableCourses(long pk);

	/**
	* Removes the association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePK the primary key of the timetable course
	*/
	public void removeTimetableCourse(long pk, long timetableCoursePK);

	/**
	* Removes the association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCourse the timetable course
	*/
	public void removeTimetableCourse(long pk,
		hu.unideb.inf.model.TimetableCourse timetableCourse);

	/**
	* Removes the association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePKs the primary keys of the timetable courses
	*/
	public void removeTimetableCourses(long pk, long[] timetableCoursePKs);

	/**
	* Removes the association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCourses the timetable courses
	*/
	public void removeTimetableCourses(long pk,
		java.util.List<hu.unideb.inf.model.TimetableCourse> timetableCourses);

	/**
	* Sets the timetable courses associated with the lecturer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCoursePKs the primary keys of the timetable courses to be associated with the lecturer
	*/
	public void setTimetableCourses(long pk, long[] timetableCoursePKs);

	/**
	* Sets the timetable courses associated with the lecturer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the lecturer
	* @param timetableCourses the timetable courses to be associated with the lecturer
	*/
	public void setTimetableCourses(long pk,
		java.util.List<hu.unideb.inf.model.TimetableCourse> timetableCourses);
}