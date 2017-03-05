package hu.unideb.inf.importexport.syllabus;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;

import hu.unideb.inf.importexport.common.AbstractCSVDataImporter;
import hu.unideb.inf.model.Course;
import hu.unideb.inf.model.CourseType;
import hu.unideb.inf.model.Curriculum;
import hu.unideb.inf.model.Lecturer;
import hu.unideb.inf.model.Semester;
import hu.unideb.inf.model.Subject;
import hu.unideb.inf.model.TimetableCourse;

public class SyllabusCSVDataImporter extends AbstractCSVDataImporter {

	public SyllabusCSVDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
	}

	@Override
	protected void parseLine(String line) throws PortalException {
		Pattern pattern = Pattern.compile("(?<curriculumCode>.*);" + "(?<curriculumName>.*);" + "(?<subjectCode>.*);"
				+ "(?<subjectName>.*);" + "(?<credit>.*);" + "(?<courseTypeName>.*);" + "(?<hoursPerSemester>.*);"
				+ "(?<hoursPerWeek>.*);" + "(?<semester>.*);" + "(?<lecturers>.*);" + "(?<timetableCourseCode>.*);"
				+ "(?<subjectType>.*);" + "(?<recommendedTerm>.*);" + "(?<limit>.*);" + "(?<classScheduleInfo>.*);"
				+ "(?<description>.*);" + "(?<competence>.*);" + "(?<ethicalStandards>.*);" + "(?<topics>.*);"
				+ "(?<educationalMaterials>.*);" + "(?<recommendedLiterature>.*);" + "(?<weeklyTasks>.*)");

		Matcher matcher = pattern.matcher(line);
		if (matcher.matches()) {
			String curriculumCode = matcher.group("curriculumCode");
			String curriculumName = matcher.group("curriculumName");
			Curriculum curriculum = parseCurriculum(curriculumCode, curriculumName);

			String subjectCode = matcher.group("subjectCode");
			String subjectName = matcher.group("subjectName");
			String credit = matcher.group("credit");

			if (Validator.isNotNull(subjectCode)) {
				Subject subject = parseSubject(curriculum, subjectCode, subjectName, Integer.parseInt(credit));

				String courseTypeName = matcher.group("courseTypeName");
				if (Validator.isNotNull(courseTypeName)) {
					CourseType courseType = parseCourseType(courseTypeName);

					String hoursPerSemester = matcher.group("hoursPerSemester");
					String hoursPerWeek = matcher.group("hoursPerWeek");

					if (Validator.isNotNull(hoursPerSemester) && Validator.isNotNull(hoursPerWeek)) {
						Course course = parseCourse(subject, courseType, Integer.parseInt(hoursPerSemester),
								Integer.parseInt(hoursPerWeek));

						String semesterString = matcher.group("semester");
						if (Validator.isNotNull(semesterString)) {
							Semester semester = parseSemester(semesterString);

							String lecturers = matcher.group("lecturers");
							if (Validator.isNotNull(lecturers)) {
								String[] lecturerNames = lecturers.split(",");

								List<Lecturer> lecturerList = new ArrayList<>();
								for (String lecturerName : lecturerNames) {
									Lecturer lecturer = parseLecturer(lecturerName, 0L);
									lecturerList.add(lecturer);
								}

								String timetableCourseCode = matcher.group("timetableCourseCode");
								String subjectType = matcher.group("subjectType");
								String recommendedTerm = matcher.group("recommendedTerm");
								String limit = matcher.group("limit");
								String classScheduleInfo = matcher.group("classScheduleInfo");
								String description = matcher.group("description");

								if (Validator.isNotNull(timetableCourseCode)) {
									long[] lecturerIds = lecturerList.stream()
											.mapToLong(lecturer -> lecturer.getLecturerId()).toArray();

									TimetableCourse timetableCourse = parseTimetableCourse(course, semester,
											timetableCourseCode, subjectType, Integer.parseInt(recommendedTerm),
											Integer.parseInt(limit), lecturerIds, classScheduleInfo, description);

									String competence = matcher.group("competence");
									String ethicalStandards = matcher.group("ethicalStandards");
									String topics = matcher.group("topics");
									String educationalMaterials = matcher.group("educationalMaterials");
									String recommendedLiterature = matcher.group("recommendedLiterature");
									String weeklyTasks = matcher.group("weeklyTasks");

									if (Validator.isNotNull(competence)) {
										parseSyllabus(timetableCourse, competence, ethicalStandards, topics,
												educationalMaterials, recommendedLiterature, weeklyTasks);
									}
								}
							}
						}
					}
				}
			}
		}
	}

}
