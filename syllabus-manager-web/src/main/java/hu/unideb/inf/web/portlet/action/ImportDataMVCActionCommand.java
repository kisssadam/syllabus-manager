package hu.unideb.inf.web.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import hu.unideb.inf.importexport.common.DataImporter;
import hu.unideb.inf.importexport.common.DataImporterFactory;
import hu.unideb.inf.web.constants.SyllabusManagerPortletKeys;
import hu.unideb.inf.web.constants.WebKeys;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SyllabusManagerPortletKeys.SYLLABUS_MANAGER_ADMIN,
		"mvc.command.name=" + WebKeys.MVC_ACTION_IMPORT_DATA
	},
	service = MVCActionCommand.class
)
public class ImportDataMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(ImportDataMVCActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		log.trace("doProcessAction()");

		DataImporterFactory dataImportFactory = DataImporterFactory.getInstance();
		try (DataImporter dataImporter = dataImportFactory.newDataImporter(actionRequest)) {
			dataImporter.importData();
		}
	}

}
