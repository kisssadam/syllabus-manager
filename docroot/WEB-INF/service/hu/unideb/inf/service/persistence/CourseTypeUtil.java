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

import hu.unideb.inf.model.CourseType;

import java.util.List;

/**
 * The persistence utility for the course type service. This utility wraps {@link CourseTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see CourseTypePersistence
 * @see CourseTypePersistenceImpl
 * @generated
 */
public class CourseTypeUtil {
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
	public static void clearCache(CourseType courseType) {
		getPersistence().clearCache(courseType);
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
	public static List<CourseType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CourseType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CourseType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CourseType update(CourseType courseType)
		throws SystemException {
		return getPersistence().update(courseType);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CourseType update(CourseType courseType,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(courseType, serviceContext);
	}

	/**
	* Returns the course type where type = &#63; or throws a {@link hu.unideb.inf.NoSuchCourseTypeException} if it could not be found.
	*
	* @param type the type
	* @return the matching course type
	* @throws hu.unideb.inf.NoSuchCourseTypeException if a matching course type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.CourseType findByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchCourseTypeException {
		return getPersistence().findByType(type);
	}

	/**
	* Returns the course type where type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param type the type
	* @return the matching course type, or <code>null</code> if a matching course type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.CourseType fetchByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType(type);
	}

	/**
	* Returns the course type where type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param type the type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching course type, or <code>null</code> if a matching course type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.CourseType fetchByType(
		java.lang.String type, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType(type, retrieveFromCache);
	}

	/**
	* Removes the course type where type = &#63; from the database.
	*
	* @param type the type
	* @return the course type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.CourseType removeByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchCourseTypeException {
		return getPersistence().removeByType(type);
	}

	/**
	* Returns the number of course types where type = &#63;.
	*
	* @param type the type
	* @return the number of matching course types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByType(type);
	}

	/**
	* Caches the course type in the entity cache if it is enabled.
	*
	* @param courseType the course type
	*/
	public static void cacheResult(hu.unideb.inf.model.CourseType courseType) {
		getPersistence().cacheResult(courseType);
	}

	/**
	* Caches the course types in the entity cache if it is enabled.
	*
	* @param courseTypes the course types
	*/
	public static void cacheResult(
		java.util.List<hu.unideb.inf.model.CourseType> courseTypes) {
		getPersistence().cacheResult(courseTypes);
	}

	/**
	* Creates a new course type with the primary key. Does not add the course type to the database.
	*
	* @param courseTypeId the primary key for the new course type
	* @return the new course type
	*/
	public static hu.unideb.inf.model.CourseType create(long courseTypeId) {
		return getPersistence().create(courseTypeId);
	}

	/**
	* Removes the course type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param courseTypeId the primary key of the course type
	* @return the course type that was removed
	* @throws hu.unideb.inf.NoSuchCourseTypeException if a course type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.CourseType remove(long courseTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchCourseTypeException {
		return getPersistence().remove(courseTypeId);
	}

	public static hu.unideb.inf.model.CourseType updateImpl(
		hu.unideb.inf.model.CourseType courseType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(courseType);
	}

	/**
	* Returns the course type with the primary key or throws a {@link hu.unideb.inf.NoSuchCourseTypeException} if it could not be found.
	*
	* @param courseTypeId the primary key of the course type
	* @return the course type
	* @throws hu.unideb.inf.NoSuchCourseTypeException if a course type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.CourseType findByPrimaryKey(
		long courseTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchCourseTypeException {
		return getPersistence().findByPrimaryKey(courseTypeId);
	}

	/**
	* Returns the course type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param courseTypeId the primary key of the course type
	* @return the course type, or <code>null</code> if a course type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.CourseType fetchByPrimaryKey(
		long courseTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(courseTypeId);
	}

	/**
	* Returns all the course types.
	*
	* @return the course types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.CourseType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the course types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.CourseTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course types
	* @param end the upper bound of the range of course types (not inclusive)
	* @return the range of course types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.CourseType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the course types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.CourseTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course types
	* @param end the upper bound of the range of course types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of course types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.CourseType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the course types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of course types.
	*
	* @return the number of course types
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CourseTypePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CourseTypePersistence)PortletBeanLocatorUtil.locate(hu.unideb.inf.service.ClpSerializer.getServletContextName(),
					CourseTypePersistence.class.getName());

			ReferenceRegistry.registerReference(CourseTypeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CourseTypePersistence persistence) {
	}

	private static CourseTypePersistence _persistence;
}