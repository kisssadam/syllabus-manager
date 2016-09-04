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

import hu.unideb.inf.model.Semester;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the semester service. This utility wraps {@link hu.unideb.inf.service.persistence.impl.SemesterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see SemesterPersistence
 * @see hu.unideb.inf.service.persistence.impl.SemesterPersistenceImpl
 * @generated
 */
@ProviderType
public class SemesterUtil {
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
	public static void clearCache(Semester semester) {
		getPersistence().clearCache(semester);
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
	public static List<Semester> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Semester> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Semester> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Semester> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Semester update(Semester semester) {
		return getPersistence().update(semester);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Semester update(Semester semester,
		ServiceContext serviceContext) {
		return getPersistence().update(semester, serviceContext);
	}

	/**
	* Returns the semester where beginYear = &#63; and endYear = &#63; and division = &#63; or throws a {@link NoSuchSemesterException} if it could not be found.
	*
	* @param beginYear the begin year
	* @param endYear the end year
	* @param division the division
	* @return the matching semester
	* @throws NoSuchSemesterException if a matching semester could not be found
	*/
	public static Semester findByB_E_D(int beginYear, int endYear, int division)
		throws hu.unideb.inf.exception.NoSuchSemesterException {
		return getPersistence().findByB_E_D(beginYear, endYear, division);
	}

	/**
	* Returns the semester where beginYear = &#63; and endYear = &#63; and division = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param beginYear the begin year
	* @param endYear the end year
	* @param division the division
	* @return the matching semester, or <code>null</code> if a matching semester could not be found
	*/
	public static Semester fetchByB_E_D(int beginYear, int endYear, int division) {
		return getPersistence().fetchByB_E_D(beginYear, endYear, division);
	}

	/**
	* Returns the semester where beginYear = &#63; and endYear = &#63; and division = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param beginYear the begin year
	* @param endYear the end year
	* @param division the division
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching semester, or <code>null</code> if a matching semester could not be found
	*/
	public static Semester fetchByB_E_D(int beginYear, int endYear,
		int division, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByB_E_D(beginYear, endYear, division, retrieveFromCache);
	}

	/**
	* Removes the semester where beginYear = &#63; and endYear = &#63; and division = &#63; from the database.
	*
	* @param beginYear the begin year
	* @param endYear the end year
	* @param division the division
	* @return the semester that was removed
	*/
	public static Semester removeByB_E_D(int beginYear, int endYear,
		int division) throws hu.unideb.inf.exception.NoSuchSemesterException {
		return getPersistence().removeByB_E_D(beginYear, endYear, division);
	}

	/**
	* Returns the number of semesters where beginYear = &#63; and endYear = &#63; and division = &#63;.
	*
	* @param beginYear the begin year
	* @param endYear the end year
	* @param division the division
	* @return the number of matching semesters
	*/
	public static int countByB_E_D(int beginYear, int endYear, int division) {
		return getPersistence().countByB_E_D(beginYear, endYear, division);
	}

	/**
	* Caches the semester in the entity cache if it is enabled.
	*
	* @param semester the semester
	*/
	public static void cacheResult(Semester semester) {
		getPersistence().cacheResult(semester);
	}

	/**
	* Caches the semesters in the entity cache if it is enabled.
	*
	* @param semesters the semesters
	*/
	public static void cacheResult(List<Semester> semesters) {
		getPersistence().cacheResult(semesters);
	}

	/**
	* Creates a new semester with the primary key. Does not add the semester to the database.
	*
	* @param semesterId the primary key for the new semester
	* @return the new semester
	*/
	public static Semester create(long semesterId) {
		return getPersistence().create(semesterId);
	}

	/**
	* Removes the semester with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param semesterId the primary key of the semester
	* @return the semester that was removed
	* @throws NoSuchSemesterException if a semester with the primary key could not be found
	*/
	public static Semester remove(long semesterId)
		throws hu.unideb.inf.exception.NoSuchSemesterException {
		return getPersistence().remove(semesterId);
	}

	public static Semester updateImpl(Semester semester) {
		return getPersistence().updateImpl(semester);
	}

	/**
	* Returns the semester with the primary key or throws a {@link NoSuchSemesterException} if it could not be found.
	*
	* @param semesterId the primary key of the semester
	* @return the semester
	* @throws NoSuchSemesterException if a semester with the primary key could not be found
	*/
	public static Semester findByPrimaryKey(long semesterId)
		throws hu.unideb.inf.exception.NoSuchSemesterException {
		return getPersistence().findByPrimaryKey(semesterId);
	}

	/**
	* Returns the semester with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param semesterId the primary key of the semester
	* @return the semester, or <code>null</code> if a semester with the primary key could not be found
	*/
	public static Semester fetchByPrimaryKey(long semesterId) {
		return getPersistence().fetchByPrimaryKey(semesterId);
	}

	public static java.util.Map<java.io.Serializable, Semester> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the semesters.
	*
	* @return the semesters
	*/
	public static List<Semester> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the semesters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SemesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of semesters
	* @param end the upper bound of the range of semesters (not inclusive)
	* @return the range of semesters
	*/
	public static List<Semester> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the semesters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SemesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of semesters
	* @param end the upper bound of the range of semesters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of semesters
	*/
	public static List<Semester> findAll(int start, int end,
		OrderByComparator<Semester> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the semesters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SemesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of semesters
	* @param end the upper bound of the range of semesters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of semesters
	*/
	public static List<Semester> findAll(int start, int end,
		OrderByComparator<Semester> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the semesters from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of semesters.
	*
	* @return the number of semesters
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SemesterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SemesterPersistence, SemesterPersistence> _serviceTracker =
		ServiceTrackerFactory.open(SemesterPersistence.class);
}