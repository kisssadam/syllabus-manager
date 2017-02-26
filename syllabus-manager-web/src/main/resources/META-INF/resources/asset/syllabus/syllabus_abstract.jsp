<%@include file="/init.jsp"%>

<%
	Syllabus syllabus = (Syllabus) request.getAttribute(WebKeys.SYLLABUS);
	
	TimetableCourse timetableCourse = null;
	Course course = null;
	CourseType courseType = null;
	Subject subject = null;
	Curriculum curriculum = null;
	Semester semester = null;
	List<Lecturer> lecturers = Collections.emptyList();
	
	if (syllabus != null) {
		timetableCourse = TimetableCourseLocalServiceUtil.getTimetableCourse(syllabus.getTimetableCourseId());
	}
	
	if (timetableCourse != null) {
		course = CourseLocalServiceUtil.getCourse(timetableCourse.getCourseId());
		semester = SemesterLocalServiceUtil.getSemester(timetableCourse.getSemesterId());
		lecturers = LecturerLocalServiceUtil.getTimetableCourseLecturers(timetableCourse.getTimetableCourseId());
	}
	
	if (course != null) {
		subject = SubjectLocalServiceUtil.getSubject(course.getSubjectId());
		courseType = CourseTypeLocalServiceUtil.getCourseType(course.getCourseTypeId());
	}
	
	if (subject != null) {
		curriculum = CurriculumLocalServiceUtil.getCurriculum(subject.getCurriculumId());
	}
	
	Format dateFormat = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
	
	request.setAttribute("curriculum", curriculum);
	request.setAttribute("semester", semester);
	request.setAttribute("subject", subject);
	request.setAttribute("course", course);
	request.setAttribute("courseType", courseType);
	request.setAttribute("timetableCourse", timetableCourse);
	request.setAttribute("syllabus", syllabus);
	request.setAttribute("lecturers", lecturers);
%>

<c:if test='<%= SyllabusPermission.contains(permissionChecker, syllabus.getSyllabusId(), "VIEW") %>'>
	<aui:input name="curriculum" type="text" value="${curriculum.curriculumCode} - ${curriculum.curriculumName}" />
	
	<aui:input name="semester" type="text" value="${semester.beginYear}/${semester.endYear}/${semester.division}" />
	
	<aui:input name="subject" type="text" value="${subject.subjectCode} - ${subject.subjectName}" />
	
	<aui:input name="courseType" type="text" value="${courseType.typeName}" />
	
	<aui:input name="timetableCourseCode" type="text" value="${timetableCourse.timetableCourseCode}" />
	
	<c:forEach items="${lecturers}" var="lecturer">
		<aui:input name="lecturer" type="text" value="${lecturer.lecturerName}" />
	</c:forEach>
	
	<aui:input name="syllabusLastModifiedDate" type="text" value="<%= dateFormat.format(syllabus.getModifiedDate()) %>" />
	
	<aui:workflow-status markupView="lexicon" showIcon="<%= true %>" showLabel="<%= true %>" status="<%= syllabus.getStatus() %>" />
</c:if>