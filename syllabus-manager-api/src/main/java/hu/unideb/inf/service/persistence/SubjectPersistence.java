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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import hu.unideb.inf.exception.NoSuchSubjectException;
import hu.unideb.inf.model.Subject;

/**
 * The persistence interface for the subject service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see hu.unideb.inf.service.persistence.impl.SubjectPersistenceImpl
 * @see SubjectUtil
 * @generated
 */
@ProviderType
public interface SubjectPersistence extends BasePersistence<Subject> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubjectUtil} to access the subject persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the subject where curriculumId = &#63; and subjectCode = &#63; or throws a {@link NoSuchSubjectException} if it could not be found.
	*
	* @param curriculumId the curriculum ID
	* @param subjectCode the subject code
	* @return the matching subject
	* @throws NoSuchSubjectException if a matching subject could not be found
	*/
	public Subject findByC_S(long curriculumId, java.lang.String subjectCode)
		throws NoSuchSubjectException;

	/**
	* Returns the subject where curriculumId = &#63; and subjectCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param curriculumId the curriculum ID
	* @param subjectCode the subject code
	* @return the matching subject, or <code>null</code> if a matching subject could not be found
	*/
	public Subject fetchByC_S(long curriculumId, java.lang.String subjectCode);

	/**
	* Returns the subject where curriculumId = &#63; and subjectCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param curriculumId the curriculum ID
	* @param subjectCode the subject code
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching subject, or <code>null</code> if a matching subject could not be found
	*/
	public Subject fetchByC_S(long curriculumId, java.lang.String subjectCode,
		boolean retrieveFromCache);

	/**
	* Removes the subject where curriculumId = &#63; and subjectCode = &#63; from the database.
	*
	* @param curriculumId the curriculum ID
	* @param subjectCode the subject code
	* @return the subject that was removed
	*/
	public Subject removeByC_S(long curriculumId, java.lang.String subjectCode)
		throws NoSuchSubjectException;

	/**
	* Returns the number of subjects where curriculumId = &#63; and subjectCode = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @param subjectCode the subject code
	* @return the number of matching subjects
	*/
	public int countByC_S(long curriculumId, java.lang.String subjectCode);

	/**
	* Returns all the subjects where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @return the matching subjects
	*/
	public java.util.List<Subject> findByCurriculum(long curriculumId);

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
	public java.util.List<Subject> findByCurriculum(long curriculumId,
		int start, int end);

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
	public java.util.List<Subject> findByCurriculum(long curriculumId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subject> orderByComparator);

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
	public java.util.List<Subject> findByCurriculum(long curriculumId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subject> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first subject in the ordered set where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subject
	* @throws NoSuchSubjectException if a matching subject could not be found
	*/
	public Subject findByCurriculum_First(long curriculumId,
		com.liferay.portal.kernel.util.OrderByComparator<Subject> orderByComparator)
		throws NoSuchSubjectException;

	/**
	* Returns the first subject in the ordered set where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subject, or <code>null</code> if a matching subject could not be found
	*/
	public Subject fetchByCurriculum_First(long curriculumId,
		com.liferay.portal.kernel.util.OrderByComparator<Subject> orderByComparator);

	/**
	* Returns the last subject in the ordered set where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subject
	* @throws NoSuchSubjectException if a matching subject could not be found
	*/
	public Subject findByCurriculum_Last(long curriculumId,
		com.liferay.portal.kernel.util.OrderByComparator<Subject> orderByComparator)
		throws NoSuchSubjectException;

	/**
	* Returns the last subject in the ordered set where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subject, or <code>null</code> if a matching subject could not be found
	*/
	public Subject fetchByCurriculum_Last(long curriculumId,
		com.liferay.portal.kernel.util.OrderByComparator<Subject> orderByComparator);

	/**
	* Returns the subjects before and after the current subject in the ordered set where curriculumId = &#63;.
	*
	* @param subjectId the primary key of the current subject
	* @param curriculumId the curriculum ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subject
	* @throws NoSuchSubjectException if a subject with the primary key could not be found
	*/
	public Subject[] findByCurriculum_PrevAndNext(long subjectId,
		long curriculumId,
		com.liferay.portal.kernel.util.OrderByComparator<Subject> orderByComparator)
		throws NoSuchSubjectException;

	/**
	* Removes all the subjects where curriculumId = &#63; from the database.
	*
	* @param curriculumId the curriculum ID
	*/
	public void removeByCurriculum(long curriculumId);

	/**
	* Returns the number of subjects where curriculumId = &#63;.
	*
	* @param curriculumId the curriculum ID
	* @return the number of matching subjects
	*/
	public int countByCurriculum(long curriculumId);

	/**
	* Caches the subject in the entity cache if it is enabled.
	*
	* @param subject the subject
	*/
	public void cacheResult(Subject subject);

	/**
	* Caches the subjects in the entity cache if it is enabled.
	*
	* @param subjects the subjects
	*/
	public void cacheResult(java.util.List<Subject> subjects);

	/**
	* Creates a new subject with the primary key. Does not add the subject to the database.
	*
	* @param subjectId the primary key for the new subject
	* @return the new subject
	*/
	public Subject create(long subjectId);

	/**
	* Removes the subject with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subjectId the primary key of the subject
	* @return the subject that was removed
	* @throws NoSuchSubjectException if a subject with the primary key could not be found
	*/
	public Subject remove(long subjectId) throws NoSuchSubjectException;

	public Subject updateImpl(Subject subject);

	/**
	* Returns the subject with the primary key or throws a {@link NoSuchSubjectException} if it could not be found.
	*
	* @param subjectId the primary key of the subject
	* @return the subject
	* @throws NoSuchSubjectException if a subject with the primary key could not be found
	*/
	public Subject findByPrimaryKey(long subjectId)
		throws NoSuchSubjectException;

	/**
	* Returns the subject with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param subjectId the primary key of the subject
	* @return the subject, or <code>null</code> if a subject with the primary key could not be found
	*/
	public Subject fetchByPrimaryKey(long subjectId);

	@Override
	public java.util.Map<java.io.Serializable, Subject> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the subjects.
	*
	* @return the subjects
	*/
	public java.util.List<Subject> findAll();

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
	public java.util.List<Subject> findAll(int start, int end);

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
	public java.util.List<Subject> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subject> orderByComparator);

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
	public java.util.List<Subject> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subject> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the subjects from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of subjects.
	*
	* @return the number of subjects
	*/
	public int countAll();
}