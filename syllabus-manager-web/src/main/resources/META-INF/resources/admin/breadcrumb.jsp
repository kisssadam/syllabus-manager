<%@include file="/init.jsp"%>

<%
	String home = GetterUtil.getString(request.getAttribute("home"));
	long curriculumId = GetterUtil.getLong(request.getAttribute("curriculumId"), 0);
	long subjectId = GetterUtil.getLong(request.getAttribute("subjectId"), 0);
	long courseId = GetterUtil.getLong(request.getAttribute("courseId"), 0);
	long timetableCourseId = GetterUtil.getLong(request.getAttribute("timetableCourseId"), 0);
	long syllabusId = ParamUtil.getLong(request, "syllabusId");
	long semesterId = GetterUtil.getLong(request.getAttribute("semesterId"), 0);
%>

<portlet:renderURL var="viewHomeURL">
	<portlet:param name="mvcPath" value="<%=WebKeys.ADMIN_VIEW%>" />
</portlet:renderURL>

<portlet:renderURL var="viewCurriculumsURL">
	<portlet:param name="mvcPath" value="<%=WebKeys.VIEW_CURRICULUMS%>" />
</portlet:renderURL>

<portlet:renderURL var="viewSubjectsURL">
	<portlet:param name="mvcPath" value="<%=WebKeys.VIEW_SUBJECTS%>" />
	<portlet:param name="curriculumId" value="<%=String.valueOf(curriculumId)%>" />
	<portlet:param name="subjectId" value="0" />
	<portlet:param name="courseId" value="0" />
</portlet:renderURL>

<portlet:renderURL var="viewCoursesURL">
	<portlet:param name="mvcPath" value="<%=WebKeys.VIEW_COURSES%>" />
	<portlet:param name="subjectId" value="<%=String.valueOf(subjectId)%>" />
</portlet:renderURL>

<portlet:renderURL var="viewCourseTypesURL">
	<portlet:param name="mvcPath" value="<%=WebKeys.VIEW_COURSE_TYPES%>" />
</portlet:renderURL>

<portlet:renderURL var="viewSemestersURL">
	<portlet:param name="mvcPath" value="<%=WebKeys.VIEW_SEMESTERS%>" />
</portlet:renderURL>

<portlet:renderURL var="viewLecturersURL">
	<portlet:param name="mvcPath" value="<%=WebKeys.VIEW_LECTURERS%>" />
</portlet:renderURL>

<portlet:renderURL var="viewTimetableCoursesURL">
	<portlet:param name="mvcPath" value="<%=WebKeys.VIEW_TIMETABLE_COURSES%>" />
	<portlet:param name="home" value="<%=home%>" />
	<portlet:param name="curriculumId" value="<%=String.valueOf(curriculumId)%>" />
	<portlet:param name="subjectId" value="<%=String.valueOf(subjectId)%>" />
	<portlet:param name="courseId" value="<%=String.valueOf(courseId)%>" />
	<portlet:param name="semesterId" value="<%=String.valueOf(semesterId)%>" />
</portlet:renderURL>

<portlet:renderURL var="importSyllabusURL">
	<portlet:param name="mvcPath" value="<%=WebKeys.ADMIN_IMPORT_SYLLABUS%>" />
</portlet:renderURL>

<portlet:renderURL var="importTimetableURL">
	<portlet:param name="mvcPath" value="<%=WebKeys.ADMIN_IMPORT_TIMETABLE%>" />
</portlet:renderURL>

<%
	PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "home"), viewHomeURL.toString());	

	if (StringUtil.equalsIgnoreCase(home, WebKeys.ADMIN_HOME_CURRICULUMS)) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, WebKeys.ADMIN_HOME_CURRICULUMS), viewCurriculumsURL.toString());
		
		if (curriculumId > 0) {
			Curriculum curriculum = CurriculumLocalServiceUtil.getCurriculum(curriculumId);
			PortalUtil.addPortletBreadcrumbEntry(request, curriculum.toString(), viewSubjectsURL.toString());
		}

		if (subjectId > 0) {
			Subject subject = SubjectLocalServiceUtil.getSubject(subjectId);
			PortalUtil.addPortletBreadcrumbEntry(request, subject.toString(), viewCoursesURL.toString());
		}

		if (courseId > 0) {
			Course course = CourseLocalServiceUtil.getCourse(courseId);
			PortalUtil.addPortletBreadcrumbEntry(request, course.toString(), viewTimetableCoursesURL.toString());
		}
		
		if (timetableCourseId > 0) {
			TimetableCourse timetableCourse = TimetableCourseLocalServiceUtil.getTimetableCourse(timetableCourseId);
			PortalUtil.addPortletBreadcrumbEntry(request, timetableCourse.toString(), StringPool.BLANK);
		}
	} else if (StringUtil.equalsIgnoreCase(home, WebKeys.ADMIN_HOME_SEMESTERS)) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, WebKeys.ADMIN_HOME_SEMESTERS), viewSemestersURL.toString());
		
		if (semesterId > 0) {
			Semester semester = SemesterLocalServiceUtil.getSemester(semesterId);
			PortalUtil.addPortletBreadcrumbEntry(request, semester.toString(), viewTimetableCoursesURL.toString());
		}
		
		if (timetableCourseId > 0) {
			TimetableCourse timetableCourse = TimetableCourseLocalServiceUtil.getTimetableCourse(timetableCourseId);
			PortalUtil.addPortletBreadcrumbEntry(request, timetableCourse.toString(), StringPool.BLANK);
		}
	} else if (StringUtil.equalsIgnoreCase(home, WebKeys.ADMIN_HOME_COURSE_TYPES)) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, WebKeys.ADMIN_HOME_COURSE_TYPES), viewCourseTypesURL.toString());
	} else if (StringUtil.equalsIgnoreCase(home, WebKeys.ADMIN_HOME_LECTURERS)) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, WebKeys.ADMIN_HOME_LECTURERS), viewLecturersURL.toString());
	} else if (StringUtil.equalsIgnoreCase(home, WebKeys.ADMIN_HOME_IMPORT_SYLLABUS)) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, WebKeys.ADMIN_HOME_IMPORT_SYLLABUS), importSyllabusURL.toString());
	} else if (StringUtil.equalsIgnoreCase(home, WebKeys.ADMIN_HOME_IMPORT_TIMETABLE)) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, WebKeys.ADMIN_HOME_IMPORT_TIMETABLE), importTimetableURL.toString());
	}
%>

<liferay-ui:breadcrumb showLayout="false" showPortletBreadcrumb="true" />
