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
	typeName TEXT null
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
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	lecturerName TEXT null,
	lecturerUserId LONG
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
	timetableCourseCode TEXT null,
	subjectType TEXT null,
	recommendedTerm INTEGER,
	limit_ INTEGER,
	classScheduleInfo TEXT null,
	description TEXT null
);