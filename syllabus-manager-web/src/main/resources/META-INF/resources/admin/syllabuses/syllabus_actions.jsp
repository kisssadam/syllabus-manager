<%@include file="/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	String home = ParamUtil.getString(request, "home");
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Syllabus syllabus = (Syllabus) row.getObject();
	long syllabusId = syllabus.getSyllabusId();
	
	int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
%>

<liferay-ui:icon-menu>
	<c:if test="<%=SyllabusPermission.contains(permissionChecker, syllabusId, SyllabusActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL">
			<portlet:param name="syllabusId" value="<%=String.valueOf(syllabusId)%>" />
			<portlet:param name="mvcPath" value="/admin/syllabuses/edit_syllabus.jsp" />
			<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent()%>" />
			<portlet:param name="home" value="<%=home%>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit" url="<%=editURL.toString()%>" />
	</c:if>

	<c:if test="<%=SyllabusPermission.contains(permissionChecker, syllabusId, SyllabusActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL modelResource="<%=Syllabus.class.getName()%>" modelResourceDescription=""
			resourcePrimKey="<%=String.valueOf(syllabusId)%>" var="permissionsURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" useDialog="true" />
	</c:if>

	<c:if test="<%=SyllabusPermission.contains(permissionChecker, syllabusId, SyllabusActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteSyllabus" var="deleteURL">
			<portlet:param name="syllabusId" value="<%=String.valueOf(syllabusId)%>" />
			<portlet:param name="<%=SearchContainer.DEFAULT_DELTA_PARAM%>" value="<%=String.valueOf(delta)%>" />
		</portlet:actionURL>

		<liferay-ui:icon image="delete" url="<%=deleteURL.toString()%>" />
	</c:if>
</liferay-ui:icon-menu>
