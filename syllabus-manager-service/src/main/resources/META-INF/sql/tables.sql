create table unideb_syllabus_manager_Course (
	courseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	subjectId LONG,
	hoursPerSemester INTEGER,
	hoursPerWeek INTEGER,
	courseTypeId LONG
);

create table unideb_syllabus_manager_CourseType (
	courseTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	typeName VARCHAR(75) null
);

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

create table unideb_syllabus_manager_Lecturer (
	lecturerId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	lecturerName VARCHAR(75) null,
	lecturerUserId LONG
);

create table unideb_syllabus_manager_Lecturers_TimetableCourses (
	companyId LONG not null,
	lecturerId LONG not null,
	timetableCourseId LONG not null,
	primary key (lecturerId, timetableCourseId)
);

create table unideb_syllabus_manager_Semester (
	semesterId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	beginYear INTEGER,
	endYear INTEGER,
	division INTEGER
);

create table unideb_syllabus_manager_Subject (
	subjectId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	subjectCode VARCHAR(75) null,
	subjectName VARCHAR(75) null,
	credit INTEGER,
	curriculumId LONG
);

create table unideb_syllabus_manager_Syllabus (
	syllabusId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	timetableCourseId LONG,
	competence VARCHAR(75) null,
	ethicalStandards VARCHAR(75) null,
	topics VARCHAR(75) null,
	educationalMaterials VARCHAR(75) null,
	recommendedLiterature VARCHAR(75) null,
	weeklyTasks VARCHAR(75) null
);

create table unideb_syllabus_manager_TimetableCourse (
	timetableCourseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	courseId LONG,
	semesterId LONG,
	timetableCourseCode VARCHAR(75) null,
	subjectType VARCHAR(75) null,
	recommendedTerm INTEGER,
	limit_ INTEGER,
	classScheduleInfo VARCHAR(75) null,
	description VARCHAR(75) null
);