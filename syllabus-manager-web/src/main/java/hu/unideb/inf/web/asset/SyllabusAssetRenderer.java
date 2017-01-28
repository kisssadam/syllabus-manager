package hu.unideb.inf.web.asset;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import hu.unideb.inf.model.Course;
import hu.unideb.inf.model.Curriculum;
import hu.unideb.inf.model.Semester;
import hu.unideb.inf.model.Subject;
import hu.unideb.inf.model.Syllabus;
import hu.unideb.inf.model.TimetableCourse;
import hu.unideb.inf.service.CourseLocalServiceUtil;
import hu.unideb.inf.service.CurriculumLocalServiceUtil;
import hu.unideb.inf.service.SemesterLocalServiceUtil;
import hu.unideb.inf.service.SubjectLocalServiceUtil;
import hu.unideb.inf.service.TimetableCourseLocalServiceUtil;
import hu.unideb.inf.service.permission.SyllabusPermission;
import hu.unideb.inf.util.SyllabusActionKeys;
import hu.unideb.inf.web.constants.SyllabusManagerPortletKeys;
import hu.unideb.inf.web.constants.SyllabusWebKeys;
import hu.unideb.inf.web.portlet.SyllabusManagerAdminPortlet;

public class SyllabusAssetRenderer extends BaseJSPAssetRenderer<Syllabus> {

	private static final Log log = LogFactoryUtil.getLog(SyllabusAssetRenderer.class);

	private Syllabus syllabus;

	public SyllabusAssetRenderer(Syllabus syllabus) {
		this.syllabus = syllabus;
	}

	@Override
	public Syllabus getAssetObject() {
		return syllabus;
	}

	@Override
	public long getGroupId() {
		return syllabus.getGroupId();
	}

	@Override
	public long getUserId() {
		return syllabus.getUserId();
	}

	@Override
	public String getUserName() {
		return syllabus.getUserName();
	}

	@Override
	public String getUuid() {
		return syllabus.getUuid();
	}

	@Override
	public String getClassName() {
		return Syllabus.class.getName();
	}

	@Override
	public long getClassPK() {
		return syllabus.getSyllabusId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		StringBuilder summary = new StringBuilder();
		
		try {
			TimetableCourse timetableCourse = TimetableCourseLocalServiceUtil
					.getTimetableCourse(syllabus.getTimetableCourseId());
			Course course = CourseLocalServiceUtil.getCourse(timetableCourse.getCourseId());
			Subject subject = SubjectLocalServiceUtil.getSubject(course.getSubjectId());
			Curriculum curriculum = CurriculumLocalServiceUtil.getCurriculum(subject.getCurriculumId());
			Semester semester = SemesterLocalServiceUtil.getSemester(timetableCourse.getSemesterId());
			
			summary.append("Semester: ").append(semester);
			summary.append(StringPool.NEW_LINE);
			summary.append("Curriculum: ").append(curriculum);
			summary.append(StringPool.NEW_LINE);
			summary.append("Subject: ").append(subject);
			summary.append(StringPool.NEW_LINE);
			summary.append("Course: ").append(course);
			summary.append(StringPool.NEW_LINE);
			summary.append("TimetableCourse: ").append(timetableCourse);
			summary.append(StringPool.NEW_LINE);
			summary.append("Syllabus: ").append(syllabus);
		} catch (PortalException e) {
			log.error(e);
		}
		return summary.toString();
	}

	@Override
	public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) throws Exception {
		Group group = GroupLocalServiceUtil.fetchGroup(syllabus.getGroupId());

		PortletURL portletURL = PortalUtil.getControlPanelPortletURL(liferayPortletRequest, group,
				SyllabusManagerPortletKeys.SYLLABUS_MANAGER_ADMIN, 0, 0, PortletRequest.RENDER_PHASE);

		portletURL.setParameter("mvcPath", SyllabusManagerAdminPortlet.EDIT_SYLLABUS);
		portletURL.setParameter("syllabusId", String.valueOf(syllabus.getSyllabusId()));

		return portletURL;
	}
	
	@Override
	public String getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) throws Exception {
		log.trace("SyllabusAssetRenderer::getURLView(liferayPortletResponse, windowState)");
		
		AssetRendererFactory<Syllabus> assetRendererFactory = getAssetRendererFactory();
		
		PortletURL portletURL = assetRendererFactory.getURLView(liferayPortletResponse, windowState);
		
		portletURL.setParameter("mvcPath", "/asset/syllabus/syllabus_full_content.jsp");
		portletURL.setParameter("syllabusId", String.valueOf(syllabus.getSyllabusId()));
		portletURL.setWindowState(windowState);
		
		return portletURL.toString();
	}

	@Override
	public String getTitle(Locale locale) {
		return "Syllabus: " + syllabus.getSyllabusId();
	}

	/**
	 * https://github.com/liferay/liferay-portal/blob/master/readme/7.0/BREAKING_CHANGES.markdown
	 * The method include can now be used to create asset renderers or workflow handlers
	 * with UIs written in FreeMarker or any other framework.
	 */
	@Override
	public boolean include(HttpServletRequest request, HttpServletResponse response, String template) throws Exception {
		log.trace("SyllabusAssetRenderer::include(request, response, template)");
		request.setAttribute(SyllabusWebKeys.SYLLABUS, syllabus);
		return super.include(request, response, template);
	}

	@Override
	public int getStatus() {
		return syllabus.getStatus();
	}

	@Override
	public String getJspPath(HttpServletRequest request, String template) {
		log.trace("SyllabusAssetRenderer::getJspPath(request, template)");
		if (StringUtil.equalsIgnoreCase(template, TEMPLATE_FULL_CONTENT)) {
			return "/asset/syllabus/syllabus_full_content.jsp";
		} else {
			return "/asset/syllabus/syllabus_abstract.jsp";
		}
	}

	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) throws PortalException {
		return SyllabusPermission.contains(permissionChecker, syllabus.getSyllabusId(), SyllabusActionKeys.UPDATE);
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) throws PortalException {
		return SyllabusPermission.contains(permissionChecker, syllabus.getSyllabusId(), SyllabusActionKeys.VIEW);
	}

}
