<%@ include file="/init.jsp"%>

<jsp:include page="/admin/navigation_bar.jsp" />

<div class="closed container-fluid-1280 sidenav-container sidenav-right">
	<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, SyllabusActionKeys.EXPORT_DATA)%>'>
		<aui:col span="6">
			<liferay-ui:header title="export" />
			
			<aui:button-row>
				<aui:col span="6">
					<portlet:resourceURL id="<%=WebKeys.MVC_RESOURCE_EXPORT_DATA%>" var="exportSyllabusDataCsvURL">
						<liferay-portlet:param name="contentType" value="<%=ContentTypes.TEXT_CSV_UTF8%>" />
						<liferay-portlet:param name="entityType" value="<%=WebKeys.SYLLABUS%>" />
					</portlet:resourceURL>
					
					<aui:button icon="icon-download" href="<%= exportSyllabusDataCsvURL.toString() %>" value="export-syllabus-data-csv" cssClass="col-xs-12 export-import-button" />
				</aui:col>
			
				<aui:col span="6">
					<portlet:resourceURL id="<%=WebKeys.MVC_RESOURCE_EXPORT_DATA%>" var="exportSyllabusDataXmlURL">
						<liferay-portlet:param name="contentType" value="<%=ContentTypes.TEXT_XML_UTF8%>" />
						<liferay-portlet:param name="entityType" value="<%=WebKeys.SYLLABUS%>" />
					</portlet:resourceURL>
					
					<aui:button icon="icon-download" href="<%= exportSyllabusDataXmlURL.toString() %>" value="export-syllabus-data-xml" cssClass="col-xs-12 export-import-button" />
				</aui:col>
			</aui:button-row>
			
			<aui:button-row>
				<aui:col span="6">
					<portlet:resourceURL id="<%=WebKeys.MVC_RESOURCE_EXPORT_DATA%>" var="exportLecturerDataCsvURL">
						<liferay-portlet:param name="contentType" value="<%=ContentTypes.TEXT_CSV_UTF8%>" />
						<liferay-portlet:param name="entityType" value="<%=WebKeys.LECTURER%>" />
					</portlet:resourceURL>
					
					<aui:button icon="icon-download" href="<%= exportLecturerDataCsvURL.toString() %>" value="export-lecturer-data-csv" cssClass="col-xs-12 export-import-button" />
				</aui:col>
				
				<aui:col span="6">
					<portlet:resourceURL id="<%=WebKeys.MVC_RESOURCE_EXPORT_DATA%>" var="exportLecturerDataXmlURL">
						<liferay-portlet:param name="contentType" value="<%=ContentTypes.TEXT_XML_UTF8%>" />
						<liferay-portlet:param name="entityType" value="<%=WebKeys.LECTURER%>" />
					</portlet:resourceURL>
					
					<aui:button icon="icon-download" href="<%= exportLecturerDataXmlURL.toString() %>" value="export-lecturer-data-xml" cssClass="col-xs-12 export-import-button" />
				</aui:col>
			</aui:button-row>
			
			<aui:button-row>
				<aui:col span="6">
					<portlet:resourceURL id="<%=WebKeys.MVC_RESOURCE_EXPORT_DATA%>" var="exportSemesterDataCsvURL">
						<liferay-portlet:param name="contentType" value="<%=ContentTypes.TEXT_CSV_UTF8%>" />
						<liferay-portlet:param name="entityType" value="<%=WebKeys.SEMESTER%>" />
					</portlet:resourceURL>
					
					<aui:button icon="icon-download" href="<%= exportSemesterDataCsvURL.toString() %>" value="export-semester-data-csv" cssClass="col-xs-12 export-import-button" />
				</aui:col>
				
				<aui:col span="6">
					<portlet:resourceURL id="<%=WebKeys.MVC_RESOURCE_EXPORT_DATA%>" var="exportSemesterDataXmlURL">
						<liferay-portlet:param name="contentType" value="<%=ContentTypes.TEXT_XML_UTF8%>" />
						<liferay-portlet:param name="entityType" value="<%=WebKeys.SEMESTER%>" />
					</portlet:resourceURL>
					
					<aui:button icon="icon-download" href="<%= exportSemesterDataXmlURL.toString() %>" value="export-semester-data-xml" cssClass="col-xs-12 export-import-button" />
				</aui:col>
			</aui:button-row>
			
			<aui:button-row>
				<aui:col span="6">
					<portlet:resourceURL id="<%=WebKeys.MVC_RESOURCE_EXPORT_DATA%>" var="exportCourseTypeDataCsvURL">
						<liferay-portlet:param name="contentType" value="<%=ContentTypes.TEXT_CSV_UTF8%>" />
						<liferay-portlet:param name="entityType" value="<%=WebKeys.COURSE_TYPE%>" />
					</portlet:resourceURL>
					
					<aui:button icon="icon-download" href="<%= exportCourseTypeDataCsvURL.toString() %>" value="export-course-type-data-csv" cssClass="col-xs-12 export-import-button" />
				</aui:col>
				
				<aui:col span="6">
					<portlet:resourceURL id="<%=WebKeys.MVC_RESOURCE_EXPORT_DATA%>" var="exportCourseTypeDataXmlURL">
						<liferay-portlet:param name="contentType" value="<%=ContentTypes.TEXT_XML_UTF8%>" />
						<liferay-portlet:param name="entityType" value="<%=WebKeys.COURSE_TYPE%>" />
					</portlet:resourceURL>
					
					<aui:button icon="icon-download" href="<%= exportCourseTypeDataXmlURL.toString() %>" value="export-course-type-data-xml" cssClass="col-xs-12 export-import-button" />
				</aui:col>
			</aui:button-row>
		</aui:col>
	</c:if>
	
	<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, SyllabusActionKeys.IMPORT_DATA)%>'>
		<aui:col span="6">
			<liferay-ui:header title="import" />
			
			<aui:button-row>
				<aui:col span="6">
					<aui:button icon="icon-upload" href="" value="import-syllabus-data-csv" cssClass="col-xs-12 export-import-button" />
				</aui:col>
			
				<aui:col span="6">
					<aui:button icon="icon-upload" href="" value="import-syllabus-data-xml" cssClass="col-xs-12 export-import-button" />
				</aui:col>
			</aui:button-row>
			
			<aui:button-row>
				<aui:col span="6">
					<aui:button icon="icon-upload" href="" value="import-lecturer-data-csv" cssClass="col-xs-12 export-import-button" />
				</aui:col>
				
				<aui:col span="6">
					<aui:button icon="icon-upload" href="" value="import-lecturer-data-xml" cssClass="col-xs-12 export-import-button" />
				</aui:col>
			</aui:button-row>
			
			<aui:button-row>
				<aui:col span="6">
					<aui:button icon="icon-upload" href="" value="import-semester-data-csv" cssClass="col-xs-12 export-import-button" />
				</aui:col>
				
				<aui:col span="6">
					<aui:button icon="icon-upload" href="" value="import-semester-data-xml" cssClass="col-xs-12 export-import-button" />
				</aui:col>
			</aui:button-row>
			
			<aui:button-row>
				<aui:col span="6">
					<aui:button icon="icon-upload" href="" value="import-course-type-data-csv" cssClass="col-xs-12 export-import-button" />
				</aui:col>
				
				<aui:col span="6">
					<aui:button icon="icon-upload" href="" value="import-course-type-data-xml" cssClass="col-xs-12 export-import-button" />
				</aui:col>
			</aui:button-row>
		</aui:col>
	</c:if>
</div>
