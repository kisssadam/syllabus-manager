package hu.unideb.inf.importexport.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.opencsv.CSVReader;

import hu.unideb.inf.web.constants.WebKeys;

public abstract class AbstractCSVDataImporter extends AbstractDataImporter {

	private static final Log log = LogFactoryUtil.getLog(AbstractCSVDataImporter.class);

	private CSVReader csvReader;

	public AbstractCSVDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
		this.csvReader = new CSVReader(getBufferedReader(), WebKeys.CSV_SEPARATOR, WebKeys.CSV_QUOTE_CHARACTER);
	}

	@Override
	public void importData() throws IOException, SystemException, PortalException {
		String[] line = null;
		long lineIndex = 0L;

		while ((line = csvReader.readNext()) != null) {
			if (log.isTraceEnabled()) {
				log.trace(String.format("line[%d]: '%s'", lineIndex, Arrays.toString(line)));
			}
			if (lineIndex++ == 0) {
				parseHeader(line);
			} else {
				parseLine(line);
			}
		}
	}

	protected void parseHeader(String[] header) {
		// there is no need for the header
		return;
	}

	protected abstract void parseLine(String[] line) throws SystemException, PortalException, IOException;

	@Override
	public void close() throws IOException {
		super.close();
		if (csvReader != null) {
			csvReader.close();
		}
	}

}
