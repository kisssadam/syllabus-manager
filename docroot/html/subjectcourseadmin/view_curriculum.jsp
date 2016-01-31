<%@include file="/html/init.jsp"%>

<%
	long curriculumId = ParamUtil.getLong(renderRequest, "curriculumId");

	Curriculum curriculum = null;

	if (curriculumId > 0) {
		curriculum = CurriculumLocalServiceUtil.getCurriculum(curriculumId);
	}
%>

<jsp:include page="/html/subjectcourseadmin/navigation_bar.jsp" />


<c:if test='<%=curriculum != null%>'>
	<ul>
		<li><b>Curriculum:</b> <%=curriculum.getCurriculumCode()%> - <%=curriculum.getCurriculumName()%></li>
	</ul>
	<hr>
	
	<liferay-ui:search-container emptyResultsMessage="subjects-not-found">
		<liferay-ui:search-container-results
			results="<%=SubjectLocalServiceUtil.getSubjectsByCurriculumId(curriculumId, searchContainer.getStart(), searchContainer.getEnd())%>"
			total="<%=SubjectLocalServiceUtil.getSubjectsCountByCurriculumId(curriculumId)%>"
		/>
		
		<liferay-ui:search-container-row className="hu.unideb.inf.model.Subject" modelVar="subject" keyProperty="subjectId">
			<c:if test='<%=SubjectPermission.contains(permissionChecker, subject.getSubjectId(), "VIEW")%>'>
				<portlet:renderURL var="viewSubjectURL">
					<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view_subject.jsp" />
					<portlet:param name="curriculumId" value="<%=String.valueOf(curriculumId)%>" />
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
</c:if>
