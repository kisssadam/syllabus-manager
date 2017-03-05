package hu.unideb.inf.importexport.coursetype;

import java.io.FileNotFoundException;

import javax.portlet.ActionRequest;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.liferay.portal.kernel.exception.PortalException;

import hu.unideb.inf.importexport.common.AbstractXMLDataImporter;

public class CourseTypeXMLDataImporter extends AbstractXMLDataImporter {

	public CourseTypeXMLDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
	}

	@Override
	protected void parseDocument(Document document) throws PortalException {
		NodeList courseTypeNodes = document.getElementsByTagName("courseType");

		for (int i = 0; i < courseTypeNodes.getLength(); i++) {
			Node courseTypeNode = courseTypeNodes.item(i);
			String courseTypeName = courseTypeNode.getTextContent();

			parseCourseType(courseTypeName);
		}
	}

}
