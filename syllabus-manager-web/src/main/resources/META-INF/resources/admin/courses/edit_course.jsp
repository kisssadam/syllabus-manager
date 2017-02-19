<%@include file="/init.jsp"%>

<%
	String backURL = ParamUtil.getString(renderRequest, "backURL");
	long courseId = ParamUtil.getLong(renderRequest, "courseId");
	long subjectId = ParamUtil.getLong(renderRequest, "subjectId");
	long curriculumId = ParamUtil.getLong(renderRequest, "curriculumId");

	List<Curriculum> curriculums = CurriculumLocalServiceUtil.getCurriculums();
	List<CourseType> courseTypes = CourseTypeLocalServiceUtil.getCourseTypes();
	List<Subject> subjects = null;
	Course course = null;

	if (courseId > 0) {
		course = CourseLocalServiceUtil.getCourse(courseId);
		subjectId = course.getSubjectId();
	}

	if (subjectId > 0) {
		Subject subject = SubjectLocalServiceUtil.getSubject(subjectId);
		curriculumId = subject.getCurriculumId();
	}
	
	if (curriculumId > 0) {
		subjects = SubjectLocalServiceUtil.getSubjectsByCurriculumId(curriculumId);
	} else {
		if (Validator.isNotNull(curriculums) && curriculums.size() > 0) {
			subjects = SubjectLocalServiceUtil.getSubjectsByCurriculumId(curriculums.get(0).getCurriculumId());
		} else {
			subjects = Collections.emptyList();
		}
	}

	request.setAttribute("backURL", backURL);
	request.setAttribute("curriculumId", curriculumId);
	request.setAttribute("subjectId", subjectId);
	request.setAttribute("curriculums", curriculums);
	request.setAttribute("courseTypes", courseTypes);
	request.setAttribute("subjects", subjects);
%>

<%@ include file="/notifications/error.jspf" %>

<div class="closed container-fluid-1280 sidenav-container sidenav-right" id="<portlet:namespace />editCoursePanelId">
	<h1>
		<c:choose>
			<c:when test="<%=courseId > 0%>">
				<liferay-ui:header title="edit-course" />
			</c:when>
			<c:otherwise>
				<liferay-ui:header title="add-course" />
			</c:otherwise>
		</c:choose>
	</h1>

	<portlet:actionURL name="addCourse" var="addCourseURL" />
	
	<aui:form action="<%=addCourseURL%>" name="<portlet:namespace />course_edit">
		<aui:model-context bean="<%=course%>" model="<%=Course.class%>" />
	
		<aui:input name="courseId" type="hidden" value='<%=course == null ? courseId : course.getCourseId()%>' />
	
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
	
			<aui:select label="courseType" name="courseTypeId" required="true">
				<c:forEach items="${courseTypes}" var="courseType">
					<aui:option value="${courseType.courseTypeId}">
						<c:out value="${courseType.typeName}" />
					</aui:option>
				</c:forEach>
			</aui:select>
	
			<aui:input name="hoursPerSemester" type="number" min="0"
				value="<%=course == null ? 0 : course.getHoursPerSemester()%>">
				<aui:validator name="required" />
				<aui:validator name="number" />
			</aui:input>
	
			<aui:input name="hoursPerWeek" type="number" min="0" value="<%=course == null ? 0 : course.getHoursPerWeek()%>">
				<aui:validator name="required" />
				<aui:validator name="number" />
			</aui:input>
		</aui:fieldset>
	
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="cancel" onClick="${backURL}" />
		</aui:button-row>
	</aui:form>
</div>

<%--
	http://rasul.work/index.php/2015/09/04/liferay-service-builder-json-javascript/
--%>

<portlet:resourceURL id="<%=WebKeys.MVC_RESOURCE_SERVE_SUBJECTS%>" var="subjectsResourceURL"></portlet:resourceURL>

<aui:script>
AUI().use('aui-base', 'aui-io-request', 'aui-node', 'node-event-simulate', function(A) {
	A.one("#<portlet:namespace/>curriculumSelect").on('change', function() {
		A.io.request('<%=subjectsResourceURL%>', {
             method: 'POST',
             data: {
            	 "<portlet:namespace/>curriculumSelect" : A.one("#<portlet:namespace/>curriculumSelect").val()
           	 },
             dataType: 'json',
             on: {
             	success: function() {
					var subjects = this.get('responseData');
					
	             	A.one('#<portlet:namespace />subjectSelect').empty();
	
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
				}
   			}
		});
	});
});
</aui:script>