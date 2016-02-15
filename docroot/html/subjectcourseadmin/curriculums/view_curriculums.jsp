<%@include file="/html/init.jsp"%>

<%
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("jspPage", "/html/subjectcourseadmin/curriculums/view_curriculums.jsp");
	
	int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
%>

<liferay-ui:success key="curriculumAdded" message="curriculum-has-been-successfully-added" />
<liferay-ui:success key="curriculumUpdated" message="curriculum-has-been-successfully-updated" />
<liferay-ui:success key="curriculumDeleted" message="curriculum-has-been-successfully-deleted" />
<liferay-ui:success key="curriculumsDeleted" message="curriculums-have-been-successfully-deleted" />

<c:set var="showCurriculumsLink" value="<%= true %>" scope="request"/>

<jsp:include page="/html/subjectcourseadmin/breadcrumb.jsp" />

<jsp:include page="/html/subjectcourseadmin/navigation_bar.jsp" />

<aui:form method="post" name="fmCurriculum">
	<liferay-ui:search-container delta="<%=delta%>" emptyResultsMessage="curriculums-not-found" iteratorURL="<%=iteratorURL%>" rowChecker="<%= new RowChecker(renderResponse) %>">
		<aui:input name="deleteCurriculumIds" type="hidden" />
	
		<liferay-ui:search-container-results
			results="<%=CurriculumLocalServiceUtil.getCurriculums(searchContainer.getStart(), searchContainer.getEnd())%>"
			total="<%=CurriculumLocalServiceUtil.getCurriculumsCount()%>"
		/>
		
		<liferay-ui:search-container-row className="hu.unideb.inf.model.Curriculum" escapedModel="<%= true %>" modelVar="curriculum" keyProperty="curriculumId">
			<c:if test='<%=CurriculumPermission.contains(permissionChecker, curriculum.getCurriculumId(), "VIEW")%>'>
				<portlet:renderURL var="viewSubjectsURL">
					<portlet:param name="mvcPath" value="/html/subjectcourseadmin/subjects/view_subjects.jsp" />
					<portlet:param name="curriculumId" value="<%=String.valueOf(curriculum.getCurriculumId())%>" />
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text name="curriculum-code" property="curriculumCode" href="<%=viewSubjectsURL.toString()%>" />
				<liferay-ui:search-container-column-text name="curriculum-name" property="curriculumName" />
				<liferay-ui:search-container-column-jsp path="/html/subjectcourseadmin/curriculums/curriculum_actions.jsp" align="right" />
			</c:if>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:form>

<!--
https://www.liferay.com/community/forums/-/message_boards/message/24915122
https://jsumon.wordpress.com/2011/01/13/retrieve-selected-checkbox-value-in-liferay-6-with-auiscript-and-liferay-provide/

https://searchcode.com/codesearch/view/6760798/
liferay-plugins /portlets/knowledge-base-portlet/docroot/admin/common/history.jsp
https://github.com/liferay/liferay-portal/blob/6.1.x/portal-web/docroot/html/portlet/document_library_display/view_file_entries.jspf
https://github.com/eduardolundgren/alloy-ui-exercises/blob/master/01-basics/08-show-hide.html#L54
-->

<portlet:actionURL name="deleteCurriculums" var="deleteCurriculumsURL">
	<portlet:param name="<%=SearchContainer.DEFAULT_DELTA_PARAM%>" value="<%=String.valueOf(delta)%>" />
</portlet:actionURL>

<aui:script use="aui-base">
	A.one('.removeCheckedItemsButton').on(
		'click',
		function(event) {
			<portlet:namespace />deleteCurriculums();
		}
	);
	
    Liferay.provide(
        window,
        '<portlet:namespace />deleteCurriculums',
        function() {
            if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-permanently-delete-the-selected-items") %>'))  {
				document.<portlet:namespace />fmCurriculum.method = "post";                
				document.<portlet:namespace />fmCurriculum.<portlet:namespace />deleteCurriculumIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fmCurriculum, '<portlet:namespace />allRowIds');
				submitForm(document.<portlet:namespace />fmCurriculum, "<%=deleteCurriculumsURL.toString()%>");
            }
        },
        ['liferay-util-list-fields']
    );
</aui:script>
