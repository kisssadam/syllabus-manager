<%@include file="/html/init.jsp"%>

<%
	boolean showCourseTypesLink = GetterUtil.getBoolean(request.getAttribute("showCourseTypesLink"), false);
	boolean showCurriculumsLink = GetterUtil.getBoolean(request.getAttribute("showCurriculumsLink"), false);
	long curriculumId = GetterUtil.getLong(request.getAttribute("curriculumId"), 0);
	long subjectId = GetterUtil.getLong(request.getAttribute("subjectId"), 0);
%>

<portlet:renderURL var="viewHomeURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewCurriculumsURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view_curriculums.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewSubjectsURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view_subjects.jsp" />
	<portlet:param name="curriculumId" value="${curriculumId}" />
</portlet:renderURL>

<portlet:renderURL var="viewCoursesURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view_courses.jsp" />
	<portlet:param name="subjectId" value="${subjectId}" />
</portlet:renderURL>

<portlet:renderURL var="viewCourseTypesURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view_course_types.jsp" />
</portlet:renderURL>

<%
	PortalUtil.addPortletBreadcrumbEntry(request, "Home", viewHomeURL.toString());

	if (showCourseTypesLink) {
		PortalUtil.addPortletBreadcrumbEntry(request, "Course Types", viewCourseTypesURL.toString());
	} else if (showCurriculumsLink) {
		PortalUtil.addPortletBreadcrumbEntry(request, "Curriculums", viewCurriculumsURL.toString());
	}

	if (curriculumId > 0) {
		Curriculum curriculum = CurriculumLocalServiceUtil.getCurriculum(curriculumId);
		PortalUtil.addPortletBreadcrumbEntry(request,
				curriculum.getCurriculumCode() + " - " + curriculum.getCurriculumName(),
				viewSubjectsURL.toString());
	}

	if (subjectId > 0) {
		Subject subject = SubjectLocalServiceUtil.getSubject(subjectId);
		PortalUtil.addPortletBreadcrumbEntry(request,
				subject.getSubjectCode() + " - " + subject.getSubjectName(), viewCoursesURL.toString());
	}
%>

<!-- https://docs.liferay.com/portal/6.2/propertiesdoc/portal.properties.html#Breadcrumb%20Portlet -->
<liferay-ui:breadcrumb displayStyle="horizontal" showLayout="false" showPortletBreadcrumb="true" />
