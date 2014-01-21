package org.jacademie.service.filereader.impl;

import org.jacademie.domain.Album;
import org.jacademie.domain.Artiste;
import org.jacademie.domain.Chanson;
import org.jacademie.service.parser.Parser;


/**
 * <p>Classe permettant de lire le dossier contenant les fichiers .music. </p>
 * 
 * <p>{@link #repositoryReader)} renvoie un string contenant les informations contenues dans un fichier .music  et permet de creer un dossier</p>
 * 
 * @see RepositoryReader
 * 
 * @author Adrien Blachere
 * 
 * **/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.jacademie.service.filereader.FileReader;
import org.jacademie.service.filereader.RepositoryReader;

public class RepositoryReaderImpl implements RepositoryReader{

	/**
	 * 
	 * @param le chemin du dossier
	 * @return Renvoie une Hashmap avec comme clef le nom du fichier et comme value le contenu du fichier
	 */
	@Override
	public HashMap<String, String>  simpleReadRepository(String filePath) throws FileNotFoundException, IOException{

		FileReader file= new FileReader();
		File di = new File(filePath);
		File fl[] = di.listFiles();
		HashMap<String, String> map = new HashMap<String, String>();


		String str="";
		String str2="";
		String totalinfo="";
		String out="";

		for (int j=0; j < fl.length; j++)
		{
			str= fl[j].toString();

			str2= filePath.replace('/', '\\');
			str2= str.replace(str2+"\\","");

			if( str.substring(str.lastIndexOf('.')).equals(".music")){
				totalinfo= file.simpleReadFile(str);
				out=out+totalinfo;
				map.put(str2, totalinfo);
			}
		}

		return map;
	}

	/**
	 * 
	 * @param le chemin ou l'on veut créer le dossier
	 * @return crée un dossier et renvoi le chemin d'entrée + le nom du fichier créé.
	 */
	@Override
	public String createDirectory(String path) { 
		
		File path2 = new File(path);
		String resultat = "";
		String nomRep = new String();
		Date actuelle = new Date();

		DateFormat dateFormat = new SimpleDateFormat("YYYY.MM.DD_HH.mm.SS");
		String dat = dateFormat.format(actuelle);
		
		nomRep="/processed_"+dat;
		File fb = new File(path+nomRep); 
		resultat=path+nomRep;
		fb.mkdirs();
		return resultat;
	} 
}
