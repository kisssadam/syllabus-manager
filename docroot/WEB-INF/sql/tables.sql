create table unideb_syllabus_manager_Curriculum (
	curriculumId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	curriculumCode VARCHAR(75) null,
	curriculumName VARCHAR(75) null
);