<%@include file="/init.jsp"%>

<%
	String home = GetterUtil.getString(request.getAttribute("home"));
	String importType = GetterUtil.getString(request.getAttribute("importType"));
	long curriculumId = GetterUtil.getLong(request.getAttribute("curriculumId"), 0);
	long subjectId = GetterUtil.getLong(request.getAttribute("subjectId"), 0);
	long courseId = GetterUtil.getLong(request.getAttribute("courseId"), 0);
	long timetableCourseId = GetterUtil.getLong(request.getAttribute("timetableCourseId"), 0);
	long syllabusId = ParamUtil.getLong(request, "syllabusId");
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
	<portlet:param name="curriculumId" value="<%=String.valueOf(curriculumId)%>" />
	<portlet:param name="subjectId" value="0" />
	<portlet:param name="courseId" value="0" />
</portlet:renderURL>

<portlet:renderURL var="viewCoursesURL">
	<portlet:param name="mvcPath" value="/admin/courses/view_courses.jsp" />
	<portlet:param name="subjectId" value="<%=String.valueOf(subjectId)%>" />
</portlet:renderURL>

<portlet:renderURL var="viewCourseTypesURL">
	<portlet:param name="mvcPath" value="/admin/course_types/view_course_types.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewSemestersURL">
	<portlet:param name="mvcPath" value="/admin/semesters/view_semesters.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewTimetableCoursesURL">
	<portlet:param name="mvcPath" value="/admin/timetablecourses/view_timetable_courses.jsp" />
	<portlet:param name="home" value="<%=home%>" />
	<portlet:param name="curriculumId" value="<%=String.valueOf(curriculumId)%>" />
	<portlet:param name="subjectId" value="<%=String.valueOf(subjectId)%>" />
	<portlet:param name="courseId" value="<%=String.valueOf(courseId)%>" />
	<portlet:param name="semesterId" value="<%=String.valueOf(semesterId)%>" />
</portlet:renderURL>

<portlet:renderURL var="importSyllabusURL">
	<portlet:param name="mvcPath" value="/admin/import_syllabus.jsp" />
</portlet:renderURL>

<portlet:renderURL var="importTimetableURL">
	<portlet:param name="mvcPath" value="/admin/import_timetable.jsp" />
</portlet:renderURL>

<%
	PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "home"), viewHomeURL.toString());	

	if (StringUtil.equalsIgnoreCase(home, "curriculums")) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "curriculums"), viewCurriculumsURL.toString());
		
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
	} else if (StringUtil.equalsIgnoreCase(home, "semesters")) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "semesters"), viewSemestersURL.toString());
		
		if (semesterId > 0) {
			Semester semester = SemesterLocalServiceUtil.getSemester(semesterId);
			PortalUtil.addPortletBreadcrumbEntry(request, semester.toString(), viewTimetableCoursesURL.toString());
		}
		
		if (timetableCourseId > 0) {
			TimetableCourse timetableCourse = TimetableCourseLocalServiceUtil.getTimetableCourse(timetableCourseId);
			PortalUtil.addPortletBreadcrumbEntry(request, timetableCourse.toString(), StringPool.BLANK);
		}
	} else if (StringUtil.equalsIgnoreCase(home, "course_types")) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "course-types"), viewCourseTypesURL.toString());
	} else if (StringUtil.equalsIgnoreCase(home, "lecturers")) {
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "lecturers"), viewSemestersURL.toString());
	} else if (StringUtil.equalsIgnoreCase(home, "import")) {
		if (StringUtil.equalsIgnoreCase(importType, "syllabus")) {
			PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "import-syllabus"), importSyllabusURL.toString());
		} else if (StringUtil.equalsIgnoreCase(importType, "timetable")) {
			PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "import-timetable"), importTimetableURL.toString());
		}
	}
%>

<liferay-ui:breadcrumb showLayout="false" showPortletBreadcrumb="true" />
