<%@include file="/init.jsp"%>

<%
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("jspPage", "/admin/lecturers/view_lecturers.jsp");
	
	int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
%>

<liferay-ui:success key="lecturerAdded" message="lecturer-has-been-successfully-added" />
<liferay-ui:success key="lecturerUpdated" message="lecturer-has-been-successfully-updated" />
<liferay-ui:success key="lecturerDeleted" message="lecturer-has-been-successfully-deleted" />
<liferay-ui:success key="lecturersDeleted" message="lecturers-have-been-successfully-deleted" />

<c:set var="showLecturersLink" value="<%= true %>" scope="request"/>

<jsp:include page="/admin/breadcrumb.jsp" />

<jsp:include page="/admin/navigation_bar.jsp" />

<aui:form method="post" name="fmLecturer">
	<liferay-ui:search-container delta="<%=delta%>" emptyResultsMessage="lecturers-not-found" iteratorURL="<%=iteratorURL%>" rowChecker="<%= new RowChecker(renderResponse) %>" total="<%=LecturerLocalServiceUtil.getLecturersCount()%>">
		<aui:input name="deleteLecturerIds" type="hidden" />
	
		<liferay-ui:search-container-results
			results="<%=LecturerLocalServiceUtil.getLecturers(searchContainer.getStart(), searchContainer.getEnd())%>"
		/>
		
		<liferay-ui:search-container-row className="hu.unideb.inf.model.Lecturer" escapedModel="<%= true %>" modelVar="lecturer" keyProperty="lecturerId">
			<c:if test='<%=LecturerPermission.contains(permissionChecker, lecturer.getLecturerId(), "VIEW")%>'>
				
				<liferay-ui:search-container-column-text name="lecturer-name" property="lecturerName" />
				
				<liferay-ui:search-container-column-text name="lecturer-user-id" property="lecturerUserId" />
				
				<%
				User lecturerUser = UserLocalServiceUtil.fetchUserById(lecturer.getLecturerUserId());
				
				String lecturerScreenName = Validator.isNull(lecturerUser) ? StringPool.BLANK : lecturerUser.getScreenName();
				%>
				<liferay-ui:search-container-column-text name="lecturer-screenname" value="<%=lecturerScreenName%>" />
				
				<liferay-ui:search-container-column-jsp path="/admin/lecturers/lecturer_actions.jsp" align="right" />
			</c:if>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:form>

<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, SyllabusActionKeys.DELETE_LECTURERS)%>'>
	<portlet:actionURL name="deleteLecturers" var="deleteLecturersURL">
		<portlet:param name="<%=SearchContainer.DEFAULT_DELTA_PARAM%>" value="<%=String.valueOf(delta)%>" />
	</portlet:actionURL>
	
	<aui:script use="aui-base">
		A.one('.removeCheckedItemsButton').on(
			'click',
			function(event) {
				<portlet:namespace />deleteLecturers();
			}
		);
		
	    Liferay.provide(
	        window,
	        '<portlet:namespace />deleteLecturers',
	        function() {
	            if (confirm('<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-permanently-delete-the-selected-items") %>'))  {
					document.<portlet:namespace />fmLecturer.method = "post";                
					document.<portlet:namespace />fmLecturer.<portlet:namespace />deleteLecturerIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fmLecturer, '<portlet:namespace />allRowIds');
					submitForm(document.<portlet:namespace />fmLecturer, "<%=deleteLecturersURL.toString()%>");
	            }
	        },
	        ['liferay-util-list-fields']
	    );
	</aui:script>
</c:if>