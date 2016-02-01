<%@include file="/html/init.jsp"%>

<%
	long curriculumId = GetterUtil.getLong(request.getAttribute("curriculumId"), 0); 
	long subjectId = GetterUtil.getLong(request.getAttribute("subjectId"), 0);
	
	System.out.println(curriculumId);
	System.out.println(subjectId);
%>

<portlet:renderURL var="viewHomeURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewCurriculumURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view_curriculum.jsp" />
	<portlet:param name="curriculumId" value="${curriculumId}" />
</portlet:renderURL>

<portlet:renderURL var="viewSubjectURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view_subject.jsp" />
	<portlet:param name="subjectId" value="${subjectId}" />
</portlet:renderURL>

<%
	PortalUtil.addPortletBreadcrumbEntry(request, "Home", viewHomeURL.toString());	

	if (curriculumId > 0) {
		Curriculum curriculum = CurriculumLocalServiceUtil.getCurriculum(curriculumId);
		PortalUtil.addPortletBreadcrumbEntry(request, curriculum.getCurriculumCode() + " - " + curriculum.getCurriculumName(), viewCurriculumURL.toString());
	}
	
	if (subjectId > 0) {
		Subject subject = SubjectLocalServiceUtil.getSubject(subjectId);
		PortalUtil.addPortletBreadcrumbEntry(request, subject.getSubjectCode() + " - " + subject.getSubjectName(), viewSubjectURL.toString());
	}
%>

<!-- https://docs.liferay.com/portal/6.2/propertiesdoc/portal.properties.html#Breadcrumb%20Portlet -->
<liferay-ui:breadcrumb displayStyle="horizontal" showLayout="false" showPortletBreadcrumb="true" />
