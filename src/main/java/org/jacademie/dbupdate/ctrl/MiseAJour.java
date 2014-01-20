package org.jacademie.dbupdate.ctrl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jacademie.dao.ArtisteDAO;
import org.jacademie.domain.Album;
import org.jacademie.domain.Artiste;
import org.jacademie.domain.Chanson;
import org.jacademie.service.filereader.FileReader;
import org.jacademie.service.filereader.RepositoryReader;
import org.jacademie.service.filereader.impl.RepositoryReaderImpl;
import org.jacademie.service.parser.Parser;
import org.jacademie.service.parser.impl.ParserImpl;

public class MiseAJour {

	private static Logger logger = Logger.getLogger(MiseAJour.class);

	public static void updateDepuisRepertoire(String cheminRepertoire) throws FileNotFoundException, IOException{
		
		RepositoryReader repoReader = new RepositoryReaderImpl();
		Parser parser = new ParserImpl();

		HashMap<String, String> map = repoReader.simpleReadRepository(cheminRepertoire);

		String newRepository = repoReader.createDirectory(cheminRepertoire);
		


		
		for(Entry<String, String> entry : map.entrySet()){
			String nomFichier = entry.getKey();
			String texte = entry.getValue();
			logger.info("---------------------------------");
			logger.info("Lecture de " + nomFichier);
			logger.info(texte);
			List<Artiste> contenuFichier = parser.parser(texte);

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			ArtisteDAO artDAO = new ArtisteDAO();

			//logger.info("-----Affichage du contenu--------");
			for(Artiste artiste : contenuFichier){
				//artiste.toString();
				session.beginTransaction();
				artDAO.ajouterArtiste(artiste, session);
				session.getTransaction().commit();
				
			}
			//logger.info("-----END--------");
			session.close();
			logger.info("+++++++++++++++++++++++++++++++++++++++++");
			logger.info("+++++++++++++++++++++++++++++++++++++++++");
			logger.info("+++++++++++++++++++++++++++++++++++++++++");
			logger.info("+++++++++++++++++++++++++++++++++++++++++");
			logger.info("+++++++++++++++++++++++++++++++++++++++++");
			logger.info(cheminRepertoire+"/"+nomFichier);
			logger.info(newRepository);
			
			//FileReader.MoveFile(cheminRepertoire+"/"+nomFichier, newRepository+"/"+nomFichier);
		}

		
	}

	public void updateDepuisRepertoire(){

	}

}
