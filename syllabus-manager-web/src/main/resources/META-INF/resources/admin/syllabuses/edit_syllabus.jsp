<%@include file="/init.jsp"%>

<%
	String home = ParamUtil.getString(renderRequest, "home");
	String backURL = ParamUtil.getString(renderRequest, "backURL");

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
		
		timetableCourses = TimetableCourseLocalServiceUtil.getTimetableCoursesByCourseId(courseId);
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

	request.setAttribute("home", home);
	request.setAttribute("backURL", backURL);
	request.setAttribute("curriculumId", curriculumId);
	request.setAttribute("subjectId", subjectId);
	request.setAttribute("courseId", courseId);
	request.setAttribute("timetableCourseId", timetableCourseId);
	
	request.setAttribute("curriculums", curriculums);
	request.setAttribute("subjects", subjects);
	request.setAttribute("courses", courses);
	request.setAttribute("timetableCourses", timetableCourses);
%>

<%@ include file="/notifications/error.jspf" %>

<div class="closed container-fluid-1280 sidenav-container sidenav-right" id="<portlet:namespace />editSyllabusPanelId">
	<h1>
		<c:choose>
			<c:when test="<%=syllabusId > 0%>">
				<liferay-ui:header title="edit-syllabus" />
			</c:when>
			<c:otherwise>
				<liferay-ui:header title="add-syllabus" />
			</c:otherwise>
		</c:choose>
	</h1>
	
	<portlet:actionURL name="addSyllabus" var="addSyllabusURL">
		<portlet:param name="home" value="${home}" />
	</portlet:actionURL>
	
	<aui:form action="<%=addSyllabusURL%>" name="<portlet:namespace />syllabus_edit">
		<aui:model-context bean="<%=syllabus%>" model="<%=Syllabus.class%>" />
	
		<aui:input name="syllabusId" type="hidden"
			value='<%=syllabus == null ? syllabusId : syllabus.getSyllabusId()%>' />
	
		<liferay-ui:panel defaultState="open" extended="<%= true %>" id="syllabusSubjectSelectorPanel" persistState="<%= true %>" title="subject-selector-panel-title">
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
		
				<aui:select label="timetableCourse" name="timetableCourseSelect" required="true">
					<c:forEach items="${timetableCourses}" var="tc">
						<aui:option selected="${timetableCourseId eq tc.timetableCourseId}" value="${tc.timetableCourseId}">
							<liferay-ui:message key="timetable-course-code" /><c:out value=": ${tc.timetableCourseCode}, " />
							<liferay-ui:message key="subject-type" /><c:out value=": ${tc.subjectType}, " />
							<liferay-ui:message key="recommended-term" /><c:out value=": ${tc.recommendedTerm}, " />
							<liferay-ui:message key="limit" /><c:out value=": ${tc.limit}, " />
							<liferay-ui:message key="class-schedule-info" /><c:out value=": ${tc.classScheduleInfo}, " />
							<liferay-ui:message key="description" /><c:out value=": ${tc.description}" />
						</aui:option>
					</c:forEach>
				</aui:select>
			</aui:fieldset>
		</liferay-ui:panel>
	
		<liferay-ui:panel defaultState="open" extended="<%= true %>" id="syllabusDataPanel" persistState="<%= true %>" title="syllabus-data-panel-title">
			<aui:fieldset>
				<aui:input name="competence" type="textarea">
					<aui:validator name="required" />
				</aui:input>
		
				<aui:input name="ethicalStandards" type="textarea">
					<aui:validator name="required" />
				</aui:input>
				
				<aui:input name="topics" type="textarea">
					<aui:validator name="required" />
				</aui:input>
				
				<aui:input name="educationalMaterials" type="textarea">
					<aui:validator name="required" />
				</aui:input>
				
				<aui:input name="recommendedLiterature" type="textarea">
					<aui:validator name="required" />
				</aui:input>
				
				<%-- https://docs.liferay.com/portal/7.0/taglibs/util-taglib/ --%>
				<aui:field-wrapper name="weeklyTasks" label="weeklyTasks">
					<liferay-ui:input-editor
						contents="<%= syllabus == null ? StringPool.BLANK : syllabus.getWeeklyTasks() %>"
						name="weeklyTasks"
						toolbarSet="liferayArticle"
						showSource="<%= false %>" />
				</aui:field-wrapper>
			</aui:fieldset>
		</liferay-ui:panel>
		
		<liferay-ui:asset-categories-error />
		
		<liferay-ui:asset-tags-error />
		
		<liferay-ui:panel defaultState="closed" extended="<%= true %>" id="syllabusCategorizationPanel" persistState="<%= true %>" title="categorization">
			<aui:fieldset>
				<aui:input name="categories" type="assetCategories" />
				<aui:input name="tags" type="assetTags" />
			</aui:fieldset>
		</liferay-ui:panel>
	
		<liferay-ui:panel defaultState="closed" extended="<%= true %>" id="syllabusAssetLinksPanel" persistState="<%= true %>" title="related-assets">
			<aui:fieldset>
				<liferay-ui:input-asset-links className="<%= Syllabus.class.getName() %>" classPK="<%= syllabusId %>" />
			</aui:fieldset>
		</liferay-ui:panel>
	
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="cancel" onClick="${backURL}" />
		</aui:button-row>
	</aui:form>
</div>

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
					
					for (var i in timetableCourses) {
						var tc = timetableCourses[i];
						A.one('#<portlet:namespace />timetableCourseSelect').append(
							"<option value='" + tc.timetableCourseId + "' >" +
							"<liferay-ui:message key='timetable-course-code' />: " + tc.timetableCourseCode + ", " +
							"<liferay-ui:message key='subject-type' />: " + tc.subjectType + ", " +
							"<liferay-ui:message key='recommended-term' />: " + tc.recommendedTerm + ", " +
							"<liferay-ui:message key='limit' />: " + tc.limit+ ", " +
							"<liferay-ui:message key='class-schedule-info' />: " + tc.classScheduleInfo + ", " +
							"<liferay-ui:message key='description' />: " + tc.description +
							"</option> "
						);
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