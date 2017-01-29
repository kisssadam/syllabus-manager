<%@include file="/init.jsp"%>

<%
	String backURL = ParamUtil.getString(renderRequest, "backURL");
	long courseTypeId = ParamUtil.getLong(renderRequest, "courseTypeId");

	CourseType courseType = null;

	if (courseTypeId > 0) {
		courseType = CourseTypeLocalServiceUtil.getCourseType(courseTypeId);
	}
	
	request.setAttribute("backURL", backURL);
%>

<%@ include file="/notifications/error.jspf" %>

<div class="closed container-fluid-1280 sidenav-container sidenav-right" id="<portlet:namespace />editCourseTypePanelId">
	<h1>
		<c:choose>
			<c:when test="<%=courseTypeId > 0%>">
				<liferay-ui:header title="edit-course-type" />
			</c:when>
			<c:otherwise>
				<liferay-ui:header title="add-course-type" />
			</c:otherwise>
		</c:choose>
	</h1>
	
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
			<aui:button type="cancel" onClick="${backURL}" />
		</aui:button-row>
	</aui:form>
</div>
