package hu.unideb.inf.importexport.lecturer;

import java.io.FileNotFoundException;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.exception.PortalException;

import hu.unideb.inf.importexport.common.AbstractCSVDataImporter;

public class LecturerCSVDataImporter extends AbstractCSVDataImporter {

	public LecturerCSVDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
	}

	@Override
	protected void parseLine(String line) throws PortalException {
		String[] tokens = line.split(";");

		String lecturerName = tokens[0];
		Long lecturerLiferayUserId = Long.valueOf(tokens[1]);

		parseLecturer(lecturerName, lecturerLiferayUserId);
	}

}
