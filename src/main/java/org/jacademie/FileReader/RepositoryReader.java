package org.jacademie.FileReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public interface RepositoryReader {
	
	public HashMap  simpleReadRepository(String filePath) throws FileNotFoundException, IOException;
}
