<%@include file="/init.jsp"%>

<%
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("jspPage", WebKeys.VIEW_SEMESTERS);
	
	int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
%>

<%@ include file="/notifications/success.jspf" %>
<%@ include file="/notifications/error.jspf" %>

<c:set var="home" value="<%=WebKeys.ADMIN_HOME_SEMESTERS%>" scope="request" />

<jsp:include page="/admin/navigation_bar.jsp" />
<jsp:include page="/admin/breadcrumb.jsp" />

<aui:form method="post" name="fmSemester">
	<liferay-ui:search-container delta="<%=delta%>" emptyResultsMessage="semesters-not-found" iteratorURL="<%=iteratorURL%>" rowChecker="<%= new RowChecker(renderResponse) %>" total="<%=SemesterLocalServiceUtil.getSemestersCount()%>">
		<aui:input name="deleteSemesterIds" type="hidden" />
		
		<liferay-ui:search-container-results
			results="<%=SemesterLocalServiceUtil.getSemesters(searchContainer.getStart(), searchContainer.getEnd())%>"
		/>
		
		<liferay-ui:search-container-row className="hu.unideb.inf.model.Semester" escapedModel="<%= true %>" modelVar="semester" keyProperty="semesterId">
			<c:if test='<%=SemesterPermission.contains(permissionChecker, semester.getSemesterId(), "VIEW")%>'>
				<portlet:renderURL var="viewTimetableCoursesURL">
					<portlet:param name="mvcPath" value="<%=WebKeys.VIEW_TIMETABLE_COURSES%>" />
					<portlet:param name="home" value="${home}" />
					<portlet:param name="semesterId" value="<%=String.valueOf(semester.getSemesterId())%>" />
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text name="semester" value="<%=HtmlUtil.escapeAttribute(semester.toString())%>" href="<%=viewTimetableCoursesURL.toString()%>" />
				<liferay-ui:search-container-column-jsp path="/admin/semesters/semester_actions.jsp" align="right" />
			</c:if>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:form>

<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, SyllabusActionKeys.DELETE_SEMESTERS)%>'>
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
	            if (confirm('<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-permanently-delete-the-selected-items") %>'))  {
					document.<portlet:namespace />fmSemester.method = "post";                
					document.<portlet:namespace />fmSemester.<portlet:namespace />deleteSemesterIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fmSemester, '<portlet:namespace />allRowIds');
					submitForm(document.<portlet:namespace />fmSemester, "<%=deleteSemestersURL.toString()%>");
	            }
	        },
	        ['liferay-util-list-fields']
	    );
	</aui:script>
</c:if>