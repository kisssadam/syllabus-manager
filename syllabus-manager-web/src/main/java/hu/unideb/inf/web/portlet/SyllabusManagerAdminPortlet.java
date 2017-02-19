package hu.unideb.inf.web.portlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ArrayUtil;
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
import hu.unideb.inf.service.CourseService;
import hu.unideb.inf.service.CourseTypeService;
import hu.unideb.inf.service.CurriculumService;
import hu.unideb.inf.service.LecturerService;
import hu.unideb.inf.service.SemesterService;
import hu.unideb.inf.service.SubjectService;
import hu.unideb.inf.service.SyllabusService;
import hu.unideb.inf.service.TimetableCourseService;
import hu.unideb.inf.web.constants.SyllabusManagerPortletKeys;
import hu.unideb.inf.web.constants.WebKeys;
import hu.unideb.inf.web.util.SyllabusCSVParser;
import hu.unideb.inf.web.util.TimetableCSVParser;

@Component(
	immediate = true,
	property = { 
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
		"javax.portlet.name=" + SyllabusManagerPortletKeys.SYLLABUS_MANAGER_ADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator,power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class SyllabusManagerAdminPortlet extends MVCPortlet {

	private static final Log log = LogFactoryUtil.getLog(SyllabusManagerAdminPortlet.class);

	private CurriculumService curriculumService;

	private SubjectService subjectService;
	
	private CourseService courseService;
	
	private TimetableCourseService timetableCourseService;
	
	private SyllabusService syllabusService;
	
	private CourseTypeService courseTypeService;
	
	private SemesterService semesterService;
	
	private LecturerService lecturerService;
	
	public void addCurriculum(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Curriculum.class.getName(), request);

		log.trace("addCurriculum()");
		
		long curriculumId = ParamUtil.getLong(request, "curriculumId");
		String curriculumCode = ParamUtil.getString(request, "curriculumCode");
		String curriculumName = ParamUtil.getString(request, "curriculumName");

		if (log.isDebugEnabled()) {
			log.debug(String.format("curriculumId: %d", curriculumId));
			log.debug(String.format("curriculumCode: '%s'", curriculumCode));
			log.debug(String.format("curriculumName: '%s'", curriculumName));
		}

		try {
			if (curriculumId > 0) {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Updating curriculum, id: %d", curriculumId));
				}
				curriculumService.updateCurriculum(serviceContext.getUserId(), curriculumId, curriculumCode,
						curriculumName, serviceContext);
				SessionMessages.add(request, "curriculumUpdated");
			} else {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Adding curriculum, id: %d", curriculumId));
				}
				curriculumService.addCurriculum(curriculumCode, curriculumName, serviceContext);
				SessionMessages.add(request, "curriculumAdded");
			}

			response.setRenderParameter("mvcPath", WebKeys.VIEW_CURRICULUMS);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", WebKeys.EDIT_CURRICULUM);
		}
	}

	public void addSubject(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Subject.class.getName(), request);

		log.trace("addSubject()");
		
		long subjectId = ParamUtil.getLong(request, "subjectId");
		String subjectCode = ParamUtil.getString(request, "subjectCode");
		String subjectName = ParamUtil.getString(request, "subjectName");
		int credit = ParamUtil.getInteger(request, "credit");
		long curriculumId = ParamUtil.getLong(request, "curriculumId");

		if (log.isDebugEnabled()) {
			log.debug(String.format("subjectId: %d", subjectId));
			log.debug(String.format("subjectCode: '%s'", subjectCode));
			log.debug(String.format("subjectName: '%s'", subjectName));
			log.debug(String.format("credit: %d", credit));
			log.debug(String.format("curriculumId: %d", curriculumId));
		}

		try {
			if (subjectId > 0) {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Updating subject, id: %d", subjectId));
				}
				subjectService.updateSubject(serviceContext.getUserId(), subjectId, subjectCode, subjectName,
						credit, curriculumId, serviceContext);
				SessionMessages.add(request, "subjectUpdated");
			} else {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Adding subject, id: %d", subjectId));
				}
				subjectService.addSubject(subjectCode, subjectName, credit, curriculumId, serviceContext);
				SessionMessages.add(request, "subjectAdded");
			}

			response.setRenderParameter("mvcPath", WebKeys.VIEW_SUBJECTS);
			response.setRenderParameter("curriculumId", String.valueOf(curriculumId));
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", WebKeys.EDIT_SUBJECT);
		}
	}

	public void addCourse(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Course.class.getName(), request);

		log.trace("addCourse()");
		
		long courseId = ParamUtil.getLong(request, "courseId");
		long subjectId = ParamUtil.getLong(request, "subjectSelect");
		int hoursPerSemester = ParamUtil.getInteger(request, "hoursPerSemester");
		int hoursPerWeek = ParamUtil.getInteger(request, "hoursPerWeek");
		long courseTypeId = ParamUtil.getLong(request, "courseTypeId");

		if (log.isDebugEnabled()) {
			log.debug(String.format("courseId: %d", courseId));
			log.debug(String.format("subjectId: %d", subjectId));
			log.debug(String.format("hoursPerSemester: %d", hoursPerSemester));
			log.debug(String.format("hoursPerWeek: %d", hoursPerWeek));
			log.debug(String.format("courseTypeId: %d", courseTypeId));
		}

		try {
			if (courseId > 0) {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Updating course, id: %d", courseId));
				}
				courseService.updateCourse(serviceContext.getUserId(), courseId, subjectId, hoursPerSemester,
						hoursPerWeek, courseTypeId, serviceContext);
				SessionMessages.add(request, "courseUpdated");
			} else {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Adding course, id: %d", courseId));
				}
				courseService.addCourse(subjectId, hoursPerSemester, hoursPerWeek, courseTypeId,
						serviceContext);
				SessionMessages.add(request, "courseAdded");
			}

			response.setRenderParameter("mvcPath", WebKeys.VIEW_COURSES);
			response.setRenderParameter("subjectId", String.valueOf(subjectId));
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", WebKeys.EDIT_COURSE);
		}
	}

	public void addCourseType(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(CourseType.class.getName(), request);

		log.trace("addCourseType()");
		
		long courseTypeId = ParamUtil.getLong(request, "courseTypeId");
		String typeName = ParamUtil.getString(request, "typeName");

		if (log.isDebugEnabled()) {
			log.debug(String.format("courseTypeId: %d", courseTypeId));
			log.debug(String.format("typeName: '%s'", typeName));
		}

		try {
			if (courseTypeId > 0) {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Updating courseType, id: %d", courseTypeId));
				}
				courseTypeService.updateCourseType(serviceContext.getUserId(), courseTypeId, typeName,
						serviceContext);
				SessionMessages.add(request, "courseTypeUpdated");
			} else {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Adding courseType, id: %d", courseTypeId));
				}
				courseTypeService.addCourseType(typeName, serviceContext);
				SessionMessages.add(request, "courseTypeAdded");
			}

			response.setRenderParameter("mvcPath", WebKeys.VIEW_COURSE_TYPES);
		} catch (Exception e) {
			log.error(e);
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", WebKeys.EDIT_COURSE_TYPE);
		}
	}

	public void addSemester(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Semester.class.getName(), request);

		log.trace("addSemester()");
		
		int beginYear = ParamUtil.getInteger(request, "beginYear");
		int endYear = ParamUtil.getInteger(request, "endYear");
		int division = ParamUtil.getInteger(request, "division");
		long semesterId = ParamUtil.getLong(request, "semesterId");

		if (log.isDebugEnabled()) {
			log.debug(String.format("beginYear: %d", beginYear));
			log.debug(String.format("endYear: %d", endYear));
			log.debug(String.format("division: %d", division));
			log.debug(String.format("semesterId: %d", semesterId));
		}

		try {
			if (semesterId > 0) {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Updating semester, id: %d", semesterId));
				}
				semesterService.updateSemester(serviceContext.getUserId(), semesterId, beginYear, endYear,
						division, serviceContext);
				SessionMessages.add(request, "semesterUpdated");
			} else {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Adding semester, id: %d", semesterId));
				}
				semesterService.addSemester(beginYear, endYear, division, serviceContext);
				SessionMessages.add(request, "semesterAdded");
			}

			response.setRenderParameter("mvcPath", WebKeys.VIEW_SEMESTERS);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", WebKeys.EDIT_SEMESTER);
		}
	}

	public void addLecturer(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Lecturer.class.getName(), request);

		log.trace("addLecturer()");
		
		long lecturerId = ParamUtil.getLong(request, "lecturerId");
		String lecturerName = ParamUtil.getString(request, "lecturerName");
		long lecturerUserId = ParamUtil.getLong(request, "lecturerUserId");

		if (log.isDebugEnabled()) {
			log.debug(String.format("lecturerId: %d", lecturerId));
			log.debug(String.format("lecturerName: '%s'", lecturerName));
			log.debug(String.format("lecturerUserId: %d", lecturerUserId));
		}

		try {
			if (lecturerId > 0) {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Updating lecturer, id: %d", lecturerId));
				}
				lecturerService.updateLecturer(serviceContext.getUserId(), lecturerId, lecturerName,
						lecturerUserId, serviceContext);
				SessionMessages.add(request, "lecturerUpdated");
			} else {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Adding lecturer, id: %d", lecturerId));
				}
				lecturerService.addLecturer(lecturerName, lecturerUserId, serviceContext);
				SessionMessages.add(request, "lecturerAdded");
			}

			response.setRenderParameter("mvcPath", WebKeys.VIEW_LECTURERS);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", WebKeys.EDIT_LECTURER);
		}
	}

	public void addTimetableCourse(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(TimetableCourse.class.getName(), request);
		
		log.trace("addTimetableCourse()");
		
		String home = ParamUtil.getString(request, "home");
		long curriculumId = ParamUtil.getLong(request, "curriculumSelect");
		long subjectId = ParamUtil.getLong(request, "subjectSelect");
		long courseId = ParamUtil.getLong(request, "courseSelect");
		long timetableCourseId = ParamUtil.getLong(request, "timetableCourseId");
		long semesterId = ParamUtil.getLong(request, "semesterId");
		String timetableCourseCode = ParamUtil.getString(request, "timetableCourseCode");
		String subjectType = ParamUtil.getString(request, "subjectType");
		int recommendedTerm = ParamUtil.getInteger(request, "recommendedTerm");
		int limit = ParamUtil.getInteger(request, "limit");
		long[] lecturerIds = getLecturerIds(request);
		String classScheduleInfo = ParamUtil.getString(request, "classScheduleInfo");
		String description = ParamUtil.getString(request, "description");

		if (log.isDebugEnabled()) {
			log.debug(String.format("home: '%s'", home));
			log.debug(String.format("curriculumId: %d", curriculumId));
			log.debug(String.format("subjectId: %d", subjectId));
			log.debug(String.format("courseId: %d", courseId));
			log.debug(String.format("timetableCourseId: %d", timetableCourseId));
			log.debug(String.format("semesterId: %d", semesterId));
			log.debug(String.format("timetableCourseCode: '%s'", timetableCourseCode));
			log.debug(String.format("subjectType: '%s'", subjectType));
			log.debug(String.format("recommendedTerm: %d", recommendedTerm));
			log.debug(String.format("limit: %d", limit));
			log.debug(String.format("lecturerIds: '%s'", Arrays.toString(lecturerIds)));
			log.debug(String.format("classScheduleInfo: '%s'", classScheduleInfo));
			log.debug(String.format("description: '%s'", description));
		}

		try {
			if (timetableCourseId > 0) {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Updating timetableCourse, id: %d", timetableCourseId));
				}
				timetableCourseService.updateTimetableCourse(serviceContext.getUserId(), timetableCourseId,
						courseId, semesterId, timetableCourseCode, subjectType, recommendedTerm, limit, lecturerIds,
						classScheduleInfo, description, serviceContext);

				SessionMessages.add(request, "timetableCourseUpdated");
			} else {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Adding timetableCourse, id: %d", timetableCourseId));
				}
				timetableCourseService.addTimetableCourse(courseId, semesterId, timetableCourseCode,
						subjectType, recommendedTerm, limit, lecturerIds, classScheduleInfo, description,
						serviceContext);

				SessionMessages.add(request, "timetableCourseAdded");
			}

			response.setRenderParameter("mvcPath", WebKeys.VIEW_TIMETABLE_COURSES);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", WebKeys.EDIT_TIMETABLE_COURSE);
		} finally {
			response.setRenderParameter("home", WebKeys.ADMIN_HOME_CURRICULUMS);
			response.setRenderParameter("curriculumId", String.valueOf(curriculumId));
			response.setRenderParameter("subjectId", String.valueOf(subjectId));
			response.setRenderParameter("courseId", String.valueOf(courseId));
			response.setRenderParameter("semesterId", String.valueOf(semesterId));
		}
	}

	public void addSyllabus(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Syllabus.class.getName(), request);
		
		log.trace("addSyllabus()");
		
		String home = ParamUtil.getString(request,  "home");
		long curriculumId = ParamUtil.getLong(request, "curriculumSelect");
		long subjectId = ParamUtil.getLong(request, "subjectSelect");
		long courseId = ParamUtil.getLong(request, "courseSelect");
		long timetableCourseId = ParamUtil.getLong(request, "timetableCourseSelect");
		long syllabusId = ParamUtil.getLong(request, "syllabusId");
		long semesterId = ParamUtil.getLong(request, "semesterId");
		String competence = ParamUtil.getString(request, "competence");
		String ethicalStandards = ParamUtil.getString(request, "ethicalStandards");
		String topics = ParamUtil.getString(request, "topics");
		String educationalMaterials = ParamUtil.getString(request, "educationalMaterials");
		String recommendedLiterature = ParamUtil.getString(request, "recommendedLiterature");
		String weeklyTasks = ParamUtil.getString(request, "weeklyTasks");
		
		if (log.isDebugEnabled()) {
			log.debug(String.format("home: '%s'", home));
			log.debug(String.format("curriculumId: %d", curriculumId));
			log.debug(String.format("subjectId: %d", subjectId));
			log.debug(String.format("courseId: %d", courseId));
			log.debug(String.format("timetableCourseId: %d", timetableCourseId));
			log.debug(String.format("syllabusId: %d", syllabusId));
			log.debug(String.format("semesterId: %d", semesterId));
			log.debug(String.format("competence: '%s'", competence));
			log.debug(String.format("ethicalStandards: '%s'", ethicalStandards));
			log.debug(String.format("topics: '%s'", topics));
			log.debug(String.format("educationalMaterials: '%s'", educationalMaterials));
			log.debug(String.format("recommendedLiterature: '%s'", recommendedLiterature));
			log.debug(String.format("weeklyTasks: '%s'", weeklyTasks));
		}
		
		try {
			if (syllabusId > 0) {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Updating syllabus, id: %d", syllabusId));
				}
				syllabusService.updateSyllabus(serviceContext.getUserId(), syllabusId, timetableCourseId,
						competence, ethicalStandards, topics, educationalMaterials,
						recommendedLiterature, weeklyTasks, serviceContext);
				
				SessionMessages.add(request, "syllabusUpdated");
			} else {
				if (log.isTraceEnabled()) {
					log.trace(String.format("Adding syllabus, id: %d", syllabusId));
				}
				syllabusService.addSyllabus(timetableCourseId, competence, ethicalStandards, topics,
						educationalMaterials, recommendedLiterature, weeklyTasks, serviceContext);
				
				SessionMessages.add(request, "syllabusAdded");
			}
			
			response.setRenderParameter("mvcPath", WebKeys.VIEW_SYLLABUSES);
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", WebKeys.EDIT_SYLLABUS);
		} finally {
			response.setRenderParameter("home", WebKeys.ADMIN_HOME_CURRICULUMS);
			response.setRenderParameter("curriculumId", String.valueOf(curriculumId));
			response.setRenderParameter("subjectId", String.valueOf(subjectId));
			response.setRenderParameter("courseId", String.valueOf(courseId));
			response.setRenderParameter("timetableCourseId", String.valueOf(timetableCourseId));
			response.setRenderParameter("semesterId", String.valueOf(semesterId));
		}
	}
	
	private long[] getLecturerIds(ActionRequest request) {
		log.trace("getLecturerIds()");
		
		Set<Long> lecturerIds = new LinkedHashSet<>();

		int[] rowIndexes = ParamUtil.getIntegerValues(request, "rowIndexes");

		for (int rowIndex : rowIndexes) {
			long lecturerId = ParamUtil.getLong(request, "lecturer" + rowIndex);
			lecturerIds.add(lecturerId);
		}

		return ArrayUtil.toArray(lecturerIds.toArray(new Long[lecturerIds.size()]));
	}

	public void deleteCurriculum(ActionRequest request, ActionResponse response) {
		log.trace("deleteCurriculum()");
		
		long curriculumId = ParamUtil.getLong(request, "curriculumId");
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
		
		if (log.isDebugEnabled()) {
			log.debug(String.format("curriculumId: %d", curriculumId));
			log.debug(String.format("delta: %d", delta));
		}

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Curriculum.class.getName(), request);

			if (log.isTraceEnabled()) {
				log.trace(String.format("Deleting curriculum, id: %d", curriculumId));
			}

			curriculumService.deleteCurriculum(curriculumId, serviceContext);
			SessionMessages.add(request, "curriculumDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", WebKeys.VIEW_CURRICULUMS);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteSubject(ActionRequest request, ActionResponse response) {
		log.trace("deleteSubject()");
		
		long curriculumId = ParamUtil.getLong(request, "curriculumId");
		long subjectId = ParamUtil.getLong(request, "subjectId");
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (log.isDebugEnabled()) {
			log.debug(String.format("curriculumId: %d", curriculumId));
			log.debug(String.format("subjectId: %d", subjectId));
			log.debug(String.format("delta: %d", delta));
		}

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Subject.class.getName(), request);
			
			if (log.isTraceEnabled()) {
				log.trace(String.format("Deleting subject, id: %d", subjectId));
			}

			subjectService.deleteSubject(subjectId, serviceContext);
			SessionMessages.add(request, "subjectDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", WebKeys.VIEW_SUBJECTS);
			response.setRenderParameter("curriculumId", String.valueOf(curriculumId));
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteCourse(ActionRequest request, ActionResponse response) {
		log.trace("deleteCourse()");
		
		long curriculumId = ParamUtil.getLong(request, "curriculumId");
		long subjectId = ParamUtil.getLong(request, "subjectId");
		long courseId = ParamUtil.getLong(request, "courseId");
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (log.isDebugEnabled()) {
			log.debug(String.format("curriculumId: %d", curriculumId));
			log.debug(String.format("subjectId: %d", subjectId));
			log.debug(String.format("courseId: %d", courseId));
			log.debug(String.format("delta: %d", delta));
		}

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Course.class.getName(), request);

			if (log.isTraceEnabled()) {
				log.trace(String.format("Deleting course, id: %d", courseId));
			}

			courseService.deleteCourse(courseId, serviceContext);
			SessionMessages.add(request, "courseDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", WebKeys.VIEW_COURSES);
			response.setRenderParameter("curriculumId", String.valueOf(curriculumId));
			response.setRenderParameter("subjectId", String.valueOf(subjectId));
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteCourseType(ActionRequest request, ActionResponse response) {
		log.trace("deleteCourseType()");
		
		long courseTypeId = ParamUtil.getLong(request, "courseTypeId");
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (log.isDebugEnabled()) {
			log.debug(String.format("courseTypeId: %d", courseTypeId));
			log.debug(String.format("delta: %d", delta));
		}

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(CourseType.class.getName(), request);

			if (log.isTraceEnabled()) {
				log.trace(String.format("Deleting courseType, id: %d", courseTypeId));
			}

			courseTypeService.deleteCourseType(courseTypeId, serviceContext);
			SessionMessages.add(request, "courseTypeDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", WebKeys.VIEW_COURSE_TYPES);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteSemester(ActionRequest request, ActionResponse response) {
		log.trace("deleteSemester()");
		
		long semesterId = ParamUtil.getLong(request, "semesterId");
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (log.isDebugEnabled()) {
			log.debug(String.format("semesterId: %d", semesterId));
			log.debug(String.format("delta: %d", delta));
		}

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Semester.class.getName(), request);

			if (log.isTraceEnabled()) {
				log.trace(String.format("Deleting semester, id: %d", semesterId));
			}

			semesterService.deleteSemester(semesterId, serviceContext);
			SessionMessages.add(request, "semesterDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", WebKeys.VIEW_SEMESTERS);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteLecturer(ActionRequest request, ActionResponse response) {
		log.trace("deleteLecturer()");
		
		long lecturerId = ParamUtil.getLong(request, "lecturerId");
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (log.isDebugEnabled()) {
			log.debug(String.format("lecturerId: %d", lecturerId));
			log.debug(String.format("delta: %d", delta));
		}

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Lecturer.class.getName(), request);

			if (log.isTraceEnabled()) {
				log.trace(String.format("Deleting lecturer, id: %d", lecturerId));
			}

			lecturerService.deleteLecturer(lecturerId, serviceContext);
			SessionMessages.add(request, "lecturerDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", WebKeys.VIEW_LECTURERS);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteTimetableCourse(ActionRequest request, ActionResponse response) {
		log.trace("deleteTimetableCourse()");
		
		String home = ParamUtil.getString(request, "home");
		long curriculumId = ParamUtil.getLong(request, "curriculumId");
		long subjectId = ParamUtil.getLong(request, "subjectId");
		long courseId = ParamUtil.getLong(request, "courseId");
		long timetableCourseId = ParamUtil.getLong(request, "timetableCourseId");
		long semesterId = ParamUtil.getLong(request, "semesterId");
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (log.isDebugEnabled()) {
			log.debug(String.format("home: '%s'", home));
			log.debug(String.format("curriculumId: %d", curriculumId));
			log.debug(String.format("subjectId: %d", subjectId));
			log.debug(String.format("courseId: %d", courseId));
			log.debug(String.format("timetableCourseId: %d", timetableCourseId));
			log.debug(String.format("semesterId: %d", semesterId));
			log.debug(String.format("delta: %d", delta));
		}

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(TimetableCourse.class.getName(), request);

			if (log.isTraceEnabled()) {
				log.trace(String.format("Deleting timetableCourse, id: %d", timetableCourseId));
			}

			timetableCourseService.deleteTimetableCourse(timetableCourseId, serviceContext);
			SessionMessages.add(request, "timetableCourseDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", WebKeys.VIEW_TIMETABLE_COURSES);
			response.setRenderParameter("home", home);
			response.setRenderParameter("curriculumId", String.valueOf(curriculumId));
			response.setRenderParameter("subjectId", String.valueOf(subjectId));
			response.setRenderParameter("courseId", String.valueOf(courseId));
			response.setRenderParameter("semesterId", String.valueOf(semesterId));
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}
	
	public void deleteSyllabus(ActionRequest request, ActionResponse response) {
		log.trace("deleteSyllabus()");
		
		String home = ParamUtil.getString(request, "home");
		long curriculumId = ParamUtil.getLong(request, "curriculumId");
		long subjectId = ParamUtil.getLong(request, "subjectId");
		long courseId = ParamUtil.getLong(request, "courseId");
		long timetableCourseId = ParamUtil.getLong(request, "timetableCourseId");
		long syllabusId = ParamUtil.getLong(request, "syllabusId");
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (log.isDebugEnabled()) {
			log.debug(String.format("home: '%s'", home));
			log.debug(String.format("curriculumId: %d", curriculumId));
			log.debug(String.format("subjectId: %d", subjectId));
			log.debug(String.format("courseId: %d", courseId));
			log.debug(String.format("timetableCourseId: %d", timetableCourseId));
			log.debug(String.format("syllabusId: %d", syllabusId));
			log.debug(String.format("delta: %d", delta));
		}

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Syllabus.class.getName(), request);

			if (log.isTraceEnabled()) {
				log.trace(String.format("Deleting syllabus, id: %d", syllabusId));
			}

			syllabusService.deleteSyllabus(syllabusId, serviceContext);
			SessionMessages.add(request, "syllabusDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", WebKeys.VIEW_SYLLABUSES);
			response.setRenderParameter("home", home);
			response.setRenderParameter("curriculumId", String.valueOf(curriculumId));
			response.setRenderParameter("subjectId", String.valueOf(subjectId));
			response.setRenderParameter("courseId", String.valueOf(courseId));
			response.setRenderParameter("timetableCourseId", String.valueOf(timetableCourseId));
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteCurriculums(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Curriculum.class.getName(), request);
		
		log.trace("deleteCurriculums()");
		
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
		String[] curriculumIds = ParamUtil.getParameterValues(request, "deleteCurriculumIds");

		if (log.isDebugEnabled()) {
			log.debug(String.format("delta: %d", delta));
			log.debug(String.format("curriculumIds: '%s'", Arrays.toString(curriculumIds)));
		}

		try {
			for (String curriculumIdString : curriculumIds) {
				long curriculumId = Long.parseLong(curriculumIdString);

				if (log.isTraceEnabled()) {
					log.trace(String.format("Deleting curriculum, id: %d", curriculumId));
				}

				curriculumService.deleteCurriculum(curriculumId, serviceContext);
			}

			SessionMessages.add(request, "curriculumsDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", WebKeys.VIEW_CURRICULUMS);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteSubjects(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Subject.class.getName(), request);
		
		log.trace("deleteSubjects()");
		
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
		Long curriculumId = ParamUtil.getLong(request, "curriculumId");
		String[] subjectIds = ParamUtil.getParameterValues(request, "deleteSubjectIds");

		if (log.isDebugEnabled()) {
			log.debug(String.format("delta: %d", delta));
			log.debug(String.format("curriculumId: %d", curriculumId));
			log.debug(String.format("subjectIds: '%s'", Arrays.toString(subjectIds)));
		}

		try {
			for (String subjectIdString : subjectIds) {
				long subjectId = Long.parseLong(subjectIdString);

				if (log.isTraceEnabled()) {
					log.trace(String.format("Deleting subject, id: %d", subjectId));
				}

				subjectService.deleteSubject(subjectId, serviceContext);
			}

			SessionMessages.add(request, "subjectsDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", WebKeys.VIEW_SUBJECTS);
			response.setRenderParameter("curriculumId", String.valueOf(curriculumId));
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteCourses(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Course.class.getName(), request);
		
		log.trace("deleteCourses()");
		
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
		Long subjectId = ParamUtil.getLong(request, "subjectId");
		String[] courseIds = ParamUtil.getParameterValues(request, "deleteCourseIds");

		if (log.isDebugEnabled()) {
			log.debug(String.format("delta: %d", delta));
			log.debug(String.format("subjectId: %d", subjectId));
			log.debug(String.format("courseIds: '%s'", Arrays.toString(courseIds)));
		}
		
		try {
			for (String courseIdString : courseIds) {
				long courseId = Long.parseLong(courseIdString);

				if (log.isTraceEnabled()) {
					log.trace(String.format("Deleting course, id: %d", courseId));
				}

				courseService.deleteCourse(courseId, serviceContext);
			}

			SessionMessages.add(request, "coursesDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", WebKeys.VIEW_COURSES);
			response.setRenderParameter("subjectId", String.valueOf(subjectId));
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteCourseTypes(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(CourseType.class.getName(), request);
		
		log.trace("deleteCourseTypes()");
		
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
		String[] courseTypeIds = ParamUtil.getParameterValues(request, "deleteCourseTypeIds");

		if (log.isDebugEnabled()) {
			log.debug(String.format("delta: %d", delta));
			log.debug(String.format("courseTypeIds: '%s'", Arrays.toString(courseTypeIds)));
		}

		try {
			for (String courseTypeIdString : courseTypeIds) {
				long courseTypeId = Long.parseLong(courseTypeIdString);

				if (log.isTraceEnabled()) {
					log.trace(String.format("Deleting courseType, id: %d", courseTypeId));
				}

				courseTypeService.deleteCourseType(courseTypeId, serviceContext);
			}

			SessionMessages.add(request, "courseTypesDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", WebKeys.VIEW_COURSE_TYPES);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteSemesters(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Semester.class.getName(), request);
		
		log.trace("deleteSemesters()");
		
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
		String[] semesterIds = ParamUtil.getParameterValues(request, "deleteSemesterIds");

		if (log.isDebugEnabled()) {
			log.debug(String.format("delta: %d", delta));
			log.debug(String.format("semesterIds: '%s'", Arrays.toString(semesterIds)));
		}

		try {
			for (String semesterIdString : semesterIds) {
				long semesterId = Long.parseLong(semesterIdString);

				if (log.isTraceEnabled()) {
					log.trace(String.format("Deleting semester, id: %d", semesterId));
				}

				semesterService.deleteSemester(semesterId, serviceContext);
			}

			SessionMessages.add(request, "semestersDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", WebKeys.VIEW_SEMESTERS);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteLecturers(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Lecturer.class.getName(), request);
		
		log.trace("deleteLecturers()");
		
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
		String[] lecturerIds = ParamUtil.getParameterValues(request, "deleteLecturerIds");

		if (log.isDebugEnabled()) {
			log.debug(String.format("delta: %d", delta));
			log.debug(String.format("lecturerIds: '%s'", Arrays.toString(lecturerIds)));
		}

		try {
			for (String lecturerIdString : lecturerIds) {
				long lecturerId = Long.parseLong(lecturerIdString);

				if (log.isTraceEnabled()) {
					log.trace(String.format("Deleting lecturer, id: %d", lecturerId));
				}

				lecturerService.deleteLecturer(lecturerId, serviceContext);
			}

			SessionMessages.add(request, "lecturersDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", WebKeys.VIEW_LECTURERS);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteTimetableCourses(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(TimetableCourse.class.getName(), request);
		
		log.trace("deleteTimetableCourses()");
		
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
		String home = ParamUtil.getString(request, "home");
		long courseId = ParamUtil.getLong(request, "courseId");
		long semesterId = ParamUtil.getLong(request, "semesterId");
		String[] timetableCourseIds = ParamUtil.getParameterValues(request, "deleteTimetableCourseIds");

		if (log.isDebugEnabled()) {
			log.debug(String.format("home: '%s'", home));
			log.debug(String.format("courseId: %d", courseId));
			log.debug(String.format("semesterId: %d", semesterId));
			log.debug(String.format("delta: %d", delta));
			log.debug(String.format("timetableCourseIds: '%s'", Arrays.toString(timetableCourseIds)));
		}

		try {
			for (String timetableCourseString : timetableCourseIds) {
				long timetableCourseId = Long.parseLong(timetableCourseString);

				if (log.isTraceEnabled()) {
					log.trace(String.format("Deleting timetableCourse, id: %d", timetableCourseId));
				}

				timetableCourseService.deleteTimetableCourse(timetableCourseId, serviceContext);
			}

			SessionMessages.add(request, "timetableCoursesDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", WebKeys.VIEW_TIMETABLE_COURSES);
			response.setRenderParameter("home", home);
			response.setRenderParameter("courseId", String.valueOf(courseId));
			response.setRenderParameter("semesterId", String.valueOf(semesterId));
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}
	
	public void deleteSyllabuses(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Syllabus.class.getName(), request);
		
		log.trace("deleteSyllabuses()");
		
		String home = ParamUtil.getString(request, "home");
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
		long timetableCourseId = ParamUtil.getLong(request, "timetableCourseId");
		String[] syllabusIds = ParamUtil.getParameterValues(request, "syllabusIds");

		if (log.isDebugEnabled()) {
			log.debug(String.format("home: '%s'", home));
			log.debug(String.format("delta: %d", delta));
			log.debug(String.format("timetableCourseId: %d", timetableCourseId));
			log.debug(String.format("syllabusIds: '%s'", Arrays.toString(syllabusIds)));
		}

		try {
			for (String syllabusIdString : syllabusIds) {
				long syllabusId = Long.parseLong(syllabusIdString);

				if (log.isTraceEnabled()) {
					log.trace(String.format("Deleting syllabus, id: %d", syllabusId));
				}

				syllabusService.deleteSyllabus(syllabusId, serviceContext);
			}

			SessionMessages.add(request, "syllabusesDeleted");
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}

			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", WebKeys.VIEW_SYLLABUSES);
			response.setRenderParameter("home", home);
			response.setRenderParameter("timetableCourseId", String.valueOf(timetableCourseId));
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void clearDatabase(ActionRequest request, ActionResponse response) throws PortalException {
		log.trace("clearDatabase()");
		
		boolean deleteSyllabuses = ParamUtil.getBoolean(request, "deleteSyllabuses");
		boolean deleteTimetableCourses = ParamUtil.getBoolean(request, "deleteTimetableCourses");
		boolean deleteCourses = ParamUtil.getBoolean(request, "deleteCourses");
		boolean deleteCourseTypes = ParamUtil.getBoolean(request, "deleteCourseTypes");
		boolean deleteSubjects = ParamUtil.getBoolean(request, "deleteSubjects");
		boolean deleteCurriculums = ParamUtil.getBoolean(request, "deleteCurriculums");
		boolean deleteLecturers = ParamUtil.getBoolean(request, "deleteLecturers");
		boolean deleteSemesters = ParamUtil.getBoolean(request, "deleteSemesters");
		
		if (log.isDebugEnabled()) {
			log.debug(String.format("deletesSyllabuses: '%s'", deleteSyllabuses));
			log.debug(String.format("deleteTimetableCourses: '%s'", deleteTimetableCourses));
			log.debug(String.format("deleteCourses: '%s'", deleteCourses));
			log.debug(String.format("deleteCourseTypes: '%s'", deleteCourseTypes));
			log.debug(String.format("deleteSubjects: '%s'", deleteSubjects));
			log.debug(String.format("deleteCurriculums: '%s'", deleteCurriculums));
			log.debug(String.format("deleteLecturers: '%s'", deleteLecturers));
			log.debug(String.format("deleteSemesters: '%s'", deleteSemesters));
		}
		
		if (deleteSyllabuses) {
			deleteSyllabuses(request);
		}
		if (deleteTimetableCourses) {
			deleteTimetableCourses(request);
		}
		if (deleteCourses) {
			deleteCourses(request);
		}
		if (deleteCourseTypes) {
			deleteCourseTypes(request);
		}
		if (deleteSubjects) {
			deleteSubjects(request);
		}
		if (deleteCurriculums) {
			deleteCurriculums(request);
		}
		if (deleteLecturers) {
			deleteLecturers(request);
		}
		if (deleteSemesters) {
			deleteSemesters(request);
		}
	}

	private void deleteSemesters(ActionRequest request) {
		log.trace("Deleting every semester.");
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Semester.class.getName(), request);
			
			List<Semester> semesters = semesterService.getSemesters();
			for (Semester semester : semesters) {
				semesterService.deleteSemester(semester.getSemesterId(), serviceContext);
			}
			SessionMessages.add(request, "semestersDeleted");
		} catch (Exception e) {
			log.error(e);
			SessionErrors.add(request, e.getClass().getName());
		}
	}

	private void deleteLecturers(ActionRequest request) {
		log.trace("Deleting every lecturer.");
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Lecturer.class.getName(), request);
			
			List<Lecturer> lecturers = lecturerService.getLecturers();
			for (Lecturer lecturer : lecturers) {
				lecturerService.deleteLecturer(lecturer.getLecturerId(), serviceContext);
			}
			SessionMessages.add(request, "lecturersDeleted");
		} catch (Exception e) {
			log.error(e);
			SessionErrors.add(request, e.getClass().getName());
		}
	}

	private void deleteCurriculums(ActionRequest request) {
		log.trace("Deleting every curriculum.");
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Curriculum.class.getName(), request);
			
			List<Curriculum> curriculums = curriculumService.getCurriculums();
			for (Curriculum curriculum : curriculums) {
				curriculumService.deleteCurriculum(curriculum.getCurriculumId(), serviceContext);
			}
			SessionMessages.add(request, "curriculumsDeleted");
		} catch (Exception e) {
			log.error(e);
			SessionErrors.add(request, e.getClass().getName());
		}
	}

	private void deleteSubjects(ActionRequest request) {
		log.trace("Deleting every subject.");
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Subject.class.getName(), request);
			
			List<Subject> subjects = subjectService.getSubjects();
			for (Subject subject : subjects) {
				subjectService.deleteSubject(subject.getSubjectId(), serviceContext);
			}
			SessionMessages.add(request, "subjectsDeleted");
		} catch (Exception e) {
			log.error(e);
			SessionErrors.add(request, e.getClass().getName());
		}
	}

	private void deleteCourseTypes(ActionRequest request) {
		log.trace("Deleting every course type.");
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(CourseType.class.getName(), request);
			
			List<CourseType> courseTypes = courseTypeService.getCourseTypes();
			for (CourseType courseType : courseTypes) {
				courseTypeService.deleteCourseType(courseType.getCourseTypeId(), serviceContext);
			}
			SessionMessages.add(request, "courseTypesDeleted");
		} catch (Exception e) {
			log.error(e);
			SessionErrors.add(request, e.getClass().getName());
		}
	}

	private void deleteCourses(ActionRequest request) {
		log.trace("Deleting every course.");
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Course.class.getName(), request);
			
			List<Course> courses = courseService.getCourses();
			for (Course course : courses) {
				courseService.deleteCourse(course.getCourseId(), serviceContext);
			}
			SessionMessages.add(request, "coursesDeleted");
		} catch (Exception e) {
			log.error(e);
			SessionErrors.add(request, e.getClass().getName());
		}
	}

	private void deleteTimetableCourses(ActionRequest request) {
		log.trace("Deleting every timetable course.");
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(TimetableCourse.class.getName(), request);
			
			List<TimetableCourse> timetableCourses = timetableCourseService.getTimetableCourses();
			for (TimetableCourse timetableCourse : timetableCourses) {
				timetableCourseService.deleteTimetableCourse(timetableCourse.getTimetableCourseId(), serviceContext);
			}
			SessionMessages.add(request, "timetableCoursesDeleted");
		} catch (Exception e) {
			log.error(e);
			SessionErrors.add(request, e.getClass().getName());
		}
	}

	private void deleteSyllabuses(ActionRequest request) {
		log.trace("Deleting every syllabus.");
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Syllabus.class.getName(), request);
			
			List<Syllabus> syllabuses = syllabusService.getSyllabuses();
			for (Syllabus syllabus : syllabuses) {
				syllabusService.deleteSyllabus(syllabus.getSyllabusId(), serviceContext);
			}
			SessionMessages.add(request, "syllabusesDeleted");
		} catch (Exception e) {
			log.error(e);
			SessionErrors.add(request, e.getClass().getName());
		}
	}
	
	public void upload(ActionRequest request, ActionResponse response) throws Exception {
		log.trace("upload()");
		
		String importType = ParamUtil.getString(request, "importType");

		if (log.isDebugEnabled()) {
			log.debug(String.format("importType: '%s'", importType));
		}

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);

		try (BufferedReader br = new BufferedReader(new FileReader(uploadRequest.getFile(WebKeys.FILE_INPUT_NAME)))) {
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

	@Reference(unbind = "-")
	protected void setCurriculumService(CurriculumService curriculumService) {
		this.curriculumService = curriculumService;
	}
	
	@Reference(unbind = "-")
	protected void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	
	@Reference(unbind = "-")
	protected void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@Reference(unbind = "-")
	protected void setTimetableCourseService(TimetableCourseService timetableCourseService) {
		this.timetableCourseService = timetableCourseService;
	}
	
	@Reference(unbind = "-")
	protected void setSyllabusService(SyllabusService syllabusService) {
		this.syllabusService = syllabusService;
	}
	
	@Reference(unbind = "-")
	protected void setCourseTypeService(CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}
	
	@Reference(unbind = "-")
	protected void setSemesterService(SemesterService semesterService) {
		this.semesterService = semesterService;
	}
	
	@Reference(unbind = "-")
	protected void setLecturerService(LecturerService lecturerService) {
		this.lecturerService = lecturerService;
	}
	
}
