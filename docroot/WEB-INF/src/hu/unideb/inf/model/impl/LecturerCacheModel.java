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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import hu.unideb.inf.model.Lecturer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Lecturer in entity cache.
 *
 * @author Adam Kiss
 * @see Lecturer
 * @generated
 */
public class LecturerCacheModel implements CacheModel<Lecturer>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{lecturerId=");
		sb.append(lecturerId);
		sb.append(", lecturerName=");
		sb.append(lecturerName);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Lecturer toEntityModel() {
		LecturerImpl lecturerImpl = new LecturerImpl();

		lecturerImpl.setLecturerId(lecturerId);

		if (lecturerName == null) {
			lecturerImpl.setLecturerName(StringPool.BLANK);
		}
		else {
			lecturerImpl.setLecturerName(lecturerName);
		}

		lecturerImpl.setUserId(userId);

		lecturerImpl.resetOriginalValues();

		return lecturerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		lecturerId = objectInput.readLong();
		lecturerName = objectInput.readUTF();
		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(lecturerId);

		if (lecturerName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lecturerName);
		}

		objectOutput.writeLong(userId);
	}

	public long lecturerId;
	public String lecturerName;
	public long userId;
}