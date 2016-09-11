<%@include file="/init.jsp"%>

<%
	long courseTypeId = ParamUtil.getLong(renderRequest, "courseTypeId");

	CourseType courseType = null;

	if (courseTypeId > 0) {
		courseType = CourseTypeLocalServiceUtil.getCourseType(courseTypeId);
	}
%>

<liferay-ui:error exception="<%=DuplicateCourseTypeException.class%>" message="duplicate-course-type-exception" />
<liferay-ui:error exception="<%=CourseTypeException.class%>" message="course-type-exception" />

<c:choose>
	<c:when test="<%=courseTypeId > 0%>">
		<liferay-ui:header title="edit-course-type" />
	</c:when>
	<c:otherwise>
		<liferay-ui:header title="add-course-type" />
	</c:otherwise>
</c:choose>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/admin/course_types/view_course_types.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addCourseType" var="addCourseTypeURL" />

<aui:form action="<%=addCourseTypeURL%>" name="<portlet:namespace />course_type_edit">
	<aui:model-context bean="<%=courseType%>" model="<%=CourseType.class%>" />

	<aui:input name="courseTypeId" type="hidden"
		value='<%=courseType == null ? courseTypeId : courseType.getCourseTypeId()%>' />

	<aui:fieldset>
		<aui:input name="typeName" type="text">
			<aui:validator name="required" />
		</aui:input>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel" onClick="<%= viewURL %>" />
	</aui:button-row>
</aui:form>
