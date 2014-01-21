package org.jacademie.app;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.jacademie.dbupdate.ctrl.MiseAJour;


public class App
{
	static Logger logger = Logger.getLogger(App.class);
	
	public static void main( String[] args )
    {
		//Repertoire dans lequel on recherche les fichiers .music
		String repertoire = "C:/Users/Kevin/Documents/JAVA_ACADEMIE/workspace/projet-javac/Playlist";
		
		try {
			MiseAJour.updateDepuisRepertoire(repertoire);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
