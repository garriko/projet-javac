package org.jacademie.dbupdate.ctrl;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainMAJ {
	
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
