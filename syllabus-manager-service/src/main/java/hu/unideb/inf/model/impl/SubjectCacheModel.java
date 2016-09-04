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

import hu.unideb.inf.model.Subject;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Subject in entity cache.
 *
 * @author Adam Kiss
 * @see Subject
 * @generated
 */
@ProviderType
public class SubjectCacheModel implements CacheModel<Subject>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubjectCacheModel)) {
			return false;
		}

		SubjectCacheModel subjectCacheModel = (SubjectCacheModel)obj;

		if (subjectId == subjectCacheModel.subjectId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, subjectId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{subjectId=");
		sb.append(subjectId);
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
		sb.append(", subjectCode=");
		sb.append(subjectCode);
		sb.append(", subjectName=");
		sb.append(subjectName);
		sb.append(", credit=");
		sb.append(credit);
		sb.append(", curriculumId=");
		sb.append(curriculumId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Subject toEntityModel() {
		SubjectImpl subjectImpl = new SubjectImpl();

		subjectImpl.setSubjectId(subjectId);
		subjectImpl.setGroupId(groupId);
		subjectImpl.setCompanyId(companyId);
		subjectImpl.setUserId(userId);

		if (userName == null) {
			subjectImpl.setUserName(StringPool.BLANK);
		}
		else {
			subjectImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			subjectImpl.setCreateDate(null);
		}
		else {
			subjectImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			subjectImpl.setModifiedDate(null);
		}
		else {
			subjectImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (subjectCode == null) {
			subjectImpl.setSubjectCode(StringPool.BLANK);
		}
		else {
			subjectImpl.setSubjectCode(subjectCode);
		}

		if (subjectName == null) {
			subjectImpl.setSubjectName(StringPool.BLANK);
		}
		else {
			subjectImpl.setSubjectName(subjectName);
		}

		subjectImpl.setCredit(credit);
		subjectImpl.setCurriculumId(curriculumId);

		subjectImpl.resetOriginalValues();

		return subjectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		subjectId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		subjectCode = objectInput.readUTF();
		subjectName = objectInput.readUTF();

		credit = objectInput.readInt();

		curriculumId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(subjectId);

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

		if (subjectCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subjectCode);
		}

		if (subjectName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subjectName);
		}

		objectOutput.writeInt(credit);

		objectOutput.writeLong(curriculumId);
	}

	public long subjectId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String subjectCode;
	public String subjectName;
	public int credit;
	public long curriculumId;
}