<%@include file="/init.jsp"%>

<%
	Syllabus syllabus = (Syllabus) request.getAttribute(SyllabusWebKeys.SYLLABUS);
	
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
	<aui:panel>
		<aui:input name="curriculum" type="text" value="${curriculum.curriculumCode} - ${curriculum.curriculumName}" />
		
		<aui:input name="semester" type="text" value="${semester.beginYear}/${semester.endYear}/${semester.division}" />
		
		<aui:input name="subject" type="text" value="${subject.subjectCode} - ${subject.subjectName}" />
		
		<aui:input name="credit" type="text" value="${subject.credit}" />
		
		<aui:input name="hoursPerSemester" type="text" value="${course.hoursPerSemester}" />
		
		<aui:input name="hoursPerWeek" type="text" value="${course.hoursPerWeek}" />
		
		<aui:input name="courseType" type="text" value="${courseType.typeName}" />
		
		<aui:input name="timetableCourseCode" type="text" value="${timetableCourse.timetableCourseCode}" />
		
		<aui:input name="subjectType" type="text" value="${timetableCourse.subjectType}" />
		
		<aui:input name="recommendedTerm" type="text" value="${timetableCourse.recommendedTerm}" />
		
		<aui:input name="limit" type="text" value="${timetableCourse.limit}" />
		
		<c:forEach items="${lecturers}" var="lecturer">
			<aui:input name="lecturer" type="text" value="${lecturer.lecturerName}" />
		</c:forEach>
		
		<aui:input name="classScheduleInfo" type="textarea" value="${timetableCourse.classScheduleInfo}" />
		
		<aui:input name="description" type="textArea" value="${timetableCourse.description}" />
		
		<aui:input name="competence" type="textArea" value="${syllabus.competence}" />
		
		<aui:input name="ethicalStandards" type="textArea" value="${syllabus.ethicalStandards}" />
		
		<aui:input name="topics" type="textArea" value="${syllabus.topics}" />
		
		<aui:input name="educationalMaterials" type="textArea" value="${syllabus.educationalMaterials}" />
		
		<aui:input name="recommendedLiterature" type="textArea" value="${syllabus.recommendedLiterature}" />
		
		<aui:input name="weeklyTasks" type="textArea" value="${syllabus.weeklyTasks}" />
		
		<aui:input name="syllabusLastModifiedDate" type="text" value="<%= dateFormat.format(syllabus.getModifiedDate()) %>" />
		
		<aui:workflow-status markupView="lexicon" showIcon="<%= true %>" showLabel="<%= true %>" status="<%= syllabus.getStatus() %>" />
	</aui:panel>
</c:if>