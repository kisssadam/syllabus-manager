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

import hu.unideb.inf.model.Curriculum;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Curriculum in entity cache.
 *
 * @author Adam Kiss
 * @see Curriculum
 * @generated
 */
public class CurriculumCacheModel implements CacheModel<Curriculum>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{curriculumId=");
		sb.append(curriculumId);
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
		sb.append(", curriculumCode=");
		sb.append(curriculumCode);
		sb.append(", curriculumName=");
		sb.append(curriculumName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Curriculum toEntityModel() {
		CurriculumImpl curriculumImpl = new CurriculumImpl();

		curriculumImpl.setCurriculumId(curriculumId);
		curriculumImpl.setGroupId(groupId);
		curriculumImpl.setCompanyId(companyId);
		curriculumImpl.setUserId(userId);

		if (userName == null) {
			curriculumImpl.setUserName(StringPool.BLANK);
		}
		else {
			curriculumImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			curriculumImpl.setCreateDate(null);
		}
		else {
			curriculumImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			curriculumImpl.setModifiedDate(null);
		}
		else {
			curriculumImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (curriculumCode == null) {
			curriculumImpl.setCurriculumCode(StringPool.BLANK);
		}
		else {
			curriculumImpl.setCurriculumCode(curriculumCode);
		}

		if (curriculumName == null) {
			curriculumImpl.setCurriculumName(StringPool.BLANK);
		}
		else {
			curriculumImpl.setCurriculumName(curriculumName);
		}

		curriculumImpl.resetOriginalValues();

		return curriculumImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		curriculumId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		curriculumCode = objectInput.readUTF();
		curriculumName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(curriculumId);
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

		if (curriculumCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(curriculumCode);
		}

		if (curriculumName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(curriculumName);
		}
	}

	public long curriculumId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String curriculumCode;
	public String curriculumName;
}