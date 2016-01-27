create index IX_ABDB3CF8 on unideb_syllabus_manager_Course (subjectId);
create unique index IX_A1C296DC on unideb_syllabus_manager_Course (subjectId, courseTypeId);

create unique index IX_533DE502 on unideb_syllabus_manager_CourseType (courseType);
create unique index IX_C792E85C on unideb_syllabus_manager_CourseType (type_);

create unique index IX_678CBA5B on unideb_syllabus_manager_Curriculum (curriculumCode);

create index IX_15B9ABFE on unideb_syllabus_manager_Subject (curriculumId);
create unique index IX_9FA317D5 on unideb_syllabus_manager_Subject (subjectCode);