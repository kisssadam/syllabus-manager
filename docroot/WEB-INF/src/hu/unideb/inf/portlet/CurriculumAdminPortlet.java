package hu.unideb.inf.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import hu.unideb.inf.model.Curriculum;
import hu.unideb.inf.service.CurriculumLocalServiceUtil;

/**
 * Portlet implementation class CurriculumAdminPortlet
 */
public class CurriculumAdminPortlet extends MVCPortlet {

	private static final String EDIT_CURRICULUM = "/html/curriculumadmin/edit_curriculum.jsp";

	public void addCurriculum(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Curriculum.class.getName(), request);

		long curriculumId = ParamUtil.getLong(request, "curriculumId");
		String curriculumCode = ParamUtil.getString(request, "curriculumCode");
		String curriculumName = ParamUtil.getString(request, "curriculumName");

		if (curriculumId > 0) {
			updateCurriculum(curriculumId, curriculumCode, curriculumName, request, response, serviceContext);
		} else {
			addCurriculum(curriculumCode, curriculumName, request, response, serviceContext);
		}
	}

	private void updateCurriculum(long curriculumId, String curriculumCode, String curriculumName,
			ActionRequest request, ActionResponse response, ServiceContext serviceContext) {
		try {
			CurriculumLocalServiceUtil.updateCurriculum(serviceContext.getUserId(), curriculumId, curriculumCode,
					curriculumName, serviceContext);
			SessionMessages.add(request, "curriculumUpdated");
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", EDIT_CURRICULUM);
		}
	}

	private void addCurriculum(String curriculumCode, String curriculumName, ActionRequest request,
			ActionResponse response, ServiceContext serviceContext) {
		try {
			CurriculumLocalServiceUtil.addCurriculum(curriculumCode, curriculumName, serviceContext);
			SessionMessages.add(request, "curriculumAdded");
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", EDIT_CURRICULUM);
		}
	}

	public void deleteCurriculum(ActionRequest request, ActionResponse response) {
		long curriculumId = ParamUtil.getLong(request, "curriculumId");

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Curriculum.class.getName(), request);
			CurriculumLocalServiceUtil.deleteCurriculum(curriculumId, serviceContext);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
		}
	}

	public void deleteEveryCurriculum(ActionRequest request, ActionResponse response) {
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Curriculum.class.getName(), request);
			CurriculumLocalServiceUtil.deleteEveryCurriculum(serviceContext);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
		}
	}

}
