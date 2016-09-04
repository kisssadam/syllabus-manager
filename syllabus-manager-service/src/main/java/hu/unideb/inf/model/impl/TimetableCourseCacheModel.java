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

import hu.unideb.inf.model.TimetableCourse;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TimetableCourse in entity cache.
 *
 * @author Adam Kiss
 * @see TimetableCourse
 * @generated
 */
@ProviderType
public class TimetableCourseCacheModel implements CacheModel<TimetableCourse>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TimetableCourseCacheModel)) {
			return false;
		}

		TimetableCourseCacheModel timetableCourseCacheModel = (TimetableCourseCacheModel)obj;

		if (timetableCourseId == timetableCourseCacheModel.timetableCourseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, timetableCourseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{timetableCourseId=");
		sb.append(timetableCourseId);
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
		sb.append(", courseId=");
		sb.append(courseId);
		sb.append(", semesterId=");
		sb.append(semesterId);
		sb.append(", timetableCourseCode=");
		sb.append(timetableCourseCode);
		sb.append(", subjectType=");
		sb.append(subjectType);
		sb.append(", recommendedTerm=");
		sb.append(recommendedTerm);
		sb.append(", limit=");
		sb.append(limit);
		sb.append(", classScheduleInfo=");
		sb.append(classScheduleInfo);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TimetableCourse toEntityModel() {
		TimetableCourseImpl timetableCourseImpl = new TimetableCourseImpl();

		timetableCourseImpl.setTimetableCourseId(timetableCourseId);
		timetableCourseImpl.setGroupId(groupId);
		timetableCourseImpl.setCompanyId(companyId);
		timetableCourseImpl.setUserId(userId);

		if (userName == null) {
			timetableCourseImpl.setUserName(StringPool.BLANK);
		}
		else {
			timetableCourseImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			timetableCourseImpl.setCreateDate(null);
		}
		else {
			timetableCourseImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			timetableCourseImpl.setModifiedDate(null);
		}
		else {
			timetableCourseImpl.setModifiedDate(new Date(modifiedDate));
		}

		timetableCourseImpl.setCourseId(courseId);
		timetableCourseImpl.setSemesterId(semesterId);

		if (timetableCourseCode == null) {
			timetableCourseImpl.setTimetableCourseCode(StringPool.BLANK);
		}
		else {
			timetableCourseImpl.setTimetableCourseCode(timetableCourseCode);
		}

		if (subjectType == null) {
			timetableCourseImpl.setSubjectType(StringPool.BLANK);
		}
		else {
			timetableCourseImpl.setSubjectType(subjectType);
		}

		timetableCourseImpl.setRecommendedTerm(recommendedTerm);
		timetableCourseImpl.setLimit(limit);

		if (classScheduleInfo == null) {
			timetableCourseImpl.setClassScheduleInfo(StringPool.BLANK);
		}
		else {
			timetableCourseImpl.setClassScheduleInfo(classScheduleInfo);
		}

		if (description == null) {
			timetableCourseImpl.setDescription(StringPool.BLANK);
		}
		else {
			timetableCourseImpl.setDescription(description);
		}

		timetableCourseImpl.resetOriginalValues();

		return timetableCourseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		timetableCourseId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		courseId = objectInput.readLong();

		semesterId = objectInput.readLong();
		timetableCourseCode = objectInput.readUTF();
		subjectType = objectInput.readUTF();

		recommendedTerm = objectInput.readInt();

		limit = objectInput.readInt();
		classScheduleInfo = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(timetableCourseId);

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

		objectOutput.writeLong(courseId);

		objectOutput.writeLong(semesterId);

		if (timetableCourseCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(timetableCourseCode);
		}

		if (subjectType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subjectType);
		}

		objectOutput.writeInt(recommendedTerm);

		objectOutput.writeInt(limit);

		if (classScheduleInfo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(classScheduleInfo);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long timetableCourseId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long courseId;
	public long semesterId;
	public String timetableCourseCode;
	public String subjectType;
	public int recommendedTerm;
	public int limit;
	public String classScheduleInfo;
	public String description;
}