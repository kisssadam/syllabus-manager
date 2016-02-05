<%@include file="/html/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Course course = (Course) row.getObject();
	long courseId = course.getCourseId();
%>

<liferay-ui:icon-menu>
	<c:if test="<%=CoursePermission.contains(permissionChecker, courseId, ActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL">
			<portlet:param name="courseId" value="<%=String.valueOf(courseId)%>" />
			<portlet:param name="mvcPath" value="/html/subjectcourseadmin/courses/edit_course.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit" url="<%=editURL.toString()%>" />
	</c:if>

	<c:if test="<%=CoursePermission.contains(permissionChecker, courseId, ActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL modelResource="<%=Course.class.getName()%>" modelResourceDescription=""
			resourcePrimKey="<%=String.valueOf(courseId)%>" var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" />
	</c:if>

	<c:if test="<%=CoursePermission.contains(permissionChecker, courseId, ActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteCourse" var="deleteURL">
			<portlet:param name="courseId" value="<%=String.valueOf(courseId)%>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
	</c:if>
</liferay-ui:icon-menu>
