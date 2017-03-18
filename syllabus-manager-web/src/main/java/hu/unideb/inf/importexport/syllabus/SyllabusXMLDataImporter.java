package hu.unideb.inf.importexport.syllabus;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;

import hu.unideb.inf.importexport.common.AbstractXMLDataImporter;
import hu.unideb.inf.model.Course;
import hu.unideb.inf.model.CourseType;
import hu.unideb.inf.model.Curriculum;
import hu.unideb.inf.model.Lecturer;
import hu.unideb.inf.model.Semester;
import hu.unideb.inf.model.Subject;
import hu.unideb.inf.model.TimetableCourse;

public class SyllabusXMLDataImporter extends AbstractXMLDataImporter {

	public SyllabusXMLDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
	}

	@Override
	protected void parseDocument(Document document) throws PortalException {
		NodeList curriculumNodes = document.getElementsByTagName("curriculum");
		for (int curriculumIndex = 0; curriculumIndex < curriculumNodes.getLength(); curriculumIndex++) {
			Node curriculumNode = curriculumNodes.item(curriculumIndex);

			if (curriculumNode.getNodeType() == Node.ELEMENT_NODE) {
				Element curriculumElement = (Element) curriculumNode;

				String curriculumCode = curriculumElement.getElementsByTagName("curriculumCode").item(0)
						.getTextContent();
				String curriculumName = curriculumElement.getElementsByTagName("curriculumName").item(0)
						.getTextContent();

				if (Validator.isNotNull(curriculumCode)) {
					Curriculum curriculum = parseCurriculum(curriculumCode, curriculumName);

					NodeList subjectNodes = curriculumElement.getElementsByTagName("subject");
					for (int subjectIndex = 0; subjectIndex < subjectNodes.getLength(); subjectIndex++) {
						Node subjectNode = subjectNodes.item(subjectIndex);

						if (subjectNode.getNodeType() == Node.ELEMENT_NODE) {
							Element subjectElement = (Element) subjectNode;

							String subjectCode = subjectElement.getElementsByTagName("subjectCode").item(0)
									.getTextContent();
							String subjectName = subjectElement.getElementsByTagName("subjectName").item(0)
									.getTextContent();
							String credit = subjectElement.getElementsByTagName("credit").item(0).getTextContent();

							if (Validator.isNotNull(subjectCode)) {
								Subject subject = parseSubject(curriculum, subjectCode, subjectName,
										Integer.parseInt(credit));

								NodeList courseNodes = subjectElement.getElementsByTagName("course");
								for (int courseIndex = 0; courseIndex < courseNodes.getLength(); courseIndex++) {
									Node courseNode = courseNodes.item(courseIndex);

									if (courseNode.getNodeType() == Node.ELEMENT_NODE) {
										Element courseElement = (Element) courseNode;

										String courseTypeName = courseElement.getAttribute("courseType");
										if (Validator.isNotNull(courseTypeName)) {
											CourseType courseType = parseCourseType(courseTypeName);

											String hoursPerSemester = courseElement
													.getElementsByTagName("hoursPerSemester").item(0).getTextContent();
											String hoursPerWeek = courseElement.getElementsByTagName("hoursPerWeek")
													.item(0).getTextContent();

											if (Validator.isNotNull(hoursPerSemester)
													&& Validator.isNotNull(hoursPerWeek)) {
												Course course = parseCourse(subject, courseType,
														Integer.parseInt(hoursPerSemester),
														Integer.parseInt(hoursPerWeek));

												NodeList timetableCourseNodes = courseElement
														.getElementsByTagName("timetableCourse");
												for (int timetableCourseIndex = 0; timetableCourseIndex < timetableCourseNodes
														.getLength(); timetableCourseIndex++) {
													Node timetableCourseNode = timetableCourseNodes
															.item(timetableCourseIndex);

													if (timetableCourseNode.getNodeType() == Node.ELEMENT_NODE) {
														Element timetableCourseElement = (Element) timetableCourseNode;

														String semesterString = timetableCourseElement
																.getAttribute("semester");
														if (Validator.isNotNull(semesterString)) {
															Semester semester = parseSemester(semesterString);

															List<Lecturer> lecturers = new ArrayList<>();

															NodeList lecturerNodes = timetableCourseElement
																	.getElementsByTagName("lecturer");
															for (int lecturerIndex = 0; lecturerIndex < lecturerNodes
																	.getLength(); lecturerIndex++) {
																Node lecturerNode = lecturerNodes.item(lecturerIndex);

																if (lecturerNode.getNodeType() == Node.ELEMENT_NODE) {
																	Element lecturerElement = (Element) lecturerNode;

																	String lecturerName = lecturerElement
																			.getElementsByTagName("lecturerName")
																			.item(0).getTextContent();
																	String lecturerLiferayUserId = lecturerElement
																			.getElementsByTagName(
																					"lecturerLiferayUserId")
																			.item(0).getTextContent();
																	if (Validator.isNotNull(lecturerName)) {
																		Lecturer lecturer = parseLecturer(lecturerName,
																				Long.parseLong(lecturerLiferayUserId));
																		lecturers.add(lecturer);
																	}
																}
															}

															if (!lecturers.isEmpty()) {
																String timetableCourseCode = timetableCourseElement
																		.getElementsByTagName("timetableCourseCode")
																		.item(0).getTextContent();
																String subjectType = timetableCourseElement
																		.getElementsByTagName("subjectType").item(0)
																		.getTextContent();
																String recommendedTerm = timetableCourseElement
																		.getElementsByTagName("recommendedTerm").item(0)
																		.getTextContent();
																String limit = timetableCourseElement
																		.getElementsByTagName("limit").item(0)
																		.getTextContent();
																String classScheduleInfo = timetableCourseElement
																		.getElementsByTagName("classScheduleInfo")
																		.item(0).getTextContent();
																String description = timetableCourseElement
																		.getElementsByTagName("description").item(0)
																		.getTextContent();

																if (Validator.isNotNull(timetableCourseCode)) {
																	TimetableCourse timetableCourse = parseTimetableCourse(
																			course, semester, timetableCourseCode,
																			subjectType,
																			Integer.parseInt(recommendedTerm),
																			Integer.parseInt(limit),
																			lecturers.stream()
																					.mapToLong(l -> l.getLecturerId())
																					.toArray(),
																			classScheduleInfo, description);

																	NodeList syllabusNodes = timetableCourseElement
																			.getElementsByTagName("syllabus");

																	for (int syllabusIndex = 0; syllabusIndex < syllabusNodes
																			.getLength(); syllabusIndex++) {
																		Node syllabusNode = syllabusNodes
																				.item(syllabusIndex);

																		if (syllabusNode
																				.getNodeType() == Node.ELEMENT_NODE) {
																			Element syllabusElement = (Element) syllabusNode;

																			String competence = syllabusElement
																					.getElementsByTagName("competence")
																					.item(0).getTextContent();
																			String ethicalStandards = syllabusElement
																					.getElementsByTagName(
																							"ethicalStandards")
																					.item(0).getTextContent();
																			String topics = syllabusElement
																					.getElementsByTagName("topics")
																					.item(0).getTextContent();
																			String educationalMaterials = syllabusElement
																					.getElementsByTagName(
																							"educationalMaterials")
																					.item(0).getTextContent();
																			String recommendedLiterature = syllabusElement
																					.getElementsByTagName(
																							"recommendedLiterature")
																					.item(0).getTextContent();
																			String weeklyTasks = syllabusElement
																					.getElementsByTagName("weeklyTasks")
																					.item(0).getTextContent();

																			if (Validator.isNotNull(competence)) {
																				parseSyllabus(timetableCourse,
																						competence, ethicalStandards,
																						topics, educationalMaterials,
																						recommendedLiterature,
																						weeklyTasks);
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
