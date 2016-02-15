<%@include file="/html/init.jsp"%>

<%
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("jspPage", "/html/subjectcourseadmin/semesters/view_semesters.jsp");
	
	int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
%>

<liferay-ui:success key="semesterAdded" message="semester-has-been-successfully-added" />
<liferay-ui:success key="semesterUpdated" message="semester-has-been-successfully-updated" />
<liferay-ui:success key="semesterDeleted" message="semester-has-been-successfully-deleted" />
<liferay-ui:success key="semestersDeleted" message="semesters-have-been-successfully-deleted" />

<liferay-ui:error exception="<%=DuplicateSemesterException.class%>" message="duplicate-semester" />

<c:set var="showSemestersLink" value="<%= true %>" scope="request"/>

<jsp:include page="/html/subjectcourseadmin/breadcrumb.jsp" />

<jsp:include page="/html/subjectcourseadmin/navigation_bar.jsp" />

<aui:form method="post" name="fmSemester">
	<liferay-ui:search-container delta="<%=delta%>" emptyResultsMessage="semesters-not-found" iteratorURL="<%=iteratorURL%>" rowChecker="<%= new RowChecker(renderResponse) %>">
		<aui:input name="deleteSemesterIds" type="hidden" />
		
		<liferay-ui:search-container-results
			results="<%=SemesterLocalServiceUtil.getSemesters(searchContainer.getStart(), searchContainer.getEnd())%>"
			total="<%=SemesterLocalServiceUtil.getSemestersCount()%>"
		/>
		
		<liferay-ui:search-container-row className="hu.unideb.inf.model.Semester" escapedModel="<%= true %>" modelVar="semester" keyProperty="semesterId">
			<c:if test='<%=SemesterPermission.contains(permissionChecker, semester.getSemesterId(), "VIEW")%>'>
				<portlet:renderURL var="viewTimetableCoursesURL">
					<portlet:param name="mvcPath" value="/html/subjectcourseadmin/timetablecourses/view_timetable_courses.jsp" />
					<portlet:param name="semesterId" value="<%=String.valueOf(semester.getSemesterId())%>" />
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text name="semester" value="<%=HtmlUtil.escapeAttribute(semester.toString())%>" href="<%=viewTimetableCoursesURL.toString()%>" />
				<liferay-ui:search-container-column-jsp path="/html/subjectcourseadmin/semesters/semester_actions.jsp" align="right" />
			</c:if>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:form>

<portlet:actionURL name="deleteSemesters" var="deleteSemestersURL">
	<portlet:param name="<%=SearchContainer.DEFAULT_DELTA_PARAM%>" value="<%=String.valueOf(delta)%>" />
</portlet:actionURL>

<aui:script use="aui-base">
	A.one('.removeCheckedItemsButton').on(
		'click',
		function(event) {
			<portlet:namespace />deleteSemesters();
		}
	);
	
    Liferay.provide(
        window,
        '<portlet:namespace />deleteSemesters',
        function() {
            if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-permanently-delete-the-selected-items") %>'))  {
				document.<portlet:namespace />fmSemester.method = "post";                
				document.<portlet:namespace />fmSemester.<portlet:namespace />deleteSemesterIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fmSemester, '<portlet:namespace />allRowIds');
				submitForm(document.<portlet:namespace />fmSemester, "<%=deleteSemestersURL.toString()%>");
            }
        },
        ['liferay-util-list-fields']
    );
</aui:script>
