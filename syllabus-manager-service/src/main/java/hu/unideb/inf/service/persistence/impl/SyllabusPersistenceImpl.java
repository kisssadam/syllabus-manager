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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import hu.unideb.inf.exception.NoSuchSyllabusException;
import hu.unideb.inf.model.Syllabus;
import hu.unideb.inf.model.impl.SyllabusImpl;
import hu.unideb.inf.model.impl.SyllabusModelImpl;
import hu.unideb.inf.service.persistence.SyllabusPersistence;

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
 * The persistence implementation for the syllabus service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see SyllabusPersistence
 * @see hu.unideb.inf.service.persistence.SyllabusUtil
 * @generated
 */
@ProviderType
public class SyllabusPersistenceImpl extends BasePersistenceImpl<Syllabus>
	implements SyllabusPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SyllabusUtil} to access the syllabus persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SyllabusImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusModelImpl.FINDER_CACHE_ENABLED, SyllabusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusModelImpl.FINDER_CACHE_ENABLED, SyllabusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusModelImpl.FINDER_CACHE_ENABLED, SyllabusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusModelImpl.FINDER_CACHE_ENABLED, SyllabusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SyllabusModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the syllabuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching syllabuses
	 */
	@Override
	public List<Syllabus> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the syllabuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of syllabuses
	 * @param end the upper bound of the range of syllabuses (not inclusive)
	 * @return the range of matching syllabuses
	 */
	@Override
	public List<Syllabus> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the syllabuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of syllabuses
	 * @param end the upper bound of the range of syllabuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching syllabuses
	 */
	@Override
	public List<Syllabus> findByUuid(String uuid, int start, int end,
		OrderByComparator<Syllabus> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the syllabuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of syllabuses
	 * @param end the upper bound of the range of syllabuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching syllabuses
	 */
	@Override
	public List<Syllabus> findByUuid(String uuid, int start, int end,
		OrderByComparator<Syllabus> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Syllabus> list = null;

		if (retrieveFromCache) {
			list = (List<Syllabus>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Syllabus syllabus : list) {
					if (!Objects.equals(uuid, syllabus.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SYLLABUS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SyllabusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Syllabus>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Syllabus>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first syllabus in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching syllabus
	 * @throws NoSuchSyllabusException if a matching syllabus could not be found
	 */
	@Override
	public Syllabus findByUuid_First(String uuid,
		OrderByComparator<Syllabus> orderByComparator)
		throws NoSuchSyllabusException {
		Syllabus syllabus = fetchByUuid_First(uuid, orderByComparator);

		if (syllabus != null) {
			return syllabus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSyllabusException(msg.toString());
	}

	/**
	 * Returns the first syllabus in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching syllabus, or <code>null</code> if a matching syllabus could not be found
	 */
	@Override
	public Syllabus fetchByUuid_First(String uuid,
		OrderByComparator<Syllabus> orderByComparator) {
		List<Syllabus> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last syllabus in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching syllabus
	 * @throws NoSuchSyllabusException if a matching syllabus could not be found
	 */
	@Override
	public Syllabus findByUuid_Last(String uuid,
		OrderByComparator<Syllabus> orderByComparator)
		throws NoSuchSyllabusException {
		Syllabus syllabus = fetchByUuid_Last(uuid, orderByComparator);

		if (syllabus != null) {
			return syllabus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSyllabusException(msg.toString());
	}

	/**
	 * Returns the last syllabus in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching syllabus, or <code>null</code> if a matching syllabus could not be found
	 */
	@Override
	public Syllabus fetchByUuid_Last(String uuid,
		OrderByComparator<Syllabus> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Syllabus> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the syllabuses before and after the current syllabus in the ordered set where uuid = &#63;.
	 *
	 * @param syllabusId the primary key of the current syllabus
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next syllabus
	 * @throws NoSuchSyllabusException if a syllabus with the primary key could not be found
	 */
	@Override
	public Syllabus[] findByUuid_PrevAndNext(long syllabusId, String uuid,
		OrderByComparator<Syllabus> orderByComparator)
		throws NoSuchSyllabusException {
		Syllabus syllabus = findByPrimaryKey(syllabusId);

		Session session = null;

		try {
			session = openSession();

			Syllabus[] array = new SyllabusImpl[3];

			array[0] = getByUuid_PrevAndNext(session, syllabus, uuid,
					orderByComparator, true);

			array[1] = syllabus;

			array[2] = getByUuid_PrevAndNext(session, syllabus, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Syllabus getByUuid_PrevAndNext(Session session,
		Syllabus syllabus, String uuid,
		OrderByComparator<Syllabus> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SYLLABUS_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SyllabusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(syllabus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Syllabus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the syllabuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Syllabus syllabus : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(syllabus);
		}
	}

	/**
	 * Returns the number of syllabuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching syllabuses
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SYLLABUS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "syllabus.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "syllabus.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(syllabus.uuid IS NULL OR syllabus.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusModelImpl.FINDER_CACHE_ENABLED, SyllabusImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SyllabusModelImpl.UUID_COLUMN_BITMASK |
			SyllabusModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the syllabus where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchSyllabusException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching syllabus
	 * @throws NoSuchSyllabusException if a matching syllabus could not be found
	 */
	@Override
	public Syllabus findByUUID_G(String uuid, long groupId)
		throws NoSuchSyllabusException {
		Syllabus syllabus = fetchByUUID_G(uuid, groupId);

		if (syllabus == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchSyllabusException(msg.toString());
		}

		return syllabus;
	}

	/**
	 * Returns the syllabus where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching syllabus, or <code>null</code> if a matching syllabus could not be found
	 */
	@Override
	public Syllabus fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the syllabus where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching syllabus, or <code>null</code> if a matching syllabus could not be found
	 */
	@Override
	public Syllabus fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Syllabus) {
			Syllabus syllabus = (Syllabus)result;

			if (!Objects.equals(uuid, syllabus.getUuid()) ||
					(groupId != syllabus.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SYLLABUS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Syllabus> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Syllabus syllabus = list.get(0);

					result = syllabus;

					cacheResult(syllabus);

					if ((syllabus.getUuid() == null) ||
							!syllabus.getUuid().equals(uuid) ||
							(syllabus.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, syllabus);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

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
			return (Syllabus)result;
		}
	}

	/**
	 * Removes the syllabus where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the syllabus that was removed
	 */
	@Override
	public Syllabus removeByUUID_G(String uuid, long groupId)
		throws NoSuchSyllabusException {
		Syllabus syllabus = findByUUID_G(uuid, groupId);

		return remove(syllabus);
	}

	/**
	 * Returns the number of syllabuses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching syllabuses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SYLLABUS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "syllabus.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "syllabus.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(syllabus.uuid IS NULL OR syllabus.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "syllabus.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusModelImpl.FINDER_CACHE_ENABLED, SyllabusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusModelImpl.FINDER_CACHE_ENABLED, SyllabusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SyllabusModelImpl.UUID_COLUMN_BITMASK |
			SyllabusModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the syllabuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching syllabuses
	 */
	@Override
	public List<Syllabus> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the syllabuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of syllabuses
	 * @param end the upper bound of the range of syllabuses (not inclusive)
	 * @return the range of matching syllabuses
	 */
	@Override
	public List<Syllabus> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the syllabuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of syllabuses
	 * @param end the upper bound of the range of syllabuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching syllabuses
	 */
	@Override
	public List<Syllabus> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Syllabus> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the syllabuses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of syllabuses
	 * @param end the upper bound of the range of syllabuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching syllabuses
	 */
	@Override
	public List<Syllabus> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Syllabus> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Syllabus> list = null;

		if (retrieveFromCache) {
			list = (List<Syllabus>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Syllabus syllabus : list) {
					if (!Objects.equals(uuid, syllabus.getUuid()) ||
							(companyId != syllabus.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SYLLABUS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SyllabusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Syllabus>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Syllabus>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first syllabus in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching syllabus
	 * @throws NoSuchSyllabusException if a matching syllabus could not be found
	 */
	@Override
	public Syllabus findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Syllabus> orderByComparator)
		throws NoSuchSyllabusException {
		Syllabus syllabus = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (syllabus != null) {
			return syllabus;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSyllabusException(msg.toString());
	}

	/**
	 * Returns the first syllabus in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching syllabus, or <code>null</code> if a matching syllabus could not be found
	 */
	@Override
	public Syllabus fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Syllabus> orderByComparator) {
		List<Syllabus> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last syllabus in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching syllabus
	 * @throws NoSuchSyllabusException if a matching syllabus could not be found
	 */
	@Override
	public Syllabus findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Syllabus> orderByComparator)
		throws NoSuchSyllabusException {
		Syllabus syllabus = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (syllabus != null) {
			return syllabus;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSyllabusException(msg.toString());
	}

	/**
	 * Returns the last syllabus in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching syllabus, or <code>null</code> if a matching syllabus could not be found
	 */
	@Override
	public Syllabus fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Syllabus> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Syllabus> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the syllabuses before and after the current syllabus in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param syllabusId the primary key of the current syllabus
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next syllabus
	 * @throws NoSuchSyllabusException if a syllabus with the primary key could not be found
	 */
	@Override
	public Syllabus[] findByUuid_C_PrevAndNext(long syllabusId, String uuid,
		long companyId, OrderByComparator<Syllabus> orderByComparator)
		throws NoSuchSyllabusException {
		Syllabus syllabus = findByPrimaryKey(syllabusId);

		Session session = null;

		try {
			session = openSession();

			Syllabus[] array = new SyllabusImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, syllabus, uuid,
					companyId, orderByComparator, true);

			array[1] = syllabus;

			array[2] = getByUuid_C_PrevAndNext(session, syllabus, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Syllabus getByUuid_C_PrevAndNext(Session session,
		Syllabus syllabus, String uuid, long companyId,
		OrderByComparator<Syllabus> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_SYLLABUS_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SyllabusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(syllabus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Syllabus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the syllabuses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Syllabus syllabus : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(syllabus);
		}
	}

	/**
	 * Returns the number of syllabuses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching syllabuses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SYLLABUS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "syllabus.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "syllabus.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(syllabus.uuid IS NULL OR syllabus.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "syllabus.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TIMETABLECOURSEID =
		new FinderPath(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusModelImpl.FINDER_CACHE_ENABLED, SyllabusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTimetableCourseId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMETABLECOURSEID =
		new FinderPath(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusModelImpl.FINDER_CACHE_ENABLED, SyllabusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTimetableCourseId", new String[] { Long.class.getName() },
			SyllabusModelImpl.TIMETABLECOURSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TIMETABLECOURSEID = new FinderPath(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTimetableCourseId", new String[] { Long.class.getName() });

	/**
	 * Returns all the syllabuses where timetableCourseId = &#63;.
	 *
	 * @param timetableCourseId the timetable course ID
	 * @return the matching syllabuses
	 */
	@Override
	public List<Syllabus> findByTimetableCourseId(long timetableCourseId) {
		return findByTimetableCourseId(timetableCourseId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the syllabuses where timetableCourseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param timetableCourseId the timetable course ID
	 * @param start the lower bound of the range of syllabuses
	 * @param end the upper bound of the range of syllabuses (not inclusive)
	 * @return the range of matching syllabuses
	 */
	@Override
	public List<Syllabus> findByTimetableCourseId(long timetableCourseId,
		int start, int end) {
		return findByTimetableCourseId(timetableCourseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the syllabuses where timetableCourseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param timetableCourseId the timetable course ID
	 * @param start the lower bound of the range of syllabuses
	 * @param end the upper bound of the range of syllabuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching syllabuses
	 */
	@Override
	public List<Syllabus> findByTimetableCourseId(long timetableCourseId,
		int start, int end, OrderByComparator<Syllabus> orderByComparator) {
		return findByTimetableCourseId(timetableCourseId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the syllabuses where timetableCourseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param timetableCourseId the timetable course ID
	 * @param start the lower bound of the range of syllabuses
	 * @param end the upper bound of the range of syllabuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching syllabuses
	 */
	@Override
	public List<Syllabus> findByTimetableCourseId(long timetableCourseId,
		int start, int end, OrderByComparator<Syllabus> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMETABLECOURSEID;
			finderArgs = new Object[] { timetableCourseId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TIMETABLECOURSEID;
			finderArgs = new Object[] {
					timetableCourseId,
					
					start, end, orderByComparator
				};
		}

		List<Syllabus> list = null;

		if (retrieveFromCache) {
			list = (List<Syllabus>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Syllabus syllabus : list) {
					if ((timetableCourseId != syllabus.getTimetableCourseId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SYLLABUS_WHERE);

			query.append(_FINDER_COLUMN_TIMETABLECOURSEID_TIMETABLECOURSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SyllabusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(timetableCourseId);

				if (!pagination) {
					list = (List<Syllabus>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Syllabus>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first syllabus in the ordered set where timetableCourseId = &#63;.
	 *
	 * @param timetableCourseId the timetable course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching syllabus
	 * @throws NoSuchSyllabusException if a matching syllabus could not be found
	 */
	@Override
	public Syllabus findByTimetableCourseId_First(long timetableCourseId,
		OrderByComparator<Syllabus> orderByComparator)
		throws NoSuchSyllabusException {
		Syllabus syllabus = fetchByTimetableCourseId_First(timetableCourseId,
				orderByComparator);

		if (syllabus != null) {
			return syllabus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("timetableCourseId=");
		msg.append(timetableCourseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSyllabusException(msg.toString());
	}

	/**
	 * Returns the first syllabus in the ordered set where timetableCourseId = &#63;.
	 *
	 * @param timetableCourseId the timetable course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching syllabus, or <code>null</code> if a matching syllabus could not be found
	 */
	@Override
	public Syllabus fetchByTimetableCourseId_First(long timetableCourseId,
		OrderByComparator<Syllabus> orderByComparator) {
		List<Syllabus> list = findByTimetableCourseId(timetableCourseId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last syllabus in the ordered set where timetableCourseId = &#63;.
	 *
	 * @param timetableCourseId the timetable course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching syllabus
	 * @throws NoSuchSyllabusException if a matching syllabus could not be found
	 */
	@Override
	public Syllabus findByTimetableCourseId_Last(long timetableCourseId,
		OrderByComparator<Syllabus> orderByComparator)
		throws NoSuchSyllabusException {
		Syllabus syllabus = fetchByTimetableCourseId_Last(timetableCourseId,
				orderByComparator);

		if (syllabus != null) {
			return syllabus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("timetableCourseId=");
		msg.append(timetableCourseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSyllabusException(msg.toString());
	}

	/**
	 * Returns the last syllabus in the ordered set where timetableCourseId = &#63;.
	 *
	 * @param timetableCourseId the timetable course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching syllabus, or <code>null</code> if a matching syllabus could not be found
	 */
	@Override
	public Syllabus fetchByTimetableCourseId_Last(long timetableCourseId,
		OrderByComparator<Syllabus> orderByComparator) {
		int count = countByTimetableCourseId(timetableCourseId);

		if (count == 0) {
			return null;
		}

		List<Syllabus> list = findByTimetableCourseId(timetableCourseId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the syllabuses before and after the current syllabus in the ordered set where timetableCourseId = &#63;.
	 *
	 * @param syllabusId the primary key of the current syllabus
	 * @param timetableCourseId the timetable course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next syllabus
	 * @throws NoSuchSyllabusException if a syllabus with the primary key could not be found
	 */
	@Override
	public Syllabus[] findByTimetableCourseId_PrevAndNext(long syllabusId,
		long timetableCourseId, OrderByComparator<Syllabus> orderByComparator)
		throws NoSuchSyllabusException {
		Syllabus syllabus = findByPrimaryKey(syllabusId);

		Session session = null;

		try {
			session = openSession();

			Syllabus[] array = new SyllabusImpl[3];

			array[0] = getByTimetableCourseId_PrevAndNext(session, syllabus,
					timetableCourseId, orderByComparator, true);

			array[1] = syllabus;

			array[2] = getByTimetableCourseId_PrevAndNext(session, syllabus,
					timetableCourseId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Syllabus getByTimetableCourseId_PrevAndNext(Session session,
		Syllabus syllabus, long timetableCourseId,
		OrderByComparator<Syllabus> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SYLLABUS_WHERE);

		query.append(_FINDER_COLUMN_TIMETABLECOURSEID_TIMETABLECOURSEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SyllabusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(timetableCourseId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(syllabus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Syllabus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the syllabuses where timetableCourseId = &#63; from the database.
	 *
	 * @param timetableCourseId the timetable course ID
	 */
	@Override
	public void removeByTimetableCourseId(long timetableCourseId) {
		for (Syllabus syllabus : findByTimetableCourseId(timetableCourseId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(syllabus);
		}
	}

	/**
	 * Returns the number of syllabuses where timetableCourseId = &#63;.
	 *
	 * @param timetableCourseId the timetable course ID
	 * @return the number of matching syllabuses
	 */
	@Override
	public int countByTimetableCourseId(long timetableCourseId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TIMETABLECOURSEID;

		Object[] finderArgs = new Object[] { timetableCourseId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SYLLABUS_WHERE);

			query.append(_FINDER_COLUMN_TIMETABLECOURSEID_TIMETABLECOURSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(timetableCourseId);

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

	private static final String _FINDER_COLUMN_TIMETABLECOURSEID_TIMETABLECOURSEID_2 =
		"syllabus.timetableCourseId = ?";

	public SyllabusPersistenceImpl() {
		setModelClass(Syllabus.class);
	}

	/**
	 * Caches the syllabus in the entity cache if it is enabled.
	 *
	 * @param syllabus the syllabus
	 */
	@Override
	public void cacheResult(Syllabus syllabus) {
		entityCache.putResult(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusImpl.class, syllabus.getPrimaryKey(), syllabus);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { syllabus.getUuid(), syllabus.getGroupId() }, syllabus);

		syllabus.resetOriginalValues();
	}

	/**
	 * Caches the syllabuses in the entity cache if it is enabled.
	 *
	 * @param syllabuses the syllabuses
	 */
	@Override
	public void cacheResult(List<Syllabus> syllabuses) {
		for (Syllabus syllabus : syllabuses) {
			if (entityCache.getResult(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
						SyllabusImpl.class, syllabus.getPrimaryKey()) == null) {
				cacheResult(syllabus);
			}
			else {
				syllabus.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all syllabuses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SyllabusImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the syllabus.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Syllabus syllabus) {
		entityCache.removeResult(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusImpl.class, syllabus.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((SyllabusModelImpl)syllabus);
	}

	@Override
	public void clearCache(List<Syllabus> syllabuses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Syllabus syllabus : syllabuses) {
			entityCache.removeResult(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
				SyllabusImpl.class, syllabus.getPrimaryKey());

			clearUniqueFindersCache((SyllabusModelImpl)syllabus);
		}
	}

	protected void cacheUniqueFindersCache(
		SyllabusModelImpl syllabusModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					syllabusModelImpl.getUuid(), syllabusModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				syllabusModelImpl);
		}
		else {
			if ((syllabusModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						syllabusModelImpl.getUuid(),
						syllabusModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					syllabusModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(SyllabusModelImpl syllabusModelImpl) {
		Object[] args = new Object[] {
				syllabusModelImpl.getUuid(), syllabusModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((syllabusModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					syllabusModelImpl.getOriginalUuid(),
					syllabusModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new syllabus with the primary key. Does not add the syllabus to the database.
	 *
	 * @param syllabusId the primary key for the new syllabus
	 * @return the new syllabus
	 */
	@Override
	public Syllabus create(long syllabusId) {
		Syllabus syllabus = new SyllabusImpl();

		syllabus.setNew(true);
		syllabus.setPrimaryKey(syllabusId);

		String uuid = PortalUUIDUtil.generate();

		syllabus.setUuid(uuid);

		syllabus.setCompanyId(companyProvider.getCompanyId());

		return syllabus;
	}

	/**
	 * Removes the syllabus with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param syllabusId the primary key of the syllabus
	 * @return the syllabus that was removed
	 * @throws NoSuchSyllabusException if a syllabus with the primary key could not be found
	 */
	@Override
	public Syllabus remove(long syllabusId) throws NoSuchSyllabusException {
		return remove((Serializable)syllabusId);
	}

	/**
	 * Removes the syllabus with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the syllabus
	 * @return the syllabus that was removed
	 * @throws NoSuchSyllabusException if a syllabus with the primary key could not be found
	 */
	@Override
	public Syllabus remove(Serializable primaryKey)
		throws NoSuchSyllabusException {
		Session session = null;

		try {
			session = openSession();

			Syllabus syllabus = (Syllabus)session.get(SyllabusImpl.class,
					primaryKey);

			if (syllabus == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSyllabusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(syllabus);
		}
		catch (NoSuchSyllabusException nsee) {
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
	protected Syllabus removeImpl(Syllabus syllabus) {
		syllabus = toUnwrappedModel(syllabus);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(syllabus)) {
				syllabus = (Syllabus)session.get(SyllabusImpl.class,
						syllabus.getPrimaryKeyObj());
			}

			if (syllabus != null) {
				session.delete(syllabus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (syllabus != null) {
			clearCache(syllabus);
		}

		return syllabus;
	}

	@Override
	public Syllabus updateImpl(Syllabus syllabus) {
		syllabus = toUnwrappedModel(syllabus);

		boolean isNew = syllabus.isNew();

		SyllabusModelImpl syllabusModelImpl = (SyllabusModelImpl)syllabus;

		if (Validator.isNull(syllabus.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			syllabus.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (syllabus.getCreateDate() == null)) {
			if (serviceContext == null) {
				syllabus.setCreateDate(now);
			}
			else {
				syllabus.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!syllabusModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				syllabus.setModifiedDate(now);
			}
			else {
				syllabus.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (syllabus.isNew()) {
				session.save(syllabus);

				syllabus.setNew(false);
			}
			else {
				syllabus = (Syllabus)session.merge(syllabus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SyllabusModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((syllabusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { syllabusModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { syllabusModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((syllabusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						syllabusModelImpl.getOriginalUuid(),
						syllabusModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						syllabusModelImpl.getUuid(),
						syllabusModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((syllabusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMETABLECOURSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						syllabusModelImpl.getOriginalTimetableCourseId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TIMETABLECOURSEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMETABLECOURSEID,
					args);

				args = new Object[] { syllabusModelImpl.getTimetableCourseId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TIMETABLECOURSEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMETABLECOURSEID,
					args);
			}
		}

		entityCache.putResult(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusImpl.class, syllabus.getPrimaryKey(), syllabus, false);

		clearUniqueFindersCache(syllabusModelImpl);
		cacheUniqueFindersCache(syllabusModelImpl, isNew);

		syllabus.resetOriginalValues();

		return syllabus;
	}

	protected Syllabus toUnwrappedModel(Syllabus syllabus) {
		if (syllabus instanceof SyllabusImpl) {
			return syllabus;
		}

		SyllabusImpl syllabusImpl = new SyllabusImpl();

		syllabusImpl.setNew(syllabus.isNew());
		syllabusImpl.setPrimaryKey(syllabus.getPrimaryKey());

		syllabusImpl.setUuid(syllabus.getUuid());
		syllabusImpl.setSyllabusId(syllabus.getSyllabusId());
		syllabusImpl.setGroupId(syllabus.getGroupId());
		syllabusImpl.setCompanyId(syllabus.getCompanyId());
		syllabusImpl.setUserId(syllabus.getUserId());
		syllabusImpl.setUserName(syllabus.getUserName());
		syllabusImpl.setCreateDate(syllabus.getCreateDate());
		syllabusImpl.setModifiedDate(syllabus.getModifiedDate());
		syllabusImpl.setTimetableCourseId(syllabus.getTimetableCourseId());
		syllabusImpl.setCompetence(syllabus.getCompetence());
		syllabusImpl.setEthicalStandards(syllabus.getEthicalStandards());
		syllabusImpl.setTopics(syllabus.getTopics());
		syllabusImpl.setEducationalMaterials(syllabus.getEducationalMaterials());
		syllabusImpl.setRecommendedLiterature(syllabus.getRecommendedLiterature());
		syllabusImpl.setWeeklyTasks(syllabus.getWeeklyTasks());
		syllabusImpl.setStatus(syllabus.getStatus());
		syllabusImpl.setStatusByUserId(syllabus.getStatusByUserId());
		syllabusImpl.setStatusByUserName(syllabus.getStatusByUserName());
		syllabusImpl.setStatusDate(syllabus.getStatusDate());

		return syllabusImpl;
	}

	/**
	 * Returns the syllabus with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the syllabus
	 * @return the syllabus
	 * @throws NoSuchSyllabusException if a syllabus with the primary key could not be found
	 */
	@Override
	public Syllabus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSyllabusException {
		Syllabus syllabus = fetchByPrimaryKey(primaryKey);

		if (syllabus == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSyllabusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return syllabus;
	}

	/**
	 * Returns the syllabus with the primary key or throws a {@link NoSuchSyllabusException} if it could not be found.
	 *
	 * @param syllabusId the primary key of the syllabus
	 * @return the syllabus
	 * @throws NoSuchSyllabusException if a syllabus with the primary key could not be found
	 */
	@Override
	public Syllabus findByPrimaryKey(long syllabusId)
		throws NoSuchSyllabusException {
		return findByPrimaryKey((Serializable)syllabusId);
	}

	/**
	 * Returns the syllabus with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the syllabus
	 * @return the syllabus, or <code>null</code> if a syllabus with the primary key could not be found
	 */
	@Override
	public Syllabus fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
				SyllabusImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Syllabus syllabus = (Syllabus)serializable;

		if (syllabus == null) {
			Session session = null;

			try {
				session = openSession();

				syllabus = (Syllabus)session.get(SyllabusImpl.class, primaryKey);

				if (syllabus != null) {
					cacheResult(syllabus);
				}
				else {
					entityCache.putResult(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
						SyllabusImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
					SyllabusImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return syllabus;
	}

	/**
	 * Returns the syllabus with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param syllabusId the primary key of the syllabus
	 * @return the syllabus, or <code>null</code> if a syllabus with the primary key could not be found
	 */
	@Override
	public Syllabus fetchByPrimaryKey(long syllabusId) {
		return fetchByPrimaryKey((Serializable)syllabusId);
	}

	@Override
	public Map<Serializable, Syllabus> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Syllabus> map = new HashMap<Serializable, Syllabus>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Syllabus syllabus = fetchByPrimaryKey(primaryKey);

			if (syllabus != null) {
				map.put(primaryKey, syllabus);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
					SyllabusImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Syllabus)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SYLLABUS_WHERE_PKS_IN);

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

			for (Syllabus syllabus : (List<Syllabus>)q.list()) {
				map.put(syllabus.getPrimaryKeyObj(), syllabus);

				cacheResult(syllabus);

				uncachedPrimaryKeys.remove(syllabus.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
					SyllabusImpl.class, primaryKey, nullModel);
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
	 * Returns all the syllabuses.
	 *
	 * @return the syllabuses
	 */
	@Override
	public List<Syllabus> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the syllabuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of syllabuses
	 * @param end the upper bound of the range of syllabuses (not inclusive)
	 * @return the range of syllabuses
	 */
	@Override
	public List<Syllabus> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the syllabuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of syllabuses
	 * @param end the upper bound of the range of syllabuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of syllabuses
	 */
	@Override
	public List<Syllabus> findAll(int start, int end,
		OrderByComparator<Syllabus> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the syllabuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of syllabuses
	 * @param end the upper bound of the range of syllabuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of syllabuses
	 */
	@Override
	public List<Syllabus> findAll(int start, int end,
		OrderByComparator<Syllabus> orderByComparator, boolean retrieveFromCache) {
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

		List<Syllabus> list = null;

		if (retrieveFromCache) {
			list = (List<Syllabus>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SYLLABUS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SYLLABUS;

				if (pagination) {
					sql = sql.concat(SyllabusModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Syllabus>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Syllabus>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the syllabuses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Syllabus syllabus : findAll()) {
			remove(syllabus);
		}
	}

	/**
	 * Returns the number of syllabuses.
	 *
	 * @return the number of syllabuses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SYLLABUS);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SyllabusModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the syllabus persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SyllabusImpl.class.getName());
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
	private static final String _SQL_SELECT_SYLLABUS = "SELECT syllabus FROM Syllabus syllabus";
	private static final String _SQL_SELECT_SYLLABUS_WHERE_PKS_IN = "SELECT syllabus FROM Syllabus syllabus WHERE syllabusId IN (";
	private static final String _SQL_SELECT_SYLLABUS_WHERE = "SELECT syllabus FROM Syllabus syllabus WHERE ";
	private static final String _SQL_COUNT_SYLLABUS = "SELECT COUNT(syllabus) FROM Syllabus syllabus";
	private static final String _SQL_COUNT_SYLLABUS_WHERE = "SELECT COUNT(syllabus) FROM Syllabus syllabus WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "syllabus.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Syllabus exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Syllabus exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SyllabusPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}