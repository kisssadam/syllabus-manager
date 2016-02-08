<%@include file="/html/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	TimetableCourse timetableCourse = (TimetableCourse) row.getObject();
	long timetableCourseId = timetableCourse.getTimetableCourseId();
%>

<liferay-ui:icon-menu>
	<c:if test="<%=TimetableCoursePermission.contains(permissionChecker, timetableCourseId, ActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL">
			<portlet:param name="timetableCourseId" value="<%=String.valueOf(timetableCourseId)%>" />
			<portlet:param name="mvcPath" value="/html/subjectcourseadmin/timetablecourses/edit_timetable_course.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit" url="<%=editURL.toString()%>" />
	</c:if>

	<c:if test="<%=TimetableCoursePermission.contains(permissionChecker, timetableCourseId, ActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL modelResource="<%=TimetableCourse.class.getName()%>" modelResourceDescription=""
			resourcePrimKey="<%=String.valueOf(timetableCourseId)%>" var="permissionsURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" useDialog="true" />
	</c:if>

	<c:if test="<%=TimetableCoursePermission.contains(permissionChecker, timetableCourseId, ActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteTimetableCourse" var="deleteURL">
			<portlet:param name="timetableCourseId" value="<%=String.valueOf(timetableCourseId)%>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
	</c:if>
</liferay-ui:icon-menu>
