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

package hu.unideb.inf.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import hu.unideb.inf.model.Lecturer;
import hu.unideb.inf.model.LecturerModel;
import hu.unideb.inf.model.LecturerSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Lecturer service. Represents a row in the &quot;unideb_syllabus_manager_Lecturer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link hu.unideb.inf.model.LecturerModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LecturerImpl}.
 * </p>
 *
 * @author Adam Kiss
 * @see LecturerImpl
 * @see hu.unideb.inf.model.Lecturer
 * @see hu.unideb.inf.model.LecturerModel
 * @generated
 */
@JSON(strict = true)
public class LecturerModelImpl extends BaseModelImpl<Lecturer>
	implements LecturerModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a lecturer model instance should use the {@link hu.unideb.inf.model.Lecturer} interface instead.
	 */
	public static final String TABLE_NAME = "unideb_syllabus_manager_Lecturer";
	public static final Object[][] TABLE_COLUMNS = {
			{ "lecturerId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "lecturerName", Types.VARCHAR },
			{ "lecturerUserId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table unideb_syllabus_manager_Lecturer (lecturerId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,lecturerName TEXT null,lecturerUserId LONG)";
	public static final String TABLE_SQL_DROP = "drop table unideb_syllabus_manager_Lecturer";
	public static final String ORDER_BY_JPQL = " ORDER BY lecturer.lecturerId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY unideb_syllabus_manager_Lecturer.lecturerId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.hu.unideb.inf.model.Lecturer"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.hu.unideb.inf.model.Lecturer"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.hu.unideb.inf.model.Lecturer"),
			true);
	public static long LECTURERNAME_COLUMN_BITMASK = 1L;
	public static long LECTURERID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Lecturer toModel(LecturerSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Lecturer model = new LecturerImpl();

		model.setLecturerId(soapModel.getLecturerId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setLecturerName(soapModel.getLecturerName());
		model.setLecturerUserId(soapModel.getLecturerUserId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Lecturer> toModels(LecturerSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Lecturer> models = new ArrayList<Lecturer>(soapModels.length);

		for (LecturerSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final String MAPPING_TABLE_UNIDEB_SYLLABUS_MANAGER_LECTURERS_TIMETABLECOURSES_NAME =
		"unideb_syllabus_manager_Lecturers_TimetableCourses";
	public static final Object[][] MAPPING_TABLE_UNIDEB_SYLLABUS_MANAGER_LECTURERS_TIMETABLECOURSES_COLUMNS =
		{
			{ "lecturerId", Types.BIGINT },
			{ "timetableCourseId", Types.BIGINT }
		};
	public static final String MAPPING_TABLE_UNIDEB_SYLLABUS_MANAGER_LECTURERS_TIMETABLECOURSES_SQL_CREATE =
		"create table unideb_syllabus_manager_Lecturers_TimetableCourses (lecturerId LONG not null,timetableCourseId LONG not null,primary key (lecturerId, timetableCourseId))";
	public static final boolean FINDER_CACHE_ENABLED_UNIDEB_SYLLABUS_MANAGER_LECTURERS_TIMETABLECOURSES =
		GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.unideb_syllabus_manager_Lecturers_TimetableCourses"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.hu.unideb.inf.model.Lecturer"));

	public LecturerModelImpl() {
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
	public Class<?> getModelClass() {
		return Lecturer.class;
	}

	@Override
	public String getModelClassName() {
		return Lecturer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lecturerId", getLecturerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("lecturerName", getLecturerName());
		attributes.put("lecturerUserId", getLecturerUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lecturerId = (Long)attributes.get("lecturerId");

		if (lecturerId != null) {
			setLecturerId(lecturerId);
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

		String lecturerName = (String)attributes.get("lecturerName");

		if (lecturerName != null) {
			setLecturerName(lecturerName);
		}

		Long lecturerUserId = (Long)attributes.get("lecturerUserId");

		if (lecturerUserId != null) {
			setLecturerUserId(lecturerUserId);
		}
	}

	@JSON
	@Override
	public long getLecturerId() {
		return _lecturerId;
	}

	@Override
	public void setLecturerId(long lecturerId) {
		_lecturerId = lecturerId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getLecturerName() {
		if (_lecturerName == null) {
			return StringPool.BLANK;
		}
		else {
			return _lecturerName;
		}
	}

	@Override
	public void setLecturerName(String lecturerName) {
		_columnBitmask |= LECTURERNAME_COLUMN_BITMASK;

		if (_originalLecturerName == null) {
			_originalLecturerName = _lecturerName;
		}

		_lecturerName = lecturerName;
	}

	public String getOriginalLecturerName() {
		return GetterUtil.getString(_originalLecturerName);
	}

	@JSON
	@Override
	public long getLecturerUserId() {
		return _lecturerUserId;
	}

	@Override
	public void setLecturerUserId(long lecturerUserId) {
		_lecturerUserId = lecturerUserId;
	}

	@Override
	public String getLecturerUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getLecturerUserId(), "uuid",
			_lecturerUserUuid);
	}

	@Override
	public void setLecturerUserUuid(String lecturerUserUuid) {
		_lecturerUserUuid = lecturerUserUuid;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Lecturer.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Lecturer toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Lecturer)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LecturerImpl lecturerImpl = new LecturerImpl();

		lecturerImpl.setLecturerId(getLecturerId());
		lecturerImpl.setGroupId(getGroupId());
		lecturerImpl.setCompanyId(getCompanyId());
		lecturerImpl.setUserId(getUserId());
		lecturerImpl.setUserName(getUserName());
		lecturerImpl.setCreateDate(getCreateDate());
		lecturerImpl.setModifiedDate(getModifiedDate());
		lecturerImpl.setLecturerName(getLecturerName());
		lecturerImpl.setLecturerUserId(getLecturerUserId());

		lecturerImpl.resetOriginalValues();

		return lecturerImpl;
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

		if (!(obj instanceof Lecturer)) {
			return false;
		}

		Lecturer lecturer = (Lecturer)obj;

		long primaryKey = lecturer.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		LecturerModelImpl lecturerModelImpl = this;

		lecturerModelImpl._originalLecturerName = lecturerModelImpl._lecturerName;

		lecturerModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Lecturer> toCacheModel() {
		LecturerCacheModel lecturerCacheModel = new LecturerCacheModel();

		lecturerCacheModel.lecturerId = getLecturerId();

		lecturerCacheModel.groupId = getGroupId();

		lecturerCacheModel.companyId = getCompanyId();

		lecturerCacheModel.userId = getUserId();

		lecturerCacheModel.userName = getUserName();

		String userName = lecturerCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			lecturerCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			lecturerCacheModel.createDate = createDate.getTime();
		}
		else {
			lecturerCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			lecturerCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			lecturerCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		lecturerCacheModel.lecturerName = getLecturerName();

		String lecturerName = lecturerCacheModel.lecturerName;

		if ((lecturerName != null) && (lecturerName.length() == 0)) {
			lecturerCacheModel.lecturerName = null;
		}

		lecturerCacheModel.lecturerUserId = getLecturerUserId();

		return lecturerCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{lecturerId=");
		sb.append(getLecturerId());
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
		sb.append(", lecturerName=");
		sb.append(getLecturerName());
		sb.append(", lecturerUserId=");
		sb.append(getLecturerUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("hu.unideb.inf.model.Lecturer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lecturerId</column-name><column-value><![CDATA[");
		sb.append(getLecturerId());
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
			"<column><column-name>lecturerName</column-name><column-value><![CDATA[");
		sb.append(getLecturerName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lecturerUserId</column-name><column-value><![CDATA[");
		sb.append(getLecturerUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Lecturer.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Lecturer.class
		};
	private long _lecturerId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _lecturerName;
	private String _originalLecturerName;
	private long _lecturerUserId;
	private String _lecturerUserUuid;
	private long _columnBitmask;
	private Lecturer _escapedModel;
}