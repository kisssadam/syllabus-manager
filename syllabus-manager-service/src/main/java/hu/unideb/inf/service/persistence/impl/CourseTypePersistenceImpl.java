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

import hu.unideb.inf.exception.NoSuchCourseTypeException;
import hu.unideb.inf.model.CourseType;
import hu.unideb.inf.model.impl.CourseTypeImpl;
import hu.unideb.inf.model.impl.CourseTypeModelImpl;
import hu.unideb.inf.service.persistence.CourseTypePersistence;

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
 * The persistence implementation for the course type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see CourseTypePersistence
 * @see hu.unideb.inf.service.persistence.CourseTypeUtil
 * @generated
 */
@ProviderType
public class CourseTypePersistenceImpl extends BasePersistenceImpl<CourseType>
	implements CourseTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CourseTypeUtil} to access the course type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CourseTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseTypeModelImpl.FINDER_CACHE_ENABLED, CourseTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseTypeModelImpl.FINDER_CACHE_ENABLED, CourseTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_TYPENAME = new FinderPath(CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseTypeModelImpl.FINDER_CACHE_ENABLED, CourseTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTypeName",
			new String[] { String.class.getName() },
			CourseTypeModelImpl.TYPENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPENAME = new FinderPath(CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTypeName",
			new String[] { String.class.getName() });

	/**
	 * Returns the course type where typeName = &#63; or throws a {@link NoSuchCourseTypeException} if it could not be found.
	 *
	 * @param typeName the type name
	 * @return the matching course type
	 * @throws NoSuchCourseTypeException if a matching course type could not be found
	 */
	@Override
	public CourseType findByTypeName(String typeName)
		throws NoSuchCourseTypeException {
		CourseType courseType = fetchByTypeName(typeName);

		if (courseType == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("typeName=");
			msg.append(typeName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCourseTypeException(msg.toString());
		}

		return courseType;
	}

	/**
	 * Returns the course type where typeName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param typeName the type name
	 * @return the matching course type, or <code>null</code> if a matching course type could not be found
	 */
	@Override
	public CourseType fetchByTypeName(String typeName) {
		return fetchByTypeName(typeName, true);
	}

	/**
	 * Returns the course type where typeName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param typeName the type name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching course type, or <code>null</code> if a matching course type could not be found
	 */
	@Override
	public CourseType fetchByTypeName(String typeName, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { typeName };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_TYPENAME,
					finderArgs, this);
		}

		if (result instanceof CourseType) {
			CourseType courseType = (CourseType)result;

			if (!Objects.equals(typeName, courseType.getTypeName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_COURSETYPE_WHERE);

			boolean bindTypeName = false;

			if (typeName == null) {
				query.append(_FINDER_COLUMN_TYPENAME_TYPENAME_1);
			}
			else if (typeName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPENAME_TYPENAME_3);
			}
			else {
				bindTypeName = true;

				query.append(_FINDER_COLUMN_TYPENAME_TYPENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTypeName) {
					qPos.add(typeName);
				}

				List<CourseType> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_TYPENAME,
						finderArgs, list);
				}
				else {
					CourseType courseType = list.get(0);

					result = courseType;

					cacheResult(courseType);

					if ((courseType.getTypeName() == null) ||
							!courseType.getTypeName().equals(typeName)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_TYPENAME,
							finderArgs, courseType);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_TYPENAME,
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
			return (CourseType)result;
		}
	}

	/**
	 * Removes the course type where typeName = &#63; from the database.
	 *
	 * @param typeName the type name
	 * @return the course type that was removed
	 */
	@Override
	public CourseType removeByTypeName(String typeName)
		throws NoSuchCourseTypeException {
		CourseType courseType = findByTypeName(typeName);

		return remove(courseType);
	}

	/**
	 * Returns the number of course types where typeName = &#63;.
	 *
	 * @param typeName the type name
	 * @return the number of matching course types
	 */
	@Override
	public int countByTypeName(String typeName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPENAME;

		Object[] finderArgs = new Object[] { typeName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COURSETYPE_WHERE);

			boolean bindTypeName = false;

			if (typeName == null) {
				query.append(_FINDER_COLUMN_TYPENAME_TYPENAME_1);
			}
			else if (typeName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPENAME_TYPENAME_3);
			}
			else {
				bindTypeName = true;

				query.append(_FINDER_COLUMN_TYPENAME_TYPENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTypeName) {
					qPos.add(typeName);
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

	private static final String _FINDER_COLUMN_TYPENAME_TYPENAME_1 = "courseType.typeName IS NULL";
	private static final String _FINDER_COLUMN_TYPENAME_TYPENAME_2 = "courseType.typeName = ?";
	private static final String _FINDER_COLUMN_TYPENAME_TYPENAME_3 = "(courseType.typeName IS NULL OR courseType.typeName = '')";

	public CourseTypePersistenceImpl() {
		setModelClass(CourseType.class);
	}

	/**
	 * Caches the course type in the entity cache if it is enabled.
	 *
	 * @param courseType the course type
	 */
	@Override
	public void cacheResult(CourseType courseType) {
		entityCache.putResult(CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseTypeImpl.class, courseType.getPrimaryKey(), courseType);

		finderCache.putResult(FINDER_PATH_FETCH_BY_TYPENAME,
			new Object[] { courseType.getTypeName() }, courseType);

		courseType.resetOriginalValues();
	}

	/**
	 * Caches the course types in the entity cache if it is enabled.
	 *
	 * @param courseTypes the course types
	 */
	@Override
	public void cacheResult(List<CourseType> courseTypes) {
		for (CourseType courseType : courseTypes) {
			if (entityCache.getResult(
						CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
						CourseTypeImpl.class, courseType.getPrimaryKey()) == null) {
				cacheResult(courseType);
			}
			else {
				courseType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all course types.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CourseTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the course type.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CourseType courseType) {
		entityCache.removeResult(CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseTypeImpl.class, courseType.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CourseTypeModelImpl)courseType, true);
	}

	@Override
	public void clearCache(List<CourseType> courseTypes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CourseType courseType : courseTypes) {
			entityCache.removeResult(CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
				CourseTypeImpl.class, courseType.getPrimaryKey());

			clearUniqueFindersCache((CourseTypeModelImpl)courseType, true);
		}
	}

	protected void cacheUniqueFindersCache(
		CourseTypeModelImpl courseTypeModelImpl) {
		Object[] args = new Object[] { courseTypeModelImpl.getTypeName() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_TYPENAME, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_TYPENAME, args,
			courseTypeModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CourseTypeModelImpl courseTypeModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { courseTypeModelImpl.getTypeName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TYPENAME, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TYPENAME, args);
		}

		if ((courseTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TYPENAME.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					courseTypeModelImpl.getOriginalTypeName()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TYPENAME, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TYPENAME, args);
		}
	}

	/**
	 * Creates a new course type with the primary key. Does not add the course type to the database.
	 *
	 * @param courseTypeId the primary key for the new course type
	 * @return the new course type
	 */
	@Override
	public CourseType create(long courseTypeId) {
		CourseType courseType = new CourseTypeImpl();

		courseType.setNew(true);
		courseType.setPrimaryKey(courseTypeId);

		courseType.setCompanyId(companyProvider.getCompanyId());

		return courseType;
	}

	/**
	 * Removes the course type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param courseTypeId the primary key of the course type
	 * @return the course type that was removed
	 * @throws NoSuchCourseTypeException if a course type with the primary key could not be found
	 */
	@Override
	public CourseType remove(long courseTypeId)
		throws NoSuchCourseTypeException {
		return remove((Serializable)courseTypeId);
	}

	/**
	 * Removes the course type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course type
	 * @return the course type that was removed
	 * @throws NoSuchCourseTypeException if a course type with the primary key could not be found
	 */
	@Override
	public CourseType remove(Serializable primaryKey)
		throws NoSuchCourseTypeException {
		Session session = null;

		try {
			session = openSession();

			CourseType courseType = (CourseType)session.get(CourseTypeImpl.class,
					primaryKey);

			if (courseType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCourseTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(courseType);
		}
		catch (NoSuchCourseTypeException nsee) {
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
	protected CourseType removeImpl(CourseType courseType) {
		courseType = toUnwrappedModel(courseType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(courseType)) {
				courseType = (CourseType)session.get(CourseTypeImpl.class,
						courseType.getPrimaryKeyObj());
			}

			if (courseType != null) {
				session.delete(courseType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (courseType != null) {
			clearCache(courseType);
		}

		return courseType;
	}

	@Override
	public CourseType updateImpl(CourseType courseType) {
		courseType = toUnwrappedModel(courseType);

		boolean isNew = courseType.isNew();

		CourseTypeModelImpl courseTypeModelImpl = (CourseTypeModelImpl)courseType;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (courseType.getCreateDate() == null)) {
			if (serviceContext == null) {
				courseType.setCreateDate(now);
			}
			else {
				courseType.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!courseTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				courseType.setModifiedDate(now);
			}
			else {
				courseType.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (courseType.isNew()) {
				session.save(courseType);

				courseType.setNew(false);
			}
			else {
				courseType = (CourseType)session.merge(courseType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CourseTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseTypeImpl.class, courseType.getPrimaryKey(), courseType, false);

		clearUniqueFindersCache(courseTypeModelImpl, false);
		cacheUniqueFindersCache(courseTypeModelImpl);

		courseType.resetOriginalValues();

		return courseType;
	}

	protected CourseType toUnwrappedModel(CourseType courseType) {
		if (courseType instanceof CourseTypeImpl) {
			return courseType;
		}

		CourseTypeImpl courseTypeImpl = new CourseTypeImpl();

		courseTypeImpl.setNew(courseType.isNew());
		courseTypeImpl.setPrimaryKey(courseType.getPrimaryKey());

		courseTypeImpl.setCourseTypeId(courseType.getCourseTypeId());
		courseTypeImpl.setGroupId(courseType.getGroupId());
		courseTypeImpl.setCompanyId(courseType.getCompanyId());
		courseTypeImpl.setUserId(courseType.getUserId());
		courseTypeImpl.setUserName(courseType.getUserName());
		courseTypeImpl.setCreateDate(courseType.getCreateDate());
		courseTypeImpl.setModifiedDate(courseType.getModifiedDate());
		courseTypeImpl.setTypeName(courseType.getTypeName());

		return courseTypeImpl;
	}

	/**
	 * Returns the course type with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the course type
	 * @return the course type
	 * @throws NoSuchCourseTypeException if a course type with the primary key could not be found
	 */
	@Override
	public CourseType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCourseTypeException {
		CourseType courseType = fetchByPrimaryKey(primaryKey);

		if (courseType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCourseTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return courseType;
	}

	/**
	 * Returns the course type with the primary key or throws a {@link NoSuchCourseTypeException} if it could not be found.
	 *
	 * @param courseTypeId the primary key of the course type
	 * @return the course type
	 * @throws NoSuchCourseTypeException if a course type with the primary key could not be found
	 */
	@Override
	public CourseType findByPrimaryKey(long courseTypeId)
		throws NoSuchCourseTypeException {
		return findByPrimaryKey((Serializable)courseTypeId);
	}

	/**
	 * Returns the course type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course type
	 * @return the course type, or <code>null</code> if a course type with the primary key could not be found
	 */
	@Override
	public CourseType fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
				CourseTypeImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CourseType courseType = (CourseType)serializable;

		if (courseType == null) {
			Session session = null;

			try {
				session = openSession();

				courseType = (CourseType)session.get(CourseTypeImpl.class,
						primaryKey);

				if (courseType != null) {
					cacheResult(courseType);
				}
				else {
					entityCache.putResult(CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
						CourseTypeImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
					CourseTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return courseType;
	}

	/**
	 * Returns the course type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param courseTypeId the primary key of the course type
	 * @return the course type, or <code>null</code> if a course type with the primary key could not be found
	 */
	@Override
	public CourseType fetchByPrimaryKey(long courseTypeId) {
		return fetchByPrimaryKey((Serializable)courseTypeId);
	}

	@Override
	public Map<Serializable, CourseType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CourseType> map = new HashMap<Serializable, CourseType>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CourseType courseType = fetchByPrimaryKey(primaryKey);

			if (courseType != null) {
				map.put(primaryKey, courseType);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
					CourseTypeImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CourseType)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_COURSETYPE_WHERE_PKS_IN);

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

			for (CourseType courseType : (List<CourseType>)q.list()) {
				map.put(courseType.getPrimaryKeyObj(), courseType);

				cacheResult(courseType);

				uncachedPrimaryKeys.remove(courseType.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
					CourseTypeImpl.class, primaryKey, nullModel);
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
	 * Returns all the course types.
	 *
	 * @return the course types
	 */
	@Override
	public List<CourseType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CourseTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course types
	 * @param end the upper bound of the range of course types (not inclusive)
	 * @return the range of course types
	 */
	@Override
	public List<CourseType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the course types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CourseTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course types
	 * @param end the upper bound of the range of course types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of course types
	 */
	@Override
	public List<CourseType> findAll(int start, int end,
		OrderByComparator<CourseType> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the course types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CourseTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course types
	 * @param end the upper bound of the range of course types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of course types
	 */
	@Override
	public List<CourseType> findAll(int start, int end,
		OrderByComparator<CourseType> orderByComparator,
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

		List<CourseType> list = null;

		if (retrieveFromCache) {
			list = (List<CourseType>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_COURSETYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COURSETYPE;

				if (pagination) {
					sql = sql.concat(CourseTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CourseType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CourseType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the course types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CourseType courseType : findAll()) {
			remove(courseType);
		}
	}

	/**
	 * Returns the number of course types.
	 *
	 * @return the number of course types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COURSETYPE);

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
		return CourseTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the course type persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CourseTypeImpl.class.getName());
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
	private static final String _SQL_SELECT_COURSETYPE = "SELECT courseType FROM CourseType courseType";
	private static final String _SQL_SELECT_COURSETYPE_WHERE_PKS_IN = "SELECT courseType FROM CourseType courseType WHERE courseTypeId IN (";
	private static final String _SQL_SELECT_COURSETYPE_WHERE = "SELECT courseType FROM CourseType courseType WHERE ";
	private static final String _SQL_COUNT_COURSETYPE = "SELECT COUNT(courseType) FROM CourseType courseType";
	private static final String _SQL_COUNT_COURSETYPE_WHERE = "SELECT COUNT(courseType) FROM CourseType courseType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "courseType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CourseType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CourseType exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CourseTypePersistenceImpl.class);
}