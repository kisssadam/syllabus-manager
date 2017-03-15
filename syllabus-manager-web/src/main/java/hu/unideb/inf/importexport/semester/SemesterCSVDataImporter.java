package hu.unideb.inf.importexport.semester;

import java.io.FileNotFoundException;
import java.util.StringJoiner;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.exception.PortalException;

import hu.unideb.inf.importexport.common.AbstractCSVDataImporter;

public class SemesterCSVDataImporter extends AbstractCSVDataImporter {

	public SemesterCSVDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
	}

	@Override
	protected void parseLine(String[] line) throws PortalException {
		StringJoiner semesterString = new StringJoiner("/");

		for (String s : line) {
			semesterString.add(s);
		}

		parseSemester(semesterString.toString());
	}

}
