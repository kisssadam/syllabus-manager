package hu.unideb.inf.importexport.lecturer;

import java.io.FileNotFoundException;

import javax.portlet.ActionRequest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.liferay.portal.kernel.exception.PortalException;

import hu.unideb.inf.importexport.common.AbstractXMLDataImporter;

public class LecturerXMLDataImporter extends AbstractXMLDataImporter {

	public LecturerXMLDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
	}

	@Override
	protected void parseDocument(Document document) throws PortalException {
		NodeList lecturerNodes = document.getElementsByTagName("lecturer");

		for (int i = 0; i < lecturerNodes.getLength(); i++) {
			Node lecturerNode = lecturerNodes.item(i);

			if (lecturerNode.getNodeType() == Node.ELEMENT_NODE) {
				Element lecturerElement = (Element) lecturerNode;

				String lecturerName = lecturerElement.getElementsByTagName("lecturerName").item(0).getTextContent();
				long lecturerLiferayUserId = Long.parseLong(
						lecturerElement.getElementsByTagName("lecturerLiferayUserId").item(0).getTextContent());

				parseLecturer(lecturerName, lecturerLiferayUserId);
			}
		}
	}

}
