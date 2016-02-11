<%@include file="/html/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Lecturer lecturer = (Lecturer) row.getObject();
	long lecturerId = lecturer.getLecturerId();
%>

<liferay-ui:icon-menu>
	<c:if test="<%=LecturerPermission.contains(permissionChecker, lecturerId, ActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL">
			<portlet:param name="lecturerId" value="<%=String.valueOf(lecturerId)%>" />
			<portlet:param name="mvcPath" value="/html/subjectcourseadmin/lecturers/edit_lecturer.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit" url="<%=editURL.toString()%>" />
	</c:if>

	<c:if test="<%=LecturerPermission.contains(permissionChecker, lecturerId, ActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL modelResource="<%=Lecturer.class.getName()%>" modelResourceDescription=""
			resourcePrimKey="<%=String.valueOf(lecturerId)%>" var="permissionsURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" useDialog="true" />
	</c:if>

	<c:if test="<%=LecturerPermission.contains(permissionChecker, lecturerId, ActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteLecturer" var="deleteURL">
			<portlet:param name="lecturerId" value="<%=String.valueOf(lecturerId)%>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
	</c:if>
</liferay-ui:icon-menu>
