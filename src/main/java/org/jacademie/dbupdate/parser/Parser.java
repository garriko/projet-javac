package org.jacademie.dbupdate.parser;

import java.util.Set;

import org.jacademie.domain.Artiste;

public interface Parser{
	
	public Set<Artiste> parser(String texte);
	
	
}
