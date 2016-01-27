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

import com.liferay.portal.service.persistence.BasePersistence;

import hu.unideb.inf.model.Subject;

/**
 * The persistence interface for the subject service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see SubjectPersistenceImpl
 * @see SubjectUtil
 * @generated
 */
public interface SubjectPersistence extends BasePersistence<Subject> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubjectUtil} to access the subject persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the subject where subjectCode = &#63; or throws a {@link hu.unideb.inf.NoSuchSubjectException} if it could not be found.
	*
	* @param subjectCode the subject code
	* @return the matching subject
	* @throws hu.unideb.inf.NoSuchSubjectException if a matching subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.Subject findBySubjectCode(
		java.lang.String subjectCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchSubjectException;

	/**
	* Returns the subject where subjectCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param subjectCode the subject code
	* @return the matching subject, or <code>null</code> if a matching subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.Subject fetchBySubjectCode(
		java.lang.String subjectCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the subject where subjectCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param subjectCode the subject code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching subject, or <code>null</code> if a matching subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.Subject fetchBySubjectCode(
		java.lang.String subjectCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the subject where subjectCode = &#63; from the database.
	*
	* @param subjectCode the subject code
	* @return the subject that was removed
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.Subject removeBySubjectCode(
		java.lang.String subjectCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchSubjectException;

	/**
	* Returns the number of subjects where subjectCode = &#63;.
	*
	* @param subjectCode the subject code
	* @return the number of matching subjects
	* @throws SystemException if a system exception occurred
	*/
	public int countBySubjectCode(java.lang.String subjectCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the subjects where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @return the matching subjects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.unideb.inf.model.Subject> findByCurriculum(
		long curriculumId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.unideb.inf.model.Subject> findByCurriculum(
		long curriculumId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.unideb.inf.model.Subject> findByCurriculum(
		long curriculumId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first subject in the ordered set where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subject
	* @throws hu.unideb.inf.NoSuchSubjectException if a matching subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.Subject findByCurriculum_First(
		long curriculumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchSubjectException;

	/**
	* Returns the first subject in the ordered set where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subject, or <code>null</code> if a matching subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.Subject fetchByCurriculum_First(
		long curriculumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last subject in the ordered set where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subject
	* @throws hu.unideb.inf.NoSuchSubjectException if a matching subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.Subject findByCurriculum_Last(
		long curriculumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchSubjectException;

	/**
	* Returns the last subject in the ordered set where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subject, or <code>null</code> if a matching subject could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.Subject fetchByCurriculum_Last(
		long curriculumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public hu.unideb.inf.model.Subject[] findByCurriculum_PrevAndNext(
		long subjectId, long curriculumId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchSubjectException;

	/**
	* Removes all the subjects where curriculumId = &#63; from the database.
	*
	* @param curriculumId the curriculum ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCurriculum(long curriculumId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of subjects where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @return the number of matching subjects
	* @throws SystemException if a system exception occurred
	*/
	public int countByCurriculum(long curriculumId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the subject in the entity cache if it is enabled.
	*
	* @param subject the subject
	*/
	public void cacheResult(hu.unideb.inf.model.Subject subject);

	/**
	* Caches the subjects in the entity cache if it is enabled.
	*
	* @param subjects the subjects
	*/
	public void cacheResult(
		java.util.List<hu.unideb.inf.model.Subject> subjects);

	/**
	* Creates a new subject with the primary key. Does not add the subject to the database.
	*
	* @param subjectId the primary key for the new subject
	* @return the new subject
	*/
	public hu.unideb.inf.model.Subject create(long subjectId);

	/**
	* Removes the subject with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subjectId the primary key of the subject
	* @return the subject that was removed
	* @throws hu.unideb.inf.NoSuchSubjectException if a subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.Subject remove(long subjectId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchSubjectException;

	public hu.unideb.inf.model.Subject updateImpl(
		hu.unideb.inf.model.Subject subject)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the subject with the primary key or throws a {@link hu.unideb.inf.NoSuchSubjectException} if it could not be found.
	*
	* @param subjectId the primary key of the subject
	* @return the subject
	* @throws hu.unideb.inf.NoSuchSubjectException if a subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.Subject findByPrimaryKey(long subjectId)
		throws com.liferay.portal.kernel.exception.SystemException,
			hu.unideb.inf.NoSuchSubjectException;

	/**
	* Returns the subject with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param subjectId the primary key of the subject
	* @return the subject, or <code>null</code> if a subject with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public hu.unideb.inf.model.Subject fetchByPrimaryKey(long subjectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the subjects.
	*
	* @return the subjects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<hu.unideb.inf.model.Subject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.unideb.inf.model.Subject> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<hu.unideb.inf.model.Subject> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the subjects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of subjects.
	*
	* @return the number of subjects
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}