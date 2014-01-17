package org.jacademie.service.parser;

import java.util.List;
import java.util.Set;

import org.jacademie.domain.Artiste;

public interface Parser{
	
	public List<Artiste> parser(String texte);
	
	
}
