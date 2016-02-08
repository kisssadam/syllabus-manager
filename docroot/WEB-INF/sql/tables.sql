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
	type_ TEXT null
);

create table unideb_syllabus_manager_Curriculum (
	curriculumId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	curriculumCode TEXT null,
	curriculumName TEXT null
);

create table unideb_syllabus_manager_Lecturer (
	lecturerId LONG not null primary key,
	lecturerName VARCHAR(75) null,
	userId LONG
);

create table unideb_syllabus_manager_Lecturers_TimetableCourses (
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
	subjectCode TEXT null,
	subjectName TEXT null,
	credit INTEGER,
	curriculumId LONG
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