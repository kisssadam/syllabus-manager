<%@include file="/init.jsp"%>

<%
	String home = ParamUtil.getString(renderRequest, "home");

	long timetableCourseId = ParamUtil.getLong(renderRequest, "timetableCourseId");
	long courseId = ParamUtil.getLong(renderRequest, "courseId");
	long subjectId = ParamUtil.getLong(renderRequest, "subjectId");
	long curriculumId = ParamUtil.getLong(renderRequest, "curriculumId");
	long semesterId = ParamUtil.getLong(renderRequest, "semesterId");
	
	TimetableCourse timetableCourse = null;
	Course course = null;
	Subject subject = null;
	
	if (timetableCourseId > 0) {
		timetableCourse = TimetableCourseLocalServiceUtil.getTimetableCourse(timetableCourseId);
		courseId = timetableCourse.getCourseId();
		semesterId = timetableCourse.getSemesterId();
	}
	
	if (courseId > 0) {
		course = CourseLocalServiceUtil.getCourse(courseId);
		subjectId = course.getSubjectId();
	}
	
	if (subjectId > 0) {
		subject = SubjectLocalServiceUtil.getSubject(course.getSubjectId());
		curriculumId = subject.getCurriculumId();
	}
	
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("jspPage", "/admin/syllabuses/view_syllabuses_by_timetable_course.jsp");
	iteratorURL.setParameter("timetableCourseId", String.valueOf(timetableCourseId));
	
	int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
%>

<liferay-ui:success key="syllabusAdded" message="syllabus-has-been-successfully-updated" />
<liferay-ui:success key="syllabusUpdated" message="syllabus-has-been-successfully-updated" />
<liferay-ui:success key="syllabusDeleted" message="syllabus-has-been-successfully-deleted" />
<liferay-ui:success key="syllabusesDeleted" message="syllabuses-have-been-successfully-deleted" />

<c:choose>
	<c:when test="<%=StringUtil.equalsIgnoreCase(home, "curriculums")%>">
		<c:set var="home" value="curriculums" scope="request" />
		<c:set var="curriculumId" value="<%=curriculumId%>" scope="request" />
		<c:set var="subjectId" value="<%=subjectId%>" scope="request" />
		<c:set var="courseId" value="<%=courseId%>" scope="request" />
		<c:set var="timetableCourseId" value="<%=timetableCourseId%>" scope="request" />
	</c:when>
	<c:when test="<%=StringUtil.equalsIgnoreCase(home, "semesters")%>">
		<c:set var="home" value="semesters" scope="request" />
		<c:set var="semesterId" value="<%=semesterId%>" scope="request" />
		<c:set var="timetableCourseId" value="<%=timetableCourseId%>" scope="request" />
	</c:when>
	<c:otherwise>
		
	</c:otherwise>
</c:choose>

<jsp:include page="/admin/navigation_bar.jsp" />

<jsp:include page="/admin/breadcrumb.jsp" />

<aui:form method="post" name="fmSyllabus">
	<liferay-ui:search-container
		delta="<%=delta%>"
		emptyResultsMessage="syllabuses-not-found"
		iteratorURL="<%=iteratorURL%>"
		rowChecker="<%= new RowChecker(renderResponse) %>"
		total="<%=SyllabusLocalServiceUtil.getSyllabusesCountByTimetableCourseId(timetableCourseId)%>">
		
		<aui:input name="timetableCourseId" type="hidden" value="<%=String.valueOf(timetableCourseId)%>" />
		
		<aui:input name="deleteSyllabusIds" type="hidden" />
		
		<liferay-ui:search-container-results
			results="<%=SyllabusLocalServiceUtil.getSyllabusesByTimetableCourseId(timetableCourseId, searchContainer.getStart(), searchContainer.getEnd())%>"
		/>
		
		<liferay-ui:search-container-row className="hu.unideb.inf.model.Syllabus" escapedModel="<%= true %>" modelVar="syllabus" keyProperty="syllabusId">
			<c:if test='<%=SyllabusPermission.contains(permissionChecker, syllabus.getSyllabusId(), "VIEW")%>'>
				<%
				Semester semester = SemesterLocalServiceUtil.getSemester(timetableCourse.getSemesterId());
				
				CourseType courseType = CourseTypeLocalServiceUtil.getCourseType(course.getCourseTypeId());
				
				Curriculum curriculum = CurriculumLocalServiceUtil.getCurriculum(subject.getCurriculumId());
				%>
				<liferay-ui:search-container-column-text name="competence" property="competence" />
				<liferay-ui:search-container-column-text name="ethical-standards" property="ethicalStandards" />
				<liferay-ui:search-container-column-text name="topics" property="topics" />
				<liferay-ui:search-container-column-text name="educational-materials" property="educationalMaterials" />
				<liferay-ui:search-container-column-text name="recommended-literature" property="recommendedLiterature" />
				<liferay-ui:search-container-column-text name="weekly-tasks" property="weeklyTasks" />
				
				<liferay-ui:search-container-column-jsp path="/admin/syllabuses/syllabus_actions.jsp" align="right" />
			</c:if>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>	
</aui:form>

<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, SyllabusActionKeys.DELETE_SYLLABUSES)%>'>
	<portlet:actionURL name="deleteSyllabuses" var="deleteSyllabusesURL">
		<portlet:param name="<%=SearchContainer.DEFAULT_DELTA_PARAM%>" value="<%=String.valueOf(delta)%>" />
	</portlet:actionURL>
	
	<aui:script use="aui-base">
		A.one('.removeCheckedItemsButton').on(
			'click',
			function(event) {
				<portlet:namespace />deleteSyllabuses();
			}
		);
		
	    Liferay.provide(
	        window,
	        '<portlet:namespace />deleteSyllabuses',
	        function() {
	            if (confirm('<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-permanently-delete-the-selected-items") %>'))  {
					document.<portlet:namespace />fmSyllabus.method = "post";
					document.<portlet:namespace />fmSyllabus.<portlet:namespace />deleteSyllabusIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fmSyllabus, '<portlet:namespace />allRowIds');
					submitForm(document.<portlet:namespace />fmSyllabus, "<%=deleteSyllabusesURL.toString()%>");
	            }
	        },
	        ['liferay-util-list-fields']
	    );
	</aui:script>
</c:if>