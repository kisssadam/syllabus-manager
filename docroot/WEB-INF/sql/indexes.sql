create index IX_2DC42CA3 on unideb_syllabus_manager_Course (courseTypeId);
create index IX_ABDB3CF8 on unideb_syllabus_manager_Course (subjectId);
create unique index IX_A1C296DC on unideb_syllabus_manager_Course (subjectId, courseTypeId);

create unique index IX_533DE502 on unideb_syllabus_manager_CourseType (courseType);
create unique index IX_C792E85C on unideb_syllabus_manager_CourseType (type_);

create unique index IX_678CBA5B on unideb_syllabus_manager_Curriculum (curriculumCode);

create unique index IX_E196776B on unideb_syllabus_manager_Lecturer (lecturerName);

create index IX_A487357E on unideb_syllabus_manager_Lecturers_TimetableCourses (lecturerId);
create index IX_97DBE28C on unideb_syllabus_manager_Lecturers_TimetableCourses (timetableCourseId);

create unique index IX_B23FA52F on unideb_syllabus_manager_Semester (beginYear, endYear, division);

create index IX_15B9ABFE on unideb_syllabus_manager_Subject (curriculumId);
create unique index IX_9FA317D5 on unideb_syllabus_manager_Subject (subjectCode);

create index IX_1BAA0C4E on unideb_syllabus_manager_TimetableCourse (courseId);
create unique index IX_45351575 on unideb_syllabus_manager_TimetableCourse (courseId, semesterId);
create index IX_EF43606B on unideb_syllabus_manager_TimetableCourse (lecturers);
create unique index IX_82695DD5 on unideb_syllabus_manager_TimetableCourse (timetableCourseCode);