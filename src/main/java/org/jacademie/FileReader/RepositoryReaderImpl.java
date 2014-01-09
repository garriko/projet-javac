package org.jacademie.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class RepositoryReaderImpl implements RepositoryReader{

	@Override
	public HashMap  simpleReadRepository(String filePath) throws FileNotFoundException, IOException{

		FileReader file= new FileReader();
		File di = new File(filePath);
		File fl[] = di.listFiles();
		HashMap map = new HashMap();


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
	
}
