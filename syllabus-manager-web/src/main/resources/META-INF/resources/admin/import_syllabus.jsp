<%@include file="/init.jsp"%>

<%
	String backURL = ParamUtil.getString(renderRequest, "backURL");
	
	request.setAttribute("backURL", backURL);
%>

<c:set var="home" value="<%=WebKeys.ADMIN_HOME_IMPORT_SYLLABUS%>" scope="request" />

<jsp:include page="/admin/navigation_bar.jsp" />
<jsp:include page="/admin/breadcrumb.jsp" />

<!-- File upload form from http://www.codeyouneed.com/liferay-portlet-file-upload-tutorial/ -->
<portlet:actionURL name="upload" var="uploadFileURL"></portlet:actionURL>

<div class="closed container-fluid-1280 sidenav-container sidenav-right" id="<portlet:namespace />importSyllabusPanelId">
	<h1>Import ik_syllabus_ws.csv</h1>
	
	<aui:form action="<%= uploadFileURL %>" enctype="multipart/form-data" method="post"> 
		<aui:input name="importType" type="hidden" value="syllabus" />
		
		<aui:input type="file" name="fileupload" />
		
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="cancel" onClick="${backURL}" />
		</aui:button-row>
	</aui:form>
</div>