<%@include file="/html/init.jsp"%>

<liferay-ui:success key="curriculumAdded" message="curriculum-has-been-successfully-added" />
<liferay-ui:success key="curriculumUpdated" message="curriculum-has-been-successfully-updated" />
<liferay-ui:success key="curriculumDeleted" message="curriculum-has-been-successfully-deleted" />
<liferay-ui:success key="everyCurriculumDeleted" message="every-curriculum-has-been-successfully-deleted" />

<jsp:include page="/html/subjectcourseadmin/navigation_bar.jsp" />

<liferay-ui:header title="curriculums" />

<aui:button onClick='<%= renderResponse.getNamespace() + "deleteCurriculums();" %>' value="delete" />

<aui:form method="post" name="fmCurriculum">
	<liferay-ui:search-container emptyResultsMessage="curriculums-not-found" rowChecker="<%= new RowChecker(renderResponse) %>">
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

<aui:script>
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

<!--
https://www.liferay.com/community/forums/-/message_boards/message/24915122
https://jsumon.wordpress.com/2011/01/13/retrieve-selected-checkbox-value-in-liferay-6-with-auiscript-and-liferay-provide/

https://searchcode.com/codesearch/view/6760798/
liferay-plugins /portlets/knowledge-base-portlet/docroot/admin/common/history.jsp
https://github.com/liferay/liferay-portal/blob/6.1.x/portal-web/docroot/html/portlet/document_library_display/view_file_entries.jspf
https://github.com/eduardolundgren/alloy-ui-exercises/blob/master/01-basics/08-show-hide.html#L54

 -->
<aui:script use="aui-base">
	function toggleViewIfRequired(rowsChecked) {
		var deleteButton = A.one('.removeCheckedItemsButton');
		
		if (rowsChecked.size() > 0) {
			deleteButton.show();
		} else {
			deleteButton.hide();
		}
	}
	
	A.all('input[name=<portlet:namespace />rowIds]').on(
		'click',
		function(event) {
			var rowsChecked = A.all('input[name=<portlet:namespace />rowIds]:checked');
			
			toggleViewIfRequired(rowsChecked);
		}
	);
	
	A.all('input[name=<portlet:namespace />allRowIds]').on(
			'click',
			function(event) {
				var rowsChecked = A.all('input[name=<portlet:namespace />allRowIds]:checked');
				
				toggleViewIfRequired(rowsChecked);
			}
		);
</aui:script>
