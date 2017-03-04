package hu.unideb.inf.importexport.common;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;

import hu.unideb.inf.exception.ImportDataContentTypeException;
import hu.unideb.inf.exception.ImportDataEntityTypeException;
import hu.unideb.inf.importexport.coursetype.CourseTypeCSVDataImporter;
import hu.unideb.inf.importexport.coursetype.CourseTypeXMLDataImporter;
import hu.unideb.inf.importexport.lecturer.LecturerCSVDataImporter;
import hu.unideb.inf.importexport.lecturer.LecturerXMLDataImporter;
import hu.unideb.inf.importexport.semester.SemesterCSVDataImporter;
import hu.unideb.inf.importexport.semester.SemesterXMLDataImporter;
import hu.unideb.inf.importexport.syllabus.SyllabusCSVDataImporter;
import hu.unideb.inf.importexport.syllabus.SyllabusXMLDataImporter;
import hu.unideb.inf.web.constants.WebKeys;

public class DataImporterFactory {

	private static final Log log = LogFactoryUtil.getLog(DataImporterFactory.class);

	private static final DataImporterFactory INSTANCE = new DataImporterFactory();

	private DataImporterFactory() {
		if (INSTANCE != null) {
			throw new IllegalStateException();
		}
	}

	public static DataImporterFactory getInstance() {
		return INSTANCE;
	}

	public DataImporter newDataImporter(ActionRequest actionRequest) throws Exception {
		String contentType = ParamUtil.getString(actionRequest, "contentType", StringPool.BLANK);
		String entityType = ParamUtil.getString(actionRequest, "entityType", StringPool.BLANK);

		if (log.isDebugEnabled()) {
			log.debug(String.format("contentType: '%s', entityType: '%s'", contentType, entityType));
		}

		DataImporter dataImporter = null;

		switch (contentType) {
		case ContentTypes.TEXT_CSV:
		case ContentTypes.TEXT_CSV_UTF8:
			switch (entityType) {
			case WebKeys.SYLLABUS:
				dataImporter = new SyllabusCSVDataImporter(actionRequest);
				break;

			case WebKeys.COURSE_TYPE:
				dataImporter = new CourseTypeCSVDataImporter(actionRequest);
				break;

			case WebKeys.SEMESTER:
				dataImporter = new SemesterCSVDataImporter(actionRequest);
				break;

			case WebKeys.LECTURER:
				dataImporter = new LecturerCSVDataImporter(actionRequest);
				break;

			default:
				throw new ImportDataEntityTypeException("Unknown entityType: " + entityType);
			}
			break;

		case ContentTypes.TEXT_XML:
		case ContentTypes.TEXT_XML_UTF8:
			switch (entityType) {
			case WebKeys.SYLLABUS:
				dataImporter = new SyllabusXMLDataImporter(actionRequest);
				break;

			case WebKeys.COURSE_TYPE:
				dataImporter = new CourseTypeXMLDataImporter(actionRequest);
				break;

			case WebKeys.SEMESTER:
				dataImporter = new SemesterXMLDataImporter(actionRequest);
				break;

			case WebKeys.LECTURER:
				dataImporter = new LecturerXMLDataImporter(actionRequest);
				break;

			default:
				throw new ImportDataEntityTypeException("Unknown entityType: " + entityType);
			}
			break;

		default:
			throw new ImportDataContentTypeException("Unknown contentType: " + contentType);
		}

		return dataImporter;
	}

}
