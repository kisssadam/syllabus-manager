<%@include file="/html/init.jsp"%>

<%
	long curriculumId = ParamUtil.getLong(renderRequest, "curriculumId");

	Curriculum curriculum = null;

	if (curriculumId > 0) {
		curriculum = CurriculumLocalServiceUtil.getCurriculum(curriculumId);
	}
%>

<c:set var="curriculumId" value="<%= curriculum.getCurriculumId() %>" scope="request"/>
<jsp:include page="/html/subjectcourseadmin/breadcrumb.jsp" />
	
<jsp:include page="/html/subjectcourseadmin/navigation_bar.jsp" />

<aui:form method="post" name="fmSubject">
	<liferay-ui:search-container emptyResultsMessage="subjects-not-found" rowChecker="<%= new RowChecker(renderResponse) %>">
		<aui:input name="curriculumId" type="hidden" value="<%= curriculumId %>" />
		<aui:input name="deleteSubjectIds" type="hidden" />
		
		<liferay-ui:search-container-results
			results="<%=SubjectLocalServiceUtil.getSubjectsByCurriculumId(curriculumId, searchContainer.getStart(), searchContainer.getEnd())%>"
			total="<%=SubjectLocalServiceUtil.getSubjectsCountByCurriculumId(curriculumId)%>"
		/>
		
		<liferay-ui:search-container-row className="hu.unideb.inf.model.Subject" modelVar="subject" keyProperty="subjectId">
			<c:if test='<%=SubjectPermission.contains(permissionChecker, subject.getSubjectId(), "VIEW")%>'>
				<portlet:renderURL var="viewSubjectURL">
					<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view_subject.jsp" />
					<portlet:param name="subjectId" value="<%=String.valueOf(subject.getSubjectId())%>" />
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text name="subject-code" property="subjectCode" href="<%=viewSubjectURL.toString()%>" />
				<liferay-ui:search-container-column-text name="subject-name" property="subjectName" />
				<liferay-ui:search-container-column-text name="credit" property="credit" />
				<liferay-ui:search-container-column-jsp path="/html/subjectcourseadmin/subject_actions.jsp" align="right" />
			</c:if>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>	
</aui:form>

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
            if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-permanently-delete-the-selected-items") %>'))  {
				document.<portlet:namespace />fmSubject.method = "post";
				document.<portlet:namespace />fmSubject.<portlet:namespace />deleteSubjectIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fmSubject, '<portlet:namespace />allRowIds');
				submitForm(document.<portlet:namespace />fmSubject, '<portlet:actionURL name="deleteSubjects"></portlet:actionURL>');
            }
        },
        ['liferay-util-list-fields']
    );
</aui:script>
