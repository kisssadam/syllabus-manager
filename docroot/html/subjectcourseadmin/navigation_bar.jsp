<%@include file="/html/init.jsp"%>

<!-- 
	https://docs.liferay.com/portal/6.2/taglibs/liferay-ui/icon.html
	
	http://marcoceppi.github.io/bootstrap-glyphicons/
-->

<portlet:renderURL var="viewHomeURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/view.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewCurriculumsURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/curriculums/view_curriculums.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewCourseTypesURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/course_types/view_course_types.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewSemestersURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/semesters/view_semesters.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewLecturersURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/lecturers/view_lecturers.jsp" />
</portlet:renderURL>

<aui:nav-bar>
    <aui:nav>
    	<aui:nav-item cssClass="removeCheckedItemsButton" iconCssClass="icon-remove" label="delete" selected='false' style="display: none;" />
    	
        <aui:nav-item href="<%=viewHomeURL.toString()%>" iconCssClass="icon-home" label="home" selected='false' />
        
        <aui:nav-item dropdown="true" iconCssClass="icon-list" label="view" selected='false'>
        	<aui:nav-item href="<%=viewCurriculumsURL.toString()%>" label="Curriculums" />
			<aui:nav-item href="<%=viewCourseTypesURL.toString()%>" label="Course Types" />
			<aui:nav-item href="<%=viewSemestersURL.toString()%>" label="Semesters" />
			<aui:nav-item href="<%=viewLecturersURL.toString()%>" label="Lecturers" />
		</aui:nav-item>
        
        <aui:nav-item dropdown="true" iconCssClass="icon-plus" label="add" selected='false'>
            <c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_CURRICULUM)%>'>
				<portlet:renderURL var="addCurriculumURL">
					<portlet:param name="mvcPath" value="/html/subjectcourseadmin/curriculums/edit_curriculum.jsp" />
				</portlet:renderURL>
            	
            	<aui:nav-item href="<%=addCurriculumURL.toString()%>" label="Curriculum" />
			</c:if>
            
            <c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_SUBJECT)%>'>
            	<portlet:renderURL var="addSubjectURL">
					<portlet:param name="mvcPath" value="/html/subjectcourseadmin/subjects/edit_subject.jsp" />
					<portlet:param name="curriculumId" value="${curriculumId}" />
				</portlet:renderURL>
            	
            	<aui:nav-item href="<%=addSubjectURL.toString()%>" label="Subject" />
			</c:if>
			
			<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_COURSE)%>'>
				<portlet:renderURL var="addCourseURL">
					<portlet:param name="mvcPath" value="/html/subjectcourseadmin/courses/edit_course.jsp" />
					<portlet:param name="subjectId" value="${subjectId}" />
					<portlet:param name="curriculumId" value="${curriculumId}" />
				</portlet:renderURL>
            	
            	<aui:nav-item href="<%=addCourseURL.toString()%>" label="Course" />
           	</c:if>
            
            <c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_COURSE_TYPE)%>'>
            	<portlet:renderURL var="addCourseTypeURL">
					<portlet:param name="mvcPath" value="/html/subjectcourseadmin/course_types/edit_course_type.jsp" />
				</portlet:renderURL>
            	
            	<aui:nav-item href="<%= addCourseTypeURL.toString() %>" label="Course Type" />
           	</c:if>
           	
           	<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_SEMESTER)%>'>
            	<portlet:renderURL var="addSemesterURL">
					<portlet:param name="mvcPath" value="/html/subjectcourseadmin/semesters/edit_semester.jsp" />
				</portlet:renderURL>
            	
            	<aui:nav-item href="<%= addSemesterURL.toString() %>" label="Semester" />
           	</c:if>
           	
           	<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_LECTURER)%>'>
           		<portlet:renderURL var="addLecturerURL">
					<portlet:param name="mvcPath" value="/html/subjectcourseadmin/lecturers/edit_lecturer.jsp" />
					<portlet:param name="lecturerId" value="${lecturerId}" />
				</portlet:renderURL>
            	
            	<aui:nav-item href="<%= addLecturerURL.toString() %>" label="Lecturer" />
           	</c:if>
           	
           	<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_TIMETABLE_COURSE)%>'>
           		<portlet:renderURL var="addTimetableCourseURL">
					<portlet:param name="mvcPath" value="/html/subjectcourseadmin/timetablecourses/edit_timetable_course.jsp" />
					<portlet:param name="curriculumId" value="${curriculumId}" />
					<portlet:param name="subjectId" value="${subjectId}" />
					<portlet:param name="courseId" value="${courseId}" />
					<portlet:param name="semesterId" value="${semesterId}" />
				</portlet:renderURL>
            	
            	<aui:nav-item href="<%= addTimetableCourseURL.toString() %>" label="TimetableCourse" />
           	</c:if>
        </aui:nav-item>
        
        <%--
        dialogos megoldashoz: https://www.liferay.com/community/forums/-/message_boards/message/41261810
        --%>
        <aui:nav-item dropdown="true" iconCssClass="icon-upload" label="import" selected='false'>
        	<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.IMPORT_SYLLABUS)%>'>
        		<portlet:renderURL var="importSyllabusURL">
					<portlet:param name="mvcPath" value="/html/subjectcourseadmin/import_syllabus.jsp" />
				</portlet:renderURL>
            	
            	<aui:nav-item href="<%=importSyllabusURL.toString()%>" label="ik_syllabus_ws.csv" />
			</c:if>
			
			<c:if test='<%=ModelPermission.contains(permissionChecker, scopeGroupId, ActionKeys.IMPORT_TIMETABLE)%>'>
				<portlet:renderURL var="importTimetableURL">
					<portlet:param name="mvcPath" value="/html/subjectcourseadmin/import_timetable.jsp" />
				</portlet:renderURL>
            	
            	<aui:nav-item href="<%=importTimetableURL.toString()%>" label="ik_orarend_ws.csv" />
           	</c:if>
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