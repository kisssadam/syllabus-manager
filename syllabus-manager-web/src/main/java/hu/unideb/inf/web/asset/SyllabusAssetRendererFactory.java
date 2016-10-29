package hu.unideb.inf.web.asset;

import org.osgi.service.component.annotations.Component;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import hu.unideb.inf.model.Syllabus;
import hu.unideb.inf.service.SyllabusLocalServiceUtil;
import hu.unideb.inf.service.permission.ModelPermission;
import hu.unideb.inf.service.permission.SyllabusPermission;
import hu.unideb.inf.util.SyllabusActionKeys;
import hu.unideb.inf.web.constants.SyllabusManagerPortletKeys;

@Component(
	immediate = true,
	property = {"javax.portlet.name=" + SyllabusManagerPortletKeys.SyllabusManagerAdmin},
	service = AssetRendererFactory.class
)
public class SyllabusAssetRendererFactory extends BaseAssetRendererFactory<Syllabus> {

	public static final String TYPE = "syllabus";

	@Override
	public AssetRenderer<Syllabus> getAssetRenderer(long classPK, int type) throws PortalException {
		Syllabus syllabus = SyllabusLocalServiceUtil.getSyllabus(classPK);

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
		return SyllabusManagerPortletKeys.SyllabusManagerAdmin;
	}

}
