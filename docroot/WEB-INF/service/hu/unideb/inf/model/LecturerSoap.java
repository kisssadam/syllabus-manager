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
		soapModel.setLecturerName(model.getLecturerName());
		soapModel.setUserId(model.getUserId());

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

	public String getLecturerName() {
		return _lecturerName;
	}

	public void setLecturerName(String lecturerName) {
		_lecturerName = lecturerName;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _lecturerId;
	private String _lecturerName;
	private long _userId;
}