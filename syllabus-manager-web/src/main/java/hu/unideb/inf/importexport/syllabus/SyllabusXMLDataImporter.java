package hu.unideb.inf.importexport.syllabus;

import java.io.FileNotFoundException;

import javax.portlet.ActionRequest;

import org.w3c.dom.Document;

import com.liferay.portal.kernel.exception.PortalException;

import hu.unideb.inf.importexport.common.AbstractXMLDataImporter;

public class SyllabusXMLDataImporter extends AbstractXMLDataImporter {

	public SyllabusXMLDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
	}

	@Override
	protected void parseDocument(Document document) throws PortalException {
		// TODO
	}

}
