<%@include file="/init.jsp"%>

<%
	String backURL = ParamUtil.getString(renderRequest, "backURL");	
	long curriculumId = ParamUtil.getLong(renderRequest, "curriculumId");

	Curriculum curriculum = null;

	if (curriculumId > 0) {
		curriculum = CurriculumLocalServiceUtil.getCurriculum(curriculumId);
	}
	
	request.setAttribute("backURL", backURL);
%>

<%@ include file="/notifications/error.jspf" %>

<c:choose>
	<c:when test="<%=curriculumId > 0%>">
		<liferay-ui:header title="edit-curriculum" />
	</c:when>
	<c:otherwise>
		<liferay-ui:header title="add-curriculum" />
	</c:otherwise>
</c:choose>

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
		<aui:button type="cancel" onClick="${backURL}" />
	</aui:button-row>
</aui:form>
