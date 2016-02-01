<%@include file="/html/init.jsp"%>

<!-- 
	https://docs.liferay.com/portal/6.2/taglibs/liferay-ui/icon.html
	
	http://marcoceppi.github.io/bootstrap-glyphicons/
-->

<aui:nav-bar>
    <aui:nav>
    	<aui:nav-item cssClass="removeCheckedItemsButton" iconCssClass="icon-remove" label="delete" selected='false' style="display: none;" />
    
    	<portlet:renderURL var="viewHomeURL">
			<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view.jsp" />
		</portlet:renderURL>
        <aui:nav-item href="<%=viewHomeURL.toString()%>" iconCssClass="icon-home" label="home" selected='false' />
        
        <aui:nav-item dropdown="true" iconCssClass="icon-list" label="view" selected='false'>
        	<aui:nav-item href="/..." label="Curriculums" />
        	<aui:nav-item href="/..." label="Subjects" />
        	<aui:nav-item href="/..." label="Courses" />
        	<aui:nav-item href="/..." label="Course Types" />
        </aui:nav-item>
        
        <aui:nav-item dropdown="true" iconCssClass="icon-plus" label="add" selected='false'>
            <c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_CURRICULUM)%>'>
				<portlet:renderURL var="addCurriculumURL">
					<portlet:param name="mvcPath" value="/html/subjectcourseadmin/edit_curriculum.jsp" />
				</portlet:renderURL>
            	
            	<aui:nav-item href="<%=addCurriculumURL.toString()%>" label="Curriculum" />
			</c:if>
            <aui:nav-item href="/..." label="Subject" />
            <aui:nav-item href="/..." label="Course" />
            <aui:nav-item href="/..." label="Course Type" />
        </aui:nav-item>
        
        <aui:nav-item dropdown="true" iconCssClass="icon-upload" label="import" selected='false'>
        	<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.IMPORT_SYLLABUS)%>'>
        		<portlet:renderURL var="importSyllabusURL">
					<portlet:param name="mvcPath" value="/html/subjectcourseadmin/import_syllabus.jsp" />
				</portlet:renderURL>
            	
            	<aui:nav-item href="<%=importSyllabusURL.toString()%>" label="ik_syllabus_ws.csv" />
			</c:if>
            <aui:nav-item href="/..." label="ik_orarend_ws.csv" />
        </aui:nav-item>
    </aui:nav>
</aui:nav-bar>

<aui:script use="aui-base">
A.all('input[name=<portlet:namespace />rowIds]').on(
		'click',
		function(event) {
			var rowsChecked = A.all('input[name=<portlet:namespace />rowIds]:checked');
			
			toggleViewIfRequired(rowsChecked);
		}
	);
	
	A.all('input[name=<portlet:namespace />allRowIds]').on(
		'click',
		function(event) {
			var rowsChecked = A.all('input[name=<portlet:namespace />allRowIds]:checked');
			
			toggleViewIfRequired(rowsChecked);
		}
	);
	
	function toggleViewIfRequired(rowsChecked) {
		var deleteButton = A.one('.removeCheckedItemsButton');
		
		if (rowsChecked.size() > 0) {
			deleteButton.show();
		} else {
			deleteButton.hide();
		}
	}
</aui:script>