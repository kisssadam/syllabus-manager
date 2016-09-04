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
 * The extended model interface for the Curriculum service. Represents a row in the &quot;unideb_syllabus_manager_Curriculum&quot; database table, with each column mapped to a property of this class.
 *
 * @author Adam Kiss
 * @see CurriculumModel
 * @see hu.unideb.inf.model.impl.CurriculumImpl
 * @see hu.unideb.inf.model.impl.CurriculumModelImpl
 * @generated
 */
@ImplementationClassName("hu.unideb.inf.model.impl.CurriculumImpl")
@ProviderType
public interface Curriculum extends CurriculumModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link hu.unideb.inf.model.impl.CurriculumImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Curriculum, Long> CURRICULUM_ID_ACCESSOR = new Accessor<Curriculum, Long>() {
			@Override
			public Long get(Curriculum curriculum) {
				return curriculum.getCurriculumId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Curriculum> getTypeClass() {
				return Curriculum.class;
			}
		};
}