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
 * This class is a wrapper for {@link Subject}.
 * </p>
 *
 * @author Adam Kiss
 * @see Subject
 * @generated
 */
public class SubjectWrapper implements Subject, ModelWrapper<Subject> {
	public SubjectWrapper(Subject subject) {
		_subject = subject;
	}

	@Override
	public Class<?> getModelClass() {
		return Subject.class;
	}

	@Override
	public String getModelClassName() {
		return Subject.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("subjectId", getSubjectId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("subjectCode", getSubjectCode());
		attributes.put("subjectName", getSubjectName());
		attributes.put("credit", getCredit());
		attributes.put("curriculumId", getCurriculumId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long subjectId = (Long)attributes.get("subjectId");

		if (subjectId != null) {
			setSubjectId(subjectId);
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

		String subjectCode = (String)attributes.get("subjectCode");

		if (subjectCode != null) {
			setSubjectCode(subjectCode);
		}

		String subjectName = (String)attributes.get("subjectName");

		if (subjectName != null) {
			setSubjectName(subjectName);
		}

		Integer credit = (Integer)attributes.get("credit");

		if (credit != null) {
			setCredit(credit);
		}

		Long curriculumId = (Long)attributes.get("curriculumId");

		if (curriculumId != null) {
			setCurriculumId(curriculumId);
		}
	}

	/**
	* Returns the primary key of this subject.
	*
	* @return the primary key of this subject
	*/
	@Override
	public long getPrimaryKey() {
		return _subject.getPrimaryKey();
	}

	/**
	* Sets the primary key of this subject.
	*
	* @param primaryKey the primary key of this subject
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_subject.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the subject ID of this subject.
	*
	* @return the subject ID of this subject
	*/
	@Override
	public long getSubjectId() {
		return _subject.getSubjectId();
	}

	/**
	* Sets the subject ID of this subject.
	*
	* @param subjectId the subject ID of this subject
	*/
	@Override
	public void setSubjectId(long subjectId) {
		_subject.setSubjectId(subjectId);
	}

	/**
	* Returns the group ID of this subject.
	*
	* @return the group ID of this subject
	*/
	@Override
	public long getGroupId() {
		return _subject.getGroupId();
	}

	/**
	* Sets the group ID of this subject.
	*
	* @param groupId the group ID of this subject
	*/
	@Override
	public void setGroupId(long groupId) {
		_subject.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this subject.
	*
	* @return the company ID of this subject
	*/
	@Override
	public long getCompanyId() {
		return _subject.getCompanyId();
	}

	/**
	* Sets the company ID of this subject.
	*
	* @param companyId the company ID of this subject
	*/
	@Override
	public void setCompanyId(long companyId) {
		_subject.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this subject.
	*
	* @return the user ID of this subject
	*/
	@Override
	public long getUserId() {
		return _subject.getUserId();
	}

	/**
	* Sets the user ID of this subject.
	*
	* @param userId the user ID of this subject
	*/
	@Override
	public void setUserId(long userId) {
		_subject.setUserId(userId);
	}

	/**
	* Returns the user uuid of this subject.
	*
	* @return the user uuid of this subject
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subject.getUserUuid();
	}

	/**
	* Sets the user uuid of this subject.
	*
	* @param userUuid the user uuid of this subject
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_subject.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this subject.
	*
	* @return the user name of this subject
	*/
	@Override
	public java.lang.String getUserName() {
		return _subject.getUserName();
	}

	/**
	* Sets the user name of this subject.
	*
	* @param userName the user name of this subject
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_subject.setUserName(userName);
	}

	/**
	* Returns the create date of this subject.
	*
	* @return the create date of this subject
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _subject.getCreateDate();
	}

	/**
	* Sets the create date of this subject.
	*
	* @param createDate the create date of this subject
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_subject.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this subject.
	*
	* @return the modified date of this subject
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _subject.getModifiedDate();
	}

	/**
	* Sets the modified date of this subject.
	*
	* @param modifiedDate the modified date of this subject
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_subject.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the subject code of this subject.
	*
	* @return the subject code of this subject
	*/
	@Override
	public java.lang.String getSubjectCode() {
		return _subject.getSubjectCode();
	}

	/**
	* Sets the subject code of this subject.
	*
	* @param subjectCode the subject code of this subject
	*/
	@Override
	public void setSubjectCode(java.lang.String subjectCode) {
		_subject.setSubjectCode(subjectCode);
	}

	/**
	* Returns the subject name of this subject.
	*
	* @return the subject name of this subject
	*/
	@Override
	public java.lang.String getSubjectName() {
		return _subject.getSubjectName();
	}

	/**
	* Sets the subject name of this subject.
	*
	* @param subjectName the subject name of this subject
	*/
	@Override
	public void setSubjectName(java.lang.String subjectName) {
		_subject.setSubjectName(subjectName);
	}

	/**
	* Returns the credit of this subject.
	*
	* @return the credit of this subject
	*/
	@Override
	public int getCredit() {
		return _subject.getCredit();
	}

	/**
	* Sets the credit of this subject.
	*
	* @param credit the credit of this subject
	*/
	@Override
	public void setCredit(int credit) {
		_subject.setCredit(credit);
	}

	/**
	* Returns the curriculum ID of this subject.
	*
	* @return the curriculum ID of this subject
	*/
	@Override
	public long getCurriculumId() {
		return _subject.getCurriculumId();
	}

	/**
	* Sets the curriculum ID of this subject.
	*
	* @param curriculumId the curriculum ID of this subject
	*/
	@Override
	public void setCurriculumId(long curriculumId) {
		_subject.setCurriculumId(curriculumId);
	}

	@Override
	public boolean isNew() {
		return _subject.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_subject.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _subject.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_subject.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _subject.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _subject.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_subject.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _subject.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_subject.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_subject.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_subject.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SubjectWrapper((Subject)_subject.clone());
	}

	@Override
	public int compareTo(hu.unideb.inf.model.Subject subject) {
		return _subject.compareTo(subject);
	}

	@Override
	public int hashCode() {
		return _subject.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<hu.unideb.inf.model.Subject> toCacheModel() {
		return _subject.toCacheModel();
	}

	@Override
	public hu.unideb.inf.model.Subject toEscapedModel() {
		return new SubjectWrapper(_subject.toEscapedModel());
	}

	@Override
	public hu.unideb.inf.model.Subject toUnescapedModel() {
		return new SubjectWrapper(_subject.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _subject.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _subject.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_subject.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubjectWrapper)) {
			return false;
		}

		SubjectWrapper subjectWrapper = (SubjectWrapper)obj;

		if (Validator.equals(_subject, subjectWrapper._subject)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Subject getWrappedSubject() {
		return _subject;
	}

	@Override
	public Subject getWrappedModel() {
		return _subject;
	}

	@Override
	public void resetOriginalValues() {
		_subject.resetOriginalValues();
	}

	private Subject _subject;
}