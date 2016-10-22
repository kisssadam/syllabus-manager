package hu.unideb.inf.workflow;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;

import hu.unideb.inf.model.Syllabus;
import hu.unideb.inf.service.SyllabusLocalServiceUtil;

@Component(
	property = { "model.class.name=hu.unideb.inf.model.Syllabus" },
	service = WorkflowHandler.class
)
public class SyllabusWorkflowHandler extends BaseWorkflowHandler<Syllabus> {

	@Override
	public String getClassName() {
		return Syllabus.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		return ResourceActionsUtil.getModelResource(locale, getClassName());
	}

	@Override
	public Syllabus updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
		long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		long classPK = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		ServiceContext serviceContext = (ServiceContext) workflowContext.get("serviceContext");

		return SyllabusLocalServiceUtil.updateStatus(userId, classPK, status, serviceContext, workflowContext);
	}

}
