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
import hu.unideb.inf.service.CurriculumLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Adam Kiss
 */
public class CurriculumClp extends BaseModelImpl<Curriculum>
	implements Curriculum {
	public CurriculumClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Curriculum.class;
	}

	@Override
	public String getModelClassName() {
		return Curriculum.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _curriculumId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCurriculumId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _curriculumId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("curriculumId", getCurriculumId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("curriculumCode", getCurriculumCode());
		attributes.put("curriculumName", getCurriculumName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long curriculumId = (Long)attributes.get("curriculumId");

		if (curriculumId != null) {
			setCurriculumId(curriculumId);
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

		String curriculumCode = (String)attributes.get("curriculumCode");

		if (curriculumCode != null) {
			setCurriculumCode(curriculumCode);
		}

		String curriculumName = (String)attributes.get("curriculumName");

		if (curriculumName != null) {
			setCurriculumName(curriculumName);
		}
	}

	@Override
	public long getCurriculumId() {
		return _curriculumId;
	}

	@Override
	public void setCurriculumId(long curriculumId) {
		_curriculumId = curriculumId;

		if (_curriculumRemoteModel != null) {
			try {
				Class<?> clazz = _curriculumRemoteModel.getClass();

				Method method = clazz.getMethod("setCurriculumId", long.class);

				method.invoke(_curriculumRemoteModel, curriculumId);
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

		if (_curriculumRemoteModel != null) {
			try {
				Class<?> clazz = _curriculumRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_curriculumRemoteModel, groupId);
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

		if (_curriculumRemoteModel != null) {
			try {
				Class<?> clazz = _curriculumRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_curriculumRemoteModel, companyId);
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

		if (_curriculumRemoteModel != null) {
			try {
				Class<?> clazz = _curriculumRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_curriculumRemoteModel, userId);
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

		if (_curriculumRemoteModel != null) {
			try {
				Class<?> clazz = _curriculumRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_curriculumRemoteModel, userName);
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

		if (_curriculumRemoteModel != null) {
			try {
				Class<?> clazz = _curriculumRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_curriculumRemoteModel, createDate);
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

		if (_curriculumRemoteModel != null) {
			try {
				Class<?> clazz = _curriculumRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_curriculumRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurriculumCode() {
		return _curriculumCode;
	}

	@Override
	public void setCurriculumCode(String curriculumCode) {
		_curriculumCode = curriculumCode;

		if (_curriculumRemoteModel != null) {
			try {
				Class<?> clazz = _curriculumRemoteModel.getClass();

				Method method = clazz.getMethod("setCurriculumCode",
						String.class);

				method.invoke(_curriculumRemoteModel, curriculumCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurriculumName() {
		return _curriculumName;
	}

	@Override
	public void setCurriculumName(String curriculumName) {
		_curriculumName = curriculumName;

		if (_curriculumRemoteModel != null) {
			try {
				Class<?> clazz = _curriculumRemoteModel.getClass();

				Method method = clazz.getMethod("setCurriculumName",
						String.class);

				method.invoke(_curriculumRemoteModel, curriculumName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCurriculumRemoteModel() {
		return _curriculumRemoteModel;
	}

	public void setCurriculumRemoteModel(BaseModel<?> curriculumRemoteModel) {
		_curriculumRemoteModel = curriculumRemoteModel;
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

		Class<?> remoteModelClass = _curriculumRemoteModel.getClass();

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

		Object returnValue = method.invoke(_curriculumRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CurriculumLocalServiceUtil.addCurriculum(this);
		}
		else {
			CurriculumLocalServiceUtil.updateCurriculum(this);
		}
	}

	@Override
	public Curriculum toEscapedModel() {
		return (Curriculum)ProxyUtil.newProxyInstance(Curriculum.class.getClassLoader(),
			new Class[] { Curriculum.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CurriculumClp clone = new CurriculumClp();

		clone.setCurriculumId(getCurriculumId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCurriculumCode(getCurriculumCode());
		clone.setCurriculumName(getCurriculumName());

		return clone;
	}

	@Override
	public int compareTo(Curriculum curriculum) {
		int value = 0;

		value = getCurriculumCode().compareTo(curriculum.getCurriculumCode());

		if (value != 0) {
			return value;
		}

		value = getCurriculumName().compareTo(curriculum.getCurriculumName());

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

		if (!(obj instanceof CurriculumClp)) {
			return false;
		}

		CurriculumClp curriculum = (CurriculumClp)obj;

		long primaryKey = curriculum.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{curriculumId=");
		sb.append(getCurriculumId());
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
		sb.append(", curriculumCode=");
		sb.append(getCurriculumCode());
		sb.append(", curriculumName=");
		sb.append(getCurriculumName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("hu.unideb.inf.model.Curriculum");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>curriculumId</column-name><column-value><![CDATA[");
		sb.append(getCurriculumId());
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
			"<column><column-name>curriculumCode</column-name><column-value><![CDATA[");
		sb.append(getCurriculumCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>curriculumName</column-name><column-value><![CDATA[");
		sb.append(getCurriculumName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _curriculumId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _curriculumCode;
	private String _curriculumName;
	private BaseModel<?> _curriculumRemoteModel;
	private Class<?> _clpSerializerClass = hu.unideb.inf.service.ClpSerializer.class;
}