package hu.unideb.inf.importexport.coursetype;

import java.io.FileNotFoundException;

import javax.portlet.ActionRequest;

import hu.unideb.inf.importexport.common.AbstractXMLDataImporter;

public class CourseTypeXMLDataImporter extends AbstractXMLDataImporter {

	public CourseTypeXMLDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
	}

	@Override
	public void importData() {
		// TODO
	}

}
