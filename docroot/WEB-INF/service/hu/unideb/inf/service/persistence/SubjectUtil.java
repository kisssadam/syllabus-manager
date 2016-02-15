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

import hu.unideb.inf.model.Subject;

import java.util.List;

/**
 * The persistence utility for the subject service. This utility wraps {@link SubjectPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see SubjectPersistence
 * @see SubjectPersistenceImpl
 * @generated
 */
public class SubjectUtil {
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
	public static void clearCache(Subject subject) {
		getPersistence().clearCache(subject);
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
	public static List<Subject> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Subject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Subject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Subject update(Subject subject) throws SystemException {
		return getPersistence().update(subject);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Subject update(Subject subject, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(subject, serviceContext);
	}

	/**
	* Returns the subject where curriculumId = &#63; and subjectCode = &#63; or throws a {@link hu.unideb.inf.NoSuchSubjectException} if it could not be found.
	*
	* @param curriculumId the curriculum ID
	* @param subjectCode the subject code
	* @return the matching subject
	* @throws hu.unideb.inf.NoSuchSubjectException if a matching subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Subject findByC_S(long curriculumId,
		java.lang.String subjectCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchSubjectException {
		return getPersistence().findByC_S(curriculumId, subjectCode);
	}

	/**
	* Returns the subject where curriculumId = &#63; and subjectCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param curriculumId the curriculum ID
	* @param subjectCode the subject code
	* @return the matching subject, or <code>null</code> if a matching subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Subject fetchByC_S(long curriculumId,
		java.lang.String subjectCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_S(curriculumId, subjectCode);
	}

	/**
	* Returns the subject where curriculumId = &#63; and subjectCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param curriculumId the curriculum ID
	* @param subjectCode the subject code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching subject, or <code>null</code> if a matching subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Subject fetchByC_S(long curriculumId,
		java.lang.String subjectCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_S(curriculumId, subjectCode, retrieveFromCache);
	}

	/**
	* Removes the subject where curriculumId = &#63; and subjectCode = &#63; from the database.
	*
	* @param curriculumId the curriculum ID
	* @param subjectCode the subject code
	* @return the subject that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Subject removeByC_S(long curriculumId,
		java.lang.String subjectCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchSubjectException {
		return getPersistence().removeByC_S(curriculumId, subjectCode);
	}

	/**
	* Returns the number of subjects where curriculumId = &#63; and subjectCode = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @param subjectCode the subject code
	* @return the number of matching subjects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_S(long curriculumId, java.lang.String subjectCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_S(curriculumId, subjectCode);
	}

	/**
	* Returns all the subjects where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @return the matching subjects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Subject> findByCurriculum(
		long curriculumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCurriculum(curriculumId);
	}

	/**
	* Returns a range of all the subjects where curriculumId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param curriculumId the curriculum ID
	* @param start the lower bound of the range of subjects
	* @param end the upper bound of the range of subjects (not inclusive)
	* @return the range of matching subjects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Subject> findByCurriculum(
		long curriculumId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCurriculum(curriculumId, start, end);
	}

	/**
	* Returns an ordered range of all the subjects where curriculumId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param curriculumId the curriculum ID
	* @param start the lower bound of the range of subjects
	* @param end the upper bound of the range of subjects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subjects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Subject> findByCurriculum(
		long curriculumId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCurriculum(curriculumId, start, end, orderByComparator);
	}

	/**
	* Returns the first subject in the ordered set where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subject
	* @throws hu.unideb.inf.NoSuchSubjectException if a matching subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Subject findByCurriculum_First(
		long curriculumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchSubjectException {
		return getPersistence()
				   .findByCurriculum_First(curriculumId, orderByComparator);
	}

	/**
	* Returns the first subject in the ordered set where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subject, or <code>null</code> if a matching subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Subject fetchByCurriculum_First(
		long curriculumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCurriculum_First(curriculumId, orderByComparator);
	}

	/**
	* Returns the last subject in the ordered set where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subject
	* @throws hu.unideb.inf.NoSuchSubjectException if a matching subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Subject findByCurriculum_Last(
		long curriculumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchSubjectException {
		return getPersistence()
				   .findByCurriculum_Last(curriculumId, orderByComparator);
	}

	/**
	* Returns the last subject in the ordered set where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subject, or <code>null</code> if a matching subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Subject fetchByCurriculum_Last(
		long curriculumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
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
	* @throws hu.unideb.inf.NoSuchSubjectException if a subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Subject[] findByCurriculum_PrevAndNext(
		long subjectId, long curriculumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchSubjectException {
		return getPersistence()
				   .findByCurriculum_PrevAndNext(subjectId, curriculumId,
			orderByComparator);
	}

	/**
	* Removes all the subjects where curriculumId = &#63; from the database.
	*
	* @param curriculumId the curriculum ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCurriculum(long curriculumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCurriculum(curriculumId);
	}

	/**
	* Returns the number of subjects where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @return the number of matching subjects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCurriculum(long curriculumId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCurriculum(curriculumId);
	}

	/**
	* Caches the subject in the entity cache if it is enabled.
	*
	* @param subject the subject
	*/
	public static void cacheResult(hu.unideb.inf.model.Subject subject) {
		getPersistence().cacheResult(subject);
	}

	/**
	* Caches the subjects in the entity cache if it is enabled.
	*
	* @param subjects the subjects
	*/
	public static void cacheResult(
		java.util.List<hu.unideb.inf.model.Subject> subjects) {
		getPersistence().cacheResult(subjects);
	}

	/**
	* Creates a new subject with the primary key. Does not add the subject to the database.
	*
	* @param subjectId the primary key for the new subject
	* @return the new subject
	*/
	public static hu.unideb.inf.model.Subject create(long subjectId) {
		return getPersistence().create(subjectId);
	}

	/**
	* Removes the subject with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subjectId the primary key of the subject
	* @return the subject that was removed
	* @throws hu.unideb.inf.NoSuchSubjectException if a subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Subject remove(long subjectId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchSubjectException {
		return getPersistence().remove(subjectId);
	}

	public static hu.unideb.inf.model.Subject updateImpl(
		hu.unideb.inf.model.Subject subject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(subject);
	}

	/**
	* Returns the subject with the primary key or throws a {@link hu.unideb.inf.NoSuchSubjectException} if it could not be found.
	*
	* @param subjectId the primary key of the subject
	* @return the subject
	* @throws hu.unideb.inf.NoSuchSubjectException if a subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Subject findByPrimaryKey(long subjectId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchSubjectException {
		return getPersistence().findByPrimaryKey(subjectId);
	}

	/**
	* Returns the subject with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param subjectId the primary key of the subject
	* @return the subject, or <code>null</code> if a subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static hu.unideb.inf.model.Subject fetchByPrimaryKey(long subjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(subjectId);
	}

	/**
	* Returns all the subjects.
	*
	* @return the subjects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Subject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the subjects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subjects
	* @param end the upper bound of the range of subjects (not inclusive)
	* @return the range of subjects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Subject> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the subjects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subjects
	* @param end the upper bound of the range of subjects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of subjects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<hu.unideb.inf.model.Subject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the subjects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of subjects.
	*
	* @return the number of subjects
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SubjectPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SubjectPersistence)PortletBeanLocatorUtil.locate(hu.unideb.inf.service.ClpSerializer.getServletContextName(),
					SubjectPersistence.class.getName());

			ReferenceRegistry.registerReference(SubjectUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SubjectPersistence persistence) {
	}

	private static SubjectPersistence _persistence;
}