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
 * This class is used by SOAP remote services, specifically {@link hu.unideb.inf.service.http.CurriculumServiceSoap}.
 *
 * @author Adam Kiss
 * @see hu.unideb.inf.service.http.CurriculumServiceSoap
 * @generated
 */
@ProviderType
public class CurriculumSoap implements Serializable {
	public static CurriculumSoap toSoapModel(Curriculum model) {
		CurriculumSoap soapModel = new CurriculumSoap();

		soapModel.setCurriculumId(model.getCurriculumId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCurriculumCode(model.getCurriculumCode());
		soapModel.setCurriculumName(model.getCurriculumName());

		return soapModel;
	}

	public static CurriculumSoap[] toSoapModels(Curriculum[] models) {
		CurriculumSoap[] soapModels = new CurriculumSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CurriculumSoap[][] toSoapModels(Curriculum[][] models) {
		CurriculumSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CurriculumSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CurriculumSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CurriculumSoap[] toSoapModels(List<Curriculum> models) {
		List<CurriculumSoap> soapModels = new ArrayList<CurriculumSoap>(models.size());

		for (Curriculum model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CurriculumSoap[soapModels.size()]);
	}

	public CurriculumSoap() {
	}

	public long getPrimaryKey() {
		return _curriculumId;
	}

	public void setPrimaryKey(long pk) {
		setCurriculumId(pk);
	}

	public long getCurriculumId() {
		return _curriculumId;
	}

	public void setCurriculumId(long curriculumId) {
		_curriculumId = curriculumId;
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

	public String getCurriculumCode() {
		return _curriculumCode;
	}

	public void setCurriculumCode(String curriculumCode) {
		_curriculumCode = curriculumCode;
	}

	public String getCurriculumName() {
		return _curriculumName;
	}

	public void setCurriculumName(String curriculumName) {
		_curriculumName = curriculumName;
	}

	private long _curriculumId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _curriculumCode;
	private String _curriculumName;
}