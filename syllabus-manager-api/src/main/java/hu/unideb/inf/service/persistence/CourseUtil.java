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

import hu.unideb.inf.model.Course;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the course service. This utility wraps {@link hu.unideb.inf.service.persistence.impl.CoursePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see CoursePersistence
 * @see hu.unideb.inf.service.persistence.impl.CoursePersistenceImpl
 * @generated
 */
@ProviderType
public class CourseUtil {
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
	public static void clearCache(Course course) {
		getPersistence().clearCache(course);
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
	public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Course> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Course update(Course course) {
		return getPersistence().update(course);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Course update(Course course, ServiceContext serviceContext) {
		return getPersistence().update(course, serviceContext);
	}

	/**
	* Returns all the courses where subjectId = &#63;.
	*
	* @param subjectId the subject ID
	* @return the matching courses
	*/
	public static List<Course> findBySubjectId(long subjectId) {
		return getPersistence().findBySubjectId(subjectId);
	}

	/**
	* Returns a range of all the courses where subjectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param subjectId the subject ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of matching courses
	*/
	public static List<Course> findBySubjectId(long subjectId, int start,
		int end) {
		return getPersistence().findBySubjectId(subjectId, start, end);
	}

	/**
	* Returns an ordered range of all the courses where subjectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param subjectId the subject ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching courses
	*/
	public static List<Course> findBySubjectId(long subjectId, int start,
		int end, OrderByComparator<Course> orderByComparator) {
		return getPersistence()
				   .findBySubjectId(subjectId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the courses where subjectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param subjectId the subject ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching courses
	*/
	public static List<Course> findBySubjectId(long subjectId, int start,
		int end, OrderByComparator<Course> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBySubjectId(subjectId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first course in the ordered set where subjectId = &#63;.
	*
	* @param subjectId the subject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course
	* @throws NoSuchCourseException if a matching course could not be found
	*/
	public static Course findBySubjectId_First(long subjectId,
		OrderByComparator<Course> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchCourseException {
		return getPersistence()
				   .findBySubjectId_First(subjectId, orderByComparator);
	}

	/**
	* Returns the first course in the ordered set where subjectId = &#63;.
	*
	* @param subjectId the subject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course, or <code>null</code> if a matching course could not be found
	*/
	public static Course fetchBySubjectId_First(long subjectId,
		OrderByComparator<Course> orderByComparator) {
		return getPersistence()
				   .fetchBySubjectId_First(subjectId, orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where subjectId = &#63;.
	*
	* @param subjectId the subject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course
	* @throws NoSuchCourseException if a matching course could not be found
	*/
	public static Course findBySubjectId_Last(long subjectId,
		OrderByComparator<Course> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchCourseException {
		return getPersistence()
				   .findBySubjectId_Last(subjectId, orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where subjectId = &#63;.
	*
	* @param subjectId the subject ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course, or <code>null</code> if a matching course could not be found
	*/
	public static Course fetchBySubjectId_Last(long subjectId,
		OrderByComparator<Course> orderByComparator) {
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
	* @throws NoSuchCourseException if a course with the primary key could not be found
	*/
	public static Course[] findBySubjectId_PrevAndNext(long courseId,
		long subjectId, OrderByComparator<Course> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchCourseException {
		return getPersistence()
				   .findBySubjectId_PrevAndNext(courseId, subjectId,
			orderByComparator);
	}

	/**
	* Removes all the courses where subjectId = &#63; from the database.
	*
	* @param subjectId the subject ID
	*/
	public static void removeBySubjectId(long subjectId) {
		getPersistence().removeBySubjectId(subjectId);
	}

	/**
	* Returns the number of courses where subjectId = &#63;.
	*
	* @param subjectId the subject ID
	* @return the number of matching courses
	*/
	public static int countBySubjectId(long subjectId) {
		return getPersistence().countBySubjectId(subjectId);
	}

	/**
	* Returns the course where subjectId = &#63; and courseTypeId = &#63; or throws a {@link NoSuchCourseException} if it could not be found.
	*
	* @param subjectId the subject ID
	* @param courseTypeId the course type ID
	* @return the matching course
	* @throws NoSuchCourseException if a matching course could not be found
	*/
	public static Course findByS_CT(long subjectId, long courseTypeId)
		throws hu.unideb.inf.exception.NoSuchCourseException {
		return getPersistence().findByS_CT(subjectId, courseTypeId);
	}

	/**
	* Returns the course where subjectId = &#63; and courseTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param subjectId the subject ID
	* @param courseTypeId the course type ID
	* @return the matching course, or <code>null</code> if a matching course could not be found
	*/
	public static Course fetchByS_CT(long subjectId, long courseTypeId) {
		return getPersistence().fetchByS_CT(subjectId, courseTypeId);
	}

	/**
	* Returns the course where subjectId = &#63; and courseTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param subjectId the subject ID
	* @param courseTypeId the course type ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching course, or <code>null</code> if a matching course could not be found
	*/
	public static Course fetchByS_CT(long subjectId, long courseTypeId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByS_CT(subjectId, courseTypeId, retrieveFromCache);
	}

	/**
	* Removes the course where subjectId = &#63; and courseTypeId = &#63; from the database.
	*
	* @param subjectId the subject ID
	* @param courseTypeId the course type ID
	* @return the course that was removed
	*/
	public static Course removeByS_CT(long subjectId, long courseTypeId)
		throws hu.unideb.inf.exception.NoSuchCourseException {
		return getPersistence().removeByS_CT(subjectId, courseTypeId);
	}

	/**
	* Returns the number of courses where subjectId = &#63; and courseTypeId = &#63;.
	*
	* @param subjectId the subject ID
	* @param courseTypeId the course type ID
	* @return the number of matching courses
	*/
	public static int countByS_CT(long subjectId, long courseTypeId) {
		return getPersistence().countByS_CT(subjectId, courseTypeId);
	}

	/**
	* Returns all the courses where courseTypeId = &#63;.
	*
	* @param courseTypeId the course type ID
	* @return the matching courses
	*/
	public static List<Course> findByCourseType(long courseTypeId) {
		return getPersistence().findByCourseType(courseTypeId);
	}

	/**
	* Returns a range of all the courses where courseTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseTypeId the course type ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of matching courses
	*/
	public static List<Course> findByCourseType(long courseTypeId, int start,
		int end) {
		return getPersistence().findByCourseType(courseTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the courses where courseTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseTypeId the course type ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching courses
	*/
	public static List<Course> findByCourseType(long courseTypeId, int start,
		int end, OrderByComparator<Course> orderByComparator) {
		return getPersistence()
				   .findByCourseType(courseTypeId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the courses where courseTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param courseTypeId the course type ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching courses
	*/
	public static List<Course> findByCourseType(long courseTypeId, int start,
		int end, OrderByComparator<Course> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCourseType(courseTypeId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first course in the ordered set where courseTypeId = &#63;.
	*
	* @param courseTypeId the course type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course
	* @throws NoSuchCourseException if a matching course could not be found
	*/
	public static Course findByCourseType_First(long courseTypeId,
		OrderByComparator<Course> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchCourseException {
		return getPersistence()
				   .findByCourseType_First(courseTypeId, orderByComparator);
	}

	/**
	* Returns the first course in the ordered set where courseTypeId = &#63;.
	*
	* @param courseTypeId the course type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course, or <code>null</code> if a matching course could not be found
	*/
	public static Course fetchByCourseType_First(long courseTypeId,
		OrderByComparator<Course> orderByComparator) {
		return getPersistence()
				   .fetchByCourseType_First(courseTypeId, orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where courseTypeId = &#63;.
	*
	* @param courseTypeId the course type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course
	* @throws NoSuchCourseException if a matching course could not be found
	*/
	public static Course findByCourseType_Last(long courseTypeId,
		OrderByComparator<Course> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchCourseException {
		return getPersistence()
				   .findByCourseType_Last(courseTypeId, orderByComparator);
	}

	/**
	* Returns the last course in the ordered set where courseTypeId = &#63;.
	*
	* @param courseTypeId the course type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course, or <code>null</code> if a matching course could not be found
	*/
	public static Course fetchByCourseType_Last(long courseTypeId,
		OrderByComparator<Course> orderByComparator) {
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
	* @throws NoSuchCourseException if a course with the primary key could not be found
	*/
	public static Course[] findByCourseType_PrevAndNext(long courseId,
		long courseTypeId, OrderByComparator<Course> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchCourseException {
		return getPersistence()
				   .findByCourseType_PrevAndNext(courseId, courseTypeId,
			orderByComparator);
	}

	/**
	* Removes all the courses where courseTypeId = &#63; from the database.
	*
	* @param courseTypeId the course type ID
	*/
	public static void removeByCourseType(long courseTypeId) {
		getPersistence().removeByCourseType(courseTypeId);
	}

	/**
	* Returns the number of courses where courseTypeId = &#63;.
	*
	* @param courseTypeId the course type ID
	* @return the number of matching courses
	*/
	public static int countByCourseType(long courseTypeId) {
		return getPersistence().countByCourseType(courseTypeId);
	}

	/**
	* Caches the course in the entity cache if it is enabled.
	*
	* @param course the course
	*/
	public static void cacheResult(Course course) {
		getPersistence().cacheResult(course);
	}

	/**
	* Caches the courses in the entity cache if it is enabled.
	*
	* @param courses the courses
	*/
	public static void cacheResult(List<Course> courses) {
		getPersistence().cacheResult(courses);
	}

	/**
	* Creates a new course with the primary key. Does not add the course to the database.
	*
	* @param courseId the primary key for the new course
	* @return the new course
	*/
	public static Course create(long courseId) {
		return getPersistence().create(courseId);
	}

	/**
	* Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param courseId the primary key of the course
	* @return the course that was removed
	* @throws NoSuchCourseException if a course with the primary key could not be found
	*/
	public static Course remove(long courseId)
		throws hu.unideb.inf.exception.NoSuchCourseException {
		return getPersistence().remove(courseId);
	}

	public static Course updateImpl(Course course) {
		return getPersistence().updateImpl(course);
	}

	/**
	* Returns the course with the primary key or throws a {@link NoSuchCourseException} if it could not be found.
	*
	* @param courseId the primary key of the course
	* @return the course
	* @throws NoSuchCourseException if a course with the primary key could not be found
	*/
	public static Course findByPrimaryKey(long courseId)
		throws hu.unideb.inf.exception.NoSuchCourseException {
		return getPersistence().findByPrimaryKey(courseId);
	}

	/**
	* Returns the course with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param courseId the primary key of the course
	* @return the course, or <code>null</code> if a course with the primary key could not be found
	*/
	public static Course fetchByPrimaryKey(long courseId) {
		return getPersistence().fetchByPrimaryKey(courseId);
	}

	public static java.util.Map<java.io.Serializable, Course> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the courses.
	*
	* @return the courses
	*/
	public static List<Course> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of courses
	*/
	public static List<Course> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of courses
	*/
	public static List<Course> findAll(int start, int end,
		OrderByComparator<Course> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of courses
	*/
	public static List<Course> findAll(int start, int end,
		OrderByComparator<Course> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the courses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of courses.
	*
	* @return the number of courses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CoursePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CoursePersistence, CoursePersistence> _serviceTracker =
		ServiceTrackerFactory.open(CoursePersistence.class);
}