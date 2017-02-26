package hu.unideb.inf.web.constants;

public interface WebKeys extends com.liferay.portal.kernel.util.WebKeys {

	/*
	 * ADMIN_HOME_... for proper breadcrumb generation and for appropriate navigation with back buttons.
	 */

	String ADMIN_HOME_CURRICULUMS = "curriculums";

	String ADMIN_HOME_SEMESTERS = "semesters";

	String ADMIN_HOME_COURSE_TYPES = "course-types";

	String ADMIN_HOME_LECTURERS = "lecturers";

	String ADMIN_HOME_IMPORT_SYLLABUS = "import-syllabus";

	String ADMIN_HOME_IMPORT_TIMETABLE = "import-timetable";

	/*
	 * JSP paths
	 */

	String ADMIN_VIEW = "/admin/view.jsp";

	String VIEW_CURRICULUMS = "/admin/curriculums/view_curriculums.jsp";

	String VIEW_SUBJECTS = "/admin/subjects/view_subjects.jsp";

	String VIEW_COURSES = "/admin/courses/view_courses.jsp";

	String VIEW_COURSE_TYPES = "/admin/course_types/view_course_types.jsp";

	String VIEW_SEMESTERS = "/admin/semesters/view_semesters.jsp";

	String VIEW_LECTURERS = "/admin/lecturers/view_lecturers.jsp";

	String VIEW_TIMETABLE_COURSES = "/admin/timetablecourses/view_timetable_courses.jsp";

	String VIEW_SYLLABUSES = "/admin/syllabuses/view_syllabuses.jsp";

	String ADMIN_VIEW_CLEAR_DATABASE = "/admin/danger_zone/clear_database.jsp";

	String EDIT_CURRICULUM = "/admin/curriculums/edit_curriculum.jsp";

	String EDIT_SUBJECT = "/admin/subjects/edit_subject.jsp";

	String EDIT_COURSE = "/admin/courses/edit_course.jsp";

	String EDIT_COURSE_TYPE = "/admin/course_types/edit_course_type.jsp";

	String EDIT_SEMESTER = "/admin/semesters/edit_semester.jsp";

	String EDIT_LECTURER = "/admin/lecturers/edit_lecturer.jsp";

	String EDIT_TIMETABLE_COURSE = "/admin/timetablecourses/edit_timetable_course.jsp";

	String EDIT_SYLLABUS = "/admin/syllabuses/edit_syllabus.jsp";

	String ADMIN_IMPORT_SYLLABUS = "/admin/import_syllabus.jsp";

	String ADMIN_IMPORT_TIMETABLE = "/admin/import_timetable.jsp";

	String ADMIN_EXPORT_IMPORT_DATA = "/admin/danger_zone/export_import.jsp";

	/*
	 * MVC Action Commands
	 */

	String MVC_ACTION_IMPORT_SYLLABUS_DATA = "/syllabusmanager/admin/import_syllabus_data";

	String MVC_ACTION_CLEAR_DATABASE = "/syllabusmanager/admin/clear_database";

	/*
	 * MVC Resource Commands
	 */

	String MVC_RESOURCE_SERVE_TIMETABLE_COURSES = "/syllabusmanager/admin/serve_timetable_courses";

	String MVC_RESOURCE_SERVE_COURSES = "/syllabusmanager/admin/serve_courses";

	String MVC_RESOURCE_SERVE_SUBJECTS = "/syllabusmanager/admin/serve_subjects";

	String MVC_RESOURCE_EXPORT_DATA = "/syllabusmanager/export_data";

	/*
	 * Other things.
	 */

	String CURRICULUM = "CURRICULUM";

	String SYLLABUS = "SYLLABUS";

	String LECTURER = "LECTURER";

	String SEMESTER = "SEMESTER";

	String COURSE_TYPE = "COURSE_TYPE";

	String FILE_INPUT_NAME = "fileupload";

}
