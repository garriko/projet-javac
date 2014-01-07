package org.jacademie.FileReader;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface RepositoryReader {
	
	public String  simpleReadRepository(String filePath) throws FileNotFoundException, IOException;
}
