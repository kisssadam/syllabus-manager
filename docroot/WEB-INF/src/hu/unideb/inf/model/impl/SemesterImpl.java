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

/**
 * The extended model implementation for the Semester service. Represents a row in the
 * &quot;unideb_syllabus_manager_Semester&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the {@link hu.unideb.inf.model.Semester} interface.
 * </p>
 *
 * @author Adam Kiss
 */
public class SemesterImpl extends SemesterBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a semester model instance should use the {@link
	 * hu.unideb.inf.model.Semester} interface instead.
	 */

	private static final String SEPARATOR = " / ";

	public SemesterImpl() {
	}

	public int getNextBeginYear() {
		return getNextDivision() == 2 ? getBeginYear() : getEndYear();
	}

	public int getNextEndYear() {
		return getNextBeginYear() + 1;
	}

	public int getNextDivision() {
		return 3 - getDivision();
	}

	@Override
	public String toString() {
		return getBeginYear() + SEPARATOR + getEndYear() + SEPARATOR + getDivision();
	}

}