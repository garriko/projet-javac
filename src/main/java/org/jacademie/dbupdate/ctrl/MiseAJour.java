package org.jacademie.dbupdate.ctrl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jacademie.dao.ArtisteDAO;
import org.jacademie.domain.Artiste;
import org.jacademie.service.filereader.RepositoryReader;
import org.jacademie.service.filereader.impl.RepositoryReaderImpl;
import org.jacademie.service.parser.Parser;
import org.jacademie.service.parser.impl.ParserImpl;


/**
 * Classe controlant toute la logique metier
 * 
 * @author Kevin
 *
 */
public class MiseAJour {

	private static Logger logger = Logger.getLogger(MiseAJour.class);
	
	
	/**
	 * <p>Cette fonction recupere les fichiers .music se trouvant dans le repertoire passe en parametre. Si ce repertoire est incorrect, la fonction renvoie une exception.</p>
	 * 
	 * <p>Elle appelle ensuite le parser sur chaque fichiers pour ensuite sauvegarder les nouveaux artistes dans la base de donnees</p>
	 * <p>Les fichiers sont ensuite deplaces vers le repertoire /processed_AAAA.MM.JJ_HH.mm.ss. Par defaut, ce repertoire se trouve dans le repertoire donne en parametre.</p>
	 * 
	 * @param cheminRepertoire Chemin vers le repertoire a traiter
	 * @throws FileNotFoundException Fichier non trouve
	 * @throws IOException
	 */
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
