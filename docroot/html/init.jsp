<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>
<%@taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>

<%@page import="com.liferay.portal.kernel.dao.search.SearchEntry"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@page import="com.liferay.portal.util.PortalUtil"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>

<%@page import="javax.portlet.PortletURL"%>

<%@page import="hu.unideb.inf.service.CurriculumLocalServiceUtil"%>
<%@page import="hu.unideb.inf.service.SubjectLocalServiceUtil"%>
<%@page import="hu.unideb.inf.service.CourseLocalServiceUtil"%>
<%@page import="hu.unideb.inf.service.CourseTypeLocalServiceUtil"%>
<%@page import="hu.unideb.inf.service.SemesterLocalServiceUtil"%>

<%@page import="hu.unideb.inf.model.Curriculum"%>
<%@page import="hu.unideb.inf.model.Subject"%>
<%@page import="hu.unideb.inf.model.Course"%>
<%@page import="hu.unideb.inf.model.CourseType"%>
<%@page import="hu.unideb.inf.model.Semester"%>

<%@page import="hu.unideb.inf.util.WebKeys"%>
<%@page import="hu.unideb.inf.util.ActionKeys"%>
<%@page import="hu.unideb.inf.util.SemesterHelper"%>

<%@page import="hu.unideb.inf.service.permission.ModelPermission"%>
<%@page import="hu.unideb.inf.service.permission.CurriculumPermission"%>
<%@page import="hu.unideb.inf.service.permission.SubjectPermission"%>
<%@page import="hu.unideb.inf.service.permission.CoursePermission"%>
<%@page import="hu.unideb.inf.service.permission.CourseTypePermission"%>
<%@page import="hu.unideb.inf.service.permission.SemesterPermission"%>

<%@page import="hu.unideb.inf.DuplicateCurriculumException"%>
<%@page import="hu.unideb.inf.DuplicateSubjectException"%>
<%@page import="hu.unideb.inf.DuplicateCourseException"%>
<%@page import="hu.unideb.inf.DuplicateCourseTypeException"%>
<%@page import="hu.unideb.inf.DuplicateSemesterException"%>

<%@page import="hu.unideb.inf.NoSuchCurriculumException"%>
<%@page import="hu.unideb.inf.NoSuchSubjectException"%>
<%@page import="hu.unideb.inf.NoSuchCourseException"%>
<%@page import="hu.unideb.inf.NoSuchCourseTypeException"%>
<%@page import="hu.unideb.inf.NoSuchSemesterException"%>

<%@page import="hu.unideb.inf.SemesterDivisionException"%>
<%@page import="hu.unideb.inf.SemesterYearOverlapException"%>
<%@page import="hu.unideb.inf.SemesterYearsAreEqualException"%>
<%@page import="hu.unideb.inf.SemesterYearDifferenceException"%>


<portlet:defineObjects />
<theme:defineObjects />
