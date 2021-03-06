package org.jacademie.service.filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.io.FileUtils;

/**
 * <p>Classe permettant de lire le fichier </p>
 * 
 * @see FileReader
 * 
 * @author Remy Girodon // modif Adrien Blachere
 * 
 * **/

public class FileReader {
	
	/**
	 * @param le chemin du fichier
	 * @return Le contenu du fichier
	  */
	
	public static String  simpleReadFile(String filePath){
		FileInputStream fis=null;

		InputStreamReader isr = null;

		BufferedReader br=null;

		try{
			StringBuilder sb=new StringBuilder();
			File file = new File(filePath);

			fis = new FileInputStream(file);
			isr= new InputStreamReader(fis);
			br= new BufferedReader(isr);

			String readLine = null;

			while((readLine = br.readLine()) != null){
				sb.append(readLine).append("\n");
			}
			return sb.toString();
		}
		catch(Exception e){
			System.out.println("Erreur pour lire : "+ filePath);

			e.printStackTrace();
			return null;
		}
		finally{

			if(fis !=null)
			{
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if(isr != null){
				try {
					isr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	/**
	 * @param le chemin du fichier (on utilise la bibliothèque FileUtils
	 * @return Le contenu du fichier
	  */
	public static String advancedReadFile(String filePath){

		try {
			File file = new File(filePath);
			
			String txt = FileUtils.readFileToString(file);
			
			return txt;
			
		} catch (IOException e) {
			
			System.out.println("Erreur while reading : "+ filePath);

			e.printStackTrace();
			
			return null;
		}


	}
	
	/**
	 * @param le chemin du fichier ainsi que le chemin de destination
	 * @return bouge le fichier de place
	  */
	public static void MoveFile(String filePath, String fileDestination){

	    File source = new File(filePath);
	    File destination = new File(fileDestination);
	    
	    source.renameTo(destination);

	}
}
