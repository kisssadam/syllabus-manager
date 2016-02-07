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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TimetableCourse}.
 * </p>
 *
 * @author Adam Kiss
 * @see TimetableCourse
 * @generated
 */
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
	* Sets the primary key of this timetable course.
	*
	* @param primaryKey the primary key of this timetable course
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_timetableCourse.setPrimaryKey(primaryKey);
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
	* Sets the timetable course ID of this timetable course.
	*
	* @param timetableCourseId the timetable course ID of this timetable course
	*/
	@Override
	public void setTimetableCourseId(long timetableCourseId) {
		_timetableCourse.setTimetableCourseId(timetableCourseId);
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
	* Sets the group ID of this timetable course.
	*
	* @param groupId the group ID of this timetable course
	*/
	@Override
	public void setGroupId(long groupId) {
		_timetableCourse.setGroupId(groupId);
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
	* Sets the company ID of this timetable course.
	*
	* @param companyId the company ID of this timetable course
	*/
	@Override
	public void setCompanyId(long companyId) {
		_timetableCourse.setCompanyId(companyId);
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
	* Returns the user uuid of this timetable course.
	*
	* @return the user uuid of this timetable course
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timetableCourse.getUserUuid();
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
	* Sets the user name of this timetable course.
	*
	* @param userName the user name of this timetable course
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_timetableCourse.setUserName(userName);
	}

	/**
	* Returns the create date of this timetable course.
	*
	* @return the create date of this timetable course
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _timetableCourse.getCreateDate();
	}

	/**
	* Sets the create date of this timetable course.
	*
	* @param createDate the create date of this timetable course
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_timetableCourse.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this timetable course.
	*
	* @return the modified date of this timetable course
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _timetableCourse.getModifiedDate();
	}

	/**
	* Sets the modified date of this timetable course.
	*
	* @param modifiedDate the modified date of this timetable course
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_timetableCourse.setModifiedDate(modifiedDate);
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
	* Sets the course ID of this timetable course.
	*
	* @param courseId the course ID of this timetable course
	*/
	@Override
	public void setCourseId(long courseId) {
		_timetableCourse.setCourseId(courseId);
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
	* Sets the subject type of this timetable course.
	*
	* @param subjectType the subject type of this timetable course
	*/
	@Override
	public void setSubjectType(java.lang.String subjectType) {
		_timetableCourse.setSubjectType(subjectType);
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
	* Returns the limit of this timetable course.
	*
	* @return the limit of this timetable course
	*/
	@Override
	public int getLimit() {
		return _timetableCourse.getLimit();
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
	* Returns the class schedule info of this timetable course.
	*
	* @return the class schedule info of this timetable course
	*/
	@Override
	public java.lang.String getClassScheduleInfo() {
		return _timetableCourse.getClassScheduleInfo();
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
	* Returns the description of this timetable course.
	*
	* @return the description of this timetable course
	*/
	@Override
	public java.lang.String getDescription() {
		return _timetableCourse.getDescription();
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
	public boolean isNew() {
		return _timetableCourse.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_timetableCourse.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _timetableCourse.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_timetableCourse.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _timetableCourse.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _timetableCourse.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_timetableCourse.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _timetableCourse.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_timetableCourse.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_timetableCourse.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_timetableCourse.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TimetableCourseWrapper((TimetableCourse)_timetableCourse.clone());
	}

	@Override
	public int compareTo(hu.unideb.inf.model.TimetableCourse timetableCourse) {
		return _timetableCourse.compareTo(timetableCourse);
	}

	@Override
	public int hashCode() {
		return _timetableCourse.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<hu.unideb.inf.model.TimetableCourse> toCacheModel() {
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
	public java.lang.String toString() {
		return _timetableCourse.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _timetableCourse.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_timetableCourse.persist();
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

		if (Validator.equals(_timetableCourse,
					timetableCourseWrapper._timetableCourse)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TimetableCourse getWrappedTimetableCourse() {
		return _timetableCourse;
	}

	@Override
	public TimetableCourse getWrappedModel() {
		return _timetableCourse;
	}

	@Override
	public void resetOriginalValues() {
		_timetableCourse.resetOriginalValues();
	}

	private TimetableCourse _timetableCourse;
}