package hu.unideb.inf.web.portlet.action;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;

import hu.unideb.inf.exception.ExportDataContentTypeException;
import hu.unideb.inf.web.constants.SyllabusManagerPortletKeys;
import hu.unideb.inf.web.constants.WebKeys;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SyllabusManagerPortletKeys.SYLLABUS_MANAGER_ADMIN,
		"mvc.command.name=" + WebKeys.MVC_RESOURCE_EXPORT_SYLLABUS_DATA
	},
	service = MVCResourceCommand.class
)
public class ExportDataMVCResourceCommand extends BaseMVCResourceCommand {

	private static final Log log = LogFactoryUtil.getLog(ExportDataMVCResourceCommand.class);
	
	private static final String FILENAME_PREFIX = "syllabus_manager_data_";
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			String contentType = ParamUtil.getString(resourceRequest, "contentType", StringPool.BLANK);
			
			if (log.isDebugEnabled()) {
				log.debug(String.format("doServeResource() contentType: '%s'", contentType));
			}
			
			String fileName = null;
			String content = null;
			
			switch (contentType) {
			case ContentTypes.TEXT_CSV_UTF8:
				content = getSyllabusManagerDataCSV();
				fileName = getFileName("csv");
				break;

			case ContentTypes.TEXT_XML_UTF8:
				content = getSyllabusManagerDataXML();
				fileName = getFileName("xml");
				break;

			default:
				throw new ExportDataContentTypeException(String.format("Unkown content type: '%s'", contentType));
			}
			
			if (log.isTraceEnabled()) {
				log.trace(String.format("doServeResource() filename: '%s', content: '%s'", fileName, content));
			}
			
			byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);
			PortletResponseUtil.sendFile(resourceRequest, resourceResponse, fileName, contentBytes, contentType);
		} catch (Exception e) {
			SessionErrors.add(resourceRequest, e.getClass());
			log.error(e);
		}
	}

	protected String getFileName(String extension) {
		return FILENAME_PREFIX + String.valueOf(new Date().getTime()) + "." + extension;
	}

	protected String getSyllabusManagerDataCSV() {
		// TODO https://github.com/liferay/liferay-portal/blob/586f66c629b559e79c744559751ecb960218fe0b/modules/apps/foundation/users-admin/users-admin-web/src/main/java/com/liferay/users/admin/web/portlet/action/ExportUsersMVCResourceCommand.java
		return "sample csv text";
	}

	protected String getSyllabusManagerDataXML() {
		// TODO java-s dom cucc jo lesz ide
		return "sample xml text";
	}
	
}
