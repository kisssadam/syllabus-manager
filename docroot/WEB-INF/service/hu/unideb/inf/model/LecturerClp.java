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
import hu.unideb.inf.service.LecturerLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Adam Kiss
 */
public class LecturerClp extends BaseModelImpl<Lecturer> implements Lecturer {
	public LecturerClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Lecturer.class;
	}

	@Override
	public String getModelClassName() {
		return Lecturer.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _lecturerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLecturerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _lecturerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lecturerId", getLecturerId());
		attributes.put("lecturerName", getLecturerName());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lecturerId = (Long)attributes.get("lecturerId");

		if (lecturerId != null) {
			setLecturerId(lecturerId);
		}

		String lecturerName = (String)attributes.get("lecturerName");

		if (lecturerName != null) {
			setLecturerName(lecturerName);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public long getLecturerId() {
		return _lecturerId;
	}

	@Override
	public void setLecturerId(long lecturerId) {
		_lecturerId = lecturerId;

		if (_lecturerRemoteModel != null) {
			try {
				Class<?> clazz = _lecturerRemoteModel.getClass();

				Method method = clazz.getMethod("setLecturerId", long.class);

				method.invoke(_lecturerRemoteModel, lecturerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLecturerName() {
		return _lecturerName;
	}

	@Override
	public void setLecturerName(String lecturerName) {
		_lecturerName = lecturerName;

		if (_lecturerRemoteModel != null) {
			try {
				Class<?> clazz = _lecturerRemoteModel.getClass();

				Method method = clazz.getMethod("setLecturerName", String.class);

				method.invoke(_lecturerRemoteModel, lecturerName);
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

		if (_lecturerRemoteModel != null) {
			try {
				Class<?> clazz = _lecturerRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_lecturerRemoteModel, userId);
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

	public BaseModel<?> getLecturerRemoteModel() {
		return _lecturerRemoteModel;
	}

	public void setLecturerRemoteModel(BaseModel<?> lecturerRemoteModel) {
		_lecturerRemoteModel = lecturerRemoteModel;
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

		Class<?> remoteModelClass = _lecturerRemoteModel.getClass();

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

		Object returnValue = method.invoke(_lecturerRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LecturerLocalServiceUtil.addLecturer(this);
		}
		else {
			LecturerLocalServiceUtil.updateLecturer(this);
		}
	}

	@Override
	public Lecturer toEscapedModel() {
		return (Lecturer)ProxyUtil.newProxyInstance(Lecturer.class.getClassLoader(),
			new Class[] { Lecturer.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LecturerClp clone = new LecturerClp();

		clone.setLecturerId(getLecturerId());
		clone.setLecturerName(getLecturerName());
		clone.setUserId(getUserId());

		return clone;
	}

	@Override
	public int compareTo(Lecturer lecturer) {
		long primaryKey = lecturer.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LecturerClp)) {
			return false;
		}

		LecturerClp lecturer = (LecturerClp)obj;

		long primaryKey = lecturer.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{lecturerId=");
		sb.append(getLecturerId());
		sb.append(", lecturerName=");
		sb.append(getLecturerName());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("hu.unideb.inf.model.Lecturer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lecturerId</column-name><column-value><![CDATA[");
		sb.append(getLecturerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lecturerName</column-name><column-value><![CDATA[");
		sb.append(getLecturerName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _lecturerId;
	private String _lecturerName;
	private long _userId;
	private String _userUuid;
	private BaseModel<?> _lecturerRemoteModel;
	private Class<?> _clpSerializerClass = hu.unideb.inf.service.ClpSerializer.class;
}