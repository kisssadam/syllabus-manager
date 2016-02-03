<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@include file="/html/init.jsp"%>

<%
	long subjectId = ParamUtil.getLong(renderRequest, "subjectId");

	Subject subject = null;

	if (subjectId > 0) {
		subject = SubjectLocalServiceUtil.getSubject(subjectId);
	}
%>

<liferay-ui:error exception="<%=DuplicateSubjectException.class%>" message="duplicate-subject" />

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view_curriculum.jsp" />
	<portlet:param name="curriculumId" value="<%=String.valueOf(subject.getCurriculumId())%>" />
</portlet:renderURL>

<portlet:actionURL name="addSubject" var="addSubjectURL" />

<aui:form action="<%=addSubjectURL%>" name="<portlet:namespace />subject_edit">
	<aui:model-context bean="<%=subject%>" model="<%=Subject.class%>" />

	<aui:input name="subjectId" type="hidden" value='<%=subject == null ? subjectId : subject.getSubjectId()%>' />

	<aui:fieldset>
		<aui:select label="curriculum" name="curriculumId">
			<%
				List<Curriculum> curriculums = CurriculumLocalServiceUtil.getCurriculums();
							for (Curriculum curriculum : curriculums) {
			%>
			<aui:option value="<%=curriculum.getCurriculumId()%>">
				<%=curriculum.getCurriculumCode() + " - " + curriculum.getCurriculumName()%>
			</aui:option>
			<%
				}
			%>
		</aui:select>

		<aui:input name="subjectCode" type="text">
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="subjectName" type="text">
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="credit" type="text">
			<aui:validator name="required" />
		</aui:input>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel" onClick="<%= viewURL %>" />
	</aui:button-row>
</aui:form>
