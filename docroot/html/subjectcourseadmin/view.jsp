<%@include file="/html/init.jsp"%>

<jsp:include page="/html/subjectcourseadmin/breadcrumb.jsp" />

<jsp:include page="/html/subjectcourseadmin/navigation_bar.jsp" />

<div id="myTreeView"></div>

<aui:script>
	YUI().use('aui-tree-view', function(Y) {
		// Create an array object for the tree root and child nodes
		var children = [ {
			children : [ {
				label : 'Curriculums',
				expanded : true,
				children : [ {
					label : 'Subjects',
					expanded : true,
					children : [ {
						label : 'Courses',
						expanded : true,
						children : [ {
							label : 'Timetable Courses'
						} ]
					} ]
				} ]
			}, {
				label : 'Course Types'
			}, {
				label : 'Semesters',
				expanded : true,
				children : [ {
					label : 'Timetable Courses'
				} ]
			}, {
				label : 'Lecturers'
			} ],
			expanded : true,
			label : 'Home'
		} ];

		// Create a TreeView Component
		new Y.TreeView({
			boundingBox : '#myTreeView',
			children : children
		}).render();
	});
</aui:script>
	
<div>ide ket oszlop: leirasok: manualis hozzaadas lepesei, automatikus hozzadas/feltoltes lepesi.</div>

<div>logot is meg lehetne jeleniteni, ki mikor mit modositott.</div>
