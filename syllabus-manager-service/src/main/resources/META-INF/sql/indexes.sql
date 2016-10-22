create index IX_642B95D1 on syllabus_manager_Course (courseTypeId);
create unique index IX_73BB44EE on syllabus_manager_Course (subjectId, courseTypeId);

create unique index IX_BD604FE0 on syllabus_manager_CourseType (typeName[$COLUMN_LENGTH:10000$]);

create unique index IX_E4600909 on syllabus_manager_Curriculum (curriculumCode[$COLUMN_LENGTH:10000$]);

create unique index IX_1BC84D19 on syllabus_manager_Lecturer (lecturerName[$COLUMN_LENGTH:10000$]);

create index IX_778D417F on syllabus_manager_Lecturers_TimetableCourses (companyId);
create index IX_85E3EF2C on syllabus_manager_Lecturers_TimetableCourses (lecturerId);
create index IX_B79891E on syllabus_manager_Lecturers_TimetableCourses (timetableCourseId);

create unique index IX_939C5EDD on syllabus_manager_Semester (beginYear, endYear, division);

create unique index IX_BF019899 on syllabus_manager_Subject (curriculumId, subjectCode[$COLUMN_LENGTH:10000$]);

create index IX_8A395C70 on syllabus_manager_Syllabus (timetableCourseId);

create unique index IX_D8B8A584 on syllabus_manager_TimetableCourse (courseId, semesterId, timetableCourseCode[$COLUMN_LENGTH:10000$], subjectType[$COLUMN_LENGTH:10000$]);
create index IX_C16E847D on syllabus_manager_TimetableCourse (semesterId);