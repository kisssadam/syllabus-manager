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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import aQute.bnd.annotation.ProviderType;
import hu.unideb.inf.model.Subject;
import hu.unideb.inf.service.base.SubjectServiceBaseImpl;

/**
 * The implementation of the subject remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.unideb.inf.service.SubjectService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Adam Kiss
 * @see SubjectServiceBaseImpl
 * @see hu.unideb.inf.service.SubjectServiceUtil
 */
@ProviderType
public class SubjectServiceImpl extends SubjectServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link hu.unideb.inf.service.SubjectServiceUtil} to access the subject remote service.
	 */
	
	public List<Subject> getSubjectsByCurriculumId(long curriculumId) throws SystemException {
		return subjectPersistence.findByCurriculum(curriculumId);
	}
	
}