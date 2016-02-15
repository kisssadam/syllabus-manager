package hu.unideb.inf.portlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import hu.unideb.inf.model.Course;
import hu.unideb.inf.model.CourseType;
import hu.unideb.inf.model.Curriculum;
import hu.unideb.inf.model.Lecturer;
import hu.unideb.inf.model.Semester;
import hu.unideb.inf.model.Subject;
import hu.unideb.inf.model.TimetableCourse;
import hu.unideb.inf.service.CourseLocalServiceUtil;
import hu.unideb.inf.service.CourseTypeLocalServiceUtil;
import hu.unideb.inf.service.CurriculumLocalServiceUtil;
import hu.unideb.inf.service.LecturerLocalServiceUtil;
import hu.unideb.inf.service.SemesterLocalServiceUtil;
import hu.unideb.inf.service.SubjectLocalServiceUtil;
import hu.unideb.inf.service.TimetableCourseLocalServiceUtil;
import hu.unideb.inf.util.SyllabusCSVParser;
import hu.unideb.inf.util.TimetableCSVParser;

/**
 * Portlet implementation class SubjectCourseAdminPortlet
 */
public class SubjectCourseAdminPortlet extends MVCPortlet {

	private static final String VIEW_CURRICULUMS = "/html/subjectcourseadmin/curriculums/view_curriculums.jsp";

	private static final String VIEW_SUBJECTS = "/html/subjectcourseadmin/subjects/view_subjects.jsp";

	private static final String VIEW_COURSES = "/html/subjectcourseadmin/courses/view_courses.jsp";

	private static final String VIEW_COURSE_TYPES = "/html/subjectcourseadmin/course_types/view_course_types.jsp";

	private static final String VIEW_SEMESTERS = "/html/subjectcourseadmin/semesters/view_semesters.jsp";

	private static final String VIEW_LECTURERS = "/html/subjectcourseadmin/lecturers/view_lecturers.jsp";

	private static final String VIEW_TIMETABLE_COURSES = "/html/subjectcourseadmin/timetablecourses/view_timetable_courses.jsp";

	private static final String EDIT_CURRICULUM = "/html/subjectcourseadmin/curriculums/edit_curriculum.jsp";

	private static final String EDIT_SUBJECT = "/html/subjectcourseadmin/subjects/edit_subject.jsp";

	private static final String EDIT_COURSE = "/html/subjectcourseadmin/courses/edit_course.jsp";

	private static final String EDIT_COURSE_TYPE = "/html/subjectcourseadmin/course_types/edit_course_type.jsp";

	private static final String EDIT_SEMESTER = "/html/subjectcourseadmin/semesters/edit_semester.jsp";

	private static final String EDIT_LECTURER = "/html/subjectcourseadmin/lecturers/edit_lecturer.jsp";

	private static final String EDIT_TIMETABLE_COURSE = "/html/subjectcourseadmin/timetablecourses/edit_timetable_course.jsp";

	private final static String fileInputName = "fileupload";

	public void addCurriculum(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Curriculum.class.getName(), request);

		long curriculumId = ParamUtil.getLong(request, "curriculumId");
		String curriculumCode = ParamUtil.getString(request, "curriculumCode");
		String curriculumName = ParamUtil.getString(request, "curriculumName");

		try {
			if (curriculumId > 0) {
				CurriculumLocalServiceUtil.updateCurriculum(serviceContext.getUserId(), curriculumId, curriculumCode,
						curriculumName, serviceContext);
				SessionMessages.add(request, "curriculumUpdated");
			} else {
				CurriculumLocalServiceUtil.addCurriculum(curriculumCode, curriculumName, serviceContext);
				SessionMessages.add(request, "curriculumAdded");
			}

			response.setRenderParameter("mvcPath", VIEW_CURRICULUMS);
		} catch (Exception e) {
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

		try {
			if (subjectId > 0) {
				SubjectLocalServiceUtil.updateSubject(serviceContext.getUserId(), subjectId, subjectCode, subjectName,
						credit, curriculumId, serviceContext);
				SessionMessages.add(request, "subjectUpdated");
			} else {
				SubjectLocalServiceUtil.addSubject(subjectCode, subjectName, credit, curriculumId, serviceContext);
				SessionMessages.add(request, "subjectAdded");
			}

			response.setRenderParameter("mvcPath", VIEW_SUBJECTS);
			response.setRenderParameter("curriculumId", String.valueOf(curriculumId));
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", EDIT_SUBJECT);
		}
	}

