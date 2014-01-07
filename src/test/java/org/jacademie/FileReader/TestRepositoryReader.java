package org.jacademie.FileReader;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class TestRepositoryReader {
	
	@Test
	public void TestMusicUnFichier() throws FileNotFoundException, IOException{
	RepositoryReader test= new RepositoryReaderImpl();
	String read = test.simpleReadRepository("C:/Users/adrien/Desktop/FI3/Java Academy/Maven/projet-javac/TestRepositoryReader/TestMusicUnFichier");
	String in = "CodeArtiste2, NomArtiste2, CodeAlbum2, NomAlbum2, NumeroChanson2, TitreChanson2, DureeChanson2\nCodeArtiste3, NomArtiste3, CodeAlbum3, NomAlbum3, NumeroChanson3, TitreChanson3, DureeChanson3\n";
	assertEquals(in,read);
	}
	
	@Test
	public void TestMusicUnFichierEtUnMauvaisFichier() throws FileNotFoundException, IOException{
	RepositoryReader test= new RepositoryReaderImpl();
	String read = test.simpleReadRepository("C:/Users/adrien/Desktop/FI3/Java Academy/Maven/projet-javac/TestRepositoryReader/TestMusicUnFichierEtUnMauvaisFichier");
	String in = "CodeArtiste2, NomArtiste2, CodeAlbum2, NomAlbum2, NumeroChanson2, TitreChanson2, DureeChanson2\nCodeArtiste3, NomArtiste3, CodeAlbum3, NomAlbum3, NumeroChanson3, TitreChanson3, DureeChanson3\n";
	assertEquals(in,read);
	}
	
	@Test
	public void TestMusicDeuxFichiers() throws FileNotFoundException, IOException{
	RepositoryReader test= new RepositoryReaderImpl();
	String read = test.simpleReadRepository("C:/Users/adrien/Desktop/FI3/Java Academy/Maven/projet-javac/TestRepositoryReader/TestMusicDeuxFichiers");
	String in = "CodeArtiste, NomArtiste, CodeAlbum, NomAlbum, NumeroChanson, TitreChanson, DureeChanson\nCodeArtiste2, NomArtiste2, CodeAlbum2, NomAlbum2, NumeroChanson2, TitreChanson2, DureeChanson2\nCodeArtiste3, NomArtiste3, CodeAlbum3, NomAlbum3, NumeroChanson3, TitreChanson3, DureeChanson3\n";
	assertEquals(in,read);
	}
	
	@Test
	public void TestMusicDeuxMauvaisFichiers() throws FileNotFoundException, IOException{
	RepositoryReader test= new RepositoryReaderImpl();
	String read = test.simpleReadRepository("C:/Users/adrien/Desktop/FI3/Java Academy/Maven/projet-javac/TestRepositoryReader/TestMusicDeuxMauvaisFichiers");
	String in ="";
	assertEquals(in,read);	
	}

}
