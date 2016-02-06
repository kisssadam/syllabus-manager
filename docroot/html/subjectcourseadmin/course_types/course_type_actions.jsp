<%@include file="/html/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	CourseType courseType = (CourseType) row.getObject();
	long courseTypeId = courseType.getCourseTypeId();
%>

<liferay-ui:icon-menu>
	<c:if test="<%=CourseTypePermission.contains(permissionChecker, courseTypeId, ActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL">
			<portlet:param name="courseTypeId" value="<%=String.valueOf(courseTypeId)%>" />
			<portlet:param name="mvcPath" value="/html/subjectcourseadmin/course_types/edit_course_type.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit" url="<%=editURL.toString()%>" />
	</c:if>

	<c:if test="<%=CourseTypePermission.contains(permissionChecker, courseTypeId, ActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL modelResource="<%=CourseType.class.getName()%>" modelResourceDescription=""
			resourcePrimKey="<%=String.valueOf(courseTypeId)%>" var="permissionsURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" useDialog="true" />
	</c:if>

	<c:if test="<%=CourseTypePermission.contains(permissionChecker, courseTypeId, ActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteCourseType" var="deleteURL">
			<portlet:param name="courseTypeId" value="<%=String.valueOf(courseTypeId)%>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
	</c:if>
</liferay-ui:icon-menu>
