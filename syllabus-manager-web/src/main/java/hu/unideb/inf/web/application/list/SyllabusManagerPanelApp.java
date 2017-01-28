package hu.unideb.inf.web.application.list;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;

import hu.unideb.inf.web.constants.SyllabusManagerPortletKeys;

@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
	},
	service = PanelApp.class
)
public class SyllabusManagerPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return SyllabusManagerPortletKeys.SYLLABUS_MANAGER_ADMIN;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + SyllabusManagerPortletKeys.SYLLABUS_MANAGER_ADMIN + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}