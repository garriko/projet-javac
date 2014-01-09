package org.jacademie.dbupdate.parser;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.jacademie.domain.Album;
import org.jacademie.domain.Artiste;
import org.jacademie.domain.Chanson;
import org.jacademie.projetjavac.LiveMain;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestParser {
	private static Logger logger = Logger.getLogger(TestParser.class);
	
	/*
	@Test
	public void testDecomposerLigne(){
		String chaineTested = "C'est une chaine de test,\navec un retour a la ligne\n";
		logger.debug(chaineTested);
		ParserImpl tester = new ParserImpl();
		
		Set<String> expected = new HashSet<>();
		expected.add("C'est une chaine de test,");
		expected.add("avec un retour a la ligne");
		
		assertEquals(expected, tester.decomposerLignes(chaineTested));
		
	}*/
	
	
	@Test
	public void testFonctionParse(){
		ParserImpl tester = new ParserImpl();
		String chaine = "2, Green Day, 3, American Idiot, 1, American Idiot, 184\n2, Green Day, 3, American Idiot, 2, Holiday, 233\n2, Green Day, 3, American Idiot, 3, Boulevard of Broken Dreams, 261\n2, Green Day, 3, American Idiot, 4, Are We the Waiting, 175\n2, Green Day, 4, 21th Century Breakdown, 1, Song of the Century, 58\n2, Green Day, 4, 21th Century Breakdown, 2, 21th Century Breakdown, 309\n2, Green Day, 4, 21th Century Breakdown, 3, Know Your Enemy, 191\n";
		Set<Artiste> res = tester.parser(chaine);
		
		logger.info("-----Affichage de la liste--------");
		for(Artiste artiste : res){
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
		
		
		
		assertTrue(true);
		
	}
	
	/*
	
	@Test
	public void testSautDeLigne(){
		logger.info("test saut de ligne - DEBUT");
		String chaineTested = "test\nhuehue";
		
		logger.debug(chaineTested);
		logger.debug(chaineTested.charAt(5));
		logger.debug(chaineTested.indexOf("\n"));
		assertEquals(4, chaineTested.indexOf("\n") );

		logger.debug("test saut de ligne - FIN");
		
	}
	
	*/
	
	
}
