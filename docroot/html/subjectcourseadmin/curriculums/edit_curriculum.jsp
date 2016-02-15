<%@include file="/html/init.jsp"%>

<%
	long curriculumId = ParamUtil.getLong(renderRequest, "curriculumId");

	Curriculum curriculum = null;

	if (curriculumId > 0) {
		curriculum = CurriculumLocalServiceUtil.getCurriculum(curriculumId);
	}
%>

<liferay-ui:error exception="<%=DuplicateCurriculumException.class%>" message="duplicate-curriculum-exception" />
<liferay-ui:error exception="<%=CurriculumCodeException.class%>" message="curriculum-code-exception" />
<liferay-ui:error exception="<%=CurriculumNameException.class%>" message="curriculum-name-exception" />

<c:choose>
	<c:when test="<%=curriculumId > 0%>">
		<liferay-ui:header title="edit-curriculum" />
	</c:when>
	<c:otherwise>
		<liferay-ui:header title="add-curriculum" />
	</c:otherwise>
</c:choose>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/curriculums/view_curriculums.jsp" />
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
