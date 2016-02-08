<%@include file="/html/init.jsp"%>

<%
	long courseId = ParamUtil.getLong(renderRequest, "courseId");
	long subjectId = ParamUtil.getLong(renderRequest, "subjectId");
	long curriculumId = ParamUtil.getLong(renderRequest, "curriculumId");

	Course course = null;

	if (courseId > 0) {
		course = CourseLocalServiceUtil.getCourse(courseId);
		subjectId = course.getSubjectId();
	}

	if (subjectId > 0) {
		Subject subject = SubjectLocalServiceUtil.getSubject(subjectId);
		curriculumId = subject.getCurriculumId();
	}

	request.setAttribute("curriculumId", curriculumId);
	request.setAttribute("subjectId", subjectId);
	request.setAttribute("curriculums", CurriculumLocalServiceUtil.getCurriculums());
	request.setAttribute("courseTypes", CourseTypeLocalServiceUtil.getCourseTypes());
%>

<liferay-ui:error exception="<%=DuplicateCourseException.class%>" message="duplicate-course-exception" />
<liferay-ui:error exception="<%=NoSuchCourseTypeException.class%>" message="no-such-course-type-exception" />
<liferay-ui:error exception="<%=NoSuchSubjectException.class%>" message="no-such-subject-exception" />
<liferay-ui:error exception="<%=CourseHoursException.class%>" message="course-hours-exception" />

<liferay-ui:header title="edit-course" />

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

<portlet:actionURL name="addCourse" var="addCourseURL" />

<aui:form action="<%=addCourseURL%>" name="<portlet:namespace />course_edit">
	<aui:model-context bean="<%=course%>" model="<%=Course.class%>" />

	<aui:input name="courseId" type="hidden" value='<%=course == null ? courseId : course.getCourseId()%>' />

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
			<c:forEach items="${subjects}" var="subject">
				<aui:option value="${subject.subjectId}">
					<c:out value="${subject.subjectCode} - ${subject.subjectName}" />
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

		<aui:select label="courseType" name="courseTypeId" required="true">
			<c:forEach items="${courseTypes}" var="courseType">
				<aui:option value="${courseType.courseTypeId}">
					<c:out value="${courseType.type}" />
				</aui:option>
			</c:forEach>
		</aui:select>
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
	}
);

AUI().ready('aui-dialog', "node", function(A) {
	A.one("#<portlet:namespace />curriculumId").on("change", function(e) {
		updateSubjectIds();
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
</aui:script>