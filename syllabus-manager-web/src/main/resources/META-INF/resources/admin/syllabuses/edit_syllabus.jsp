<%@include file="/init.jsp"%>

<%
	long syllabusId = ParamUtil.getLong(renderRequest, "syllabusId");
	long timetableCourseId = ParamUtil.getLong(renderRequest, "timetableCourseId");
	long courseId = ParamUtil.getLong(renderRequest, "courseId");
	long subjectId = ParamUtil.getLong(renderRequest, "subjectId");
	long curriculumId = ParamUtil.getLong(renderRequest, "curriculumId");

	Syllabus syllabus = null;

	List<Curriculum> curriculums = CurriculumLocalServiceUtil.getCurriculums();
	List<Subject> subjects = null;
	List<Course> courses = null;
	List<TimetableCourse> timetableCourses = null;

	if (syllabusId > 0) {
		syllabus = SyllabusLocalServiceUtil.getSyllabus(syllabusId);
		timetableCourseId = syllabus.getTimetableCourseId();
	}
	
	if (timetableCourseId > 0) {
		TimetableCourse timetableCourse = TimetableCourseLocalServiceUtil.getTimetableCourse(timetableCourseId);
		courseId = timetableCourse.getCourseId();
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
	
	if (Validator.isNull(timetableCourses)) {
		if (courses.size() > 0) {
			timetableCourses = TimetableCourseLocalServiceUtil.getTimetableCoursesByCourseId(courses.get(0).getCourseId());
		} else {
			timetableCourses = Collections.emptyList();
		}
	}

	request.setAttribute("curriculumId", curriculumId);
	request.setAttribute("subjectId", subjectId);
	request.setAttribute("courseId", courseId);
	request.setAttribute("timetableCourseId", timetableCourseId);
	
	request.setAttribute("curriculums", curriculums);
	request.setAttribute("subjects", subjects);
	request.setAttribute("courses", courses);
	request.setAttribute("timetableCourses", timetableCourses);
%>

<liferay-ui:error exception="<%=DuplicateSyllabusException.class%>" message="duplicate-syllabus-exception" />
<liferay-ui:error exception="<%=NoSuchSyllabusException.class%>" message="no-such-syllabus-exception" />
<liferay-ui:error exception="<%=NoSuchTimetableCourseException.class%>" message="no-such-timetable-course-exception" />
<liferay-ui:error exception="<%=NoSuchCourseException.class%>" message="no-such-course-exception" />
<liferay-ui:error exception="<%=NoSuchSubjectException.class%>" message="no-such-subject-exception" />

<c:choose>
	<c:when test="<%=syllabusId > 0%>">
		<liferay-ui:header title="edit-syllabus" />
	</c:when>
	<c:otherwise>
		<liferay-ui:header title="add-syllabus" />
	</c:otherwise>
</c:choose>

<portlet:renderURL var="viewURL">
	
</portlet:renderURL>

<portlet:actionURL name="addSyllabus" var="addSyllabusURL" />

<aui:form action="<%=addSyllabusURL%>" name="<portlet:namespace />syllabus_edit">
	<aui:model-context bean="<%=syllabus%>" model="<%=Syllabus.class%>" />

	<aui:input name="syllabusId" type="hidden"
		value='<%=syllabus == null ? syllabusId : syllabus.getSyllabusId()%>' />

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
					<c:out value="${subject}" />
				</aui:option>
			</c:forEach>
		</aui:select>

		<aui:select label="course" name="courseSelect" required="true">
			<c:forEach items="${courses}" var="course">
				<aui:option selected="${courseId eq course.courseId}" value="${course.courseId}">
					<c:out value="${course}" />
				</aui:option>
			</c:forEach>
		</aui:select>

		<aui:select label="timetableCourse" name="timetableCourseSelect" required="true">
			<c:forEach items="${timetableCourses}" var="timetableCourse">
				<aui:option selected="${timetableCourseId eq timetableCourse.timetableCourseId}" value="${timetableCourse.timetableCourseId}">
					<c:out value="${timetableCourse}" />
				</aui:option>
			</c:forEach>
		</aui:select>

		<aui:input name="competence" type="text">
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="ethicalStandards" type="text">
			<aui:validator name="required" />
		</aui:input>
		
		<aui:input name="topics" type="text">
			<aui:validator name="required" />
		</aui:input>
		
		<aui:input name="educationalMaterials" type="text">
			<aui:validator name="required" />
		</aui:input>
		
		<aui:input name="recommendedLiterature" type="text">
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
	A.one("#<portlet:namespace/>curriculumSelect").on('change', function() {
		A.io.request('<%=resourceURL%>', {
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
	             	A.one('#<portlet:namespace />timetableCourseSelect').empty();
	
					for(var i in subjects){
						A.one('#<portlet:namespace />subjectSelect').append("<option value='" + subjects[i].subjectId + "' >" + subjects[i].subjectList + "</option> "); 
					}
					
					A.one('#<portlet:namespace/>subjectSelect').simulate("change");
				},
				failure: function() {
					A.one('#<portlet:namespace />subjectSelect').empty();
	             	A.one('#<portlet:namespace />courseSelect').empty();
	             	A.one('#<portlet:namespace />timetableCourseSelect').empty();
				}
   			}
		});
	});
    
	A.one("#<portlet:namespace/>subjectSelect").on('change', function() {
		A.io.request('<%=resourceURL%>', {
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
					A.one('#<portlet:namespace />timetableCourseSelect').empty();
					
					for(var i in courses) {
						A.one('#<portlet:namespace />courseSelect').append("<option value='" + courses[i].courseId + "' >" + courses[i].courseList + "</option> ");
					}
					
					// this is required to revalidate the form
					A.one('#<portlet:namespace/>courseSelect').simulate("change");
				},
				failure: function() {
	             	A.one('#<portlet:namespace />courseSelect').empty();
	             	A.one('#<portlet:namespace />timetableCourseSelect').empty();
				}
			}
		});
	});

	A.one("#<portlet:namespace/>courseSelect").on('change', function() {
		A.io.request('<%=resourceURL%>', {
			method :'POST',
			data: {
				'<portlet:namespace/>courseSelect' : A.one("#<portlet:namespace/>courseSelect").val(),
				'<portlet:namespace/>courseSelected' : 'courseSelected'
				},
			dataType: 'json',
			on: {
				success: function() {
					var timetableCourses = this.get('responseData');

					A.one('#<portlet:namespace />timetableCourseSelect').empty();
					
					for(var i in timetableCourses) {
						A.one('#<portlet:namespace />timetableCourseSelect').append("<option value='" + timetableCourses[i].timetableCourseId + "' >" + timetableCourses[i].timetableCourseList + "</option> ");
					}
					
					// this is required to revalidate the form
					A.one('#<portlet:namespace/>timetableCourseSelect').simulate("change");
				},
				failure: function() {
	             	A.one('#<portlet:namespace />timetableCourseSelect').empty();
				}
			}
		});
	});
});
</aui:script>