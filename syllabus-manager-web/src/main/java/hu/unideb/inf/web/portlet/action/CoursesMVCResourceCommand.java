package hu.unideb.inf.web.portlet.action;

import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import hu.unideb.inf.model.Course;
import hu.unideb.inf.model.CourseType;
import hu.unideb.inf.service.CourseService;
import hu.unideb.inf.service.CourseTypeService;
import hu.unideb.inf.web.constants.SyllabusManagerPortletKeys;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SyllabusManagerPortletKeys.SYLLABUS_MANAGER_ADMIN,
		"mvc.command.name=/syllabusmanager/admin/serve_courses"
	},
	service = MVCResourceCommand.class
)
public class CoursesMVCResourceCommand extends BaseMVCResourceCommand {

	private static final Log log = LogFactoryUtil.getLog(CoursesMVCResourceCommand.class);

	private CourseService courseService;

	private CourseTypeService courseTypeService;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		long subjectId = ParamUtil.getLong(resourceRequest, "subjectSelect");
		String subjectSelected = ParamUtil.getString(resourceRequest, "subjectSelected");

		if (log.isDebugEnabled()) {
			log.debug(String.format("subjectId: %d, subjectSelected: '%s'", subjectId, subjectSelected));
		}

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		if (subjectSelected.equalsIgnoreCase("subjectSelected")) {
			serveCourses(subjectId, jsonArray);
		}

		try (PrintWriter writer = resourceResponse.getWriter()) {
			writer.write(jsonArray.toString());
			writer.flush();
		}
	}

	private void serveCourses(long subjectId, JSONArray jsonArray) {
		log.trace("Subject selected, serving courses.");
		try {
			List<Course> courses = courseService.getCoursesBySubjectId(subjectId);

			if (log.isTraceEnabled()) {
				log.trace("courses: " + courses);
			}

			for (Course course : courses) {
				Course c = course.toEscapedModel();
				CourseType ct = courseTypeService.getCourseType(c.getCourseTypeId()).toEscapedModel();

				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

				jsonObject.put("courseId", c.getCourseId());
				jsonObject.put("courseTypeName", ct.getTypeName());
				jsonObject.put("hoursPerSemester", c.getHoursPerSemester());
				jsonObject.put("hoursPerWeek", c.getHoursPerWeek());

				jsonArray.put(jsonObject);
			}
		} catch (PortalException | SystemException e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}
		}
	}

	@Reference(unbind = "-")
	protected void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	@Reference(unbind = "-")
	protected void setCourseTypeService(CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}

}
