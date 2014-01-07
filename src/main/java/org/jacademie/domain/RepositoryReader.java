package org.jacademie.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class RepositoryReader {
	
	public static ArrayList  simpleReadRepository(String filePath) throws FileNotFoundException, IOException{
		
		FileReader file= new FileReader();
		File di = new File(filePath);
		File fl[] = di.listFiles();
		

		String str="";
		String totalinfo="";
		
		ArrayList out = new ArrayList();
		
		for (int j=0; j < fl.length; j++)
		{
		System.out.println(fl[j]);
		
		str= fl[j].toString();
		totalinfo= file.simpleReadFile(str);
		System.out.println(totalinfo);
		out.add(totalinfo);
		}
		
		return out;
		
		
	}
	
	
	

}
