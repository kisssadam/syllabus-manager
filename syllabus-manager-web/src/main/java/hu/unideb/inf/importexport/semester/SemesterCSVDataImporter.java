package hu.unideb.inf.importexport.semester;

import java.io.FileNotFoundException;

import javax.portlet.ActionRequest;

import hu.unideb.inf.importexport.common.AbstractCSVDataImporter;

public class SemesterCSVDataImporter extends AbstractCSVDataImporter {

	public SemesterCSVDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
	}

	@Override
	public void parseHeader() {
		// there is no need for the header
		return;
	}

	@Override
	public void parseLine(String line) {
		// TODO
	}

}
