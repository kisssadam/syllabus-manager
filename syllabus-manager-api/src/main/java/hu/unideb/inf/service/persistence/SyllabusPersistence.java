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

import hu.unideb.inf.exception.NoSuchSyllabusException;
import hu.unideb.inf.model.Syllabus;

/**
 * The persistence interface for the syllabus service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see hu.unideb.inf.service.persistence.impl.SyllabusPersistenceImpl
 * @see SyllabusUtil
 * @generated
 */
@ProviderType
public interface SyllabusPersistence extends BasePersistence<Syllabus> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SyllabusUtil} to access the syllabus persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the syllabuses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching syllabuses
	*/
	public java.util.List<Syllabus> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the syllabuses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of syllabuses
	* @param end the upper bound of the range of syllabuses (not inclusive)
	* @return the range of matching syllabuses
	*/
	public java.util.List<Syllabus> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the syllabuses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of syllabuses
	* @param end the upper bound of the range of syllabuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching syllabuses
	*/
	public java.util.List<Syllabus> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator);

	/**
	* Returns an ordered range of all the syllabuses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of syllabuses
	* @param end the upper bound of the range of syllabuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching syllabuses
	*/
	public java.util.List<Syllabus> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first syllabus in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching syllabus
	* @throws NoSuchSyllabusException if a matching syllabus could not be found
	*/
	public Syllabus findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator)
		throws NoSuchSyllabusException;

	/**
	* Returns the first syllabus in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching syllabus, or <code>null</code> if a matching syllabus could not be found
	*/
	public Syllabus fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator);

	/**
	* Returns the last syllabus in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching syllabus
	* @throws NoSuchSyllabusException if a matching syllabus could not be found
	*/
	public Syllabus findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator)
		throws NoSuchSyllabusException;

	/**
	* Returns the last syllabus in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching syllabus, or <code>null</code> if a matching syllabus could not be found
	*/
	public Syllabus fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator);

	/**
	* Returns the syllabuses before and after the current syllabus in the ordered set where uuid = &#63;.
	*
	* @param syllabusId the primary key of the current syllabus
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next syllabus
	* @throws NoSuchSyllabusException if a syllabus with the primary key could not be found
	*/
	public Syllabus[] findByUuid_PrevAndNext(long syllabusId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator)
		throws NoSuchSyllabusException;

	/**
	* Removes all the syllabuses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of syllabuses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching syllabuses
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the syllabus where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchSyllabusException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching syllabus
	* @throws NoSuchSyllabusException if a matching syllabus could not be found
	*/
	public Syllabus findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchSyllabusException;

	/**
	* Returns the syllabus where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching syllabus, or <code>null</code> if a matching syllabus could not be found
	*/
	public Syllabus fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the syllabus where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching syllabus, or <code>null</code> if a matching syllabus could not be found
	*/
	public Syllabus fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the syllabus where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the syllabus that was removed
	*/
	public Syllabus removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchSyllabusException;

	/**
	* Returns the number of syllabuses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching syllabuses
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the syllabuses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching syllabuses
	*/
	public java.util.List<Syllabus> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the syllabuses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of syllabuses
	* @param end the upper bound of the range of syllabuses (not inclusive)
	* @return the range of matching syllabuses
	*/
	public java.util.List<Syllabus> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the syllabuses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of syllabuses
	* @param end the upper bound of the range of syllabuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching syllabuses
	*/
	public java.util.List<Syllabus> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator);

	/**
	* Returns an ordered range of all the syllabuses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of syllabuses
	* @param end the upper bound of the range of syllabuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching syllabuses
	*/
	public java.util.List<Syllabus> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first syllabus in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching syllabus
	* @throws NoSuchSyllabusException if a matching syllabus could not be found
	*/
	public Syllabus findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator)
		throws NoSuchSyllabusException;

	/**
	* Returns the first syllabus in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching syllabus, or <code>null</code> if a matching syllabus could not be found
	*/
	public Syllabus fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator);

	/**
	* Returns the last syllabus in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching syllabus
	* @throws NoSuchSyllabusException if a matching syllabus could not be found
	*/
	public Syllabus findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator)
		throws NoSuchSyllabusException;

	/**
	* Returns the last syllabus in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching syllabus, or <code>null</code> if a matching syllabus could not be found
	*/
	public Syllabus fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator);

	/**
	* Returns the syllabuses before and after the current syllabus in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param syllabusId the primary key of the current syllabus
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next syllabus
	* @throws NoSuchSyllabusException if a syllabus with the primary key could not be found
	*/
	public Syllabus[] findByUuid_C_PrevAndNext(long syllabusId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator)
		throws NoSuchSyllabusException;

	/**
	* Removes all the syllabuses where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of syllabuses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching syllabuses
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the syllabuses where timetableCourseId = &#63;.
	*
	* @param timetableCourseId the timetable course ID
	* @return the matching syllabuses
	*/
	public java.util.List<Syllabus> findByTimetableCourseId(
		long timetableCourseId);

	/**
	* Returns a range of all the syllabuses where timetableCourseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param timetableCourseId the timetable course ID
	* @param start the lower bound of the range of syllabuses
	* @param end the upper bound of the range of syllabuses (not inclusive)
	* @return the range of matching syllabuses
	*/
	public java.util.List<Syllabus> findByTimetableCourseId(
		long timetableCourseId, int start, int end);

	/**
	* Returns an ordered range of all the syllabuses where timetableCourseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param timetableCourseId the timetable course ID
	* @param start the lower bound of the range of syllabuses
	* @param end the upper bound of the range of syllabuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching syllabuses
	*/
	public java.util.List<Syllabus> findByTimetableCourseId(
		long timetableCourseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator);

	/**
	* Returns an ordered range of all the syllabuses where timetableCourseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param timetableCourseId the timetable course ID
	* @param start the lower bound of the range of syllabuses
	* @param end the upper bound of the range of syllabuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching syllabuses
	*/
	public java.util.List<Syllabus> findByTimetableCourseId(
		long timetableCourseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first syllabus in the ordered set where timetableCourseId = &#63;.
	*
	* @param timetableCourseId the timetable course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching syllabus
	* @throws NoSuchSyllabusException if a matching syllabus could not be found
	*/
	public Syllabus findByTimetableCourseId_First(long timetableCourseId,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator)
		throws NoSuchSyllabusException;

	/**
	* Returns the first syllabus in the ordered set where timetableCourseId = &#63;.
	*
	* @param timetableCourseId the timetable course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching syllabus, or <code>null</code> if a matching syllabus could not be found
	*/
	public Syllabus fetchByTimetableCourseId_First(long timetableCourseId,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator);

	/**
	* Returns the last syllabus in the ordered set where timetableCourseId = &#63;.
	*
	* @param timetableCourseId the timetable course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching syllabus
	* @throws NoSuchSyllabusException if a matching syllabus could not be found
	*/
	public Syllabus findByTimetableCourseId_Last(long timetableCourseId,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator)
		throws NoSuchSyllabusException;

	/**
	* Returns the last syllabus in the ordered set where timetableCourseId = &#63;.
	*
	* @param timetableCourseId the timetable course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching syllabus, or <code>null</code> if a matching syllabus could not be found
	*/
	public Syllabus fetchByTimetableCourseId_Last(long timetableCourseId,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator);

	/**
	* Returns the syllabuses before and after the current syllabus in the ordered set where timetableCourseId = &#63;.
	*
	* @param syllabusId the primary key of the current syllabus
	* @param timetableCourseId the timetable course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next syllabus
	* @throws NoSuchSyllabusException if a syllabus with the primary key could not be found
	*/
	public Syllabus[] findByTimetableCourseId_PrevAndNext(long syllabusId,
		long timetableCourseId,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator)
		throws NoSuchSyllabusException;

	/**
	* Removes all the syllabuses where timetableCourseId = &#63; from the database.
	*
	* @param timetableCourseId the timetable course ID
	*/
	public void removeByTimetableCourseId(long timetableCourseId);

	/**
	* Returns the number of syllabuses where timetableCourseId = &#63;.
	*
	* @param timetableCourseId the timetable course ID
	* @return the number of matching syllabuses
	*/
	public int countByTimetableCourseId(long timetableCourseId);

	/**
	* Caches the syllabus in the entity cache if it is enabled.
	*
	* @param syllabus the syllabus
	*/
	public void cacheResult(Syllabus syllabus);

	/**
	* Caches the syllabuses in the entity cache if it is enabled.
	*
	* @param syllabuses the syllabuses
	*/
	public void cacheResult(java.util.List<Syllabus> syllabuses);

	/**
	* Creates a new syllabus with the primary key. Does not add the syllabus to the database.
	*
	* @param syllabusId the primary key for the new syllabus
	* @return the new syllabus
	*/
	public Syllabus create(long syllabusId);

	/**
	* Removes the syllabus with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param syllabusId the primary key of the syllabus
	* @return the syllabus that was removed
	* @throws NoSuchSyllabusException if a syllabus with the primary key could not be found
	*/
	public Syllabus remove(long syllabusId) throws NoSuchSyllabusException;

	public Syllabus updateImpl(Syllabus syllabus);

	/**
	* Returns the syllabus with the primary key or throws a {@link NoSuchSyllabusException} if it could not be found.
	*
	* @param syllabusId the primary key of the syllabus
	* @return the syllabus
	* @throws NoSuchSyllabusException if a syllabus with the primary key could not be found
	*/
	public Syllabus findByPrimaryKey(long syllabusId)
		throws NoSuchSyllabusException;

	/**
	* Returns the syllabus with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param syllabusId the primary key of the syllabus
	* @return the syllabus, or <code>null</code> if a syllabus with the primary key could not be found
	*/
	public Syllabus fetchByPrimaryKey(long syllabusId);

	@Override
	public java.util.Map<java.io.Serializable, Syllabus> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the syllabuses.
	*
	* @return the syllabuses
	*/
	public java.util.List<Syllabus> findAll();

	/**
	* Returns a range of all the syllabuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of syllabuses
	* @param end the upper bound of the range of syllabuses (not inclusive)
	* @return the range of syllabuses
	*/
	public java.util.List<Syllabus> findAll(int start, int end);

	/**
	* Returns an ordered range of all the syllabuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of syllabuses
	* @param end the upper bound of the range of syllabuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of syllabuses
	*/
	public java.util.List<Syllabus> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator);

	/**
	* Returns an ordered range of all the syllabuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of syllabuses
	* @param end the upper bound of the range of syllabuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of syllabuses
	*/
	public java.util.List<Syllabus> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Syllabus> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the syllabuses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of syllabuses.
	*
	* @return the number of syllabuses
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}