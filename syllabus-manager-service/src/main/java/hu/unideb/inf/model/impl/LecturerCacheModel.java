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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import hu.unideb.inf.model.Lecturer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Lecturer in entity cache.
 *
 * @author Adam Kiss
 * @see Lecturer
 * @generated
 */
@ProviderType
public class LecturerCacheModel implements CacheModel<Lecturer>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LecturerCacheModel)) {
			return false;
		}

		LecturerCacheModel lecturerCacheModel = (LecturerCacheModel)obj;

		if (lecturerId == lecturerCacheModel.lecturerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, lecturerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{lecturerId=");
		sb.append(lecturerId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", lecturerName=");
		sb.append(lecturerName);
		sb.append(", lecturerUserId=");
		sb.append(lecturerUserId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Lecturer toEntityModel() {
		LecturerImpl lecturerImpl = new LecturerImpl();

		lecturerImpl.setLecturerId(lecturerId);
		lecturerImpl.setGroupId(groupId);
		lecturerImpl.setCompanyId(companyId);
		lecturerImpl.setUserId(userId);

		if (userName == null) {
			lecturerImpl.setUserName(StringPool.BLANK);
		}
		else {
			lecturerImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			lecturerImpl.setCreateDate(null);
		}
		else {
			lecturerImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			lecturerImpl.setModifiedDate(null);
		}
		else {
			lecturerImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (lecturerName == null) {
			lecturerImpl.setLecturerName(StringPool.BLANK);
		}
		else {
			lecturerImpl.setLecturerName(lecturerName);
		}

		lecturerImpl.setLecturerUserId(lecturerUserId);

		lecturerImpl.resetOriginalValues();

		return lecturerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		lecturerId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		lecturerName = objectInput.readUTF();

		lecturerUserId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(lecturerId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (lecturerName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lecturerName);
		}

		objectOutput.writeLong(lecturerUserId);
	}

	public long lecturerId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String lecturerName;
	public long lecturerUserId;
}