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
import hu.unideb.inf.exception.NoSuchSyllabusException;
import hu.unideb.inf.model.Syllabus;
import hu.unideb.inf.service.base.SyllabusLocalServiceBaseImpl;

/**
 * The implementation of the syllabus local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.unideb.inf.service.SyllabusLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Adam Kiss
 * @see SyllabusLocalServiceBaseImpl
 * @see hu.unideb.inf.service.SyllabusLocalServiceUtil
 */
@ProviderType
public class SyllabusLocalServiceImpl extends SyllabusLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link hu.unideb.inf.service.SyllabusLocalServiceUtil} to access the syllabus local service.
	 */
	public List<Syllabus> getSyllabuses() throws SystemException {
		return syllabusPersistence.findAll();
	}
	
	public Syllabus getSyllabusByT_S(long timetableCourseId, long semesterId) throws NoSuchSyllabusException {
		return syllabusPersistence.findByT_S(timetableCourseId, semesterId);
	}
	
	public Syllabus fetchSyllabusByT_S(long timetableCourseId, long semesterId) {
		return syllabusPersistence.fetchByT_S(timetableCourseId, semesterId);
	}
	
	
}