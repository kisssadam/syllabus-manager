<%@ include file="/init.jsp"%>

<%
	String backURL = ParamUtil.getString(renderRequest, "backURL");
	
	request.setAttribute("backURL", backURL);
%>

<%@ include file="/notifications/success.jspf" %>
<%@ include file="/notifications/error.jspf" %>

<jsp:include page="/admin/navigation_bar.jsp" />

<div class="closed container-fluid-1280 sidenav-container sidenav-right" id="<portlet:namespace />clearDatabasePanelId">
	<h1>
		<liferay-ui:header title="clear-database" />
	</h1>
	
	<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, SyllabusActionKeys.CLEAR_DATABASE)%>'>
		<portlet:actionURL name="clearDatabase" var="clearDatabaseURL" />
		
		<aui:form method="post" action="<%=clearDatabaseURL%>" name="<portlet:namespace />clear_database">
			<aui:fieldset>
				<aui:input name="deleteSyllabuses" type="checkbox" />
				<aui:input name="deleteTimetableCourses" type="checkbox" />
				<aui:input name="deleteCourses" type="checkbox" />
				<aui:input name="deleteCourseTypes" type="checkbox" />
				<aui:input name="deleteSubjects" type="checkbox" />
				<aui:input name="deleteCurriculums" type="checkbox" />
				<aui:input name="deleteLecturers" type="checkbox" />
				<aui:input name="deleteSemesters" type="checkbox" />
			</aui:fieldset>
			
			<aui:button-row>
				<aui:button type="submit" />
				<aui:button type="cancel" onClick="${backURL}>" />
			</aui:button-row>
		</aui:form>
	</c:if>
</div>
