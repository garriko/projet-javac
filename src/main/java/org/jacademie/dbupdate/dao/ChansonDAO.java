package org.jacademie.dbupdate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jacademie.domain.Chanson;

public class ChansonDAO {
	public void ajouterChanson(Chanson chanson, Session session){
	
		session.save(chanson);
				
	}
}
