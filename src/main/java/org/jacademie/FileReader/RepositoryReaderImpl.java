package org.jacademie.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RepositoryReaderImpl implements RepositoryReader{

	@Override
	public String  simpleReadRepository(String filePath) throws FileNotFoundException, IOException{

		FileReader file= new FileReader();
		File di = new File(filePath);
		File fl[] = di.listFiles();


		String str="";
		String totalinfo="";
		String out="";

		for (int j=0; j < fl.length; j++)
		{
			str= fl[j].toString();
			if(str.indexOf(".music")!=-1){
				totalinfo= file.simpleReadFile(str);
				out=out+totalinfo;
			}
		}

		return out;


	}
}
