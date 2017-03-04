package hu.unideb.inf.importexport.syllabus;

import java.io.FileNotFoundException;

import javax.portlet.ActionRequest;

import hu.unideb.inf.importexport.common.AbstractXMLDataImporter;

public class SyllabusXMLDataImporter extends AbstractXMLDataImporter {

	public SyllabusXMLDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
	}

	@Override
	public void importData() {
		// TODO
	}

}
