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
 * This class is a wrapper for {@link CourseType}.
 * </p>
 *
 * @author Adam Kiss
 * @see CourseType
 * @generated
 */
@ProviderType
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
		attributes.put("typeName", getTypeName());

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

		String typeName = (String)attributes.get("typeName");

		if (typeName != null) {
			setTypeName(typeName);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _courseType.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _courseType.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _courseType.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _courseType.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<hu.unideb.inf.model.CourseType> toCacheModel() {
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
	public int compareTo(hu.unideb.inf.model.CourseType courseType) {
		return _courseType.compareTo(courseType);
	}

	@Override
	public int hashCode() {
		return _courseType.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _courseType.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CourseTypeWrapper((CourseType)_courseType.clone());
	}

	/**
	* Returns the type name of this course type.
	*
	* @return the type name of this course type
	*/
	@Override
	public java.lang.String getTypeName() {
		return _courseType.getTypeName();
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
	* Returns the user uuid of this course type.
	*
	* @return the user uuid of this course type
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _courseType.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _courseType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _courseType.toXmlString();
	}

	/**
	* Returns the create date of this course type.
	*
	* @return the create date of this course type
	*/
	@Override
	public Date getCreateDate() {
		return _courseType.getCreateDate();
	}

	/**
	* Returns the modified date of this course type.
	*
	* @return the modified date of this course type
	*/
	@Override
	public Date getModifiedDate() {
		return _courseType.getModifiedDate();
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
	* Returns the course type ID of this course type.
	*
	* @return the course type ID of this course type
	*/
	@Override
	public long getCourseTypeId() {
		return _courseType.getCourseTypeId();
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
	* Returns the primary key of this course type.
	*
	* @return the primary key of this course type
	*/
	@Override
	public long getPrimaryKey() {
		return _courseType.getPrimaryKey();
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

	@Override
	public void persist() {
		_courseType.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_courseType.setCachedModel(cachedModel);
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
	* Sets the course type ID of this course type.
	*
	* @param courseTypeId the course type ID of this course type
	*/
	@Override
	public void setCourseTypeId(long courseTypeId) {
		_courseType.setCourseTypeId(courseTypeId);
	}

	/**
	* Sets the create date of this course type.
	*
	* @param createDate the create date of this course type
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_courseType.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_courseType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_courseType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_courseType.setExpandoBridgeAttributes(serviceContext);
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
	* Sets the modified date of this course type.
	*
	* @param modifiedDate the modified date of this course type
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_courseType.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_courseType.setNew(n);
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

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_courseType.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the type name of this course type.
	*
	* @param typeName the type name of this course type
	*/
	@Override
	public void setTypeName(java.lang.String typeName) {
		_courseType.setTypeName(typeName);
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
	* Sets the user name of this course type.
	*
	* @param userName the user name of this course type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_courseType.setUserName(userName);
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CourseTypeWrapper)) {
			return false;
		}

		CourseTypeWrapper courseTypeWrapper = (CourseTypeWrapper)obj;

		if (Objects.equals(_courseType, courseTypeWrapper._courseType)) {
			return true;
		}

		return false;
	}

	@Override
	public CourseType getWrappedModel() {
		return _courseType;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _courseType.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _courseType.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_courseType.resetOriginalValues();
	}

	private final CourseType _courseType;
}