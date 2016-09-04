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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import hu.unideb.inf.exception.NoSuchCurriculumException;
import hu.unideb.inf.model.Curriculum;
import hu.unideb.inf.model.impl.CurriculumImpl;
import hu.unideb.inf.model.impl.CurriculumModelImpl;
import hu.unideb.inf.service.persistence.CurriculumPersistence;

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
 * The persistence implementation for the curriculum service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see CurriculumPersistence
 * @see hu.unideb.inf.service.persistence.CurriculumUtil
 * @generated
 */
@ProviderType
public class CurriculumPersistenceImpl extends BasePersistenceImpl<Curriculum>
	implements CurriculumPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CurriculumUtil} to access the curriculum persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CurriculumImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CurriculumModelImpl.ENTITY_CACHE_ENABLED,
			CurriculumModelImpl.FINDER_CACHE_ENABLED, CurriculumImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CurriculumModelImpl.ENTITY_CACHE_ENABLED,
			CurriculumModelImpl.FINDER_CACHE_ENABLED, CurriculumImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CurriculumModelImpl.ENTITY_CACHE_ENABLED,
			CurriculumModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(CurriculumModelImpl.ENTITY_CACHE_ENABLED,
			CurriculumModelImpl.FINDER_CACHE_ENABLED, CurriculumImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] { String.class.getName() },
			CurriculumModelImpl.CURRICULUMCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(CurriculumModelImpl.ENTITY_CACHE_ENABLED,
			CurriculumModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the curriculum where curriculumCode = &#63; or throws a {@link NoSuchCurriculumException} if it could not be found.
	 *
	 * @param curriculumCode the curriculum code
	 * @return the matching curriculum
	 * @throws NoSuchCurriculumException if a matching curriculum could not be found
	 */
	@Override
	public Curriculum findByCode(String curriculumCode)
		throws NoSuchCurriculumException {
		Curriculum curriculum = fetchByCode(curriculumCode);

		if (curriculum == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("curriculumCode=");
			msg.append(curriculumCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCurriculumException(msg.toString());
		}

		return curriculum;
	}

	/**
	 * Returns the curriculum where curriculumCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param curriculumCode the curriculum code
	 * @return the matching curriculum, or <code>null</code> if a matching curriculum could not be found
	 */
	@Override
	public Curriculum fetchByCode(String curriculumCode) {
		return fetchByCode(curriculumCode, true);
	}

	/**
	 * Returns the curriculum where curriculumCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param curriculumCode the curriculum code
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching curriculum, or <code>null</code> if a matching curriculum could not be found
	 */
	@Override
	public Curriculum fetchByCode(String curriculumCode,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { curriculumCode };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs, this);
		}

		if (result instanceof Curriculum) {
			Curriculum curriculum = (Curriculum)result;

			if (!Objects.equals(curriculumCode, curriculum.getCurriculumCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CURRICULUM_WHERE);

			boolean bindCurriculumCode = false;

			if (curriculumCode == null) {
				query.append(_FINDER_COLUMN_CODE_CURRICULUMCODE_1);
			}
			else if (curriculumCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_CURRICULUMCODE_3);
			}
			else {
				bindCurriculumCode = true;

				query.append(_FINDER_COLUMN_CODE_CURRICULUMCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCurriculumCode) {
					qPos.add(curriculumCode);
				}

				List<Curriculum> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs, list);
				}
				else {
					Curriculum curriculum = list.get(0);

					result = curriculum;

					cacheResult(curriculum);

					if ((curriculum.getCurriculumCode() == null) ||
							!curriculum.getCurriculumCode()
										   .equals(curriculumCode)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_CODE,
							finderArgs, curriculum);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_CODE, finderArgs);

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
			return (Curriculum)result;
		}
	}

	/**
	 * Removes the curriculum where curriculumCode = &#63; from the database.
	 *
	 * @param curriculumCode the curriculum code
	 * @return the curriculum that was removed
	 */
	@Override
	public Curriculum removeByCode(String curriculumCode)
		throws NoSuchCurriculumException {
		Curriculum curriculum = findByCode(curriculumCode);

		return remove(curriculum);
	}

	/**
	 * Returns the number of curriculums where curriculumCode = &#63;.
	 *
	 * @param curriculumCode the curriculum code
	 * @return the number of matching curriculums
	 */
	@Override
	public int countByCode(String curriculumCode) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODE;

		Object[] finderArgs = new Object[] { curriculumCode };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CURRICULUM_WHERE);

			boolean bindCurriculumCode = false;

			if (curriculumCode == null) {
				query.append(_FINDER_COLUMN_CODE_CURRICULUMCODE_1);
			}
			else if (curriculumCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_CURRICULUMCODE_3);
			}
			else {
				bindCurriculumCode = true;

				query.append(_FINDER_COLUMN_CODE_CURRICULUMCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCurriculumCode) {
					qPos.add(curriculumCode);
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

	private static final String _FINDER_COLUMN_CODE_CURRICULUMCODE_1 = "curriculum.curriculumCode IS NULL";
	private static final String _FINDER_COLUMN_CODE_CURRICULUMCODE_2 = "curriculum.curriculumCode = ?";
	private static final String _FINDER_COLUMN_CODE_CURRICULUMCODE_3 = "(curriculum.curriculumCode IS NULL OR curriculum.curriculumCode = '')";

	public CurriculumPersistenceImpl() {
		setModelClass(Curriculum.class);
	}

	/**
	 * Caches the curriculum in the entity cache if it is enabled.
	 *
	 * @param curriculum the curriculum
	 */
	@Override
	public void cacheResult(Curriculum curriculum) {
		entityCache.putResult(CurriculumModelImpl.ENTITY_CACHE_ENABLED,
			CurriculumImpl.class, curriculum.getPrimaryKey(), curriculum);

		finderCache.putResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { curriculum.getCurriculumCode() }, curriculum);

		curriculum.resetOriginalValues();
	}

	/**
	 * Caches the curriculums in the entity cache if it is enabled.
	 *
	 * @param curriculums the curriculums
	 */
	@Override
	public void cacheResult(List<Curriculum> curriculums) {
		for (Curriculum curriculum : curriculums) {
			if (entityCache.getResult(
						CurriculumModelImpl.ENTITY_CACHE_ENABLED,
						CurriculumImpl.class, curriculum.getPrimaryKey()) == null) {
				cacheResult(curriculum);
			}
			else {
				curriculum.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all curriculums.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CurriculumImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the curriculum.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Curriculum curriculum) {
		entityCache.removeResult(CurriculumModelImpl.ENTITY_CACHE_ENABLED,
			CurriculumImpl.class, curriculum.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CurriculumModelImpl)curriculum);
	}

	@Override
	public void clearCache(List<Curriculum> curriculums) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Curriculum curriculum : curriculums) {
			entityCache.removeResult(CurriculumModelImpl.ENTITY_CACHE_ENABLED,
				CurriculumImpl.class, curriculum.getPrimaryKey());

			clearUniqueFindersCache((CurriculumModelImpl)curriculum);
		}
	}

	protected void cacheUniqueFindersCache(
		CurriculumModelImpl curriculumModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] { curriculumModelImpl.getCurriculumCode() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_CODE, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_CODE, args,
				curriculumModelImpl);
		}
		else {
			if ((curriculumModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						curriculumModelImpl.getCurriculumCode()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_CODE, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_CODE, args,
					curriculumModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		CurriculumModelImpl curriculumModelImpl) {
		Object[] args = new Object[] { curriculumModelImpl.getCurriculumCode() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

		if ((curriculumModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
			args = new Object[] { curriculumModelImpl.getOriginalCurriculumCode() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_CODE, args);
		}
	}

	/**
	 * Creates a new curriculum with the primary key. Does not add the curriculum to the database.
	 *
	 * @param curriculumId the primary key for the new curriculum
	 * @return the new curriculum
	 */
	@Override
	public Curriculum create(long curriculumId) {
		Curriculum curriculum = new CurriculumImpl();

		curriculum.setNew(true);
		curriculum.setPrimaryKey(curriculumId);

		curriculum.setCompanyId(companyProvider.getCompanyId());

		return curriculum;
	}

	/**
	 * Removes the curriculum with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param curriculumId the primary key of the curriculum
	 * @return the curriculum that was removed
	 * @throws NoSuchCurriculumException if a curriculum with the primary key could not be found
	 */
	@Override
	public Curriculum remove(long curriculumId)
		throws NoSuchCurriculumException {
		return remove((Serializable)curriculumId);
	}

	/**
	 * Removes the curriculum with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the curriculum
	 * @return the curriculum that was removed
	 * @throws NoSuchCurriculumException if a curriculum with the primary key could not be found
	 */
	@Override
	public Curriculum remove(Serializable primaryKey)
		throws NoSuchCurriculumException {
		Session session = null;

		try {
			session = openSession();

			Curriculum curriculum = (Curriculum)session.get(CurriculumImpl.class,
					primaryKey);

			if (curriculum == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCurriculumException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(curriculum);
		}
		catch (NoSuchCurriculumException nsee) {
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
	protected Curriculum removeImpl(Curriculum curriculum) {
		curriculum = toUnwrappedModel(curriculum);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(curriculum)) {
				curriculum = (Curriculum)session.get(CurriculumImpl.class,
						curriculum.getPrimaryKeyObj());
			}

			if (curriculum != null) {
				session.delete(curriculum);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (curriculum != null) {
			clearCache(curriculum);
		}

		return curriculum;
	}

	@Override
	public Curriculum updateImpl(Curriculum curriculum) {
		curriculum = toUnwrappedModel(curriculum);

		boolean isNew = curriculum.isNew();

		CurriculumModelImpl curriculumModelImpl = (CurriculumModelImpl)curriculum;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (curriculum.getCreateDate() == null)) {
			if (serviceContext == null) {
				curriculum.setCreateDate(now);
			}
			else {
				curriculum.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!curriculumModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				curriculum.setModifiedDate(now);
			}
			else {
				curriculum.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (curriculum.isNew()) {
				session.save(curriculum);

				curriculum.setNew(false);
			}
			else {
				curriculum = (Curriculum)session.merge(curriculum);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CurriculumModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(CurriculumModelImpl.ENTITY_CACHE_ENABLED,
			CurriculumImpl.class, curriculum.getPrimaryKey(), curriculum, false);

		clearUniqueFindersCache(curriculumModelImpl);
		cacheUniqueFindersCache(curriculumModelImpl, isNew);

		curriculum.resetOriginalValues();

		return curriculum;
	}

	protected Curriculum toUnwrappedModel(Curriculum curriculum) {
		if (curriculum instanceof CurriculumImpl) {
			return curriculum;
		}

		CurriculumImpl curriculumImpl = new CurriculumImpl();

		curriculumImpl.setNew(curriculum.isNew());
		curriculumImpl.setPrimaryKey(curriculum.getPrimaryKey());

		curriculumImpl.setCurriculumId(curriculum.getCurriculumId());
		curriculumImpl.setGroupId(curriculum.getGroupId());
		curriculumImpl.setCompanyId(curriculum.getCompanyId());
		curriculumImpl.setUserId(curriculum.getUserId());
		curriculumImpl.setUserName(curriculum.getUserName());
		curriculumImpl.setCreateDate(curriculum.getCreateDate());
		curriculumImpl.setModifiedDate(curriculum.getModifiedDate());
		curriculumImpl.setCurriculumCode(curriculum.getCurriculumCode());
		curriculumImpl.setCurriculumName(curriculum.getCurriculumName());

		return curriculumImpl;
	}

	/**
	 * Returns the curriculum with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the curriculum
	 * @return the curriculum
	 * @throws NoSuchCurriculumException if a curriculum with the primary key could not be found
	 */
	@Override
	public Curriculum findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCurriculumException {
		Curriculum curriculum = fetchByPrimaryKey(primaryKey);

		if (curriculum == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCurriculumException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return curriculum;
	}

	/**
	 * Returns the curriculum with the primary key or throws a {@link NoSuchCurriculumException} if it could not be found.
	 *
	 * @param curriculumId the primary key of the curriculum
	 * @return the curriculum
	 * @throws NoSuchCurriculumException if a curriculum with the primary key could not be found
	 */
	@Override
	public Curriculum findByPrimaryKey(long curriculumId)
		throws NoSuchCurriculumException {
		return findByPrimaryKey((Serializable)curriculumId);
	}

	/**
	 * Returns the curriculum with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the curriculum
	 * @return the curriculum, or <code>null</code> if a curriculum with the primary key could not be found
	 */
	@Override
	public Curriculum fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CurriculumModelImpl.ENTITY_CACHE_ENABLED,
				CurriculumImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Curriculum curriculum = (Curriculum)serializable;

		if (curriculum == null) {
			Session session = null;

			try {
				session = openSession();

				curriculum = (Curriculum)session.get(CurriculumImpl.class,
						primaryKey);

				if (curriculum != null) {
					cacheResult(curriculum);
				}
				else {
					entityCache.putResult(CurriculumModelImpl.ENTITY_CACHE_ENABLED,
						CurriculumImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CurriculumModelImpl.ENTITY_CACHE_ENABLED,
					CurriculumImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return curriculum;
	}

	/**
	 * Returns the curriculum with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param curriculumId the primary key of the curriculum
	 * @return the curriculum, or <code>null</code> if a curriculum with the primary key could not be found
	 */
	@Override
	public Curriculum fetchByPrimaryKey(long curriculumId) {
		return fetchByPrimaryKey((Serializable)curriculumId);
	}

	@Override
	public Map<Serializable, Curriculum> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Curriculum> map = new HashMap<Serializable, Curriculum>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Curriculum curriculum = fetchByPrimaryKey(primaryKey);

			if (curriculum != null) {
				map.put(primaryKey, curriculum);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CurriculumModelImpl.ENTITY_CACHE_ENABLED,
					CurriculumImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Curriculum)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CURRICULUM_WHERE_PKS_IN);

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

			for (Curriculum curriculum : (List<Curriculum>)q.list()) {
				map.put(curriculum.getPrimaryKeyObj(), curriculum);

				cacheResult(curriculum);

				uncachedPrimaryKeys.remove(curriculum.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CurriculumModelImpl.ENTITY_CACHE_ENABLED,
					CurriculumImpl.class, primaryKey, nullModel);
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
	 * Returns all the curriculums.
	 *
	 * @return the curriculums
	 */
	@Override
	public List<Curriculum> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the curriculums.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CurriculumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of curriculums
	 * @param end the upper bound of the range of curriculums (not inclusive)
	 * @return the range of curriculums
	 */
	@Override
	public List<Curriculum> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the curriculums.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CurriculumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of curriculums
	 * @param end the upper bound of the range of curriculums (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of curriculums
	 */
	@Override
	public List<Curriculum> findAll(int start, int end,
		OrderByComparator<Curriculum> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the curriculums.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CurriculumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of curriculums
	 * @param end the upper bound of the range of curriculums (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of curriculums
	 */
	@Override
	public List<Curriculum> findAll(int start, int end,
		OrderByComparator<Curriculum> orderByComparator,
		boolean retrieveFromCache) {
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

		List<Curriculum> list = null;

		if (retrieveFromCache) {
			list = (List<Curriculum>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CURRICULUM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CURRICULUM;

				if (pagination) {
					sql = sql.concat(CurriculumModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Curriculum>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Curriculum>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the curriculums from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Curriculum curriculum : findAll()) {
			remove(curriculum);
		}
	}

	/**
	 * Returns the number of curriculums.
	 *
	 * @return the number of curriculums
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CURRICULUM);

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

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CurriculumModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the curriculum persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CurriculumImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CURRICULUM = "SELECT curriculum FROM Curriculum curriculum";
	private static final String _SQL_SELECT_CURRICULUM_WHERE_PKS_IN = "SELECT curriculum FROM Curriculum curriculum WHERE curriculumId IN (";
	private static final String _SQL_SELECT_CURRICULUM_WHERE = "SELECT curriculum FROM Curriculum curriculum WHERE ";
	private static final String _SQL_COUNT_CURRICULUM = "SELECT COUNT(curriculum) FROM Curriculum curriculum";
	private static final String _SQL_COUNT_CURRICULUM_WHERE = "SELECT COUNT(curriculum) FROM Curriculum curriculum WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "curriculum.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Curriculum exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Curriculum exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CurriculumPersistenceImpl.class);
}