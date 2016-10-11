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
	public static final FinderPath FINDER_PATH_FETCH_BY_T_S = new FinderPath(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusModelImpl.FINDER_CACHE_ENABLED, SyllabusImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByT_S",
			new String[] { Long.class.getName(), Long.class.getName() },
			SyllabusModelImpl.TIMETABLECOURSEID_COLUMN_BITMASK |
			SyllabusModelImpl.SEMESTERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_T_S = new FinderPath(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_S",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the syllabus where timetableCourseId = &#63; and semesterId = &#63; or throws a {@link NoSuchSyllabusException} if it could not be found.
	 *
	 * @param timetableCourseId the timetable course ID
	 * @param semesterId the semester ID
	 * @return the matching syllabus
	 * @throws NoSuchSyllabusException if a matching syllabus could not be found
	 */
	@Override
	public Syllabus findByT_S(long timetableCourseId, long semesterId)
		throws NoSuchSyllabusException {
		Syllabus syllabus = fetchByT_S(timetableCourseId, semesterId);

		if (syllabus == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("timetableCourseId=");
			msg.append(timetableCourseId);

			msg.append(", semesterId=");
			msg.append(semesterId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchSyllabusException(msg.toString());
		}

		return syllabus;
	}

	/**
	 * Returns the syllabus where timetableCourseId = &#63; and semesterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param timetableCourseId the timetable course ID
	 * @param semesterId the semester ID
	 * @return the matching syllabus, or <code>null</code> if a matching syllabus could not be found
	 */
	@Override
	public Syllabus fetchByT_S(long timetableCourseId, long semesterId) {
		return fetchByT_S(timetableCourseId, semesterId, true);
	}

	/**
	 * Returns the syllabus where timetableCourseId = &#63; and semesterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param timetableCourseId the timetable course ID
	 * @param semesterId the semester ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching syllabus, or <code>null</code> if a matching syllabus could not be found
	 */
	@Override
	public Syllabus fetchByT_S(long timetableCourseId, long semesterId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { timetableCourseId, semesterId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_T_S,
					finderArgs, this);
		}

		if (result instanceof Syllabus) {
			Syllabus syllabus = (Syllabus)result;

			if ((timetableCourseId != syllabus.getTimetableCourseId()) ||
					(semesterId != syllabus.getSemesterId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SYLLABUS_WHERE);

			query.append(_FINDER_COLUMN_T_S_TIMETABLECOURSEID_2);

			query.append(_FINDER_COLUMN_T_S_SEMESTERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(timetableCourseId);

				qPos.add(semesterId);

				List<Syllabus> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_T_S, finderArgs,
						list);
				}
				else {
					Syllabus syllabus = list.get(0);

					result = syllabus;

					cacheResult(syllabus);

					if ((syllabus.getTimetableCourseId() != timetableCourseId) ||
							(syllabus.getSemesterId() != semesterId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_T_S,
							finderArgs, syllabus);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_T_S, finderArgs);

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
	 * Removes the syllabus where timetableCourseId = &#63; and semesterId = &#63; from the database.
	 *
	 * @param timetableCourseId the timetable course ID
	 * @param semesterId the semester ID
	 * @return the syllabus that was removed
	 */
	@Override
	public Syllabus removeByT_S(long timetableCourseId, long semesterId)
		throws NoSuchSyllabusException {
		Syllabus syllabus = findByT_S(timetableCourseId, semesterId);

		return remove(syllabus);
	}

	/**
	 * Returns the number of syllabuses where timetableCourseId = &#63; and semesterId = &#63;.
	 *
	 * @param timetableCourseId the timetable course ID
	 * @param semesterId the semester ID
	 * @return the number of matching syllabuses
	 */
	@Override
	public int countByT_S(long timetableCourseId, long semesterId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_T_S;

		Object[] finderArgs = new Object[] { timetableCourseId, semesterId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SYLLABUS_WHERE);

			query.append(_FINDER_COLUMN_T_S_TIMETABLECOURSEID_2);

			query.append(_FINDER_COLUMN_T_S_SEMESTERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(timetableCourseId);

				qPos.add(semesterId);

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

	private static final String _FINDER_COLUMN_T_S_TIMETABLECOURSEID_2 = "syllabus.timetableCourseId = ? AND ";
	private static final String _FINDER_COLUMN_T_S_SEMESTERID_2 = "syllabus.semesterId = ?";
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
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEMESTERID =
		new FinderPath(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusModelImpl.FINDER_CACHE_ENABLED, SyllabusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySemesterId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEMESTERID =
		new FinderPath(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusModelImpl.FINDER_CACHE_ENABLED, SyllabusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySemesterId",
			new String[] { Long.class.getName() },
			SyllabusModelImpl.SEMESTERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SEMESTERID = new FinderPath(SyllabusModelImpl.ENTITY_CACHE_ENABLED,
			SyllabusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySemesterId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the syllabuses where semesterId = &#63;.
	 *
	 * @param semesterId the semester ID
	 * @return the matching syllabuses
	 */
	@Override
	public List<Syllabus> findBySemesterId(long semesterId) {
		return findBySemesterId(semesterId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the syllabuses where semesterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param semesterId the semester ID
	 * @param start the lower bound of the range of syllabuses
	 * @param end the upper bound of the range of syllabuses (not inclusive)
	 * @return the range of matching syllabuses
	 */
	@Override
	public List<Syllabus> findBySemesterId(long semesterId, int start, int end) {
		return findBySemesterId(semesterId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the syllabuses where semesterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param semesterId the semester ID
	 * @param start the lower bound of the range of syllabuses
	 * @param end the upper bound of the range of syllabuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching syllabuses
	 */
	@Override
	public List<Syllabus> findBySemesterId(long semesterId, int start, int end,
		OrderByComparator<Syllabus> orderByComparator) {
		return findBySemesterId(semesterId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the syllabuses where semesterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SyllabusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param semesterId the semester ID
	 * @param start the lower bound of the range of syllabuses
	 * @param end the upper bound of the range of syllabuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching syllabuses
	 */
	@Override
	public List<Syllabus> findBySemesterId(long semesterId, int start, int end,
		OrderByComparator<Syllabus> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEMESTERID;
			finderArgs = new Object[] { semesterId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SEMESTERID;
			finderArgs = new Object[] { semesterId, start, end, orderByComparator };
		}

		List<Syllabus> list = null;

		if (retrieveFromCache) {
			list = (List<Syllabus>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Syllabus syllabus : list) {
					if ((semesterId != syllabus.getSemesterId())) {
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

			query.append(_FINDER_COLUMN_SEMESTERID_SEMESTERID_2);

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

				qPos.add(semesterId);

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
	 * Returns the first syllabus in the ordered set where semesterId = &#63;.
	 *
	 * @param semesterId the semester ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching syllabus
	 * @throws NoSuchSyllabusException if a matching syllabus could not be found
	 */
	@Override
	public Syllabus findBySemesterId_First(long semesterId,
		OrderByComparator<Syllabus> orderByComparator)
		throws NoSuchSyllabusException {
		Syllabus syllabus = fetchBySemesterId_First(semesterId,
				orderByComparator);

		if (syllabus != null) {
			return syllabus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("semesterId=");
		msg.append(semesterId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSyllabusException(msg.toString());
	}

	/**
	 * Returns the first syllabus in the ordered set where semesterId = &#63;.
	 *
	 * @param semesterId the semester ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching syllabus, or <code>null</code> if a matching syllabus could not be found
	 */
	@Override
	public Syllabus fetchBySemesterId_First(long semesterId,
		OrderByComparator<Syllabus> orderByComparator) {
		List<Syllabus> list = findBySemesterId(semesterId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last syllabus in the ordered set where semesterId = &#63;.
	 *
	 * @param semesterId the semester ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching syllabus
	 * @throws NoSuchSyllabusException if a matching syllabus could not be found
	 */
	@Override
	public Syllabus findBySemesterId_Last(long semesterId,
		OrderByComparator<Syllabus> orderByComparator)
		throws NoSuchSyllabusException {
		Syllabus syllabus = fetchBySemesterId_Last(semesterId, orderByComparator);

		if (syllabus != null) {
			return syllabus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("semesterId=");
		msg.append(semesterId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSyllabusException(msg.toString());
	}

	/**
	 * Returns the last syllabus in the ordered set where semesterId = &#63;.
	 *
	 * @param semesterId the semester ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching syllabus, or <code>null</code> if a matching syllabus could not be found
	 */
	@Override
	public Syllabus fetchBySemesterId_Last(long semesterId,
		OrderByComparator<Syllabus> orderByComparator) {
		int count = countBySemesterId(semesterId);

		if (count == 0) {
			return null;
		}

		List<Syllabus> list = findBySemesterId(semesterId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the syllabuses before and after the current syllabus in the ordered set where semesterId = &#63;.
	 *
	 * @param syllabusId the primary key of the current syllabus
	 * @param semesterId the semester ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next syllabus
	 * @throws NoSuchSyllabusException if a syllabus with the primary key could not be found
	 */
	@Override
	public Syllabus[] findBySemesterId_PrevAndNext(long syllabusId,
		long semesterId, OrderByComparator<Syllabus> orderByComparator)
		throws NoSuchSyllabusException {
		Syllabus syllabus = findByPrimaryKey(syllabusId);

		Session session = null;

		try {
			session = openSession();

			Syllabus[] array = new SyllabusImpl[3];

			array[0] = getBySemesterId_PrevAndNext(session, syllabus,
					semesterId, orderByComparator, true);

			array[1] = syllabus;

			array[2] = getBySemesterId_PrevAndNext(session, syllabus,
					semesterId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Syllabus getBySemesterId_PrevAndNext(Session session,
		Syllabus syllabus, long semesterId,
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

		query.append(_FINDER_COLUMN_SEMESTERID_SEMESTERID_2);

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

		qPos.add(semesterId);

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
	 * Removes all the syllabuses where semesterId = &#63; from the database.
	 *
	 * @param semesterId the semester ID
	 */
	@Override
	public void removeBySemesterId(long semesterId) {
		for (Syllabus syllabus : findBySemesterId(semesterId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(syllabus);
		}
	}

	/**
	 * Returns the number of syllabuses where semesterId = &#63;.
	 *
	 * @param semesterId the semester ID
	 * @return the number of matching syllabuses
	 */
	@Override
	public int countBySemesterId(long semesterId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SEMESTERID;

		Object[] finderArgs = new Object[] { semesterId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SYLLABUS_WHERE);

			query.append(_FINDER_COLUMN_SEMESTERID_SEMESTERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(semesterId);

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

	private static final String _FINDER_COLUMN_SEMESTERID_SEMESTERID_2 = "syllabus.semesterId = ?";

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

		finderCache.putResult(FINDER_PATH_FETCH_BY_T_S,
			new Object[] {
				syllabus.getTimetableCourseId(), syllabus.getSemesterId()
			}, syllabus);

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
					syllabusModelImpl.getTimetableCourseId(),
					syllabusModelImpl.getSemesterId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_T_S, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_T_S, args,
				syllabusModelImpl);
		}
		else {
			if ((syllabusModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_T_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						syllabusModelImpl.getTimetableCourseId(),
						syllabusModelImpl.getSemesterId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_T_S, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_T_S, args,
					syllabusModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(SyllabusModelImpl syllabusModelImpl) {
		Object[] args = new Object[] {
				syllabusModelImpl.getTimetableCourseId(),
				syllabusModelImpl.getSemesterId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_T_S, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_T_S, args);

		if ((syllabusModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_T_S.getColumnBitmask()) != 0) {
			args = new Object[] {
					syllabusModelImpl.getOriginalTimetableCourseId(),
					syllabusModelImpl.getOriginalSemesterId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_T_S, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_T_S, args);
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

			if ((syllabusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEMESTERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						syllabusModelImpl.getOriginalSemesterId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SEMESTERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEMESTERID,
					args);

				args = new Object[] { syllabusModelImpl.getSemesterId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SEMESTERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEMESTERID,
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

		syllabusImpl.setSyllabusId(syllabus.getSyllabusId());
		syllabusImpl.setGroupId(syllabus.getGroupId());
		syllabusImpl.setCompanyId(syllabus.getCompanyId());
		syllabusImpl.setUserId(syllabus.getUserId());
		syllabusImpl.setUserName(syllabus.getUserName());
		syllabusImpl.setCreateDate(syllabus.getCreateDate());
		syllabusImpl.setModifiedDate(syllabus.getModifiedDate());
		syllabusImpl.setTimetableCourseId(syllabus.getTimetableCourseId());
		syllabusImpl.setSemesterId(syllabus.getSemesterId());
		syllabusImpl.setCompetence(syllabus.getCompetence());
		syllabusImpl.setEthicalStandards(syllabus.getEthicalStandards());
		syllabusImpl.setTopics(syllabus.getTopics());
		syllabusImpl.setEducationalMaterials(syllabus.getEducationalMaterials());
		syllabusImpl.setRecommendedLiterature(syllabus.getRecommendedLiterature());

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
}