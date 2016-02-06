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

package hu.unideb.inf.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Semester service. Represents a row in the &quot;unideb_syllabus_manager_Semester&quot; database table, with each column mapped to a property of this class.
 *
 * @author Adam Kiss
 * @see SemesterModel
 * @see hu.unideb.inf.model.impl.SemesterImpl
 * @see hu.unideb.inf.model.impl.SemesterModelImpl
 * @generated
 */
public interface Semester extends SemesterModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link hu.unideb.inf.model.impl.SemesterImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public int getNextBeginYear();

	public int getNextEndYear();

	public int getNextDivision();
}