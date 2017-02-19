<%@include file="/init.jsp"%>

<%
	String home = ParamUtil.getString(renderRequest, "home");
	String backURL = ParamUtil.getString(renderRequest, "backURL");
	long timetableCourseId = ParamUtil.getLong(renderRequest, "timetableCourseId");
	long courseId = ParamUtil.getLong(renderRequest, "courseId");
	long subjectId = ParamUtil.getLong(renderRequest, "subjectId");
	long curriculumId = ParamUtil.getLong(renderRequest, "curriculumId");
	long semesterId = ParamUtil.getLong(renderRequest, "semesterId");

	TimetableCourse timetableCourse = null;

	List<Curriculum> curriculums = CurriculumLocalServiceUtil.getCurriculums();
	List<Lecturer> lecturers = LecturerLocalServiceUtil.getLecturers();
	List<Lecturer> selectedLecturers = Collections.emptyList();
	List<Subject> subjects = null;
	List<Course> courses = null;

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

		courses = CourseLocalServiceUtil.getCoursesBySubjectId(subjectId);
	}

	if (curriculumId <= 0) {
		if (Validator.isNotNull(curriculums) && curriculums.size() > 0) {
			curriculumId = curriculums.get(0).getCurriculumId();
		} else {
			curriculums = Collections.emptyList();
		}
	}

	if (Validator.isNull(subjects)) {
		if (curriculums.size() > 0) {
			subjects = SubjectLocalServiceUtil.getSubjectsByCurriculumId(curriculumId);
		} else {
			subjects = Collections.emptyList();
		}
	}

	if (Validator.isNull(courses)) {
		if (subjects.size() > 0) {
			courses = CourseLocalServiceUtil.getCoursesBySubjectId(subjects.get(0).getSubjectId());
		} else {
			courses = Collections.emptyList();
		}
	}

	request.setAttribute("home", home);
	request.setAttribute("backURL", backURL);
	request.setAttribute("curriculumId", curriculumId);
	request.setAttribute("subjectId", subjectId);
	request.setAttribute("courseId", courseId);
	request.setAttribute("semesterId", semesterId);
	
	if (Validator.isNotNull(timetableCourse)) {
		selectedLecturers = TimetableCourseLocalServiceUtil.getLecutersByTimetableCourseId(timetableCourseId);
	}
	
	request.setAttribute("selectedLecturers", selectedLecturers);
	request.setAttribute("lecturers", lecturers);
	request.setAttribute("curriculums", curriculums);
	request.setAttribute("subjects", subjects);
	request.setAttribute("courses", courses);
	request.setAttribute("semesters", SemesterLocalServiceUtil.getSemesters());
%>

<%@ include file="/notifications/error.jspf" %>

<div class="closed container-fluid-1280 sidenav-container sidenav-right" id="<portlet:namespace />editTimetableCoursePanelId">
	<h1>
		<c:choose>
			<c:when test="<%=timetableCourseId > 0%>">
				<liferay-ui:header title="edit-timetable-course" />
			</c:when>
			<c:otherwise>
				<liferay-ui:header title="add-timetable-course" />
			</c:otherwise>
		</c:choose>
	</h1>
	
	<portlet:actionURL name="addTimetableCourse" var="addTimetableCourseURL" />
	
	<aui:form action="<%=addTimetableCourseURL%>" name="<portlet:namespace />timetable_course_edit">
		<aui:model-context bean="<%=timetableCourse%>" model="<%=TimetableCourse.class%>" />
	
		<aui:input name="timetableCourseId" type="hidden"
			value='<%=timetableCourse == null ? timetableCourseId : timetableCourse.getTimetableCourseId()%>' />
	
		<aui:fieldset>
			<aui:select label="curriculum" name="curriculumSelect" required="true">
				<c:forEach items="${curriculums}" var="curriculum">
					<aui:option selected="${curriculumId eq curriculum.curriculumId}" value="${curriculum.curriculumId}">
						<c:out value="${curriculum.curriculumCode} - ${curriculum.curriculumName}" />
					</aui:option>
				</c:forEach>
			</aui:select>
	
			<aui:select label="subject" name="subjectSelect" required="true">
				<c:forEach items="${subjects}" var="subject">
					<aui:option selected="${subjectId eq subject.subjectId}" value="${subject.subjectId}">
						<c:out value="${subject.subjectCode} - ${subject.subjectName}" />
					</aui:option>
				</c:forEach>
			</aui:select>

			<aui:select label="course" name="courseSelect" required="true">
				<c:forEach items="${courses}" var="course">
					<%
					Course course = (Course) pageContext.getAttribute("course");
					CourseType courseType = CourseTypeLocalServiceUtil.getCourseType(course.getCourseTypeId()).toEscapedModel();
					pageContext.setAttribute("courseType", courseType);
					%>
					<aui:option selected="${courseId eq course.courseId}" value="${course.courseId}">
						<c:out value="${courseType.typeName}: ${course.hoursPerSemester}" />
						<liferay-ui:message key="hours-per-semester" /><c:out value=", ${course.hoursPerWeek}" />
						<liferay-ui:message key="hours-per-week" />
					</aui:option>
				</c:forEach>
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
	
			<aui:input name="limit" type="number" min="0" value="<%=timetableCourse == null ? 0 : timetableCourse.getLimit()%>">
				<aui:validator name="required" />
				<aui:validator name="number" />
			</aui:input>
			
			<div id="lecturer-fields">
				<c:choose>
					<c:when test="${empty selectedLecturers}">
						<div class="lfr-form-row lfr-form-row-inline">
							<div class="row-fields" style="display: flex;">
								<aui:select label="lecturer" name="lecturer1" required="true">
									<c:forEach items="${lecturers}" var="lecturer">
										<aui:option value="${lecturer.lecturerId}">
											<c:out value="${lecturer.lecturerName}" />
										</aui:option>
									</c:forEach>
								</aui:select>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<c:forEach items="${selectedLecturers}" var="selectedlecturer" varStatus="selectedLecturerStatus">
							<div class="lfr-form-row lfr-form-row-inline">
								<div class="row-fields" style="display: flex;">
									<aui:select label="lecturer" name="lecturer${selectedLecturerStatus.index + 1}" required="true">
										<c:forEach items="${lecturers}" var="lecturer">
											<aui:option value="${lecturer.lecturerId}" selected="${lecturer eq selectedlecturer}">
												<c:out value="${lecturer.lecturerName}" />
											</aui:option>
										</c:forEach>
									</aui:select>
								</div>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
	
			<aui:input name="classScheduleInfo" type="text" />
	
			<aui:input name="description" type="text" />
		</aui:fieldset>
	
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="cancel" onClick="${backURL}" />
		</aui:button-row>
	</aui:form>
