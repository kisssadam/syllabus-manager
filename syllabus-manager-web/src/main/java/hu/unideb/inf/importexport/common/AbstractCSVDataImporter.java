package hu.unideb.inf.importexport.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public abstract class AbstractCSVDataImporter extends AbstractDataImporter {

	private static final Log log = LogFactoryUtil.getLog(AbstractCSVDataImporter.class);

	public AbstractCSVDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
	}

	@Override
	public void importData() throws IOException {
		BufferedReader br = getBufferedReader();
		String line = null;
		long lineIndex = 0L;

		while ((line = br.readLine()) != null) {
			if (log.isTraceEnabled()) {
				log.trace(String.format("line[%d]: '%s'", lineIndex, line));
			}
			if (lineIndex++ == 0) {
				parseHeader(line);
			} else {
				parseLine(line);
			}
		}
	}

	protected void parseHeader(String header) {
		// there is no need for the header
		return;
	}

	protected abstract void parseLine(String line);

}
