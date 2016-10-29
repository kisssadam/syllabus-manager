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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Syllabus service. Represents a row in the &quot;syllabus_manager_Syllabus&quot; database table, with each column mapped to a property of this class.
 *
 * @author Adam Kiss
 * @see SyllabusModel
 * @see hu.unideb.inf.model.impl.SyllabusImpl
 * @see hu.unideb.inf.model.impl.SyllabusModelImpl
 * @generated
 */
@ImplementationClassName("hu.unideb.inf.model.impl.SyllabusImpl")
@ProviderType
public interface Syllabus extends SyllabusModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link hu.unideb.inf.model.impl.SyllabusImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Syllabus, String> UUID_ACCESSOR = new Accessor<Syllabus, String>() {
			@Override
			public String get(Syllabus syllabus) {
				return syllabus.getUuid();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Syllabus> getTypeClass() {
				return Syllabus.class;
			}
		};

	public static final Accessor<Syllabus, Long> SYLLABUS_ID_ACCESSOR = new Accessor<Syllabus, Long>() {
			@Override
			public Long get(Syllabus syllabus) {
				return syllabus.getSyllabusId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Syllabus> getTypeClass() {
				return Syllabus.class;
			}
		};
}