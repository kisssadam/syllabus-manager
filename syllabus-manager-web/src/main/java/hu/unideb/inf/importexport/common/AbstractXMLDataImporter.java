package hu.unideb.inf.importexport.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

public abstract class AbstractXMLDataImporter extends AbstractDataImporter {

	private static final Log log = LogFactoryUtil.getLog(AbstractXMLDataImporter.class);

	private static final DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();

	public AbstractXMLDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
	}

	@Override
	public void importData() throws IOException, ParserConfigurationException, SAXException, PortalException {
		String inputString = getInputString();
		
		if (log.isTraceEnabled()) {
			log.trace(String.format("Read file in string: '%s'", inputString));
		}
		
		DocumentBuilder db = DBF.newDocumentBuilder();
		Document document = db.parse(new InputSource(new StringReader(inputString)));
		parseDocument(document);
	}

	private String getInputString() throws IOException {
		return getBufferedReader().lines().collect(Collectors.joining(StringPool.NEW_LINE));
	}

	protected abstract void parseDocument(Document document) throws PortalException;

}
