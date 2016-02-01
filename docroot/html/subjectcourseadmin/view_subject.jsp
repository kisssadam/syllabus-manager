<%@include file="/html/init.jsp"%>

<%
	long subjectId = ParamUtil.getLong(renderRequest, "subjectId");

	Subject subject = null;
	
	if (subjectId > 0) {
		subject = SubjectLocalServiceUtil.getSubject(subjectId);
	}
%>

<c:set var="curriculumId" value="<%= subject.getCurriculumId() %>" scope="request"/>
<c:set var="subjectId" value="<%= subject.getSubjectId() %>" scope="request"/>
<jsp:include page="/html/subjectcourseadmin/breadcrumb.jsp" />

<jsp:include page="/html/subjectcourseadmin/navigation_bar.jsp" />
	
<liferay-ui:search-container emptyResultsMessage="courses-not-found">
	<liferay-ui:search-container-results
		results="<%=CourseLocalServiceUtil.getCoursesBySubjectId(subjectId, searchContainer.getStart(), searchContainer.getEnd())%>"
		total="<%=CourseLocalServiceUtil.getCoursesCountBySubjectId(subjectId)%>"
	/>
	
	<liferay-ui:search-container-row className="hu.unideb.inf.model.Course" modelVar="course" keyProperty="courseId">
		<c:if test='<%=CoursePermission.contains(permissionChecker, course.getCourseId(), "VIEW")%>'>				
			<liferay-ui:search-container-column-text name="course-type"
				value="<%=CourseTypeLocalServiceUtil.getCourseType(course.getCourseTypeId()).getType()%>" />
			<liferay-ui:search-container-column-text name="hours-per-semester" property="hoursPerSemester" />
			<liferay-ui:search-container-column-text name="hours-per-week" property="hoursPerWeek" />
			<liferay-ui:search-container-column-jsp path="/html/subjectcourseadmin/course_actions.jsp" align="right" />
		</c:if>
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
</liferay-ui:search-container>	
