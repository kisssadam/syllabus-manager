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

package hu.unideb.inf.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import hu.unideb.inf.DuplicateTimetableCourseException;
import hu.unideb.inf.NoSuchTimetableCourseException;
import hu.unideb.inf.TimetableCourseCodeException;
import hu.unideb.inf.TimetableCourseLecturerException;
import hu.unideb.inf.TimetableCourseLimitException;
import hu.unideb.inf.TimetableCourseRecommendedTermException;
import hu.unideb.inf.TimetableCourseSubjectTypeException;
import hu.unideb.inf.model.Lecturer;
import hu.unideb.inf.model.TimetableCourse;
import hu.unideb.inf.service.LecturerLocalServiceUtil;
import hu.unideb.inf.service.TimetableCourseLocalServiceUtil;
import hu.unideb.inf.service.base.TimetableCourseLocalServiceBaseImpl;

/**
 * The implementation of the timetable course local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the {@link hu.unideb.inf.service.TimetableCourseLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Adam Kiss
 * @see hu.unideb.inf.service.base.TimetableCourseLocalServiceBaseImpl
 * @see hu.unideb.inf.service.TimetableCourseLocalServiceUtil
 */
public class TimetableCourseLocalServiceImpl extends TimetableCourseLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link hu.unideb.inf.service.TimetableCourseLocalServiceUtil}
	 * to access the timetable course local service.
	 */

	public List<TimetableCourse> getTimetableCourses() throws SystemException {
		return timetableCoursePersistence.findAll();
	}

	public List<TimetableCourse> getTimetableCoursesBySemesterId(long semesterId) throws SystemException {
		return timetableCoursePersistence.findBySemesterId(semesterId);
	}

	public List<TimetableCourse> getTimetableCoursesBySemesterId(long semesterId, int start, int end)
			throws SystemException {
		return timetableCoursePersistence.findBySemesterId(semesterId, start, end);
	}

	public int getTimetableCoursesCountBySemesterId(long semesterId) throws SystemException {
		return timetableCoursePersistence.countBySemesterId(semesterId);
	}

	public TimetableCourse findTimetableCourseByTimetableCourseCode(String timetableCourseCode)
			throws SystemException, NoSuchTimetableCourseException {
		return timetableCoursePersistence.findByTimetableCourseCode(timetableCourseCode);
	}

	public TimetableCourse fetchTimetableCourseByTimetableCourseCode(String timetableCourseCode)
			throws SystemException {
		return timetableCoursePersistence.fetchByTimetableCourseCode(timetableCourseCode);
	}

	public List<TimetableCourse> getTimetableCoursesByC_S(long courseId, long semesterId)
			throws NoSuchTimetableCourseException, SystemException {
		return timetableCoursePersistence.findByC_S(courseId, semesterId);
	}

	public List<TimetableCourse> getTimetableCoursesByCourseId(long courseId) throws SystemException {
		return timetableCoursePersistence.findByCourseId(courseId);
	}

	public List<TimetableCourse> getTimetableCoursesByCourseId(long courseId, int start, int end)
			throws SystemException {
		return timetableCoursePersistence.findByCourseId(courseId, start, end);
	}

	public int getTimetableCourseCountByCourseId(long courseId) throws SystemException {
		return timetableCoursePersistence.countByCourseId(courseId);
	}

	public List<Lecturer> getLecutersByTimetableCourseId(long timetableCourseId) throws SystemException {
		return timetableCoursePersistence.getLecturers(timetableCourseId);
	}

	public TimetableCourse addTimetableCourse(long courseId, long semesterId, String timetableCourseCode,
			String subjectType, int recommendedTerm, int limit, long[] lecturerIds, String classScheduleInfo,
			String description, ServiceContext serviceContext) throws PortalException, SystemException {
		Date now = new Date();

		long timetableCourseId = counterLocalService.increment();
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		long userId = serviceContext.getUserId();
		User user = userPersistence.findByPrimaryKey(userId);
		String userName = user.getFullName();

		validate(courseId, semesterId, timetableCourseCode, subjectType, recommendedTerm, limit, lecturerIds);

		TimetableCourse timetableCourse = timetableCoursePersistence.create(timetableCourseId);

		timetableCourse.setGroupId(groupId);
		timetableCourse.setCompanyId(companyId);
		timetableCourse.setUserId(userId);
		timetableCourse.setUserName(userName);
		timetableCourse.setCreateDate(serviceContext.getCreateDate(now));
		timetableCourse.setModifiedDate(serviceContext.getModifiedDate(now));
		timetableCourse.setCourseId(courseId);
		timetableCourse.setSemesterId(semesterId);
		timetableCourse.setTimetableCourseCode(timetableCourseCode);
		timetableCourse.setSubjectType(subjectType);
		timetableCourse.setRecommendedTerm(recommendedTerm);
		timetableCourse.setLimit(limit);
		timetableCourse.setClassScheduleInfo(classScheduleInfo);
		timetableCourse.setDescription(description);

		timetableCoursePersistence.update(timetableCourse);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, TimetableCourse.class.getName(),
				timetableCourseId, false, true, true);

		List<Lecturer> lecturers = LecturerLocalServiceUtil.getLecturersByIds(lecturerIds);

		timetableCoursePersistence.setLecturers(timetableCourseId, lecturers);

		return timetableCourse;
	}

	public TimetableCourse updateTimetableCourse(long userId, long timetableCourseId, long courseId, long semesterId,
			String timetableCourseCode, String subjectType, int recommendedTerm, int limit, long[] lecturerIds,
			String classScheduleInfo, String description, ServiceContext serviceContext)
					throws PortalException, SystemException {
		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(courseId, semesterId, timetableCourseCode, subjectType, recommendedTerm, limit, lecturerIds);

		TimetableCourse timetableCourse = TimetableCourseLocalServiceUtil.getTimetableCourse(timetableCourseId);

		timetableCourse.setUserId(userId);
		timetableCourse.setUserName(user.getFullName());
		timetableCourse.setModifiedDate(serviceContext.getModifiedDate(now));
		timetableCourse.setCourseId(courseId);
		timetableCourse.setSemesterId(semesterId);
		timetableCourse.setTimetableCourseCode(timetableCourseCode);
		timetableCourse.setSubjectType(subjectType);
		timetableCourse.setRecommendedTerm(recommendedTerm);
		timetableCourse.setLimit(limit);
		timetableCourse.getClassScheduleInfo();
		timetableCourse.setDescription(description);

		timetableCoursePersistence.update(timetableCourse);

		List<Lecturer> lecturers = LecturerLocalServiceUtil.getLecturersByIds(lecturerIds);

		timetableCoursePersistence.setLecturers(timetableCourseId, lecturers);

		resourceLocalService.updateResources(user.getCompanyId(), groupId, TimetableCourse.class.getName(),
				timetableCourseId, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());

		return timetableCourse;
	}

	public TimetableCourse deleteTimetableCourse(long timetableCourseId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		timetableCoursePersistence.clearLecturers(timetableCourseId);

		TimetableCourse timetableCourse = TimetableCourseLocalServiceUtil.getTimetableCourse(timetableCourseId);

		resourceLocalService.deleteResource(timetableCourse.getCompanyId(), timetableCourse.getClass().getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, timetableCourseId);

		return deleteTimetableCourse(timetableCourse);
	}

	private void validate(long courseId, long semesterId, String timetableCourseCode, String subjectType,
			int recommendedTerm, int limit, long[] lecturerIds) throws PortalException, SystemException {
		if (Validator.isNull(timetableCourseCode)) {
			throw new TimetableCourseCodeException();
		}

		if (Validator.isNull(subjectType)) {
			throw new TimetableCourseSubjectTypeException();
		}

		if (recommendedTerm < 0) {
			throw new TimetableCourseRecommendedTermException();
		}

		if (limit < 0) {
			throw new TimetableCourseLimitException();
		}

		if (ArrayUtil.isEmpty(lecturerIds)) {
			throw new TimetableCourseLecturerException();
		}

		TimetableCourse timetableCourse = TimetableCourseLocalServiceUtil
				.fetchTimetableCourseByTimetableCourseCode(timetableCourseCode);
		if (Validator.isNotNull(timetableCourse)) {
			if (!Validator.equals(timetableCourse.getCourseId(), courseId)
					&& !Validator.equals(timetableCourse.getSemesterId(), semesterId)
					&& !Validator.equals(timetableCourse.getTimetableCourseCode(), timetableCourseCode)) {
				throw new DuplicateTimetableCourseException();
			}
		}
	}

}