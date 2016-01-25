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

import hu.unideb.inf.model.Curriculum;

import java.util.List;

/**
 * The persistence utility for the curriculum service. This utility wraps {@link CurriculumPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see CurriculumPersistence
 * @see CurriculumPersistenceImpl
 * @generated
 */
public class CurriculumUtil {
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
	public static void clearCache(Curriculum curriculum) {
		getPersistence().clearCache(curriculum);
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
	public static List<Curriculum> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Curriculum> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Curriculum> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Curriculum update(Curriculum curriculum)
		throws SystemException {
		return getPersistence().update(curriculum);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Curriculum update(Curriculum curriculum,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(curriculum, serviceContext);
	}

	/**
	* Returns the curriculum where curriculumCode = &#63; or throws a {@link hu.unideb.inf.NoSuchCurriculumException} if it could not be found.
	*
	* @param curriculumCode the curriculum code
	* @return the matching curriculum
	* @throws hu.unideb.inf.NoSuchCurriculumException if a matching curriculum could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Curriculum findByCode(
		java.lang.String curriculumCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchCurriculumException {
		return getPersistence().findByCode(curriculumCode);
	}

	/**
	* Returns the curriculum where curriculumCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param curriculumCode the curriculum code
	* @return the matching curriculum, or <code>null</code> if a matching curriculum could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Curriculum fetchByCode(
		java.lang.String curriculumCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode(curriculumCode);
	}

	/**
	* Returns the curriculum where curriculumCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param curriculumCode the curriculum code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching curriculum, or <code>null</code> if a matching curriculum could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Curriculum fetchByCode(
		java.lang.String curriculumCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCode(curriculumCode, retrieveFromCache);
	}

	/**
	* Removes the curriculum where curriculumCode = &#63; from the database.
	*
	* @param curriculumCode the curriculum code
	* @return the curriculum that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Curriculum removeByCode(
		java.lang.String curriculumCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchCurriculumException {
		return getPersistence().removeByCode(curriculumCode);
	}

	/**
	* Returns the number of curriculums where curriculumCode = &#63;.
	*
	* @param curriculumCode the curriculum code
	* @return the number of matching curriculums
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCode(java.lang.String curriculumCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCode(curriculumCode);
	}

	/**
	* Caches the curriculum in the entity cache if it is enabled.
	*
	* @param curriculum the curriculum
	*/
	public static void cacheResult(hu.unideb.inf.model.Curriculum curriculum) {
		getPersistence().cacheResult(curriculum);
	}

	/**
	* Caches the curriculums in the entity cache if it is enabled.
	*
	* @param curriculums the curriculums
	*/
	public static void cacheResult(
		java.util.List<hu.unideb.inf.model.Curriculum> curriculums) {
		getPersistence().cacheResult(curriculums);
	}

	/**
	* Creates a new curriculum with the primary key. Does not add the curriculum to the database.
	*
	* @param curriculumId the primary key for the new curriculum
	* @return the new curriculum
	*/
	public static hu.unideb.inf.model.Curriculum create(long curriculumId) {
		return getPersistence().create(curriculumId);
	}

	/**
	* Removes the curriculum with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param curriculumId the primary key of the curriculum
	* @return the curriculum that was removed
	* @throws hu.unideb.inf.NoSuchCurriculumException if a curriculum with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Curriculum remove(long curriculumId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchCurriculumException {
		return getPersistence().remove(curriculumId);
	}

	public static hu.unideb.inf.model.Curriculum updateImpl(
		hu.unideb.inf.model.Curriculum curriculum)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(curriculum);
	}

	/**
	* Returns the curriculum with the primary key or throws a {@link hu.unideb.inf.NoSuchCurriculumException} if it could not be found.
	*
	* @param curriculumId the primary key of the curriculum
	* @return the curriculum
	* @throws hu.unideb.inf.NoSuchCurriculumException if a curriculum with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Curriculum findByPrimaryKey(
		long curriculumId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchCurriculumException {
		return getPersistence().findByPrimaryKey(curriculumId);
	}

	/**
	* Returns the curriculum with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param curriculumId the primary key of the curriculum
	* @return the curriculum, or <code>null</code> if a curriculum with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Curriculum fetchByPrimaryKey(
		long curriculumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(curriculumId);
	}

	/**
	* Returns all the curriculums.
	*
	* @return the curriculums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Curriculum> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the curriculums.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.CurriculumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of curriculums
	* @param end the upper bound of the range of curriculums (not inclusive)
	* @return the range of curriculums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Curriculum> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the curriculums.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.CurriculumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of curriculums
	* @param end the upper bound of the range of curriculums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of curriculums
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Curriculum> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the curriculums from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of curriculums.
	*
	* @return the number of curriculums
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CurriculumPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CurriculumPersistence)PortletBeanLocatorUtil.locate(hu.unideb.inf.service.ClpSerializer.getServletContextName(),
					CurriculumPersistence.class.getName());

			ReferenceRegistry.registerReference(CurriculumUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CurriculumPersistence persistence) {
	}

	private static CurriculumPersistence _persistence;
}