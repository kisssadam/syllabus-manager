<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@include file="/html/init.jsp"%>

<%
	long subjectId = ParamUtil.getLong(renderRequest, "subjectId");
	long curriculumId = ParamUtil.getLong(request, "curriculumId");

	Subject subject = null;

	if (subjectId > 0) {
		subject = SubjectLocalServiceUtil.getSubject(subjectId);
		curriculumId = subject.getCurriculumId();
	}

	request.setAttribute("curriculums", CurriculumLocalServiceUtil.getCurriculums());
%>

<liferay-ui:header title="edit-subject" />

<liferay-ui:error exception="<%=DuplicateSubjectException.class%>" message="duplicate-subject" />

<portlet:renderURL var="viewURL">
	<%
		if (curriculumId > 0) {
	%>
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view_curriculum.jsp" />
	<portlet:param name="curriculumId" value="<%=String.valueOf(curriculumId)%>" />
	<%
		} else {
	%>
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view_curriculums.jsp" />
	<%
		}
	%>
</portlet:renderURL>

<portlet:actionURL name="addSubject" var="addSubjectURL" />

<aui:form action="<%=addSubjectURL%>" name="<portlet:namespace />subject_edit">
	<aui:model-context bean="<%=subject%>" model="<%=Subject.class%>" />

	<aui:input name="subjectId" type="hidden" value='<%=subject == null ? subjectId : subject.getSubjectId()%>' />

	<aui:fieldset>
		<aui:select label="curriculum" name="curriculumId" required="true">
			<c:forEach items="${curriculums}" var="curriculum">
				<aui:option value="${curriculum.curriculumId}">
					<c:out value="${curriculum.curriculumCode} - ${curriculum.curriculumName}" />
				</aui:option>
			</c:forEach>
		</aui:select>

		<aui:input name="subjectCode" type="text">
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="subjectName" type="text">
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="credit" type="number" min="0" value="<%=subject == null ? 0 : subject.getCredit()%>">
			<aui:validator name="required" />
		</aui:input>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel" onClick="<%= viewURL %>" />
	</aui:button-row>
</aui:form>
