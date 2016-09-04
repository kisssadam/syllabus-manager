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
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import aQute.bnd.annotation.ProviderType;
import hu.unideb.inf.exception.CurriculumCodeException;
import hu.unideb.inf.exception.CurriculumNameException;
import hu.unideb.inf.exception.DuplicateCurriculumException;
import hu.unideb.inf.exception.NoSuchCurriculumException;
import hu.unideb.inf.model.Curriculum;
import hu.unideb.inf.model.Subject;
import hu.unideb.inf.service.CurriculumLocalServiceUtil;
import hu.unideb.inf.service.SubjectLocalServiceUtil;
import hu.unideb.inf.service.base.CurriculumLocalServiceBaseImpl;

/**
 * The implementation of the curriculum local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.unideb.inf.service.CurriculumLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Adam Kiss
 * @see CurriculumLocalServiceBaseImpl
 * @see hu.unideb.inf.service.CurriculumLocalServiceUtil
 */
@ProviderType
public class CurriculumLocalServiceImpl extends CurriculumLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link hu.unideb.inf.service.CurriculumLocalServiceUtil} to access the curriculum local service.
	 */
	

	public List<Curriculum> getCurriculums() throws SystemException {
		return curriculumPersistence.findAll();
	}

	public Curriculum getCurriculumByCode(String curriculumCode) throws SystemException, NoSuchCurriculumException {
		return curriculumPersistence.findByCode(curriculumCode);
	}

	public Curriculum fetchCurriculumByCode(String curriculumCode) throws SystemException {
		return curriculumPersistence.fetchByCode(curriculumCode);
	}

	public Curriculum addCurriculum(String curriculumCode, String curriculumName, ServiceContext serviceContext)
			throws PortalException, SystemException {
		Date now = new Date();

		long curriculumId = counterLocalService.increment();
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		long userId = serviceContext.getUserId();
		User user = userPersistence.findByPrimaryKey(userId);
		String userName = user.getFullName();

		validate(curriculumId, curriculumCode, curriculumName);

		Curriculum curriculum = curriculumPersistence.create(curriculumId);

		curriculum.setGroupId(groupId);
		curriculum.setCompanyId(companyId);
		curriculum.setUserId(userId);
		curriculum.setUserName(userName);
		curriculum.setCreateDate(serviceContext.getCreateDate(now));
		curriculum.setModifiedDate(serviceContext.getModifiedDate(now));
		curriculum.setCurriculumCode(curriculumCode);
		curriculum.setCurriculumName(curriculumName);

		curriculumPersistence.update(curriculum);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, Curriculum.class.getName(),
				curriculumId, false, true, true);

		return curriculum;
	}

	public Curriculum deleteCurriculum(long curriculumId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		Curriculum curriculum = CurriculumLocalServiceUtil.getCurriculum(curriculumId);

		List<Subject> subjectsToDelete = SubjectLocalServiceUtil.getSubjectsByCurriculumId(curriculumId);
		for (Subject subject : subjectsToDelete) {
			SubjectLocalServiceUtil.deleteSubject(subject.getSubjectId(), serviceContext);
		}

		resourceLocalService.deleteResource(curriculum.getCompanyId(), curriculum.getClass().getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, curriculumId);

		return deleteCurriculum(curriculumId);
	}

	public Curriculum updateCurriculum(long userId, long curriculumId, String curriculumCode, String curriculumName,
			ServiceContext serviceContext) throws SystemException, PortalException {
		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(curriculumId, curriculumCode, curriculumName);

		Curriculum curriculum = getCurriculum(curriculumId);

		curriculum.setUserId(userId);
		curriculum.setUserName(user.getFullName());
		curriculum.setModifiedDate(serviceContext.getModifiedDate(now));
		curriculum.setCurriculumCode(curriculumCode);
		curriculum.setCurriculumName(curriculumName);

		curriculumPersistence.update(curriculum);

		resourceLocalService.updateResources(user.getCompanyId(), groupId, Curriculum.class.getName(), curriculumId,
				serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());

		return curriculum;
	}

	private void validate(long curriculumId, String curriculumCode, String curriculumName)
			throws PortalException, SystemException {
		if (Validator.isNull(curriculumCode)) {
			throw new CurriculumCodeException();
		}

		if (Validator.isNull(curriculumName)) {
			throw new CurriculumNameException();
		}

		Curriculum curriculum = CurriculumLocalServiceUtil.fetchCurriculumByCode(curriculumCode);
		if (Validator.isNotNull(curriculum)) {
			if (!Validator.equals(curriculum.getCurriculumId(), curriculumId)) {
				throw new DuplicateCurriculumException();
			}
		}
	}
	
}