package hu.unideb.inf.importexport.syllabus;

import java.io.FileNotFoundException;

import javax.portlet.ActionRequest;

import hu.unideb.inf.importexport.common.AbstractCSVDataImporter;

public class SyllabusCSVDataImporter extends AbstractCSVDataImporter {

	public SyllabusCSVDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
	}

	@Override
	public void parseHeader() {
		// there is no need for the header
		return;
	}

	@Override
	public void parseLine(String line) {
		
	}

}
