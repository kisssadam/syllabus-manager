create index IX_2DC42CA3 on unideb_syllabus_manager_Course (courseTypeId);
create unique index IX_A1C296DC on unideb_syllabus_manager_Course (subjectId, courseTypeId);

create unique index IX_86F8E6B2 on unideb_syllabus_manager_CourseType (typeName[$COLUMN_LENGTH:75$]);

create unique index IX_678CBA5B on unideb_syllabus_manager_Curriculum (curriculumCode[$COLUMN_LENGTH:75$]);

create unique index IX_E196776B on unideb_syllabus_manager_Lecturer (lecturerName[$COLUMN_LENGTH:75$]);

create index IX_CB1EE8ED on unideb_syllabus_manager_Lecturers_TimetableCourses (companyId);
create index IX_A487357E on unideb_syllabus_manager_Lecturers_TimetableCourses (lecturerId);
create index IX_97DBE28C on unideb_syllabus_manager_Lecturers_TimetableCourses (timetableCourseId);

create unique index IX_B23FA52F on unideb_syllabus_manager_Semester (beginYear, endYear, division);

create unique index IX_24D8D7EB on unideb_syllabus_manager_Subject (curriculumId, subjectCode[$COLUMN_LENGTH:75$]);

create index IX_6F7D7770 on unideb_syllabus_manager_Syllabus (semesterId);
create unique index IX_AA78C685 on unideb_syllabus_manager_Syllabus (timetableCourseId, semesterId);

create unique index IX_9E42F172 on unideb_syllabus_manager_TimetableCourse (courseId, semesterId, timetableCourseCode[$COLUMN_LENGTH:75$], subjectType[$COLUMN_LENGTH:75$]);
create index IX_A3D7FD6B on unideb_syllabus_manager_TimetableCourse (semesterId);