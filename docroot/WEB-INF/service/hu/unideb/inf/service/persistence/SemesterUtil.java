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

import hu.unideb.inf.model.Semester;

import java.util.List;

/**
 * The persistence utility for the semester service. This utility wraps {@link SemesterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see SemesterPersistence
 * @see SemesterPersistenceImpl
 * @generated
 */
public class SemesterUtil {
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
	public static void clearCache(Semester semester) {
		getPersistence().clearCache(semester);
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
	public static List<Semester> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Semester> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Semester> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Semester update(Semester semester) throws SystemException {
		return getPersistence().update(semester);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Semester update(Semester semester,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(semester, serviceContext);
	}

	/**
	* Returns the semester where beginYear = &#63; and endYear = &#63; and division = &#63; or throws a {@link hu.unideb.inf.NoSuchSemesterException} if it could not be found.
	*
	* @param beginYear the begin year
	* @param endYear the end year
	* @param division the division
	* @return the matching semester
	* @throws hu.unideb.inf.NoSuchSemesterException if a matching semester could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Semester findByB_E_D(int beginYear,
		int endYear, int division)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchSemesterException {
		return getPersistence().findByB_E_D(beginYear, endYear, division);
	}

	/**
	* Returns the semester where beginYear = &#63; and endYear = &#63; and division = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param beginYear the begin year
	* @param endYear the end year
	* @param division the division
	* @return the matching semester, or <code>null</code> if a matching semester could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Semester fetchByB_E_D(int beginYear,
		int endYear, int division)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByB_E_D(beginYear, endYear, division);
	}

	/**
	* Returns the semester where beginYear = &#63; and endYear = &#63; and division = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param beginYear the begin year
	* @param endYear the end year
	* @param division the division
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching semester, or <code>null</code> if a matching semester could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Semester fetchByB_E_D(int beginYear,
		int endYear, int division, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
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
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Semester removeByB_E_D(int beginYear,
		int endYear, int division)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchSemesterException {
		return getPersistence().removeByB_E_D(beginYear, endYear, division);
	}

	/**
	* Returns the number of semesters where beginYear = &#63; and endYear = &#63; and division = &#63;.
	*
	* @param beginYear the begin year
	* @param endYear the end year
	* @param division the division
	* @return the number of matching semesters
	* @throws SystemException if a system exception occurred
	*/
	public static int countByB_E_D(int beginYear, int endYear, int division)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByB_E_D(beginYear, endYear, division);
	}

	/**
	* Caches the semester in the entity cache if it is enabled.
	*
	* @param semester the semester
	*/
	public static void cacheResult(hu.unideb.inf.model.Semester semester) {
		getPersistence().cacheResult(semester);
	}

	/**
	* Caches the semesters in the entity cache if it is enabled.
	*
	* @param semesters the semesters
	*/
	public static void cacheResult(
		java.util.List<hu.unideb.inf.model.Semester> semesters) {
		getPersistence().cacheResult(semesters);
	}

	/**
	* Creates a new semester with the primary key. Does not add the semester to the database.
	*
	* @param semesterId the primary key for the new semester
	* @return the new semester
	*/
	public static hu.unideb.inf.model.Semester create(long semesterId) {
		return getPersistence().create(semesterId);
	}

	/**
	* Removes the semester with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param semesterId the primary key of the semester
	* @return the semester that was removed
	* @throws hu.unideb.inf.NoSuchSemesterException if a semester with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Semester remove(long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchSemesterException {
		return getPersistence().remove(semesterId);
	}

	public static hu.unideb.inf.model.Semester updateImpl(
		hu.unideb.inf.model.Semester semester)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(semester);
	}

	/**
	* Returns the semester with the primary key or throws a {@link hu.unideb.inf.NoSuchSemesterException} if it could not be found.
	*
	* @param semesterId the primary key of the semester
	* @return the semester
	* @throws hu.unideb.inf.NoSuchSemesterException if a semester with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Semester findByPrimaryKey(long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchSemesterException {
		return getPersistence().findByPrimaryKey(semesterId);
	}

	/**
	* Returns the semester with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param semesterId the primary key of the semester
	* @return the semester, or <code>null</code> if a semester with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Semester fetchByPrimaryKey(
		long semesterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(semesterId);
	}

	/**
	* Returns all the semesters.
	*
	* @return the semesters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Semester> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the semesters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SemesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of semesters
	* @param end the upper bound of the range of semesters (not inclusive)
	* @return the range of semesters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Semester> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the semesters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SemesterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of semesters
	* @param end the upper bound of the range of semesters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of semesters
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Semester> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the semesters from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of semesters.
	*
	* @return the number of semesters
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SemesterPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SemesterPersistence)PortletBeanLocatorUtil.locate(hu.unideb.inf.service.ClpSerializer.getServletContextName(),
					SemesterPersistence.class.getName());

			ReferenceRegistry.registerReference(SemesterUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SemesterPersistence persistence) {
	}

	private static SemesterPersistence _persistence;
}