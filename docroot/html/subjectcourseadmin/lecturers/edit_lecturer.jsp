<%@page import="com.liferay.portal.NoSuchUserException"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@include file="/html/init.jsp"%>

<%
	long lecturerId = ParamUtil.getLong(renderRequest, "lecturerId");

	Lecturer lecturer = null;

	if (lecturerId > 0) {
		lecturer = LecturerLocalServiceUtil.getLecturer(lecturerId);
		request.setAttribute("lecturerUserId", lecturer.getLecturerUserId());
	}

	request.setAttribute("lecturerId", lecturerId);
	request.setAttribute("users", UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS));
%>

<liferay-ui:error exception="<%=DuplicateLecturerException.class%>" message="duplicate-lecturer-exception" />
<liferay-ui:error exception="<%=NoSuchLecturerException.class%>" message="no-such-lecturer-exception" />
<liferay-ui:error exception="<%=LecturerNameException.class%>" message="lecturer-name-exception" />
<liferay-ui:error exception="<%=NoSuchUserException.class%>" message="no-such-user-exception" />

<c:choose>
	<c:when test="<%=lecturerId > 0%>">
		<liferay-ui:header title="edit-lecturer" />
	</c:when>
	<c:otherwise>
		<liferay-ui:header title="add-lecturer" />
	</c:otherwise>
</c:choose>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/lecturers/view_lecturers.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addLecturer" var="addLecturerURL" />

<aui:form action="<%=addLecturerURL%>" name="<portlet:namespace />lecturer_edit">
	<aui:model-context bean="<%=lecturer%>" model="<%=Lecturer.class%>" />

	<aui:input name="lecturerId" type="hidden" value='<%=lecturer == null ? lecturerId : lecturer.getLecturerId()%>' />

	<aui:fieldset>
		<aui:input name="lecturerName" type="text">
			<aui:validator name="required" />
		</aui:input>

		<aui:select label="lecturerUserId" name="lecturerUserId">
			<aui:option value="0">not-set-up</aui:option>
			<c:forEach items="${users}" var="user">
				<aui:option value="${user.userId}">
					<c:out value="${user.screenName}" />
				</aui:option>
			</c:forEach>
		</aui:select>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel" onClick="<%= viewURL %>" />
	</aui:button-row>
</aui:form>
