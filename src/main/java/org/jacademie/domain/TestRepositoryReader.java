package org.jacademie.domain;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.jacademie.domain.RepositoryReader;

public class TestRepositoryReader {

	private static Logger logger = Logger.getLogger(TestRepositoryReader.class);
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		logger.info("Debut du test");
		RepositoryReader test= new RepositoryReader();
		
		ArrayList number = test.simpleReadRepository("C:/Users/adrien/Desktop/FI3/Java Academy/Maven/projet-javac/MusicExemple");

		System.out.println(number.toString());
	}

}
