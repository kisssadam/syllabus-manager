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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import hu.unideb.inf.service.ClpSerializer;
import hu.unideb.inf.service.SemesterLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Adam Kiss
 */
public class SemesterClp extends BaseModelImpl<Semester> implements Semester {
	public SemesterClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Semester.class;
	}

	@Override
	public String getModelClassName() {
		return Semester.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _semesterId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSemesterId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _semesterId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("semesterId", getSemesterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("beginYear", getBeginYear());
		attributes.put("endYear", getEndYear());
		attributes.put("division", getDivision());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long semesterId = (Long)attributes.get("semesterId");

		if (semesterId != null) {
			setSemesterId(semesterId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer beginYear = (Integer)attributes.get("beginYear");

		if (beginYear != null) {
			setBeginYear(beginYear);
		}

		Integer endYear = (Integer)attributes.get("endYear");

		if (endYear != null) {
			setEndYear(endYear);
		}

		Integer division = (Integer)attributes.get("division");

		if (division != null) {
			setDivision(division);
		}
	}

	@Override
	public long getSemesterId() {
		return _semesterId;
	}

	@Override
	public void setSemesterId(long semesterId) {
		_semesterId = semesterId;

		if (_semesterRemoteModel != null) {
			try {
				Class<?> clazz = _semesterRemoteModel.getClass();

				Method method = clazz.getMethod("setSemesterId", long.class);

				method.invoke(_semesterRemoteModel, semesterId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_semesterRemoteModel != null) {
			try {
				Class<?> clazz = _semesterRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_semesterRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_semesterRemoteModel != null) {
			try {
				Class<?> clazz = _semesterRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_semesterRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_semesterRemoteModel != null) {
			try {
				Class<?> clazz = _semesterRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_semesterRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_semesterRemoteModel != null) {
			try {
				Class<?> clazz = _semesterRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_semesterRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_semesterRemoteModel != null) {
			try {
				Class<?> clazz = _semesterRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_semesterRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_semesterRemoteModel != null) {
			try {
				Class<?> clazz = _semesterRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_semesterRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getBeginYear() {
		return _beginYear;
	}

	@Override
	public void setBeginYear(int beginYear) {
		_beginYear = beginYear;

		if (_semesterRemoteModel != null) {
			try {
				Class<?> clazz = _semesterRemoteModel.getClass();

				Method method = clazz.getMethod("setBeginYear", int.class);

				method.invoke(_semesterRemoteModel, beginYear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getEndYear() {
		return _endYear;
	}

	@Override
	public void setEndYear(int endYear) {
		_endYear = endYear;

		if (_semesterRemoteModel != null) {
			try {
				Class<?> clazz = _semesterRemoteModel.getClass();

				Method method = clazz.getMethod("setEndYear", int.class);

				method.invoke(_semesterRemoteModel, endYear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDivision() {
		return _division;
	}

	@Override
	public void setDivision(int division) {
		_division = division;

		if (_semesterRemoteModel != null) {
			try {
				Class<?> clazz = _semesterRemoteModel.getClass();

				Method method = clazz.getMethod("setDivision", int.class);

				method.invoke(_semesterRemoteModel, division);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNextBeginYear() {
		try {
			String methodName = "getNextBeginYear";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Integer returnObj = (Integer)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public int getNextEndYear() {
		try {
			String methodName = "getNextEndYear";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Integer returnObj = (Integer)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public int getNextDivision() {
		try {
			String methodName = "getNextDivision";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Integer returnObj = (Integer)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getSemesterRemoteModel() {
		return _semesterRemoteModel;
	}

	public void setSemesterRemoteModel(BaseModel<?> semesterRemoteModel) {
		_semesterRemoteModel = semesterRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _semesterRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_semesterRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SemesterLocalServiceUtil.addSemester(this);
		}
		else {
			SemesterLocalServiceUtil.updateSemester(this);
		}
	}

	@Override
	public Semester toEscapedModel() {
		return (Semester)ProxyUtil.newProxyInstance(Semester.class.getClassLoader(),
			new Class[] { Semester.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SemesterClp clone = new SemesterClp();

		clone.setSemesterId(getSemesterId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setBeginYear(getBeginYear());
		clone.setEndYear(getEndYear());
		clone.setDivision(getDivision());

		return clone;
	}

	@Override
	public int compareTo(Semester semester) {
		int value = 0;

		if (getBeginYear() < semester.getBeginYear()) {
			value = -1;
		}
		else if (getBeginYear() > semester.getBeginYear()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getEndYear() < semester.getEndYear()) {
			value = -1;
		}
		else if (getEndYear() > semester.getEndYear()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getDivision() < semester.getDivision()) {
			value = -1;
		}
		else if (getDivision() > semester.getDivision()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SemesterClp)) {
			return false;
		}

		SemesterClp semester = (SemesterClp)obj;

		long primaryKey = semester.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{semesterId=");
		sb.append(getSemesterId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", beginYear=");
		sb.append(getBeginYear());
		sb.append(", endYear=");
		sb.append(getEndYear());
		sb.append(", division=");
		sb.append(getDivision());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("hu.unideb.inf.model.Semester");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>semesterId</column-name><column-value><![CDATA[");
		sb.append(getSemesterId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>beginYear</column-name><column-value><![CDATA[");
		sb.append(getBeginYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endYear</column-name><column-value><![CDATA[");
		sb.append(getEndYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>division</column-name><column-value><![CDATA[");
		sb.append(getDivision());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _semesterId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _beginYear;
	private int _endYear;
	private int _division;
	private BaseModel<?> _semesterRemoteModel;
	private Class<?> _clpSerializerClass = hu.unideb.inf.service.ClpSerializer.class;
}