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

import hu.unideb.inf.exception.NoSuchSubjectException;
import hu.unideb.inf.model.Subject;
import hu.unideb.inf.model.impl.SubjectImpl;
import hu.unideb.inf.model.impl.SubjectModelImpl;
import hu.unideb.inf.service.persistence.SubjectPersistence;

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
 * The persistence implementation for the subject service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Adam Kiss
 * @see SubjectPersistence
 * @see hu.unideb.inf.service.persistence.SubjectUtil
 * @generated
 */
@ProviderType
public class SubjectPersistenceImpl extends BasePersistenceImpl<Subject>
	implements SubjectPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SubjectUtil} to access the subject persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SubjectImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectModelImpl.FINDER_CACHE_ENABLED, SubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectModelImpl.FINDER_CACHE_ENABLED, SubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_C_S = new FinderPath(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectModelImpl.FINDER_CACHE_ENABLED, SubjectImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_S",
			new String[] { Long.class.getName(), String.class.getName() },
			SubjectModelImpl.CURRICULUMID_COLUMN_BITMASK |
			SubjectModelImpl.SUBJECTCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_S = new FinderPath(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_S",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the subject where curriculumId = &#63; and subjectCode = &#63; or throws a {@link NoSuchSubjectException} if it could not be found.
	 *
	 * @param curriculumId the curriculum ID
	 * @param subjectCode the subject code
	 * @return the matching subject
	 * @throws NoSuchSubjectException if a matching subject could not be found
	 */
	@Override
	public Subject findByC_S(long curriculumId, String subjectCode)
		throws NoSuchSubjectException {
		Subject subject = fetchByC_S(curriculumId, subjectCode);

		if (subject == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("curriculumId=");
			msg.append(curriculumId);

			msg.append(", subjectCode=");
			msg.append(subjectCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchSubjectException(msg.toString());
		}

		return subject;
	}

	/**
	 * Returns the subject where curriculumId = &#63; and subjectCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param curriculumId the curriculum ID
	 * @param subjectCode the subject code
	 * @return the matching subject, or <code>null</code> if a matching subject could not be found
	 */
	@Override
	public Subject fetchByC_S(long curriculumId, String subjectCode) {
		return fetchByC_S(curriculumId, subjectCode, true);
	}

	/**
	 * Returns the subject where curriculumId = &#63; and subjectCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param curriculumId the curriculum ID
	 * @param subjectCode the subject code
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching subject, or <code>null</code> if a matching subject could not be found
	 */
	@Override
	public Subject fetchByC_S(long curriculumId, String subjectCode,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { curriculumId, subjectCode };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_C_S,
					finderArgs, this);
		}

		if (result instanceof Subject) {
			Subject subject = (Subject)result;

			if ((curriculumId != subject.getCurriculumId()) ||
					!Objects.equals(subjectCode, subject.getSubjectCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SUBJECT_WHERE);

			query.append(_FINDER_COLUMN_C_S_CURRICULUMID_2);

			boolean bindSubjectCode = false;

			if (subjectCode == null) {
				query.append(_FINDER_COLUMN_C_S_SUBJECTCODE_1);
			}
			else if (subjectCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_S_SUBJECTCODE_3);
			}
			else {
				bindSubjectCode = true;

				query.append(_FINDER_COLUMN_C_S_SUBJECTCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(curriculumId);

				if (bindSubjectCode) {
					qPos.add(subjectCode);
				}

				List<Subject> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_C_S, finderArgs,
						list);
				}
				else {
					Subject subject = list.get(0);

					result = subject;

					cacheResult(subject);

					if ((subject.getCurriculumId() != curriculumId) ||
							(subject.getSubjectCode() == null) ||
							!subject.getSubjectCode().equals(subjectCode)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_C_S,
							finderArgs, subject);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_C_S, finderArgs);

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
			return (Subject)result;
		}
	}

	/**
	 * Removes the subject where curriculumId = &#63; and subjectCode = &#63; from the database.
	 *
	 * @param curriculumId the curriculum ID
	 * @param subjectCode the subject code
	 * @return the subject that was removed
	 */
	@Override
	public Subject removeByC_S(long curriculumId, String subjectCode)
		throws NoSuchSubjectException {
		Subject subject = findByC_S(curriculumId, subjectCode);

		return remove(subject);
	}

	/**
	 * Returns the number of subjects where curriculumId = &#63; and subjectCode = &#63;.
	 *
	 * @param curriculumId the curriculum ID
	 * @param subjectCode the subject code
	 * @return the number of matching subjects
	 */
	@Override
	public int countByC_S(long curriculumId, String subjectCode) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_S;

		Object[] finderArgs = new Object[] { curriculumId, subjectCode };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SUBJECT_WHERE);

			query.append(_FINDER_COLUMN_C_S_CURRICULUMID_2);

			boolean bindSubjectCode = false;

			if (subjectCode == null) {
				query.append(_FINDER_COLUMN_C_S_SUBJECTCODE_1);
			}
			else if (subjectCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_S_SUBJECTCODE_3);
			}
			else {
				bindSubjectCode = true;

				query.append(_FINDER_COLUMN_C_S_SUBJECTCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(curriculumId);

				if (bindSubjectCode) {
					qPos.add(subjectCode);
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

	private static final String _FINDER_COLUMN_C_S_CURRICULUMID_2 = "subject.curriculumId = ? AND ";
	private static final String _FINDER_COLUMN_C_S_SUBJECTCODE_1 = "subject.subjectCode IS NULL";
	private static final String _FINDER_COLUMN_C_S_SUBJECTCODE_2 = "subject.subjectCode = ?";
	private static final String _FINDER_COLUMN_C_S_SUBJECTCODE_3 = "(subject.subjectCode IS NULL OR subject.subjectCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CURRICULUM =
		new FinderPath(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectModelImpl.FINDER_CACHE_ENABLED, SubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCurriculum",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CURRICULUM =
		new FinderPath(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectModelImpl.FINDER_CACHE_ENABLED, SubjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCurriculum",
			new String[] { Long.class.getName() },
			SubjectModelImpl.CURRICULUMID_COLUMN_BITMASK |
			SubjectModelImpl.SUBJECTCODE_COLUMN_BITMASK |
			SubjectModelImpl.SUBJECTNAME_COLUMN_BITMASK |
			SubjectModelImpl.CREDIT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CURRICULUM = new FinderPath(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCurriculum",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the subjects where curriculumId = &#63;.
	 *
	 * @param curriculumId the curriculum ID
	 * @return the matching subjects
	 */
	@Override
	public List<Subject> findByCurriculum(long curriculumId) {
		return findByCurriculum(curriculumId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the subjects where curriculumId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param curriculumId the curriculum ID
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @return the range of matching subjects
	 */
	@Override
	public List<Subject> findByCurriculum(long curriculumId, int start, int end) {
		return findByCurriculum(curriculumId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the subjects where curriculumId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param curriculumId the curriculum ID
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching subjects
	 */
	@Override
	public List<Subject> findByCurriculum(long curriculumId, int start,
		int end, OrderByComparator<Subject> orderByComparator) {
		return findByCurriculum(curriculumId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the subjects where curriculumId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param curriculumId the curriculum ID
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching subjects
	 */
	@Override
	public List<Subject> findByCurriculum(long curriculumId, int start,
		int end, OrderByComparator<Subject> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CURRICULUM;
			finderArgs = new Object[] { curriculumId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CURRICULUM;
			finderArgs = new Object[] {
					curriculumId,
					
					start, end, orderByComparator
				};
		}

		List<Subject> list = null;

		if (retrieveFromCache) {
			list = (List<Subject>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Subject subject : list) {
					if ((curriculumId != subject.getCurriculumId())) {
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

			query.append(_SQL_SELECT_SUBJECT_WHERE);

			query.append(_FINDER_COLUMN_CURRICULUM_CURRICULUMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(curriculumId);

				if (!pagination) {
					list = (List<Subject>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Subject>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first subject in the ordered set where curriculumId = &#63;.
	 *
	 * @param curriculumId the curriculum ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subject
	 * @throws NoSuchSubjectException if a matching subject could not be found
	 */
	@Override
	public Subject findByCurriculum_First(long curriculumId,
		OrderByComparator<Subject> orderByComparator)
		throws NoSuchSubjectException {
		Subject subject = fetchByCurriculum_First(curriculumId,
				orderByComparator);

		if (subject != null) {
			return subject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("curriculumId=");
		msg.append(curriculumId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubjectException(msg.toString());
	}

	/**
	 * Returns the first subject in the ordered set where curriculumId = &#63;.
	 *
	 * @param curriculumId the curriculum ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subject, or <code>null</code> if a matching subject could not be found
	 */
	@Override
	public Subject fetchByCurriculum_First(long curriculumId,
		OrderByComparator<Subject> orderByComparator) {
		List<Subject> list = findByCurriculum(curriculumId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last subject in the ordered set where curriculumId = &#63;.
	 *
	 * @param curriculumId the curriculum ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subject
	 * @throws NoSuchSubjectException if a matching subject could not be found
	 */
	@Override
	public Subject findByCurriculum_Last(long curriculumId,
		OrderByComparator<Subject> orderByComparator)
		throws NoSuchSubjectException {
		Subject subject = fetchByCurriculum_Last(curriculumId, orderByComparator);

		if (subject != null) {
			return subject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("curriculumId=");
		msg.append(curriculumId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSubjectException(msg.toString());
	}

	/**
	 * Returns the last subject in the ordered set where curriculumId = &#63;.
	 *
	 * @param curriculumId the curriculum ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subject, or <code>null</code> if a matching subject could not be found
	 */
	@Override
	public Subject fetchByCurriculum_Last(long curriculumId,
		OrderByComparator<Subject> orderByComparator) {
		int count = countByCurriculum(curriculumId);

		if (count == 0) {
			return null;
		}

		List<Subject> list = findByCurriculum(curriculumId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the subjects before and after the current subject in the ordered set where curriculumId = &#63;.
	 *
	 * @param subjectId the primary key of the current subject
	 * @param curriculumId the curriculum ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subject
	 * @throws NoSuchSubjectException if a subject with the primary key could not be found
	 */
	@Override
	public Subject[] findByCurriculum_PrevAndNext(long subjectId,
		long curriculumId, OrderByComparator<Subject> orderByComparator)
		throws NoSuchSubjectException {
		Subject subject = findByPrimaryKey(subjectId);

		Session session = null;

		try {
			session = openSession();

			Subject[] array = new SubjectImpl[3];

			array[0] = getByCurriculum_PrevAndNext(session, subject,
					curriculumId, orderByComparator, true);

			array[1] = subject;

			array[2] = getByCurriculum_PrevAndNext(session, subject,
					curriculumId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Subject getByCurriculum_PrevAndNext(Session session,
		Subject subject, long curriculumId,
		OrderByComparator<Subject> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBJECT_WHERE);

		query.append(_FINDER_COLUMN_CURRICULUM_CURRICULUMID_2);

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
			query.append(SubjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(curriculumId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(subject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Subject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the subjects where curriculumId = &#63; from the database.
	 *
	 * @param curriculumId the curriculum ID
	 */
	@Override
	public void removeByCurriculum(long curriculumId) {
		for (Subject subject : findByCurriculum(curriculumId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(subject);
		}
	}

	/**
	 * Returns the number of subjects where curriculumId = &#63;.
	 *
	 * @param curriculumId the curriculum ID
	 * @return the number of matching subjects
	 */
	@Override
	public int countByCurriculum(long curriculumId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CURRICULUM;

		Object[] finderArgs = new Object[] { curriculumId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBJECT_WHERE);

			query.append(_FINDER_COLUMN_CURRICULUM_CURRICULUMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(curriculumId);

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

	private static final String _FINDER_COLUMN_CURRICULUM_CURRICULUMID_2 = "subject.curriculumId = ?";

	public SubjectPersistenceImpl() {
		setModelClass(Subject.class);
	}

	/**
	 * Caches the subject in the entity cache if it is enabled.
	 *
	 * @param subject the subject
	 */
	@Override
	public void cacheResult(Subject subject) {
		entityCache.putResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectImpl.class, subject.getPrimaryKey(), subject);

		finderCache.putResult(FINDER_PATH_FETCH_BY_C_S,
			new Object[] { subject.getCurriculumId(), subject.getSubjectCode() },
			subject);

		subject.resetOriginalValues();
	}

	/**
	 * Caches the subjects in the entity cache if it is enabled.
	 *
	 * @param subjects the subjects
	 */
	@Override
	public void cacheResult(List<Subject> subjects) {
		for (Subject subject : subjects) {
			if (entityCache.getResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
						SubjectImpl.class, subject.getPrimaryKey()) == null) {
				cacheResult(subject);
			}
			else {
				subject.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all subjects.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SubjectImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the subject.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Subject subject) {
		entityCache.removeResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectImpl.class, subject.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((SubjectModelImpl)subject);
	}

	@Override
	public void clearCache(List<Subject> subjects) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Subject subject : subjects) {
			entityCache.removeResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
				SubjectImpl.class, subject.getPrimaryKey());

			clearUniqueFindersCache((SubjectModelImpl)subject);
		}
	}

	protected void cacheUniqueFindersCache(SubjectModelImpl subjectModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					subjectModelImpl.getCurriculumId(),
					subjectModelImpl.getSubjectCode()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_C_S, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_C_S, args,
				subjectModelImpl);
		}
		else {
			if ((subjectModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						subjectModelImpl.getCurriculumId(),
						subjectModelImpl.getSubjectCode()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_C_S, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_C_S, args,
					subjectModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(SubjectModelImpl subjectModelImpl) {
		Object[] args = new Object[] {
				subjectModelImpl.getCurriculumId(),
				subjectModelImpl.getSubjectCode()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_C_S, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_C_S, args);

		if ((subjectModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_S.getColumnBitmask()) != 0) {
			args = new Object[] {
					subjectModelImpl.getOriginalCurriculumId(),
					subjectModelImpl.getOriginalSubjectCode()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_C_S, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_C_S, args);
		}
	}

	/**
	 * Creates a new subject with the primary key. Does not add the subject to the database.
	 *
	 * @param subjectId the primary key for the new subject
	 * @return the new subject
	 */
	@Override
	public Subject create(long subjectId) {
		Subject subject = new SubjectImpl();

		subject.setNew(true);
		subject.setPrimaryKey(subjectId);

		subject.setCompanyId(companyProvider.getCompanyId());

		return subject;
	}

	/**
	 * Removes the subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subjectId the primary key of the subject
	 * @return the subject that was removed
	 * @throws NoSuchSubjectException if a subject with the primary key could not be found
	 */
	@Override
	public Subject remove(long subjectId) throws NoSuchSubjectException {
		return remove((Serializable)subjectId);
	}

	/**
	 * Removes the subject with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the subject
	 * @return the subject that was removed
	 * @throws NoSuchSubjectException if a subject with the primary key could not be found
	 */
	@Override
	public Subject remove(Serializable primaryKey)
		throws NoSuchSubjectException {
		Session session = null;

		try {
			session = openSession();

			Subject subject = (Subject)session.get(SubjectImpl.class, primaryKey);

			if (subject == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(subject);
		}
		catch (NoSuchSubjectException nsee) {
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
	protected Subject removeImpl(Subject subject) {
		subject = toUnwrappedModel(subject);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(subject)) {
				subject = (Subject)session.get(SubjectImpl.class,
						subject.getPrimaryKeyObj());
			}

			if (subject != null) {
				session.delete(subject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (subject != null) {
			clearCache(subject);
		}

		return subject;
	}

	@Override
	public Subject updateImpl(Subject subject) {
		subject = toUnwrappedModel(subject);

		boolean isNew = subject.isNew();

		SubjectModelImpl subjectModelImpl = (SubjectModelImpl)subject;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (subject.getCreateDate() == null)) {
			if (serviceContext == null) {
				subject.setCreateDate(now);
			}
			else {
				subject.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!subjectModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				subject.setModifiedDate(now);
			}
			else {
				subject.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (subject.isNew()) {
				session.save(subject);

				subject.setNew(false);
			}
			else {
				subject = (Subject)session.merge(subject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SubjectModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((subjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CURRICULUM.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						subjectModelImpl.getOriginalCurriculumId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CURRICULUM, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CURRICULUM,
					args);

				args = new Object[] { subjectModelImpl.getCurriculumId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CURRICULUM, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CURRICULUM,
					args);
			}
		}

		entityCache.putResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
			SubjectImpl.class, subject.getPrimaryKey(), subject, false);

		clearUniqueFindersCache(subjectModelImpl);
		cacheUniqueFindersCache(subjectModelImpl, isNew);

		subject.resetOriginalValues();

		return subject;
	}

	protected Subject toUnwrappedModel(Subject subject) {
		if (subject instanceof SubjectImpl) {
			return subject;
		}

		SubjectImpl subjectImpl = new SubjectImpl();

		subjectImpl.setNew(subject.isNew());
		subjectImpl.setPrimaryKey(subject.getPrimaryKey());

		subjectImpl.setSubjectId(subject.getSubjectId());
		subjectImpl.setGroupId(subject.getGroupId());
		subjectImpl.setCompanyId(subject.getCompanyId());
		subjectImpl.setUserId(subject.getUserId());
		subjectImpl.setUserName(subject.getUserName());
		subjectImpl.setCreateDate(subject.getCreateDate());
		subjectImpl.setModifiedDate(subject.getModifiedDate());
		subjectImpl.setSubjectCode(subject.getSubjectCode());
		subjectImpl.setSubjectName(subject.getSubjectName());
		subjectImpl.setCredit(subject.getCredit());
		subjectImpl.setCurriculumId(subject.getCurriculumId());

		return subjectImpl;
	}

	/**
	 * Returns the subject with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the subject
	 * @return the subject
	 * @throws NoSuchSubjectException if a subject with the primary key could not be found
	 */
	@Override
	public Subject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubjectException {
		Subject subject = fetchByPrimaryKey(primaryKey);

		if (subject == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return subject;
	}

	/**
	 * Returns the subject with the primary key or throws a {@link NoSuchSubjectException} if it could not be found.
	 *
	 * @param subjectId the primary key of the subject
	 * @return the subject
	 * @throws NoSuchSubjectException if a subject with the primary key could not be found
	 */
	@Override
	public Subject findByPrimaryKey(long subjectId)
		throws NoSuchSubjectException {
		return findByPrimaryKey((Serializable)subjectId);
	}

	/**
	 * Returns the subject with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the subject
	 * @return the subject, or <code>null</code> if a subject with the primary key could not be found
	 */
	@Override
	public Subject fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
				SubjectImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Subject subject = (Subject)serializable;

		if (subject == null) {
			Session session = null;

			try {
				session = openSession();

				subject = (Subject)session.get(SubjectImpl.class, primaryKey);

				if (subject != null) {
					cacheResult(subject);
				}
				else {
					entityCache.putResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
						SubjectImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
					SubjectImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return subject;
	}

	/**
	 * Returns the subject with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subjectId the primary key of the subject
	 * @return the subject, or <code>null</code> if a subject with the primary key could not be found
	 */
	@Override
	public Subject fetchByPrimaryKey(long subjectId) {
		return fetchByPrimaryKey((Serializable)subjectId);
	}

	@Override
	public Map<Serializable, Subject> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Subject> map = new HashMap<Serializable, Subject>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Subject subject = fetchByPrimaryKey(primaryKey);

			if (subject != null) {
				map.put(primaryKey, subject);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
					SubjectImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Subject)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SUBJECT_WHERE_PKS_IN);

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

			for (Subject subject : (List<Subject>)q.list()) {
				map.put(subject.getPrimaryKeyObj(), subject);

				cacheResult(subject);

				uncachedPrimaryKeys.remove(subject.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SubjectModelImpl.ENTITY_CACHE_ENABLED,
					SubjectImpl.class, primaryKey, nullModel);
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
	 * Returns all the subjects.
	 *
	 * @return the subjects
	 */
	@Override
	public List<Subject> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @return the range of subjects
	 */
	@Override
	public List<Subject> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of subjects
	 */
	@Override
	public List<Subject> findAll(int start, int end,
		OrderByComparator<Subject> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the subjects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of subjects
	 * @param end the upper bound of the range of subjects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of subjects
	 */
	@Override
	public List<Subject> findAll(int start, int end,
		OrderByComparator<Subject> orderByComparator, boolean retrieveFromCache) {
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

		List<Subject> list = null;

		if (retrieveFromCache) {
			list = (List<Subject>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SUBJECT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUBJECT;

				if (pagination) {
					sql = sql.concat(SubjectModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Subject>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Subject>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the subjects from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Subject subject : findAll()) {
			remove(subject);
		}
	}

	/**
	 * Returns the number of subjects.
	 *
	 * @return the number of subjects
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SUBJECT);

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
		return SubjectModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the subject persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SubjectImpl.class.getName());
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
	private static final String _SQL_SELECT_SUBJECT = "SELECT subject FROM Subject subject";
	private static final String _SQL_SELECT_SUBJECT_WHERE_PKS_IN = "SELECT subject FROM Subject subject WHERE subjectId IN (";
	private static final String _SQL_SELECT_SUBJECT_WHERE = "SELECT subject FROM Subject subject WHERE ";
	private static final String _SQL_COUNT_SUBJECT = "SELECT COUNT(subject) FROM Subject subject";
	private static final String _SQL_COUNT_SUBJECT_WHERE = "SELECT COUNT(subject) FROM Subject subject WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "subject.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Subject exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Subject exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SubjectPersistenceImpl.class);
}