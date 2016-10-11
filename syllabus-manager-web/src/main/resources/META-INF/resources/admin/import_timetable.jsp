<%@include file="/init.jsp"%>

<%
request.setAttribute("semesters", SemesterLocalServiceUtil.getSemesters());
%>

<c:set var="home" value="import" scope="request"/>
<c:set var="importType" value="timetable" scope="request"/>

<jsp:include page="/admin/navigation_bar.jsp" />

<jsp:include page="/admin/breadcrumb.jsp" />

<!-- File upload form from http://www.codeyouneed.com/liferay-portlet-file-upload-tutorial/ -->
<portlet:actionURL name="upload" var="uploadFileURL"></portlet:actionURL>

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

	<aui:button name="Save" value="Save" type="submit" />
</aui:form>
