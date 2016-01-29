<%@include file="/html/init.jsp"%>

<liferay-ui:success key="curriculumAdded" message="curriculum-has-been-successfully-added" />
<liferay-ui:success key="curriculumUpdated" message="curriculum-has-been-successfully-updated" />
<liferay-ui:success key="curriculumDeleted" message="curriculum-has-been-successfully-deleted" />
<liferay-ui:success key="everyCurriculumDeleted" message="every-curriculum-has-been-successfully-deleted" />

<aui:button-row cssClass="curriculum-buttons">
	<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_CURRICULUM)%>'>
		<portlet:renderURL var="addCurriculumURL">
			<portlet:param name="mvcPath" value="/html/curriculumadmin/edit_curriculum.jsp" />
		</portlet:renderURL>
	
		<aui:button onClick="<%=addCurriculumURL.toString()%>" value="add-curriculum" />
	</c:if>
	<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.DELETE_EVERY_CURRICULUM)%>'>
		<portlet:actionURL name="deleteEveryCurriculum" var="deleteURL" />
		
		<aui:button onClick="<%=deleteURL.toString()%>" value="delete-every-curriculum" />
	</c:if>
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="curriculums-not-found">
	<liferay-ui:search-container-results
		results="<%=CurriculumLocalServiceUtil.getCurriculums(searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%=CurriculumLocalServiceUtil.getCurriculumsCount()%>"
	/>
	
	<liferay-ui:search-container-row className="hu.unideb.inf.model.Curriculum" modelVar="curriculum" keyProperty="curriculumId">
		<c:if test='<%=CurriculumPermission.contains(permissionChecker, curriculum.getCurriculumId(), "VIEW")%>'>
			<liferay-ui:search-container-column-text name="curriculum-code" property="curriculumCode" />
			<liferay-ui:search-container-column-text name="curriculum-name" property="curriculumName" />
			<liferay-ui:search-container-column-jsp path="/html/curriculumadmin/curriculum_actions.jsp" align="right" />
		</c:if>
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
