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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link TimetableCourse}.
 * </p>
 *
 * @author Adam Kiss
 * @see TimetableCourse
 * @generated
 */
@ProviderType
public class TimetableCourseWrapper implements TimetableCourse,
	ModelWrapper<TimetableCourse> {
	public TimetableCourseWrapper(TimetableCourse timetableCourse) {
		_timetableCourse = timetableCourse;
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
		attributes.put("semesterId", getSemesterId());
		attributes.put("timetableCourseCode", getTimetableCourseCode());
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

		Long semesterId = (Long)attributes.get("semesterId");

		if (semesterId != null) {
			setSemesterId(semesterId);
		}

		String timetableCourseCode = (String)attributes.get(
				"timetableCourseCode");

		if (timetableCourseCode != null) {
			setTimetableCourseCode(timetableCourseCode);
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
	public boolean isCachedModel() {
		return _timetableCourse.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _timetableCourse.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _timetableCourse.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _timetableCourse.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<hu.unideb.inf.model.TimetableCourse> toCacheModel() {
		return _timetableCourse.toCacheModel();
	}

	@Override
	public hu.unideb.inf.model.TimetableCourse toEscapedModel() {
		return new TimetableCourseWrapper(_timetableCourse.toEscapedModel());
	}

	@Override
	public hu.unideb.inf.model.TimetableCourse toUnescapedModel() {
		return new TimetableCourseWrapper(_timetableCourse.toUnescapedModel());
	}

	@Override
	public int compareTo(hu.unideb.inf.model.TimetableCourse timetableCourse) {
		return _timetableCourse.compareTo(timetableCourse);
	}

	/**
	* Returns the limit of this timetable course.
	*
	* @return the limit of this timetable course
	*/
	@Override
	public int getLimit() {
		return _timetableCourse.getLimit();
	}

	/**
	* Returns the recommended term of this timetable course.
	*
	* @return the recommended term of this timetable course
	*/
	@Override
	public int getRecommendedTerm() {
		return _timetableCourse.getRecommendedTerm();
	}

	@Override
	public int hashCode() {
		return _timetableCourse.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _timetableCourse.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TimetableCourseWrapper((TimetableCourse)_timetableCourse.clone());
	}

	/**
	* Returns the class schedule info of this timetable course.
	*
	* @return the class schedule info of this timetable course
	*/
	@Override
	public java.lang.String getClassScheduleInfo() {
		return _timetableCourse.getClassScheduleInfo();
	}

	/**
	* Returns the description of this timetable course.
	*
	* @return the description of this timetable course
	*/
	@Override
	public java.lang.String getDescription() {
		return _timetableCourse.getDescription();
	}

	/**
	* Returns the subject type of this timetable course.
	*
	* @return the subject type of this timetable course
	*/
	@Override
	public java.lang.String getSubjectType() {
		return _timetableCourse.getSubjectType();
	}

	/**
	* Returns the timetable course code of this timetable course.
	*
	* @return the timetable course code of this timetable course
	*/
	@Override
	public java.lang.String getTimetableCourseCode() {
		return _timetableCourse.getTimetableCourseCode();
	}

	/**
	* Returns the user name of this timetable course.
	*
	* @return the user name of this timetable course
	*/
	@Override
	public java.lang.String getUserName() {
		return _timetableCourse.getUserName();
	}

	/**
	* Returns the user uuid of this timetable course.
	*
	* @return the user uuid of this timetable course
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _timetableCourse.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _timetableCourse.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _timetableCourse.toXmlString();
	}

	/**
	* Returns the create date of this timetable course.
	*
	* @return the create date of this timetable course
	*/
	@Override
	public Date getCreateDate() {
		return _timetableCourse.getCreateDate();
	}

	/**
	* Returns the modified date of this timetable course.
	*
	* @return the modified date of this timetable course
	*/
	@Override
	public Date getModifiedDate() {
		return _timetableCourse.getModifiedDate();
	}

	/**
	* Returns the company ID of this timetable course.
	*
	* @return the company ID of this timetable course
	*/
	@Override
	public long getCompanyId() {
		return _timetableCourse.getCompanyId();
	}

	/**
	* Returns the course ID of this timetable course.
	*
	* @return the course ID of this timetable course
	*/
	@Override
	public long getCourseId() {
		return _timetableCourse.getCourseId();
	}

	/**
	* Returns the group ID of this timetable course.
	*
	* @return the group ID of this timetable course
	*/
	@Override
	public long getGroupId() {
		return _timetableCourse.getGroupId();
	}

	/**
	* Returns the primary key of this timetable course.
	*
	* @return the primary key of this timetable course
	*/
	@Override
	public long getPrimaryKey() {
		return _timetableCourse.getPrimaryKey();
	}

	/**
	* Returns the semester ID of this timetable course.
	*
	* @return the semester ID of this timetable course
	*/
	@Override
	public long getSemesterId() {
		return _timetableCourse.getSemesterId();
	}

	/**
	* Returns the timetable course ID of this timetable course.
	*
	* @return the timetable course ID of this timetable course
	*/
	@Override
	public long getTimetableCourseId() {
		return _timetableCourse.getTimetableCourseId();
	}

	/**
	* Returns the user ID of this timetable course.
	*
	* @return the user ID of this timetable course
	*/
	@Override
	public long getUserId() {
		return _timetableCourse.getUserId();
	}

	@Override
	public void persist() {
		_timetableCourse.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_timetableCourse.setCachedModel(cachedModel);
	}

	/**
	* Sets the class schedule info of this timetable course.
	*
	* @param classScheduleInfo the class schedule info of this timetable course
	*/
	@Override
	public void setClassScheduleInfo(java.lang.String classScheduleInfo) {
		_timetableCourse.setClassScheduleInfo(classScheduleInfo);
	}

	/**
	* Sets the company ID of this timetable course.
	*
	* @param companyId the company ID of this timetable course
	*/
	@Override
	public void setCompanyId(long companyId) {
		_timetableCourse.setCompanyId(companyId);
	}

	/**
	* Sets the course ID of this timetable course.
	*
	* @param courseId the course ID of this timetable course
	*/
	@Override
	public void setCourseId(long courseId) {
		_timetableCourse.setCourseId(courseId);
	}

	/**
	* Sets the create date of this timetable course.
	*
	* @param createDate the create date of this timetable course
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_timetableCourse.setCreateDate(createDate);
	}

	/**
	* Sets the description of this timetable course.
	*
	* @param description the description of this timetable course
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_timetableCourse.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_timetableCourse.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_timetableCourse.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_timetableCourse.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this timetable course.
	*
	* @param groupId the group ID of this timetable course
	*/
	@Override
	public void setGroupId(long groupId) {
		_timetableCourse.setGroupId(groupId);
	}

	/**
	* Sets the limit of this timetable course.
	*
	* @param limit the limit of this timetable course
	*/
	@Override
	public void setLimit(int limit) {
		_timetableCourse.setLimit(limit);
	}

	/**
	* Sets the modified date of this timetable course.
	*
	* @param modifiedDate the modified date of this timetable course
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_timetableCourse.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_timetableCourse.setNew(n);
	}

	/**
	* Sets the primary key of this timetable course.
	*
	* @param primaryKey the primary key of this timetable course
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_timetableCourse.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_timetableCourse.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the recommended term of this timetable course.
	*
	* @param recommendedTerm the recommended term of this timetable course
	*/
	@Override
	public void setRecommendedTerm(int recommendedTerm) {
		_timetableCourse.setRecommendedTerm(recommendedTerm);
	}

	/**
	* Sets the semester ID of this timetable course.
	*
	* @param semesterId the semester ID of this timetable course
	*/
	@Override
	public void setSemesterId(long semesterId) {
		_timetableCourse.setSemesterId(semesterId);
	}

	/**
	* Sets the subject type of this timetable course.
	*
	* @param subjectType the subject type of this timetable course
	*/
	@Override
	public void setSubjectType(java.lang.String subjectType) {
		_timetableCourse.setSubjectType(subjectType);
	}

	/**
	* Sets the timetable course code of this timetable course.
	*
	* @param timetableCourseCode the timetable course code of this timetable course
	*/
	@Override
	public void setTimetableCourseCode(java.lang.String timetableCourseCode) {
		_timetableCourse.setTimetableCourseCode(timetableCourseCode);
	}

	/**
	* Sets the timetable course ID of this timetable course.
	*
	* @param timetableCourseId the timetable course ID of this timetable course
	*/
	@Override
	public void setTimetableCourseId(long timetableCourseId) {
		_timetableCourse.setTimetableCourseId(timetableCourseId);
	}

	/**
	* Sets the user ID of this timetable course.
	*
	* @param userId the user ID of this timetable course
	*/
	@Override
	public void setUserId(long userId) {
		_timetableCourse.setUserId(userId);
	}

	/**
	* Sets the user name of this timetable course.
	*
	* @param userName the user name of this timetable course
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_timetableCourse.setUserName(userName);
	}

	/**
	* Sets the user uuid of this timetable course.
	*
	* @param userUuid the user uuid of this timetable course
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_timetableCourse.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TimetableCourseWrapper)) {
			return false;
		}

		TimetableCourseWrapper timetableCourseWrapper = (TimetableCourseWrapper)obj;

		if (Objects.equals(_timetableCourse,
					timetableCourseWrapper._timetableCourse)) {
			return true;
		}

		return false;
	}

	@Override
	public TimetableCourse getWrappedModel() {
		return _timetableCourse;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _timetableCourse.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _timetableCourse.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_timetableCourse.resetOriginalValues();
	}

	private final TimetableCourse _timetableCourse;
}