package org.jacademie.projetjavac;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jacademie.domain.Album;
import org.jacademie.domain.Artiste;
import org.jacademie.domain.Chanson;

public class LiveMain {
private static Logger logger = Logger.getLogger(LiveMain.class);
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
	
		logger.info("Test du modele de donnees");
		
		Chanson ch1 = new Chanson();
		ch1.setNumeroChanson(1);
		ch1.setTitre("Uprising");
		ch1.setDuree(335);
		
		Chanson ch2 = new Chanson();
		ch2.setNumeroChanson(2);
		ch2.setTitre("Supremacy");
		ch2.setDuree(314);
		
		Chanson ch3 = new Chanson();
		ch3.setNumeroChanson(1);
		ch3.setTitre("Plug in baby");
		ch3.setDuree(195);
		
		Album alb1 = new Album();
		alb1.setNom("Live at Rome");
		alb1.setCodeAlbum(1);
		alb1.addChanson(ch1);
		alb1.addChanson(ch2);
		
		Album alb2 = new Album();
		alb2.setNom("Origin of Symmetry");
		alb2.setCodeAlbum(2);
		alb2.addChanson(ch3);
		
		Artiste art1 = new Artiste();
		art1.setCodeArtiste(1);
		art1.setNom("Muse");
		art1.addAlbum(alb1);
		art1.addAlbum(alb2);

		alb1.setArtiste(art1);
		alb2.setArtiste(art1);
	
		session.save(alb1);
		session.save(alb2);
		session.save(art1);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
}
