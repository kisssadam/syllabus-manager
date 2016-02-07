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

import hu.unideb.inf.NoSuchTimetableCourseException;
import hu.unideb.inf.model.TimetableCourse;
import hu.unideb.inf.model.impl.TimetableCourseImpl;
import hu.unideb.inf.model.impl.TimetableCourseModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the timetable course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see TimetableCoursePersistence
 * @see TimetableCourseUtil
 * @generated
 */
public class TimetableCoursePersistenceImpl extends BasePersistenceImpl<TimetableCourse>
	implements TimetableCoursePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TimetableCourseUtil} to access the timetable course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TimetableCourseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseModelImpl.FINDER_CACHE_ENABLED,
			TimetableCourseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseModelImpl.FINDER_CACHE_ENABLED,
			TimetableCourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TimetableCoursePersistenceImpl() {
		setModelClass(TimetableCourse.class);
	}

	/**
	 * Caches the timetable course in the entity cache if it is enabled.
	 *
	 * @param timetableCourse the timetable course
	 */
	@Override
	public void cacheResult(TimetableCourse timetableCourse) {
		EntityCacheUtil.putResult(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseImpl.class, timetableCourse.getPrimaryKey(),
			timetableCourse);

		timetableCourse.resetOriginalValues();
	}

	/**
	 * Caches the timetable courses in the entity cache if it is enabled.
	 *
	 * @param timetableCourses the timetable courses
	 */
	@Override
	public void cacheResult(List<TimetableCourse> timetableCourses) {
		for (TimetableCourse timetableCourse : timetableCourses) {
			if (EntityCacheUtil.getResult(
						TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
						TimetableCourseImpl.class,
						timetableCourse.getPrimaryKey()) == null) {
				cacheResult(timetableCourse);
			}
			else {
				timetableCourse.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all timetable courses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TimetableCourseImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TimetableCourseImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the timetable course.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TimetableCourse timetableCourse) {
		EntityCacheUtil.removeResult(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseImpl.class, timetableCourse.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TimetableCourse> timetableCourses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TimetableCourse timetableCourse : timetableCourses) {
			EntityCacheUtil.removeResult(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
				TimetableCourseImpl.class, timetableCourse.getPrimaryKey());
		}
	}

	/**
	 * Creates a new timetable course with the primary key. Does not add the timetable course to the database.
	 *
	 * @param timetableCourseId the primary key for the new timetable course
	 * @return the new timetable course
	 */
	@Override
	public TimetableCourse create(long timetableCourseId) {
		TimetableCourse timetableCourse = new TimetableCourseImpl();

		timetableCourse.setNew(true);
		timetableCourse.setPrimaryKey(timetableCourseId);

		return timetableCourse;
	}

	/**
	 * Removes the timetable course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param timetableCourseId the primary key of the timetable course
	 * @return the timetable course that was removed
	 * @throws hu.unideb.inf.NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse remove(long timetableCourseId)
		throws NoSuchTimetableCourseException, SystemException {
		return remove((Serializable)timetableCourseId);
	}

	/**
	 * Removes the timetable course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the timetable course
	 * @return the timetable course that was removed
	 * @throws hu.unideb.inf.NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse remove(Serializable primaryKey)
		throws NoSuchTimetableCourseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TimetableCourse timetableCourse = (TimetableCourse)session.get(TimetableCourseImpl.class,
					primaryKey);

			if (timetableCourse == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTimetableCourseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(timetableCourse);
		}
		catch (NoSuchTimetableCourseException nsee) {
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
	protected TimetableCourse removeImpl(TimetableCourse timetableCourse)
		throws SystemException {
		timetableCourse = toUnwrappedModel(timetableCourse);

		timetableCourseToLecturerTableMapper.deleteLeftPrimaryKeyTableMappings(timetableCourse.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(timetableCourse)) {
				timetableCourse = (TimetableCourse)session.get(TimetableCourseImpl.class,
						timetableCourse.getPrimaryKeyObj());
			}

			if (timetableCourse != null) {
				session.delete(timetableCourse);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (timetableCourse != null) {
			clearCache(timetableCourse);
		}

		return timetableCourse;
	}

	@Override
	public TimetableCourse updateImpl(
		hu.unideb.inf.model.TimetableCourse timetableCourse)
		throws SystemException {
		timetableCourse = toUnwrappedModel(timetableCourse);

		boolean isNew = timetableCourse.isNew();

		Session session = null;

		try {
			session = openSession();

			if (timetableCourse.isNew()) {
				session.save(timetableCourse);

				timetableCourse.setNew(false);
			}
			else {
				session.merge(timetableCourse);
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

		EntityCacheUtil.putResult(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseImpl.class, timetableCourse.getPrimaryKey(),
			timetableCourse);

		return timetableCourse;
	}

	protected TimetableCourse toUnwrappedModel(TimetableCourse timetableCourse) {
		if (timetableCourse instanceof TimetableCourseImpl) {
			return timetableCourse;
		}

		TimetableCourseImpl timetableCourseImpl = new TimetableCourseImpl();

		timetableCourseImpl.setNew(timetableCourse.isNew());
		timetableCourseImpl.setPrimaryKey(timetableCourse.getPrimaryKey());

		timetableCourseImpl.setTimetableCourseId(timetableCourse.getTimetableCourseId());
		timetableCourseImpl.setGroupId(timetableCourse.getGroupId());
		timetableCourseImpl.setCompanyId(timetableCourse.getCompanyId());
		timetableCourseImpl.setUserId(timetableCourse.getUserId());
		timetableCourseImpl.setUserName(timetableCourse.getUserName());
		timetableCourseImpl.setCreateDate(timetableCourse.getCreateDate());
		timetableCourseImpl.setModifiedDate(timetableCourse.getModifiedDate());
		timetableCourseImpl.setCourseId(timetableCourse.getCourseId());
		timetableCourseImpl.setSubjectType(timetableCourse.getSubjectType());
		timetableCourseImpl.setRecommendedTerm(timetableCourse.getRecommendedTerm());
		timetableCourseImpl.setLimit(timetableCourse.getLimit());
		timetableCourseImpl.setClassScheduleInfo(timetableCourse.getClassScheduleInfo());
		timetableCourseImpl.setDescription(timetableCourse.getDescription());

		return timetableCourseImpl;
	}

	/**
	 * Returns the timetable course with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the timetable course
	 * @return the timetable course
	 * @throws hu.unideb.inf.NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTimetableCourseException, SystemException {
		TimetableCourse timetableCourse = fetchByPrimaryKey(primaryKey);

		if (timetableCourse == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTimetableCourseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return timetableCourse;
	}

	/**
	 * Returns the timetable course with the primary key or throws a {@link hu.unideb.inf.NoSuchTimetableCourseException} if it could not be found.
	 *
	 * @param timetableCourseId the primary key of the timetable course
	 * @return the timetable course
	 * @throws hu.unideb.inf.NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse findByPrimaryKey(long timetableCourseId)
		throws NoSuchTimetableCourseException, SystemException {
		return findByPrimaryKey((Serializable)timetableCourseId);
	}

	/**
	 * Returns the timetable course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the timetable course
	 * @return the timetable course, or <code>null</code> if a timetable course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TimetableCourse timetableCourse = (TimetableCourse)EntityCacheUtil.getResult(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
				TimetableCourseImpl.class, primaryKey);

		if (timetableCourse == _nullTimetableCourse) {
			return null;
		}

		if (timetableCourse == null) {
			Session session = null;

			try {
				session = openSession();

				timetableCourse = (TimetableCourse)session.get(TimetableCourseImpl.class,
						primaryKey);

				if (timetableCourse != null) {
					cacheResult(timetableCourse);
				}
				else {
					EntityCacheUtil.putResult(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
						TimetableCourseImpl.class, primaryKey,
						_nullTimetableCourse);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
					TimetableCourseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return timetableCourse;
	}

	/**
	 * Returns the timetable course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param timetableCourseId the primary key of the timetable course
	 * @return the timetable course, or <code>null</code> if a timetable course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse fetchByPrimaryKey(long timetableCourseId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)timetableCourseId);
	}

	/**
	 * Returns all the timetable courses.
	 *
	 * @return the timetable courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TimetableCourse> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the timetable courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @return the range of timetable courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TimetableCourse> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the timetable courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of timetable courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TimetableCourse> findAll(int start, int end,
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

		List<TimetableCourse> list = (List<TimetableCourse>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TIMETABLECOURSE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TIMETABLECOURSE;

				if (pagination) {
					sql = sql.concat(TimetableCourseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TimetableCourse>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TimetableCourse>(list);
				}
				else {
					list = (List<TimetableCourse>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the timetable courses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TimetableCourse timetableCourse : findAll()) {
			remove(timetableCourse);
		}
	}

	/**
	 * Returns the number of timetable courses.
	 *
	 * @return the number of timetable courses
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

				Query q = session.createQuery(_SQL_COUNT_TIMETABLECOURSE);

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
	 * Returns all the lecturers associated with the timetable course.
	 *
	 * @param pk the primary key of the timetable course
	 * @return the lecturers associated with the timetable course
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<hu.unideb.inf.model.Lecturer> getLecturers(long pk)
		throws SystemException {
		return getLecturers(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the lecturers associated with the timetable course.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the timetable course
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @return the range of lecturers associated with the timetable course
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<hu.unideb.inf.model.Lecturer> getLecturers(long pk, int start,
		int end) throws SystemException {
		return getLecturers(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lecturers associated with the timetable course.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the timetable course
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lecturers associated with the timetable course
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<hu.unideb.inf.model.Lecturer> getLecturers(long pk, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		return timetableCourseToLecturerTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of lecturers associated with the timetable course.
	 *
	 * @param pk the primary key of the timetable course
	 * @return the number of lecturers associated with the timetable course
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getLecturersSize(long pk) throws SystemException {
		long[] pks = timetableCourseToLecturerTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the lecturer is associated with the timetable course.
	 *
	 * @param pk the primary key of the timetable course
	 * @param lecturerPK the primary key of the lecturer
	 * @return <code>true</code> if the lecturer is associated with the timetable course; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsLecturer(long pk, long lecturerPK)
		throws SystemException {
		return timetableCourseToLecturerTableMapper.containsTableMapping(pk,
			lecturerPK);
	}

	/**
	 * Returns <code>true</code> if the timetable course has any lecturers associated with it.
	 *
	 * @param pk the primary key of the timetable course to check for associations with lecturers
	 * @return <code>true</code> if the timetable course has any lecturers associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsLecturers(long pk) throws SystemException {
		if (getLecturersSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the timetable course
	 * @param lecturerPK the primary key of the lecturer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addLecturer(long pk, long lecturerPK) throws SystemException {
		timetableCourseToLecturerTableMapper.addTableMapping(pk, lecturerPK);
	}

	/**
	 * Adds an association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the timetable course
	 * @param lecturer the lecturer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addLecturer(long pk, hu.unideb.inf.model.Lecturer lecturer)
		throws SystemException {
		timetableCourseToLecturerTableMapper.addTableMapping(pk,
			lecturer.getPrimaryKey());
	}

	/**
	 * Adds an association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the timetable course
	 * @param lecturerPKs the primary keys of the lecturers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addLecturers(long pk, long[] lecturerPKs)
		throws SystemException {
		for (long lecturerPK : lecturerPKs) {
			timetableCourseToLecturerTableMapper.addTableMapping(pk, lecturerPK);
		}
	}

	/**
	 * Adds an association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the timetable course
	 * @param lecturers the lecturers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addLecturers(long pk,
		List<hu.unideb.inf.model.Lecturer> lecturers) throws SystemException {
		for (hu.unideb.inf.model.Lecturer lecturer : lecturers) {
			timetableCourseToLecturerTableMapper.addTableMapping(pk,
				lecturer.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the timetable course and its lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the timetable course to clear the associated lecturers from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearLecturers(long pk) throws SystemException {
		timetableCourseToLecturerTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the timetable course
	 * @param lecturerPK the primary key of the lecturer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeLecturer(long pk, long lecturerPK)
		throws SystemException {
		timetableCourseToLecturerTableMapper.deleteTableMapping(pk, lecturerPK);
	}

	/**
	 * Removes the association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the timetable course
	 * @param lecturer the lecturer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeLecturer(long pk, hu.unideb.inf.model.Lecturer lecturer)
		throws SystemException {
		timetableCourseToLecturerTableMapper.deleteTableMapping(pk,
			lecturer.getPrimaryKey());
	}

	/**
	 * Removes the association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the timetable course
	 * @param lecturerPKs the primary keys of the lecturers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeLecturers(long pk, long[] lecturerPKs)
		throws SystemException {
		for (long lecturerPK : lecturerPKs) {
			timetableCourseToLecturerTableMapper.deleteTableMapping(pk,
				lecturerPK);
		}
	}

	/**
	 * Removes the association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the timetable course
	 * @param lecturers the lecturers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeLecturers(long pk,
		List<hu.unideb.inf.model.Lecturer> lecturers) throws SystemException {
		for (hu.unideb.inf.model.Lecturer lecturer : lecturers) {
			timetableCourseToLecturerTableMapper.deleteTableMapping(pk,
				lecturer.getPrimaryKey());
		}
	}

	/**
	 * Sets the lecturers associated with the timetable course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the timetable course
	 * @param lecturerPKs the primary keys of the lecturers to be associated with the timetable course
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setLecturers(long pk, long[] lecturerPKs)
		throws SystemException {
		Set<Long> newLecturerPKsSet = SetUtil.fromArray(lecturerPKs);
		Set<Long> oldLecturerPKsSet = SetUtil.fromArray(timetableCourseToLecturerTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeLecturerPKsSet = new HashSet<Long>(oldLecturerPKsSet);

		removeLecturerPKsSet.removeAll(newLecturerPKsSet);

		for (long removeLecturerPK : removeLecturerPKsSet) {
			timetableCourseToLecturerTableMapper.deleteTableMapping(pk,
				removeLecturerPK);
		}

		newLecturerPKsSet.removeAll(oldLecturerPKsSet);

		for (long newLecturerPK : newLecturerPKsSet) {
			timetableCourseToLecturerTableMapper.addTableMapping(pk,
				newLecturerPK);
		}
	}

	/**
	 * Sets the lecturers associated with the timetable course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the timetable course
	 * @param lecturers the lecturers to be associated with the timetable course
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setLecturers(long pk,
		List<hu.unideb.inf.model.Lecturer> lecturers) throws SystemException {
		try {
			long[] lecturerPKs = new long[lecturers.size()];

			for (int i = 0; i < lecturers.size(); i++) {
				hu.unideb.inf.model.Lecturer lecturer = lecturers.get(i);

				lecturerPKs[i] = lecturer.getPrimaryKey();
			}

			setLecturers(pk, lecturerPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(TimetableCourseModelImpl.MAPPING_TABLE_UNIDEB_SYLLABUS_MANAGER_LECTURERS_TIMETABLECOURSES_NAME);
		}
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the timetable course persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.hu.unideb.inf.model.TimetableCourse")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TimetableCourse>> listenersList = new ArrayList<ModelListener<TimetableCourse>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TimetableCourse>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		timetableCourseToLecturerTableMapper = TableMapperFactory.getTableMapper("unideb_syllabus_manager_Lecturers_TimetableCourses",
				"timetableCourseId", "lecturerId", this, lecturerPersistence);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TimetableCourseImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper(
			"unideb_syllabus_manager_Lecturers_TimetableCourses");
	}

	@BeanReference(type = LecturerPersistence.class)
	protected LecturerPersistence lecturerPersistence;
	protected TableMapper<TimetableCourse, hu.unideb.inf.model.Lecturer> timetableCourseToLecturerTableMapper;
	private static final String _SQL_SELECT_TIMETABLECOURSE = "SELECT timetableCourse FROM TimetableCourse timetableCourse";
	private static final String _SQL_COUNT_TIMETABLECOURSE = "SELECT COUNT(timetableCourse) FROM TimetableCourse timetableCourse";
	private static final String _ORDER_BY_ENTITY_ALIAS = "timetableCourse.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TimetableCourse exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TimetableCoursePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"limit"
			});
	private static TimetableCourse _nullTimetableCourse = new TimetableCourseImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TimetableCourse> toCacheModel() {
				return _nullTimetableCourseCacheModel;
			}
		};

	private static CacheModel<TimetableCourse> _nullTimetableCourseCacheModel = new CacheModel<TimetableCourse>() {
			@Override
			public TimetableCourse toEntityModel() {
				return _nullTimetableCourse;
			}
		};
}