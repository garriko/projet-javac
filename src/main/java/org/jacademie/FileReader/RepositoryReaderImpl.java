package org.jacademie.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class RepositoryReaderImpl implements RepositoryReader{

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

	/*
	 * Crée le dossier path/processed_YYYYMMDD_HHmmSS 
	 * (non-Javadoc)
	 * @see org.jacademie.FileReader.RepositoryReader#createDirectory(java.io.File)
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
