<%@include file="/html/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Curriculum curriculum = (Curriculum) row.getObject();
	long curriculumId = curriculum.getCurriculumId();
%>

<liferay-ui:icon-menu>
	<c:if test="<%=CurriculumPermission.contains(permissionChecker, curriculumId, ActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL">
			<portlet:param name="curriculumId" value="<%=String.valueOf(curriculumId)%>" />
			<portlet:param name="mvcPath" value="/html/subjectcourseadmin/edit_curriculum.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit" url="<%=editURL.toString()%>" />
	</c:if>

	<c:if test="<%=CurriculumPermission.contains(permissionChecker, curriculumId, ActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL modelResource="<%=Curriculum.class.getName()%>" modelResourceDescription=""
			resourcePrimKey="<%=String.valueOf(curriculumId)%>" var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" />
	</c:if>

	<c:if test="<%=CurriculumPermission.contains(permissionChecker, curriculumId, ActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteCurriculum" var="deleteURL">
			<portlet:param name="curriculumId" value="<%=String.valueOf(curriculumId)%>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
	</c:if>
</liferay-ui:icon-menu>
