<%@include file="/html/init.jsp"%>

<liferay-ui:success key="curriculumAdded" message="curriculum-has-been-successfully-added" />
<liferay-ui:success key="curriculumUpdated" message="curriculum-has-been-successfully-updated" />
<liferay-ui:success key="curriculumDeleted" message="curriculum-has-been-successfully-deleted" />
<liferay-ui:success key="everyCurriculumDeleted" message="every-curriculum-has-been-successfully-deleted" />

<!-- 
https://docs.liferay.com/portal/6.2/taglibs/liferay-ui/icon.html
http://marcoceppi.github.io/bootstrap-glyphicons/
-->
<aui:nav-bar>
    <aui:nav>
    	<portlet:renderURL var="viewHomeURL">
			<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view.jsp" />
		</portlet:renderURL>
        <aui:nav-item href="<%=viewHomeURL.toString()%>" iconCssClass="icon-home" label="home" selected='false' />
        <aui:nav-item dropdown="true" iconCssClass="icon-list" label="view" selected='false'>
        	<aui:nav-item href="/..." label="Curriculums" />
        	<aui:nav-item href="/..." label="Subjects" />
        	<aui:nav-item href="/..." label="Courses" />
        	<aui:nav-item href="/..." label="Course Types" />
        </aui:nav-item>
        <aui:nav-item dropdown="true" iconCssClass="icon-plus" label="add" selected='false'>
            <c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_CURRICULUM)%>'>
				<portlet:renderURL var="addCurriculumURL">
					<portlet:param name="mvcPath" value="/html/curriculumadmin/edit_curriculum.jsp" />
				</portlet:renderURL>
			
				<%-- <aui:button onClick="<%=addCurriculumURL.toString()%>" value="add-curriculum" /> --%>
            	<aui:nav-item href="<%=addCurriculumURL.toString()%>" label="Curriculum" />
			</c:if>
            <aui:nav-item href="/..." label="Subject" />
            <aui:nav-item href="/..." label="Course" />
            <aui:nav-item href="/..." label="Course Type" />
        </aui:nav-item>
        <aui:nav-item dropdown="true" iconCssClass="icon-upload" label="import" selected='false'>
        	<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.IMPORT_SYLLABUS)%>'>
        		<portlet:renderURL var="importSyllabusURL">
					<portlet:param name="mvcPath" value="/html/subjectcourseadmin/import_syllabus.jsp" />
				</portlet:renderURL>
            	<aui:nav-item href="<%=importSyllabusURL.toString()%>" label="ik_syllabus_ws.csv" />
			</c:if>
            <aui:nav-item href="/..." label="ik_orarend_ws.csv" />
        </aui:nav-item>
        <aui:nav-item href="/..." iconCssClass="icon-download" label="export" selected='false' />
    </aui:nav>
</aui:nav-bar>

<aui:button-row cssClass="curriculum-buttons">
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
			<portlet:renderURL var="viewCurriculumURL">
				<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view_curriculum.jsp" />
				<portlet:param name="curriculumId" value="<%=String.valueOf(curriculum.getCurriculumId())%>" />
			</portlet:renderURL>
			
			<liferay-ui:search-container-column-text name="curriculum-code" property="curriculumCode" href="<%=viewCurriculumURL.toString()%>" />
			<liferay-ui:search-container-column-text name="curriculum-name" property="curriculumName" />
			<liferay-ui:search-container-column-jsp path="/html/curriculumadmin/curriculum_actions.jsp" align="right" />
		</c:if>
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
