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
import hu.unideb.inf.service.SubjectLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Adam Kiss
 */
public class SubjectClp extends BaseModelImpl<Subject> implements Subject {
	public SubjectClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Subject.class;
	}

	@Override
	public String getModelClassName() {
		return Subject.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _subjectId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSubjectId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _subjectId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("subjectId", getSubjectId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("subjectCode", getSubjectCode());
		attributes.put("subjectName", getSubjectName());
		attributes.put("credit", getCredit());
		attributes.put("curriculumId", getCurriculumId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long subjectId = (Long)attributes.get("subjectId");

		if (subjectId != null) {
			setSubjectId(subjectId);
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

		String subjectCode = (String)attributes.get("subjectCode");

		if (subjectCode != null) {
			setSubjectCode(subjectCode);
		}

		String subjectName = (String)attributes.get("subjectName");

		if (subjectName != null) {
			setSubjectName(subjectName);
		}

		Integer credit = (Integer)attributes.get("credit");

		if (credit != null) {
			setCredit(credit);
		}

		Long curriculumId = (Long)attributes.get("curriculumId");

		if (curriculumId != null) {
			setCurriculumId(curriculumId);
		}
	}

	@Override
	public long getSubjectId() {
		return _subjectId;
	}

	@Override
	public void setSubjectId(long subjectId) {
		_subjectId = subjectId;

		if (_subjectRemoteModel != null) {
			try {
				Class<?> clazz = _subjectRemoteModel.getClass();

				Method method = clazz.getMethod("setSubjectId", long.class);

				method.invoke(_subjectRemoteModel, subjectId);
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

		if (_subjectRemoteModel != null) {
			try {
				Class<?> clazz = _subjectRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_subjectRemoteModel, groupId);
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

		if (_subjectRemoteModel != null) {
			try {
				Class<?> clazz = _subjectRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_subjectRemoteModel, companyId);
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

		if (_subjectRemoteModel != null) {
			try {
				Class<?> clazz = _subjectRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_subjectRemoteModel, userId);
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

		if (_subjectRemoteModel != null) {
			try {
				Class<?> clazz = _subjectRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_subjectRemoteModel, userName);
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

		if (_subjectRemoteModel != null) {
			try {
				Class<?> clazz = _subjectRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_subjectRemoteModel, createDate);
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

		if (_subjectRemoteModel != null) {
			try {
				Class<?> clazz = _subjectRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_subjectRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubjectCode() {
		return _subjectCode;
	}

	@Override
	public void setSubjectCode(String subjectCode) {
		_subjectCode = subjectCode;

		if (_subjectRemoteModel != null) {
			try {
				Class<?> clazz = _subjectRemoteModel.getClass();

				Method method = clazz.getMethod("setSubjectCode", String.class);

				method.invoke(_subjectRemoteModel, subjectCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubjectName() {
		return _subjectName;
	}

	@Override
	public void setSubjectName(String subjectName) {
		_subjectName = subjectName;

		if (_subjectRemoteModel != null) {
			try {
				Class<?> clazz = _subjectRemoteModel.getClass();

				Method method = clazz.getMethod("setSubjectName", String.class);

				method.invoke(_subjectRemoteModel, subjectName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCredit() {
		return _credit;
	}

	@Override
	public void setCredit(int credit) {
		_credit = credit;

		if (_subjectRemoteModel != null) {
			try {
				Class<?> clazz = _subjectRemoteModel.getClass();

				Method method = clazz.getMethod("setCredit", int.class);

				method.invoke(_subjectRemoteModel, credit);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCurriculumId() {
		return _curriculumId;
	}

	@Override
	public void setCurriculumId(long curriculumId) {
		_curriculumId = curriculumId;

		if (_subjectRemoteModel != null) {
			try {
				Class<?> clazz = _subjectRemoteModel.getClass();

				Method method = clazz.getMethod("setCurriculumId", long.class);

				method.invoke(_subjectRemoteModel, curriculumId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSubjectRemoteModel() {
		return _subjectRemoteModel;
	}

	public void setSubjectRemoteModel(BaseModel<?> subjectRemoteModel) {
		_subjectRemoteModel = subjectRemoteModel;
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

		Class<?> remoteModelClass = _subjectRemoteModel.getClass();

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

		Object returnValue = method.invoke(_subjectRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SubjectLocalServiceUtil.addSubject(this);
		}
		else {
			SubjectLocalServiceUtil.updateSubject(this);
		}
	}

	@Override
	public Subject toEscapedModel() {
		return (Subject)ProxyUtil.newProxyInstance(Subject.class.getClassLoader(),
			new Class[] { Subject.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SubjectClp clone = new SubjectClp();

		clone.setSubjectId(getSubjectId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSubjectCode(getSubjectCode());
		clone.setSubjectName(getSubjectName());
		clone.setCredit(getCredit());
		clone.setCurriculumId(getCurriculumId());

		return clone;
	}

	@Override
	public int compareTo(Subject subject) {
		int value = 0;

		value = getSubjectCode().compareTo(subject.getSubjectCode());

		if (value != 0) {
			return value;
		}

		value = getSubjectName().compareTo(subject.getSubjectName());

		if (value != 0) {
			return value;
		}

		if (getCredit() < subject.getCredit()) {
			value = -1;
		}
		else if (getCredit() > subject.getCredit()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof SubjectClp)) {
			return false;
		}

		SubjectClp subject = (SubjectClp)obj;

		long primaryKey = subject.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{subjectId=");
		sb.append(getSubjectId());
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
		sb.append(", subjectCode=");
		sb.append(getSubjectCode());
		sb.append(", subjectName=");
		sb.append(getSubjectName());
		sb.append(", credit=");
		sb.append(getCredit());
		sb.append(", curriculumId=");
		sb.append(getCurriculumId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("hu.unideb.inf.model.Subject");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>subjectId</column-name><column-value><![CDATA[");
		sb.append(getSubjectId());
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
			"<column><column-name>subjectCode</column-name><column-value><![CDATA[");
		sb.append(getSubjectCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subjectName</column-name><column-value><![CDATA[");
		sb.append(getSubjectName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>credit</column-name><column-value><![CDATA[");
		sb.append(getCredit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>curriculumId</column-name><column-value><![CDATA[");
		sb.append(getCurriculumId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _subjectId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _subjectCode;
	private String _subjectName;
	private int _credit;
	private long _curriculumId;
	private BaseModel<?> _subjectRemoteModel;
	private Class<?> _clpSerializerClass = hu.unideb.inf.service.ClpSerializer.class;
}