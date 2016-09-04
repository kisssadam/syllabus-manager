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
 * This class is a wrapper for {@link Curriculum}.
 * </p>
 *
 * @author Adam Kiss
 * @see Curriculum
 * @generated
 */
@ProviderType
public class CurriculumWrapper implements Curriculum, ModelWrapper<Curriculum> {
	public CurriculumWrapper(Curriculum curriculum) {
		_curriculum = curriculum;
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
	public boolean isCachedModel() {
		return _curriculum.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _curriculum.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _curriculum.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _curriculum.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<hu.unideb.inf.model.Curriculum> toCacheModel() {
		return _curriculum.toCacheModel();
	}

	@Override
	public hu.unideb.inf.model.Curriculum toEscapedModel() {
		return new CurriculumWrapper(_curriculum.toEscapedModel());
	}

	@Override
	public hu.unideb.inf.model.Curriculum toUnescapedModel() {
		return new CurriculumWrapper(_curriculum.toUnescapedModel());
	}

	@Override
	public int compareTo(hu.unideb.inf.model.Curriculum curriculum) {
		return _curriculum.compareTo(curriculum);
	}

	@Override
	public int hashCode() {
		return _curriculum.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _curriculum.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CurriculumWrapper((Curriculum)_curriculum.clone());
	}

	/**
	* Returns the curriculum code of this curriculum.
	*
	* @return the curriculum code of this curriculum
	*/
	@Override
	public java.lang.String getCurriculumCode() {
		return _curriculum.getCurriculumCode();
	}

	/**
	* Returns the curriculum name of this curriculum.
	*
	* @return the curriculum name of this curriculum
	*/
	@Override
	public java.lang.String getCurriculumName() {
		return _curriculum.getCurriculumName();
	}

	/**
	* Returns the user name of this curriculum.
	*
	* @return the user name of this curriculum
	*/
	@Override
	public java.lang.String getUserName() {
		return _curriculum.getUserName();
	}

	/**
	* Returns the user uuid of this curriculum.
	*
	* @return the user uuid of this curriculum
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _curriculum.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _curriculum.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _curriculum.toXmlString();
	}

	/**
	* Returns the create date of this curriculum.
	*
	* @return the create date of this curriculum
	*/
	@Override
	public Date getCreateDate() {
		return _curriculum.getCreateDate();
	}

	/**
	* Returns the modified date of this curriculum.
	*
	* @return the modified date of this curriculum
	*/
	@Override
	public Date getModifiedDate() {
		return _curriculum.getModifiedDate();
	}

	/**
	* Returns the company ID of this curriculum.
	*
	* @return the company ID of this curriculum
	*/
	@Override
	public long getCompanyId() {
		return _curriculum.getCompanyId();
	}

	/**
	* Returns the curriculum ID of this curriculum.
	*
	* @return the curriculum ID of this curriculum
	*/
	@Override
	public long getCurriculumId() {
		return _curriculum.getCurriculumId();
	}

	/**
	* Returns the group ID of this curriculum.
	*
	* @return the group ID of this curriculum
	*/
	@Override
	public long getGroupId() {
		return _curriculum.getGroupId();
	}

	/**
	* Returns the primary key of this curriculum.
	*
	* @return the primary key of this curriculum
	*/
	@Override
	public long getPrimaryKey() {
		return _curriculum.getPrimaryKey();
	}

	/**
	* Returns the user ID of this curriculum.
	*
	* @return the user ID of this curriculum
	*/
	@Override
	public long getUserId() {
		return _curriculum.getUserId();
	}

	@Override
	public void persist() {
		_curriculum.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_curriculum.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this curriculum.
	*
	* @param companyId the company ID of this curriculum
	*/
	@Override
	public void setCompanyId(long companyId) {
		_curriculum.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this curriculum.
	*
	* @param createDate the create date of this curriculum
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_curriculum.setCreateDate(createDate);
	}

	/**
	* Sets the curriculum code of this curriculum.
	*
	* @param curriculumCode the curriculum code of this curriculum
	*/
	@Override
	public void setCurriculumCode(java.lang.String curriculumCode) {
		_curriculum.setCurriculumCode(curriculumCode);
	}

	/**
	* Sets the curriculum ID of this curriculum.
	*
	* @param curriculumId the curriculum ID of this curriculum
	*/
	@Override
	public void setCurriculumId(long curriculumId) {
		_curriculum.setCurriculumId(curriculumId);
	}

	/**
	* Sets the curriculum name of this curriculum.
	*
	* @param curriculumName the curriculum name of this curriculum
	*/
	@Override
	public void setCurriculumName(java.lang.String curriculumName) {
		_curriculum.setCurriculumName(curriculumName);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_curriculum.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_curriculum.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_curriculum.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this curriculum.
	*
	* @param groupId the group ID of this curriculum
	*/
	@Override
	public void setGroupId(long groupId) {
		_curriculum.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this curriculum.
	*
	* @param modifiedDate the modified date of this curriculum
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_curriculum.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_curriculum.setNew(n);
	}

	/**
	* Sets the primary key of this curriculum.
	*
	* @param primaryKey the primary key of this curriculum
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_curriculum.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_curriculum.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this curriculum.
	*
	* @param userId the user ID of this curriculum
	*/
	@Override
	public void setUserId(long userId) {
		_curriculum.setUserId(userId);
	}

	/**
	* Sets the user name of this curriculum.
	*
	* @param userName the user name of this curriculum
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_curriculum.setUserName(userName);
	}

	/**
	* Sets the user uuid of this curriculum.
	*
	* @param userUuid the user uuid of this curriculum
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_curriculum.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CurriculumWrapper)) {
			return false;
		}

		CurriculumWrapper curriculumWrapper = (CurriculumWrapper)obj;

		if (Objects.equals(_curriculum, curriculumWrapper._curriculum)) {
			return true;
		}

		return false;
	}

	@Override
	public Curriculum getWrappedModel() {
		return _curriculum;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _curriculum.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _curriculum.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_curriculum.resetOriginalValues();
	}

	private final Curriculum _curriculum;
}