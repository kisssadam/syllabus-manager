<%@include file="/init.jsp"%>

<%
	String backURL = ParamUtil.getString(renderRequest, "backURL");

	request.setAttribute("backURL", backURL);
	request.setAttribute("semesters", SemesterLocalServiceUtil.getSemesters());
%>

<c:set var="home" value="<%=WebKeys.ADMIN_HOME_IMPORT_TIMETABLE%>" scope="request" />

<jsp:include page="/admin/navigation_bar.jsp" />
<jsp:include page="/admin/breadcrumb.jsp" />

<!-- File upload form from http://www.codeyouneed.com/liferay-portlet-file-upload-tutorial/ -->
<liferay-portlet:actionURL name="<%=WebKeys.MVC_ACTION_IMPORT_SYLLABUS_DATA%>" var="uploadFileURL">
	<portlet:param name="mvcActionCommand" value="<%=WebKeys.MVC_ACTION_IMPORT_SYLLABUS_DATA%>" />
</liferay-portlet:actionURL>

<div class="closed container-fluid-1280 sidenav-container sidenav-right" id="<portlet:namespace />importTimetablePanelId">
	<h1>Import ik_orarend_ws.csv</h1>
	
	<aui:form action="<%=uploadFileURL%>" enctype="multipart/form-data" method="post">
		<aui:select label="semester" name="semesterId" required="true">
			<c:forEach items="${semesters}" var="semester">
				<aui:option value="${semester.semesterId}">
					<c:out value="${semester.beginYear}/${semester.endYear}/${semester.division}" />
				</aui:option>
			</c:forEach>
		</aui:select>
		
		<aui:input name="importType" type="hidden" value="timetable" />
	
		<aui:input type="file" name="fileupload" />
	
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="cancel" onClick="${backURL}" />
		</aui:button-row>
	</aui:form>
</div>
