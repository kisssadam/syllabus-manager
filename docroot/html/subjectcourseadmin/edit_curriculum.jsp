<%@include file="/html/init.jsp"%>

<%
	long curriculumId = ParamUtil.getLong(renderRequest, "curriculumId");

	Curriculum curriculum = null;

	if (curriculumId > 0) {
		curriculum = CurriculumLocalServiceUtil.getCurriculum(curriculumId);
	}
%>

<liferay-ui:error exception="<%=DuplicateCurriculumException.class%>" message="duplicate-curriculum" />

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addCurriculum" var="addCurriculumURL" />

<aui:form action="<%=addCurriculumURL%>" name="<portlet:namespace />curriculum_edit">
	<aui:model-context bean="<%=curriculum%>" model="<%=Curriculum.class%>" />

	<aui:input name="curriculumId" type="hidden"
		value='<%=curriculum == null ? curriculumId : curriculum.getCurriculumId()%>' />

	<aui:fieldset>
		<aui:input name="curriculumCode" type="text">
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="curriculumName" type="text">
			<aui:validator name="required" />
		</aui:input>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel" onClick="<%= viewURL %>" />
	</aui:button-row>
</aui:form>
