<%@include file="/html/init.jsp"%>

<%
	long timetableCourseId = ParamUtil.getLong(renderRequest, "timetableCourseId");
	long courseId = ParamUtil.getLong(renderRequest, "courseId");
	long subjectId = ParamUtil.getLong(renderRequest, "subjectId");
	long curriculumId = ParamUtil.getLong(renderRequest, "curriculumId");
	long semesterId = ParamUtil.getLong(renderRequest, "semesterId");

	TimetableCourse timetableCourse = null;

	if (timetableCourseId > 0) {
		timetableCourse = TimetableCourseLocalServiceUtil.getTimetableCourse(timetableCourseId);
		courseId = timetableCourse.getCourseId();
		semesterId = timetableCourse.getSemesterId();
	}
	
	if (courseId > 0) {
		Course course = CourseLocalServiceUtil.getCourse(courseId);
		subjectId = course.getSubjectId();
	}

	if (subjectId > 0) {
		Subject subject = SubjectLocalServiceUtil.getSubject(subjectId);
		curriculumId = subject.getCurriculumId();
	}

	request.setAttribute("curriculumId", curriculumId);
	request.setAttribute("subjectId", subjectId);
	request.setAttribute("courseId", courseId);
	request.setAttribute("semesterId", semesterId);
	
	request.setAttribute("curriculums", CurriculumLocalServiceUtil.getCurriculums());
	request.setAttribute("semesters", SemesterLocalServiceUtil.getSemesters());
%>

<liferay-ui:error exception="<%=DuplicateTimetableCourseException.class%>" message="duplicate-timetable-course-exception" />
<liferay-ui:error exception="<%=NoSuchTimetableCourseException.class%>" message="no-such-timetable-course-exception" />
<liferay-ui:error exception="<%=NoSuchCourseException.class%>" message="no-such-course-exception" />
<liferay-ui:error exception="<%=NoSuchSubjectException.class%>" message="no-such-subject-exception" />
<liferay-ui:error exception="<%=TimetableCourseCodeException.class%>" message="timetable-course-code-exception" />
<liferay-ui:error exception="<%=TimetableCourseRecommendedTermException.class%>" message="timetable-course-recommended-term-exception" />
<liferay-ui:error exception="<%=TimetableCourseLecturerNameException.class%>" message="timetable-course-lecturer-name-exception" />
<liferay-ui:error exception="<%=TimetableCourseLimitException.class%>" message="timetable-course-limit-exception" />
<liferay-ui:error exception="<%=TimetableCourseSubjectTypeException.class%>" message="timetable-course-subject-type-exception" />

<liferay-ui:header title="edit-timetable-course" />

<portlet:renderURL var="viewURL">
	<c:choose>
		<c:when test="${subjectId gt 0}">
			<portlet:param name="mvcPath" value="/html/subjectcourseadmin/courses/view_courses.jsp" />
			<portlet:param name="subjectId" value="${subjectId}" />
		</c:when>
		<c:when test="${curriculumId gt 0}">
			<portlet:param name="mvcPath" value="/html/subjectcourseadmin/subjects/view_subjects.jsp" />
			<portlet:param name="curriculumId" value="${curriculumId}" />
		</c:when>
		<c:otherwise>
			<portlet:param name="mvcPath" value="/html/subjectcourseadmin/curriculums/view_curriculums.jsp" />
		</c:otherwise>
	</c:choose>
</portlet:renderURL>

<portlet:actionURL name="addTimetableCourse" var="addTimetableCourseURL" />

