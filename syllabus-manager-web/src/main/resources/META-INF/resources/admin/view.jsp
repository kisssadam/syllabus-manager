<%@ include file="/init.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<jsp:include page="/admin/navigation_bar.jsp" />

<div class="closed container-fluid-1280 sidenav-container sidenav-right" id="<portlet:namespace />infoPanelId">
	<jsp:include page="/admin/breadcrumb.jsp" />
	
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
		
	<div>
		<h1>Ami kellene:</h1>
		<ol>
			<li>Megfelelő xlsx vagy csv állomány vagy állományok megfelelő attribútumokkal. Lásd: aszalós.xlsx vagy
				ik_syllabus_ws.xlsx ik_timetable_ws.xlsx</li>
			<li>Tantárgyfelelőst jó ha kézzel kell bejelöltetni? Lenne egy külön tábla Lecturer és TimetableCourse között. A
				timetableCourse-ok felvitelénél kellene meghatározni a tantárgyfelelőst</li>
			<li>Számít a sorrend egy tantárgy oktatói során vagy jó ha mindig rendezett sorrendben jelenik meg?</li>
			<li>Külön portlet a tanári oldalra, ahol be a portlethez tartozó konfigurációs menüben be lehet állítani, hogy
				mely sillabuszokat listázza ki. Ötlet: erre aui panelek használata célszerű lehet.</li>
			<li>Ha minden kész, akkor search bar kellene a search containerek jobb felső sarkára</li>
			<li>Asset Publisher integráció a syllabuszhoz!</li>
			<li>Velocity macro, freemarker template-ek támogatása, így bárki aki ért hozzá testre tudja szabni a syllabuszok
				megjelenítését</li>
		</ol>
	</div>
	
	<div>ide ket oszlop: leirasok: manualis hozzaadas lepesei, automatikus hozzadas/feltoltes lepesi.</div>
	
	<div>logot is meg lehetne jeleniteni, ki mikor mit modositott.</div>
</div>