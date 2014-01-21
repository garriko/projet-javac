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
	
	public List<Artiste> parser(String texte);
	
	
}
