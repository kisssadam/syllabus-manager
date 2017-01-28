<%@include file="/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Subject subject = (Subject) row.getObject();
	long curriculumId = subject.getCurriculumId();
	long subjectId = subject.getSubjectId();
	
	int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
%>

<liferay-ui:icon-menu>
	<c:if test="<%=SubjectPermission.contains(permissionChecker, subjectId, SyllabusActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL">
			<portlet:param name="subjectId" value="<%=String.valueOf(subjectId)%>" />
			<portlet:param name="mvcPath" value="/admin/subjects/edit_subject.jsp" />
			<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent()%>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit" url="<%=editURL.toString()%>" />
	</c:if>

	<c:if test="<%=SubjectPermission.contains(permissionChecker, subjectId, SyllabusActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL modelResource="<%=Subject.class.getName()%>" modelResourceDescription=""
			resourcePrimKey="<%=String.valueOf(subjectId)%>" var="permissionsURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" useDialog="true" />
	</c:if>

	<c:if test="<%=SubjectPermission.contains(permissionChecker, subjectId, SyllabusActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteSubject" var="deleteURL">
			<portlet:param name="curriculumId" value="<%=String.valueOf(curriculumId)%>" />
			<portlet:param name="subjectId" value="<%=String.valueOf(subjectId)%>" />
			<portlet:param name="<%=SearchContainer.DEFAULT_DELTA_PARAM%>" value="<%=String.valueOf(delta)%>" />
		</portlet:actionURL>

		<liferay-ui:icon image="delete" url="<%=deleteURL.toString()%>" />
	</c:if>
</liferay-ui:icon-menu>
