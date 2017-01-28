<%@ include file="/init.jsp"%>

<%@ include file="/notifications/success.jspf" %>
<%@ include file="/notifications/error.jspf" %>

<jsp:include page="/admin/navigation_bar.jsp" />

<liferay-ui:header title="clear-database" />

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/admin/index.jsp" />
</portlet:renderURL>

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
			<aui:button type="cancel" onClick="<%= viewURL %>" />
		</aui:button-row>
	</aui:form>
</c:if>
