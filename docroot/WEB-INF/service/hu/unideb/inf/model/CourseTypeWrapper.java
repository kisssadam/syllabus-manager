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
 * This class is a wrapper for {@link CourseType}.
 * </p>
 *
 * @author Adam Kiss
 * @see CourseType
 * @generated
 */
public class CourseTypeWrapper implements CourseType, ModelWrapper<CourseType> {
	public CourseTypeWrapper(CourseType courseType) {
		_courseType = courseType;
	}

	@Override
	public Class<?> getModelClass() {
		return CourseType.class;
	}

	@Override
	public String getModelClassName() {
		return CourseType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("courseTypeId", getCourseTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long courseTypeId = (Long)attributes.get("courseTypeId");

		if (courseTypeId != null) {
			setCourseTypeId(courseTypeId);
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

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	/**
	* Returns the primary key of this course type.
	*
	* @return the primary key of this course type
	*/
	@Override
	public long getPrimaryKey() {
		return _courseType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this course type.
	*
	* @param primaryKey the primary key of this course type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_courseType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the course type ID of this course type.
	*
	* @return the course type ID of this course type
	*/
	@Override
	public long getCourseTypeId() {
		return _courseType.getCourseTypeId();
	}

	/**
	* Sets the course type ID of this course type.
	*
	* @param courseTypeId the course type ID of this course type
	*/
	@Override
	public void setCourseTypeId(long courseTypeId) {
		_courseType.setCourseTypeId(courseTypeId);
	}

	/**
	* Returns the group ID of this course type.
	*
	* @return the group ID of this course type
	*/
	@Override
	public long getGroupId() {
		return _courseType.getGroupId();
	}

	/**
	* Sets the group ID of this course type.
	*
	* @param groupId the group ID of this course type
	*/
	@Override
	public void setGroupId(long groupId) {
		_courseType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this course type.
	*
	* @return the company ID of this course type
	*/
	@Override
	public long getCompanyId() {
		return _courseType.getCompanyId();
	}

	/**
	* Sets the company ID of this course type.
	*
	* @param companyId the company ID of this course type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_courseType.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this course type.
	*
	* @return the user ID of this course type
	*/
	@Override
	public long getUserId() {
		return _courseType.getUserId();
	}

	/**
	* Sets the user ID of this course type.
	*
	* @param userId the user ID of this course type
	*/
	@Override
	public void setUserId(long userId) {
		_courseType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this course type.
	*
	* @return the user uuid of this course type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseType.getUserUuid();
	}

	/**
	* Sets the user uuid of this course type.
	*
	* @param userUuid the user uuid of this course type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_courseType.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this course type.
	*
	* @return the user name of this course type
	*/
	@Override
	public java.lang.String getUserName() {
		return _courseType.getUserName();
	}

	/**
	* Sets the user name of this course type.
	*
	* @param userName the user name of this course type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_courseType.setUserName(userName);
	}

	/**
	* Returns the create date of this course type.
	*
	* @return the create date of this course type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _courseType.getCreateDate();
	}

	/**
	* Sets the create date of this course type.
	*
	* @param createDate the create date of this course type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_courseType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this course type.
	*
	* @return the modified date of this course type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _courseType.getModifiedDate();
	}

	/**
	* Sets the modified date of this course type.
	*
	* @param modifiedDate the modified date of this course type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_courseType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the type of this course type.
	*
	* @return the type of this course type
	*/
	@Override
	public java.lang.String getType() {
		return _courseType.getType();
	}

	/**
	* Sets the type of this course type.
	*
	* @param type the type of this course type
	*/
	@Override
	public void setType(java.lang.String type) {
		_courseType.setType(type);
	}

	@Override
	public boolean isNew() {
		return _courseType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_courseType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _courseType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_courseType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _courseType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _courseType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_courseType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _courseType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_courseType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_courseType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_courseType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CourseTypeWrapper((CourseType)_courseType.clone());
	}

	@Override
	public int compareTo(hu.unideb.inf.model.CourseType courseType) {
		return _courseType.compareTo(courseType);
	}

	@Override
	public int hashCode() {
		return _courseType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<hu.unideb.inf.model.CourseType> toCacheModel() {
		return _courseType.toCacheModel();
	}

	@Override
	public hu.unideb.inf.model.CourseType toEscapedModel() {
		return new CourseTypeWrapper(_courseType.toEscapedModel());
	}

	@Override
	public hu.unideb.inf.model.CourseType toUnescapedModel() {
		return new CourseTypeWrapper(_courseType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _courseType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _courseType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_courseType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CourseTypeWrapper)) {
			return false;
		}

		CourseTypeWrapper courseTypeWrapper = (CourseTypeWrapper)obj;

		if (Validator.equals(_courseType, courseTypeWrapper._courseType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CourseType getWrappedCourseType() {
		return _courseType;
	}

	@Override
	public CourseType getWrappedModel() {
		return _courseType;
	}

	@Override
	public void resetOriginalValues() {
		_courseType.resetOriginalValues();
	}

	private CourseType _courseType;
}