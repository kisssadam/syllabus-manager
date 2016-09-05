package hu.unideb.inf.web.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import hu.unideb.inf.web.constants.SyllabusManagerPanelAppPanelCategoryKeys;
import hu.unideb.inf.web.constants.SyllabusManagerPanelAppPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + SyllabusManagerPanelAppPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class SyllabusManagerPanelAppPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return SyllabusManagerPanelAppPortletKeys.SyllabusManagerPanelApp;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + SyllabusManagerPanelAppPortletKeys.SyllabusManagerPanelApp + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}