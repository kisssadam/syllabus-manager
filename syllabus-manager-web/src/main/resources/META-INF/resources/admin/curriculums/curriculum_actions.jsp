<%@include file="/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Curriculum curriculum = (Curriculum) row.getObject();
	long curriculumId = curriculum.getCurriculumId();
	
	int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
%>

<liferay-ui:icon-menu>
	<c:if test="<%=CurriculumPermission.contains(permissionChecker, curriculumId, SyllabusActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL">
			<portlet:param name="curriculumId" value="<%=String.valueOf(curriculumId)%>" />
			<portlet:param name="mvcPath" value="/admin/curriculums/edit_curriculum.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit" url="<%=editURL.toString()%>" />
	</c:if>

	<c:if test="<%=CurriculumPermission.contains(permissionChecker, curriculumId, SyllabusActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL modelResource="<%=Curriculum.class.getName()%>" modelResourceDescription=""
			resourcePrimKey="<%=String.valueOf(curriculumId)%>" var="permissionsURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" useDialog="true" />
	</c:if>

	<c:if test="<%=CurriculumPermission.contains(permissionChecker, curriculumId, SyllabusActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteCurriculum" var="deleteURL">
			<portlet:param name="curriculumId" value="<%=String.valueOf(curriculumId)%>" />
			<portlet:param name="<%=SearchContainer.DEFAULT_DELTA_PARAM%>" value="<%=String.valueOf(delta)%>" />
		</portlet:actionURL>

		<liferay-ui:icon image="delete" url="<%=deleteURL.toString()%>" />
	</c:if>
</liferay-ui:icon-menu>
