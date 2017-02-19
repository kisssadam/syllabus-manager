package hu.unideb.inf.web.portlet.action;

import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import hu.unideb.inf.model.TimetableCourse;
import hu.unideb.inf.service.TimetableCourseLocalService;
import hu.unideb.inf.web.constants.SyllabusManagerPortletKeys;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SyllabusManagerPortletKeys.SYLLABUS_MANAGER_ADMIN,
		"mvc.command.name=/syllabusmanager/admin/serve_timetable_courses"
	},
	service = MVCResourceCommand.class
)
public class TimetableCoursesMVCResourceCommand extends BaseMVCResourceCommand {

	private static final Log log = LogFactoryUtil.getLog(TimetableCoursesMVCResourceCommand.class);
	
	private TimetableCourseLocalService timetableCourseLocalService;
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		long courseId = ParamUtil.getLong(resourceRequest, "courseSelect");
		String courseSelected = ParamUtil.getString(resourceRequest, "courseSelected");

		if (log.isDebugEnabled()) {
			log.debug(String.format("courseId: %d, courseSelected: '%s'", courseId, courseSelected));
		}

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		if (courseSelected.equalsIgnoreCase("courseSelected")) {
			serveTimetableCourses(courseId, jsonArray);
		}

		try (PrintWriter writer = resourceResponse.getWriter()) {
			writer.write(jsonArray.toString());
			writer.flush();
		}
	}

	private void serveTimetableCourses(long courseId, JSONArray jsonArray) {
		log.trace("Course selected, serving timetableCourses.");
		try {
			List<TimetableCourse> timetableCourses = timetableCourseLocalService.getTimetableCoursesByCourseId(courseId);

			if (log.isTraceEnabled()) {
				log.trace("timetableCourses: " + timetableCourses);
			}

			for (TimetableCourse timetableCourse : timetableCourses) {
				TimetableCourse tc = timetableCourse.toEscapedModel();

				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

				jsonObject.put("timetableCourseId", tc.getTimetableCourseId());
				jsonObject.put("timetableCourseCode", tc.getTimetableCourseCode());
				jsonObject.put("subjectType", tc.getSubjectType());
				jsonObject.put("recommendedTerm", tc.getRecommendedTerm());
				jsonObject.put("limit", tc.getLimit());
				jsonObject.put("classScheduleInfo", tc.getClassScheduleInfo());
				jsonObject.put("description", tc.getDescription());

				jsonArray.put(jsonObject);
			}
		} catch (SystemException e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}
		}
	}
	
	@Reference(unbind = "-")
	protected void setTimetableCourseService(TimetableCourseLocalService timetableCourseLocalService) {
		this.timetableCourseLocalService = timetableCourseLocalService;
	}

}
