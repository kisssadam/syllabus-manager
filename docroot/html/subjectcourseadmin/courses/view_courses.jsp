<%@include file="/html/init.jsp"%>

<%
	long subjectId = ParamUtil.getLong(renderRequest, "subjectId");

	Subject subject = null;
	
	if (subjectId > 0) {
		subject = SubjectLocalServiceUtil.getSubject(subjectId);
	}
	
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("jspPage", "/html/subjectcourseadmin/courses/view_courses.jsp");
	iteratorURL.setParameter("subjectId", String.valueOf(subjectId));
	
	int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
%>

<liferay-ui:success key="courseAdded" message="course-has-been-successfully-updated" />
<liferay-ui:success key="courseUpdated" message="course-has-been-successfully-updated" />
<liferay-ui:success key="courseDeleted" message="course-has-been-successfully-deleted" />
<liferay-ui:success key="coursesDeleted" message="courses-have-been-successfully-deleted" />

<c:set var="showCurriculumsLink" value="<%= true %>" scope="request"/>
<c:set var="curriculumId" value="<%= subject.getCurriculumId() %>" scope="request"/>
<c:set var="subjectId" value="<%= subject.getSubjectId() %>" scope="request"/>

<jsp:include page="/html/subjectcourseadmin/breadcrumb.jsp" />

<jsp:include page="/html/subjectcourseadmin/navigation_bar.jsp" />

<aui:form method="post" name="fmCourse">
	<liferay-ui:search-container delta="<%=delta%>" emptyResultsMessage="courses-not-found" iteratorURL="<%=iteratorURL%>" rowChecker="<%= new RowChecker(renderResponse) %>">
		<aui:input name="subjectId" type="hidden" value="<%= subjectId %>" />
		<aui:input name="deleteCourseIds" type="hidden" />
		
		<liferay-ui:search-container-results
			results="<%=CourseLocalServiceUtil.getCoursesBySubjectId(subjectId, searchContainer.getStart(), searchContainer.getEnd())%>"
			total="<%=CourseLocalServiceUtil.getCoursesCountBySubjectId(subjectId)%>"
		/>
		
		<liferay-ui:search-container-row className="hu.unideb.inf.model.Course" escapedModel="<%= true %>" modelVar="course" keyProperty="courseId">
			<c:if test='<%=CoursePermission.contains(permissionChecker, course.getCourseId(), "VIEW")%>'>				
				<portlet:renderURL var="viewTimetableCoursesURL">
					<portlet:param name="mvcPath" value="/html/subjectcourseadmin/timetablecourses/view_timetable_courses_by_course.jsp" />
					<portlet:param name="courseId" value="<%=String.valueOf(course.getCourseId())%>" />
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text name="course-type"
					value="<%=HtmlUtil.escapeAttribute(CourseTypeLocalServiceUtil.getCourseType(course.getCourseTypeId()).getTypeName())%>" href="<%=viewTimetableCoursesURL.toString()%>" />
				<liferay-ui:search-container-column-text name="hours-per-semester" property="hoursPerSemester" />
				<liferay-ui:search-container-column-text name="hours-per-week" property="hoursPerWeek" />
				<liferay-ui:search-container-column-jsp path="/html/subjectcourseadmin/courses/course_actions.jsp" align="right" />
			</c:if>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>	
</aui:form>

<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.DELETE_COURSES)%>'>
	<portlet:actionURL name="deleteCourses" var="deleteCoursesURL">
		<portlet:param name="<%=SearchContainer.DEFAULT_DELTA_PARAM%>" value="<%=String.valueOf(delta)%>" />
	</portlet:actionURL>
	
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
					submitForm(document.<portlet:namespace />fmCourse, "<%=deleteCoursesURL.toString()%>");
	            }
	        },
	        ['liferay-util-list-fields']
	    );
	</aui:script>
</c:if>