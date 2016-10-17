package hu.unideb.inf.web.portlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import hu.unideb.inf.model.Course;
import hu.unideb.inf.model.CourseType;
import hu.unideb.inf.model.Curriculum;
import hu.unideb.inf.model.Lecturer;
import hu.unideb.inf.model.Semester;
import hu.unideb.inf.model.Subject;
import hu.unideb.inf.model.Syllabus;
import hu.unideb.inf.model.TimetableCourse;
import hu.unideb.inf.service.CourseLocalServiceUtil;
import hu.unideb.inf.service.CourseTypeLocalServiceUtil;
import hu.unideb.inf.service.CurriculumLocalServiceUtil;
import hu.unideb.inf.service.LecturerLocalServiceUtil;
import hu.unideb.inf.service.SemesterLocalServiceUtil;
import hu.unideb.inf.service.SubjectLocalServiceUtil;
import hu.unideb.inf.service.SyllabusLocalServiceUtil;
import hu.unideb.inf.service.TimetableCourseLocalServiceUtil;
import hu.unideb.inf.web.constants.SyllabusManagerPortletKeys;
import hu.unideb.inf.web.util.SyllabusCSVParser;
import hu.unideb.inf.web.util.TimetableCSVParser;

@Component(immediate = true, property = { 
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.layout-cacheable=true",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=Syllabus Manager PanelApp Portlet",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.template-path=/admin/",
		"javax.portlet.init-param.view-template=/admin/view.jsp",
		"javax.portlet.name=" + SyllabusManagerPortletKeys.SyllabusManagerAdmin,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator,power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class SyllabusManagerAdminPortlet extends MVCPortlet {

	private static final String VIEW_CURRICULUMS = "/admin/curriculums/view_curriculums.jsp";

	private static final String VIEW_SUBJECTS = "/admin/subjects/view_subjects.jsp";

	private static final String VIEW_COURSES = "/admin/courses/view_courses.jsp";

	private static final String VIEW_COURSE_TYPES = "/admin/course_types/view_course_types.jsp";

	private static final String VIEW_SEMESTERS = "/admin/semesters/view_semesters.jsp";

	private static final String VIEW_LECTURERS = "/admin/lecturers/view_lecturers.jsp";

	private static final String VIEW_TIMETABLE_COURSES_BY_SEMESTER = "/admin/timetablecourses/view_timetable_courses_by_semester.jsp";
	
	private static final String VIEW_SYLLABUSES_BY_TIMETABLE_COURSE = "/admin/syllabuses/view_syllabuses_by_timetable_course.jsp";

	private static final String EDIT_CURRICULUM = "/admin/curriculums/edit_curriculum.jsp";

	private static final String EDIT_SUBJECT = "/admin/subjects/edit_subject.jsp";

	private static final String EDIT_COURSE = "/admin/courses/edit_course.jsp";

	private static final String EDIT_COURSE_TYPE = "/admin/course_types/edit_course_type.jsp";

	private static final String EDIT_SEMESTER = "/admin/semesters/edit_semester.jsp";

	private static final String EDIT_LECTURER = "/admin/lecturers/edit_lecturer.jsp";

	private static final String EDIT_TIMETABLE_COURSE = "/admin/timetablecourses/edit_timetable_course.jsp";
	
	private static final String EDIT_SYLLABUS = "/admin/syllabuses/edit_syllabus.jsp";

	private final static String fileInputName = "fileupload";

	private static final Log log = LogFactoryUtil.getLog(SyllabusManagerAdminPortlet.class);

	public void addCurriculum(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Curriculum.class.getName(), request);

		long curriculumId = ParamUtil.getLong(request, "curriculumId");
		String curriculumCode = ParamUtil.getString(request, "curriculumCode");
		String curriculumName = ParamUtil.getString(request, "curriculumName");

		if (log.isDebugEnabled()) {
			log.debug(String.format("curriculumId: %d, curriculumCode: '%s', curriculumName: '%s'", curriculumId,
					curriculumCode, curriculumName));
		}

		try {
			if (curriculumId > 0) {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Updating curriculum, id: %d", curriculumId));
				}
				CurriculumLocalServiceUtil.updateCurriculum(serviceContext.getUserId(), curriculumId, curriculumCode,
						curriculumName, serviceContext);
				SessionMessages.add(request, "curriculumUpdated");
			} else {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Adding curriculum, id: %d", curriculumId));
				}
				CurriculumLocalServiceUtil.addCurriculum(curriculumCode, curriculumName, serviceContext);
				SessionMessages.add(request, "curriculumAdded");
			}

			response.setRenderParameter("mvcPath", VIEW_CURRICULUMS);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", EDIT_CURRICULUM);
		}
	}

	public void addSubject(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Subject.class.getName(), request);

		long subjectId = ParamUtil.getLong(request, "subjectId");
		String subjectCode = ParamUtil.getString(request, "subjectCode");
		String subjectName = ParamUtil.getString(request, "subjectName");
		int credit = ParamUtil.getInteger(request, "credit");
		long curriculumId = ParamUtil.getLong(request, "curriculumId");

		if (log.isDebugEnabled()) {
			log.debug(String.format("subjectId: %d, subjectCode: '%s', subjectName: '%s', credit: %d, curriculumId: %d",
					subjectId, subjectCode, subjectName, credit, curriculumId));
		}

		try {
			if (subjectId > 0) {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Updating subject, id: %d", subjectId));
				}
				SubjectLocalServiceUtil.updateSubject(serviceContext.getUserId(), subjectId, subjectCode, subjectName,
						credit, curriculumId, serviceContext);
				SessionMessages.add(request, "subjectUpdated");
			} else {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Adding subject, id: %d", subjectId));
				}
				SubjectLocalServiceUtil.addSubject(subjectCode, subjectName, credit, curriculumId, serviceContext);
				SessionMessages.add(request, "subjectAdded");
			}

			response.setRenderParameter("mvcPath", VIEW_SUBJECTS);
			response.setRenderParameter("curriculumId", String.valueOf(curriculumId));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", EDIT_SUBJECT);
		}
	}

	public void addCourse(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Course.class.getName(), request);

		long courseId = ParamUtil.getLong(request, "courseId");
		long subjectId = ParamUtil.getLong(request, "subjectSelect");
		int hoursPerSemester = ParamUtil.getInteger(request, "hoursPerSemester");
		int hoursPerWeek = ParamUtil.getInteger(request, "hoursPerWeek");
		long courseTypeId = ParamUtil.getLong(request, "courseTypeId");

		if (log.isDebugEnabled()) {
			log.debug(String.format(
					"courseId: %d, subjectId: %d, hoursPerSemester: %d, hoursPerWeek: %d, courseTypeId: %d", courseId,
					subjectId, hoursPerSemester, hoursPerWeek, courseTypeId));
		}

		try {
			if (courseId > 0) {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Updating course, id: %d", courseId));
				}
				CourseLocalServiceUtil.updateCourse(serviceContext.getUserId(), courseId, subjectId, hoursPerSemester,
						hoursPerWeek, courseTypeId, serviceContext);
				SessionMessages.add(request, "courseUpdated");
			} else {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Adding course, id: %d", courseId));
				}
				CourseLocalServiceUtil.addCourse(subjectId, hoursPerSemester, hoursPerWeek, courseTypeId,
						serviceContext);
				SessionMessages.add(request, "courseAdded");
			}

			response.setRenderParameter("mvcPath", VIEW_COURSES);
			response.setRenderParameter("subjectId", String.valueOf(subjectId));
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", EDIT_COURSE);
		}
	}

	public void addCourseType(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(CourseType.class.getName(), request);

		long courseTypeId = ParamUtil.getLong(request, "courseTypeId");
		String typeName = ParamUtil.getString(request, "typeName");

		if (log.isDebugEnabled()) {
			log.debug(String.format("courseTypeId: %d, typeName: '%s'", courseTypeId, typeName));
		}

		try {
			if (courseTypeId > 0) {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Updating courseType, id: %d", courseTypeId));
				}
				CourseTypeLocalServiceUtil.updateCourseType(serviceContext.getUserId(), courseTypeId, typeName,
						serviceContext);
				SessionMessages.add(request, "courseTypeUpdated");
			} else {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Adding courseType, id: %d", courseTypeId));
				}
				CourseTypeLocalServiceUtil.addCourseType(typeName, serviceContext);
				SessionMessages.add(request, "courseTypeAdded");
			}

			response.setRenderParameter("mvcPath", VIEW_COURSE_TYPES);
		} catch (Exception e) {
			log.error(e);
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", EDIT_COURSE_TYPE);
		}
	}

	public void addSemester(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Semester.class.getName(), request);

		int beginYear = ParamUtil.getInteger(request, "beginYear");
		int endYear = ParamUtil.getInteger(request, "endYear");
		int division = ParamUtil.getInteger(request, "division");
		long semesterId = ParamUtil.getLong(request, "semesterId");

		if (log.isDebugEnabled()) {
			log.debug(String.format("beginYear: %d, endYear: %d, division: %d, semesterId: %d", beginYear, endYear,
					division, semesterId));
		}

		try {
			if (semesterId > 0) {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Updating semester, id: %d", semesterId));
				}
				SemesterLocalServiceUtil.updateSemester(serviceContext.getUserId(), semesterId, beginYear, endYear,
						division, serviceContext);
				SessionMessages.add(request, "semesterUpdated");
			} else {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Adding semester, id: %d", semesterId));
				}
				SemesterLocalServiceUtil.addSemester(beginYear, endYear, division, serviceContext);
				SessionMessages.add(request, "semesterAdded");
			}

			response.setRenderParameter("mvcPath", VIEW_SEMESTERS);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", EDIT_SEMESTER);
		}
	}

	public void addLecturer(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Lecturer.class.getName(), request);

		long lecturerId = ParamUtil.getLong(request, "lecturerId");
		String lecturerName = ParamUtil.getString(request, "lecturerName");
		long lecturerUserId = ParamUtil.getLong(request, "lecturerUserId");

		if (log.isDebugEnabled()) {
			log.debug(String.format("lecturerId: %d, lecturerName: '%s', lecturerUserId: %d", lecturerId, lecturerName,
					lecturerUserId));
		}

		try {
			if (lecturerId > 0) {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Updating lecturer, id: %d", lecturerId));
				}
				LecturerLocalServiceUtil.updateLecturer(serviceContext.getUserId(), lecturerId, lecturerName,
						lecturerUserId, serviceContext);
				SessionMessages.add(request, "lecturerUpdated");
			} else {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Adding lecturer, id: %d", lecturerId));
				}
				LecturerLocalServiceUtil.addLecturer(lecturerName, lecturerUserId, serviceContext);
				SessionMessages.add(request, "lecturerAdded");
			}

			response.setRenderParameter("mvcPath", VIEW_LECTURERS);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", EDIT_LECTURER);
		}
	}

	public void addTimetableCourse(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(TimetableCourse.class.getName(), request);

		long timetableCourseId = ParamUtil.getLong(request, "timetableCourseId");
		long courseId = ParamUtil.getLong(request, "courseSelect");
		long semesterId = ParamUtil.getLong(request, "semesterId");
		String timetableCourseCode = ParamUtil.getString(request, "timetableCourseCode");
		String subjectType = ParamUtil.getString(request, "subjectType");
		int recommendedTerm = ParamUtil.getInteger(request, "recommendedTerm");
		int limit = ParamUtil.getInteger(request, "limit");
		long[] lecturerIds = getLecturerIds(request);
		String classScheduleInfo = ParamUtil.getString(request, "classScheduleInfo");
		String description = ParamUtil.getString(request, "description");

		if (log.isDebugEnabled()) {
			log.debug(String.format(
					"timetableCourseId: %d, courseId: %d, semesterId: %d, timetableCourseCode: '%s', subjectType: '%s', recommendedTerm: %d, limit: %d, lecturerIds: '%s', classScheduleInfo: '%s', description: '%s'",
					timetableCourseId, courseId, semesterId, timetableCourseCode, subjectType, recommendedTerm, limit,
					Arrays.toString(lecturerIds), classScheduleInfo, description));
		}

		try {
			if (timetableCourseId > 0) {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Updating timetableCourse, id: %d", timetableCourseId));
				}
				TimetableCourseLocalServiceUtil.updateTimetableCourse(serviceContext.getUserId(), timetableCourseId,
						courseId, semesterId, timetableCourseCode, subjectType, recommendedTerm, limit, lecturerIds,
						classScheduleInfo, description, serviceContext);

				SessionMessages.add(request, "timetableCourseUpdated");
			} else {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Adding timetableCourse, id: %d", timetableCourseId));
				}
				TimetableCourseLocalServiceUtil.addTimetableCourse(courseId, semesterId, timetableCourseCode,
						subjectType, recommendedTerm, limit, lecturerIds, classScheduleInfo, description,
						serviceContext);

				SessionMessages.add(request, "timetableCourseAdded");
			}

			response.setRenderParameter("mvcPath", VIEW_TIMETABLE_COURSES_BY_SEMESTER);
			response.setRenderParameter("semesterId", String.valueOf(semesterId));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", EDIT_TIMETABLE_COURSE);
		}
	}

	public void addSyllabus(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Syllabus.class.getName(), request);
		
		long syllabusId = ParamUtil.getLong(request, "syllabusId");
		long timetableCourseId = ParamUtil.getLong(request, "timetableCourseId");
		String competence = ParamUtil.getString(request, "competence");
		String ethicalStandards = ParamUtil.getString(request, "ethicalStandards");
		String topics = ParamUtil.getString(request, "topics");
		String educationalMaterials = ParamUtil.getString(request, "educationalMaterials");
		String recommendedLiterature = ParamUtil.getString(request, "recommendedLiterature");
		String weeklyTasks = ParamUtil.getString(request, "weeklyTasks");
		
		if (log.isDebugEnabled()) {
			log.debug(String.format("syllabusId: %d, timetableCourseId: %d, competence: '%s', ethicalStandards: '%s', topics: '%s', educationalMaterials: '%s', recommendedLiterature: '%s', weeklyTasks: '%s'",
					syllabusId, timetableCourseId, competence, ethicalStandards, topics, educationalMaterials, recommendedLiterature, weeklyTasks));
		}
		
		try {
			if (syllabusId > 0) {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Updating syllabus, id: %d", syllabusId));
				}
				SyllabusLocalServiceUtil.updateSyllabus(serviceContext.getUserId(), syllabusId, timetableCourseId,
						competence, ethicalStandards, topics, educationalMaterials,
						recommendedLiterature, weeklyTasks, serviceContext);
				
				SessionMessages.add(request, "syllabusUpdated");
			} else {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Adding syllabus, id: %d", syllabusId));
				}
				SyllabusLocalServiceUtil.addSyllabus(timetableCourseId, competence, ethicalStandards, topics,
						educationalMaterials, recommendedLiterature, weeklyTasks, serviceContext);
				
				SessionMessages.add(request, "syllabusAdded");
			}
			
			response.setRenderParameter("mvcPath", VIEW_SYLLABUSES_BY_TIMETABLE_COURSE);
			response.setRenderParameter("timetableCourseId", String.valueOf(timetableCourseId));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", EDIT_SYLLABUS);
		}
	}
	
	private long[] getLecturerIds(ActionRequest request) {
		Set<Long> lecturerIds = new LinkedHashSet<>();

		int[] rowIndexes = ParamUtil.getIntegerValues(request, "rowIndexes");

		for (int rowIndex : rowIndexes) {
			long lecturerId = ParamUtil.getLong(request, "lecturer" + rowIndex);
			lecturerIds.add(lecturerId);
		}

		return ArrayUtil.toArray(lecturerIds.toArray(new Long[lecturerIds.size()]));
	}

	public void deleteCurriculum(ActionRequest request, ActionResponse response) {
		long curriculumId = ParamUtil.getLong(request, "curriculumId");
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (log.isDebugEnabled()) {
			log.debug(String.format("curriculumId: %d, delta: %d", curriculumId, delta));
		}

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Curriculum.class.getName(), request);

			if (log.isTraceEnabled()) {
				log.trace(String.format("Deleting curriculum, id: %d", curriculumId));
			}

			CurriculumLocalServiceUtil.deleteCurriculum(curriculumId, serviceContext);
			SessionMessages.add(request, "curriculumDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", VIEW_CURRICULUMS);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteSubject(ActionRequest request, ActionResponse response) {
		long subjectId = ParamUtil.getLong(request, "subjectId");
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (log.isDebugEnabled()) {
			log.debug(String.format("subjectId: %d, delta: %d", subjectId, delta));
		}

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Subject.class.getName(), request);

			if (log.isTraceEnabled()) {
				log.trace(String.format("Deleting subject, id: %d", subjectId));
			}

			Subject deletedSubject = SubjectLocalServiceUtil.deleteSubject(subjectId, serviceContext);
			SessionMessages.add(request, "subjectDeleted");

			response.setRenderParameter("curriculumId", String.valueOf(deletedSubject.getCurriculumId()));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", VIEW_SUBJECTS);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteCourse(ActionRequest request, ActionResponse response) {
		long courseId = ParamUtil.getLong(request, "courseId");
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (log.isDebugEnabled()) {
			log.debug(String.format("courseId: %d, delta: %d", courseId, delta));
		}

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Course.class.getName(), request);

			if (log.isTraceEnabled()) {
				log.trace(String.format("Deleting course, id: %d", courseId));
			}

			Course deletedCourse = CourseLocalServiceUtil.deleteCourse(courseId, serviceContext);
			SessionMessages.add(request, "courseDeleted");

			response.setRenderParameter("subjectId", String.valueOf(deletedCourse.getSubjectId()));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", VIEW_COURSES);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteCourseType(ActionRequest request, ActionResponse response) {
		long courseTypeId = ParamUtil.getLong(request, "courseTypeId");
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (log.isDebugEnabled()) {
			log.debug(String.format("courseTypeId: %d, delta: %d", courseTypeId, delta));
		}

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(CourseType.class.getName(), request);

			if (log.isTraceEnabled()) {
				log.trace(String.format("Deleting courseType, id: %d", courseTypeId));
			}

			CourseTypeLocalServiceUtil.deleteCourseType(courseTypeId, serviceContext);
			SessionMessages.add(request, "courseTypeDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", VIEW_COURSE_TYPES);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteSemester(ActionRequest request, ActionResponse response) {
		long semesterId = ParamUtil.getLong(request, "semesterId");
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (log.isDebugEnabled()) {
			log.debug(String.format("semesterId: %d, delta: %d", semesterId, delta));
		}

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Semester.class.getName(), request);

			if (log.isTraceEnabled()) {
				log.trace(String.format("Deleting semester, id: %d", semesterId));
			}

			SemesterLocalServiceUtil.deleteSemester(semesterId, serviceContext);
			SessionMessages.add(request, "semesterDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", VIEW_SEMESTERS);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteLecturer(ActionRequest request, ActionResponse response) {
		long lecturerId = ParamUtil.getLong(request, "lecturerId");
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (log.isDebugEnabled()) {
			log.debug(String.format("lecturerId: %d, delta: %d", lecturerId, delta));
		}

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Lecturer.class.getName(), request);

			if (log.isTraceEnabled()) {
				log.trace(String.format("Deleting lecturer, id: %d", lecturerId));
			}

			LecturerLocalServiceUtil.deleteLecturer(lecturerId, serviceContext);
			SessionMessages.add(request, "lecturerDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", VIEW_LECTURERS);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteTimetableCourse(ActionRequest request, ActionResponse response) {
		long timetableCourseId = ParamUtil.getLong(request, "timetableCourseId");
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (log.isDebugEnabled()) {
			log.debug(String.format("timetableCourseId: %d, delta: %d", timetableCourseId, delta));
		}

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(TimetableCourse.class.getName(), request);

			if (log.isTraceEnabled()) {
				log.trace(String.format("Deleting timetableCourse, id: %d", timetableCourseId));
			}

			TimetableCourse timetableCourse = TimetableCourseLocalServiceUtil.deleteTimetableCourse(timetableCourseId,
					serviceContext);
			SessionMessages.add(request, "timetableCourseDeleted");

			response.setRenderParameter("semesterId", String.valueOf(timetableCourse.getSemesterId()));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", VIEW_TIMETABLE_COURSES_BY_SEMESTER);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteCurriculums(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Curriculum.class.getName(), request);
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (log.isDebugEnabled()) {
			log.debug(String.format("delta: %d", delta));
		}

		try {
			String[] curriculumIds = ParamUtil.getParameterValues(request, "deleteCurriculumIds");

			if (log.isDebugEnabled()) {
				log.debug(String.format("curriculumIds: '%s'", Arrays.toString(curriculumIds)));
			}

			for (String curriculumIdString : curriculumIds) {
				long curriculumId = Long.parseLong(curriculumIdString);

				if (log.isTraceEnabled()) {
					log.trace(String.format("Deleting curriculum, id: %d", curriculumId));
				}

				CurriculumLocalServiceUtil.deleteCurriculum(curriculumId, serviceContext);
			}

			SessionMessages.add(request, "curriculumsDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", VIEW_CURRICULUMS);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteSubjects(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Subject.class.getName(), request);
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (log.isDebugEnabled()) {
			log.debug(String.format("delta: %d", delta));
		}

		try {
			Long curriculumId = ParamUtil.getLong(request, "curriculumId");
			String[] subjectIds = ParamUtil.getParameterValues(request, "deleteSubjectIds");

			if (log.isDebugEnabled()) {
				log.debug(String.format("curriculumId: %d, subjectIds: '%s'", curriculumId, subjectIds));
			}

			for (String subjectIdString : subjectIds) {
				long subjectId = Long.parseLong(subjectIdString);

				if (log.isTraceEnabled()) {
					log.trace(String.format("Deleting subject, id: %d", subjectId));
				}

				SubjectLocalServiceUtil.deleteSubject(subjectId, serviceContext);
			}

			SessionMessages.add(request, "subjectsDeleted");
			response.setRenderParameter("curriculumId", String.valueOf(curriculumId));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", VIEW_SUBJECTS);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteCourses(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Course.class.getName(), request);
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (log.isDebugEnabled()) {
			log.debug(String.format("delta: %d", delta));
		}

		try {
			Long subjectId = ParamUtil.getLong(request, "subjectId");
			String[] courseIds = ParamUtil.getParameterValues(request, "deleteCourseIds");

			if (log.isDebugEnabled()) {
				log.debug(String.format("subjectId: %d, courseIds: '%s'", subjectId, courseIds));
			}

			for (String courseIdString : courseIds) {
				long courseId = Long.parseLong(courseIdString);

				if (log.isTraceEnabled()) {
					log.trace(String.format("Deleting course, id: %d", courseId));
				}

				CourseLocalServiceUtil.deleteCourse(courseId, serviceContext);
			}

			SessionMessages.add(request, "coursesDeleted");
			response.setRenderParameter("subjectId", String.valueOf(subjectId));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", VIEW_COURSES);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteCourseTypes(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(CourseType.class.getName(), request);
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (log.isDebugEnabled()) {
			log.debug(String.format("delta: %d", delta));
		}

		try {
			String[] courseTypeIds = ParamUtil.getParameterValues(request, "deleteCourseTypeIds");

			if (log.isDebugEnabled()) {
				log.debug(String.format("courseTypeIds: '%s'", Arrays.toString(courseTypeIds)));
			}

			for (String courseTypeIdString : courseTypeIds) {
				long courseTypeId = Long.parseLong(courseTypeIdString);

				if (log.isTraceEnabled()) {
					log.trace(String.format("Deleting courseType, id: %d", courseTypeId));
				}

				CourseTypeLocalServiceUtil.deleteCourseType(courseTypeId, serviceContext);
			}

			SessionMessages.add(request, "courseTypesDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", VIEW_COURSE_TYPES);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteSemesters(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Semester.class.getName(), request);
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (log.isDebugEnabled()) {
			log.debug(String.format("delta: %d", delta));
		}

		try {
			String[] semesterIds = ParamUtil.getParameterValues(request, "deleteSemesterIds");

			if (log.isDebugEnabled()) {
				log.debug(String.format("semesterIds: '%s'", Arrays.toString(semesterIds)));
			}

			for (String semesterIdString : semesterIds) {
				long semesterId = Long.parseLong(semesterIdString);

				if (log.isTraceEnabled()) {
					log.trace(String.format("Deleting semester, id: %d", semesterId));
				}

				SemesterLocalServiceUtil.deleteSemester(semesterId, serviceContext);
			}

			SessionMessages.add(request, "semestersDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", VIEW_SEMESTERS);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteLecturers(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Lecturer.class.getName(), request);
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (log.isDebugEnabled()) {
			log.debug(String.format("delta: %d", delta));
		}

		try {
			String[] lecturerIds = ParamUtil.getParameterValues(request, "deleteLecturerIds");

			if (log.isDebugEnabled()) {
				log.debug(String.format("lecturerIds: '%s'", Arrays.toString(lecturerIds)));
			}

			for (String lecturerIdString : lecturerIds) {
				long lecturerId = Long.parseLong(lecturerIdString);

				if (log.isTraceEnabled()) {
					log.trace(String.format("Deleting lecturer, id: %d", lecturerId));
				}

				LecturerLocalServiceUtil.deleteLecturer(lecturerId, serviceContext);
			}

			SessionMessages.add(request, "lecturersDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", VIEW_LECTURERS);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteTimetableCourses(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(TimetableCourse.class.getName(), request);
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (log.isDebugEnabled()) {
			log.debug(String.format("delta: %d", delta));
		}

		try {
			String[] timetableCourseIds = ParamUtil.getParameterValues(request, "deleteTimetableCourseIds");
			long semesterId = 0L;

			if (log.isDebugEnabled()) {
				log.debug(String.format("timetableCourseIds: '%s', semesterId: %d", Arrays.toString(timetableCourseIds),
						semesterId));
			}

			for (String timetableCourseString : timetableCourseIds) {
				long timetableCourseId = Long.parseLong(timetableCourseString);

				if (log.isTraceEnabled()) {
					log.trace(String.format("Deleting timetableCourse, id: %d", timetableCourseId));
				}

				TimetableCourse timetableCourse = TimetableCourseLocalServiceUtil
						.deleteTimetableCourse(timetableCourseId, serviceContext);

				semesterId = timetableCourse.getSemesterId();
			}

			SessionMessages.add(request, "timetableCoursesDeleted");
			response.setRenderParameter("semesterId", String.valueOf(semesterId));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", VIEW_TIMETABLE_COURSES_BY_SEMESTER);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void upload(ActionRequest request, ActionResponse response) throws Exception {
		String importType = ParamUtil.getString(request, "importType");

		if (log.isDebugEnabled()) {
			log.debug(String.format("importType: '%s'", importType));
		}

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);

		try (BufferedReader br = new BufferedReader(new FileReader(uploadRequest.getFile(fileInputName)))) {
			// skips the first line, which is a header
			String line = br.readLine();

			while ((line = br.readLine()) != null) {
				try {
					if (log.isTraceEnabled()) {
						log.trace("Parsing: " + line);
					}

					switch (importType) {
					case "syllabus":
						SyllabusCSVParser.parseLine(line, request);
						break;

					case "timetable":
						TimetableCSVParser.parseLine(line, request);
						break;

					default:
						throw new RuntimeException("Unknown importType: " + importType);
					}
				} catch (Exception e) {
					if (log.isErrorEnabled()) {
						log.error(e);
					}
				}
			}
		}
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		long curriculumId = ParamUtil.getLong(resourceRequest, "curriculumSelect");
		String curriculumSelected = ParamUtil.getString(resourceRequest, "curriculumSelected");

		long subjectId = ParamUtil.getLong(resourceRequest, "subjectSelect");
		String subjectSelected = ParamUtil.getString(resourceRequest, "subjectSelected");
		
		long courseId = ParamUtil.getLong(resourceRequest, "courseSelect");
		String courseSelected = ParamUtil.getString(resourceRequest, "courseSelected");

		if (log.isDebugEnabled()) {
			log.debug(String.format("curriculumId: %d, curriculumSelected: '%s'", curriculumId, curriculumSelected));
			log.debug(String.format("subjectId: %d, subjectSelected: '%s'", subjectId, subjectSelected));
			log.debug(String.format("courseId: %d, courseSelected: '%s'", courseId, courseSelected));
		}

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		if (curriculumSelected.equalsIgnoreCase("curriculumSelected")) {
			log.trace("Curriculum selected, serving subjects.");
			try {
				List<Subject> subjects = SubjectLocalServiceUtil.getSubjectsByCurriculumId(curriculumId);

				for (Subject subject : subjects) {
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

					jsonObject.put("subjectList", HtmlUtil.escapeAttribute(subject.toString()));
					jsonObject.put("subjectId", subject.getSubjectId());

					jsonArray.put(jsonObject);
				}
			} catch (SystemException e) {
				if (log.isErrorEnabled()) {
					log.error(e);
				}
			}
		}

		if (subjectSelected.equalsIgnoreCase("subjectSelected")) {
			log.trace("Subject selected, serving courses.");
			try {
				List<Course> courses = CourseLocalServiceUtil.getCoursesBySubjectId(subjectId);

				for (Course course : courses) {
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

					jsonObject.put("courseList", HtmlUtil.escapeAttribute(course.toString()));
					jsonObject.put("courseId", course.getCourseId());

					jsonArray.put(jsonObject);
				}
			} catch (SystemException e) {
				if (log.isErrorEnabled()) {
					log.error(e);
				}
			}
		}
		
		if (courseSelected.equalsIgnoreCase("courseSelected")) {
			log.trace("Course selected, serving timetableCourses.");
			try {
				List<TimetableCourse> timetableCourses = TimetableCourseLocalServiceUtil.getTimetableCoursesByCourseId(courseId);
				if (log.isTraceEnabled()) {
					log.trace("timetableCourses: " + timetableCourses);
				}
				
				for (TimetableCourse timetableCourse : timetableCourses) {
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
					
					jsonObject.put("timetableCourseList", HtmlUtil.escapeAttribute(timetableCourse.toString()));
					jsonObject.put("timetableCourseId", timetableCourse.getTimetableCourseId());
					
					jsonArray.put(jsonObject);
				}
			} catch (SystemException e) {
				if (log.isErrorEnabled()) {
					log.error(e);
				}
			}
		}

		try (PrintWriter writer = resourceResponse.getWriter()) {
			writer.write(jsonArray.toString());
			writer.flush();
		}
	}

}