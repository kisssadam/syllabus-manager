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

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.service.persistence.impl.TableMapper;
import com.liferay.portal.service.persistence.impl.TableMapperFactory;

import hu.unideb.inf.NoSuchLecturerException;
import hu.unideb.inf.model.Lecturer;
import hu.unideb.inf.model.impl.LecturerImpl;
import hu.unideb.inf.model.impl.LecturerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the lecturer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see LecturerPersistence
 * @see LecturerUtil
 * @generated
 */
public class LecturerPersistenceImpl extends BasePersistenceImpl<Lecturer>
	implements LecturerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LecturerUtil} to access the lecturer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LecturerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LecturerModelImpl.ENTITY_CACHE_ENABLED,
			LecturerModelImpl.FINDER_CACHE_ENABLED, LecturerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LecturerModelImpl.ENTITY_CACHE_ENABLED,
			LecturerModelImpl.FINDER_CACHE_ENABLED, LecturerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LecturerModelImpl.ENTITY_CACHE_ENABLED,
			LecturerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LecturerPersistenceImpl() {
		setModelClass(Lecturer.class);
	}

	/**
	 * Caches the lecturer in the entity cache if it is enabled.
	 *
	 * @param lecturer the lecturer
	 */
	@Override
	public void cacheResult(Lecturer lecturer) {
		EntityCacheUtil.putResult(LecturerModelImpl.ENTITY_CACHE_ENABLED,
			LecturerImpl.class, lecturer.getPrimaryKey(), lecturer);

		lecturer.resetOriginalValues();
	}

	/**
	 * Caches the lecturers in the entity cache if it is enabled.
	 *
	 * @param lecturers the lecturers
	 */
	@Override
	public void cacheResult(List<Lecturer> lecturers) {
		for (Lecturer lecturer : lecturers) {
			if (EntityCacheUtil.getResult(
						LecturerModelImpl.ENTITY_CACHE_ENABLED,
						LecturerImpl.class, lecturer.getPrimaryKey()) == null) {
				cacheResult(lecturer);
			}
			else {
				lecturer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lecturers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LecturerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LecturerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lecturer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Lecturer lecturer) {
		EntityCacheUtil.removeResult(LecturerModelImpl.ENTITY_CACHE_ENABLED,
			LecturerImpl.class, lecturer.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Lecturer> lecturers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Lecturer lecturer : lecturers) {
			EntityCacheUtil.removeResult(LecturerModelImpl.ENTITY_CACHE_ENABLED,
				LecturerImpl.class, lecturer.getPrimaryKey());
		}
	}

	/**
	 * Creates a new lecturer with the primary key. Does not add the lecturer to the database.
	 *
	 * @param lecturerId the primary key for the new lecturer
	 * @return the new lecturer
	 */
	@Override
	public Lecturer create(long lecturerId) {
		Lecturer lecturer = new LecturerImpl();

		lecturer.setNew(true);
		lecturer.setPrimaryKey(lecturerId);

		return lecturer;
	}

	/**
	 * Removes the lecturer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lecturerId the primary key of the lecturer
	 * @return the lecturer that was removed
	 * @throws hu.unideb.inf.NoSuchLecturerException if a lecturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lecturer remove(long lecturerId)
		throws NoSuchLecturerException, SystemException {
		return remove((Serializable)lecturerId);
	}

	/**
	 * Removes the lecturer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lecturer
	 * @return the lecturer that was removed
	 * @throws hu.unideb.inf.NoSuchLecturerException if a lecturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lecturer remove(Serializable primaryKey)
		throws NoSuchLecturerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Lecturer lecturer = (Lecturer)session.get(LecturerImpl.class,
					primaryKey);

			if (lecturer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLecturerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(lecturer);
		}
		catch (NoSuchLecturerException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Lecturer removeImpl(Lecturer lecturer) throws SystemException {
		lecturer = toUnwrappedModel(lecturer);

		lecturerToTimetableCourseTableMapper.deleteLeftPrimaryKeyTableMappings(lecturer.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lecturer)) {
				lecturer = (Lecturer)session.get(LecturerImpl.class,
						lecturer.getPrimaryKeyObj());
			}

			if (lecturer != null) {
				session.delete(lecturer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (lecturer != null) {
			clearCache(lecturer);
		}

		return lecturer;
	}

	@Override
	public Lecturer updateImpl(hu.unideb.inf.model.Lecturer lecturer)
		throws SystemException {
		lecturer = toUnwrappedModel(lecturer);

		boolean isNew = lecturer.isNew();

		Session session = null;

		try {
			session = openSession();

			if (lecturer.isNew()) {
				session.save(lecturer);

				lecturer.setNew(false);
			}
			else {
				session.merge(lecturer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(LecturerModelImpl.ENTITY_CACHE_ENABLED,
			LecturerImpl.class, lecturer.getPrimaryKey(), lecturer);

		return lecturer;
	}

	protected Lecturer toUnwrappedModel(Lecturer lecturer) {
		if (lecturer instanceof LecturerImpl) {
			return lecturer;
		}

		LecturerImpl lecturerImpl = new LecturerImpl();

		lecturerImpl.setNew(lecturer.isNew());
		lecturerImpl.setPrimaryKey(lecturer.getPrimaryKey());

		lecturerImpl.setLecturerId(lecturer.getLecturerId());
		lecturerImpl.setLecturerName(lecturer.getLecturerName());
		lecturerImpl.setUserId(lecturer.getUserId());

		return lecturerImpl;
	}

	/**
	 * Returns the lecturer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lecturer
	 * @return the lecturer
	 * @throws hu.unideb.inf.NoSuchLecturerException if a lecturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lecturer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLecturerException, SystemException {
		Lecturer lecturer = fetchByPrimaryKey(primaryKey);

		if (lecturer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLecturerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lecturer;
	}

	/**
	 * Returns the lecturer with the primary key or throws a {@link hu.unideb.inf.NoSuchLecturerException} if it could not be found.
	 *
	 * @param lecturerId the primary key of the lecturer
	 * @return the lecturer
	 * @throws hu.unideb.inf.NoSuchLecturerException if a lecturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lecturer findByPrimaryKey(long lecturerId)
		throws NoSuchLecturerException, SystemException {
		return findByPrimaryKey((Serializable)lecturerId);
	}

	/**
	 * Returns the lecturer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lecturer
	 * @return the lecturer, or <code>null</code> if a lecturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lecturer fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Lecturer lecturer = (Lecturer)EntityCacheUtil.getResult(LecturerModelImpl.ENTITY_CACHE_ENABLED,
				LecturerImpl.class, primaryKey);

		if (lecturer == _nullLecturer) {
			return null;
		}

		if (lecturer == null) {
			Session session = null;

			try {
				session = openSession();

				lecturer = (Lecturer)session.get(LecturerImpl.class, primaryKey);

				if (lecturer != null) {
					cacheResult(lecturer);
				}
				else {
					EntityCacheUtil.putResult(LecturerModelImpl.ENTITY_CACHE_ENABLED,
						LecturerImpl.class, primaryKey, _nullLecturer);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LecturerModelImpl.ENTITY_CACHE_ENABLED,
					LecturerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return lecturer;
	}

	/**
	 * Returns the lecturer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lecturerId the primary key of the lecturer
	 * @return the lecturer, or <code>null</code> if a lecturer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Lecturer fetchByPrimaryKey(long lecturerId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)lecturerId);
	}

	/**
	 * Returns all the lecturers.
	 *
	 * @return the lecturers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lecturer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lecturers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lecturers
	 * @param end the upper bound of the range of lecturers (not inclusive)
	 * @return the range of lecturers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lecturer> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lecturers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lecturers
	 * @param end the upper bound of the range of lecturers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lecturers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Lecturer> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Lecturer> list = (List<Lecturer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LECTURER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LECTURER;

				if (pagination) {
					sql = sql.concat(LecturerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Lecturer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Lecturer>(list);
				}
				else {
					list = (List<Lecturer>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the lecturers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Lecturer lecturer : findAll()) {
			remove(lecturer);
		}
	}

	/**
	 * Returns the number of lecturers.
	 *
	 * @return the number of lecturers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LECTURER);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns all the timetable courses associated with the lecturer.
	 *
	 * @param pk the primary key of the lecturer
	 * @return the timetable courses associated with the lecturer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		long pk) throws SystemException {
		return getTimetableCourses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the timetable courses associated with the lecturer.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the lecturer
	 * @param start the lower bound of the range of lecturers
	 * @param end the upper bound of the range of lecturers (not inclusive)
	 * @return the range of timetable courses associated with the lecturer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		long pk, int start, int end) throws SystemException {
		return getTimetableCourses(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the timetable courses associated with the lecturer.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the lecturer
	 * @param start the lower bound of the range of lecturers
	 * @param end the upper bound of the range of lecturers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of timetable courses associated with the lecturer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return lecturerToTimetableCourseTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of timetable courses associated with the lecturer.
	 *
	 * @param pk the primary key of the lecturer
	 * @return the number of timetable courses associated with the lecturer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getTimetableCoursesSize(long pk) throws SystemException {
		long[] pks = lecturerToTimetableCourseTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the timetable course is associated with the lecturer.
	 *
	 * @param pk the primary key of the lecturer
	 * @param timetableCoursePK the primary key of the timetable course
	 * @return <code>true</code> if the timetable course is associated with the lecturer; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsTimetableCourse(long pk, long timetableCoursePK)
		throws SystemException {
		return lecturerToTimetableCourseTableMapper.containsTableMapping(pk,
			timetableCoursePK);
	}

	/**
	 * Returns <code>true</code> if the lecturer has any timetable courses associated with it.
	 *
	 * @param pk the primary key of the lecturer to check for associations with timetable courses
	 * @return <code>true</code> if the lecturer has any timetable courses associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsTimetableCourses(long pk) throws SystemException {
		if (getTimetableCoursesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the lecturer
	 * @param timetableCoursePK the primary key of the timetable course
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addTimetableCourse(long pk, long timetableCoursePK)
		throws SystemException {
		lecturerToTimetableCourseTableMapper.addTableMapping(pk,
			timetableCoursePK);
	}

	/**
	 * Adds an association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the lecturer
	 * @param timetableCourse the timetable course
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addTimetableCourse(long pk,
		hu.unideb.inf.model.TimetableCourse timetableCourse)
		throws SystemException {
		lecturerToTimetableCourseTableMapper.addTableMapping(pk,
			timetableCourse.getPrimaryKey());
	}

	/**
	 * Adds an association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the lecturer
	 * @param timetableCoursePKs the primary keys of the timetable courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addTimetableCourses(long pk, long[] timetableCoursePKs)
		throws SystemException {
		for (long timetableCoursePK : timetableCoursePKs) {
			lecturerToTimetableCourseTableMapper.addTableMapping(pk,
				timetableCoursePK);
		}
	}

	/**
	 * Adds an association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the lecturer
	 * @param timetableCourses the timetable courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addTimetableCourses(long pk,
		List<hu.unideb.inf.model.TimetableCourse> timetableCourses)
		throws SystemException {
		for (hu.unideb.inf.model.TimetableCourse timetableCourse : timetableCourses) {
			lecturerToTimetableCourseTableMapper.addTableMapping(pk,
				timetableCourse.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the lecturer and its timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the lecturer to clear the associated timetable courses from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearTimetableCourses(long pk) throws SystemException {
		lecturerToTimetableCourseTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the lecturer
	 * @param timetableCoursePK the primary key of the timetable course
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeTimetableCourse(long pk, long timetableCoursePK)
		throws SystemException {
		lecturerToTimetableCourseTableMapper.deleteTableMapping(pk,
			timetableCoursePK);
	}

	/**
	 * Removes the association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the lecturer
	 * @param timetableCourse the timetable course
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeTimetableCourse(long pk,
		hu.unideb.inf.model.TimetableCourse timetableCourse)
		throws SystemException {
		lecturerToTimetableCourseTableMapper.deleteTableMapping(pk,
			timetableCourse.getPrimaryKey());
	}

	/**
	 * Removes the association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the lecturer
	 * @param timetableCoursePKs the primary keys of the timetable courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeTimetableCourses(long pk, long[] timetableCoursePKs)
		throws SystemException {
		for (long timetableCoursePK : timetableCoursePKs) {
			lecturerToTimetableCourseTableMapper.deleteTableMapping(pk,
				timetableCoursePK);
		}
	}

	/**
	 * Removes the association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the lecturer
	 * @param timetableCourses the timetable courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeTimetableCourses(long pk,
		List<hu.unideb.inf.model.TimetableCourse> timetableCourses)
		throws SystemException {
		for (hu.unideb.inf.model.TimetableCourse timetableCourse : timetableCourses) {
			lecturerToTimetableCourseTableMapper.deleteTableMapping(pk,
				timetableCourse.getPrimaryKey());
		}
	}

	/**
	 * Sets the timetable courses associated with the lecturer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the lecturer
	 * @param timetableCoursePKs the primary keys of the timetable courses to be associated with the lecturer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setTimetableCourses(long pk, long[] timetableCoursePKs)
		throws SystemException {
		Set<Long> newTimetableCoursePKsSet = SetUtil.fromArray(timetableCoursePKs);
		Set<Long> oldTimetableCoursePKsSet = SetUtil.fromArray(lecturerToTimetableCourseTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeTimetableCoursePKsSet = new HashSet<Long>(oldTimetableCoursePKsSet);

		removeTimetableCoursePKsSet.removeAll(newTimetableCoursePKsSet);

		for (long removeTimetableCoursePK : removeTimetableCoursePKsSet) {
			lecturerToTimetableCourseTableMapper.deleteTableMapping(pk,
				removeTimetableCoursePK);
		}

		newTimetableCoursePKsSet.removeAll(oldTimetableCoursePKsSet);

		for (long newTimetableCoursePK : newTimetableCoursePKsSet) {
			lecturerToTimetableCourseTableMapper.addTableMapping(pk,
				newTimetableCoursePK);
		}
	}

	/**
	 * Sets the timetable courses associated with the lecturer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the lecturer
	 * @param timetableCourses the timetable courses to be associated with the lecturer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setTimetableCourses(long pk,
		List<hu.unideb.inf.model.TimetableCourse> timetableCourses)
		throws SystemException {
		try {
			long[] timetableCoursePKs = new long[timetableCourses.size()];

			for (int i = 0; i < timetableCourses.size(); i++) {
				hu.unideb.inf.model.TimetableCourse timetableCourse = timetableCourses.get(i);

				timetableCoursePKs[i] = timetableCourse.getPrimaryKey();
			}

			setTimetableCourses(pk, timetableCoursePKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(LecturerModelImpl.MAPPING_TABLE_UNIDEB_SYLLABUS_MANAGER_LECTURERS_TIMETABLECOURSES_NAME);
		}
	}

	/**
	 * Initializes the lecturer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.hu.unideb.inf.model.Lecturer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Lecturer>> listenersList = new ArrayList<ModelListener<Lecturer>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Lecturer>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		lecturerToTimetableCourseTableMapper = TableMapperFactory.getTableMapper("unideb_syllabus_manager_Lecturers_TimetableCourses",
				"lecturerId", "timetableCourseId", this,
				timetableCoursePersistence);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(LecturerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper(
			"unideb_syllabus_manager_Lecturers_TimetableCourses");
	}

	@BeanReference(type = TimetableCoursePersistence.class)
	protected TimetableCoursePersistence timetableCoursePersistence;
	protected TableMapper<Lecturer, hu.unideb.inf.model.TimetableCourse> lecturerToTimetableCourseTableMapper;
	private static final String _SQL_SELECT_LECTURER = "SELECT lecturer FROM Lecturer lecturer";
	private static final String _SQL_COUNT_LECTURER = "SELECT COUNT(lecturer) FROM Lecturer lecturer";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lecturer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Lecturer exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LecturerPersistenceImpl.class);
	private static Lecturer _nullLecturer = new LecturerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Lecturer> toCacheModel() {
				return _nullLecturerCacheModel;
			}
		};

	private static CacheModel<Lecturer> _nullLecturerCacheModel = new CacheModel<Lecturer>() {
			@Override
			public Lecturer toEntityModel() {
				return _nullLecturer;
			}
		};
}