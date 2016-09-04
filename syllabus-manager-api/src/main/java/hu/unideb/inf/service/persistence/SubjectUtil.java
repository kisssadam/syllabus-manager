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

import hu.unideb.inf.model.Subject;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the subject service. This utility wraps {@link hu.unideb.inf.service.persistence.impl.SubjectPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see SubjectPersistence
 * @see hu.unideb.inf.service.persistence.impl.SubjectPersistenceImpl
 * @generated
 */
@ProviderType
public class SubjectUtil {
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
	public static void clearCache(Subject subject) {
		getPersistence().clearCache(subject);
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
	public static List<Subject> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Subject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Subject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Subject> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Subject update(Subject subject) {
		return getPersistence().update(subject);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Subject update(Subject subject, ServiceContext serviceContext) {
		return getPersistence().update(subject, serviceContext);
	}

	/**
	* Returns the subject where curriculumId = &#63; and subjectCode = &#63; or throws a {@link NoSuchSubjectException} if it could not be found.
	*
	* @param curriculumId the curriculum ID
	* @param subjectCode the subject code
	* @return the matching subject
	* @throws NoSuchSubjectException if a matching subject could not be found
	*/
	public static Subject findByC_S(long curriculumId,
		java.lang.String subjectCode)
		throws hu.unideb.inf.exception.NoSuchSubjectException {
		return getPersistence().findByC_S(curriculumId, subjectCode);
	}

	/**
	* Returns the subject where curriculumId = &#63; and subjectCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param curriculumId the curriculum ID
	* @param subjectCode the subject code
	* @return the matching subject, or <code>null</code> if a matching subject could not be found
	*/
	public static Subject fetchByC_S(long curriculumId,
		java.lang.String subjectCode) {
		return getPersistence().fetchByC_S(curriculumId, subjectCode);
	}

	/**
	* Returns the subject where curriculumId = &#63; and subjectCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param curriculumId the curriculum ID
	* @param subjectCode the subject code
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching subject, or <code>null</code> if a matching subject could not be found
	*/
	public static Subject fetchByC_S(long curriculumId,
		java.lang.String subjectCode, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByC_S(curriculumId, subjectCode, retrieveFromCache);
	}

	/**
	* Removes the subject where curriculumId = &#63; and subjectCode = &#63; from the database.
	*
	* @param curriculumId the curriculum ID
	* @param subjectCode the subject code
	* @return the subject that was removed
	*/
	public static Subject removeByC_S(long curriculumId,
		java.lang.String subjectCode)
		throws hu.unideb.inf.exception.NoSuchSubjectException {
		return getPersistence().removeByC_S(curriculumId, subjectCode);
	}

	/**
	* Returns the number of subjects where curriculumId = &#63; and subjectCode = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @param subjectCode the subject code
	* @return the number of matching subjects
	*/
	public static int countByC_S(long curriculumId, java.lang.String subjectCode) {
		return getPersistence().countByC_S(curriculumId, subjectCode);
	}

	/**
	* Returns all the subjects where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @return the matching subjects
	*/
	public static List<Subject> findByCurriculum(long curriculumId) {
		return getPersistence().findByCurriculum(curriculumId);
	}

	/**
	* Returns a range of all the subjects where curriculumId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param curriculumId the curriculum ID
	* @param start the lower bound of the range of subjects
	* @param end the upper bound of the range of subjects (not inclusive)
	* @return the range of matching subjects
	*/
	public static List<Subject> findByCurriculum(long curriculumId, int start,
		int end) {
		return getPersistence().findByCurriculum(curriculumId, start, end);
	}

	/**
	* Returns an ordered range of all the subjects where curriculumId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param curriculumId the curriculum ID
	* @param start the lower bound of the range of subjects
	* @param end the upper bound of the range of subjects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subjects
	*/
	public static List<Subject> findByCurriculum(long curriculumId, int start,
		int end, OrderByComparator<Subject> orderByComparator) {
		return getPersistence()
				   .findByCurriculum(curriculumId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the subjects where curriculumId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param curriculumId the curriculum ID
	* @param start the lower bound of the range of subjects
	* @param end the upper bound of the range of subjects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching subjects
	*/
	public static List<Subject> findByCurriculum(long curriculumId, int start,
		int end, OrderByComparator<Subject> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCurriculum(curriculumId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first subject in the ordered set where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subject
	* @throws NoSuchSubjectException if a matching subject could not be found
	*/
	public static Subject findByCurriculum_First(long curriculumId,
		OrderByComparator<Subject> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchSubjectException {
		return getPersistence()
				   .findByCurriculum_First(curriculumId, orderByComparator);
	}

	/**
	* Returns the first subject in the ordered set where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subject, or <code>null</code> if a matching subject could not be found
	*/
	public static Subject fetchByCurriculum_First(long curriculumId,
		OrderByComparator<Subject> orderByComparator) {
		return getPersistence()
				   .fetchByCurriculum_First(curriculumId, orderByComparator);
	}

	/**
	* Returns the last subject in the ordered set where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subject
	* @throws NoSuchSubjectException if a matching subject could not be found
	*/
	public static Subject findByCurriculum_Last(long curriculumId,
		OrderByComparator<Subject> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchSubjectException {
		return getPersistence()
				   .findByCurriculum_Last(curriculumId, orderByComparator);
	}

	/**
	* Returns the last subject in the ordered set where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subject, or <code>null</code> if a matching subject could not be found
	*/
	public static Subject fetchByCurriculum_Last(long curriculumId,
		OrderByComparator<Subject> orderByComparator) {
		return getPersistence()
				   .fetchByCurriculum_Last(curriculumId, orderByComparator);
	}

	/**
	* Returns the subjects before and after the current subject in the ordered set where curriculumId = &#63;.
	*
	* @param subjectId the primary key of the current subject
	* @param curriculumId the curriculum ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subject
	* @throws NoSuchSubjectException if a subject with the primary key could not be found
	*/
	public static Subject[] findByCurriculum_PrevAndNext(long subjectId,
		long curriculumId, OrderByComparator<Subject> orderByComparator)
		throws hu.unideb.inf.exception.NoSuchSubjectException {
		return getPersistence()
				   .findByCurriculum_PrevAndNext(subjectId, curriculumId,
			orderByComparator);
	}

	/**
	* Removes all the subjects where curriculumId = &#63; from the database.
	*
	* @param curriculumId the curriculum ID
	*/
	public static void removeByCurriculum(long curriculumId) {
		getPersistence().removeByCurriculum(curriculumId);
	}

	/**
	* Returns the number of subjects where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @return the number of matching subjects
	*/
	public static int countByCurriculum(long curriculumId) {
		return getPersistence().countByCurriculum(curriculumId);
	}

	/**
	* Caches the subject in the entity cache if it is enabled.
	*
	* @param subject the subject
	*/
	public static void cacheResult(Subject subject) {
		getPersistence().cacheResult(subject);
	}

	/**
	* Caches the subjects in the entity cache if it is enabled.
	*
	* @param subjects the subjects
	*/
	public static void cacheResult(List<Subject> subjects) {
		getPersistence().cacheResult(subjects);
	}

	/**
	* Creates a new subject with the primary key. Does not add the subject to the database.
	*
	* @param subjectId the primary key for the new subject
	* @return the new subject
	*/
	public static Subject create(long subjectId) {
		return getPersistence().create(subjectId);
	}

	/**
	* Removes the subject with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subjectId the primary key of the subject
	* @return the subject that was removed
	* @throws NoSuchSubjectException if a subject with the primary key could not be found
	*/
	public static Subject remove(long subjectId)
		throws hu.unideb.inf.exception.NoSuchSubjectException {
		return getPersistence().remove(subjectId);
	}

	public static Subject updateImpl(Subject subject) {
		return getPersistence().updateImpl(subject);
	}

	/**
	* Returns the subject with the primary key or throws a {@link NoSuchSubjectException} if it could not be found.
	*
	* @param subjectId the primary key of the subject
	* @return the subject
	* @throws NoSuchSubjectException if a subject with the primary key could not be found
	*/
	public static Subject findByPrimaryKey(long subjectId)
		throws hu.unideb.inf.exception.NoSuchSubjectException {
		return getPersistence().findByPrimaryKey(subjectId);
	}

	/**
	* Returns the subject with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param subjectId the primary key of the subject
	* @return the subject, or <code>null</code> if a subject with the primary key could not be found
	*/
	public static Subject fetchByPrimaryKey(long subjectId) {
		return getPersistence().fetchByPrimaryKey(subjectId);
	}

	public static java.util.Map<java.io.Serializable, Subject> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the subjects.
	*
	* @return the subjects
	*/
	public static List<Subject> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the subjects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subjects
	* @param end the upper bound of the range of subjects (not inclusive)
	* @return the range of subjects
	*/
	public static List<Subject> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the subjects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subjects
	* @param end the upper bound of the range of subjects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of subjects
	*/
	public static List<Subject> findAll(int start, int end,
		OrderByComparator<Subject> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the subjects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subjects
	* @param end the upper bound of the range of subjects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of subjects
	*/
	public static List<Subject> findAll(int start, int end,
		OrderByComparator<Subject> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the subjects from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of subjects.
	*
	* @return the number of subjects
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SubjectPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SubjectPersistence, SubjectPersistence> _serviceTracker =
		ServiceTrackerFactory.open(SubjectPersistence.class);
}