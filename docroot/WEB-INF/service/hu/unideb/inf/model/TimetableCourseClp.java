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
import hu.unideb.inf.service.TimetableCourseLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Adam Kiss
 */
public class TimetableCourseClp extends BaseModelImpl<TimetableCourse>
	implements TimetableCourse {
	public TimetableCourseClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TimetableCourse.class;
	}

	@Override
	public String getModelClassName() {
		return TimetableCourse.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _timetableCourseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTimetableCourseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _timetableCourseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("timetableCourseId", getTimetableCourseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("courseId", getCourseId());
		attributes.put("subjectType", getSubjectType());
		attributes.put("recommendedTerm", getRecommendedTerm());
		attributes.put("limit", getLimit());
		attributes.put("classScheduleInfo", getClassScheduleInfo());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long timetableCourseId = (Long)attributes.get("timetableCourseId");

		if (timetableCourseId != null) {
			setTimetableCourseId(timetableCourseId);
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

		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		String subjectType = (String)attributes.get("subjectType");

		if (subjectType != null) {
			setSubjectType(subjectType);
		}

		Integer recommendedTerm = (Integer)attributes.get("recommendedTerm");

		if (recommendedTerm != null) {
			setRecommendedTerm(recommendedTerm);
		}

		Integer limit = (Integer)attributes.get("limit");

		if (limit != null) {
			setLimit(limit);
		}

		String classScheduleInfo = (String)attributes.get("classScheduleInfo");

		if (classScheduleInfo != null) {
			setClassScheduleInfo(classScheduleInfo);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public long getTimetableCourseId() {
		return _timetableCourseId;
	}

	@Override
	public void setTimetableCourseId(long timetableCourseId) {
		_timetableCourseId = timetableCourseId;

		if (_timetableCourseRemoteModel != null) {
			try {
				Class<?> clazz = _timetableCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setTimetableCourseId",
						long.class);

				method.invoke(_timetableCourseRemoteModel, timetableCourseId);
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

		if (_timetableCourseRemoteModel != null) {
			try {
				Class<?> clazz = _timetableCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_timetableCourseRemoteModel, groupId);
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

		if (_timetableCourseRemoteModel != null) {
			try {
				Class<?> clazz = _timetableCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_timetableCourseRemoteModel, companyId);
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

		if (_timetableCourseRemoteModel != null) {
			try {
				Class<?> clazz = _timetableCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_timetableCourseRemoteModel, userId);
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

		if (_timetableCourseRemoteModel != null) {
			try {
				Class<?> clazz = _timetableCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_timetableCourseRemoteModel, userName);
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

		if (_timetableCourseRemoteModel != null) {
			try {
				Class<?> clazz = _timetableCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_timetableCourseRemoteModel, createDate);
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

		if (_timetableCourseRemoteModel != null) {
			try {
				Class<?> clazz = _timetableCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_timetableCourseRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCourseId() {
		return _courseId;
	}

	@Override
	public void setCourseId(long courseId) {
		_courseId = courseId;

		if (_timetableCourseRemoteModel != null) {
			try {
				Class<?> clazz = _timetableCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseId", long.class);

				method.invoke(_timetableCourseRemoteModel, courseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubjectType() {
		return _subjectType;
	}

	@Override
	public void setSubjectType(String subjectType) {
		_subjectType = subjectType;

		if (_timetableCourseRemoteModel != null) {
			try {
				Class<?> clazz = _timetableCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setSubjectType", String.class);

				method.invoke(_timetableCourseRemoteModel, subjectType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRecommendedTerm() {
		return _recommendedTerm;
	}

	@Override
	public void setRecommendedTerm(int recommendedTerm) {
		_recommendedTerm = recommendedTerm;

		if (_timetableCourseRemoteModel != null) {
			try {
				Class<?> clazz = _timetableCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setRecommendedTerm", int.class);

				method.invoke(_timetableCourseRemoteModel, recommendedTerm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getLimit() {
		return _limit;
	}

	@Override
	public void setLimit(int limit) {
		_limit = limit;

		if (_timetableCourseRemoteModel != null) {
			try {
				Class<?> clazz = _timetableCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setLimit", int.class);

				method.invoke(_timetableCourseRemoteModel, limit);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassScheduleInfo() {
		return _classScheduleInfo;
	}

	@Override
	public void setClassScheduleInfo(String classScheduleInfo) {
		_classScheduleInfo = classScheduleInfo;

		if (_timetableCourseRemoteModel != null) {
			try {
				Class<?> clazz = _timetableCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setClassScheduleInfo",
						String.class);

				method.invoke(_timetableCourseRemoteModel, classScheduleInfo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_timetableCourseRemoteModel != null) {
			try {
				Class<?> clazz = _timetableCourseRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_timetableCourseRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTimetableCourseRemoteModel() {
		return _timetableCourseRemoteModel;
	}

	public void setTimetableCourseRemoteModel(
		BaseModel<?> timetableCourseRemoteModel) {
		_timetableCourseRemoteModel = timetableCourseRemoteModel;
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

		Class<?> remoteModelClass = _timetableCourseRemoteModel.getClass();

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

		Object returnValue = method.invoke(_timetableCourseRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TimetableCourseLocalServiceUtil.addTimetableCourse(this);
		}
		else {
			TimetableCourseLocalServiceUtil.updateTimetableCourse(this);
		}
	}

	@Override
	public TimetableCourse toEscapedModel() {
		return (TimetableCourse)ProxyUtil.newProxyInstance(TimetableCourse.class.getClassLoader(),
			new Class[] { TimetableCourse.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TimetableCourseClp clone = new TimetableCourseClp();

		clone.setTimetableCourseId(getTimetableCourseId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCourseId(getCourseId());
		clone.setSubjectType(getSubjectType());
		clone.setRecommendedTerm(getRecommendedTerm());
		clone.setLimit(getLimit());
		clone.setClassScheduleInfo(getClassScheduleInfo());
		clone.setDescription(getDescription());

		return clone;
	}

	@Override
	public int compareTo(TimetableCourse timetableCourse) {
		long primaryKey = timetableCourse.getPrimaryKey();

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

		if (!(obj instanceof TimetableCourseClp)) {
			return false;
		}

		TimetableCourseClp timetableCourse = (TimetableCourseClp)obj;

		long primaryKey = timetableCourse.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{timetableCourseId=");
		sb.append(getTimetableCourseId());
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
		sb.append(", courseId=");
		sb.append(getCourseId());
		sb.append(", subjectType=");
		sb.append(getSubjectType());
		sb.append(", recommendedTerm=");
		sb.append(getRecommendedTerm());
		sb.append(", limit=");
		sb.append(getLimit());
		sb.append(", classScheduleInfo=");
		sb.append(getClassScheduleInfo());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("hu.unideb.inf.model.TimetableCourse");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>timetableCourseId</column-name><column-value><![CDATA[");
		sb.append(getTimetableCourseId());
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
			"<column><column-name>courseId</column-name><column-value><![CDATA[");
		sb.append(getCourseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subjectType</column-name><column-value><![CDATA[");
		sb.append(getSubjectType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recommendedTerm</column-name><column-value><![CDATA[");
		sb.append(getRecommendedTerm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>limit</column-name><column-value><![CDATA[");
		sb.append(getLimit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classScheduleInfo</column-name><column-value><![CDATA[");
		sb.append(getClassScheduleInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _timetableCourseId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _courseId;
	private String _subjectType;
	private int _recommendedTerm;
	private int _limit;
	private String _classScheduleInfo;
	private String _description;
	private BaseModel<?> _timetableCourseRemoteModel;
	private Class<?> _clpSerializerClass = hu.unideb.inf.service.ClpSerializer.class;
}