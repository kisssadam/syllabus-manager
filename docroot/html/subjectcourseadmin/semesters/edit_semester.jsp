<%@include file="/html/init.jsp"%>

<%
	long semesterId = ParamUtil.getLong(renderRequest, "semesterId");

	int beginYear = ParamUtil.getInteger(request, "beginYear", SemesterHelper.currentYear());
	int endYear = ParamUtil.getInteger(request, "endYear", beginYear + 1);
	int division = ParamUtil.getInteger(request, "division", SemesterHelper.nextDivision());

	Semester semester = null;

	if (semesterId > 0) {
		semester = SemesterLocalServiceUtil.getSemester(semesterId);
	} else {
		try {
			Semester latestSemester = SemesterLocalServiceUtil.getLatestSemester();
			
			beginYear = latestSemester.getNextBeginYear();
			endYear = latestSemester.getNextEndYear();
			division = latestSemester.getNextDivision();
		} catch (NoSuchSemesterException e) {
			// omit
		}
	}
%>

<liferay-ui:error exception="<%=DuplicateSemesterException.class%>" message="semester-already-exists" />
<liferay-ui:error exception="<%=SemesterYearDifferenceException.class%>" message="semester-year-difference-exception" />
<liferay-ui:error exception="<%=SemesterYearsAreEqualException.class%>" message="semester-years-are-equal-exception" />
<liferay-ui:error exception="<%=SemesterYearOverlapException.class%>" message="semester-year-overlap-exception" />
<liferay-ui:error exception="<%=SemesterDivisionException.class%>" message="semester-division-exception" />

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/subjectcourseadmin/semesters/view_semesters.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addSemester" var="addSemesterURL" />

<aui:form action="<%=addSemesterURL%>" name="<portlet:namespace />semester_edit">
	<aui:model-context bean="<%=semester%>" model="<%=Semester.class%>" />
	<aui:input name="semesterId" type="hidden" value='<%=semester == null ? semesterId : semester.getSemesterId()%>' />

	<aui:fieldset>
		<aui:input id="beginYear" name="beginYear" onChange="updateEndYearValue(this.value)" type="number"
			value="<%=semester == null ? beginYear : semester.getBeginYear()%>">
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="endYear" onChange="updateBeginYearValue(this.value)" type="number"
			value="<%=semester == null ? endYear : semester.getEndYear()%>">
			<aui:validator name="required" />
		</aui:input>

		<aui:input name="division" min="1" max="2" type="number"
			value="<%=semester == null ? division : semester.getDivision()%>">
			<aui:validator name="required" />
		</aui:input>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel" onClick="<%= viewURL %>" />
	</aui:button-row>
</aui:form>


<script type="text/javascript">
	function updateEndYearValue(beginYear) {
		var endYearElement = document.getElementById("<portlet:namespace />endYear");
		
		endYearElement.value = parseInt(beginYear) + 1;
	}
	
	function updateBeginYearValue(endYear) {
		var beginYearElement = document.getElementById("<portlet:namespace />beginYear");
		
		beginYearElement.value = parseInt(endYear) - 1;
	}
</script>