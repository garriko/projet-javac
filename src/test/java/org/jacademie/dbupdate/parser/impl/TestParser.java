package org.jacademie.dbupdate.parser.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jacademie.domain.Album;
import org.jacademie.domain.Artiste;
import org.jacademie.service.parser.impl.ParserImpl;
import org.junit.Before;
import org.junit.Test;

public class TestParser {

	private List<Artiste> listeArtiste;
	
	
	
	@Before
	public void initialize(){
		
		listeArtiste= new ArrayList<Artiste>();

		Artiste artiste1 = new Artiste();
		artiste1.setCodeArtiste(12);
		artiste1.setNom("art1");
		
		Album alb1 = new Album();
		alb1.setArtiste(artiste1);
		alb1.setCodeAlbum(1);
		alb1.setNom("album 1");
		
		artiste1.addAlbum(alb1);
		
		Artiste artiste2 = new Artiste();
		artiste2.setCodeArtiste(3);
		artiste2.setNom("art2");

		listeArtiste.add(artiste1);
		listeArtiste.add(artiste2);
	}
	

	@Test
	public void testDecomposerLigne(){
		String chaineTested = "C'est une chaine de test\navec un retour a la ligne\n";

		ParserImpl tester = new ParserImpl();

		Collection<String> expected = new ArrayList<String>();

		expected.add("C'est une chaine de test");
		expected.add("avec un retour a la ligne");


		assertEquals(expected, tester.decomposerLignes(chaineTested));

	}


	@Test
	public void testArtisteExistantVrai(){
		ParserImpl tester = new ParserImpl();

		assertTrue(tester.artisteExistant(listeArtiste, 3));
	}

	@Test
	public void testArtisteExistantFaux(){
		ParserImpl tester = new ParserImpl();

		assertFalse(tester.artisteExistant(listeArtiste, 5));
	}

	@Test
	public void testArtisteExistantNull(){
		ParserImpl tester = new ParserImpl();

		List<Artiste> listeNull = null;
		
		assertFalse(tester.artisteExistant(listeNull, 5));
	}
	
	@Test
	public void testArtisteExistantVide(){
		ParserImpl tester = new ParserImpl();

		List<Artiste> listeVide = new ArrayList<Artiste>();
		
		assertFalse(tester.artisteExistant(listeVide, 5));
	}
	
	@Test
	public void testAlbumExistantVrai(){
		ParserImpl tester = new ParserImpl();

		assertTrue(tester.albumExistant(listeArtiste, 12, 1));
	}

	@Test
	public void testAlbumExistantFauxMauvaisAlbum(){
		ParserImpl tester = new ParserImpl();

		assertFalse(tester.albumExistant(listeArtiste, 12, 3));
	}

	@Test
	public void testAlbumExistantFauxMauvaisArtiste(){
		ParserImpl tester = new ParserImpl();

		assertFalse(tester.albumExistant(listeArtiste, 1, 1));
	}
	
	@Test
	public void testAlbumExistantNull(){
		ParserImpl tester = new ParserImpl();

		List<Artiste> listeNull = null;
		
		assertFalse(tester.albumExistant(listeNull, 12, 1));
	}
	
	@Test
	public void testAlbumExistantVide(){
		ParserImpl tester = new ParserImpl();

		List<Artiste> listeVide = new ArrayList<Artiste>();
		
		assertFalse(tester.albumExistant(listeVide, 12,1));
	}
	/*
	@Test
	public void testFonctionParse(){
		ParserImpl tester = new ParserImpl();
		String chaine = "2, Green Day, 3, American Idiot, 1, American Idiot, 184\n2, Green Day, 3, American Idiot, 2, Holiday, 233\n2, Green Day, 3, American Idiot, 3, Boulevard of Broken Dreams, 261\n2, Green Day, 3, American Idiot, 4, Are We the Waiting, 175\n2, Green Day, 4, 21th Century Breakdown, 1, Song of the Century, 58\n2, Green Day, 4, 21th Century Breakdown, 2, 21th Century Breakdown, 309\n2, Green Day, 4, 21th Century Breakdown, 3, Know Your Enemy, 191\n";
		List<Artiste> res = tester.parser(chaine);
		logger.info(chaine);

		logger.info("-----Affichage de la liste--------");
		for(Artiste artiste : res){
			logger.info("-----ARTISTE--------");
			logger.debug("Artiste : " + artiste.getNom());
			logger.debug("Code " + artiste.getCodeArtiste());

			for(Album album : artiste.getAlbums()){
				logger.info("------ALBUM--------");
				logger.debug("Album : " + album.getNom());
				logger.debug("Code album " + album.getCodeAlbum());

				for(Chanson chanson : album.getChansons()){
					logger.info("------CHANSON--------");
					logger.debug("Titre : " + chanson.getTitre());
					logger.debug("Numero " + chanson.getNumeroChanson());
					logger.debug("Duree "+ chanson.getDuree());
				}
				logger.info("------FIN ALBUM--------");
			}

		}
		logger.info("-----END--------");



		assertTrue(true);

	}
	 */


}
