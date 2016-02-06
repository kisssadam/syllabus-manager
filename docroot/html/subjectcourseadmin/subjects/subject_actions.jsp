<%@include file="/html/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Subject subject = (Subject) row.getObject();
	long subjectId = subject.getSubjectId();
%>

<liferay-ui:icon-menu>
	<c:if test="<%=SubjectPermission.contains(permissionChecker, subjectId, ActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL">
			<portlet:param name="subjectId" value="<%=String.valueOf(subjectId)%>" />
			<portlet:param name="mvcPath" value="/html/subjectcourseadmin/subjects/edit_subject.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit" url="<%=editURL.toString()%>" />
	</c:if>

	<c:if test="<%=SubjectPermission.contains(permissionChecker, subjectId, ActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL modelResource="<%=Subject.class.getName()%>" modelResourceDescription=""
			resourcePrimKey="<%=String.valueOf(subjectId)%>" var="permissionsURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" useDialog="true" />
	</c:if>

	<c:if test="<%=SubjectPermission.contains(permissionChecker, subjectId, ActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteSubject" var="deleteURL">
			<portlet:param name="subjectId" value="<%=String.valueOf(subjectId)%>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
	</c:if>
</liferay-ui:icon-menu>
