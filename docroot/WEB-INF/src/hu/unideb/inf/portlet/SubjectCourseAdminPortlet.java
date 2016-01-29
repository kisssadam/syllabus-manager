package hu.unideb.inf.portlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import hu.unideb.inf.model.Course;
import hu.unideb.inf.model.CourseType;
import hu.unideb.inf.model.Curriculum;
import hu.unideb.inf.model.Subject;
import hu.unideb.inf.service.CourseLocalServiceUtil;
import hu.unideb.inf.service.CourseTypeLocalServiceUtil;
import hu.unideb.inf.service.CurriculumLocalServiceUtil;
import hu.unideb.inf.service.SubjectLocalServiceUtil;

/**
 * Portlet implementation class SubjectCourseAdminPortlet
 */
public class SubjectCourseAdminPortlet extends MVCPortlet {

	private final static String fileInputName = "fileupload";

	public void upload(ActionRequest request, ActionResponse response) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(SubjectCourseAdminPortlet.class.getName(),
				request);

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);

		File uploadedFile = uploadRequest.getFile(fileInputName);

		try (BufferedReader br = new BufferedReader(new FileReader(uploadedFile))) {
			String line = br.readLine(); // skips the first line, which is a header

			while ((line = br.readLine()) != null) {
				try {
					System.out.println("Parsing: " + line);
					parseLine(line, serviceContext);
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		}
	}

	private void parseLine(String line, ServiceContext serviceContext) throws PortalException, SystemException {
		String[] tokens = line.split(";");

		String subjectName = tokens[0];
		String subjectCode = tokens[1];
		int credit = Integer.parseInt(tokens[2]);
		String curriculumName = tokens[3];
		String curriculumCode = tokens[4];

		Curriculum curriculum = parseCurriculum(curriculumCode, curriculumName, serviceContext);
		Subject subject = parseSubject(curriculum, subjectCode, subjectName, credit, serviceContext);

		int i;
		for (i = 5; i <= tokens.length - 3; i += 3) {
			String hoursPerSemesterField = tokens[i];
			String hoursPerWeekField = tokens[i + 1];
			String typeOfCourse = tokens[i + 2];

			if (Validator.isNull(typeOfCourse)) {
				continue;
			}

			parseCourse(subject, hoursPerSemesterField, hoursPerWeekField, typeOfCourse, serviceContext);
		}
		System.out.println("i: " + i);
		if (i != tokens.length) {
			throw new RuntimeException("Failed to parse some Courses.");
		}
	}

	private Curriculum parseCurriculum(String curriculumCode, String curriculumName, ServiceContext serviceContext)
			throws PortalException, SystemException {
		Curriculum curriculum;

		if (CurriculumLocalServiceUtil.isCurriculumExistsWithCode(curriculumCode)) {
			curriculum = CurriculumLocalServiceUtil.getCurriculumByCode(curriculumCode);
			curriculum = CurriculumLocalServiceUtil.updateCurriculum(serviceContext.getUserId(),
					curriculum.getCurriculumId(), curriculumCode, curriculumName, serviceContext);
		} else {
			curriculum = CurriculumLocalServiceUtil.addCurriculum(curriculumCode, curriculumName, serviceContext);
		}

		return curriculum;
	}

	private Subject parseSubject(Curriculum curriculum, String subjectCode, String subjectName, int credit,
			ServiceContext serviceContext) throws PortalException, SystemException {
		Subject subject;

		if (SubjectLocalServiceUtil.isSubjectExistsWithCode(subjectCode)) {
			subject = SubjectLocalServiceUtil.getSubjectByCode(subjectCode);
			subject = SubjectLocalServiceUtil.updateSubject(serviceContext.getUserId(), subject.getSubjectId(),
					subjectCode, subjectName, credit, curriculum.getCurriculumId(), serviceContext);
		} else {
			subject = SubjectLocalServiceUtil.addSubject(subjectCode, subjectName, credit, curriculum.getCurriculumId(),
					serviceContext);
		}

		return subject;
	}

	private void parseCourse(Subject subject, String hoursPerSemesterField, String hoursPerWeekField,
			String typeOfCourse, ServiceContext serviceContext) throws PortalException, SystemException {
		int hoursPerSemester = Validator.isNull(hoursPerSemesterField) ? 0 : Integer.parseInt(hoursPerSemesterField);
		int hoursPerWeek = Validator.isNull(hoursPerWeekField) ? 0 : Integer.parseInt(hoursPerWeekField);

		CourseType courseType = parseCourseType(typeOfCourse, serviceContext);
		Course course = parseCourse(subject, courseType, hoursPerSemester, hoursPerWeek, serviceContext);

		System.out.println("Success: " + course);
	}

	private CourseType parseCourseType(String typeOfCourse, ServiceContext serviceContext)
			throws PortalException, SystemException {
		CourseType courseType;

		if (CourseTypeLocalServiceUtil.isCourseExistsWithType(typeOfCourse)) {
			courseType = CourseTypeLocalServiceUtil.getCourseTypeByType(typeOfCourse);
			courseType = CourseTypeLocalServiceUtil.updateCourseType(serviceContext.getUserId(),
					courseType.getCourseTypeId(), typeOfCourse, serviceContext);
		} else {
			courseType = CourseTypeLocalServiceUtil.addCourseType(typeOfCourse, serviceContext);
		}

		return courseType;
	}

	private Course parseCourse(Subject subject, CourseType courseType, int hoursPerSemester, int hoursPerWeek,
			ServiceContext serviceContext) throws PortalException, SystemException {
		Course course;

		if (CourseLocalServiceUtil.isCourseExistsWithS_CT(subject.getSubjectId(), courseType.getCourseTypeId())) {
			course = CourseLocalServiceUtil.getCourseByS_CT(subject.getSubjectId(), courseType.getCourseTypeId());
			course = CourseLocalServiceUtil.updateCourse(serviceContext.getUserId(), course.getCourseId(),
					subject.getSubjectId(), hoursPerSemester, hoursPerWeek, courseType.getCourseTypeId(),
					serviceContext);
		} else {
			course = CourseLocalServiceUtil.addCourse(subject.getSubjectId(), hoursPerSemester, hoursPerWeek,
					courseType.getCourseTypeId(), serviceContext);
		}

		return course;
	}

}
