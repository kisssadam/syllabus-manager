package hu.unideb.inf.importexport.semester;

import java.io.FileNotFoundException;

import javax.portlet.ActionRequest;

import hu.unideb.inf.importexport.common.AbstractXMLDataImporter;

public class SemesterXMLDataImporter extends AbstractXMLDataImporter {

	public SemesterXMLDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
	}

	@Override
	public void importData() {
		// TODO
	}

}
