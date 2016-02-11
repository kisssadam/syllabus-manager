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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link hu.unideb.inf.service.http.LecturerServiceSoap}.
 *
 * @author Adam Kiss
 * @see hu.unideb.inf.service.http.LecturerServiceSoap
 * @generated
 */
public class LecturerSoap implements Serializable {
	public static LecturerSoap toSoapModel(Lecturer model) {
		LecturerSoap soapModel = new LecturerSoap();

		soapModel.setLecturerId(model.getLecturerId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLecturerName(model.getLecturerName());
		soapModel.setLecturerUserId(model.getLecturerUserId());

		return soapModel;
	}

	public static LecturerSoap[] toSoapModels(Lecturer[] models) {
		LecturerSoap[] soapModels = new LecturerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LecturerSoap[][] toSoapModels(Lecturer[][] models) {
		LecturerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LecturerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LecturerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LecturerSoap[] toSoapModels(List<Lecturer> models) {
		List<LecturerSoap> soapModels = new ArrayList<LecturerSoap>(models.size());

		for (Lecturer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LecturerSoap[soapModels.size()]);
	}

	public LecturerSoap() {
	}

	public long getPrimaryKey() {
		return _lecturerId;
	}

	public void setPrimaryKey(long pk) {
		setLecturerId(pk);
	}

	public long getLecturerId() {
		return _lecturerId;
	}

	public void setLecturerId(long lecturerId) {
		_lecturerId = lecturerId;
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

	public String getLecturerName() {
		return _lecturerName;
	}

	public void setLecturerName(String lecturerName) {
		_lecturerName = lecturerName;
	}

	public long getLecturerUserId() {
		return _lecturerUserId;
	}

	public void setLecturerUserId(long lecturerUserId) {
		_lecturerUserId = lecturerUserId;
	}

	private long _lecturerId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _lecturerName;
	private long _lecturerUserId;
}