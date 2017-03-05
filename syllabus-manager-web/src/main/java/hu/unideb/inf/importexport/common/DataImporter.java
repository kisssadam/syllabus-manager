package hu.unideb.inf.importexport.common;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

public interface DataImporter extends AutoCloseable {

	void importData() throws IOException, SystemException, PortalException, ParserConfigurationException, SAXException;

}
