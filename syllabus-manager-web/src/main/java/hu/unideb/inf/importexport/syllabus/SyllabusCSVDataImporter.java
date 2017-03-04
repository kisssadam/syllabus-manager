package hu.unideb.inf.importexport.syllabus;

import java.io.FileNotFoundException;

import javax.portlet.ActionRequest;

import hu.unideb.inf.importexport.common.AbstractCSVDataImporter;

public class SyllabusCSVDataImporter extends AbstractCSVDataImporter {

	public SyllabusCSVDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
	}

	@Override
	protected void parseLine(String line) {
		// TODO
	}

}
