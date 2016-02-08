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

import hu.unideb.inf.model.Course;
import hu.unideb.inf.service.CourseLocalServiceUtil;
import hu.unideb.inf.service.base.CourseServiceBaseImpl;

/**
 * The implementation of the course remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the {@link hu.unideb.inf.service.CourseService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Adam Kiss
 * @see hu.unideb.inf.service.base.CourseServiceBaseImpl
 * @see hu.unideb.inf.service.CourseServiceUtil
 */
public class CourseServiceImpl extends CourseServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link hu.unideb.inf.service.CourseServiceUtil} to access the
	 * course remote service.
	 */

	public List<Course> getCoursesBySubjectId(long subjectId) throws SystemException {
		return CourseLocalServiceUtil.getCoursesBySubjectId(subjectId);
	}
}