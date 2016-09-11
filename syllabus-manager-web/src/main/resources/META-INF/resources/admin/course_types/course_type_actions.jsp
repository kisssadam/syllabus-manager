<%@include file="/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	CourseType courseType = (CourseType) row.getObject();
	long courseTypeId = courseType.getCourseTypeId();
	
	int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
%>

<liferay-ui:icon-menu>
	<c:if test="<%=CourseTypePermission.contains(permissionChecker, courseTypeId, SyllabusActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL">
			<portlet:param name="courseTypeId" value="<%=String.valueOf(courseTypeId)%>" />
			<portlet:param name="mvcPath" value="/admin/course_types/edit_course_type.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit" url="<%=editURL.toString()%>" />
	</c:if>

	<c:if test="<%=CourseTypePermission.contains(permissionChecker, courseTypeId, SyllabusActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL modelResource="<%=CourseType.class.getName()%>" modelResourceDescription=""
			resourcePrimKey="<%=String.valueOf(courseTypeId)%>" var="permissionsURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" useDialog="true" />
	</c:if>

	<c:if test="<%=CourseTypePermission.contains(permissionChecker, courseTypeId, SyllabusActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteCourseType" var="deleteURL">
			<portlet:param name="courseTypeId" value="<%=String.valueOf(courseTypeId)%>" />
			<portlet:param name="<%=SearchContainer.DEFAULT_DELTA_PARAM%>" value="<%=String.valueOf(delta)%>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
	</c:if>
</liferay-ui:icon-menu>
