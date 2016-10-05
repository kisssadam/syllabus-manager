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

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import aQute.bnd.annotation.ProviderType;
import hu.unideb.inf.exception.DuplicateSemesterException;
import hu.unideb.inf.exception.NoSuchSemesterException;
import hu.unideb.inf.exception.SemesterDivisionException;
import hu.unideb.inf.exception.SemesterYearDifferenceException;
import hu.unideb.inf.exception.SemesterYearOverlapException;
import hu.unideb.inf.exception.SemesterYearsAreEqualException;
import hu.unideb.inf.model.Semester;
import hu.unideb.inf.model.TimetableCourse;
import hu.unideb.inf.model.impl.SemesterImpl;
import hu.unideb.inf.service.SemesterLocalServiceUtil;
import hu.unideb.inf.service.TimetableCourseLocalServiceUtil;
import hu.unideb.inf.service.base.SemesterLocalServiceBaseImpl;
import hu.unideb.inf.service.util.SemesterHelper;

/**
 * The implementation of the semester local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.unideb.inf.service.SemesterLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Adam Kiss
 * @see SemesterLocalServiceBaseImpl
 * @see hu.unideb.inf.service.SemesterLocalServiceUtil
 */
@ProviderType
public class SemesterLocalServiceImpl extends SemesterLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link hu.unideb.inf.service.SemesterLocalServiceUtil} to access the semester local service.
	 */
	

	public List<Semester> getSemesters() throws SystemException {
		return semesterPersistence.findAll();
	}

	public Semester getSemesterByB_E_D(int beginYear, int endYear, int division)
			throws NoSuchSemesterException, SystemException {
		return semesterPersistence.findByB_E_D(beginYear, endYear, division);
	}

	public Semester getLatestSemester() throws SystemException, NoSuchSemesterException {
		DynamicQuery latestSemesterQuery = DynamicQueryFactoryUtil.forClass(SemesterImpl.class)
				.addOrder(PropertyFactoryUtil.forName("beginYear").desc())
				.addOrder(PropertyFactoryUtil.forName("endYear").desc())
				.addOrder(PropertyFactoryUtil.forName("division").desc());

		List<Semester> queriedSemesters = dynamicQuery(latestSemesterQuery, 0, 1);

		if (queriedSemesters.isEmpty()) {
			throw new NoSuchSemesterException();
		} else {
			return queriedSemesters.get(0);
		}
	}

	public Semester addNextSemester(ServiceContext serviceContext) throws SystemException, PortalException {
		Semester latestSemester;
		try {
			latestSemester = getLatestSemester();

			int nextBeginYear = latestSemester.getNextBeginYear();
			int nextEndYear = latestSemester.getNextEndYear();
			int nextDivision = latestSemester.getNextDivision();

			latestSemester = addSemester(nextBeginYear, nextEndYear, nextDivision, serviceContext);
		} catch (NoSuchSemesterException e) {
			latestSemester = addCurrentSemester(serviceContext);
		}

		return latestSemester;
	}

	public Semester addCurrentSemester(ServiceContext serviceContext) throws SystemException, PortalException {
		int beginYear = SemesterHelper.currentYear();
		int endYear = beginYear + 1;
		int division = SemesterHelper.nextDivision();

		return addSemester(beginYear, endYear, division, serviceContext);
	}

	public Semester addSemester(int beginYear, int endYear, int division, ServiceContext serviceContext)
			throws SystemException, PortalException {
		Date now = new Date();

		long semesterId = counterLocalService.increment();
		validate(semesterId, beginYear, endYear, division);

		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();

		long userId = serviceContext.getUserId();
		User user = userPersistence.findByPrimaryKey(userId);
		String userName = user.getFullName();

		Semester semester = semesterPersistence.create(semesterId);

		semester.setGroupId(groupId);
		semester.setCompanyId(companyId);
		semester.setUserId(userId);
		semester.setUserName(userName);
		semester.setCreateDate(serviceContext.getCreateDate(now));
		semester.setModifiedDate(serviceContext.getModifiedDate(now));
		semester.setBeginYear(beginYear);
		semester.setEndYear(endYear);
		semester.setDivision(division);

		semesterPersistence.update(semester);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, Semester.class.getName(), semesterId,
				false, true, true);

		return semester;
	}

	public Semester deleteSemester(long semesterId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		Semester semester = SemesterLocalServiceUtil.getSemester(semesterId);

		List<TimetableCourse> timetableCourses = TimetableCourseLocalServiceUtil
				.getTimetableCoursesBySemesterId(semesterId);
		for (TimetableCourse timetableCourse : timetableCourses) {
			TimetableCourseLocalServiceUtil.deleteTimetableCourse(timetableCourse.getTimetableCourseId(),
					serviceContext);
		}

		resourceLocalService.deleteResource(semester.getCompanyId(), Semester.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, semesterId);

		return deleteSemester(semesterId);
	}

	public Semester updateSemester(long userId, long semesterId, int beginYear, int endYear, int division,
			ServiceContext serviceContext) throws PortalException, SystemException {
		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(semesterId, beginYear, endYear, division);

		Semester semester = getSemester(semesterId);

		semester.setUserId(userId);
		semester.setUserName(user.getFullName());
		semester.setBeginYear(beginYear);
		semester.setEndYear(endYear);
		semester.setDivision(division);
		semester.setModifiedDate(now);

		semesterPersistence.update(semester);

		resourceLocalService.updateResources(user.getCompanyId(), groupId, Semester.class.getName(), semesterId,
				serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());

		return semester;
	}

	protected void validate(long semesterId, int beginYear, int endYear, int division)
			throws PortalException, SystemException {
		validateYears(beginYear, endYear);

		validateDivision(division);

		checkForExistingSemester(semesterId, beginYear, endYear, division);
	}

	private void validateYears(int beginYear, int endYear)
			throws SemesterYearsAreEqualException, SemesterYearOverlapException, SemesterYearDifferenceException {
		if (beginYear + 1 != endYear) {
			if (beginYear == endYear) {
				throw new SemesterYearsAreEqualException();
			}
			if (beginYear < endYear) {
				throw new SemesterYearOverlapException();
			}
			if (beginYear > endYear) {
				throw new SemesterYearDifferenceException();
			}
		}
	}

	private void validateDivision(int division) throws SemesterDivisionException {
		if (valuesAreUnique(division, 1, 2)) {
			throw new SemesterDivisionException();
		}
	}

	private boolean valuesAreUnique(int... values) {
		Arrays.sort(values);

		boolean result = true;

		for (int i = 0; i + 1 < values.length; i++) {
			if (values[i] == values[i + 1]) {
				result = false;
				break;
			}
		}

		return result;
	}

	private void checkForExistingSemester(long semesterId, int beginYear, int endYear, int division)
			throws SystemException, DuplicateSemesterException {
		Semester semester = semesterPersistence.fetchByB_E_D(beginYear, endYear, division);

		if (Validator.isNotNull(semester) && !Validator.equals(semester.getSemesterId(), semesterId)) {
			throw new DuplicateSemesterException();
		}
	}
	
}