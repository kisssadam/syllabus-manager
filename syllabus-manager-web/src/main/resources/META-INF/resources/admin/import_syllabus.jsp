<%@include file="/init.jsp"%>

<c:set var="showImportSyllabusLink" value="<%= true %>" scope="request"/>

<jsp:include page="/admin/navigation_bar.jsp" />

<jsp:include page="/admin/breadcrumb.jsp" />

<!-- File upload form from http://www.codeyouneed.com/liferay-portlet-file-upload-tutorial/ -->
<portlet:actionURL name="upload" var="uploadFileURL"></portlet:actionURL>

<h1>Import ik_syllabus_ws.csv</h1>

<aui:form action="<%= uploadFileURL %>" enctype="multipart/form-data" method="post"> 
	<aui:input name="importType" type="hidden" value="syllabus" />
	
	<aui:input type="file" name="fileupload" />
	
	<aui:button name="Save" value="Save" type="submit" />
</aui:form>
