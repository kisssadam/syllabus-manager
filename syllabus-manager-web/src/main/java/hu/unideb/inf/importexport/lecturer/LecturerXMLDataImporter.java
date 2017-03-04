package hu.unideb.inf.importexport.lecturer;

import java.io.FileNotFoundException;

import javax.portlet.ActionRequest;

import hu.unideb.inf.importexport.common.AbstractXMLDataImporter;

public class LecturerXMLDataImporter extends AbstractXMLDataImporter {

	public LecturerXMLDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
	}

	@Override
	public void importData() {
		// TODO
	}

}
