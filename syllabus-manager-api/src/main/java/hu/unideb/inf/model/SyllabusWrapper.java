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
 * This class is a wrapper for {@link Syllabus}.
 * </p>
 *
 * @author Adam Kiss
 * @see Syllabus
 * @generated
 */
@ProviderType
public class SyllabusWrapper implements Syllabus, ModelWrapper<Syllabus> {
	public SyllabusWrapper(Syllabus syllabus) {
		_syllabus = syllabus;
	}

	@Override
	public Class<?> getModelClass() {
		return Syllabus.class;
	}

	@Override
	public String getModelClassName() {
		return Syllabus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("syllabusId", getSyllabusId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("timetableCourseId", getTimetableCourseId());
		attributes.put("competence", getCompetence());
		attributes.put("ethicalStandards", getEthicalStandards());
		attributes.put("topics", getTopics());
		attributes.put("educationalMaterials", getEducationalMaterials());
		attributes.put("recommendedLiterature", getRecommendedLiterature());
		attributes.put("weeklyTasks", getWeeklyTasks());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long syllabusId = (Long)attributes.get("syllabusId");

		if (syllabusId != null) {
			setSyllabusId(syllabusId);
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

		Long timetableCourseId = (Long)attributes.get("timetableCourseId");

		if (timetableCourseId != null) {
			setTimetableCourseId(timetableCourseId);
		}

		String competence = (String)attributes.get("competence");

		if (competence != null) {
			setCompetence(competence);
		}

		String ethicalStandards = (String)attributes.get("ethicalStandards");

		if (ethicalStandards != null) {
			setEthicalStandards(ethicalStandards);
		}

		String topics = (String)attributes.get("topics");

		if (topics != null) {
			setTopics(topics);
		}

		String educationalMaterials = (String)attributes.get(
				"educationalMaterials");

		if (educationalMaterials != null) {
			setEducationalMaterials(educationalMaterials);
		}

		String recommendedLiterature = (String)attributes.get(
				"recommendedLiterature");

		if (recommendedLiterature != null) {
			setRecommendedLiterature(recommendedLiterature);
		}

		String weeklyTasks = (String)attributes.get("weeklyTasks");

		if (weeklyTasks != null) {
			setWeeklyTasks(weeklyTasks);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _syllabus.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _syllabus.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _syllabus.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _syllabus.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<hu.unideb.inf.model.Syllabus> toCacheModel() {
		return _syllabus.toCacheModel();
	}

	@Override
	public hu.unideb.inf.model.Syllabus toEscapedModel() {
		return new SyllabusWrapper(_syllabus.toEscapedModel());
	}

	@Override
	public hu.unideb.inf.model.Syllabus toUnescapedModel() {
		return new SyllabusWrapper(_syllabus.toUnescapedModel());
	}

	@Override
	public int compareTo(hu.unideb.inf.model.Syllabus syllabus) {
		return _syllabus.compareTo(syllabus);
	}

	@Override
	public int hashCode() {
		return _syllabus.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _syllabus.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new SyllabusWrapper((Syllabus)_syllabus.clone());
	}

	/**
	* Returns the competence of this syllabus.
	*
	* @return the competence of this syllabus
	*/
	@Override
	public java.lang.String getCompetence() {
		return _syllabus.getCompetence();
	}

	/**
	* Returns the educational materials of this syllabus.
	*
	* @return the educational materials of this syllabus
	*/
	@Override
	public java.lang.String getEducationalMaterials() {
		return _syllabus.getEducationalMaterials();
	}

	/**
	* Returns the ethical standards of this syllabus.
	*
	* @return the ethical standards of this syllabus
	*/
	@Override
	public java.lang.String getEthicalStandards() {
		return _syllabus.getEthicalStandards();
	}

	/**
	* Returns the recommended literature of this syllabus.
	*
	* @return the recommended literature of this syllabus
	*/
	@Override
	public java.lang.String getRecommendedLiterature() {
		return _syllabus.getRecommendedLiterature();
	}

	/**
	* Returns the topics of this syllabus.
	*
	* @return the topics of this syllabus
	*/
	@Override
	public java.lang.String getTopics() {
		return _syllabus.getTopics();
	}

	/**
	* Returns the user name of this syllabus.
	*
	* @return the user name of this syllabus
	*/
	@Override
	public java.lang.String getUserName() {
		return _syllabus.getUserName();
	}

	/**
	* Returns the user uuid of this syllabus.
	*
	* @return the user uuid of this syllabus
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _syllabus.getUserUuid();
	}

	/**
	* Returns the weekly tasks of this syllabus.
	*
	* @return the weekly tasks of this syllabus
	*/
	@Override
	public java.lang.String getWeeklyTasks() {
		return _syllabus.getWeeklyTasks();
	}

	@Override
	public java.lang.String toString() {
		return _syllabus.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _syllabus.toXmlString();
	}

	/**
	* Returns the create date of this syllabus.
	*
	* @return the create date of this syllabus
	*/
	@Override
	public Date getCreateDate() {
		return _syllabus.getCreateDate();
	}

	/**
	* Returns the modified date of this syllabus.
	*
	* @return the modified date of this syllabus
	*/
	@Override
	public Date getModifiedDate() {
		return _syllabus.getModifiedDate();
	}

	/**
	* Returns the company ID of this syllabus.
	*
	* @return the company ID of this syllabus
	*/
	@Override
	public long getCompanyId() {
		return _syllabus.getCompanyId();
	}

	/**
	* Returns the group ID of this syllabus.
	*
	* @return the group ID of this syllabus
	*/
	@Override
	public long getGroupId() {
		return _syllabus.getGroupId();
	}

	/**
	* Returns the primary key of this syllabus.
	*
	* @return the primary key of this syllabus
	*/
	@Override
	public long getPrimaryKey() {
		return _syllabus.getPrimaryKey();
	}

	/**
	* Returns the syllabus ID of this syllabus.
	*
	* @return the syllabus ID of this syllabus
	*/
	@Override
	public long getSyllabusId() {
		return _syllabus.getSyllabusId();
	}

	/**
	* Returns the timetable course ID of this syllabus.
	*
	* @return the timetable course ID of this syllabus
	*/
	@Override
	public long getTimetableCourseId() {
		return _syllabus.getTimetableCourseId();
	}

	/**
	* Returns the user ID of this syllabus.
	*
	* @return the user ID of this syllabus
	*/
	@Override
	public long getUserId() {
		return _syllabus.getUserId();
	}

	@Override
	public void persist() {
		_syllabus.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_syllabus.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this syllabus.
	*
	* @param companyId the company ID of this syllabus
	*/
	@Override
	public void setCompanyId(long companyId) {
		_syllabus.setCompanyId(companyId);
	}

	/**
	* Sets the competence of this syllabus.
	*
	* @param competence the competence of this syllabus
	*/
	@Override
	public void setCompetence(java.lang.String competence) {
		_syllabus.setCompetence(competence);
	}

	/**
	* Sets the create date of this syllabus.
	*
	* @param createDate the create date of this syllabus
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_syllabus.setCreateDate(createDate);
	}

	/**
	* Sets the educational materials of this syllabus.
	*
	* @param educationalMaterials the educational materials of this syllabus
	*/
	@Override
	public void setEducationalMaterials(java.lang.String educationalMaterials) {
		_syllabus.setEducationalMaterials(educationalMaterials);
	}

	/**
	* Sets the ethical standards of this syllabus.
	*
	* @param ethicalStandards the ethical standards of this syllabus
	*/
	@Override
	public void setEthicalStandards(java.lang.String ethicalStandards) {
		_syllabus.setEthicalStandards(ethicalStandards);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_syllabus.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_syllabus.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_syllabus.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this syllabus.
	*
	* @param groupId the group ID of this syllabus
	*/
	@Override
	public void setGroupId(long groupId) {
		_syllabus.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this syllabus.
	*
	* @param modifiedDate the modified date of this syllabus
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_syllabus.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_syllabus.setNew(n);
	}

	/**
	* Sets the primary key of this syllabus.
	*
	* @param primaryKey the primary key of this syllabus
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_syllabus.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_syllabus.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the recommended literature of this syllabus.
	*
	* @param recommendedLiterature the recommended literature of this syllabus
	*/
	@Override
	public void setRecommendedLiterature(java.lang.String recommendedLiterature) {
		_syllabus.setRecommendedLiterature(recommendedLiterature);
	}

	/**
	* Sets the syllabus ID of this syllabus.
	*
	* @param syllabusId the syllabus ID of this syllabus
	*/
	@Override
	public void setSyllabusId(long syllabusId) {
		_syllabus.setSyllabusId(syllabusId);
	}

	/**
	* Sets the timetable course ID of this syllabus.
	*
	* @param timetableCourseId the timetable course ID of this syllabus
	*/
	@Override
	public void setTimetableCourseId(long timetableCourseId) {
		_syllabus.setTimetableCourseId(timetableCourseId);
	}

	/**
	* Sets the topics of this syllabus.
	*
	* @param topics the topics of this syllabus
	*/
	@Override
	public void setTopics(java.lang.String topics) {
		_syllabus.setTopics(topics);
	}

	/**
	* Sets the user ID of this syllabus.
	*
	* @param userId the user ID of this syllabus
	*/
	@Override
	public void setUserId(long userId) {
		_syllabus.setUserId(userId);
	}

	/**
	* Sets the user name of this syllabus.
	*
	* @param userName the user name of this syllabus
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_syllabus.setUserName(userName);
	}

	/**
	* Sets the user uuid of this syllabus.
	*
	* @param userUuid the user uuid of this syllabus
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_syllabus.setUserUuid(userUuid);
	}

	/**
	* Sets the weekly tasks of this syllabus.
	*
	* @param weeklyTasks the weekly tasks of this syllabus
	*/
	@Override
	public void setWeeklyTasks(java.lang.String weeklyTasks) {
		_syllabus.setWeeklyTasks(weeklyTasks);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SyllabusWrapper)) {
			return false;
		}

		SyllabusWrapper syllabusWrapper = (SyllabusWrapper)obj;

		if (Objects.equals(_syllabus, syllabusWrapper._syllabus)) {
			return true;
		}

		return false;
	}

	@Override
	public Syllabus getWrappedModel() {
		return _syllabus;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _syllabus.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _syllabus.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_syllabus.resetOriginalValues();
	}

	private final Syllabus _syllabus;
}