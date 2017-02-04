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

package hu.unideb.inf.service.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetLinkLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import aQute.bnd.annotation.ProviderType;
import hu.unideb.inf.model.Syllabus;
import hu.unideb.inf.service.SyllabusLocalServiceUtil;
import hu.unideb.inf.service.base.SyllabusLocalServiceBaseImpl;

/**
 * The implementation of the syllabus local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link hu.unideb.inf.service.SyllabusLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Adam Kiss
 * @see SyllabusLocalServiceBaseImpl
 * @see hu.unideb.inf.service.SyllabusLocalServiceUtil
 */
@ProviderType
public class SyllabusLocalServiceImpl extends SyllabusLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * hu.unideb.inf.service.SyllabusLocalServiceUtil} to access the syllabus
	 * local service.
	 */
	public List<Syllabus> getSyllabuses() throws SystemException {
		return syllabusPersistence.findAll();
	}

	public List<Syllabus> getSyllabusesByTimetableCourseId(long timetableCourseId) {
		return syllabusPersistence.findByTimetableCourseId(timetableCourseId);
	}

	public List<Syllabus> getSyllabusesByTimetableCourseId(long timetableCourseId, int start, int end) {
		return syllabusPersistence.findByTimetableCourseId(timetableCourseId, start, end);
	}

	public int getSyllabusesCountByTimetableCourseId(long timetableCourseId) {
		return syllabusPersistence.countByTimetableCourseId(timetableCourseId);
	}

	public Syllabus addSyllabus(long timetableCourseId, String competence, String ethicalStandards, String topics,
			String educationalMaterials, String recommendedLiterature, String weeklyTasks,
			ServiceContext serviceContext) throws PortalException, SystemException {
		Date now = new Date();

		long syllabusId = counterLocalService.increment();
		long groupId = serviceContext.getScopeGroupId();
		long companyId = serviceContext.getCompanyId();
		long userId = serviceContext.getUserId();
		User user = userPersistence.findByPrimaryKey(userId);
		String userName = user.getFullName();

		validate(syllabusId, timetableCourseId, competence, ethicalStandards, topics, educationalMaterials,
				recommendedLiterature, weeklyTasks);

		Syllabus syllabus = syllabusPersistence.create(syllabusId);

		syllabus.setUuid(serviceContext.getUuid());
		syllabus.setGroupId(groupId);
		syllabus.setCompanyId(companyId);
		syllabus.setUserId(userId);
		syllabus.setUserName(userName);
		syllabus.setCreateDate(serviceContext.getCreateDate(now));
		syllabus.setModifiedDate(serviceContext.getModifiedDate(now));
		syllabus.setSyllabusId(syllabusId);
		syllabus.setTimetableCourseId(timetableCourseId);
		syllabus.setCompetence(competence);
		syllabus.setEthicalStandards(ethicalStandards);
		syllabus.setTopics(topics);
		syllabus.setEducationalMaterials(educationalMaterials);
		syllabus.setRecommendedLiterature(recommendedLiterature);
		syllabus.setWeeklyTasks(weeklyTasks);
		syllabus.setStatus(WorkflowConstants.STATUS_PENDING);
		syllabus.setStatusByUserId(userId);
		syllabus.setStatusByUserName(user.getFullName());
		syllabus.setStatusDate(serviceContext.getModifiedDate(null));

		syllabusPersistence.update(syllabus);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, Syllabus.class.getName(), syllabusId,
				false, true, true);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId, groupId, syllabus.getCreateDate(),
				syllabus.getModifiedDate(), Syllabus.class.getName(), syllabus.getPrimaryKey(), syllabus.getUuid(), 0,
				serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), true, true, null, null,
				syllabus.getCreateDate(), null, ContentTypes.TEXT_HTML_UTF8, String.valueOf(syllabus.getSyllabusId()),
				null, null, null, null, 0, 0, null);

		AssetLinkLocalServiceUtil.updateLinks(userId, assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		Indexer<Syllabus> indexer = IndexerRegistryUtil.nullSafeGetIndexer(Syllabus.class);
		indexer.reindex(syllabus);

		return WorkflowHandlerRegistryUtil.startWorkflowInstance(user.getCompanyId(), groupId, userId,
				Syllabus.class.getName(), syllabus.getPrimaryKey(), syllabus, serviceContext,
				Collections.<String, Serializable>emptyMap());
	}

	public Syllabus updateSyllabus(long userId, long syllabusId, long timetableCourseId, String competence,
			String ethicalStandards, String topics, String educationalMaterials, String recommendedLiterature,
			String weeklyTasks, ServiceContext serviceContext) throws PortalException, SystemException {
		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(syllabusId, timetableCourseId, competence, ethicalStandards, topics, educationalMaterials,
				recommendedLiterature, weeklyTasks);

		Syllabus syllabus = syllabusLocalService.getSyllabus(syllabusId);

		syllabus.setUserId(userId);
		syllabus.setUserName(user.getFullName());
		syllabus.setModifiedDate(serviceContext.getModifiedDate(now));
		syllabus.setTimetableCourseId(timetableCourseId);
		syllabus.setCompetence(competence);
		syllabus.setEthicalStandards(ethicalStandards);
		syllabus.setTopics(topics);
		syllabus.setEducationalMaterials(educationalMaterials);
		syllabus.setRecommendedLiterature(recommendedLiterature);
		syllabus.setWeeklyTasks(weeklyTasks);

		syllabusPersistence.update(syllabus);

		resourceLocalService.updateResources(user.getCompanyId(), groupId, Syllabus.class.getName(), syllabusId,
				serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(syllabus.getUserId(), syllabus.getGroupId(),
				syllabus.getCreateDate(), syllabus.getModifiedDate(), Syllabus.class.getName(),
				syllabus.getPrimaryKey(), syllabus.getUuid(), 0, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, true, null, null, syllabus.getCreateDate(), null,
				ContentTypes.TEXT_HTML_UTF8, String.valueOf(syllabus.getSyllabusId()), null, null, null, null, 0, 0,
				null);

		AssetLinkLocalServiceUtil.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(), AssetLinkConstants.TYPE_RELATED);

		Indexer<Syllabus> indexer = IndexerRegistryUtil.nullSafeGetIndexer(Syllabus.class);
		indexer.reindex(syllabus);

		WorkflowHandlerRegistryUtil.startWorkflowInstance(user.getCompanyId(), syllabus.getGroupId(), userId,
				Syllabus.class.getName(), syllabus.getSyllabusId(), syllabus, serviceContext);

		return syllabus;
	}

	public Syllabus deleteSyllabus(long syllabusId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		Syllabus syllabus = SyllabusLocalServiceUtil.getSyllabus(syllabusId);

		resourceLocalService.deleteResource(syllabus.getCompanyId(), syllabus.getClass().getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, syllabusId);

		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(Syllabus.class.getName(), syllabusId);
		AssetLinkLocalServiceUtil.deleteLinks(assetEntry.getEntryId());
		AssetEntryLocalServiceUtil.deleteEntry(assetEntry.getEntryId());

		Indexer<Syllabus> indexer = IndexerRegistryUtil.nullSafeGetIndexer(Syllabus.class);
		indexer.delete(syllabus);

		WorkflowInstanceLinkLocalServiceUtil.deleteWorkflowInstanceLinks(syllabus.getCompanyId(), syllabus.getGroupId(),
				Syllabus.class.getName(), syllabus.getSyllabusId());

		WorkflowInstanceLinkLocalServiceUtil.deleteWorkflowInstanceLink(syllabus.getCompanyId(), syllabus.getGroupId(),
				Syllabus.class.getName(), syllabus.getSyllabusId());
		
		return deleteSyllabus(syllabus);
	}

	public Syllabus updateStatus(long userId, long classPK, int status, ServiceContext serviceContext,
			Map<String, Serializable> workflowContext) throws PortalException {
		User user = userLocalService.getUser(userId);
		Date now = new Date();

		Syllabus syllabus = getSyllabus(classPK);

		syllabus.setModifiedDate(now);
		syllabus.setStatus(status);
		syllabus.setStatusByUserId(user.getUserId());
		syllabus.setStatusByUserName(user.getFullName());
		syllabus.setStatusDate(serviceContext.getModifiedDate(now));

		syllabusPersistence.update(syllabus);

		return syllabus;
	}

	private void validate(long syllabusId, long timetableCourseId, String competence, String ethicalStandards,
			String topics, String educationalMaterials, String recommendedLiterature, String weeklyTasks) {
		// TODO Auto-generated method stub
	}

}