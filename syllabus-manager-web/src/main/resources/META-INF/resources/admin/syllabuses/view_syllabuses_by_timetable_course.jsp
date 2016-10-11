<%@include file="/init.jsp"%>

<%
	String home = ParamUtil.getString(renderRequest, "home");

	long timetableCourseId = ParamUtil.getLong(renderRequest, "timetableCourseId");
	long courseId = ParamUtil.getLong(renderRequest, "courseId");
	long subjectId = ParamUtil.getLong(renderRequest, "subjectId");
	long curriculumId = ParamUtil.getLong(renderRequest, "curriculumId");
	long semesterId = ParamUtil.getLong(renderRequest, "semesterId");
	
	TimetableCourse timetableCourse = null;
	Course course = null;
	Subject subject = null;
	
	if (timetableCourseId > 0) {
		timetableCourse = TimetableCourseLocalServiceUtil.getTimetableCourse(timetableCourseId);
		courseId = timetableCourse.getCourseId();
		semesterId = timetableCourse.getSemesterId();
	}
	
	if (courseId > 0) {
		course = CourseLocalServiceUtil.getCourse(courseId);
		subjectId = course.getSubjectId();
	}
	
	if (subjectId > 0) {
		subject = SubjectLocalServiceUtil.getSubject(course.getSubjectId());
		curriculumId = subject.getCurriculumId();
	}
	
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("jspPage", "/admin/syllabuses/view_syllabuses_by_timetable_course.jsp");
	iteratorURL.setParameter("timetableCourseId", String.valueOf(timetableCourseId));
	
	int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
%>
<c:choose>
	<c:when test="<%=StringUtil.equalsIgnoreCase(home, "curriculums")%>">
		<c:set var="home" value="curriculums" scope="request" />
		<c:set var="curriculumId" value="<%=curriculumId%>" scope="request" />
		<c:set var="subjectId" value="<%=subjectId%>" scope="request" />
		<c:set var="courseId" value="<%=courseId%>" scope="request" />
		<c:set var="timetableCourseId" value="<%=timetableCourseId%>" scope="request" />
	</c:when>
	<c:when test="<%=StringUtil.equalsIgnoreCase(home, "semesters")%>">
		<c:set var="home" value="semesters" scope="request" />
		<c:set var="semesterId" value="<%=semesterId%>" scope="request" />
		<c:set var="timetableCourseId" value="<%=timetableCourseId%>" scope="request" />
	</c:when>
	<c:otherwise>
		
	</c:otherwise>
</c:choose>

<jsp:include page="/admin/navigation_bar.jsp" />

<jsp:include page="/admin/breadcrumb.jsp" />
