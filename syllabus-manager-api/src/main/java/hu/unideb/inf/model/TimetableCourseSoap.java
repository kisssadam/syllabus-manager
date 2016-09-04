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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link hu.unideb.inf.service.http.TimetableCourseServiceSoap}.
 *
 * @author Adam Kiss
 * @see hu.unideb.inf.service.http.TimetableCourseServiceSoap
 * @generated
 */
@ProviderType
public class TimetableCourseSoap implements Serializable {
	public static TimetableCourseSoap toSoapModel(TimetableCourse model) {
		TimetableCourseSoap soapModel = new TimetableCourseSoap();

		soapModel.setTimetableCourseId(model.getTimetableCourseId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCourseId(model.getCourseId());
		soapModel.setSemesterId(model.getSemesterId());
		soapModel.setTimetableCourseCode(model.getTimetableCourseCode());
		soapModel.setSubjectType(model.getSubjectType());
		soapModel.setRecommendedTerm(model.getRecommendedTerm());
		soapModel.setLimit(model.getLimit());
		soapModel.setClassScheduleInfo(model.getClassScheduleInfo());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static TimetableCourseSoap[] toSoapModels(TimetableCourse[] models) {
		TimetableCourseSoap[] soapModels = new TimetableCourseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TimetableCourseSoap[][] toSoapModels(
		TimetableCourse[][] models) {
		TimetableCourseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TimetableCourseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TimetableCourseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TimetableCourseSoap[] toSoapModels(
		List<TimetableCourse> models) {
		List<TimetableCourseSoap> soapModels = new ArrayList<TimetableCourseSoap>(models.size());

		for (TimetableCourse model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TimetableCourseSoap[soapModels.size()]);
	}

	public TimetableCourseSoap() {
	}

	public long getPrimaryKey() {
		return _timetableCourseId;
	}

	public void setPrimaryKey(long pk) {
		setTimetableCourseId(pk);
	}

	public long getTimetableCourseId() {
		return _timetableCourseId;
	}

	public void setTimetableCourseId(long timetableCourseId) {
		_timetableCourseId = timetableCourseId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCourseId() {
		return _courseId;
	}

	public void setCourseId(long courseId) {
		_courseId = courseId;
	}

	public long getSemesterId() {
		return _semesterId;
	}

	public void setSemesterId(long semesterId) {
		_semesterId = semesterId;
	}

	public String getTimetableCourseCode() {
		return _timetableCourseCode;
	}

	public void setTimetableCourseCode(String timetableCourseCode) {
		_timetableCourseCode = timetableCourseCode;
	}

	public String getSubjectType() {
		return _subjectType;
	}

	public void setSubjectType(String subjectType) {
		_subjectType = subjectType;
	}

	public int getRecommendedTerm() {
		return _recommendedTerm;
	}

	public void setRecommendedTerm(int recommendedTerm) {
		_recommendedTerm = recommendedTerm;
	}

	public int getLimit() {
		return _limit;
	}

	public void setLimit(int limit) {
		_limit = limit;
	}

	public String getClassScheduleInfo() {
		return _classScheduleInfo;
	}

	public void setClassScheduleInfo(String classScheduleInfo) {
		_classScheduleInfo = classScheduleInfo;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _timetableCourseId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _courseId;
	private long _semesterId;
	private String _timetableCourseCode;
	private String _subjectType;
	private int _recommendedTerm;
	private int _limit;
	private String _classScheduleInfo;
	private String _description;
}