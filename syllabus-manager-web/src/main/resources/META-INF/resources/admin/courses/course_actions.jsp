<%@include file="/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Course course = (Course) row.getObject();
	
	long curriculumId = ParamUtil.getLong(renderRequest, "curriculumId");
	long subjectId = ParamUtil.getLong(renderRequest, "subjectId");
	long courseId = course.getCourseId();
	
	int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
%>

<liferay-ui:icon-menu>
	<c:if test="<%=CoursePermission.contains(permissionChecker, courseId, SyllabusActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL">
			<portlet:param name="courseId" value="<%=String.valueOf(courseId)%>" />
			<portlet:param name="mvcPath" value="/admin/courses/edit_course.jsp" />
			<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent()%>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit" url="<%=editURL.toString()%>" />
	</c:if>

	<c:if test="<%=CoursePermission.contains(permissionChecker, courseId, SyllabusActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL modelResource="<%=Course.class.getName()%>" modelResourceDescription=""
			resourcePrimKey="<%=String.valueOf(courseId)%>" var="permissionsURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" useDialog="true" />
	</c:if>

	<c:if test="<%=CoursePermission.contains(permissionChecker, courseId, SyllabusActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteCourse" var="deleteURL">
			<portlet:param name="curriculumId" value="<%=String.valueOf(curriculumId)%>" />
			<portlet:param name="subjectId" value="<%=String.valueOf(subjectId)%>" />
			<portlet:param name="courseId" value="<%=String.valueOf(courseId)%>" />
			<portlet:param name="<%=SearchContainer.DEFAULT_DELTA_PARAM%>" value="<%=String.valueOf(delta)%>" />
		</portlet:actionURL>

		<liferay-ui:icon image="delete" url="<%=deleteURL.toString()%>" />
	</c:if>
</liferay-ui:icon-menu>
