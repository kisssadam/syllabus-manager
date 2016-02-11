<%@include file="/html/init.jsp"%>

<liferay-ui:success key="curriculumAdded" message="curriculum-has-been-successfully-added" />
<liferay-ui:success key="curriculumUpdated" message="curriculum-has-been-successfully-updated" />
<liferay-ui:success key="curriculumDeleted" message="curriculum-has-been-successfully-deleted" />
<liferay-ui:success key="everyCurriculumDeleted" message="every-curriculum-has-been-successfully-deleted" />

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
						label : 'Courses'
					} ]
				} ]
			}, {
				label : 'Course Types'
			}, {
				label : 'Semesters'
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

<div>
	ide ket oszlop: leirasok: manualis hozzaadas lepesei, automatikus hozzadas/feltoltes lepesi.
</div>

<div>
	logot is meg lehetne jeleniteni, ki mikor mit modositott.
</div>
