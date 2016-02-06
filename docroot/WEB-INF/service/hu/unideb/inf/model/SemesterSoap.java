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
 * This class is used by SOAP remote services, specifically {@link hu.unideb.inf.service.http.SemesterServiceSoap}.
 *
 * @author Adam Kiss
 * @see hu.unideb.inf.service.http.SemesterServiceSoap
 * @generated
 */
public class SemesterSoap implements Serializable {
	public static SemesterSoap toSoapModel(Semester model) {
		SemesterSoap soapModel = new SemesterSoap();

		soapModel.setSemesterId(model.getSemesterId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBeginYear(model.getBeginYear());
		soapModel.setEndYear(model.getEndYear());
		soapModel.setDivision(model.getDivision());

		return soapModel;
	}

	public static SemesterSoap[] toSoapModels(Semester[] models) {
		SemesterSoap[] soapModels = new SemesterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SemesterSoap[][] toSoapModels(Semester[][] models) {
		SemesterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SemesterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SemesterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SemesterSoap[] toSoapModels(List<Semester> models) {
		List<SemesterSoap> soapModels = new ArrayList<SemesterSoap>(models.size());

		for (Semester model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SemesterSoap[soapModels.size()]);
	}

	public SemesterSoap() {
	}

	public long getPrimaryKey() {
		return _semesterId;
	}

	public void setPrimaryKey(long pk) {
		setSemesterId(pk);
	}

	public long getSemesterId() {
		return _semesterId;
	}

	public void setSemesterId(long semesterId) {
		_semesterId = semesterId;
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

	public int getBeginYear() {
		return _beginYear;
	}

	public void setBeginYear(int beginYear) {
		_beginYear = beginYear;
	}

	public int getEndYear() {
		return _endYear;
	}

	public void setEndYear(int endYear) {
		_endYear = endYear;
	}

	public int getDivision() {
		return _division;
	}

	public void setDivision(int division) {
		_division = division;
	}

	private long _semesterId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _beginYear;
	private int _endYear;
	private int _division;
}