<aui:form action="<%=addTimetableCourseURL%>" name="<portlet:namespace />timetable_course_edit">
	<aui:model-context bean="<%=timetableCourse%>" model="<%=TimetableCourse.class%>" />

	<aui:input name="timetableCourseId" type="hidden" value='<%=timetableCourse == null ? timetableCourseId : timetableCourse.getTimetableCourseId()%>' />

	<aui:fieldset>
		<aui:select label="curriculum" name="curriculumId" required="true">
			<c:forEach items="${curriculums}" var="curriculum">
				<c:choose>
					<c:when test="${curriculumId eq curriculum.curriculumId}">
						<c:set var="isCurriculumSelected" value="true" />
					</c:when>
					<c:otherwise>
						<c:set var="isCurriculumSelected" value="false" />
					</c:otherwise>
				</c:choose>
				<aui:option selected="${isCurriculumSelected}" value="${curriculum.curriculumId}">
					<c:out value="${curriculum.curriculumCode} - ${curriculum.curriculumName}" />
				</aui:option>
			</c:forEach>
		</aui:select>

		<aui:select label="subject" name="subjectId" required="true">
			<%-- <c:forEach items="${subjects}" var="subject">
				<aui:option value="${subject.subjectId}">
					<c:out value="${subject.subjectCode} - ${subject.subjectName}" />
				</aui:option>
			</c:forEach> --%>
		</aui:select>
		
		<aui:select label="course" name="courseId" required="true">
			<%-- <c:forEach items="${courses}" var="course">
				<aui:option value="${course.courseId}">
					<c:set var="courseTypeId" value="${course.courseTypeId}" />
					<%
					CourseType courseType = CourseTypeLocalServiceUtil.getCourseType(GetterUtil.getLong(pageContext.getAttribute("courseTypeId"), 0));
					%>
					<c:out value="<%=courseType.getType()%> - hps: ${course.hoursPerSemester} - hpw: ${course.hoursPerWeek}" />
				</aui:option>
			</c:forEach> --%>
		</aui:select>

		<aui:select label="semester" name="semesterId" required="true">
			<c:forEach items="${semesters}" var="semester">
				<aui:option value="${semester.semesterId}">
					<c:out value="${semester.beginYear}/${semester.endYear}/${semester.division}" />
				</aui:option>
			</c:forEach>
		</aui:select>
		
		<aui:input name="timetableCourseCode" type="text">
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="subjectType" type="text">
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="recommendedTerm" type="number" min="0"
			value="<%=timetableCourse == null ? 0 : timetableCourse.getRecommendedTerm()%>">
			<aui:validator name="required" />
			<aui:validator name="number" />
		</aui:input>
		
		<aui:input name="limit" type="number" min="0"
			value="<%=timetableCourse == null ? 0 : timetableCourse.getLimit()%>">
			<aui:validator name="required" />
			<aui:validator name="number" />
		</aui:input>
		
		<%-- lecturers ide :( --%>
		
		<aui:input name="classScheduleInfo" type="text">
			<aui:validator name="required" />
		</aui:input>
		
		<aui:input name="description" type="text">
			<aui:validator name="required" />
		</aui:input>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel" onClick="<%= viewURL %>" />
	</aui:button-row>
</aui:form>

<%--
	http://rasul.work/index.php/2015/09/04/liferay-service-builder-json-javascript/
--%>

<aui:script use="aui-base">
AUI().ready(
	function() {
		updateSubjectIds();
		updateCourseIds();
	}
);

AUI().ready('aui-dialog', "node", function(A) {
	A.one("#<portlet:namespace />curriculumId").on("change", function(e) {
		updateSubjectIds();
		updateCourseIds();
	});
});

AUI().ready('aui-dialog', "node", function(A) {
	A.one("#<portlet:namespace />subjectId").on("change", function(e) {
		updateCourseIds();
	});
});

function updateSubjectIds() {
	var selectedCurriculumId = A.one("#<portlet:namespace />curriculumId").val();
	if (selectedCurriculumId > 0) {
		Liferay.Service(
			'/unideb-syllabus-manager-portlet.subject/get-subjects-by-curriculum-id',
			{
				curriculumId: selectedCurriculumId
			},
			function(obj) {
				A.one("#<portlet:namespace />subjectId").val("");
				document.getElementById('<portlet:namespace/>subjectId').options.length = obj.length;
				for(var i = 0; i < obj.length; i++){
					var subject = obj[i];
					
					document.getElementById('<portlet:namespace/>subjectId').options[i]= new Option(subject.subjectCode + " - " + subject.subjectName, subject.subjectId);
					document.getElementById('<portlet:namespace/>subjectId').options[i].selected = subject.subjectId == "${subjectId}" ? true : false;
				}
			}
		);
	}
	
	AUI().ready("node", "node-event-simulate", function(A) {
		var changedNode = A.one('#<portlet:namespace/>subjectId');
		changedNode.simulate("change");
	});
}

function updateCourseIds() {
	var selectedSubjectId = A.one("#<portlet:namespace />subjectId").val();
	if (selectedSubjectId > 0) {
		Liferay.Service(
				'/unideb-syllabus-manager-portlet.course/get-courses-by-subject-id',
			{
				subjectId: selectedSubjectId
			},
			function(obj) {
				A.one("#<portlet:namespace />courseId").val("");
				document.getElementById('<portlet:namespace/>courseId').options.length = obj.length;
				for(var i = 0; i < obj.length; i++){
					var course = obj[i];
					
					document.getElementById('<portlet:namespace/>courseId').options[i]= new Option(course.courseTypeId + " hps: "  + course.hoursPerSemester + " hpw: " + course.hoursPerWeek);
					document.getElementById('<portlet:namespace/>courseId').options[i].selected = course.courseId == "${courseId}" ? true : false;
				}
			}
		);
	}
	
	AUI().ready("node", "node-event-simulate", function(A) {
		var changedNode = A.one('#<portlet:namespace/>courseId');
		changedNode.simulate("change");
	});
}
</aui:script>