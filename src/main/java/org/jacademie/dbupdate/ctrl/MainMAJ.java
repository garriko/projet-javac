package org.jacademie.dbupdate.ctrl;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;

public class MainMAJ {
	
	public static Logger logger = Logger.getLogger(MainMAJ.class);
	
	public static void main(String[] args) {
		try {
			
			MiseAJour.updateDepuisRepertoire("C:/Users/Kevin/Documents/JAVA_ACADEMIE/workspace/projet-javac/TestRepositoryReader/Playlist");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
