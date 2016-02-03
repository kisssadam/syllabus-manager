<%@include file="/html/init.jsp"%>

<%
	long courseTypeId = ParamUtil.getLong(renderRequest, "courseTypeId");

	CourseType courseType = null;

	if (courseTypeId > 0) {
		courseType = CourseTypeLocalServiceUtil.getCourseType(courseTypeId);
	}
%>

<liferay-ui:error exception="<%=DuplicateCourseTypeException.class%>" message="duplicate-course-type" />

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view_course_types.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addCourseType" var="addCourseTypeURL" />

<aui:form action="<%=addCourseTypeURL%>" name="<portlet:namespace />course_type_edit">
	<aui:model-context bean="<%=courseType%>" model="<%=CourseType.class%>" />

	<aui:input name="courseTypeId" type="hidden"
		value='<%=courseType == null ? courseTypeId : courseType.getCourseTypeId()%>' />

	<aui:fieldset>
		<aui:input name="type" type="text">
			<aui:validator name="required" />
		</aui:input>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel" onClick="<%= viewURL %>" />
	</aui:button-row>
</aui:form>
