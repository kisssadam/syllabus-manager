package hu.unideb.inf.importexport.semester;

import java.io.FileNotFoundException;

import javax.portlet.ActionRequest;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.liferay.portal.kernel.exception.PortalException;

import hu.unideb.inf.importexport.common.AbstractXMLDataImporter;

public class SemesterXMLDataImporter extends AbstractXMLDataImporter {

	public SemesterXMLDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
	}

	@Override
	protected void parseDocument(Document document) throws PortalException {
		NodeList semesters = document.getElementsByTagName("semester");

		for (int i = 0; i < semesters.getLength(); i++) {
			Node semesterNode = semesters.item(i);
			String semester = semesterNode.getTextContent();

			parseSemester(semester);
		}
	}

}
