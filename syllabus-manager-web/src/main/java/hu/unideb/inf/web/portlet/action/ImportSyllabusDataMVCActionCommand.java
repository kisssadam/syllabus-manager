package hu.unideb.inf.web.portlet.action;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;

import hu.unideb.inf.web.constants.SyllabusManagerPortletKeys;
import hu.unideb.inf.web.constants.WebKeys;
import hu.unideb.inf.web.util.SyllabusCSVParser;
import hu.unideb.inf.web.util.TimetableCSVParser;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SyllabusManagerPortletKeys.SYLLABUS_MANAGER_ADMIN,
		"mvc.command.name=" + WebKeys.MVC_ACTION_IMPORT_SYLLABUS_DATA
	},
	service = MVCActionCommand.class
)
public class ImportSyllabusDataMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(ImportSyllabusDataMVCActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		log.trace("upload()");
		
		String importType = ParamUtil.getString(actionRequest, "importType", StringPool.BLANK);

		if (log.isDebugEnabled()) {
			log.debug(String.format("importType: '%s'", importType));
		}

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		try (BufferedReader br = new BufferedReader(new FileReader(uploadRequest.getFile(WebKeys.FILE_INPUT_NAME)))) {
			// skips the first line, which is a header
			String line = br.readLine();

			while ((line = br.readLine()) != null) {
				try {
					if (log.isTraceEnabled()) {
						log.trace("Parsing: " + line);
					}

					switch (importType) {
					case "syllabus":
						SyllabusCSVParser.parseLine(line, actionRequest);
						break;

					case "timetable":
						TimetableCSVParser.parseLine(line, actionRequest);
						break;

					default:
						throw new RuntimeException("Unknown importType: " + importType);
					}
				} catch (Exception e) {
					if (log.isErrorEnabled()) {
						log.error(e);
					}
				}
			}
		}
	}

}
