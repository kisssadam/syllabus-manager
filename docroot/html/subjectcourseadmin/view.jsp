<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<portlet:defineObjects />

This is the <b>Subject Course Admin</b> portlet in View mode.

<!-- File upload form from http://www.codeyouneed.com/liferay-portlet-file-upload-tutorial/ -->

<portlet:actionURL name="upload" var="uploadFileURL"></portlet:actionURL>
 
<aui:form action="<%= uploadFileURL %>" enctype="multipart/form-data" method="post">
 
	<aui:input type="file" name="fileupload" />
	
	<aui:button name="Save" value="Save" type="submit" />
 
</aui:form>