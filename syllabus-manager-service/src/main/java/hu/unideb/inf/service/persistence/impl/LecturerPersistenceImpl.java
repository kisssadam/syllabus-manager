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

package hu.unideb.inf.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import hu.unideb.inf.exception.NoSuchLecturerException;
import hu.unideb.inf.model.Lecturer;
import hu.unideb.inf.model.impl.LecturerImpl;
import hu.unideb.inf.model.impl.LecturerModelImpl;
import hu.unideb.inf.service.persistence.LecturerPersistence;
import hu.unideb.inf.service.persistence.TimetableCoursePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
 * @see hu.unideb.inf.service.persistence.LecturerUtil
 * @generated
 */
@ProviderType
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
	public static final FinderPath FINDER_PATH_FETCH_BY_LECTURERNAME = new FinderPath(LecturerModelImpl.ENTITY_CACHE_ENABLED,
			LecturerModelImpl.FINDER_CACHE_ENABLED, LecturerImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByLecturerName",
			new String[] { String.class.getName() },
			LecturerModelImpl.LECTURERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LECTURERNAME = new FinderPath(LecturerModelImpl.ENTITY_CACHE_ENABLED,
			LecturerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLecturerName",
			new String[] { String.class.getName() });

	/**
	 * Returns the lecturer where lecturerName = &#63; or throws a {@link NoSuchLecturerException} if it could not be found.
	 *
	 * @param lecturerName the lecturer name
	 * @return the matching lecturer
	 * @throws NoSuchLecturerException if a matching lecturer could not be found
	 */
	@Override
	public Lecturer findByLecturerName(String lecturerName)
		throws NoSuchLecturerException {
		Lecturer lecturer = fetchByLecturerName(lecturerName);

		if (lecturer == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("lecturerName=");
			msg.append(lecturerName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLecturerException(msg.toString());
		}

		return lecturer;
	}

	/**
	 * Returns the lecturer where lecturerName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param lecturerName the lecturer name
	 * @return the matching lecturer, or <code>null</code> if a matching lecturer could not be found
	 */
	@Override
	public Lecturer fetchByLecturerName(String lecturerName) {
		return fetchByLecturerName(lecturerName, true);
	}

	/**
	 * Returns the lecturer where lecturerName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param lecturerName the lecturer name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching lecturer, or <code>null</code> if a matching lecturer could not be found
	 */
	@Override
	public Lecturer fetchByLecturerName(String lecturerName,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { lecturerName };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_LECTURERNAME,
					finderArgs, this);
		}

		if (result instanceof Lecturer) {
			Lecturer lecturer = (Lecturer)result;

			if (!Objects.equals(lecturerName, lecturer.getLecturerName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LECTURER_WHERE);

			boolean bindLecturerName = false;

			if (lecturerName == null) {
				query.append(_FINDER_COLUMN_LECTURERNAME_LECTURERNAME_1);
			}
			else if (lecturerName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LECTURERNAME_LECTURERNAME_3);
			}
			else {
				bindLecturerName = true;

				query.append(_FINDER_COLUMN_LECTURERNAME_LECTURERNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLecturerName) {
					qPos.add(lecturerName);
				}

				List<Lecturer> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_LECTURERNAME,
						finderArgs, list);
				}
				else {
					Lecturer lecturer = list.get(0);

					result = lecturer;

					cacheResult(lecturer);

					if ((lecturer.getLecturerName() == null) ||
							!lecturer.getLecturerName().equals(lecturerName)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_LECTURERNAME,
							finderArgs, lecturer);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_LECTURERNAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Lecturer)result;
		}
	}

	/**
	 * Removes the lecturer where lecturerName = &#63; from the database.
	 *
	 * @param lecturerName the lecturer name
	 * @return the lecturer that was removed
	 */
	@Override
	public Lecturer removeByLecturerName(String lecturerName)
		throws NoSuchLecturerException {
		Lecturer lecturer = findByLecturerName(lecturerName);

		return remove(lecturer);
	}

	/**
	 * Returns the number of lecturers where lecturerName = &#63;.
	 *
	 * @param lecturerName the lecturer name
	 * @return the number of matching lecturers
	 */
	@Override
	public int countByLecturerName(String lecturerName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LECTURERNAME;

		Object[] finderArgs = new Object[] { lecturerName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LECTURER_WHERE);

			boolean bindLecturerName = false;

			if (lecturerName == null) {
				query.append(_FINDER_COLUMN_LECTURERNAME_LECTURERNAME_1);
			}
			else if (lecturerName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LECTURERNAME_LECTURERNAME_3);
			}
			else {
				bindLecturerName = true;

				query.append(_FINDER_COLUMN_LECTURERNAME_LECTURERNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLecturerName) {
					qPos.add(lecturerName);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LECTURERNAME_LECTURERNAME_1 = "lecturer.lecturerName IS NULL";
	private static final String _FINDER_COLUMN_LECTURERNAME_LECTURERNAME_2 = "lecturer.lecturerName = ?";
	private static final String _FINDER_COLUMN_LECTURERNAME_LECTURERNAME_3 = "(lecturer.lecturerName IS NULL OR lecturer.lecturerName = '')";

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
		entityCache.putResult(LecturerModelImpl.ENTITY_CACHE_ENABLED,
			LecturerImpl.class, lecturer.getPrimaryKey(), lecturer);

		finderCache.putResult(FINDER_PATH_FETCH_BY_LECTURERNAME,
			new Object[] { lecturer.getLecturerName() }, lecturer);

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
			if (entityCache.getResult(LecturerModelImpl.ENTITY_CACHE_ENABLED,
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
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LecturerImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lecturer.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Lecturer lecturer) {
		entityCache.removeResult(LecturerModelImpl.ENTITY_CACHE_ENABLED,
			LecturerImpl.class, lecturer.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LecturerModelImpl)lecturer, true);
	}

	@Override
	public void clearCache(List<Lecturer> lecturers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Lecturer lecturer : lecturers) {
			entityCache.removeResult(LecturerModelImpl.ENTITY_CACHE_ENABLED,
				LecturerImpl.class, lecturer.getPrimaryKey());

			clearUniqueFindersCache((LecturerModelImpl)lecturer, true);
		}
	}

	protected void cacheUniqueFindersCache(LecturerModelImpl lecturerModelImpl) {
		Object[] args = new Object[] { lecturerModelImpl.getLecturerName() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_LECTURERNAME, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_LECTURERNAME, args,
			lecturerModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LecturerModelImpl lecturerModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { lecturerModelImpl.getLecturerName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LECTURERNAME, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_LECTURERNAME, args);
		}

		if ((lecturerModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LECTURERNAME.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					lecturerModelImpl.getOriginalLecturerName()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LECTURERNAME, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_LECTURERNAME, args);
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

		lecturer.setCompanyId(companyProvider.getCompanyId());

		return lecturer;
	}

	/**
	 * Removes the lecturer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lecturerId the primary key of the lecturer
	 * @return the lecturer that was removed
	 * @throws NoSuchLecturerException if a lecturer with the primary key could not be found
	 */
	@Override
	public Lecturer remove(long lecturerId) throws NoSuchLecturerException {
		return remove((Serializable)lecturerId);
	}

	/**
	 * Removes the lecturer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lecturer
	 * @return the lecturer that was removed
	 * @throws NoSuchLecturerException if a lecturer with the primary key could not be found
	 */
	@Override
	public Lecturer remove(Serializable primaryKey)
		throws NoSuchLecturerException {
		Session session = null;

		try {
			session = openSession();

			Lecturer lecturer = (Lecturer)session.get(LecturerImpl.class,
					primaryKey);

			if (lecturer == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
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
	protected Lecturer removeImpl(Lecturer lecturer) {
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
	public Lecturer updateImpl(Lecturer lecturer) {
		lecturer = toUnwrappedModel(lecturer);

		boolean isNew = lecturer.isNew();

		LecturerModelImpl lecturerModelImpl = (LecturerModelImpl)lecturer;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (lecturer.getCreateDate() == null)) {
			if (serviceContext == null) {
				lecturer.setCreateDate(now);
			}
			else {
				lecturer.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!lecturerModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				lecturer.setModifiedDate(now);
			}
			else {
				lecturer.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (lecturer.isNew()) {
				session.save(lecturer);

				lecturer.setNew(false);
			}
			else {
				lecturer = (Lecturer)session.merge(lecturer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LecturerModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(LecturerModelImpl.ENTITY_CACHE_ENABLED,
			LecturerImpl.class, lecturer.getPrimaryKey(), lecturer, false);

		clearUniqueFindersCache(lecturerModelImpl, false);
		cacheUniqueFindersCache(lecturerModelImpl);

		lecturer.resetOriginalValues();

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
		lecturerImpl.setGroupId(lecturer.getGroupId());
		lecturerImpl.setCompanyId(lecturer.getCompanyId());
		lecturerImpl.setUserId(lecturer.getUserId());
		lecturerImpl.setUserName(lecturer.getUserName());
		lecturerImpl.setCreateDate(lecturer.getCreateDate());
		lecturerImpl.setModifiedDate(lecturer.getModifiedDate());
		lecturerImpl.setLecturerName(lecturer.getLecturerName());
		lecturerImpl.setLecturerUserId(lecturer.getLecturerUserId());

		return lecturerImpl;
	}

	/**
	 * Returns the lecturer with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lecturer
	 * @return the lecturer
	 * @throws NoSuchLecturerException if a lecturer with the primary key could not be found
	 */
	@Override
	public Lecturer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLecturerException {
		Lecturer lecturer = fetchByPrimaryKey(primaryKey);

		if (lecturer == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLecturerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return lecturer;
	}

	/**
	 * Returns the lecturer with the primary key or throws a {@link NoSuchLecturerException} if it could not be found.
	 *
	 * @param lecturerId the primary key of the lecturer
	 * @return the lecturer
	 * @throws NoSuchLecturerException if a lecturer with the primary key could not be found
	 */
	@Override
	public Lecturer findByPrimaryKey(long lecturerId)
		throws NoSuchLecturerException {
		return findByPrimaryKey((Serializable)lecturerId);
	}

	/**
	 * Returns the lecturer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lecturer
	 * @return the lecturer, or <code>null</code> if a lecturer with the primary key could not be found
	 */
	@Override
	public Lecturer fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LecturerModelImpl.ENTITY_CACHE_ENABLED,
				LecturerImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Lecturer lecturer = (Lecturer)serializable;

		if (lecturer == null) {
			Session session = null;

			try {
				session = openSession();

				lecturer = (Lecturer)session.get(LecturerImpl.class, primaryKey);

				if (lecturer != null) {
					cacheResult(lecturer);
				}
				else {
					entityCache.putResult(LecturerModelImpl.ENTITY_CACHE_ENABLED,
						LecturerImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LecturerModelImpl.ENTITY_CACHE_ENABLED,
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
	 */
	@Override
	public Lecturer fetchByPrimaryKey(long lecturerId) {
		return fetchByPrimaryKey((Serializable)lecturerId);
	}

	@Override
	public Map<Serializable, Lecturer> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Lecturer> map = new HashMap<Serializable, Lecturer>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Lecturer lecturer = fetchByPrimaryKey(primaryKey);

			if (lecturer != null) {
				map.put(primaryKey, lecturer);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LecturerModelImpl.ENTITY_CACHE_ENABLED,
					LecturerImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Lecturer)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LECTURER_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Lecturer lecturer : (List<Lecturer>)q.list()) {
				map.put(lecturer.getPrimaryKeyObj(), lecturer);

				cacheResult(lecturer);

				uncachedPrimaryKeys.remove(lecturer.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LecturerModelImpl.ENTITY_CACHE_ENABLED,
					LecturerImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the lecturers.
	 *
	 * @return the lecturers
	 */
	@Override
	public List<Lecturer> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lecturers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lecturers
	 * @param end the upper bound of the range of lecturers (not inclusive)
	 * @return the range of lecturers
	 */
	@Override
	public List<Lecturer> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lecturers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lecturers
	 * @param end the upper bound of the range of lecturers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lecturers
	 */
	@Override
	public List<Lecturer> findAll(int start, int end,
		OrderByComparator<Lecturer> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lecturers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lecturers
	 * @param end the upper bound of the range of lecturers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of lecturers
	 */
	@Override
	public List<Lecturer> findAll(int start, int end,
		OrderByComparator<Lecturer> orderByComparator, boolean retrieveFromCache) {
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

		List<Lecturer> list = null;

		if (retrieveFromCache) {
			list = (List<Lecturer>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Lecturer>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	 */
	@Override
	public void removeAll() {
		for (Lecturer lecturer : findAll()) {
			remove(lecturer);
		}
	}

	/**
	 * Returns the number of lecturers.
	 *
	 * @return the number of lecturers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LECTURER);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
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
	 * Returns the primaryKeys of timetable courses associated with the lecturer.
	 *
	 * @param pk the primary key of the lecturer
	 * @return long[] of the primaryKeys of timetable courses associated with the lecturer
	 */
	@Override
	public long[] getTimetableCoursePrimaryKeys(long pk) {
		long[] pks = lecturerToTimetableCourseTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the timetable courses associated with the lecturer.
	 *
	 * @param pk the primary key of the lecturer
	 * @return the timetable courses associated with the lecturer
	 */
	@Override
	public List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		long pk) {
		return getTimetableCourses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the timetable courses associated with the lecturer.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the lecturer
	 * @param start the lower bound of the range of lecturers
	 * @param end the upper bound of the range of lecturers (not inclusive)
	 * @return the range of timetable courses associated with the lecturer
	 */
	@Override
	public List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		long pk, int start, int end) {
		return getTimetableCourses(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the timetable courses associated with the lecturer.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LecturerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the lecturer
	 * @param start the lower bound of the range of lecturers
	 * @param end the upper bound of the range of lecturers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of timetable courses associated with the lecturer
	 */
	@Override
	public List<hu.unideb.inf.model.TimetableCourse> getTimetableCourses(
		long pk, int start, int end,
		OrderByComparator<hu.unideb.inf.model.TimetableCourse> orderByComparator) {
		return lecturerToTimetableCourseTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of timetable courses associated with the lecturer.
	 *
	 * @param pk the primary key of the lecturer
	 * @return the number of timetable courses associated with the lecturer
	 */
	@Override
	public int getTimetableCoursesSize(long pk) {
		long[] pks = lecturerToTimetableCourseTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the timetable course is associated with the lecturer.
	 *
	 * @param pk the primary key of the lecturer
	 * @param timetableCoursePK the primary key of the timetable course
	 * @return <code>true</code> if the timetable course is associated with the lecturer; <code>false</code> otherwise
	 */
	@Override
	public boolean containsTimetableCourse(long pk, long timetableCoursePK) {
		return lecturerToTimetableCourseTableMapper.containsTableMapping(pk,
			timetableCoursePK);
	}

	/**
	 * Returns <code>true</code> if the lecturer has any timetable courses associated with it.
	 *
	 * @param pk the primary key of the lecturer to check for associations with timetable courses
	 * @return <code>true</code> if the lecturer has any timetable courses associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsTimetableCourses(long pk) {
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
	 */
	@Override
	public void addTimetableCourse(long pk, long timetableCoursePK) {
		Lecturer lecturer = fetchByPrimaryKey(pk);

		if (lecturer == null) {
			lecturerToTimetableCourseTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, timetableCoursePK);
		}
		else {
			lecturerToTimetableCourseTableMapper.addTableMapping(lecturer.getCompanyId(),
				pk, timetableCoursePK);
		}
	}

	/**
	 * Adds an association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the lecturer
	 * @param timetableCourse the timetable course
	 */
	@Override
	public void addTimetableCourse(long pk,
		hu.unideb.inf.model.TimetableCourse timetableCourse) {
		Lecturer lecturer = fetchByPrimaryKey(pk);

		if (lecturer == null) {
			lecturerToTimetableCourseTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, timetableCourse.getPrimaryKey());
		}
		else {
			lecturerToTimetableCourseTableMapper.addTableMapping(lecturer.getCompanyId(),
				pk, timetableCourse.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the lecturer
	 * @param timetableCoursePKs the primary keys of the timetable courses
	 */
	@Override
	public void addTimetableCourses(long pk, long[] timetableCoursePKs) {
		long companyId = 0;

		Lecturer lecturer = fetchByPrimaryKey(pk);

		if (lecturer == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = lecturer.getCompanyId();
		}

		lecturerToTimetableCourseTableMapper.addTableMappings(companyId, pk,
			timetableCoursePKs);
	}

	/**
	 * Adds an association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the lecturer
	 * @param timetableCourses the timetable courses
	 */
	@Override
	public void addTimetableCourses(long pk,
		List<hu.unideb.inf.model.TimetableCourse> timetableCourses) {
		addTimetableCourses(pk,
			ListUtil.toLongArray(timetableCourses,
				hu.unideb.inf.model.TimetableCourse.TIMETABLE_COURSE_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the lecturer and its timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the lecturer to clear the associated timetable courses from
	 */
	@Override
	public void clearTimetableCourses(long pk) {
		lecturerToTimetableCourseTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the lecturer
	 * @param timetableCoursePK the primary key of the timetable course
	 */
	@Override
	public void removeTimetableCourse(long pk, long timetableCoursePK) {
		lecturerToTimetableCourseTableMapper.deleteTableMapping(pk,
			timetableCoursePK);
	}

	/**
	 * Removes the association between the lecturer and the timetable course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the lecturer
	 * @param timetableCourse the timetable course
	 */
	@Override
	public void removeTimetableCourse(long pk,
		hu.unideb.inf.model.TimetableCourse timetableCourse) {
		lecturerToTimetableCourseTableMapper.deleteTableMapping(pk,
			timetableCourse.getPrimaryKey());
	}

	/**
	 * Removes the association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the lecturer
	 * @param timetableCoursePKs the primary keys of the timetable courses
	 */
	@Override
	public void removeTimetableCourses(long pk, long[] timetableCoursePKs) {
		lecturerToTimetableCourseTableMapper.deleteTableMappings(pk,
			timetableCoursePKs);
	}

	/**
	 * Removes the association between the lecturer and the timetable courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the lecturer
	 * @param timetableCourses the timetable courses
	 */
	@Override
	public void removeTimetableCourses(long pk,
		List<hu.unideb.inf.model.TimetableCourse> timetableCourses) {
		removeTimetableCourses(pk,
			ListUtil.toLongArray(timetableCourses,
				hu.unideb.inf.model.TimetableCourse.TIMETABLE_COURSE_ID_ACCESSOR));
	}

	/**
	 * Sets the timetable courses associated with the lecturer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the lecturer
	 * @param timetableCoursePKs the primary keys of the timetable courses to be associated with the lecturer
	 */
	@Override
	public void setTimetableCourses(long pk, long[] timetableCoursePKs) {
		Set<Long> newTimetableCoursePKsSet = SetUtil.fromArray(timetableCoursePKs);
		Set<Long> oldTimetableCoursePKsSet = SetUtil.fromArray(lecturerToTimetableCourseTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeTimetableCoursePKsSet = new HashSet<Long>(oldTimetableCoursePKsSet);

		removeTimetableCoursePKsSet.removeAll(newTimetableCoursePKsSet);

		lecturerToTimetableCourseTableMapper.deleteTableMappings(pk,
			ArrayUtil.toLongArray(removeTimetableCoursePKsSet));

		newTimetableCoursePKsSet.removeAll(oldTimetableCoursePKsSet);

		long companyId = 0;

		Lecturer lecturer = fetchByPrimaryKey(pk);

		if (lecturer == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = lecturer.getCompanyId();
		}

		lecturerToTimetableCourseTableMapper.addTableMappings(companyId, pk,
			ArrayUtil.toLongArray(newTimetableCoursePKsSet));
	}

	/**
	 * Sets the timetable courses associated with the lecturer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the lecturer
	 * @param timetableCourses the timetable courses to be associated with the lecturer
	 */
	@Override
	public void setTimetableCourses(long pk,
		List<hu.unideb.inf.model.TimetableCourse> timetableCourses) {
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
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LecturerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lecturer persistence.
	 */
	public void afterPropertiesSet() {
		lecturerToTimetableCourseTableMapper = TableMapperFactory.getTableMapper("syllabus_manager_Lecturers_TimetableCourses",
				"companyId", "lecturerId", "timetableCourseId", this,
				timetableCoursePersistence);
	}

	public void destroy() {
		entityCache.removeCache(LecturerImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper(
			"syllabus_manager_Lecturers_TimetableCourses");
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	@BeanReference(type = TimetableCoursePersistence.class)
	protected TimetableCoursePersistence timetableCoursePersistence;
	protected TableMapper<Lecturer, hu.unideb.inf.model.TimetableCourse> lecturerToTimetableCourseTableMapper;
	private static final String _SQL_SELECT_LECTURER = "SELECT lecturer FROM Lecturer lecturer";
	private static final String _SQL_SELECT_LECTURER_WHERE_PKS_IN = "SELECT lecturer FROM Lecturer lecturer WHERE lecturerId IN (";
	private static final String _SQL_SELECT_LECTURER_WHERE = "SELECT lecturer FROM Lecturer lecturer WHERE ";
	private static final String _SQL_COUNT_LECTURER = "SELECT COUNT(lecturer) FROM Lecturer lecturer";
	private static final String _SQL_COUNT_LECTURER_WHERE = "SELECT COUNT(lecturer) FROM Lecturer lecturer WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "lecturer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Lecturer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Lecturer exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LecturerPersistenceImpl.class);
}