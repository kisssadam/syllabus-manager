package hu.unideb.inf.web.portlet.action;

import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import hu.unideb.inf.model.Subject;
import hu.unideb.inf.service.SubjectLocalService;
import hu.unideb.inf.web.constants.SyllabusManagerPortletKeys;
import hu.unideb.inf.web.constants.WebKeys;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SyllabusManagerPortletKeys.SYLLABUS_MANAGER_ADMIN,
		"mvc.command.name=" + WebKeys.MVC_RESOURCE_SERVE_SUBJECTS
	},
	service = MVCResourceCommand.class
)
public class SubjectsMVCResourceCommand extends BaseMVCResourceCommand {

	private static final Log log = LogFactoryUtil.getLog(SubjectsMVCResourceCommand.class);

	private SubjectLocalService subjectLocalService;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		log.trace("Curriculum selected, serving subjects.");

		try (PrintWriter writer = resourceResponse.getWriter()) {
			long curriculumId = ParamUtil.getLong(resourceRequest, "curriculumSelect");

			if (log.isDebugEnabled()) {
				log.debug(String.format("curriculumId: %d", curriculumId));
			}

			JSONArray jsonArray = serveSubjects(curriculumId);

			if (log.isDebugEnabled()) {
				log.debug(String.format("subjects to serve: '%s'", jsonArray));
			}

			writer.write(jsonArray.toString());
			writer.flush();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error(e);
			}
		}
	}

	private JSONArray serveSubjects(long curriculumId) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		List<Subject> subjects = subjectLocalService.getSubjectsByCurriculumId(curriculumId);

		for (Subject subject : subjects) {
			Subject s = subject.toEscapedModel();

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			jsonObject.put("subjectId", s.getSubjectId());
			jsonObject.put("subjectCode", s.getSubjectCode());
			jsonObject.put("subjectName", s.getSubjectName());

			jsonArray.put(jsonObject);
		}

		return jsonArray;
	}

	@Reference(unbind = "-")
	protected void setSubjectService(SubjectLocalService subjectLocalService) {
		this.subjectLocalService = subjectLocalService;
	}

}
