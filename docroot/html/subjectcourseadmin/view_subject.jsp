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

<aui:form method="post" name="fmCourse">
	<liferay-ui:search-container emptyResultsMessage="courses-not-found" rowChecker="<%= new RowChecker(renderResponse) %>">
		<aui:input name="subjectId" type="hidden" value="<%= subjectId %>" />
		<aui:input name="deleteCourseIds" type="hidden" />
		
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
</aui:form>

<aui:script use="aui-base">
	A.one('.removeCheckedItemsButton').on(
		'click',
		function(event) {
			<portlet:namespace />deleteCourses();
		}
	);
	
    Liferay.provide(
        window,
        '<portlet:namespace />deleteCourses',
        function() {
            if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-permanently-delete-the-selected-items") %>'))  {
				document.<portlet:namespace />fmCourse.method = "post";
				document.<portlet:namespace />fmCourse.<portlet:namespace />deleteCourseIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fmCourse, '<portlet:namespace />allRowIds');
				submitForm(document.<portlet:namespace />fmCourse, '<portlet:actionURL name="deleteCourses"></portlet:actionURL>');
            }
        },
        ['liferay-util-list-fields']
    );
</aui:script>
