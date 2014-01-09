package org.jacademie.dbupdate.ctrl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.jacademie.FileReader.RepositoryReader;
import org.jacademie.FileReader.RepositoryReaderImpl;
import org.jacademie.dbupdate.parser.Parser;
import org.jacademie.dbupdate.parser.ParserImpl;
import org.jacademie.domain.Album;
import org.jacademie.domain.Artiste;
import org.jacademie.domain.Chanson;

public class MiseAJour {
	
	private static Logger logger = Logger.getLogger(MiseAJour.class);
	
	public static void updateDepuisRepertoire(String cheminRepertoire) throws FileNotFoundException, IOException{
		RepositoryReader repoReader = new RepositoryReaderImpl();
		Parser parser = new ParserImpl();
		
		HashMap<String, String> map = repoReader.simpleReadRepository(cheminRepertoire);
		
		for(Entry<String, String> entry : map.entrySet()){
			String nomFichier = entry.getKey();
			String texte = entry.getValue();
			logger.info("---------------------------------");
			logger.info("Lecture de " + nomFichier);
			logger.info(texte);
			Set<Artiste> contenuFichier = parser.parser(texte);
			
			
			logger.info("-----Affichage du contenu--------");
			for(Artiste artiste : contenuFichier){
				logger.info("-----NOUVEL ARTISTE--------");
				logger.debug("Artiste : " + artiste.getNom());
				logger.debug("Code " + artiste.getCodeArtiste());
				
				for(Album album : artiste.getAlbums()){
					logger.info("-----NOUVEL ALBUM--------");
					logger.debug("Album : " + album.getNom());
					logger.debug("Code album " + album.getCodeAlbum());
					
					for(Chanson chanson : album.getChansons()){
						logger.debug("Titre : " + chanson.getTitre());
						logger.debug("Numero " + chanson.getNumeroChanson());
						logger.debug("Duree"+ chanson.getDuree());
					}
					
				}
				
			}
			logger.info("-----END--------");
		}
	}
	
	public void updateDepuisRepertoire(){
		
	}
	
}
