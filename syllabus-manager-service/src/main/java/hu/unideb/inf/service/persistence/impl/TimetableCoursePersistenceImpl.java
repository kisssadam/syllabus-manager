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

import hu.unideb.inf.exception.NoSuchTimetableCourseException;
import hu.unideb.inf.model.TimetableCourse;
import hu.unideb.inf.model.impl.TimetableCourseImpl;
import hu.unideb.inf.model.impl.TimetableCourseModelImpl;
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
 * The persistence implementation for the timetable course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see TimetableCoursePersistence
 * @see hu.unideb.inf.service.persistence.TimetableCourseUtil
 * @generated
 */
@ProviderType
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
	 */
	@Override
	public List<TimetableCourse> findByC_S(long courseId, long semesterId) {
		return findByC_S(courseId, semesterId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the timetable courses where courseId = &#63; and semesterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @return the range of matching timetable courses
	 */
	@Override
	public List<TimetableCourse> findByC_S(long courseId, long semesterId,
		int start, int end) {
		return findByC_S(courseId, semesterId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the timetable courses where courseId = &#63; and semesterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching timetable courses
	 */
	@Override
	public List<TimetableCourse> findByC_S(long courseId, long semesterId,
		int start, int end, OrderByComparator<TimetableCourse> orderByComparator) {
		return findByC_S(courseId, semesterId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the timetable courses where courseId = &#63; and semesterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching timetable courses
	 */
	@Override
	public List<TimetableCourse> findByC_S(long courseId, long semesterId,
		int start, int end,
		OrderByComparator<TimetableCourse> orderByComparator,
		boolean retrieveFromCache) {
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

		List<TimetableCourse> list = null;

		if (retrieveFromCache) {
			list = (List<TimetableCourse>)finderCache.getResult(finderPath,
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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TimetableCourse>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first timetable course in the ordered set where courseId = &#63; and semesterId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching timetable course
	 * @throws NoSuchTimetableCourseException if a matching timetable course could not be found
	 */
	@Override
	public TimetableCourse findByC_S_First(long courseId, long semesterId,
		OrderByComparator<TimetableCourse> orderByComparator)
		throws NoSuchTimetableCourseException {
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
	 */
	@Override
	public TimetableCourse fetchByC_S_First(long courseId, long semesterId,
		OrderByComparator<TimetableCourse> orderByComparator) {
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
	 * @throws NoSuchTimetableCourseException if a matching timetable course could not be found
	 */
	@Override
	public TimetableCourse findByC_S_Last(long courseId, long semesterId,
		OrderByComparator<TimetableCourse> orderByComparator)
		throws NoSuchTimetableCourseException {
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
	 */
	@Override
	public TimetableCourse fetchByC_S_Last(long courseId, long semesterId,
		OrderByComparator<TimetableCourse> orderByComparator) {
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
	 * @throws NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	 */
	@Override
	public TimetableCourse[] findByC_S_PrevAndNext(long timetableCourseId,
		long courseId, long semesterId,
		OrderByComparator<TimetableCourse> orderByComparator)
		throws NoSuchTimetableCourseException {
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
		OrderByComparator<TimetableCourse> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
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
	 */
	@Override
	public void removeByC_S(long courseId, long semesterId) {
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
	 */
	@Override
	public int countByC_S(long courseId, long semesterId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_S;

		Object[] finderArgs = new Object[] { courseId, semesterId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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
	 */
	@Override
	public List<TimetableCourse> findByCourseId(long courseId) {
		return findByCourseId(courseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the timetable courses where courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param courseId the course ID
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @return the range of matching timetable courses
	 */
	@Override
	public List<TimetableCourse> findByCourseId(long courseId, int start,
		int end) {
		return findByCourseId(courseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the timetable courses where courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param courseId the course ID
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching timetable courses
	 */
	@Override
	public List<TimetableCourse> findByCourseId(long courseId, int start,
		int end, OrderByComparator<TimetableCourse> orderByComparator) {
		return findByCourseId(courseId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the timetable courses where courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param courseId the course ID
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching timetable courses
	 */
	@Override
	public List<TimetableCourse> findByCourseId(long courseId, int start,
		int end, OrderByComparator<TimetableCourse> orderByComparator,
		boolean retrieveFromCache) {
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

		List<TimetableCourse> list = null;

		if (retrieveFromCache) {
			list = (List<TimetableCourse>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TimetableCourse timetableCourse : list) {
					if ((courseId != timetableCourse.getCourseId())) {
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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TimetableCourse>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first timetable course in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching timetable course
	 * @throws NoSuchTimetableCourseException if a matching timetable course could not be found
	 */
	@Override
	public TimetableCourse findByCourseId_First(long courseId,
		OrderByComparator<TimetableCourse> orderByComparator)
		throws NoSuchTimetableCourseException {
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
	 */
	@Override
	public TimetableCourse fetchByCourseId_First(long courseId,
		OrderByComparator<TimetableCourse> orderByComparator) {
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
	 * @throws NoSuchTimetableCourseException if a matching timetable course could not be found
	 */
	@Override
	public TimetableCourse findByCourseId_Last(long courseId,
		OrderByComparator<TimetableCourse> orderByComparator)
		throws NoSuchTimetableCourseException {
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
	 */
	@Override
	public TimetableCourse fetchByCourseId_Last(long courseId,
		OrderByComparator<TimetableCourse> orderByComparator) {
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
	 * @throws NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	 */
	@Override
	public TimetableCourse[] findByCourseId_PrevAndNext(
		long timetableCourseId, long courseId,
		OrderByComparator<TimetableCourse> orderByComparator)
		throws NoSuchTimetableCourseException {
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
		OrderByComparator<TimetableCourse> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
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
	 */
	@Override
	public void removeByCourseId(long courseId) {
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
	 */
	@Override
	public int countByCourseId(long courseId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSEID;

		Object[] finderArgs = new Object[] { courseId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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
	 */
	@Override
	public List<TimetableCourse> findBySemesterId(long semesterId) {
		return findBySemesterId(semesterId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the timetable courses where semesterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param semesterId the semester ID
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @return the range of matching timetable courses
	 */
	@Override
	public List<TimetableCourse> findBySemesterId(long semesterId, int start,
		int end) {
		return findBySemesterId(semesterId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the timetable courses where semesterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param semesterId the semester ID
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching timetable courses
	 */
	@Override
	public List<TimetableCourse> findBySemesterId(long semesterId, int start,
		int end, OrderByComparator<TimetableCourse> orderByComparator) {
		return findBySemesterId(semesterId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the timetable courses where semesterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param semesterId the semester ID
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching timetable courses
	 */
	@Override
	public List<TimetableCourse> findBySemesterId(long semesterId, int start,
		int end, OrderByComparator<TimetableCourse> orderByComparator,
		boolean retrieveFromCache) {
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

		List<TimetableCourse> list = null;

		if (retrieveFromCache) {
			list = (List<TimetableCourse>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TimetableCourse timetableCourse : list) {
					if ((semesterId != timetableCourse.getSemesterId())) {
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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TimetableCourse>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first timetable course in the ordered set where semesterId = &#63;.
	 *
	 * @param semesterId the semester ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching timetable course
	 * @throws NoSuchTimetableCourseException if a matching timetable course could not be found
	 */
	@Override
	public TimetableCourse findBySemesterId_First(long semesterId,
		OrderByComparator<TimetableCourse> orderByComparator)
		throws NoSuchTimetableCourseException {
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
	 */
	@Override
	public TimetableCourse fetchBySemesterId_First(long semesterId,
		OrderByComparator<TimetableCourse> orderByComparator) {
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
	 * @throws NoSuchTimetableCourseException if a matching timetable course could not be found
	 */
	@Override
	public TimetableCourse findBySemesterId_Last(long semesterId,
		OrderByComparator<TimetableCourse> orderByComparator)
		throws NoSuchTimetableCourseException {
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
	 */
	@Override
	public TimetableCourse fetchBySemesterId_Last(long semesterId,
		OrderByComparator<TimetableCourse> orderByComparator) {
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
	 * @throws NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	 */
	@Override
	public TimetableCourse[] findBySemesterId_PrevAndNext(
		long timetableCourseId, long semesterId,
		OrderByComparator<TimetableCourse> orderByComparator)
		throws NoSuchTimetableCourseException {
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
		OrderByComparator<TimetableCourse> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
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
	 */
	@Override
	public void removeBySemesterId(long semesterId) {
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
	 */
	@Override
	public int countBySemesterId(long semesterId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SEMESTERID;

		Object[] finderArgs = new Object[] { semesterId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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

	private static final String _FINDER_COLUMN_SEMESTERID_SEMESTERID_2 = "timetableCourse.semesterId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_S_T_S = new FinderPath(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseModelImpl.FINDER_CACHE_ENABLED,
			TimetableCourseImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByC_S_T_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			},
			TimetableCourseModelImpl.COURSEID_COLUMN_BITMASK |
			TimetableCourseModelImpl.SEMESTERID_COLUMN_BITMASK |
			TimetableCourseModelImpl.TIMETABLECOURSECODE_COLUMN_BITMASK |
			TimetableCourseModelImpl.SUBJECTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_S_T_S = new FinderPath(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_S_T_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), String.class.getName()
			});

	/**
	 * Returns the timetable course where courseId = &#63; and semesterId = &#63; and timetableCourseCode = &#63; and subjectType = &#63; or throws a {@link NoSuchTimetableCourseException} if it could not be found.
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @param timetableCourseCode the timetable course code
	 * @param subjectType the subject type
	 * @return the matching timetable course
	 * @throws NoSuchTimetableCourseException if a matching timetable course could not be found
	 */
	@Override
	public TimetableCourse findByC_S_T_S(long courseId, long semesterId,
		String timetableCourseCode, String subjectType)
		throws NoSuchTimetableCourseException {
		TimetableCourse timetableCourse = fetchByC_S_T_S(courseId, semesterId,
				timetableCourseCode, subjectType);

		if (timetableCourse == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("courseId=");
			msg.append(courseId);

			msg.append(", semesterId=");
			msg.append(semesterId);

			msg.append(", timetableCourseCode=");
			msg.append(timetableCourseCode);

			msg.append(", subjectType=");
			msg.append(subjectType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTimetableCourseException(msg.toString());
		}

		return timetableCourse;
	}

	/**
	 * Returns the timetable course where courseId = &#63; and semesterId = &#63; and timetableCourseCode = &#63; and subjectType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @param timetableCourseCode the timetable course code
	 * @param subjectType the subject type
	 * @return the matching timetable course, or <code>null</code> if a matching timetable course could not be found
	 */
	@Override
	public TimetableCourse fetchByC_S_T_S(long courseId, long semesterId,
		String timetableCourseCode, String subjectType) {
		return fetchByC_S_T_S(courseId, semesterId, timetableCourseCode,
			subjectType, true);
	}

	/**
	 * Returns the timetable course where courseId = &#63; and semesterId = &#63; and timetableCourseCode = &#63; and subjectType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @param timetableCourseCode the timetable course code
	 * @param subjectType the subject type
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching timetable course, or <code>null</code> if a matching timetable course could not be found
	 */
	@Override
	public TimetableCourse fetchByC_S_T_S(long courseId, long semesterId,
		String timetableCourseCode, String subjectType,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {
				courseId, semesterId, timetableCourseCode, subjectType
			};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_C_S_T_S,
					finderArgs, this);
		}

		if (result instanceof TimetableCourse) {
			TimetableCourse timetableCourse = (TimetableCourse)result;

			if ((courseId != timetableCourse.getCourseId()) ||
					(semesterId != timetableCourse.getSemesterId()) ||
					!Objects.equals(timetableCourseCode,
						timetableCourse.getTimetableCourseCode()) ||
					!Objects.equals(subjectType,
						timetableCourse.getSubjectType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_TIMETABLECOURSE_WHERE);

			query.append(_FINDER_COLUMN_C_S_T_S_COURSEID_2);

			query.append(_FINDER_COLUMN_C_S_T_S_SEMESTERID_2);

			boolean bindTimetableCourseCode = false;

			if (timetableCourseCode == null) {
				query.append(_FINDER_COLUMN_C_S_T_S_TIMETABLECOURSECODE_1);
			}
			else if (timetableCourseCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_S_T_S_TIMETABLECOURSECODE_3);
			}
			else {
				bindTimetableCourseCode = true;

				query.append(_FINDER_COLUMN_C_S_T_S_TIMETABLECOURSECODE_2);
			}

			boolean bindSubjectType = false;

			if (subjectType == null) {
				query.append(_FINDER_COLUMN_C_S_T_S_SUBJECTTYPE_1);
			}
			else if (subjectType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_S_T_S_SUBJECTTYPE_3);
			}
			else {
				bindSubjectType = true;

				query.append(_FINDER_COLUMN_C_S_T_S_SUBJECTTYPE_2);
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

				if (bindSubjectType) {
					qPos.add(subjectType);
				}

				List<TimetableCourse> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_C_S_T_S,
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
												.equals(timetableCourseCode) ||
							(timetableCourse.getSubjectType() == null) ||
							!timetableCourse.getSubjectType().equals(subjectType)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_C_S_T_S,
							finderArgs, timetableCourse);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_C_S_T_S,
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
	 * Removes the timetable course where courseId = &#63; and semesterId = &#63; and timetableCourseCode = &#63; and subjectType = &#63; from the database.
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @param timetableCourseCode the timetable course code
	 * @param subjectType the subject type
	 * @return the timetable course that was removed
	 */
	@Override
	public TimetableCourse removeByC_S_T_S(long courseId, long semesterId,
		String timetableCourseCode, String subjectType)
		throws NoSuchTimetableCourseException {
		TimetableCourse timetableCourse = findByC_S_T_S(courseId, semesterId,
				timetableCourseCode, subjectType);

		return remove(timetableCourse);
	}

	/**
	 * Returns the number of timetable courses where courseId = &#63; and semesterId = &#63; and timetableCourseCode = &#63; and subjectType = &#63;.
	 *
	 * @param courseId the course ID
	 * @param semesterId the semester ID
	 * @param timetableCourseCode the timetable course code
	 * @param subjectType the subject type
	 * @return the number of matching timetable courses
	 */
	@Override
	public int countByC_S_T_S(long courseId, long semesterId,
		String timetableCourseCode, String subjectType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_S_T_S;

		Object[] finderArgs = new Object[] {
				courseId, semesterId, timetableCourseCode, subjectType
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_TIMETABLECOURSE_WHERE);

			query.append(_FINDER_COLUMN_C_S_T_S_COURSEID_2);

			query.append(_FINDER_COLUMN_C_S_T_S_SEMESTERID_2);

			boolean bindTimetableCourseCode = false;

			if (timetableCourseCode == null) {
				query.append(_FINDER_COLUMN_C_S_T_S_TIMETABLECOURSECODE_1);
			}
			else if (timetableCourseCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_S_T_S_TIMETABLECOURSECODE_3);
			}
			else {
				bindTimetableCourseCode = true;

				query.append(_FINDER_COLUMN_C_S_T_S_TIMETABLECOURSECODE_2);
			}

			boolean bindSubjectType = false;

			if (subjectType == null) {
				query.append(_FINDER_COLUMN_C_S_T_S_SUBJECTTYPE_1);
			}
			else if (subjectType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_S_T_S_SUBJECTTYPE_3);
			}
			else {
				bindSubjectType = true;

				query.append(_FINDER_COLUMN_C_S_T_S_SUBJECTTYPE_2);
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

				if (bindSubjectType) {
					qPos.add(subjectType);
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

	private static final String _FINDER_COLUMN_C_S_T_S_COURSEID_2 = "timetableCourse.courseId = ? AND ";
	private static final String _FINDER_COLUMN_C_S_T_S_SEMESTERID_2 = "timetableCourse.semesterId = ? AND ";
	private static final String _FINDER_COLUMN_C_S_T_S_TIMETABLECOURSECODE_1 = "timetableCourse.timetableCourseCode IS NULL AND ";
	private static final String _FINDER_COLUMN_C_S_T_S_TIMETABLECOURSECODE_2 = "timetableCourse.timetableCourseCode = ? AND ";
	private static final String _FINDER_COLUMN_C_S_T_S_TIMETABLECOURSECODE_3 = "(timetableCourse.timetableCourseCode IS NULL OR timetableCourse.timetableCourseCode = '') AND ";
	private static final String _FINDER_COLUMN_C_S_T_S_SUBJECTTYPE_1 = "timetableCourse.subjectType IS NULL";
	private static final String _FINDER_COLUMN_C_S_T_S_SUBJECTTYPE_2 = "timetableCourse.subjectType = ?";
	private static final String _FINDER_COLUMN_C_S_T_S_SUBJECTTYPE_3 = "(timetableCourse.subjectType IS NULL OR timetableCourse.subjectType = '')";

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
		entityCache.putResult(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseImpl.class, timetableCourse.getPrimaryKey(),
			timetableCourse);

		finderCache.putResult(FINDER_PATH_FETCH_BY_C_S_T_S,
			new Object[] {
				timetableCourse.getCourseId(), timetableCourse.getSemesterId(),
				timetableCourse.getTimetableCourseCode(),
				timetableCourse.getSubjectType()
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
			if (entityCache.getResult(
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
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TimetableCourseImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the timetable course.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TimetableCourse timetableCourse) {
		entityCache.removeResult(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseImpl.class, timetableCourse.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TimetableCourseModelImpl)timetableCourse);
	}

	@Override
	public void clearCache(List<TimetableCourse> timetableCourses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TimetableCourse timetableCourse : timetableCourses) {
			entityCache.removeResult(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
				TimetableCourseImpl.class, timetableCourse.getPrimaryKey());

			clearUniqueFindersCache((TimetableCourseModelImpl)timetableCourse);
		}
	}

	protected void cacheUniqueFindersCache(
		TimetableCourseModelImpl timetableCourseModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					timetableCourseModelImpl.getCourseId(),
					timetableCourseModelImpl.getSemesterId(),
					timetableCourseModelImpl.getTimetableCourseCode(),
					timetableCourseModelImpl.getSubjectType()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_C_S_T_S, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_C_S_T_S, args,
				timetableCourseModelImpl);
		}
		else {
			if ((timetableCourseModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_S_T_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timetableCourseModelImpl.getCourseId(),
						timetableCourseModelImpl.getSemesterId(),
						timetableCourseModelImpl.getTimetableCourseCode(),
						timetableCourseModelImpl.getSubjectType()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_C_S_T_S, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_C_S_T_S, args,
					timetableCourseModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		TimetableCourseModelImpl timetableCourseModelImpl) {
		Object[] args = new Object[] {
				timetableCourseModelImpl.getCourseId(),
				timetableCourseModelImpl.getSemesterId(),
				timetableCourseModelImpl.getTimetableCourseCode(),
				timetableCourseModelImpl.getSubjectType()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_C_S_T_S, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_C_S_T_S, args);

		if ((timetableCourseModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_S_T_S.getColumnBitmask()) != 0) {
			args = new Object[] {
					timetableCourseModelImpl.getOriginalCourseId(),
					timetableCourseModelImpl.getOriginalSemesterId(),
					timetableCourseModelImpl.getOriginalTimetableCourseCode(),
					timetableCourseModelImpl.getOriginalSubjectType()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_C_S_T_S, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_C_S_T_S, args);
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

		timetableCourse.setCompanyId(companyProvider.getCompanyId());

		return timetableCourse;
	}

	/**
	 * Removes the timetable course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param timetableCourseId the primary key of the timetable course
	 * @return the timetable course that was removed
	 * @throws NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	 */
	@Override
	public TimetableCourse remove(long timetableCourseId)
		throws NoSuchTimetableCourseException {
		return remove((Serializable)timetableCourseId);
	}

	/**
	 * Removes the timetable course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the timetable course
	 * @return the timetable course that was removed
	 * @throws NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	 */
	@Override
	public TimetableCourse remove(Serializable primaryKey)
		throws NoSuchTimetableCourseException {
		Session session = null;

		try {
			session = openSession();

			TimetableCourse timetableCourse = (TimetableCourse)session.get(TimetableCourseImpl.class,
					primaryKey);

			if (timetableCourse == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
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
	protected TimetableCourse removeImpl(TimetableCourse timetableCourse) {
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
	public TimetableCourse updateImpl(TimetableCourse timetableCourse) {
		timetableCourse = toUnwrappedModel(timetableCourse);

		boolean isNew = timetableCourse.isNew();

		TimetableCourseModelImpl timetableCourseModelImpl = (TimetableCourseModelImpl)timetableCourse;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (timetableCourse.getCreateDate() == null)) {
			if (serviceContext == null) {
				timetableCourse.setCreateDate(now);
			}
			else {
				timetableCourse.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!timetableCourseModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				timetableCourse.setModifiedDate(now);
			}
			else {
				timetableCourse.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (timetableCourse.isNew()) {
				session.save(timetableCourse);

				timetableCourse.setNew(false);
			}
			else {
				timetableCourse = (TimetableCourse)session.merge(timetableCourse);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TimetableCourseModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((timetableCourseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timetableCourseModelImpl.getOriginalCourseId(),
						timetableCourseModelImpl.getOriginalSemesterId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_S, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S,
					args);

				args = new Object[] {
						timetableCourseModelImpl.getCourseId(),
						timetableCourseModelImpl.getSemesterId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_C_S, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_S,
					args);
			}

			if ((timetableCourseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timetableCourseModelImpl.getOriginalCourseId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
					args);

				args = new Object[] { timetableCourseModelImpl.getCourseId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
					args);
			}

			if ((timetableCourseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEMESTERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timetableCourseModelImpl.getOriginalSemesterId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SEMESTERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEMESTERID,
					args);

				args = new Object[] { timetableCourseModelImpl.getSemesterId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SEMESTERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEMESTERID,
					args);
			}
		}

		entityCache.putResult(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
			TimetableCourseImpl.class, timetableCourse.getPrimaryKey(),
			timetableCourse, false);

		clearUniqueFindersCache(timetableCourseModelImpl);
		cacheUniqueFindersCache(timetableCourseModelImpl, isNew);

		timetableCourse.resetOriginalValues();

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
	 * Returns the timetable course with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the timetable course
	 * @return the timetable course
	 * @throws NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	 */
	@Override
	public TimetableCourse findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTimetableCourseException {
		TimetableCourse timetableCourse = fetchByPrimaryKey(primaryKey);

		if (timetableCourse == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTimetableCourseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return timetableCourse;
	}

	/**
	 * Returns the timetable course with the primary key or throws a {@link NoSuchTimetableCourseException} if it could not be found.
	 *
	 * @param timetableCourseId the primary key of the timetable course
	 * @return the timetable course
	 * @throws NoSuchTimetableCourseException if a timetable course with the primary key could not be found
	 */
	@Override
	public TimetableCourse findByPrimaryKey(long timetableCourseId)
		throws NoSuchTimetableCourseException {
		return findByPrimaryKey((Serializable)timetableCourseId);
	}

	/**
	 * Returns the timetable course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the timetable course
	 * @return the timetable course, or <code>null</code> if a timetable course with the primary key could not be found
	 */
	@Override
	public TimetableCourse fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
				TimetableCourseImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TimetableCourse timetableCourse = (TimetableCourse)serializable;

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
					entityCache.putResult(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
						TimetableCourseImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
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
	 */
	@Override
	public TimetableCourse fetchByPrimaryKey(long timetableCourseId) {
		return fetchByPrimaryKey((Serializable)timetableCourseId);
	}

	@Override
	public Map<Serializable, TimetableCourse> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TimetableCourse> map = new HashMap<Serializable, TimetableCourse>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TimetableCourse timetableCourse = fetchByPrimaryKey(primaryKey);

			if (timetableCourse != null) {
				map.put(primaryKey, timetableCourse);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
					TimetableCourseImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TimetableCourse)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TIMETABLECOURSE_WHERE_PKS_IN);

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

			for (TimetableCourse timetableCourse : (List<TimetableCourse>)q.list()) {
				map.put(timetableCourse.getPrimaryKeyObj(), timetableCourse);

				cacheResult(timetableCourse);

				uncachedPrimaryKeys.remove(timetableCourse.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TimetableCourseModelImpl.ENTITY_CACHE_ENABLED,
					TimetableCourseImpl.class, primaryKey, nullModel);
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
	 * Returns all the timetable courses.
	 *
	 * @return the timetable courses
	 */
	@Override
	public List<TimetableCourse> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the timetable courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @return the range of timetable courses
	 */
	@Override
	public List<TimetableCourse> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the timetable courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of timetable courses
	 */
	@Override
	public List<TimetableCourse> findAll(int start, int end,
		OrderByComparator<TimetableCourse> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the timetable courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of timetable courses
	 */
	@Override
	public List<TimetableCourse> findAll(int start, int end,
		OrderByComparator<TimetableCourse> orderByComparator,
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

		List<TimetableCourse> list = null;

		if (retrieveFromCache) {
			list = (List<TimetableCourse>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TimetableCourse>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the timetable courses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TimetableCourse timetableCourse : findAll()) {
			remove(timetableCourse);
		}
	}

	/**
	 * Returns the number of timetable courses.
	 *
	 * @return the number of timetable courses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TIMETABLECOURSE);

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
	 * Returns the primaryKeys of lecturers associated with the timetable course.
	 *
	 * @param pk the primary key of the timetable course
	 * @return long[] of the primaryKeys of lecturers associated with the timetable course
	 */
	@Override
	public long[] getLecturerPrimaryKeys(long pk) {
		long[] pks = timetableCourseToLecturerTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the lecturers associated with the timetable course.
	 *
	 * @param pk the primary key of the timetable course
	 * @return the lecturers associated with the timetable course
	 */
	@Override
	public List<hu.unideb.inf.model.Lecturer> getLecturers(long pk) {
		return getLecturers(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the lecturers associated with the timetable course.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the timetable course
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @return the range of lecturers associated with the timetable course
	 */
	@Override
	public List<hu.unideb.inf.model.Lecturer> getLecturers(long pk, int start,
		int end) {
		return getLecturers(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lecturers associated with the timetable course.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimetableCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the timetable course
	 * @param start the lower bound of the range of timetable courses
	 * @param end the upper bound of the range of timetable courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lecturers associated with the timetable course
	 */
	@Override
	public List<hu.unideb.inf.model.Lecturer> getLecturers(long pk, int start,
		int end,
		OrderByComparator<hu.unideb.inf.model.Lecturer> orderByComparator) {
		return timetableCourseToLecturerTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of lecturers associated with the timetable course.
	 *
	 * @param pk the primary key of the timetable course
	 * @return the number of lecturers associated with the timetable course
	 */
	@Override
	public int getLecturersSize(long pk) {
		long[] pks = timetableCourseToLecturerTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the lecturer is associated with the timetable course.
	 *
	 * @param pk the primary key of the timetable course
	 * @param lecturerPK the primary key of the lecturer
	 * @return <code>true</code> if the lecturer is associated with the timetable course; <code>false</code> otherwise
	 */
	@Override
	public boolean containsLecturer(long pk, long lecturerPK) {
		return timetableCourseToLecturerTableMapper.containsTableMapping(pk,
			lecturerPK);
	}

	/**
	 * Returns <code>true</code> if the timetable course has any lecturers associated with it.
	 *
	 * @param pk the primary key of the timetable course to check for associations with lecturers
	 * @return <code>true</code> if the timetable course has any lecturers associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsLecturers(long pk) {
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
	 */
	@Override
	public void addLecturer(long pk, long lecturerPK) {
		TimetableCourse timetableCourse = fetchByPrimaryKey(pk);

		if (timetableCourse == null) {
			timetableCourseToLecturerTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, lecturerPK);
		}
		else {
			timetableCourseToLecturerTableMapper.addTableMapping(timetableCourse.getCompanyId(),
				pk, lecturerPK);
		}
	}

	/**
	 * Adds an association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the timetable course
	 * @param lecturer the lecturer
	 */
	@Override
	public void addLecturer(long pk, hu.unideb.inf.model.Lecturer lecturer) {
		TimetableCourse timetableCourse = fetchByPrimaryKey(pk);

		if (timetableCourse == null) {
			timetableCourseToLecturerTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, lecturer.getPrimaryKey());
		}
		else {
			timetableCourseToLecturerTableMapper.addTableMapping(timetableCourse.getCompanyId(),
				pk, lecturer.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the timetable course
	 * @param lecturerPKs the primary keys of the lecturers
	 */
	@Override
	public void addLecturers(long pk, long[] lecturerPKs) {
		long companyId = 0;

		TimetableCourse timetableCourse = fetchByPrimaryKey(pk);

		if (timetableCourse == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = timetableCourse.getCompanyId();
		}

		timetableCourseToLecturerTableMapper.addTableMappings(companyId, pk,
			lecturerPKs);
	}

	/**
	 * Adds an association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the timetable course
	 * @param lecturers the lecturers
	 */
	@Override
	public void addLecturers(long pk,
		List<hu.unideb.inf.model.Lecturer> lecturers) {
		addLecturers(pk,
			ListUtil.toLongArray(lecturers,
				hu.unideb.inf.model.Lecturer.LECTURER_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the timetable course and its lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the timetable course to clear the associated lecturers from
	 */
	@Override
	public void clearLecturers(long pk) {
		timetableCourseToLecturerTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the timetable course
	 * @param lecturerPK the primary key of the lecturer
	 */
	@Override
	public void removeLecturer(long pk, long lecturerPK) {
		timetableCourseToLecturerTableMapper.deleteTableMapping(pk, lecturerPK);
	}

	/**
	 * Removes the association between the timetable course and the lecturer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the timetable course
	 * @param lecturer the lecturer
	 */
	@Override
	public void removeLecturer(long pk, hu.unideb.inf.model.Lecturer lecturer) {
		timetableCourseToLecturerTableMapper.deleteTableMapping(pk,
			lecturer.getPrimaryKey());
	}

	/**
	 * Removes the association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the timetable course
	 * @param lecturerPKs the primary keys of the lecturers
	 */
	@Override
	public void removeLecturers(long pk, long[] lecturerPKs) {
		timetableCourseToLecturerTableMapper.deleteTableMappings(pk, lecturerPKs);
	}

	/**
	 * Removes the association between the timetable course and the lecturers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the timetable course
	 * @param lecturers the lecturers
	 */
	@Override
	public void removeLecturers(long pk,
		List<hu.unideb.inf.model.Lecturer> lecturers) {
		removeLecturers(pk,
			ListUtil.toLongArray(lecturers,
				hu.unideb.inf.model.Lecturer.LECTURER_ID_ACCESSOR));
	}

	/**
	 * Sets the lecturers associated with the timetable course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the timetable course
	 * @param lecturerPKs the primary keys of the lecturers to be associated with the timetable course
	 */
	@Override
	public void setLecturers(long pk, long[] lecturerPKs) {
		Set<Long> newLecturerPKsSet = SetUtil.fromArray(lecturerPKs);
		Set<Long> oldLecturerPKsSet = SetUtil.fromArray(timetableCourseToLecturerTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeLecturerPKsSet = new HashSet<Long>(oldLecturerPKsSet);

		removeLecturerPKsSet.removeAll(newLecturerPKsSet);

		timetableCourseToLecturerTableMapper.deleteTableMappings(pk,
			ArrayUtil.toLongArray(removeLecturerPKsSet));

		newLecturerPKsSet.removeAll(oldLecturerPKsSet);

		long companyId = 0;

		TimetableCourse timetableCourse = fetchByPrimaryKey(pk);

		if (timetableCourse == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = timetableCourse.getCompanyId();
		}

		timetableCourseToLecturerTableMapper.addTableMappings(companyId, pk,
			ArrayUtil.toLongArray(newLecturerPKsSet));
	}

	/**
	 * Sets the lecturers associated with the timetable course, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the timetable course
	 * @param lecturers the lecturers to be associated with the timetable course
	 */
	@Override
	public void setLecturers(long pk,
		List<hu.unideb.inf.model.Lecturer> lecturers) {
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
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TimetableCourseModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the timetable course persistence.
	 */
	public void afterPropertiesSet() {
		timetableCourseToLecturerTableMapper = TableMapperFactory.getTableMapper("syllabus_manager_Lecturers_TimetableCourses",
				"companyId", "timetableCourseId", "lecturerId", this,
				lecturerPersistence);
	}

	public void destroy() {
		entityCache.removeCache(TimetableCourseImpl.class.getName());
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
	@BeanReference(type = LecturerPersistence.class)
	protected LecturerPersistence lecturerPersistence;
	protected TableMapper<TimetableCourse, hu.unideb.inf.model.Lecturer> timetableCourseToLecturerTableMapper;
	private static final String _SQL_SELECT_TIMETABLECOURSE = "SELECT timetableCourse FROM TimetableCourse timetableCourse";
	private static final String _SQL_SELECT_TIMETABLECOURSE_WHERE_PKS_IN = "SELECT timetableCourse FROM TimetableCourse timetableCourse WHERE timetableCourseId IN (";
	private static final String _SQL_SELECT_TIMETABLECOURSE_WHERE = "SELECT timetableCourse FROM TimetableCourse timetableCourse WHERE ";
	private static final String _SQL_COUNT_TIMETABLECOURSE = "SELECT COUNT(timetableCourse) FROM TimetableCourse timetableCourse";
	private static final String _SQL_COUNT_TIMETABLECOURSE_WHERE = "SELECT COUNT(timetableCourse) FROM TimetableCourse timetableCourse WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "timetableCourse.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TimetableCourse exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TimetableCourse exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TimetableCoursePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"limit"
			});
}