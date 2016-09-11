package hu.unideb.inf.web.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import hu.unideb.inf.web.constants.SyllabusManagerPanelCategoryKeys;
import hu.unideb.inf.web.constants.SyllabusManagerPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + SyllabusManagerPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class SyllabusManagerPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return SyllabusManagerPortletKeys.SyllabusManagerAdmin;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + SyllabusManagerPortletKeys.SyllabusManagerAdmin + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}