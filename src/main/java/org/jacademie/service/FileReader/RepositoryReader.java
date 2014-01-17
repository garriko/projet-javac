package org.jacademie.service.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public interface RepositoryReader {
	
	public HashMap<String, String> simpleReadRepository(String filePath) throws FileNotFoundException, IOException;

	String createDirectory(String path);
}
