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

import hu.unideb.inf.exception.NoSuchSemesterException;
import hu.unideb.inf.model.Semester;

/**
 * The persistence interface for the semester service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see hu.unideb.inf.service.persistence.impl.SemesterPersistenceImpl
 * @see SemesterUtil
 * @generated
 */
@ProviderType
public interface SemesterPersistence extends BasePersistence<Semester> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SemesterUtil} to access the semester persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the semester where beginYear = &#63; and endYear = &#63; and division = &#63; or throws a {@link NoSuchSemesterException} if it could not be found.
	*
	* @param beginYear the begin year
	* @param endYear the end year
	* @param division the division
	* @return the matching semester
	* @throws NoSuchSemesterException if a matching semester could not be found
	*/
	public Semester findByB_E_D(int beginYear, int endYear, int division)
		throws NoSuchSemesterException;

	/**
	* Returns the semester where beginYear = &#63; and endYear = &#63; and division = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param beginYear the begin year
	* @param endYear the end year
	* @param division the division
	* @return the matching semester, or <code>null</code> if a matching semester could not be found
	*/
	public Semester fetchByB_E_D(int beginYear, int endYear, int division);

	/**
	* Returns the semester where beginYear = &#63; and endYear = &#63; and division = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param beginYear the begin year
	* @param endYear the end year
	* @param division the division
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching semester, or <code>null</code> if a matching semester could not be found
	*/
	public Semester fetchByB_E_D(int beginYear, int endYear, int division,
		boolean retrieveFromCache);

	/**
	* Removes the semester where beginYear = &#63; and endYear = &#63; and division = &#63; from the database.
	*
	* @param beginYear the begin year
	* @param endYear the end year
	* @param division the division
	* @return the semester that was removed
	*/
	public Semester removeByB_E_D(int beginYear, int endYear, int division)
		throws NoSuchSemesterException;

	/**
	* Returns the number of semesters where beginYear = &#63; and endYear = &#63; and division = &#63;.
	*
	* @param beginYear the begin year
	* @param endYear the end year
	* @param division the division
	* @return the number of matching semesters
	*/
	public int countByB_E_D(int beginYear, int endYear, int division);

	/**
	* Caches the semester in the entity cache if it is enabled.
	*
	* @param semester the semester
	*/
	public void cacheResult(Semester semester);

	/**
	* Caches the semesters in the entity cache if it is enabled.
	*
	* @param semesters the semesters
	*/
	public void cacheResult(java.util.List<Semester> semesters);

	/**
	* Creates a new semester with the primary key. Does not add the semester to the database.
	*
	* @param semesterId the primary key for the new semester
	* @return the new semester
	*/
	public Semester create(long semesterId);

	/**
	* Removes the semester with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param semesterId the primary key of the semester
	* @return the semester that was removed
	* @throws NoSuchSemesterException if a semester with the primary key could not be found
	*/
	public Semester remove(long semesterId) throws NoSuchSemesterException;

	public Semester updateImpl(Semester semester);

	/**
	* Returns the semester with the primary key or throws a {@link NoSuchSemesterException} if it could not be found.
	*
	* @param semesterId the primary key of the semester
	* @return the semester
	* @throws NoSuchSemesterException if a semester with the primary key could not be found
	*/
	public Semester findByPrimaryKey(long semesterId)
		throws NoSuchSemesterException;

	/**
	* Returns the semester with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param semesterId the primary key of the semester
	* @return the semester, or <code>null</code> if a semester with the primary key could not be found
	*/
	public Semester fetchByPrimaryKey(long semesterId);

	@Override
	public java.util.Map<java.io.Serializable, Semester> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the semesters.
	*
	* @return the semesters
	*/
	public java.util.List<Semester> findAll();

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
	public java.util.List<Semester> findAll(int start, int end);

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
	public java.util.List<Semester> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Semester> orderByComparator);

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
	public java.util.List<Semester> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Semester> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the semesters from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of semesters.
	*
	* @return the number of semesters
	*/
	public int countAll();
}