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
 * This class is a wrapper for {@link Curriculum}.
 * </p>
 *
 * @author Adam Kiss
 * @see Curriculum
 * @generated
 */
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
	* Sets the primary key of this curriculum.
	*
	* @param primaryKey the primary key of this curriculum
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_curriculum.setPrimaryKey(primaryKey);
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
	* Sets the curriculum ID of this curriculum.
	*
	* @param curriculumId the curriculum ID of this curriculum
	*/
	@Override
	public void setCurriculumId(long curriculumId) {
		_curriculum.setCurriculumId(curriculumId);
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
	* Sets the group ID of this curriculum.
	*
	* @param groupId the group ID of this curriculum
	*/
	@Override
	public void setGroupId(long groupId) {
		_curriculum.setGroupId(groupId);
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
	* Sets the company ID of this curriculum.
	*
	* @param companyId the company ID of this curriculum
	*/
	@Override
	public void setCompanyId(long companyId) {
		_curriculum.setCompanyId(companyId);
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
	* Returns the user uuid of this curriculum.
	*
	* @return the user uuid of this curriculum
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _curriculum.getUserUuid();
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
	* Sets the user name of this curriculum.
	*
	* @param userName the user name of this curriculum
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_curriculum.setUserName(userName);
	}

	/**
	* Returns the create date of this curriculum.
	*
	* @return the create date of this curriculum
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _curriculum.getCreateDate();
	}

	/**
	* Sets the create date of this curriculum.
	*
	* @param createDate the create date of this curriculum
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_curriculum.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this curriculum.
	*
	* @return the modified date of this curriculum
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _curriculum.getModifiedDate();
	}

	/**
	* Sets the modified date of this curriculum.
	*
	* @param modifiedDate the modified date of this curriculum
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_curriculum.setModifiedDate(modifiedDate);
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
	* Sets the curriculum code of this curriculum.
	*
	* @param curriculumCode the curriculum code of this curriculum
	*/
	@Override
	public void setCurriculumCode(java.lang.String curriculumCode) {
		_curriculum.setCurriculumCode(curriculumCode);
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
	* Sets the curriculum name of this curriculum.
	*
	* @param curriculumName the curriculum name of this curriculum
	*/
	@Override
	public void setCurriculumName(java.lang.String curriculumName) {
		_curriculum.setCurriculumName(curriculumName);
	}

	@Override
	public boolean isNew() {
		return _curriculum.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_curriculum.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _curriculum.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_curriculum.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _curriculum.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _curriculum.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_curriculum.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _curriculum.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_curriculum.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_curriculum.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_curriculum.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CurriculumWrapper((Curriculum)_curriculum.clone());
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
	public com.liferay.portal.model.CacheModel<hu.unideb.inf.model.Curriculum> toCacheModel() {
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
	public java.lang.String toString() {
		return _curriculum.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _curriculum.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_curriculum.persist();
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

		if (Validator.equals(_curriculum, curriculumWrapper._curriculum)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Curriculum getWrappedCurriculum() {
		return _curriculum;
	}

	@Override
	public Curriculum getWrappedModel() {
		return _curriculum;
	}

	@Override
	public void resetOriginalValues() {
		_curriculum.resetOriginalValues();
	}

	private Curriculum _curriculum;
}