package hu.unideb.inf.importexport.syllabus;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;
import com.opencsv.CSVReader;

import hu.unideb.inf.importexport.common.AbstractCSVDataImporter;
import hu.unideb.inf.model.Course;
import hu.unideb.inf.model.CourseType;
import hu.unideb.inf.model.Curriculum;
import hu.unideb.inf.model.Lecturer;
import hu.unideb.inf.model.Semester;
import hu.unideb.inf.model.Subject;
import hu.unideb.inf.model.TimetableCourse;
import hu.unideb.inf.web.constants.WebKeys;
import hu.unideb.inf.web.util.SyllabusCSVUtil;

public class SyllabusCSVDataImporter extends AbstractCSVDataImporter {

	public SyllabusCSVDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
	}

	@Override
	protected void parseLine(String[] line) throws PortalException, IOException {
		String curriculumCode = SyllabusCSVUtil.decode(line[0]);
		String curriculumName = SyllabusCSVUtil.decode(line[1]);

		if (Validator.isNotNull(curriculumCode)) {
			Curriculum curriculum = parseCurriculum(curriculumCode, curriculumName);

			String subjectCode = SyllabusCSVUtil.decode(line[2]);
			String subjectName = SyllabusCSVUtil.decode(line[3]);
			String credit = SyllabusCSVUtil.decode(line[4]);

			if (Validator.isNotNull(subjectCode)) {
				Subject subject = parseSubject(curriculum, subjectCode, subjectName, Integer.parseInt(credit));

				String courseTypeName = SyllabusCSVUtil.decode(line[5]);
				if (Validator.isNotNull(courseTypeName)) {
					CourseType courseType = parseCourseType(courseTypeName);

					String hoursPerSemester = SyllabusCSVUtil.decode(line[6]);
					String hoursPerWeek = SyllabusCSVUtil.decode(line[7]);

					if (Validator.isNotNull(hoursPerSemester) && Validator.isNotNull(hoursPerWeek)) {
						Course course = parseCourse(subject, courseType, Integer.parseInt(hoursPerSemester),
								Integer.parseInt(hoursPerWeek));

						String semesterString = SyllabusCSVUtil.decode(line[8]);
						if (Validator.isNotNull(semesterString)) {
							Semester semester = parseSemester(semesterString);

							String lecturers = line[9];
							if (Validator.isNotNull(lecturers)) {
								List<Lecturer> lecturerList = new ArrayList<>();

								try (CSVReader csvReader = new CSVReader(new StringReader(lecturers),
										WebKeys.CSV_INNER_SEPARATOR, WebKeys.CSV_QUOTE_CHARACTER)) {
									String[] lecturerLine = null;
									while ((lecturerLine = csvReader.readNext()) != null) {
										String lecturerName = SyllabusCSVUtil.decode(lecturerLine[0]);
										String lecturerLiferayUserId = SyllabusCSVUtil.decode(lecturerLine[1]);

										Lecturer lecturer = parseLecturer(lecturerName, lecturerLiferayUserId == null
												? 0L : Long.parseLong(lecturerLiferayUserId));
										lecturerList.add(lecturer);
									}
								}

								String timetableCourseCode = SyllabusCSVUtil.decode(line[10]);
								String subjectType = SyllabusCSVUtil.decode(line[11]);
								String recommendedTerm = SyllabusCSVUtil.decode(line[12]);
								String limit = SyllabusCSVUtil.decode(line[13]);
								String classScheduleInfo = SyllabusCSVUtil.decode(line[14]);
								String description = SyllabusCSVUtil.decode(line[15]);

								if (Validator.isNotNull(timetableCourseCode)) {
									long[] lecturerIds = lecturerList.stream()
											.mapToLong(lecturer -> lecturer.getLecturerId()).toArray();

									TimetableCourse timetableCourse = parseTimetableCourse(course, semester,
											timetableCourseCode, subjectType, Integer.parseInt(recommendedTerm),
											Integer.parseInt(limit), lecturerIds, classScheduleInfo, description);

									String competence = SyllabusCSVUtil.decode(line[16]);
									String ethicalStandards = SyllabusCSVUtil.decode(line[17]);
									String topics = SyllabusCSVUtil.decode(line[18]);
									String educationalMaterials = SyllabusCSVUtil.decode(line[19]);
									String recommendedLiterature = SyllabusCSVUtil.decode(line[20]);
									String weeklyTasks = SyllabusCSVUtil.decode(line[21]);

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
