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

import hu.unideb.inf.model.CourseType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CourseType in entity cache.
 *
 * @author Adam Kiss
 * @see CourseType
 * @generated
 */
public class CourseTypeCacheModel implements CacheModel<CourseType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{courseTypeId=");
		sb.append(courseTypeId);
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
		sb.append(", typeName=");
		sb.append(typeName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CourseType toEntityModel() {
		CourseTypeImpl courseTypeImpl = new CourseTypeImpl();

		courseTypeImpl.setCourseTypeId(courseTypeId);
		courseTypeImpl.setGroupId(groupId);
		courseTypeImpl.setCompanyId(companyId);
		courseTypeImpl.setUserId(userId);

		if (userName == null) {
			courseTypeImpl.setUserName(StringPool.BLANK);
		}
		else {
			courseTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			courseTypeImpl.setCreateDate(null);
		}
		else {
			courseTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			courseTypeImpl.setModifiedDate(null);
		}
		else {
			courseTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (typeName == null) {
			courseTypeImpl.setTypeName(StringPool.BLANK);
		}
		else {
			courseTypeImpl.setTypeName(typeName);
		}

		courseTypeImpl.resetOriginalValues();

		return courseTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		courseTypeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		typeName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(courseTypeId);
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

		if (typeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typeName);
		}
	}

	public long courseTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String typeName;
}