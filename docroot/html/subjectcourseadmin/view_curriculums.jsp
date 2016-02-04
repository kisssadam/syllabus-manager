<%@include file="/html/init.jsp"%>

<%
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("jspPage", "/html/subjectcourseadmin/view_curriculums.jsp");
%>

<c:set var="showCurriculumsLink" value="<%= true %>" scope="request"/>

<jsp:include page="/html/subjectcourseadmin/breadcrumb.jsp" />

<jsp:include page="/html/subjectcourseadmin/navigation_bar.jsp" />

<aui:form method="post" name="fmCurriculum">
	<liferay-ui:search-container emptyResultsMessage="curriculums-not-found" iteratorURL="<%=iteratorURL%>" rowChecker="<%= new RowChecker(renderResponse) %>">
		<aui:input name="deleteCurriculumIds" type="hidden" />
	
		<liferay-ui:search-container-results
			results="<%=CurriculumLocalServiceUtil.getCurriculums(searchContainer.getStart(), searchContainer.getEnd())%>"
			total="<%=CurriculumLocalServiceUtil.getCurriculumsCount()%>"
		/>
		
		<liferay-ui:search-container-row className="hu.unideb.inf.model.Curriculum" modelVar="curriculum" keyProperty="curriculumId">
			<c:if test='<%=CurriculumPermission.contains(permissionChecker, curriculum.getCurriculumId(), "VIEW")%>'>
				<portlet:renderURL var="viewCurriculumURL">
					<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view_curriculum.jsp" />
					<portlet:param name="curriculumId" value="<%=String.valueOf(curriculum.getCurriculumId())%>" />
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text name="curriculum-code" property="curriculumCode" href="<%=viewCurriculumURL.toString()%>" />
				<liferay-ui:search-container-column-text name="curriculum-name" property="curriculumName" />
				<liferay-ui:search-container-column-jsp path="/html/subjectcourseadmin/curriculum_actions.jsp" align="right" />
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
				submitForm(document.<portlet:namespace />fmCurriculum, '<portlet:actionURL name="deleteCurriculums"></portlet:actionURL>');
            }
        },
        ['liferay-util-list-fields']
    );
</aui:script>
