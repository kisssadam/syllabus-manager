package hu.unideb.inf.importexport.coursetype;

import java.io.FileNotFoundException;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import hu.unideb.inf.importexport.common.AbstractCSVDataImporter;
import hu.unideb.inf.web.util.SyllabusCSVUtil;

public class CourseTypeCSVDataImporter extends AbstractCSVDataImporter {

	public CourseTypeCSVDataImporter(ActionRequest actionRequest) throws FileNotFoundException {
		super(actionRequest);
	}

	@Override
	protected void parseLine(String[] line) throws SystemException, PortalException {
		String courseTypeName = SyllabusCSVUtil.decode(line[0]);

		parseCourseType(courseTypeName);
	}

}