	public void addCourse(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Course.class.getName(), request);

		long courseId = ParamUtil.getLong(request, "courseId");
		long subjectId = ParamUtil.getLong(request, "subjectId");
		int hoursPerSemester = ParamUtil.getInteger(request, "hoursPerSemester");
		int hoursPerWeek = ParamUtil.getInteger(request, "hoursPerWeek");
		long courseTypeId = ParamUtil.getLong(request, "courseTypeId");

		try {
			if (courseId > 0) {
				CourseLocalServiceUtil.updateCourse(serviceContext.getUserId(), courseId, subjectId, hoursPerSemester,
						hoursPerWeek, courseTypeId, serviceContext);
				SessionMessages.add(request, "courseUpdated");
			} else {
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
		String type = ParamUtil.getString(request, "type");

		try {
			if (courseTypeId > 0) {
				CourseTypeLocalServiceUtil.updateCourseType(serviceContext.getUserId(), courseTypeId, type,
						serviceContext);
				SessionMessages.add(request, "courseTypeUpdated");
			} else {
				CourseTypeLocalServiceUtil.addCourseType(type, serviceContext);
				SessionMessages.add(request, "courseTypeAdded");
			}

			response.setRenderParameter("mvcPath", VIEW_COURSE_TYPES);
		} catch (Exception e) {
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

		try {
			if (semesterId > 0) {
				SemesterLocalServiceUtil.updateSemester(serviceContext.getUserId(), semesterId, beginYear, endYear,
						division, serviceContext);
				SessionMessages.add(request, "semesterUpdated");
			} else {
				SemesterLocalServiceUtil.addSemester(beginYear, endYear, division, serviceContext);
				SessionMessages.add(request, "semesterAdded");
			}

			response.setRenderParameter("mvcPath", VIEW_SEMESTERS);
		} catch (Exception e) {
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

		try {
			if (lecturerId > 0) {
				LecturerLocalServiceUtil.updateLecturer(serviceContext.getUserId(), lecturerId, lecturerName,
						lecturerUserId, serviceContext);
				SessionMessages.add(request, "lecturerUpdated");
			} else {
				LecturerLocalServiceUtil.addLecturer(lecturerName, lecturerUserId, serviceContext);
				SessionMessages.add(request, "lecturerAdded");
			}

			response.setRenderParameter("mvcPath", VIEW_LECTURERS);
		} catch (Exception e) {
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

		System.out.println("timetableCourseId :" + timetableCourseId);
		System.out.println("courseId: " + courseId);
		System.out.println("semesterId: " + semesterId);
		System.out.println("timetableCourseCode: " + timetableCourseCode);
		System.out.println("subjectType: " + subjectType);
		System.out.println("recommendedTerm: " + recommendedTerm);
		System.out.println("limit: " + limit);
		for (int i = 0; i < lecturerIds.length; i++) {
			System.out.println("lecturerIds[" + i + "]: " + lecturerIds[i]);
		}
		System.out.println("classScheduleInfo: " + classScheduleInfo);
		System.out.println("description: " + description);
		System.out.println();

		try {
			if (timetableCourseId > 0) {
				TimetableCourseLocalServiceUtil.updateTimetableCourse(serviceContext.getUserId(), timetableCourseId,
						courseId, semesterId, timetableCourseCode, subjectType, recommendedTerm, limit, lecturerIds,
						classScheduleInfo, description, serviceContext);

				SessionMessages.add(request, "timetableCourseUpdated");
			} else {
				TimetableCourseLocalServiceUtil.addTimetableCourse(courseId, semesterId, timetableCourseCode,
						subjectType, recommendedTerm, limit, lecturerIds, classScheduleInfo, description,
						serviceContext);

				SessionMessages.add(request, "timetableCourseAdded");
			}

			response.setRenderParameter("mvcPath", VIEW_TIMETABLE_COURSES);
			response.setRenderParameter("semesterId", String.valueOf(semesterId));
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", EDIT_TIMETABLE_COURSE);
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

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Curriculum.class.getName(), request);

			CurriculumLocalServiceUtil.deleteCurriculum(curriculumId, serviceContext);
			SessionMessages.add(request, "curriculumDeleted");
		} catch (Exception e) {
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

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Subject.class.getName(), request);

			Subject deletedSubject = SubjectLocalServiceUtil.deleteSubject(subjectId, serviceContext);
			SessionMessages.add(request, "subjectDeleted");

			response.setRenderParameter("curriculumId", String.valueOf(deletedSubject.getCurriculumId()));
		} catch (Exception e) {
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

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Course.class.getName(), request);

			Course deletedCourse = CourseLocalServiceUtil.deleteCourse(courseId, serviceContext);
			SessionMessages.add(request, "courseDeleted");

			response.setRenderParameter("subjectId", String.valueOf(deletedCourse.getSubjectId()));
		} catch (Exception e) {
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

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(CourseType.class.getName(), request);

			CourseTypeLocalServiceUtil.deleteCourseType(courseTypeId, serviceContext);
			SessionMessages.add(request, "courseTypeDeleted");
		} catch (Exception e) {
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

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Semester.class.getName(), request);

			SemesterLocalServiceUtil.deleteSemester(semesterId, serviceContext);
			SessionMessages.add(request, "semesterDeleted");
		} catch (Exception e) {
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

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Lecturer.class.getName(), request);

			LecturerLocalServiceUtil.deleteLecturer(lecturerId, serviceContext);
			SessionMessages.add(request, "lecturerDeleted");
		} catch (Exception e) {
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

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(TimetableCourse.class.getName(), request);

			TimetableCourse timetableCourse = TimetableCourseLocalServiceUtil.deleteTimetableCourse(timetableCourseId,
					serviceContext);
			SessionMessages.add(request, "timetableCourseDeleted");

			response.setRenderParameter("semesterId", String.valueOf(timetableCourse.getSemesterId()));
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", VIEW_TIMETABLE_COURSES);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void deleteCurriculums(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Curriculum.class.getName(), request);

		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		try {
			String[] curriculumIds = ParamUtil.getParameterValues(request, "deleteCurriculumIds");

			for (String curriculumIdString : curriculumIds) {
				long curriculumId = Long.parseLong(curriculumIdString);
				CurriculumLocalServiceUtil.deleteCurriculum(curriculumId, serviceContext);
			}

			SessionMessages.add(request, "curriculumsDeleted");
		} catch (Exception e) {
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

		try {
			Long curriculumId = ParamUtil.getLong(request, "curriculumId");

			String[] subjectIds = ParamUtil.getParameterValues(request, "deleteSubjectIds");

			for (String subjectIdString : subjectIds) {
				long subjectId = Long.parseLong(subjectIdString);
				SubjectLocalServiceUtil.deleteSubject(subjectId, serviceContext);
			}

			SessionMessages.add(request, "subjectsDeleted");
			response.setRenderParameter("curriculumId", String.valueOf(curriculumId));
		} catch (Exception e) {
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

		try {
			Long subjectId = ParamUtil.getLong(request, "subjectId");

			String[] courseIds = ParamUtil.getParameterValues(request, "deleteCourseIds");

			for (String courseIdString : courseIds) {
				long courseId = Long.parseLong(courseIdString);
				CourseLocalServiceUtil.deleteCourse(courseId, serviceContext);
			}

			SessionMessages.add(request, "coursesDeleted");
			response.setRenderParameter("subjectId", String.valueOf(subjectId));
		} catch (Exception e) {
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

		try {
			String[] courseTypeIds = ParamUtil.getParameterValues(request, "deleteCourseTypeIds");

			for (String courseTypeIdString : courseTypeIds) {
				long courseTypeId = Long.parseLong(courseTypeIdString);
				CourseTypeLocalServiceUtil.deleteCourseType(courseTypeId, serviceContext);
			}

			SessionMessages.add(request, "courseTypesDeleted");
		} catch (Exception e) {
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

		try {
			String[] semesterIds = ParamUtil.getParameterValues(request, "deleteSemesterIds");

			for (String semesterIdString : semesterIds) {
				long semesterId = Long.parseLong(semesterIdString);
				SemesterLocalServiceUtil.deleteSemester(semesterId, serviceContext);
			}

			SessionMessages.add(request, "semestersDeleted");
		} catch (Exception e) {
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

		try {
			String[] lecturerIds = ParamUtil.getParameterValues(request, "deleteLecturerIds");

			for (String lecturerIdString : lecturerIds) {
				long lecturerId = Long.parseLong(lecturerIdString);
				LecturerLocalServiceUtil.deleteLecturer(lecturerId, serviceContext);
			}

			SessionMessages.add(request, "lecturersDeleted");
		} catch (Exception e) {
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

		try {
			String[] timetableCourseIds = ParamUtil.getParameterValues(request, "deleteTimetableCourseIds");

			long semesterId = 0L;

			for (String timetableCourseString : timetableCourseIds) {
				long timetableCourseId = Long.parseLong(timetableCourseString);
				TimetableCourse timetableCourse = TimetableCourseLocalServiceUtil
						.deleteTimetableCourse(timetableCourseId, serviceContext);

				semesterId = timetableCourse.getSemesterId();
			}

			SessionMessages.add(request, "timetableCoursesDeleted");
			response.setRenderParameter("semesterId", String.valueOf(semesterId));
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
		} finally {
			response.setRenderParameter("mvcPath", VIEW_TIMETABLE_COURSES);
			response.setRenderParameter(SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}
	}

	public void upload(ActionRequest request, ActionResponse response) throws Exception {
		String importType = ParamUtil.getString(request, "importType");

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);

		File uploadedFile = uploadRequest.getFile(fileInputName);

		try (BufferedReader br = new BufferedReader(new FileReader(uploadedFile))) {
			String line = br.readLine(); // skips the first line, which is a header

			while ((line = br.readLine()) != null) {
				try {
					System.out.println("Parsing: " + line);

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
					System.out.println(e.toString());
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

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		if (curriculumSelected.equalsIgnoreCase("curriculumSelected")) {
			try {
				List<Subject> subjects = SubjectLocalServiceUtil.getSubjectsByCurriculumId(curriculumId);

				for (Subject subject : subjects) {
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

					jsonObject.put("subjectList", HtmlUtil.escapeAttribute(subject.toString()));
					jsonObject.put("subjectId", subject.getSubjectId());

					jsonArray.put(jsonObject);
				}
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}

		if (subjectSelected.equalsIgnoreCase("subjectSelected")) {
			try {
				List<Course> courses = CourseLocalServiceUtil.getCoursesBySubjectId(subjectId);

				for (Course course : courses) {
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

					jsonObject.put("courseList", HtmlUtil.escapeAttribute(course.toString()));
					jsonObject.put("courseId", course.getCourseId());

					jsonArray.put(jsonObject);
				}
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}

		PrintWriter writer = resourceResponse.getWriter();
		writer.write(jsonArray.toString());
		writer.flush();
	}

}
