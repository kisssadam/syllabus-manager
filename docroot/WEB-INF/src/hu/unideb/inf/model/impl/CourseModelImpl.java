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

import hu.unideb.inf.model.Course;
import hu.unideb.inf.model.CourseModel;
import hu.unideb.inf.model.CourseSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Course service. Represents a row in the &quot;unideb_syllabus_manager_Course&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link hu.unideb.inf.model.CourseModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CourseImpl}.
 * </p>
 *
 * @author Adam Kiss
 * @see CourseImpl
 * @see hu.unideb.inf.model.Course
 * @see hu.unideb.inf.model.CourseModel
 * @generated
 */
@JSON(strict = true)
public class CourseModelImpl extends BaseModelImpl<Course>
	implements CourseModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a course model instance should use the {@link hu.unideb.inf.model.Course} interface instead.
	 */
	public static final String TABLE_NAME = "unideb_syllabus_manager_Course";
	public static final Object[][] TABLE_COLUMNS = {
			{ "courseId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "subjectId", Types.BIGINT },
			{ "hoursPerSemester", Types.INTEGER },
			{ "hoursPerWeek", Types.INTEGER },
			{ "courseTypeId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table unideb_syllabus_manager_Course (courseId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,subjectId LONG,hoursPerSemester INTEGER,hoursPerWeek INTEGER,courseTypeId LONG)";
	public static final String TABLE_SQL_DROP = "drop table unideb_syllabus_manager_Course";
	public static final String ORDER_BY_JPQL = " ORDER BY course.courseId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY unideb_syllabus_manager_Course.courseId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.hu.unideb.inf.model.Course"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.hu.unideb.inf.model.Course"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.hu.unideb.inf.model.Course"),
			true);
	public static long COURSETYPEID_COLUMN_BITMASK = 1L;
	public static long SUBJECTID_COLUMN_BITMASK = 2L;
	public static long COURSEID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Course toModel(CourseSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Course model = new CourseImpl();

		model.setCourseId(soapModel.getCourseId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setSubjectId(soapModel.getSubjectId());
		model.setHoursPerSemester(soapModel.getHoursPerSemester());
		model.setHoursPerWeek(soapModel.getHoursPerWeek());
		model.setCourseTypeId(soapModel.getCourseTypeId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Course> toModels(CourseSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Course> models = new ArrayList<Course>(soapModels.length);

		for (CourseSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.hu.unideb.inf.model.Course"));

	public CourseModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _courseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCourseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _courseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Course.class;
	}

	@Override
	public String getModelClassName() {
		return Course.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("courseId", getCourseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("subjectId", getSubjectId());
		attributes.put("hoursPerSemester", getHoursPerSemester());
		attributes.put("hoursPerWeek", getHoursPerWeek());
		attributes.put("courseTypeId", getCourseTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
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

		Long subjectId = (Long)attributes.get("subjectId");

		if (subjectId != null) {
			setSubjectId(subjectId);
		}

		Integer hoursPerSemester = (Integer)attributes.get("hoursPerSemester");

		if (hoursPerSemester != null) {
			setHoursPerSemester(hoursPerSemester);
		}

		Integer hoursPerWeek = (Integer)attributes.get("hoursPerWeek");

		if (hoursPerWeek != null) {
			setHoursPerWeek(hoursPerWeek);
		}

		Long courseTypeId = (Long)attributes.get("courseTypeId");

		if (courseTypeId != null) {
			setCourseTypeId(courseTypeId);
		}
	}

	@JSON
	@Override
	public long getCourseId() {
		return _courseId;
	}

	@Override
	public void setCourseId(long courseId) {
		_courseId = courseId;
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
	public long getSubjectId() {
		return _subjectId;
	}

	@Override
	public void setSubjectId(long subjectId) {
		_columnBitmask |= SUBJECTID_COLUMN_BITMASK;

		if (!_setOriginalSubjectId) {
			_setOriginalSubjectId = true;

			_originalSubjectId = _subjectId;
		}

		_subjectId = subjectId;
	}

	public long getOriginalSubjectId() {
		return _originalSubjectId;
	}

	@JSON
	@Override
	public int getHoursPerSemester() {
		return _hoursPerSemester;
	}

	@Override
	public void setHoursPerSemester(int hoursPerSemester) {
		_hoursPerSemester = hoursPerSemester;
	}

	@JSON
	@Override
	public int getHoursPerWeek() {
		return _hoursPerWeek;
	}

	@Override
	public void setHoursPerWeek(int hoursPerWeek) {
		_hoursPerWeek = hoursPerWeek;
	}

	@JSON
	@Override
	public long getCourseTypeId() {
		return _courseTypeId;
	}

	@Override
	public void setCourseTypeId(long courseTypeId) {
		_columnBitmask |= COURSETYPEID_COLUMN_BITMASK;

		if (!_setOriginalCourseTypeId) {
			_setOriginalCourseTypeId = true;

			_originalCourseTypeId = _courseTypeId;
		}

		_courseTypeId = courseTypeId;
	}

	public long getOriginalCourseTypeId() {
		return _originalCourseTypeId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Course.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Course toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Course)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CourseImpl courseImpl = new CourseImpl();

		courseImpl.setCourseId(getCourseId());
		courseImpl.setGroupId(getGroupId());
		courseImpl.setCompanyId(getCompanyId());
		courseImpl.setUserId(getUserId());
		courseImpl.setUserName(getUserName());
		courseImpl.setCreateDate(getCreateDate());
		courseImpl.setModifiedDate(getModifiedDate());
		courseImpl.setSubjectId(getSubjectId());
		courseImpl.setHoursPerSemester(getHoursPerSemester());
		courseImpl.setHoursPerWeek(getHoursPerWeek());
		courseImpl.setCourseTypeId(getCourseTypeId());

		courseImpl.resetOriginalValues();

		return courseImpl;
	}

	@Override
	public int compareTo(Course course) {
		long primaryKey = course.getPrimaryKey();

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

		if (!(obj instanceof Course)) {
			return false;
		}

		Course course = (Course)obj;

		long primaryKey = course.getPrimaryKey();

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
		CourseModelImpl courseModelImpl = this;

		courseModelImpl._originalSubjectId = courseModelImpl._subjectId;

		courseModelImpl._setOriginalSubjectId = false;

		courseModelImpl._originalCourseTypeId = courseModelImpl._courseTypeId;

		courseModelImpl._setOriginalCourseTypeId = false;

		courseModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Course> toCacheModel() {
		CourseCacheModel courseCacheModel = new CourseCacheModel();

		courseCacheModel.courseId = getCourseId();

		courseCacheModel.groupId = getGroupId();

		courseCacheModel.companyId = getCompanyId();

		courseCacheModel.userId = getUserId();

		courseCacheModel.userName = getUserName();

		String userName = courseCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			courseCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			courseCacheModel.createDate = createDate.getTime();
		}
		else {
			courseCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			courseCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			courseCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		courseCacheModel.subjectId = getSubjectId();

		courseCacheModel.hoursPerSemester = getHoursPerSemester();

		courseCacheModel.hoursPerWeek = getHoursPerWeek();

		courseCacheModel.courseTypeId = getCourseTypeId();

		return courseCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{courseId=");
		sb.append(getCourseId());
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
		sb.append(", subjectId=");
		sb.append(getSubjectId());
		sb.append(", hoursPerSemester=");
		sb.append(getHoursPerSemester());
		sb.append(", hoursPerWeek=");
		sb.append(getHoursPerWeek());
		sb.append(", courseTypeId=");
		sb.append(getCourseTypeId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("hu.unideb.inf.model.Course");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>courseId</column-name><column-value><![CDATA[");
		sb.append(getCourseId());
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
			"<column><column-name>subjectId</column-name><column-value><![CDATA[");
		sb.append(getSubjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoursPerSemester</column-name><column-value><![CDATA[");
		sb.append(getHoursPerSemester());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoursPerWeek</column-name><column-value><![CDATA[");
		sb.append(getHoursPerWeek());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseTypeId</column-name><column-value><![CDATA[");
		sb.append(getCourseTypeId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Course.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Course.class };
	private long _courseId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _subjectId;
	private long _originalSubjectId;
	private boolean _setOriginalSubjectId;
	private int _hoursPerSemester;
	private int _hoursPerWeek;
	private long _courseTypeId;
	private long _originalCourseTypeId;
	private boolean _setOriginalCourseTypeId;
	private long _columnBitmask;
	private Course _escapedModel;
}