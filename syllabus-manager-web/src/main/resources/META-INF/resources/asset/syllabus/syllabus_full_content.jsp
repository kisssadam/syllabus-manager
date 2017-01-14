<%@include file="/init.jsp"%>

<%
	Syllabus syllabus = (Syllabus) request.getAttribute(SyllabusWebKeys.SYLLABUS);
%>

Hello Syllabus Asset Renderer! This is syllabus_full_content.jsp!

Syllabus id: <%= String.valueOf(syllabus.getSyllabusId()) %>
