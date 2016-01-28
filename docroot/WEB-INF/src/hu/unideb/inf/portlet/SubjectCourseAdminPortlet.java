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

		Curriculum curriculum;
		if (CurriculumLocalServiceUtil.isCurriculumExistsWithCode(curriculumCode)) {
			curriculum = CurriculumLocalServiceUtil.getCurriculumByCode(curriculumCode);
		} else {
			curriculum = CurriculumLocalServiceUtil.addCurriculum(curriculumCode, curriculumName, serviceContext);
		}

		Subject subject;
		if (SubjectLocalServiceUtil.isSubjectExistsWithCode(subjectCode)) {
			subject = SubjectLocalServiceUtil.getSubjectByCode(subjectCode);
		} else {
			subject = SubjectLocalServiceUtil.addSubject(subjectCode, subjectName, credit, curriculum.getCurriculumId(),
					serviceContext);
		}

		for (int i = 5; i <= tokens.length - 3; i += 3) {
			String hoursPerSemesterField = tokens[i];
			String hoursPerWeekField = tokens[i + 1];
			String typeOfCourse = tokens[i + 2];

			if (Validator.isNull(typeOfCourse)) {
				continue;
			}

			parseCourse(subject, hoursPerSemesterField, hoursPerWeekField, typeOfCourse, serviceContext);
		}
	}

	private void parseCourse(Subject subject, String hoursPerSemesterField, String hoursPerWeekField,
			String typeOfCourse, ServiceContext serviceContext) throws SystemException, PortalException {
		int hoursPerSemester = Validator.isNull(hoursPerSemesterField) ? 0 : Integer.parseInt(hoursPerSemesterField);
		int hoursPerWeek = Validator.isNull(hoursPerWeekField) ? 0 : Integer.parseInt(hoursPerWeekField);

		CourseType courseType;
		if (CourseTypeLocalServiceUtil.isCourseExistsWithType(typeOfCourse)) {
			courseType = CourseTypeLocalServiceUtil.getCourseTypeByType(typeOfCourse);
		} else {
			courseType = CourseTypeLocalServiceUtil.addCourseType(typeOfCourse, serviceContext);
		}

		Course course;
		if (CourseLocalServiceUtil.isCourseExistsWithS_CT(subject.getSubjectId(), courseType.getCourseTypeId())) {
			course = CourseLocalServiceUtil.getCourseByS_CT(subject.getSubjectId(), courseType.getCourseTypeId());
		} else {
			course = CourseLocalServiceUtil.addCourse(subject.getSubjectId(), hoursPerSemester, hoursPerWeek,
					courseType.getCourseTypeId(), serviceContext);
		}

		System.out.println("Success: " + course);
	}

}
