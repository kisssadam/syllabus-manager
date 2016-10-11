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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link hu.unideb.inf.service.http.SyllabusServiceSoap}.
 *
 * @author Adam Kiss
 * @see hu.unideb.inf.service.http.SyllabusServiceSoap
 * @generated
 */
@ProviderType
public class SyllabusSoap implements Serializable {
	public static SyllabusSoap toSoapModel(Syllabus model) {
		SyllabusSoap soapModel = new SyllabusSoap();

		soapModel.setSyllabusId(model.getSyllabusId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTimetableCourseId(model.getTimetableCourseId());
		soapModel.setSemesterId(model.getSemesterId());
		soapModel.setCompetence(model.getCompetence());
		soapModel.setEthicalStandards(model.getEthicalStandards());
		soapModel.setTopics(model.getTopics());
		soapModel.setEducationalMaterials(model.getEducationalMaterials());
		soapModel.setRecommendedLiterature(model.getRecommendedLiterature());

		return soapModel;
	}

	public static SyllabusSoap[] toSoapModels(Syllabus[] models) {
		SyllabusSoap[] soapModels = new SyllabusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SyllabusSoap[][] toSoapModels(Syllabus[][] models) {
		SyllabusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SyllabusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SyllabusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SyllabusSoap[] toSoapModels(List<Syllabus> models) {
		List<SyllabusSoap> soapModels = new ArrayList<SyllabusSoap>(models.size());

		for (Syllabus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SyllabusSoap[soapModels.size()]);
	}

	public SyllabusSoap() {
	}

	public long getPrimaryKey() {
		return _syllabusId;
	}

	public void setPrimaryKey(long pk) {
		setSyllabusId(pk);
	}

	public long getSyllabusId() {
		return _syllabusId;
	}

	public void setSyllabusId(long syllabusId) {
		_syllabusId = syllabusId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getTimetableCourseId() {
		return _timetableCourseId;
	}

	public void setTimetableCourseId(long timetableCourseId) {
		_timetableCourseId = timetableCourseId;
	}

	public long getSemesterId() {
		return _semesterId;
	}

	public void setSemesterId(long semesterId) {
		_semesterId = semesterId;
	}

	public String getCompetence() {
		return _competence;
	}

	public void setCompetence(String competence) {
		_competence = competence;
	}

	public String getEthicalStandards() {
		return _ethicalStandards;
	}

	public void setEthicalStandards(String ethicalStandards) {
		_ethicalStandards = ethicalStandards;
	}

	public String getTopics() {
		return _topics;
	}

	public void setTopics(String topics) {
		_topics = topics;
	}

	public String getEducationalMaterials() {
		return _educationalMaterials;
	}

	public void setEducationalMaterials(String educationalMaterials) {
		_educationalMaterials = educationalMaterials;
	}

	public String getRecommendedLiterature() {
		return _recommendedLiterature;
	}

	public void setRecommendedLiterature(String recommendedLiterature) {
		_recommendedLiterature = recommendedLiterature;
	}

	private long _syllabusId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _timetableCourseId;
	private long _semesterId;
	private String _competence;
	private String _ethicalStandards;
	private String _topics;
	private String _educationalMaterials;
	private String _recommendedLiterature;
}