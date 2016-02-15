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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import hu.unideb.inf.NoSuchCourseTypeException;
import hu.unideb.inf.model.CourseType;
import hu.unideb.inf.model.impl.CourseTypeImpl;
import hu.unideb.inf.model.impl.CourseTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the course type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see CourseTypePersistence
 * @see CourseTypeUtil
 * @generated
 */
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
	 * Returns the course type where typeName = &#63; or throws a {@link hu.unideb.inf.NoSuchCourseTypeException} if it could not be found.
	 *
	 * @param typeName the type name
	 * @return the matching course type
	 * @throws hu.unideb.inf.NoSuchCourseTypeException if a matching course type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseType findByTypeName(String typeName)
		throws NoSuchCourseTypeException, SystemException {
		CourseType courseType = fetchByTypeName(typeName);

		if (courseType == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("typeName=");
			msg.append(typeName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseType fetchByTypeName(String typeName)
		throws SystemException {
		return fetchByTypeName(typeName, true);
	}

	/**
	 * Returns the course type where typeName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param typeName the type name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching course type, or <code>null</code> if a matching course type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseType fetchByTypeName(String typeName, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { typeName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TYPENAME,
					finderArgs, this);
		}

		if (result instanceof CourseType) {
			CourseType courseType = (CourseType)result;

			if (!Validator.equals(typeName, courseType.getTypeName())) {
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
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPENAME,
						finderArgs, list);
				}
				else {
					CourseType courseType = list.get(0);

					result = courseType;

					cacheResult(courseType);

					if ((courseType.getTypeName() == null) ||
							!courseType.getTypeName().equals(typeName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPENAME,
							finderArgs, courseType);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TYPENAME,
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseType removeByTypeName(String typeName)
		throws NoSuchCourseTypeException, SystemException {
		CourseType courseType = findByTypeName(typeName);

		return remove(courseType);
	}

	/**
	 * Returns the number of course types where typeName = &#63;.
	 *
	 * @param typeName the type name
	 * @return the number of matching course types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTypeName(String typeName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPENAME;

		Object[] finderArgs = new Object[] { typeName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

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

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

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
		EntityCacheUtil.putResult(CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseTypeImpl.class, courseType.getPrimaryKey(), courseType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPENAME,
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
			if (EntityCacheUtil.getResult(
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
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CourseTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CourseTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the course type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CourseType courseType) {
		EntityCacheUtil.removeResult(CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseTypeImpl.class, courseType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(courseType);
	}

	@Override
	public void clearCache(List<CourseType> courseTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CourseType courseType : courseTypes) {
			EntityCacheUtil.removeResult(CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
				CourseTypeImpl.class, courseType.getPrimaryKey());

			clearUniqueFindersCache(courseType);
		}
	}

	protected void cacheUniqueFindersCache(CourseType courseType) {
		if (courseType.isNew()) {
			Object[] args = new Object[] { courseType.getTypeName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TYPENAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPENAME, args,
				courseType);
		}
		else {
			CourseTypeModelImpl courseTypeModelImpl = (CourseTypeModelImpl)courseType;

			if ((courseTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TYPENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { courseType.getTypeName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TYPENAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TYPENAME, args,
					courseType);
			}
		}
	}

	protected void clearUniqueFindersCache(CourseType courseType) {
		CourseTypeModelImpl courseTypeModelImpl = (CourseTypeModelImpl)courseType;

		Object[] args = new Object[] { courseType.getTypeName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPENAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TYPENAME, args);

		if ((courseTypeModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TYPENAME.getColumnBitmask()) != 0) {
			args = new Object[] { courseTypeModelImpl.getOriginalTypeName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPENAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TYPENAME, args);
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

		return courseType;
	}

	/**
	 * Removes the course type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param courseTypeId the primary key of the course type
	 * @return the course type that was removed
	 * @throws hu.unideb.inf.NoSuchCourseTypeException if a course type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseType remove(long courseTypeId)
		throws NoSuchCourseTypeException, SystemException {
		return remove((Serializable)courseTypeId);
	}

	/**
	 * Removes the course type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course type
	 * @return the course type that was removed
	 * @throws hu.unideb.inf.NoSuchCourseTypeException if a course type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseType remove(Serializable primaryKey)
		throws NoSuchCourseTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CourseType courseType = (CourseType)session.get(CourseTypeImpl.class,
					primaryKey);

			if (courseType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
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
	protected CourseType removeImpl(CourseType courseType)
		throws SystemException {
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
	public CourseType updateImpl(hu.unideb.inf.model.CourseType courseType)
		throws SystemException {
		courseType = toUnwrappedModel(courseType);

		boolean isNew = courseType.isNew();

		Session session = null;

		try {
			session = openSession();

			if (courseType.isNew()) {
				session.save(courseType);

				courseType.setNew(false);
			}
			else {
				session.merge(courseType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CourseTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
			CourseTypeImpl.class, courseType.getPrimaryKey(), courseType);

		clearUniqueFindersCache(courseType);
		cacheUniqueFindersCache(courseType);

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
	 * Returns the course type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the course type
	 * @return the course type
	 * @throws hu.unideb.inf.NoSuchCourseTypeException if a course type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCourseTypeException, SystemException {
		CourseType courseType = fetchByPrimaryKey(primaryKey);

		if (courseType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCourseTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return courseType;
	}

	/**
	 * Returns the course type with the primary key or throws a {@link hu.unideb.inf.NoSuchCourseTypeException} if it could not be found.
	 *
	 * @param courseTypeId the primary key of the course type
	 * @return the course type
	 * @throws hu.unideb.inf.NoSuchCourseTypeException if a course type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseType findByPrimaryKey(long courseTypeId)
		throws NoSuchCourseTypeException, SystemException {
		return findByPrimaryKey((Serializable)courseTypeId);
	}

	/**
	 * Returns the course type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course type
	 * @return the course type, or <code>null</code> if a course type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CourseType courseType = (CourseType)EntityCacheUtil.getResult(CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
				CourseTypeImpl.class, primaryKey);

		if (courseType == _nullCourseType) {
			return null;
		}

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
					EntityCacheUtil.putResult(CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
						CourseTypeImpl.class, primaryKey, _nullCourseType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CourseTypeModelImpl.ENTITY_CACHE_ENABLED,
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
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CourseType fetchByPrimaryKey(long courseTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)courseTypeId);
	}

	/**
	 * Returns all the course types.
	 *
	 * @return the course types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.CourseTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course types
	 * @param end the upper bound of the range of course types (not inclusive)
	 * @return the range of course types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the course types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.CourseTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of course types
	 * @param end the upper bound of the range of course types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of course types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CourseType> findAll(int start, int end,
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

		List<CourseType> list = (List<CourseType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

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

					list = new UnmodifiableList<CourseType>(list);
				}
				else {
					list = (List<CourseType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the course types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CourseType courseType : findAll()) {
			remove(courseType);
		}
	}

	/**
	 * Returns the number of course types.
	 *
	 * @return the number of course types
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

				Query q = session.createQuery(_SQL_COUNT_COURSETYPE);

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
	 * Initializes the course type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.hu.unideb.inf.model.CourseType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CourseType>> listenersList = new ArrayList<ModelListener<CourseType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CourseType>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(CourseTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COURSETYPE = "SELECT courseType FROM CourseType courseType";
	private static final String _SQL_SELECT_COURSETYPE_WHERE = "SELECT courseType FROM CourseType courseType WHERE ";
	private static final String _SQL_COUNT_COURSETYPE = "SELECT COUNT(courseType) FROM CourseType courseType";
	private static final String _SQL_COUNT_COURSETYPE_WHERE = "SELECT COUNT(courseType) FROM CourseType courseType WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "courseType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CourseType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CourseType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CourseTypePersistenceImpl.class);
	private static CourseType _nullCourseType = new CourseTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CourseType> toCacheModel() {
				return _nullCourseTypeCacheModel;
			}
		};

	private static CacheModel<CourseType> _nullCourseTypeCacheModel = new CacheModel<CourseType>() {
			@Override
			public CourseType toEntityModel() {
				return _nullCourseType;
			}
		};
}