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

import hu.unideb.inf.model.Semester;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Semester in entity cache.
 *
 * @author Adam Kiss
 * @see Semester
 * @generated
 */
@ProviderType
public class SemesterCacheModel implements CacheModel<Semester>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SemesterCacheModel)) {
			return false;
		}

		SemesterCacheModel semesterCacheModel = (SemesterCacheModel)obj;

		if (semesterId == semesterCacheModel.semesterId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, semesterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{semesterId=");
		sb.append(semesterId);
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
		sb.append(", beginYear=");
		sb.append(beginYear);
		sb.append(", endYear=");
		sb.append(endYear);
		sb.append(", division=");
		sb.append(division);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Semester toEntityModel() {
		SemesterImpl semesterImpl = new SemesterImpl();

		semesterImpl.setSemesterId(semesterId);
		semesterImpl.setGroupId(groupId);
		semesterImpl.setCompanyId(companyId);
		semesterImpl.setUserId(userId);

		if (userName == null) {
			semesterImpl.setUserName(StringPool.BLANK);
		}
		else {
			semesterImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			semesterImpl.setCreateDate(null);
		}
		else {
			semesterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			semesterImpl.setModifiedDate(null);
		}
		else {
			semesterImpl.setModifiedDate(new Date(modifiedDate));
		}

		semesterImpl.setBeginYear(beginYear);
		semesterImpl.setEndYear(endYear);
		semesterImpl.setDivision(division);

		semesterImpl.resetOriginalValues();

		return semesterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		semesterId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		beginYear = objectInput.readInt();

		endYear = objectInput.readInt();

		division = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(semesterId);

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

		objectOutput.writeInt(beginYear);

		objectOutput.writeInt(endYear);

		objectOutput.writeInt(division);
	}

	public long semesterId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int beginYear;
	public int endYear;
	public int division;
}