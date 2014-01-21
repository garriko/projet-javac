package org.jacademie.service.filereader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/**
 * <p>Interface permettant de lire le dossier contenant les fichiers .music. </p>
 * 
 * <p>{@link #repositoryReader)} renvoie un string contenant les informations contenues dans un fichier .music et permet de creer un dossier</p>
 * 
 * @see RepositoryReader
 * 
 * @author Adrien Blachere
 * 
 * **/
public interface RepositoryReader {
	
	/**
	 * 
	 * @param le chemin du dossier
	 * @return Renvoie une Hashmap avec comme clef le nom du fichier et comme value le contenu du fichier
	 */
	public HashMap<String, String> simpleReadRepository(String filePath) throws FileNotFoundException, IOException;

	/**
	 * 
	 * @param le chemin ou l'on veut créer le dossier
	 * @return crée un dossier et renvoi le chemin d'entrée + le nom du fichier créé.
	 */
	
	String createDirectory(String path);
}
