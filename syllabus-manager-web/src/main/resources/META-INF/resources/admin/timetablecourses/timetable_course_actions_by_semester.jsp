<%@include file="/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	TimetableCourse timetableCourse = (TimetableCourse) row.getObject();
	long timetableCourseId = timetableCourse.getTimetableCourseId();
	
	int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
%>

<liferay-ui:icon-menu>
	<c:if test="<%=TimetableCoursePermission.contains(permissionChecker, timetableCourseId, SyllabusActionKeys.VIEW)%>">
		<portlet:renderURL var="viewURL">
			<portlet:param name="timetableCourseId" value="<%=String.valueOf(timetableCourseId)%>" />
			<portlet:param name="mvcPath" value="/admin/syllabuses/view_syllabuses_by_timetable_course.jsp" />
			<portlet:param name="home" value="semesters" />
		</portlet:renderURL>
		
		<liferay-ui:icon image="view" message="view" url="<%=viewURL.toString()%>" />
	</c:if>

	<c:if test="<%=TimetableCoursePermission.contains(permissionChecker, timetableCourseId, SyllabusActionKeys.UPDATE)%>">
		<portlet:renderURL var="editURL">
			<portlet:param name="timetableCourseId" value="<%=String.valueOf(timetableCourseId)%>" />
			<portlet:param name="mvcPath" value="/admin/timetablecourses/edit_timetable_course.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit" url="<%=editURL.toString()%>" />
	</c:if>

	<c:if test="<%=TimetableCoursePermission.contains(permissionChecker, timetableCourseId, SyllabusActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL modelResource="<%=TimetableCourse.class.getName()%>" modelResourceDescription=""
			resourcePrimKey="<%=String.valueOf(timetableCourseId)%>" var="permissionsURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" useDialog="true" />
	</c:if>

	<c:if test="<%=TimetableCoursePermission.contains(permissionChecker, timetableCourseId, SyllabusActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteTimetableCourse" var="deleteURL">
			<portlet:param name="timetableCourseId" value="<%=String.valueOf(timetableCourseId)%>" />
			<portlet:param name="<%=SearchContainer.DEFAULT_DELTA_PARAM%>" value="<%=String.valueOf(delta)%>" />
		</portlet:actionURL>

		<liferay-ui:icon image="delete" url="<%=deleteURL.toString()%>" />
	</c:if>
</liferay-ui:icon-menu>
