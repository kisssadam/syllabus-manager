<%@include file="/html/init.jsp"%>

<liferay-ui:success key="curriculumAdded" message="curriculum-has-been-successfully-added" />
<liferay-ui:success key="curriculumUpdated" message="curriculum-has-been-successfully-updated" />

<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, "ADD_CURRICULUM")%>'>
	<aui:button-row cssClass="curriculum-buttons">
		<portlet:renderURL var="addCurriculumURL">
			<portlet:param name="mvcPath" value="/html/curriculumadmin/edit_curriculum.jsp" />
		</portlet:renderURL>
	
		<aui:button onClick="<%=addCurriculumURL.toString()%>" value="add-curriculum" />
	</aui:button-row>
</c:if>

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
