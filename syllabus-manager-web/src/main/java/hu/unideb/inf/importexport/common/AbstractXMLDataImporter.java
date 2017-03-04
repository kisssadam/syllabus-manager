package hu.unideb.inf.importexport.common;

import java.io.FileNotFoundException;

import javax.portlet.ActionRequest;

public abstract class AbstractXMLDataImporter extends AbstractDataImporter {

	public AbstractXMLDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
	}

	@Override
	public abstract void importData();

}
