package hu.unideb.inf.portlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
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
import hu.unideb.inf.service.CourseLocalServiceUtil;
import hu.unideb.inf.service.CourseTypeLocalServiceUtil;
import hu.unideb.inf.service.CurriculumLocalServiceUtil;
import hu.unideb.inf.service.LecturerLocalServiceUtil;
import hu.unideb.inf.service.SemesterLocalServiceUtil;
import hu.unideb.inf.service.SubjectLocalServiceUtil;

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

	private static final String EDIT_CURRICULUM = "/html/subjectcourseadmin/curriculums/edit_curriculum.jsp";

	private static final String EDIT_SUBJECT = "/html/subjectcourseadmin/subjects/edit_subject.jsp";

	private static final String EDIT_COURSE = "/html/subjectcourseadmin/courses/edit_course.jsp";

	private static final String EDIT_COURSE_TYPE = "/html/subjectcourseadmin/course_types/edit_course_type.jsp";

	private static final String EDIT_SEMESTER = "/html/subjectcourseadmin/semesters/edit_semester.jsp";

	private static final String EDIT_LECTURER = "/html/subjectcourseadmin/lecturers/edit_lecturer.jsp";

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
			e.printStackTrace();
		}
	}

	public void deleteCurriculum(ActionRequest request, ActionResponse response) {
		long curriculumId = ParamUtil.getLong(request, "curriculumId");

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Curriculum.class.getName(), request);

			CurriculumLocalServiceUtil.deleteCurriculum(curriculumId, serviceContext);
			SessionMessages.add(request, "curriculumDeleted");

			response.setRenderParameter("mvcPath", VIEW_CURRICULUMS);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", VIEW_CURRICULUMS);
		}
	}

	public void deleteSubject(ActionRequest request, ActionResponse response) {
		long subjectId = ParamUtil.getLong(request, "subjectId");

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Subject.class.getName(), request);

			Subject deletedSubject = SubjectLocalServiceUtil.deleteSubject(subjectId, serviceContext);
			SessionMessages.add(request, "subjectDeleted");

			response.setRenderParameter("mvcPath", VIEW_SUBJECTS);
			response.setRenderParameter("curriculumId", String.valueOf(deletedSubject.getCurriculumId()));
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", VIEW_SUBJECTS);
		}
	}

	public void deleteCourse(ActionRequest request, ActionResponse response) {
		long courseId = ParamUtil.getLong(request, "courseId");

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Course.class.getName(), request);

			Course deletedCourse = CourseLocalServiceUtil.deleteCourse(courseId, serviceContext);
			SessionMessages.add(request, "courseDeleted");

			response.setRenderParameter("mvcPath", VIEW_COURSES);
			response.setRenderParameter("subjectId", String.valueOf(deletedCourse.getSubjectId()));
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", VIEW_COURSES);
		}
	}

	public void deleteCourseType(ActionRequest request, ActionResponse response) {
		long courseTypeId = ParamUtil.getLong(request, "courseTypeId");

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(CourseType.class.getName(), request);

			CourseTypeLocalServiceUtil.deleteCourseType(courseTypeId, serviceContext);
			SessionMessages.add(request, "courseTypeDeleted");

			response.setRenderParameter("mvcPath", VIEW_COURSE_TYPES);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", VIEW_COURSE_TYPES);
		}
	}

	public void deleteSemester(ActionRequest request, ActionResponse response) {
		long semesterId = ParamUtil.getLong(request, "semesterId");

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Semester.class.getName(), request);

			SemesterLocalServiceUtil.deleteSemester(semesterId, serviceContext);
			SessionMessages.add(request, "semesterDeleted");

			response.setRenderParameter("mvcPath", VIEW_SEMESTERS);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", VIEW_SEMESTERS);
		}
	}

	public void deleteLecturer(ActionRequest request, ActionResponse response) {
		long lecturerId = ParamUtil.getLong(request, "lecturerId");

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Lecturer.class.getName(), request);

			LecturerLocalServiceUtil.deleteLecturer(lecturerId, serviceContext);
			SessionMessages.add(request, "lecturerDeleted");

			response.setRenderParameter("mvcPath", VIEW_LECTURERS);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", VIEW_LECTURERS);
		}
	}

	public void deleteCurriculums(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Curriculum.class.getName(), request);

		try {
			String[] curriculumIds = ParamUtil.getParameterValues(request, "deleteCurriculumIds");

			for (String curriculumIdString : curriculumIds) {
				long curriculumId = Long.parseLong(curriculumIdString);
				CurriculumLocalServiceUtil.deleteCurriculum(curriculumId, serviceContext);
			}

			SessionMessages.add(request, "curriculumsDeleted");
			response.setRenderParameter("mvcPath", VIEW_CURRICULUMS);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", VIEW_CURRICULUMS);
		}
	}

	public void deleteSubjects(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Subject.class.getName(), request);
		try {
			Long curriculumId = ParamUtil.getLong(request, "curriculumId");

			String[] subjectIds = ParamUtil.getParameterValues(request, "deleteSubjectIds");

			for (String subjectIdString : subjectIds) {
				long subjectId = Long.parseLong(subjectIdString);
				SubjectLocalServiceUtil.deleteSubject(subjectId, serviceContext);
			}

			SessionMessages.add(request, "subjectsDeleted");

			response.setRenderParameter("mvcPath", VIEW_SUBJECTS);
			response.setRenderParameter("curriculumId", String.valueOf(curriculumId));
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", VIEW_SUBJECTS);
		}
	}

	public void deleteCourses(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Course.class.getName(), request);
		try {
			Long subjectId = ParamUtil.getLong(request, "subjectId");

			String[] courseIds = ParamUtil.getParameterValues(request, "deleteCourseIds");

			for (String courseIdString : courseIds) {
				long courseId = Long.parseLong(courseIdString);
				CourseLocalServiceUtil.deleteCourse(courseId, serviceContext);
			}

			SessionMessages.add(request, "coursesDeleted");

			response.setRenderParameter("mvcPath", VIEW_COURSES);
			response.setRenderParameter("subjectId", String.valueOf(subjectId));
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", VIEW_COURSES);
		}
	}

	public void deleteCourseTypes(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(CourseType.class.getName(), request);

		try {
			String[] courseTypeIds = ParamUtil.getParameterValues(request, "deleteCourseTypeIds");

			for (String courseTypeIdString : courseTypeIds) {
				long courseTypeId = Long.parseLong(courseTypeIdString);
				CourseTypeLocalServiceUtil.deleteCourseType(courseTypeId, serviceContext);
			}

			SessionMessages.add(request, "courseTypesDeleted");

			response.setRenderParameter("mvcPath", VIEW_COURSE_TYPES);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", VIEW_COURSE_TYPES);
		}
	}

	public void deleteSemesters(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Semester.class.getName(), request);

		try {
			String[] semesterIds = ParamUtil.getParameterValues(request, "deleteSemesterIds");

			for (String semesterIdString : semesterIds) {
				long semesterId = Long.parseLong(semesterIdString);
				SemesterLocalServiceUtil.deleteSemester(semesterId, serviceContext);
			}

			SessionMessages.add(request, "semestersDeleted");

			response.setRenderParameter("mvcPath", VIEW_SEMESTERS);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", VIEW_SEMESTERS);
		}
	}

	public void deleteLecturers(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Lecturer.class.getName(), request);

		try {
			String[] lecturerIds = ParamUtil.getParameterValues(request, "deleteLecturerIds");

			for (String lecturerIdString : lecturerIds) {
				long lecturerId = Long.parseLong(lecturerIdString);
				LecturerLocalServiceUtil.deleteLecturer(lecturerId, serviceContext);
			}

			SessionMessages.add(request, "lecturersDeleted");
			response.setRenderParameter("mvcPath", VIEW_LECTURERS);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", VIEW_LECTURERS);
		}
	}

	public void upload(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(SubjectCourseAdminPortlet.class.getName(),
				request);

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);

		File uploadedFile = uploadRequest.getFile(fileInputName);

		try (BufferedReader br = new BufferedReader(new FileReader(uploadedFile))) {
			String line = br.readLine(); // skips the first line, which is a header

			while ((line = br.readLine()) != null) {
				try {
					System.out.println("Parsing: " + line);
					parseLine(line, serviceContext);
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		}
	}

	private void parseLine(String line, ServiceContext serviceContext) throws PortalException, SystemException {
		String[] tokens = line.split(";");

		String subjectName = tokens[0];
		String subjectCode = tokens[1];
		int credit = Integer.parseInt(tokens[2]);
		String curriculumName = tokens[3];
		String curriculumCode = tokens[4];

		Curriculum curriculum = parseCurriculum(curriculumCode, curriculumName, serviceContext);
		Subject subject = parseSubject(curriculum, subjectCode, subjectName, credit, serviceContext);

		int i;
		for (i = 5; i <= tokens.length - 3; i += 3) {
			String hoursPerSemesterField = tokens[i];
			String hoursPerWeekField = tokens[i + 1];
			String typeOfCourse = tokens[i + 2];

			if (Validator.isNull(typeOfCourse)) {
				continue;
			}

			parseCourse(subject, hoursPerSemesterField, hoursPerWeekField, typeOfCourse, serviceContext);
		}
		System.out.println("i: " + i);
		if (i != tokens.length) {
			throw new RuntimeException("Failed to parse some Courses.");
		}
	}

	private Curriculum parseCurriculum(String curriculumCode, String curriculumName, ServiceContext serviceContext)
			throws PortalException, SystemException {
		Curriculum curriculum;

		if (CurriculumLocalServiceUtil.isCurriculumExistsWithCode(curriculumCode)) {
			curriculum = CurriculumLocalServiceUtil.getCurriculumByCode(curriculumCode);
			curriculum = CurriculumLocalServiceUtil.updateCurriculum(serviceContext.getUserId(),
					curriculum.getCurriculumId(), curriculumCode, curriculumName, serviceContext);
		} else {
			curriculum = CurriculumLocalServiceUtil.addCurriculum(curriculumCode, curriculumName, serviceContext);
		}

		return curriculum;
	}

	private Subject parseSubject(Curriculum curriculum, String subjectCode, String subjectName, int credit,
			ServiceContext serviceContext) throws PortalException, SystemException {
		Subject subject;

		if (SubjectLocalServiceUtil.isSubjectExistsWithCode(subjectCode)) {
			subject = SubjectLocalServiceUtil.getSubjectByCode(subjectCode);
			subject = SubjectLocalServiceUtil.updateSubject(serviceContext.getUserId(), subject.getSubjectId(),
					subjectCode, subjectName, credit, curriculum.getCurriculumId(), serviceContext);
		} else {
			subject = SubjectLocalServiceUtil.addSubject(subjectCode, subjectName, credit, curriculum.getCurriculumId(),
					serviceContext);
		}

		return subject;
	}

	private void parseCourse(Subject subject, String hoursPerSemesterField, String hoursPerWeekField,
			String typeOfCourse, ServiceContext serviceContext) throws PortalException, SystemException {
		int hoursPerSemester = Validator.isNull(hoursPerSemesterField) ? 0 : Integer.parseInt(hoursPerSemesterField);
		int hoursPerWeek = Validator.isNull(hoursPerWeekField) ? 0 : Integer.parseInt(hoursPerWeekField);

		CourseType courseType = parseCourseType(typeOfCourse, serviceContext);
		Course course = parseCourse(subject, courseType, hoursPerSemester, hoursPerWeek, serviceContext);

		System.out.println("Success: " + course);
	}

	private CourseType parseCourseType(String typeOfCourse, ServiceContext serviceContext)
			throws PortalException, SystemException {
		CourseType courseType;

		if (CourseTypeLocalServiceUtil.isCourseExistsWithType(typeOfCourse)) {
			courseType = CourseTypeLocalServiceUtil.getCourseTypeByType(typeOfCourse);
			courseType = CourseTypeLocalServiceUtil.updateCourseType(serviceContext.getUserId(),
					courseType.getCourseTypeId(), typeOfCourse, serviceContext);
		} else {
			courseType = CourseTypeLocalServiceUtil.addCourseType(typeOfCourse, serviceContext);
		}

		return courseType;
	}

	private Course parseCourse(Subject subject, CourseType courseType, int hoursPerSemester, int hoursPerWeek,
			ServiceContext serviceContext) throws PortalException, SystemException {
		Course course;

		if (CourseLocalServiceUtil.isCourseExistsWithS_CT(subject.getSubjectId(), courseType.getCourseTypeId())) {
			course = CourseLocalServiceUtil.getCourseByS_CT(subject.getSubjectId(), courseType.getCourseTypeId());
			course = CourseLocalServiceUtil.updateCourse(serviceContext.getUserId(), course.getCourseId(),
					subject.getSubjectId(), hoursPerSemester, hoursPerWeek, courseType.getCourseTypeId(),
					serviceContext);
		} else {
			course = CourseLocalServiceUtil.addCourse(subject.getSubjectId(), hoursPerSemester, hoursPerWeek,
					courseType.getCourseTypeId(), serviceContext);
		}

		return course;
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
