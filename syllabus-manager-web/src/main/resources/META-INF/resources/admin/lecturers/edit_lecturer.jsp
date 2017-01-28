<%@include file="/init.jsp"%>

<%
	String backURL = ParamUtil.getString(renderRequest, "backURL");
	long lecturerId = ParamUtil.getLong(renderRequest, "lecturerId");

	Lecturer lecturer = null;

	if (lecturerId > 0) {
		lecturer = LecturerLocalServiceUtil.getLecturer(lecturerId);
		request.setAttribute("lecturerUserId", lecturer.getLecturerUserId());
	}

	request.setAttribute("backURL", backURL);
	request.setAttribute("lecturerId", lecturerId);
	request.setAttribute("users", UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS));
%>

<%@ include file="/notifications/error.jspf" %>

<c:choose>
	<c:when test="<%=lecturerId > 0%>">
		<liferay-ui:header title="edit-lecturer" />
	</c:when>
	<c:otherwise>
		<liferay-ui:header title="add-lecturer" />
	</c:otherwise>
</c:choose>

<portlet:actionURL name="addLecturer" var="addLecturerURL" />

<aui:form action="<%=addLecturerURL%>" name="<portlet:namespace />lecturer_edit">
	<aui:model-context bean="<%=lecturer%>" model="<%=Lecturer.class%>" />

	<aui:input name="lecturerId" type="hidden" value='<%=lecturer == null ? lecturerId : lecturer.getLecturerId()%>' />

	<aui:fieldset>
		<aui:input name="lecturerName" type="text">
			<aui:validator name="required" />
		</aui:input>

		<aui:select label="lecturerUserId" name="lecturerUserId" showEmptyOption="true">
			<c:forEach items="${users}" var="user">
				<aui:option value="${user.userId}">
					<c:out value="${user.screenName}" />
				</aui:option>
			</c:forEach>
		</aui:select>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel" onClick="${backURL}" />
	</aui:button-row>
</aui:form>
