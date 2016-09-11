<%@include file="/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Semester semester = (Semester) row.getObject();
	
	int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
%>

<liferay-ui:icon-menu>
	<c:if test="<%=SemesterPermission.contains(permissionChecker, semester.getSemesterId(),
							SyllabusActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL">
			<portlet:param name="semesterId" value="<%=String.valueOf(semester.getSemesterId())%>" />
			<portlet:param name="mvcPath" value="/admin/semesters/edit_semester.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit" url="<%=editURL.toString()%>" />
	</c:if>

	<c:if test="<%=SemesterPermission.contains(permissionChecker, semester.getSemesterId(),
							SyllabusActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL modelResource="<%=Semester.class.getName()%>" modelResourceDescription=""
			resourcePrimKey="<%=String.valueOf(semester.getSemesterId())%>" var="permissionsURL"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" useDialog="true" />
	</c:if>

	<c:if test="<%=SemesterPermission.contains(permissionChecker, semester.getSemesterId(),
							SyllabusActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteSemester" var="deleteURL">
			<portlet:param name="semesterId" value="<%=String.valueOf(semester.getSemesterId())%>" />
			<portlet:param name="<%=SearchContainer.DEFAULT_DELTA_PARAM%>" value="<%=String.valueOf(delta)%>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
	</c:if>
</liferay-ui:icon-menu>
