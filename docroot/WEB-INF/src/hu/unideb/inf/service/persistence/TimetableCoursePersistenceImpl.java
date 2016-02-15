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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
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
	public static final FinderPath FINDER_PATH_FETCH_BY_TIMETABLECOURSECODE = new FinderPath(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseModelImpl.FINDER_CACHE_ENABLED,
			TimetableCourseImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTimetableCourseCode",
			new String[] { String.class.getName() },
			TimetableCourseModelImpl.TIMETABLECOURSECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TIMETABLECOURSECODE = new FinderPath(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTimetableCourseCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the timetable course where timetableCourseCode = &#63; or throws a {@link hu.unideb.inf.NoSuchTimetableCourseException} if it could not be found.
	 *
	 * @param timetableCourseCode the timetable course code
	 * @return the matching timetable course
	 * @throws hu.unideb.inf.NoSuchTimetableCourseException if a matching timetable course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse findByTimetableCourseCode(String timetableCourseCode)
		throws NoSuchTimetableCourseException, SystemException {
		TimetableCourse timetableCourse = fetchByTimetableCourseCode(timetableCourseCode);

		if (timetableCourse == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("timetableCourseCode=");
			msg.append(timetableCourseCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTimetableCourseException(msg.toString());
		}

		return timetableCourse;
	}

	/**
	 * Returns the timetable course where timetableCourseCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param timetableCourseCode the timetable course code
	 * @return the matching timetable course, or <code>null</code> if a matching timetable course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse fetchByTimetableCourseCode(
		String timetableCourseCode) throws SystemException {
		return fetchByTimetableCourseCode(timetableCourseCode, true);
	}

	/**
	 * Returns the timetable course where timetableCourseCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param timetableCourseCode the timetable course code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching timetable course, or <code>null</code> if a matching timetable course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse fetchByTimetableCourseCode(
		String timetableCourseCode, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { timetableCourseCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TIMETABLECOURSECODE,
					finderArgs, this);
		}

		if (result instanceof TimetableCourse) {
			TimetableCourse timetableCourse = (TimetableCourse)result;

			if (!Validator.equals(timetableCourseCode,
						timetableCourse.getTimetableCourseCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TIMETABLECOURSE_WHERE);

			boolean bindTimetableCourseCode = false;

			if (timetableCourseCode == null) {
				query.append(_FINDER_COLUMN_TIMETABLECOURSECODE_TIMETABLECOURSECODE_1);
			}
			else if (timetableCourseCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TIMETABLECOURSECODE_TIMETABLECOURSECODE_3);
			}
			else {
				bindTimetableCourseCode = true;

				query.append(_FINDER_COLUMN_TIMETABLECOURSECODE_TIMETABLECOURSECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTimetableCourseCode) {
					qPos.add(timetableCourseCode);
				}

				List<TimetableCourse> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TIMETABLECOURSECODE,
						finderArgs, list);
				}
				else {
					TimetableCourse timetableCourse = list.get(0);

					result = timetableCourse;

					cacheResult(timetableCourse);

					if ((timetableCourse.getTimetableCourseCode() == null) ||
							!timetableCourse.getTimetableCourseCode()
												.equals(timetableCourseCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TIMETABLECOURSECODE,
							finderArgs, timetableCourse);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TIMETABLECOURSECODE,
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
			return (TimetableCourse)result;
		}
	}

	/**
	 * Removes the timetable course where timetableCourseCode = &#63; from the database.
	 *
	 * @param timetableCourseCode the timetable course code
	 * @return the timetable course that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse removeByTimetableCourseCode(
		String timetableCourseCode)
		throws NoSuchTimetableCourseException, SystemException {
		TimetableCourse timetableCourse = findByTimetableCourseCode(timetableCourseCode);

		return remove(timetableCourse);
	}

	/**
	 * Returns the number of timetable courses where timetableCourseCode = &#63;.
	 *
	 * @param timetableCourseCode the timetable course code
	 * @return the number of matching timetable courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTimetableCourseCode(String timetableCourseCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TIMETABLECOURSECODE;

		Object[] finderArgs = new Object[] { timetableCourseCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TIMETABLECOURSE_WHERE);

			boolean bindTimetableCourseCode = false;

			if (timetableCourseCode == null) {
				query.append(_FINDER_COLUMN_TIMETABLECOURSECODE_TIMETABLECOURSECODE_1);
			}
			else if (timetableCourseCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TIMETABLECOURSECODE_TIMETABLECOURSECODE_3);
			}
			else {
				bindTimetableCourseCode = true;

				query.append(_FINDER_COLUMN_TIMETABLECOURSECODE_TIMETABLECOURSECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTimetableCourseCode) {
					qPos.add(timetableCourseCode);
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

	private static final String _FINDER_COLUMN_TIMETABLECOURSECODE_TIMETABLECOURSECODE_1 =
		"timetableCourse.timetableCourseCode IS NULL";
	private static final String _FINDER_COLUMN_TIMETABLECOURSECODE_TIMETABLECOURSECODE_2 =
		"timetableCourse.timetableCourseCode = ?";
	private static final String _FINDER_COLUMN_TIMETABLECOURSECODE_TIMETABLECOURSECODE_3 =
		"(timetableCourse.timetableCourseCode IS NULL OR timetableCourse.timetableCourseCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_S = new FinderPath(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseModelImpl.FINDER_CACHE_ENABLED,
			TimetableCourseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByC_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S = new FinderPath(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseModelImpl.FINDER_CACHE_ENABLED,
			TimetableCourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_S",
			new String[] { Long.class.getName(), Long.class.getName() },
			TimetableCourseModelImpl.COURSEID_COLUMN_BITMASK |
			TimetableCourseModelImpl.SEMESTERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_S = new FinderPath(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_S",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the timetable courses where courseId = &#63; and semesterId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @return the matching timetable courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TimetableCourse> findByC_S(long courseId, long semesterId)
		throws SystemException {
		return findByC_S(courseId, semesterId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the timetable courses where courseId = &#63; and semesterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @return the range of matching timetable courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TimetableCourse> findByC_S(long courseId, long semesterId,
		int start, int end) throws SystemException {
		return findByC_S(courseId, semesterId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the timetable courses where courseId = &#63; and semesterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching timetable courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TimetableCourse> findByC_S(long courseId, long semesterId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S;
			finderArgs = new Object[] { courseId, semesterId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_S;
			finderArgs = new Object[] {
					courseId, semesterId,
					
					start, end, orderByComparator
				};
		}

		List<TimetableCourse> list = (List<TimetableCourse>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TimetableCourse timetableCourse : list) {
				if ((courseId != timetableCourse.getCourseId()) ||
						(semesterId != timetableCourse.getSemesterId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TIMETABLECOURSE_WHERE);

			query.append(_FINDER_COLUMN_C_S_COURSEID_2);

			query.append(_FINDER_COLUMN_C_S_SEMESTERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TimetableCourseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				qPos.add(semesterId);

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
	 * Returns the first timetable course in the ordered set where courseId = &#63; and semesterId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching timetable course
	 * @throws hu.unideb.inf.NoSuchTimetableCourseException if a matching timetable course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse findByC_S_First(long courseId, long semesterId,
		OrderByComparator orderByComparator)
		throws NoSuchTimetableCourseException, SystemException {
		TimetableCourse timetableCourse = fetchByC_S_First(courseId,
				semesterId, orderByComparator);

		if (timetableCourse != null) {
			return timetableCourse;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseId=");
		msg.append(courseId);

		msg.append(", semesterId=");
		msg.append(semesterId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimetableCourseException(msg.toString());
	}

	/**
	 * Returns the first timetable course in the ordered set where courseId = &#63; and semesterId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching timetable course, or <code>null</code> if a matching timetable course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse fetchByC_S_First(long courseId, long semesterId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TimetableCourse> list = findByC_S(courseId, semesterId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last timetable course in the ordered set where courseId = &#63; and semesterId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching timetable course
	 * @throws hu.unideb.inf.NoSuchTimetableCourseException if a matching timetable course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse findByC_S_Last(long courseId, long semesterId,
		OrderByComparator orderByComparator)
		throws NoSuchTimetableCourseException, SystemException {
		TimetableCourse timetableCourse = fetchByC_S_Last(courseId, semesterId,
				orderByComparator);

		if (timetableCourse != null) {
			return timetableCourse;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseId=");
		msg.append(courseId);

		msg.append(", semesterId=");
		msg.append(semesterId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimetableCourseException(msg.toString());
	}

	/**
	 * Returns the last timetable course in the ordered set where courseId = &#63; and semesterId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching timetable course, or <code>null</code> if a matching timetable course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse fetchByC_S_Last(long courseId, long semesterId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_S(courseId, semesterId);

		if (count == 0) {
			return null;
		}

		List<TimetableCourse> list = findByC_S(courseId, semesterId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the timetable courses before and after the current timetable course in the ordered set where courseId = &#63; and semesterId = &#63;.
	 *
	 * @param timetableCourseId the primary key of the current timetable course
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next timetable course
	 * @throws hu.unideb.inf.NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse[] findByC_S_PrevAndNext(long timetableCourseId,
		long courseId, long semesterId, OrderByComparator orderByComparator)
		throws NoSuchTimetableCourseException, SystemException {
		TimetableCourse timetableCourse = findByPrimaryKey(timetableCourseId);

		Session session = null;

		try {
			session = openSession();

			TimetableCourse[] array = new TimetableCourseImpl[3];

			array[0] = getByC_S_PrevAndNext(session, timetableCourse, courseId,
					semesterId, orderByComparator, true);

			array[1] = timetableCourse;

			array[2] = getByC_S_PrevAndNext(session, timetableCourse, courseId,
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

	protected TimetableCourse getByC_S_PrevAndNext(Session session,
		TimetableCourse timetableCourse, long courseId, long semesterId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TIMETABLECOURSE_WHERE);

		query.append(_FINDER_COLUMN_C_S_COURSEID_2);

		query.append(_FINDER_COLUMN_C_S_SEMESTERID_2);

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
			query.append(TimetableCourseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(courseId);

		qPos.add(semesterId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(timetableCourse);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TimetableCourse> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the timetable courses where courseId = &#63; and semesterId = &#63; from the database.
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_S(long courseId, long semesterId)
		throws SystemException {
		for (TimetableCourse timetableCourse : findByC_S(courseId, semesterId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(timetableCourse);
		}
	}

	/**
	 * Returns the number of timetable courses where courseId = &#63; and semesterId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @return the number of matching timetable courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_S(long courseId, long semesterId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_S;

		Object[] finderArgs = new Object[] { courseId, semesterId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TIMETABLECOURSE_WHERE);

			query.append(_FINDER_COLUMN_C_S_COURSEID_2);

			query.append(_FINDER_COLUMN_C_S_SEMESTERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				qPos.add(semesterId);

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

	private static final String _FINDER_COLUMN_C_S_COURSEID_2 = "timetableCourse.courseId = ? AND ";
	private static final String _FINDER_COLUMN_C_S_SEMESTERID_2 = "timetableCourse.semesterId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID = new FinderPath(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseModelImpl.FINDER_CACHE_ENABLED,
			TimetableCourseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCourseId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID =
		new FinderPath(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseModelImpl.FINDER_CACHE_ENABLED,
			TimetableCourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCourseId",
			new String[] { Long.class.getName() },
			TimetableCourseModelImpl.COURSEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEID = new FinderPath(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourseId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the timetable courses where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @return the matching timetable courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TimetableCourse> findByCourseId(long courseId)
		throws SystemException {
		return findByCourseId(courseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the timetable courses where courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param courseId the course ID
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @return the range of matching timetable courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TimetableCourse> findByCourseId(long courseId, int start,
		int end) throws SystemException {
		return findByCourseId(courseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the timetable courses where courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param courseId the course ID
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching timetable courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TimetableCourse> findByCourseId(long courseId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID;
			finderArgs = new Object[] { courseId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID;
			finderArgs = new Object[] { courseId, start, end, orderByComparator };
		}

		List<TimetableCourse> list = (List<TimetableCourse>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TimetableCourse timetableCourse : list) {
				if ((courseId != timetableCourse.getCourseId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TIMETABLECOURSE_WHERE);

			query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TimetableCourseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

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
	 * Returns the first timetable course in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching timetable course
	 * @throws hu.unideb.inf.NoSuchTimetableCourseException if a matching timetable course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse findByCourseId_First(long courseId,
		OrderByComparator orderByComparator)
		throws NoSuchTimetableCourseException, SystemException {
		TimetableCourse timetableCourse = fetchByCourseId_First(courseId,
				orderByComparator);

		if (timetableCourse != null) {
			return timetableCourse;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseId=");
		msg.append(courseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimetableCourseException(msg.toString());
	}

	/**
	 * Returns the first timetable course in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching timetable course, or <code>null</code> if a matching timetable course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse fetchByCourseId_First(long courseId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TimetableCourse> list = findByCourseId(courseId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last timetable course in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching timetable course
	 * @throws hu.unideb.inf.NoSuchTimetableCourseException if a matching timetable course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse findByCourseId_Last(long courseId,
		OrderByComparator orderByComparator)
		throws NoSuchTimetableCourseException, SystemException {
		TimetableCourse timetableCourse = fetchByCourseId_Last(courseId,
				orderByComparator);

		if (timetableCourse != null) {
			return timetableCourse;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("courseId=");
		msg.append(courseId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimetableCourseException(msg.toString());
	}

	/**
	 * Returns the last timetable course in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching timetable course, or <code>null</code> if a matching timetable course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse fetchByCourseId_Last(long courseId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCourseId(courseId);

		if (count == 0) {
			return null;
		}

		List<TimetableCourse> list = findByCourseId(courseId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the timetable courses before and after the current timetable course in the ordered set where courseId = &#63;.
	 *
	 * @param timetableCourseId the primary key of the current timetable course
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next timetable course
	 * @throws hu.unideb.inf.NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse[] findByCourseId_PrevAndNext(
		long timetableCourseId, long courseId,
		OrderByComparator orderByComparator)
		throws NoSuchTimetableCourseException, SystemException {
		TimetableCourse timetableCourse = findByPrimaryKey(timetableCourseId);

		Session session = null;

		try {
			session = openSession();

			TimetableCourse[] array = new TimetableCourseImpl[3];

			array[0] = getByCourseId_PrevAndNext(session, timetableCourse,
					courseId, orderByComparator, true);

			array[1] = timetableCourse;

			array[2] = getByCourseId_PrevAndNext(session, timetableCourse,
					courseId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TimetableCourse getByCourseId_PrevAndNext(Session session,
		TimetableCourse timetableCourse, long courseId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TIMETABLECOURSE_WHERE);

		query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

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
			query.append(TimetableCourseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(courseId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(timetableCourse);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TimetableCourse> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the timetable courses where courseId = &#63; from the database.
	 *
	 * @param courseId the course ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCourseId(long courseId) throws SystemException {
		for (TimetableCourse timetableCourse : findByCourseId(courseId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(timetableCourse);
		}
	}

	/**
	 * Returns the number of timetable courses where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @return the number of matching timetable courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCourseId(long courseId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSEID;

		Object[] finderArgs = new Object[] { courseId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TIMETABLECOURSE_WHERE);

			query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

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

	private static final String _FINDER_COLUMN_COURSEID_COURSEID_2 = "timetableCourse.courseId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEMESTERID =
		new FinderPath(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseModelImpl.FINDER_CACHE_ENABLED,
			TimetableCourseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBySemesterId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEMESTERID =
		new FinderPath(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseModelImpl.FINDER_CACHE_ENABLED,
			TimetableCourseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySemesterId",
			new String[] { Long.class.getName() },
			TimetableCourseModelImpl.SEMESTERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SEMESTERID = new FinderPath(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySemesterId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the timetable courses where semesterId = &#63;.
	 *
	 * @param semesterId the semester ID
	 * @return the matching timetable courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TimetableCourse> findBySemesterId(long semesterId)
		throws SystemException {
		return findBySemesterId(semesterId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the timetable courses where semesterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param semesterId the semester ID
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @return the range of matching timetable courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TimetableCourse> findBySemesterId(long semesterId, int start,
		int end) throws SystemException {
		return findBySemesterId(semesterId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the timetable courses where semesterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link hu.unideb.inf.model.impl.TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param semesterId the semester ID
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching timetable courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TimetableCourse> findBySemesterId(long semesterId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<TimetableCourse> list = (List<TimetableCourse>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TimetableCourse timetableCourse : list) {
				if ((semesterId != timetableCourse.getSemesterId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TIMETABLECOURSE_WHERE);

			query.append(_FINDER_COLUMN_SEMESTERID_SEMESTERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TimetableCourseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(semesterId);

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
	 * Returns the first timetable course in the ordered set where semesterId = &#63;.
	 *
	 * @param semesterId the semester ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching timetable course
	 * @throws hu.unideb.inf.NoSuchTimetableCourseException if a matching timetable course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse findBySemesterId_First(long semesterId,
		OrderByComparator orderByComparator)
		throws NoSuchTimetableCourseException, SystemException {
		TimetableCourse timetableCourse = fetchBySemesterId_First(semesterId,
				orderByComparator);

		if (timetableCourse != null) {
			return timetableCourse;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("semesterId=");
		msg.append(semesterId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimetableCourseException(msg.toString());
	}

	/**
	 * Returns the first timetable course in the ordered set where semesterId = &#63;.
	 *
	 * @param semesterId the semester ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching timetable course, or <code>null</code> if a matching timetable course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse fetchBySemesterId_First(long semesterId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TimetableCourse> list = findBySemesterId(semesterId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last timetable course in the ordered set where semesterId = &#63;.
	 *
	 * @param semesterId the semester ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching timetable course
	 * @throws hu.unideb.inf.NoSuchTimetableCourseException if a matching timetable course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse findBySemesterId_Last(long semesterId,
		OrderByComparator orderByComparator)
		throws NoSuchTimetableCourseException, SystemException {
		TimetableCourse timetableCourse = fetchBySemesterId_Last(semesterId,
				orderByComparator);

		if (timetableCourse != null) {
			return timetableCourse;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("semesterId=");
		msg.append(semesterId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimetableCourseException(msg.toString());
	}

	/**
	 * Returns the last timetable course in the ordered set where semesterId = &#63;.
	 *
	 * @param semesterId the semester ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching timetable course, or <code>null</code> if a matching timetable course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse fetchBySemesterId_Last(long semesterId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySemesterId(semesterId);

		if (count == 0) {
			return null;
		}

		List<TimetableCourse> list = findBySemesterId(semesterId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the timetable courses before and after the current timetable course in the ordered set where semesterId = &#63;.
	 *
	 * @param timetableCourseId the primary key of the current timetable course
	 * @param semesterId the semester ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next timetable course
	 * @throws hu.unideb.inf.NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse[] findBySemesterId_PrevAndNext(
		long timetableCourseId, long semesterId,
		OrderByComparator orderByComparator)
		throws NoSuchTimetableCourseException, SystemException {
		TimetableCourse timetableCourse = findByPrimaryKey(timetableCourseId);

		Session session = null;

		try {
			session = openSession();

			TimetableCourse[] array = new TimetableCourseImpl[3];

			array[0] = getBySemesterId_PrevAndNext(session, timetableCourse,
					semesterId, orderByComparator, true);

			array[1] = timetableCourse;

			array[2] = getBySemesterId_PrevAndNext(session, timetableCourse,
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

	protected TimetableCourse getBySemesterId_PrevAndNext(Session session,
		TimetableCourse timetableCourse, long semesterId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TIMETABLECOURSE_WHERE);

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
			query.append(TimetableCourseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(semesterId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(timetableCourse);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TimetableCourse> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the timetable courses where semesterId = &#63; from the database.
	 *
	 * @param semesterId the semester ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySemesterId(long semesterId) throws SystemException {
		for (TimetableCourse timetableCourse : findBySemesterId(semesterId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(timetableCourse);
		}
	}

	/**
	 * Returns the number of timetable courses where semesterId = &#63;.
	 *
	 * @param semesterId the semester ID
	 * @return the number of matching timetable courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySemesterId(long semesterId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SEMESTERID;

		Object[] finderArgs = new Object[] { semesterId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TIMETABLECOURSE_WHERE);

			query.append(_FINDER_COLUMN_SEMESTERID_SEMESTERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(semesterId);

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

	private static final String _FINDER_COLUMN_SEMESTERID_SEMESTERID_2 = "timetableCourse.semesterId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_S_T = new FinderPath(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseModelImpl.FINDER_CACHE_ENABLED,
			TimetableCourseImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByC_S_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			TimetableCourseModelImpl.COURSEID_COLUMN_BITMASK |
			TimetableCourseModelImpl.SEMESTERID_COLUMN_BITMASK |
			TimetableCourseModelImpl.TIMETABLECOURSECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_S_T = new FinderPath(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_S_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the timetable course where courseId = &#63; and semesterId = &#63; and timetableCourseCode = &#63; or throws a {@link hu.unideb.inf.NoSuchTimetableCourseException} if it could not be found.
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @param timetableCourseCode the timetable course code
	 * @return the matching timetable course
	 * @throws hu.unideb.inf.NoSuchTimetableCourseException if a matching timetable course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse findByC_S_T(long courseId, long semesterId,
		String timetableCourseCode)
		throws NoSuchTimetableCourseException, SystemException {
		TimetableCourse timetableCourse = fetchByC_S_T(courseId, semesterId,
				timetableCourseCode);

		if (timetableCourse == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("courseId=");
			msg.append(courseId);

			msg.append(", semesterId=");
			msg.append(semesterId);

			msg.append(", timetableCourseCode=");
			msg.append(timetableCourseCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTimetableCourseException(msg.toString());
		}

		return timetableCourse;
	}

	/**
	 * Returns the timetable course where courseId = &#63; and semesterId = &#63; and timetableCourseCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @param timetableCourseCode the timetable course code
	 * @return the matching timetable course, or <code>null</code> if a matching timetable course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse fetchByC_S_T(long courseId, long semesterId,
		String timetableCourseCode) throws SystemException {
		return fetchByC_S_T(courseId, semesterId, timetableCourseCode, true);
	}

	/**
	 * Returns the timetable course where courseId = &#63; and semesterId = &#63; and timetableCourseCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @param timetableCourseCode the timetable course code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching timetable course, or <code>null</code> if a matching timetable course could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse fetchByC_S_T(long courseId, long semesterId,
		String timetableCourseCode, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				courseId, semesterId, timetableCourseCode
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_S_T,
					finderArgs, this);
		}

		if (result instanceof TimetableCourse) {
			TimetableCourse timetableCourse = (TimetableCourse)result;

			if ((courseId != timetableCourse.getCourseId()) ||
					(semesterId != timetableCourse.getSemesterId()) ||
					!Validator.equals(timetableCourseCode,
						timetableCourse.getTimetableCourseCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_TIMETABLECOURSE_WHERE);

			query.append(_FINDER_COLUMN_C_S_T_COURSEID_2);

			query.append(_FINDER_COLUMN_C_S_T_SEMESTERID_2);

			boolean bindTimetableCourseCode = false;

			if (timetableCourseCode == null) {
				query.append(_FINDER_COLUMN_C_S_T_TIMETABLECOURSECODE_1);
			}
			else if (timetableCourseCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_S_T_TIMETABLECOURSECODE_3);
			}
			else {
				bindTimetableCourseCode = true;

				query.append(_FINDER_COLUMN_C_S_T_TIMETABLECOURSECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				qPos.add(semesterId);

				if (bindTimetableCourseCode) {
					qPos.add(timetableCourseCode);
				}

				List<TimetableCourse> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_S_T,
						finderArgs, list);
				}
				else {
					TimetableCourse timetableCourse = list.get(0);

					result = timetableCourse;

					cacheResult(timetableCourse);

					if ((timetableCourse.getCourseId() != courseId) ||
							(timetableCourse.getSemesterId() != semesterId) ||
							(timetableCourse.getTimetableCourseCode() == null) ||
							!timetableCourse.getTimetableCourseCode()
												.equals(timetableCourseCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_S_T,
							finderArgs, timetableCourse);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_S_T,
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
			return (TimetableCourse)result;
		}
	}

	/**
	 * Removes the timetable course where courseId = &#63; and semesterId = &#63; and timetableCourseCode = &#63; from the database.
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @param timetableCourseCode the timetable course code
	 * @return the timetable course that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimetableCourse removeByC_S_T(long courseId, long semesterId,
		String timetableCourseCode)
		throws NoSuchTimetableCourseException, SystemException {
		TimetableCourse timetableCourse = findByC_S_T(courseId, semesterId,
				timetableCourseCode);

		return remove(timetableCourse);
	}

	/**
	 * Returns the number of timetable courses where courseId = &#63; and semesterId = &#63; and timetableCourseCode = &#63;.
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @param timetableCourseCode the timetable course code
	 * @return the number of matching timetable courses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_S_T(long courseId, long semesterId,
		String timetableCourseCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_S_T;

		Object[] finderArgs = new Object[] {
				courseId, semesterId, timetableCourseCode
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TIMETABLECOURSE_WHERE);

			query.append(_FINDER_COLUMN_C_S_T_COURSEID_2);

			query.append(_FINDER_COLUMN_C_S_T_SEMESTERID_2);

			boolean bindTimetableCourseCode = false;

			if (timetableCourseCode == null) {
				query.append(_FINDER_COLUMN_C_S_T_TIMETABLECOURSECODE_1);
			}
			else if (timetableCourseCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_S_T_TIMETABLECOURSECODE_3);
			}
			else {
				bindTimetableCourseCode = true;

				query.append(_FINDER_COLUMN_C_S_T_TIMETABLECOURSECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				qPos.add(semesterId);

				if (bindTimetableCourseCode) {
					qPos.add(timetableCourseCode);
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

	private static final String _FINDER_COLUMN_C_S_T_COURSEID_2 = "timetableCourse.courseId = ? AND ";
	private static final String _FINDER_COLUMN_C_S_T_SEMESTERID_2 = "timetableCourse.semesterId = ? AND ";
	private static final String _FINDER_COLUMN_C_S_T_TIMETABLECOURSECODE_1 = "timetableCourse.timetableCourseCode IS NULL";
	private static final String _FINDER_COLUMN_C_S_T_TIMETABLECOURSECODE_2 = "timetableCourse.timetableCourseCode = ?";
	private static final String _FINDER_COLUMN_C_S_T_TIMETABLECOURSECODE_3 = "(timetableCourse.timetableCourseCode IS NULL OR timetableCourse.timetableCourseCode = '')";

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

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TIMETABLECOURSECODE,
			new Object[] { timetableCourse.getTimetableCourseCode() },
			timetableCourse);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_S_T,
			new Object[] {
				timetableCourse.getCourseId(), timetableCourse.getSemesterId(),
				timetableCourse.getTimetableCourseCode()
			}, timetableCourse);

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

		clearUniqueFindersCache(timetableCourse);
	}

	@Override
	public void clearCache(List<TimetableCourse> timetableCourses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TimetableCourse timetableCourse : timetableCourses) {
			EntityCacheUtil.removeResult(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
				TimetableCourseImpl.class, timetableCourse.getPrimaryKey());

			clearUniqueFindersCache(timetableCourse);
		}
	}

	protected void cacheUniqueFindersCache(TimetableCourse timetableCourse) {
		if (timetableCourse.isNew()) {
			Object[] args = new Object[] {
					timetableCourse.getTimetableCourseCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TIMETABLECOURSECODE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TIMETABLECOURSECODE,
				args, timetableCourse);

			args = new Object[] {
					timetableCourse.getCourseId(),
					timetableCourse.getSemesterId(),
					timetableCourse.getTimetableCourseCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_S_T, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_S_T, args,
				timetableCourse);
		}
		else {
			TimetableCourseModelImpl timetableCourseModelImpl = (TimetableCourseModelImpl)timetableCourse;

			if ((timetableCourseModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TIMETABLECOURSECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timetableCourse.getTimetableCourseCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TIMETABLECOURSECODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TIMETABLECOURSECODE,
					args, timetableCourse);
			}

			if ((timetableCourseModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_S_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timetableCourse.getCourseId(),
						timetableCourse.getSemesterId(),
						timetableCourse.getTimetableCourseCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_S_T, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_S_T, args,
					timetableCourse);
			}
		}
	}

	protected void clearUniqueFindersCache(TimetableCourse timetableCourse) {
		TimetableCourseModelImpl timetableCourseModelImpl = (TimetableCourseModelImpl)timetableCourse;

		Object[] args = new Object[] { timetableCourse.getTimetableCourseCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TIMETABLECOURSECODE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TIMETABLECOURSECODE,
			args);

		if ((timetableCourseModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TIMETABLECOURSECODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					timetableCourseModelImpl.getOriginalTimetableCourseCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TIMETABLECOURSECODE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TIMETABLECOURSECODE,
				args);
		}

		args = new Object[] {
				timetableCourse.getCourseId(), timetableCourse.getSemesterId(),
				timetableCourse.getTimetableCourseCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_S_T, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_S_T, args);

		if ((timetableCourseModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_S_T.getColumnBitmask()) != 0) {
			args = new Object[] {
					timetableCourseModelImpl.getOriginalCourseId(),
					timetableCourseModelImpl.getOriginalSemesterId(),
					timetableCourseModelImpl.getOriginalTimetableCourseCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_S_T, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_S_T, args);
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

		TimetableCourseModelImpl timetableCourseModelImpl = (TimetableCourseModelImpl)timetableCourse;

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

		if (isNew || !TimetableCourseModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((timetableCourseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timetableCourseModelImpl.getOriginalCourseId(),
						timetableCourseModelImpl.getOriginalSemesterId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S,
					args);

				args = new Object[] {
						timetableCourseModelImpl.getCourseId(),
						timetableCourseModelImpl.getSemesterId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S,
					args);
			}

			if ((timetableCourseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timetableCourseModelImpl.getOriginalCourseId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
					args);

				args = new Object[] { timetableCourseModelImpl.getCourseId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
					args);
			}

			if ((timetableCourseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEMESTERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timetableCourseModelImpl.getOriginalSemesterId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEMESTERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEMESTERID,
					args);

				args = new Object[] { timetableCourseModelImpl.getSemesterId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEMESTERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEMESTERID,
					args);
			}
		}

		EntityCacheUtil.putResult(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseImpl.class, timetableCourse.getPrimaryKey(),
			timetableCourse);

		clearUniqueFindersCache(timetableCourse);
		cacheUniqueFindersCache(timetableCourse);

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
		timetableCourseImpl.setSemesterId(timetableCourse.getSemesterId());
		timetableCourseImpl.setTimetableCourseCode(timetableCourse.getTimetableCourseCode());
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
	private static final String _SQL_SELECT_TIMETABLECOURSE_WHERE = "SELECT timetableCourse FROM TimetableCourse timetableCourse WHERE ";
	private static final String _SQL_COUNT_TIMETABLECOURSE = "SELECT COUNT(timetableCourse) FROM TimetableCourse timetableCourse";
	private static final String _SQL_COUNT_TIMETABLECOURSE_WHERE = "SELECT COUNT(timetableCourse) FROM TimetableCourse timetableCourse WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "timetableCourse.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TimetableCourse exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TimetableCourse exists with the key {";
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