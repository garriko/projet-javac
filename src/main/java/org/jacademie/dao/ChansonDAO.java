package org.jacademie.dao;

import org.hibernate.Session;
import org.jacademie.domain.Chanson;

public class ChansonDAO {
	public void ajouterChanson(Chanson chanson, Session session){
	
		session.save(chanson);
				
	}
}
