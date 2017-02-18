package hu.unideb.inf.web.asset;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.PortalUtil;

import hu.unideb.inf.model.Curriculum;
import hu.unideb.inf.model.Syllabus;
import hu.unideb.inf.service.SyllabusLocalService;
import hu.unideb.inf.service.permission.ModelPermission;
import hu.unideb.inf.service.permission.SyllabusPermission;
import hu.unideb.inf.util.SyllabusActionKeys;
import hu.unideb.inf.web.constants.SyllabusManagerPortletKeys;
import hu.unideb.inf.web.constants.WebKeys;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SyllabusManagerPortletKeys.SYLLABUS_MANAGER_ADMIN
	},
	service = AssetRendererFactory.class
)
public class SyllabusAssetRendererFactory extends BaseAssetRendererFactory<Syllabus> {

	private static final Log log = LogFactoryUtil.getLog(SyllabusAssetRendererFactory.class);
	
	public static final String TYPE = "syllabus";
	
	private SyllabusLocalService syllabusLocalService;

	@Reference(unbind = "-")
	public void setSyllabusLocalService(SyllabusLocalService syllabusLocalService) {
		this.syllabusLocalService = syllabusLocalService;
	}
	
	@Override
	public AssetRenderer<Syllabus> getAssetRenderer(long classPK, int type) throws PortalException {
		if (log.isTraceEnabled()) {
			log.trace(String.format("getAssetRenderer() classPK: %d, type: %d", classPK, type));
		}
		
		Syllabus syllabus = syllabusLocalService.getSyllabus(classPK);
		
		if (log.isTraceEnabled()) {
			log.trace(String.format("getAssetRenderer() syllabus: '%s'", syllabus));
		}
		
		return new SyllabusAssetRenderer(syllabus);
	}
	
	@Override
	public String getType() {
		return TYPE;
	}
	
	@Override
	public String getClassName() {
		return Syllabus.class.getName();
	}
	
	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, long classPK, String actionId) throws Exception {
		return SyllabusPermission.contains(permissionChecker, classPK, actionId);
	}
	
	@Override
	public boolean hasAddPermission(PermissionChecker permissionChecker, long groupId, long classTypeId)
			throws Exception {
		return ModelPermission.contains(permissionChecker, groupId, SyllabusActionKeys.ADD_SYLLABUS);
	}
	
	@Override
	public boolean isLinkable() {
		return true;
	}
	
	@Override
	public String getPortletId() {
		return SyllabusManagerPortletKeys.SYLLABUS_MANAGER_ADMIN;
	}

	@Override
	public PortletURL getURLAdd(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, long classTypeId) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Curriculum.class.getName(), liferayPortletRequest);
		long groupId = serviceContext.getScopeGroupId();
		Group group = GroupLocalServiceUtil.fetchGroup(groupId);

		PortletURL portletURL = PortalUtil.getControlPanelPortletURL(liferayPortletRequest, group,
				SyllabusManagerPortletKeys.SYLLABUS_MANAGER_ADMIN, 0, 0, PortletRequest.RENDER_PHASE);

		portletURL.setParameter("mvcPath", WebKeys.EDIT_SYLLABUS);

		return portletURL;
	}
	
}
