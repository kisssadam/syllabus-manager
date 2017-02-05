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

package hu.unideb.inf.model.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

import aQute.bnd.annotation.ProviderType;
import hu.unideb.inf.model.CourseType;
import hu.unideb.inf.service.CourseTypeLocalServiceUtil;

/**
 * The extended model implementation for the Course service. Represents a row in the &quot;unideb_syllabus_manager_Course&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.unideb.inf.model.Course} interface.
 * </p>
 *
 * @author Adam Kiss
 */
@ProviderType
public class CourseImpl extends CourseBaseImpl {
	
	private static final long serialVersionUID = 1L;

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a course model instance should use the {@link hu.unideb.inf.model.Course} interface instead.
	 */
	public CourseImpl() {
	}
	
	@Override
	public String toString() {
		CourseType courseType = null;

		try {
			courseType = CourseTypeLocalServiceUtil.fetchCourseType(getCourseTypeId());
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return (Validator.isNull(courseType) ? "course type not found" : courseType.getTypeName()) + ": "
				+ getHoursPerSemester() + " hours per semester, " + getHoursPerWeek() + " hours per week";
	}
}