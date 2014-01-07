package org.jacademie.dbupdate.parser;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.jacademie.projetjavac.LiveMain;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestParser {
	private static Logger logger = Logger.getLogger(TestParser.class);
	
	
	@Test
	public void testDecomposerLigne(){
		String chaineTested = "C'est une chaine de test,\navec un retour a la ligne\n";
		logger.debug(chaineTested);
		ParserImpl tester = new ParserImpl();
		
		Set<String> expected = new HashSet<>();
		expected.add("C'est une chaine de test,");
		expected.add("avec un retour a la ligne");
		
		assertEquals(expected, tester.decomposerLignes(chaineTested));
		
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
