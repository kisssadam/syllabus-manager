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
 * This class is a wrapper for {@link Semester}.
 * </p>
 *
 * @author Adam Kiss
 * @see Semester
 * @generated
 */
@ProviderType
public class SemesterWrapper implements Semester, ModelWrapper<Semester> {
	public SemesterWrapper(Semester semester) {
		_semester = semester;
	}

	@Override
	public Class<?> getModelClass() {
		return Semester.class;
	}

	@Override
	public String getModelClassName() {
		return Semester.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("semesterId", getSemesterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("beginYear", getBeginYear());
		attributes.put("endYear", getEndYear());
		attributes.put("division", getDivision());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long semesterId = (Long)attributes.get("semesterId");

		if (semesterId != null) {
			setSemesterId(semesterId);
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

		Integer beginYear = (Integer)attributes.get("beginYear");

		if (beginYear != null) {
			setBeginYear(beginYear);
		}

		Integer endYear = (Integer)attributes.get("endYear");

		if (endYear != null) {
			setEndYear(endYear);
		}

		Integer division = (Integer)attributes.get("division");

		if (division != null) {
			setDivision(division);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _semester.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _semester.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _semester.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _semester.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<hu.unideb.inf.model.Semester> toCacheModel() {
		return _semester.toCacheModel();
	}

	@Override
	public hu.unideb.inf.model.Semester toEscapedModel() {
		return new SemesterWrapper(_semester.toEscapedModel());
	}

	@Override
	public hu.unideb.inf.model.Semester toUnescapedModel() {
		return new SemesterWrapper(_semester.toUnescapedModel());
	}

	@Override
	public int compareTo(hu.unideb.inf.model.Semester semester) {
		return _semester.compareTo(semester);
	}

	/**
	* Returns the begin year of this semester.
	*
	* @return the begin year of this semester
	*/
	@Override
	public int getBeginYear() {
		return _semester.getBeginYear();
	}

	/**
	* Returns the division of this semester.
	*
	* @return the division of this semester
	*/
	@Override
	public int getDivision() {
		return _semester.getDivision();
	}

	/**
	* Returns the end year of this semester.
	*
	* @return the end year of this semester
	*/
	@Override
	public int getEndYear() {
		return _semester.getEndYear();
	}

	@Override
	public int getNextBeginYear() {
		return _semester.getNextBeginYear();
	}

	@Override
	public int getNextDivision() {
		return _semester.getNextDivision();
	}

	@Override
	public int getNextEndYear() {
		return _semester.getNextEndYear();
	}

	@Override
	public int hashCode() {
		return _semester.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _semester.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new SemesterWrapper((Semester)_semester.clone());
	}

	/**
	* Returns the user name of this semester.
	*
	* @return the user name of this semester
	*/
	@Override
	public java.lang.String getUserName() {
		return _semester.getUserName();
	}

	/**
	* Returns the user uuid of this semester.
	*
	* @return the user uuid of this semester
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _semester.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _semester.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _semester.toXmlString();
	}

	/**
	* Returns the create date of this semester.
	*
	* @return the create date of this semester
	*/
	@Override
	public Date getCreateDate() {
		return _semester.getCreateDate();
	}

	/**
	* Returns the modified date of this semester.
	*
	* @return the modified date of this semester
	*/
	@Override
	public Date getModifiedDate() {
		return _semester.getModifiedDate();
	}

	/**
	* Returns the company ID of this semester.
	*
	* @return the company ID of this semester
	*/
	@Override
	public long getCompanyId() {
		return _semester.getCompanyId();
	}

	/**
	* Returns the group ID of this semester.
	*
	* @return the group ID of this semester
	*/
	@Override
	public long getGroupId() {
		return _semester.getGroupId();
	}

	/**
	* Returns the primary key of this semester.
	*
	* @return the primary key of this semester
	*/
	@Override
	public long getPrimaryKey() {
		return _semester.getPrimaryKey();
	}

	/**
	* Returns the semester ID of this semester.
	*
	* @return the semester ID of this semester
	*/
	@Override
	public long getSemesterId() {
		return _semester.getSemesterId();
	}

	/**
	* Returns the user ID of this semester.
	*
	* @return the user ID of this semester
	*/
	@Override
	public long getUserId() {
		return _semester.getUserId();
	}

	@Override
	public void persist() {
		_semester.persist();
	}

	/**
	* Sets the begin year of this semester.
	*
	* @param beginYear the begin year of this semester
	*/
	@Override
	public void setBeginYear(int beginYear) {
		_semester.setBeginYear(beginYear);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_semester.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this semester.
	*
	* @param companyId the company ID of this semester
	*/
	@Override
	public void setCompanyId(long companyId) {
		_semester.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this semester.
	*
	* @param createDate the create date of this semester
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_semester.setCreateDate(createDate);
	}

	/**
	* Sets the division of this semester.
	*
	* @param division the division of this semester
	*/
	@Override
	public void setDivision(int division) {
		_semester.setDivision(division);
	}

	/**
	* Sets the end year of this semester.
	*
	* @param endYear the end year of this semester
	*/
	@Override
	public void setEndYear(int endYear) {
		_semester.setEndYear(endYear);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_semester.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_semester.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_semester.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this semester.
	*
	* @param groupId the group ID of this semester
	*/
	@Override
	public void setGroupId(long groupId) {
		_semester.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this semester.
	*
	* @param modifiedDate the modified date of this semester
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_semester.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_semester.setNew(n);
	}

	/**
	* Sets the primary key of this semester.
	*
	* @param primaryKey the primary key of this semester
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_semester.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_semester.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the semester ID of this semester.
	*
	* @param semesterId the semester ID of this semester
	*/
	@Override
	public void setSemesterId(long semesterId) {
		_semester.setSemesterId(semesterId);
	}

	/**
	* Sets the user ID of this semester.
	*
	* @param userId the user ID of this semester
	*/
	@Override
	public void setUserId(long userId) {
		_semester.setUserId(userId);
	}

	/**
	* Sets the user name of this semester.
	*
	* @param userName the user name of this semester
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_semester.setUserName(userName);
	}

	/**
	* Sets the user uuid of this semester.
	*
	* @param userUuid the user uuid of this semester
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_semester.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SemesterWrapper)) {
			return false;
		}

		SemesterWrapper semesterWrapper = (SemesterWrapper)obj;

		if (Objects.equals(_semester, semesterWrapper._semester)) {
			return true;
		}

		return false;
	}

	@Override
	public Semester getWrappedModel() {
		return _semester;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _semester.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _semester.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_semester.resetOriginalValues();
	}

	private final Semester _semester;
}