<%@include file="/html/init.jsp"%>

<c:set var="showCourseTypesLink" value="<%= true %>" scope="request"/>

<jsp:include page="/html/subjectcourseadmin/breadcrumb.jsp" />

<jsp:include page="/html/subjectcourseadmin/navigation_bar.jsp" />

<aui:form method="post" name="fmCourseType">
	<liferay-ui:search-container emptyResultsMessage="course-types-not-found" rowChecker="<%= new RowChecker(renderResponse) %>">
		<aui:input name="deleteCourseTypeIds" type="hidden" />
		
		<liferay-ui:search-container-results
			results="<%=CourseTypeLocalServiceUtil.getCourseTypes(searchContainer.getStart(), searchContainer.getEnd())%>"
			total="<%=CourseTypeLocalServiceUtil.getCourseTypesCount()%>"
		/>
		
		<liferay-ui:search-container-row className="hu.unideb.inf.model.CourseType" modelVar="courseType" keyProperty="courseTypeId">
			<c:if test='<%=CourseTypePermission.contains(permissionChecker, courseType.getCourseTypeId(), "VIEW")%>'>
				<liferay-ui:search-container-column-text name="course-type" property="type" />
				<liferay-ui:search-container-column-jsp path="/html/subjectcourseadmin/course_type_actions.jsp" align="right" />
			</c:if>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:form>

<aui:script use="aui-base">
	A.one('.removeCheckedItemsButton').on(
		'click',
		function(event) {
			<portlet:namespace />deleteCourseTypes();
		}
	);
	
    Liferay.provide(
        window,
        '<portlet:namespace />deleteCourseTypes',
        function() {
            if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-permanently-delete-the-selected-items") %>'))  {
				document.<portlet:namespace />fmCourseType.method = "post";
				document.<portlet:namespace />fmCourseType.<portlet:namespace />deleteCourseTypeIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fmCourseType, '<portlet:namespace />allRowIds');
				submitForm(document.<portlet:namespace />fmCourseType, '<portlet:actionURL name="deleteCourseTypes"></portlet:actionURL>');
            }
        },
        ['liferay-util-list-fields']
    );
</aui:script>
