package hu.unideb.inf.importexport.lecturer;

import java.io.FileNotFoundException;

import javax.portlet.ActionRequest;

import hu.unideb.inf.importexport.common.AbstractCSVDataImporter;

public class LecturerCSVDataImporter extends AbstractCSVDataImporter {

	public LecturerCSVDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
	}

	@Override
	protected void parseLine(String line) {
		// TODO
	}

}
