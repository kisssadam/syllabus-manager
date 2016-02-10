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

	<aui:input name="timetableCourseId" type="hidden"
		value='<%=timetableCourse == null ? timetableCourseId : timetableCourse.getTimetableCourseId()%>' />

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

		<aui:select label="subject" name="subjectId" required="true" />

		<aui:select label="course" name="courseId" required="true" />

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

		<aui:input name="limit" type="number" min="0" value="<%=timetableCourse == null ? 0 : timetableCourse.getLimit()%>">
			<aui:validator name="required" />
			<aui:validator name="number" />
		</aui:input>

		<%-- lecturers ide :( aui select2 jo lenne --%>

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

<portlet:resourceURL var="resourceURL"></portlet:resourceURL>

<aui:script>
AUI().use('aui-base', 'aui-io-request', 'aui-node', 'node-event-simulate', function(A) {
	A.one("#<portlet:namespace/>curriculumId").on('change', function() {
		A.io.request('<%=resourceURL%>', {
             method: 'POST',
             data: {
            	 "<portlet:namespace/>curriculumId" : A.one("#<portlet:namespace/>curriculumId").val(),
            	 '<portlet:namespace/>curriculumSelected' :'curriculumSelected'
            	 },
             dataType: 'json',
             on: {
             	success: function() {
					var subjects = this.get('responseData');
					
	             	A.one('#<portlet:namespace />subjectId').empty();
	             	A.one('#<portlet:namespace />courseId').empty();
	
					for(var i in subjects){
						A.one('#<portlet:namespace />subjectId').append("<option value='" + subjects[i].subjectId + "' >" + subjects[i].subjectList + "</option> "); 
					}
					
					A.one('#<portlet:namespace/>subjectId').simulate("change");
				},
				failure: function() {
					A.one('#<portlet:namespace />subjectId').empty();
	             	A.one('#<portlet:namespace />courseId').empty();
				}
   			}
		});
	});
    
	A.one("#<portlet:namespace/>subjectId").on('change', function() {
		A.io.request('<%=resourceURL%>', {
			method :'POST',
			data: {
				'<portlet:namespace/>subjectId' : A.one("#<portlet:namespace/>subjectId").val(),
				'<portlet:namespace/>subjectSelected' : 'subjectSelected'
				},
			dataType: 'json',
			on: {
				success: function() {
					var courses = this.get('responseData');
					
					A.one('#<portlet:namespace />courseId').empty();
					
					for(var i in courses) {
						A.one('#<portlet:namespace />courseId').append("<option value='" + courses[i].courseId + "' >" + courses[i].courseList + "</option> ");
					}
					
					// this is required to revalidate the form
					A.one('#<portlet:namespace/>courseId').simulate("change");
				},
				failure: function() {
	             	A.one('#<portlet:namespace />courseId').empty();
				}
			}
		});
	});
});
</aui:script>