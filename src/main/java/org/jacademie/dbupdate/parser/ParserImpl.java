package org.jacademie.dbupdate.parser;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.jacademie.domain.Artiste;


public class ParserImpl implements Parser{
	private static Logger logger = Logger.getLogger(TestParser.class);

	public Set<String> decomposerLignes(String texte){
		Set<String> lignes = new HashSet<String>();

		int index = 0;

		int fin = texte.indexOf("\n", index);

		logger.debug(fin);

		while(fin != -1){
			String ligne = texte.substring(index,fin);


			logger.debug(ligne);

			if(ligne!=null){
				lignes.add(ligne);
			}

			index=fin+1;
			logger.debug("index :" +index);
			fin = texte.indexOf("\n", index);
			logger.debug("fin :" +fin);
		}

		return lignes;
	}

	
	public void majResultat(Set<Artiste> liste, String ligne){
		
	}
	
	@Override
	public Set<Artiste> parser(String texte) {
		Set<Artiste> resultat = new HashSet<>();	

		Set<String> lignes = decomposerLignes(texte);
		
		for(String l : lignes){
			majResultat(resultat, l);
		}

		return resultat;
	}


}
