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

import hu.unideb.inf.model.Syllabus;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the syllabus service. This utility wraps {@link hu.unideb.inf.service.persistence.impl.SyllabusPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see SyllabusPersistence
 * @see hu.unideb.inf.service.persistence.impl.SyllabusPersistenceImpl
 * @generated
 */
@ProviderType
public class SyllabusUtil {
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
	public static void clearCache(Syllabus syllabus) {
		getPersistence().clearCache(syllabus);
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
	public static List<Syllabus> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Syllabus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Syllabus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Syllabus> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Syllabus update(Syllabus syllabus) {
		return getPersistence().update(syllabus);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Syllabus update(Syllabus syllabus,
		ServiceContext serviceContext) {
		return getPersistence().update(syllabus, serviceContext);
	}

	/**
	* Returns all the syllabuses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching syllabuses
	*/
	public static List<Syllabus> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Syllabus> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Syllabus> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Syllabus> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Syllabus> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Syllabus> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first syllabus in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching syllabus
	* @throws NoSuchSyllabusException if a matching syllabus could not be found
	*/
	public static Syllabus findByUuid_First(java.lang.String uuid,
		OrderByComparator<Syllabus> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchSyllabusException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first syllabus in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching syllabus, or <code>null</code> if a matching syllabus could not be found
	*/
	public static Syllabus fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Syllabus> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last syllabus in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching syllabus
	* @throws NoSuchSyllabusException if a matching syllabus could not be found
	*/
	public static Syllabus findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Syllabus> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchSyllabusException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last syllabus in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching syllabus, or <code>null</code> if a matching syllabus could not be found
	*/
	public static Syllabus fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Syllabus> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the syllabuses before and after the current syllabus in the ordered set where uuid = &#63;.
	*
	* @param syllabusId the primary key of the current syllabus
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next syllabus
	* @throws NoSuchSyllabusException if a syllabus with the primary key could not be found
	*/
	public static Syllabus[] findByUuid_PrevAndNext(long syllabusId,
		java.lang.String uuid, OrderByComparator<Syllabus> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchSyllabusException {
		return getPersistence()
				   .findByUuid_PrevAndNext(syllabusId, uuid, orderByComparator);
	}

	/**
	* Removes all the syllabuses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of syllabuses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching syllabuses
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the syllabus where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchSyllabusException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching syllabus
	* @throws NoSuchSyllabusException if a matching syllabus could not be found
	*/
	public static Syllabus findByUUID_G(java.lang.String uuid, long groupId)
		throws hu.unideb.inf.exception.NoSuchSyllabusException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the syllabus where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching syllabus, or <code>null</code> if a matching syllabus could not be found
	*/
	public static Syllabus fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the syllabus where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching syllabus, or <code>null</code> if a matching syllabus could not be found
	*/
	public static Syllabus fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the syllabus where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the syllabus that was removed
	*/
	public static Syllabus removeByUUID_G(java.lang.String uuid, long groupId)
		throws hu.unideb.inf.exception.NoSuchSyllabusException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of syllabuses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching syllabuses
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the syllabuses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching syllabuses
	*/
	public static List<Syllabus> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<Syllabus> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<Syllabus> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Syllabus> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<Syllabus> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Syllabus> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first syllabus in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching syllabus
	* @throws NoSuchSyllabusException if a matching syllabus could not be found
	*/
	public static Syllabus findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Syllabus> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchSyllabusException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first syllabus in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching syllabus, or <code>null</code> if a matching syllabus could not be found
	*/
	public static Syllabus fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Syllabus> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last syllabus in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching syllabus
	* @throws NoSuchSyllabusException if a matching syllabus could not be found
	*/
	public static Syllabus findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Syllabus> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchSyllabusException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last syllabus in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching syllabus, or <code>null</code> if a matching syllabus could not be found
	*/
	public static Syllabus fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Syllabus> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static Syllabus[] findByUuid_C_PrevAndNext(long syllabusId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Syllabus> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchSyllabusException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(syllabusId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the syllabuses where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of syllabuses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching syllabuses
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the syllabuses where timetableCourseId = &#63;.
	*
	* @param timetableCourseId the timetable course ID
	* @return the matching syllabuses
	*/
	public static List<Syllabus> findByTimetableCourseId(long timetableCourseId) {
		return getPersistence().findByTimetableCourseId(timetableCourseId);
	}

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
	public static List<Syllabus> findByTimetableCourseId(
		long timetableCourseId, int start, int end) {
		return getPersistence()
				   .findByTimetableCourseId(timetableCourseId, start, end);
	}

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
	public static List<Syllabus> findByTimetableCourseId(
		long timetableCourseId, int start, int end,
		OrderByComparator<Syllabus> orderByComparator) {
		return getPersistence()
				   .findByTimetableCourseId(timetableCourseId, start, end,
			orderByComparator);
	}

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
	public static List<Syllabus> findByTimetableCourseId(
		long timetableCourseId, int start, int end,
		OrderByComparator<Syllabus> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByTimetableCourseId(timetableCourseId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first syllabus in the ordered set where timetableCourseId = &#63;.
	*
	* @param timetableCourseId the timetable course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching syllabus
	* @throws NoSuchSyllabusException if a matching syllabus could not be found
	*/
	public static Syllabus findByTimetableCourseId_First(
		long timetableCourseId, OrderByComparator<Syllabus> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchSyllabusException {
		return getPersistence()
				   .findByTimetableCourseId_First(timetableCourseId,
			orderByComparator);
	}

	/**
	* Returns the first syllabus in the ordered set where timetableCourseId = &#63;.
	*
	* @param timetableCourseId the timetable course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching syllabus, or <code>null</code> if a matching syllabus could not be found
	*/
	public static Syllabus fetchByTimetableCourseId_First(
		long timetableCourseId, OrderByComparator<Syllabus> orderByComparator) {
		return getPersistence()
				   .fetchByTimetableCourseId_First(timetableCourseId,
			orderByComparator);
	}

	/**
	* Returns the last syllabus in the ordered set where timetableCourseId = &#63;.
	*
	* @param timetableCourseId the timetable course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching syllabus
	* @throws NoSuchSyllabusException if a matching syllabus could not be found
	*/
	public static Syllabus findByTimetableCourseId_Last(
		long timetableCourseId, OrderByComparator<Syllabus> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchSyllabusException {
		return getPersistence()
				   .findByTimetableCourseId_Last(timetableCourseId,
			orderByComparator);
	}

	/**
	* Returns the last syllabus in the ordered set where timetableCourseId = &#63;.
	*
	* @param timetableCourseId the timetable course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching syllabus, or <code>null</code> if a matching syllabus could not be found
	*/
	public static Syllabus fetchByTimetableCourseId_Last(
		long timetableCourseId, OrderByComparator<Syllabus> orderByComparator) {
		return getPersistence()
				   .fetchByTimetableCourseId_Last(timetableCourseId,
			orderByComparator);
	}

	/**
	* Returns the syllabuses before and after the current syllabus in the ordered set where timetableCourseId = &#63;.
	*
	* @param syllabusId the primary key of the current syllabus
	* @param timetableCourseId the timetable course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next syllabus
	* @throws NoSuchSyllabusException if a syllabus with the primary key could not be found
	*/
	public static Syllabus[] findByTimetableCourseId_PrevAndNext(
		long syllabusId, long timetableCourseId,
		OrderByComparator<Syllabus> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchSyllabusException {
		return getPersistence()
				   .findByTimetableCourseId_PrevAndNext(syllabusId,
			timetableCourseId, orderByComparator);
	}

	/**
	* Removes all the syllabuses where timetableCourseId = &#63; from the database.
	*
	* @param timetableCourseId the timetable course ID
	*/
	public static void removeByTimetableCourseId(long timetableCourseId) {
		getPersistence().removeByTimetableCourseId(timetableCourseId);
	}

	/**
	* Returns the number of syllabuses where timetableCourseId = &#63;.
	*
	* @param timetableCourseId the timetable course ID
	* @return the number of matching syllabuses
	*/
	public static int countByTimetableCourseId(long timetableCourseId) {
		return getPersistence().countByTimetableCourseId(timetableCourseId);
	}

	/**
	* Caches the syllabus in the entity cache if it is enabled.
	*
	* @param syllabus the syllabus
	*/
	public static void cacheResult(Syllabus syllabus) {
		getPersistence().cacheResult(syllabus);
	}

	/**
	* Caches the syllabuses in the entity cache if it is enabled.
	*
	* @param syllabuses the syllabuses
	*/
	public static void cacheResult(List<Syllabus> syllabuses) {
		getPersistence().cacheResult(syllabuses);
	}

	/**
	* Creates a new syllabus with the primary key. Does not add the syllabus to the database.
	*
	* @param syllabusId the primary key for the new syllabus
	* @return the new syllabus
	*/
	public static Syllabus create(long syllabusId) {
		return getPersistence().create(syllabusId);
	}

	/**
	* Removes the syllabus with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param syllabusId the primary key of the syllabus
	* @return the syllabus that was removed
	* @throws NoSuchSyllabusException if a syllabus with the primary key could not be found
	*/
	public static Syllabus remove(long syllabusId)
		throws hu.unideb.inf.exception.NoSuchSyllabusException {
		return getPersistence().remove(syllabusId);
	}

	public static Syllabus updateImpl(Syllabus syllabus) {
		return getPersistence().updateImpl(syllabus);
	}

	/**
	* Returns the syllabus with the primary key or throws a {@link NoSuchSyllabusException} if it could not be found.
	*
	* @param syllabusId the primary key of the syllabus
	* @return the syllabus
	* @throws NoSuchSyllabusException if a syllabus with the primary key could not be found
	*/
	public static Syllabus findByPrimaryKey(long syllabusId)
		throws hu.unideb.inf.exception.NoSuchSyllabusException {
		return getPersistence().findByPrimaryKey(syllabusId);
	}

	/**
	* Returns the syllabus with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param syllabusId the primary key of the syllabus
	* @return the syllabus, or <code>null</code> if a syllabus with the primary key could not be found
	*/
	public static Syllabus fetchByPrimaryKey(long syllabusId) {
		return getPersistence().fetchByPrimaryKey(syllabusId);
	}

	public static java.util.Map<java.io.Serializable, Syllabus> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the syllabuses.
	*
	* @return the syllabuses
	*/
	public static List<Syllabus> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Syllabus> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Syllabus> findAll(int start, int end,
		OrderByComparator<Syllabus> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Syllabus> findAll(int start, int end,
		OrderByComparator<Syllabus> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the syllabuses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of syllabuses.
	*
	* @return the number of syllabuses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static SyllabusPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SyllabusPersistence, SyllabusPersistence> _serviceTracker =
		ServiceTrackerFactory.open(SyllabusPersistence.class);
}