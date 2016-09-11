<%@include file="/init.jsp"%>

<%
	boolean showCurriculumsLink = GetterUtil.getBoolean(request.getAttribute("showCurriculumsLink"), false);
	boolean showCourseTypesLink = GetterUtil.getBoolean(request.getAttribute("showCourseTypesLink"), false);
	boolean showSemestersLink = GetterUtil.getBoolean(request.getAttribute("showSemestersLink"), false);
	boolean showLecturersLink = GetterUtil.getBoolean(request.getAttribute("showLecturersLink"), false);
	boolean showImportSyllabusLink = GetterUtil.getBoolean(request.getAttribute("showImportSyllabusLink"), false);
	boolean showImportTimetableLink = GetterUtil.getBoolean(request.getAttribute("showImportTimetableLink"), false);

	long curriculumId = GetterUtil.getLong(request.getAttribute("curriculumId"), 0);
	long subjectId = GetterUtil.getLong(request.getAttribute("subjectId"), 0);
	long courseId = GetterUtil.getLong(request.getAttribute("courseId"), 0);
	long semesterId = GetterUtil.getLong(request.getAttribute("semesterId"), 0);
%>

<portlet:renderURL var="viewHomeURL">
	<portlet:param name="mvcPath" value="/admin/view.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewCurriculumsURL">
	<portlet:param name="mvcPath" value="/admin/curriculums/view_curriculums.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewSubjectsURL">
	<portlet:param name="mvcPath" value="/admin/subjects/view_subjects.jsp" />
	<portlet:param name="curriculumId" value="${curriculumId}" />
</portlet:renderURL>

<portlet:renderURL var="viewCoursesURL">
	<portlet:param name="mvcPath" value="/admin/courses/view_courses.jsp" />
	<portlet:param name="subjectId" value="${subjectId}" />
</portlet:renderURL>

<portlet:renderURL var="viewCourseTypesURL">
	<portlet:param name="mvcPath" value="/admin/course_types/view_course_types.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewSemestersURL">
	<portlet:param name="mvcPath" value="/admin/semesters/view_semesters.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewTimetableCoursesURL">
	<portlet:param name="mvcPath" value="/admin/timetablecourses/view_timetable_courses.jsp" />
	<portlet:param name="semesterId" value="${semesterId}" />
</portlet:renderURL>

<portlet:renderURL var="importSyllabusURL">
	<portlet:param name="mvcPath" value="/admin/import_syllabus.jsp" />
</portlet:renderURL>

<portlet:renderURL var="importTimetableURL">
	<portlet:param name="mvcPath" value="/admin/import_timetable.jsp" />
</portlet:renderURL>

<%
	PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "home"), viewHomeURL.toString());

	if (showCurriculumsLink) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "curriculums"), viewCurriculumsURL.toString());
	} else if (showCourseTypesLink) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "course-types"), viewCourseTypesURL.toString());
	} else if (showSemestersLink) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "semesters"), viewSemestersURL.toString());
	} else if (showLecturersLink) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "lecturers"), viewSemestersURL.toString());
	} else if (showImportSyllabusLink) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "import-syllabus"), importSyllabusURL.toString());
	} else if (showImportTimetableLink) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "import-timetable"), importTimetableURL.toString());
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
	
	if (courseId > 0) {
		Course course = CourseLocalServiceUtil.getCourse(courseId);
		PortalUtil.addPortletBreadcrumbEntry(request, course.toString(), viewCoursesURL.toString());
	}
%>

<!-- https://docs.liferay.com/portal/6.2/propertiesdoc/portal.properties.html#Breadcrumb%20Portlet -->
<%-- <liferay-ui:breadcrumb displayStyle="horizontal" showLayout="false" showPortletBreadcrumb="true" /> --%>
