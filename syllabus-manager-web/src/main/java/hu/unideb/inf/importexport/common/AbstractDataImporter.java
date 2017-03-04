package hu.unideb.inf.importexport.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;

import hu.unideb.inf.web.constants.WebKeys;

public abstract class AbstractDataImporter implements DataImporter {

	private ActionRequest actionRequest;

	private BufferedReader bufferedReader;

	public AbstractDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		this.actionRequest = actionRequest;

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		this.bufferedReader = new BufferedReader(new FileReader(uploadRequest.getFile(WebKeys.FILE_INPUT_NAME)));
	}

	public ActionRequest getActionRequest() {
		return actionRequest;
	}

	public BufferedReader getBufferedReader() {
		return bufferedReader;
	}

	public void close() throws IOException {
		if (bufferedReader != null) {
			bufferedReader.close();
		}
	}

}
