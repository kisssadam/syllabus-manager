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

import hu.unideb.inf.model.Course;

import java.util.List;

/**
 * The persistence utility for the course service. This utility wraps {@link CoursePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see CoursePersistence
 * @see CoursePersistenceImpl
 * @generated
 */
public class CourseUtil {
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
	public static void clearCache(Course course) {
		getPersistence().clearCache(course);
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
	public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Course update(Course course) throws SystemException {
		return getPersistence().update(course);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Course update(Course course, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(course, serviceContext);
	}

	/**
	* Returns all the courses where subjectId = &#63;.
	*
	* @param subjectId the subject ID
	* @return the matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Course> findBySubjectId(
		long subjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySubjectId(subjectId);
	}

	/**
	* Returns a range of all the courses where subjectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param subjectId the subject ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Course> findBySubjectId(
		long subjectId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySubjectId(subjectId, start, end);
	}

	/**
	* Returns an ordered range of all the courses where subjectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param subjectId the subject ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Course> findBySubjectId(
		long subjectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySubjectId(subjectId, start, end, orderByComparator);
	}

	/**
	* Returns the first course in the ordered set where subjectId = &#63;.
	*
	* @param subjectId the subject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course
	* @throws hu.unideb.inf.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Course findBySubjectId_First(
		long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchCourseException {
		return getPersistence()
				   .findBySubjectId_First(subjectId, orderByComparator);
	}

	/**
	* Returns the first course in the ordered set where subjectId = &#63;.
	*
	* @param subjectId the subject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Course fetchBySubjectId_First(
		long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySubjectId_First(subjectId, orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where subjectId = &#63;.
	*
	* @param subjectId the subject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course
	* @throws hu.unideb.inf.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Course findBySubjectId_Last(
		long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchCourseException {
		return getPersistence()
				   .findBySubjectId_Last(subjectId, orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where subjectId = &#63;.
	*
	* @param subjectId the subject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Course fetchBySubjectId_Last(
		long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySubjectId_Last(subjectId, orderByComparator);
	}

	/**
	* Returns the courses before and after the current course in the ordered set where subjectId = &#63;.
	*
	* @param courseId the primary key of the current course
	* @param subjectId the subject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course
	* @throws hu.unideb.inf.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Course[] findBySubjectId_PrevAndNext(
		long courseId, long subjectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchCourseException {
		return getPersistence()
				   .findBySubjectId_PrevAndNext(courseId, subjectId,
			orderByComparator);
	}

	/**
	* Removes all the courses where subjectId = &#63; from the database.
	*
	* @param subjectId the subject ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySubjectId(long subjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySubjectId(subjectId);
	}

	/**
	* Returns the number of courses where subjectId = &#63;.
	*
	* @param subjectId the subject ID
	* @return the number of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySubjectId(long subjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySubjectId(subjectId);
	}

	/**
	* Returns the course where subjectId = &#63; and courseTypeId = &#63; or throws a {@link hu.unideb.inf.NoSuchCourseException} if it could not be found.
	*
	* @param subjectId the subject ID
	* @param courseTypeId the course type ID
	* @return the matching course
	* @throws hu.unideb.inf.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Course findByS_CT(long subjectId,
		long courseTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchCourseException {
		return getPersistence().findByS_CT(subjectId, courseTypeId);
	}

	/**
	* Returns the course where subjectId = &#63; and courseTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param subjectId the subject ID
	* @param courseTypeId the course type ID
	* @return the matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Course fetchByS_CT(long subjectId,
		long courseTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByS_CT(subjectId, courseTypeId);
	}

	/**
	* Returns the course where subjectId = &#63; and courseTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param subjectId the subject ID
	* @param courseTypeId the course type ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Course fetchByS_CT(long subjectId,
		long courseTypeId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_CT(subjectId, courseTypeId, retrieveFromCache);
	}

	/**
	* Removes the course where subjectId = &#63; and courseTypeId = &#63; from the database.
	*
	* @param subjectId the subject ID
	* @param courseTypeId the course type ID
	* @return the course that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Course removeByS_CT(long subjectId,
		long courseTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchCourseException {
		return getPersistence().removeByS_CT(subjectId, courseTypeId);
	}

	/**
	* Returns the number of courses where subjectId = &#63; and courseTypeId = &#63;.
	*
	* @param subjectId the subject ID
	* @param courseTypeId the course type ID
	* @return the number of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByS_CT(long subjectId, long courseTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByS_CT(subjectId, courseTypeId);
	}

	/**
	* Returns all the courses where courseTypeId = &#63;.
	*
	* @param courseTypeId the course type ID
	* @return the matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Course> findByCourseType(
		long courseTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseType(courseTypeId);
	}

	/**
	* Returns a range of all the courses where courseTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseTypeId the course type ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Course> findByCourseType(
		long courseTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseType(courseTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the courses where courseTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseTypeId the course type ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Course> findByCourseType(
		long courseTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseType(courseTypeId, start, end, orderByComparator);
	}

	/**
	* Returns the first course in the ordered set where courseTypeId = &#63;.
	*
	* @param courseTypeId the course type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course
	* @throws hu.unideb.inf.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Course findByCourseType_First(
		long courseTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchCourseException {
		return getPersistence()
				   .findByCourseType_First(courseTypeId, orderByComparator);
	}

	/**
	* Returns the first course in the ordered set where courseTypeId = &#63;.
	*
	* @param courseTypeId the course type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Course fetchByCourseType_First(
		long courseTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseType_First(courseTypeId, orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where courseTypeId = &#63;.
	*
	* @param courseTypeId the course type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course
	* @throws hu.unideb.inf.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Course findByCourseType_Last(
		long courseTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchCourseException {
		return getPersistence()
				   .findByCourseType_Last(courseTypeId, orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where courseTypeId = &#63;.
	*
	* @param courseTypeId the course type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Course fetchByCourseType_Last(
		long courseTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseType_Last(courseTypeId, orderByComparator);
	}

	/**
	* Returns the courses before and after the current course in the ordered set where courseTypeId = &#63;.
	*
	* @param courseId the primary key of the current course
	* @param courseTypeId the course type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course
	* @throws hu.unideb.inf.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Course[] findByCourseType_PrevAndNext(
		long courseId, long courseTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchCourseException {
		return getPersistence()
				   .findByCourseType_PrevAndNext(courseId, courseTypeId,
			orderByComparator);
	}

	/**
	* Removes all the courses where courseTypeId = &#63; from the database.
	*
	* @param courseTypeId the course type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCourseType(long courseTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCourseType(courseTypeId);
	}

	/**
	* Returns the number of courses where courseTypeId = &#63;.
	*
	* @param courseTypeId the course type ID
	* @return the number of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourseType(long courseTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCourseType(courseTypeId);
	}

	/**
	* Caches the course in the entity cache if it is enabled.
	*
	* @param course the course
	*/
	public static void cacheResult(hu.unideb.inf.model.Course course) {
		getPersistence().cacheResult(course);
	}

	/**
	* Caches the courses in the entity cache if it is enabled.
	*
	* @param courses the courses
	*/
	public static void cacheResult(
		java.util.List<hu.unideb.inf.model.Course> courses) {
		getPersistence().cacheResult(courses);
	}

	/**
	* Creates a new course with the primary key. Does not add the course to the database.
	*
	* @param courseId the primary key for the new course
	* @return the new course
	*/
	public static hu.unideb.inf.model.Course create(long courseId) {
		return getPersistence().create(courseId);
	}

	/**
	* Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param courseId the primary key of the course
	* @return the course that was removed
	* @throws hu.unideb.inf.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Course remove(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchCourseException {
		return getPersistence().remove(courseId);
	}

	public static hu.unideb.inf.model.Course updateImpl(
		hu.unideb.inf.model.Course course)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(course);
	}

	/**
	* Returns the course with the primary key or throws a {@link hu.unideb.inf.NoSuchCourseException} if it could not be found.
	*
	* @param courseId the primary key of the course
	* @return the course
	* @throws hu.unideb.inf.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Course findByPrimaryKey(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchCourseException {
		return getPersistence().findByPrimaryKey(courseId);
	}

	/**
	* Returns the course with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param courseId the primary key of the course
	* @return the course, or <code>null</code> if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Course fetchByPrimaryKey(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(courseId);
	}

	/**
	* Returns all the courses.
	*
	* @return the courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Course> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Course> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Course> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the courses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of courses.
	*
	* @return the number of courses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CoursePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CoursePersistence)PortletBeanLocatorUtil.locate(hu.unideb.inf.service.ClpSerializer.getServletContextName(),
					CoursePersistence.class.getName());

			ReferenceRegistry.registerReference(CourseUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CoursePersistence persistence) {
	}

	private static CoursePersistence _persistence;
}