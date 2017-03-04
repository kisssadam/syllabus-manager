package hu.unideb.inf.importexport.common;

import java.io.IOException;

public interface DataImporter extends AutoCloseable {

	void importData() throws IOException;
	
}