</div>

<portlet:resourceURL id="/syllabusmanager/admin/serve_subjects" var="subjectsResourceURL"></portlet:resourceURL>
<portlet:resourceURL id="/syllabusmanager/admin/serve_courses" var="coursesResourceURL"></portlet:resourceURL>

<aui:script use="liferay-auto-fields">
new Liferay.AutoFields({
		contentBox: '#lecturer-fields',
		fieldIndexes: '<portlet:namespace />rowIndexes'
}).render();
</aui:script>

<aui:script>
AUI().use('aui-base', 'aui-io-request', 'aui-node', 'node-event-simulate', function(A) {
	A.one("#<portlet:namespace/>curriculumSelect").on('change', function() {
		A.io.request('<%=subjectsResourceURL%>', {
             method: 'POST',
             data: {
            	 "<portlet:namespace/>curriculumSelect" : A.one("#<portlet:namespace/>curriculumSelect").val(),
            	 '<portlet:namespace/>curriculumSelected' :'curriculumSelected'
           	 },
             dataType: 'json',
             on: {
             	success: function() {
					var subjects = this.get('responseData');
					
	             	A.one('#<portlet:namespace />subjectSelect').empty();
	             	A.one('#<portlet:namespace />courseSelect').empty();
	
	             	for (var i in subjects) {
						var subject = subjects[i];

						A.one('#<portlet:namespace />subjectSelect').append(
							"<option value='" + subject.subjectId + "' >" +
							subject.subjectCode + " - " + subject.subjectName +
							"</option> "
						); 
					}
					
					A.one('#<portlet:namespace/>subjectSelect').simulate("change");
				},
				failure: function() {
					A.one('#<portlet:namespace />subjectSelect').empty();
	             	A.one('#<portlet:namespace />courseSelect').empty();
				}
   			}
		});
	});
    
	A.one("#<portlet:namespace/>subjectSelect").on('change', function() {
		A.io.request('<%=coursesResourceURL%>', {
			method :'POST',
			data: {
				'<portlet:namespace/>subjectSelect' : A.one("#<portlet:namespace/>subjectSelect").val(),
				'<portlet:namespace/>subjectSelected' : 'subjectSelected'
			},
			dataType: 'json',
			on: {
				success: function() {
					var courses = this.get('responseData');
					
					A.one('#<portlet:namespace />courseSelect').empty();
					
					for (var i in courses) {
						var course = courses[i];
						
						A.one('#<portlet:namespace />courseSelect').append(
							"<option value='" + course.courseId + "' >" +
							course.courseTypeName + ": " +
							course.hoursPerSemester + " <liferay-ui:message key='hours-per-semester' />" + ", " +
							course.hoursPerWeek + " <liferay-ui:message key='hours-per-week' />" +
							"</option> "
						);
					}
					
					// this is required to revalidate the form
					A.one('#<portlet:namespace/>courseSelect').simulate("change");
				},
				failure: function() {
	             	A.one('#<portlet:namespace />courseSelect').empty();
				}
			}
		});
	});
});
</aui:script>