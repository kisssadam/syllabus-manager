package hu.unideb.inf.web.portlet.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import hu.unideb.inf.model.Course;
import hu.unideb.inf.model.CourseType;
import hu.unideb.inf.model.Curriculum;
import hu.unideb.inf.model.Lecturer;
import hu.unideb.inf.model.Semester;
import hu.unideb.inf.model.Subject;
import hu.unideb.inf.model.Syllabus;
import hu.unideb.inf.model.TimetableCourse;
import hu.unideb.inf.service.CourseLocalService;
import hu.unideb.inf.service.CourseTypeLocalService;
import hu.unideb.inf.service.CurriculumLocalService;
import hu.unideb.inf.service.LecturerLocalService;
import hu.unideb.inf.service.SemesterLocalService;
import hu.unideb.inf.service.SubjectLocalService;
import hu.unideb.inf.service.SyllabusLocalService;
import hu.unideb.inf.service.TimetableCourseLocalService;
import hu.unideb.inf.web.constants.SyllabusManagerPortletKeys;
import hu.unideb.inf.web.constants.WebKeys;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SyllabusManagerPortletKeys.SYLLABUS_MANAGER_ADMIN,
		"mvc.command.name=" + WebKeys.MVC_ACTION_CLEAR_DATABASE
	},
	service = MVCActionCommand.class
)
public class ClearDatabaseMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(ClearDatabaseMVCActionCommand.class);

	private CurriculumLocalService curriculumLocalService;

	private SubjectLocalService subjectLocalService;

	private CourseLocalService courseLocalService;

	private TimetableCourseLocalService timetableCourseLocalService;

	private SyllabusLocalService syllabusLocalService;

	private CourseTypeLocalService courseTypeLocalService;

	private SemesterLocalService semesterLocalService;

	private LecturerLocalService lecturerLocalService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {
		log.trace("clearDatabase()");
		
		try {
			boolean deleteSyllabuses = ParamUtil.getBoolean(actionRequest, "deleteSyllabuses");
			boolean deleteTimetableCourses = ParamUtil.getBoolean(actionRequest, "deleteTimetableCourses");
			boolean deleteCourses = ParamUtil.getBoolean(actionRequest, "deleteCourses");
			boolean deleteCourseTypes = ParamUtil.getBoolean(actionRequest, "deleteCourseTypes");
			boolean deleteSubjects = ParamUtil.getBoolean(actionRequest, "deleteSubjects");
			boolean deleteCurriculums = ParamUtil.getBoolean(actionRequest, "deleteCurriculums");
			boolean deleteLecturers = ParamUtil.getBoolean(actionRequest, "deleteLecturers");
			boolean deleteSemesters = ParamUtil.getBoolean(actionRequest, "deleteSemesters");
	
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
				deleteSyllabuses(actionRequest);
			}
			if (deleteTimetableCourses) {
				deleteTimetableCourses(actionRequest);
			}
			if (deleteCourses) {
				deleteCourses(actionRequest);
			}
			if (deleteCourseTypes) {
				deleteCourseTypes(actionRequest);
			}
			if (deleteSubjects) {
				deleteSubjects(actionRequest);
			}
			if (deleteCurriculums) {
				deleteCurriculums(actionRequest);
			}
			if (deleteLecturers) {
				deleteLecturers(actionRequest);
			}
			if (deleteSemesters) {
				deleteSemesters(actionRequest);
			}
		} catch (Exception e) {
			log.error(e);
			SessionErrors.add(actionRequest, e.getClass().getName());
			actionResponse.setRenderParameter("mvcPath", WebKeys.ADMIN_VIEW_CLEAR_DATABASE);
		}
	}

	private void deleteSemesters(ActionRequest request) throws PortalException {
		log.trace("Deleting every semester.");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Semester.class.getName(), request);

		List<Semester> semesters = semesterLocalService.getSemesters();
		for (Semester semester : semesters) {
			semesterLocalService.deleteSemester(semester.getSemesterId(), serviceContext);
		}
		SessionMessages.add(request, "semestersDeleted");
	}

	private void deleteLecturers(ActionRequest request) throws PortalException {
		log.trace("Deleting every lecturer.");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Lecturer.class.getName(), request);

		List<Lecturer> lecturers = lecturerLocalService.getLecturers();
		for (Lecturer lecturer : lecturers) {
			lecturerLocalService.deleteLecturer(lecturer.getLecturerId(), serviceContext);
		}
		SessionMessages.add(request, "lecturersDeleted");
	}

	private void deleteCurriculums(ActionRequest request) throws PortalException {
		log.trace("Deleting every curriculum.");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Curriculum.class.getName(), request);

		List<Curriculum> curriculums = curriculumLocalService.getCurriculums();
		for (Curriculum curriculum : curriculums) {
			curriculumLocalService.deleteCurriculum(curriculum.getCurriculumId(), serviceContext);
		}
		SessionMessages.add(request, "curriculumsDeleted");
	}

	private void deleteSubjects(ActionRequest request) throws PortalException {
		log.trace("Deleting every subject.");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Subject.class.getName(), request);

		List<Subject> subjects = subjectLocalService.getSubjects();
		for (Subject subject : subjects) {
			subjectLocalService.deleteSubject(subject.getSubjectId(), serviceContext);
		}
		SessionMessages.add(request, "subjectsDeleted");
	}

	private void deleteCourseTypes(ActionRequest request) throws PortalException {
		log.trace("Deleting every course type.");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(CourseType.class.getName(), request);

		List<CourseType> courseTypes = courseTypeLocalService.getCourseTypes();
		for (CourseType courseType : courseTypes) {
			courseTypeLocalService.deleteCourseType(courseType.getCourseTypeId(), serviceContext);
		}
		SessionMessages.add(request, "courseTypesDeleted");
	}

	private void deleteCourses(ActionRequest request) throws PortalException {
		log.trace("Deleting every course.");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Course.class.getName(), request);

		List<Course> courses = courseLocalService.getCourses();
		for (Course course : courses) {
			courseLocalService.deleteCourse(course.getCourseId(), serviceContext);
		}
		SessionMessages.add(request, "coursesDeleted");
	}

	private void deleteTimetableCourses(ActionRequest request) throws PortalException {
		log.trace("Deleting every timetable course.");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(TimetableCourse.class.getName(), request);

		List<TimetableCourse> timetableCourses = timetableCourseLocalService.getTimetableCourses();
		for (TimetableCourse timetableCourse : timetableCourses) {
			timetableCourseLocalService.deleteTimetableCourse(timetableCourse.getTimetableCourseId(),
					serviceContext);
		}
		SessionMessages.add(request, "timetableCoursesDeleted");
	}

	private void deleteSyllabuses(ActionRequest request) throws PortalException {
		log.trace("Deleting every syllabus.");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Syllabus.class.getName(), request);

		List<Syllabus> syllabuses = syllabusLocalService.getSyllabuses();
		for (Syllabus syllabus : syllabuses) {
			syllabusLocalService.deleteSyllabus(syllabus.getSyllabusId(), serviceContext);
		}
		SessionMessages.add(request, "syllabusesDeleted");
	}

	@Reference(unbind = "-")
	protected void setCurriculumService(CurriculumLocalService curriculumLocalService) {
		this.curriculumLocalService = curriculumLocalService;
	}

	@Reference(unbind = "-")
	protected void setSubjectService(SubjectLocalService subjectLocalService) {
		this.subjectLocalService = subjectLocalService;
	}

	@Reference(unbind = "-")
	protected void setCourseService(CourseLocalService courseLocalService) {
		this.courseLocalService = courseLocalService;
	}

	@Reference(unbind = "-")
	protected void setTimetableCourseService(TimetableCourseLocalService timetableCourseLocalService) {
		this.timetableCourseLocalService = timetableCourseLocalService;
	}

	@Reference(unbind = "-")
	protected void setSyllabusService(SyllabusLocalService syllabusLocalService) {
		this.syllabusLocalService = syllabusLocalService;
	}

	@Reference(unbind = "-")
	protected void setCourseTypeService(CourseTypeLocalService courseTypeLocalService) {
		this.courseTypeLocalService = courseTypeLocalService;
	}

	@Reference(unbind = "-")
	protected void setSemesterService(SemesterLocalService semesterLocalService) {
		this.semesterLocalService = semesterLocalService;
	}

	@Reference(unbind = "-")
	protected void setLecturerService(LecturerLocalService lecturerLocalService) {
		this.lecturerLocalService = lecturerLocalService;
	}

}
