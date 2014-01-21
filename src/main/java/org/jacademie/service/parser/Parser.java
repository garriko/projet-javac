package org.jacademie.service.parser;

import java.util.List;

import org.jacademie.domain.Artiste;
import org.jacademie.service.parser.impl.ParserImpl;
/**
 * 
 * Interface a utiliser pour parser un fichier .music
 * 
 * 
 * 
 * @author Kevin Garrido
 * @see ParserImpl
 */
public interface Parser{
	
	/**
	 * <p>Parse un String et en extrait les artistes, albums et chansons</p>
	 *  
	 * @param texte Texte multiligne a parser
	 * @return Renvoie la liste d'artiste cree a partir du String
	 */
	public List<Artiste> parser(String texte);
	
	
}
