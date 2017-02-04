package hu.unideb.inf.web.asset;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.trash.BaseTrashRenderer;

import hu.unideb.inf.model.Syllabus;
import hu.unideb.inf.web.constants.SyllabusManagerPortletKeys;

public class SyllabusTrashRenderer extends BaseTrashRenderer {

	private Syllabus syllabus;
	
	public SyllabusTrashRenderer(Syllabus syllabus) {
		this.syllabus = syllabus;
	}

	@Override
	public String getPortletId() {
		return SyllabusManagerPortletKeys.SYLLABUS_MANAGER_ADMIN;
	}

	@Override
	public String getType() {
		return SyllabusAssetRendererFactory.TYPE;
	}

	@Override
	public String getClassName() {
		return Syllabus.class.getName();
	}

	@Override
	public long getClassPK() {
		return syllabus.getPrimaryKey();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		return "Syllabus " + syllabus.getSyllabusId() + " summary"; 
	}

	@Override
	public String getTitle(Locale locale) {
		return "Syllabus: " + syllabus.getSyllabusId();
	}

	@Override
	public boolean include(HttpServletRequest request, HttpServletResponse response, String template) throws Exception {
		return false;
	}

}
