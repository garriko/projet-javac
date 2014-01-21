package org.jacademie.dao;

import org.hibernate.Session;
import org.jacademie.domain.Chanson;

/**
 * DAO Chanson
 * Ajoute une nouvelle chanson
 * 
 * @author Kevin Garrido
 *
 */
public class ChansonDAO {
	public void ajouterChanson(Chanson chanson, Session session){
	
		session.save(chanson);
				
	}
}
