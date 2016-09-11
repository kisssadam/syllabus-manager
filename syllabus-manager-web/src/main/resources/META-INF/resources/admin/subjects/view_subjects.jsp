<%@include file="/init.jsp"%>

<%
	long curriculumId = ParamUtil.getLong(request, "curriculumId");

	Curriculum curriculum = null;

	if (curriculumId > 0) {
		curriculum = CurriculumLocalServiceUtil.getCurriculum(curriculumId);
	}
	
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("jspPage", "/admin/subjects/view_subjects.jsp");
	iteratorURL.setParameter("curriculumId", String.valueOf(curriculumId));
	
	int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
%>

<liferay-ui:success key="subjectAdded" message="subject-has-been-successfully-updated" />
<liferay-ui:success key="subjectUpdated" message="subject-has-been-successfully-updated" />
<liferay-ui:success key="subjectDeleted" message="subject-has-been-successfully-deleted" />
<liferay-ui:success key="subjectsDeleted" message="subjects-have-been-successfully-deleted" />

<c:set var="showCurriculumsLink" value="<%= true %>" scope="request"/>
<c:set var="curriculumId" value="<%= curriculum.getCurriculumId() %>" scope="request"/>

<jsp:include page="/admin/breadcrumb.jsp" />

<jsp:include page="/admin/navigation_bar.jsp" />

<aui:form method="post" name="fmSubject">
	<liferay-ui:search-container delta="<%=delta%>" emptyResultsMessage="subjects-not-found" iteratorURL="<%=iteratorURL%>" rowChecker="<%= new RowChecker(renderResponse) %>" total="<%=SubjectLocalServiceUtil.getSubjectsCountByCurriculumId(curriculumId)%>">
		<aui:input name="curriculumId" type="hidden" value="<%= curriculumId %>" />
		<aui:input name="deleteSubjectIds" type="hidden" />
		
		<liferay-ui:search-container-results
			results="<%=SubjectLocalServiceUtil.getSubjectsByCurriculumId(curriculumId, searchContainer.getStart(), searchContainer.getEnd())%>"
		/>
		
		<liferay-ui:search-container-row className="hu.unideb.inf.model.Subject" escapedModel="<%= true %>" modelVar="subject" keyProperty="subjectId">
			<c:if test='<%=SubjectPermission.contains(permissionChecker, subject.getSubjectId(), "VIEW")%>'>
				<portlet:renderURL var="viewCoursesURL">
					<portlet:param name="mvcPath" value="/admin/courses/view_courses.jsp" />
					<portlet:param name="subjectId" value="<%=String.valueOf(subject.getSubjectId())%>" />
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text name="subject-code" property="subjectCode" href="<%=viewCoursesURL.toString()%>" />
				<liferay-ui:search-container-column-text name="subject-name" property="subjectName" />
				<liferay-ui:search-container-column-text name="credit" property="credit" />
				<liferay-ui:search-container-column-jsp path="/admin/subjects/subject_actions.jsp" align="right" />
			</c:if>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>	
</aui:form>

<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, SyllabusActionKeys.DELETE_SUBJECTS)%>'>
	<portlet:actionURL name="deleteSubjects" var="deleteSubjectsURL">
		<portlet:param name="<%=SearchContainer.DEFAULT_DELTA_PARAM%>" value="<%=String.valueOf(delta)%>" />
	</portlet:actionURL>
	
	<aui:script use="aui-base">
		A.one('.removeCheckedItemsButton').on(
			'click',
			function(event) {
				<portlet:namespace />deleteSubjects();
			}
		);
		
	    Liferay.provide(
	        window,
	        '<portlet:namespace />deleteSubjects',
	        function() {
	            if (confirm('<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-permanently-delete-the-selected-items") %>'))  {
					document.<portlet:namespace />fmSubject.method = "post";
					document.<portlet:namespace />fmSubject.<portlet:namespace />deleteSubjectIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fmSubject, '<portlet:namespace />allRowIds');
					submitForm(document.<portlet:namespace />fmSubject, "<%=deleteSubjectsURL.toString()%>");
	            }
	        },
	        ['liferay-util-list-fields']
	    );
	</aui:script>
</c:if>