<%@include file="/html/init.jsp"%>

<%
	boolean showCurriculumsLink = GetterUtil.getBoolean(request.getAttribute("showCurriculumsLink"), false);
	boolean showCourseTypesLink = GetterUtil.getBoolean(request.getAttribute("showCourseTypesLink"), false);
	boolean showSemestersLink = GetterUtil.getBoolean(request.getAttribute("showSemestersLink"), false);
	boolean showLecturersLink = GetterUtil.getBoolean(request.getAttribute("showLecturersLink"), false);

	long curriculumId = GetterUtil.getLong(request.getAttribute("curriculumId"), 0);
	long subjectId = GetterUtil.getLong(request.getAttribute("subjectId"), 0);
	long semesterId = GetterUtil.getLong(request.getAttribute("semesterId"), 0);
%>

<portlet:renderURL var="viewHomeURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewCurriculumsURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/curriculums/view_curriculums.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewSubjectsURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/subjects/view_subjects.jsp" />
	<portlet:param name="curriculumId" value="${curriculumId}" />
</portlet:renderURL>

<portlet:renderURL var="viewCoursesURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/courses/view_courses.jsp" />
	<portlet:param name="subjectId" value="${subjectId}" />
</portlet:renderURL>

<portlet:renderURL var="viewCourseTypesURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/course_types/view_course_types.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewSemestersURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/semesters/view_semesters.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewTimetableCoursesURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/timetablecourses/view_timetable_courses.jsp" />
	<portlet:param name="semesterId" value="${semesterId}" />
</portlet:renderURL>

<%
	PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "home"), viewHomeURL.toString());

	if (showCurriculumsLink) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "curriculums"), viewCurriculumsURL.toString());
	} else if (showCourseTypesLink) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "course-types"), viewCourseTypesURL.toString());
	} else if (showSemestersLink) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "semesters"), viewSemestersURL.toString());
	} else if (showLecturersLink) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "lecturers"), viewSemestersURL.toString());
	}

	if (curriculumId > 0) {
		Curriculum curriculum = CurriculumLocalServiceUtil.getCurriculum(curriculumId);
		PortalUtil.addPortletBreadcrumbEntry(request, curriculum.toString(), viewSubjectsURL.toString());
	}

	if (subjectId > 0) {
		Subject subject = SubjectLocalServiceUtil.getSubject(subjectId);
		PortalUtil.addPortletBreadcrumbEntry(request, subject.toString(), viewCoursesURL.toString());
	}

	if (semesterId > 0) {
		Semester semester = SemesterLocalServiceUtil.getSemester(semesterId);
		PortalUtil.addPortletBreadcrumbEntry(request, semester.toString(), viewTimetableCoursesURL.toString());
	}
%>

<!-- https://docs.liferay.com/portal/6.2/propertiesdoc/portal.properties.html#Breadcrumb%20Portlet -->
<liferay-ui:breadcrumb displayStyle="horizontal" showLayout="false" showPortletBreadcrumb="true" />
