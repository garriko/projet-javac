package org.jacademie.FileReader;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.jacademie.service.FileReader.RepositoryReader;
import org.jacademie.service.FileReader.RepositoryReaderImpl;
import org.junit.Test;

public class TestRepositoryReader {

	@Test
	public void TestMusicUnFichier() throws FileNotFoundException, IOException{
		RepositoryReader test= new RepositoryReaderImpl();
		HashMap<String,String> read = test.simpleReadRepository("C:/Users/adrien/Desktop/FI3/Java Academy/Maven/projet-javac/TestRepositoryReader/TestMusicUnFichier");
		String in = "CodeArtiste2, NomArtiste2, CodeAlbum2, NomAlbum2, NumeroChanson2, TitreChanson2, DureeChanson2\nCodeArtiste3, NomArtiste3, CodeAlbum3, NomAlbum3, NumeroChanson3, TitreChanson3, DureeChanson3\n";
		assertEquals(in,read.get("exemple.music"));
	}

	@Test
	public void TestMusicUnFichierEtUnMauvaisFichier() throws FileNotFoundException, IOException{
		RepositoryReader test= new RepositoryReaderImpl();
		HashMap<String,String> read = test.simpleReadRepository("C:/Users/adrien/Desktop/FI3/Java Academy/Maven/projet-javac/TestRepositoryReader/TestMusicUnFichierEtUnMauvaisFichier");
		String in = "CodeArtiste2, NomArtiste2, CodeAlbum2, NomAlbum2, NumeroChanson2, TitreChanson2, DureeChanson2\nCodeArtiste3, NomArtiste3, CodeAlbum3, NomAlbum3, NumeroChanson3, TitreChanson3, DureeChanson3\n";
		assertEquals(in,read.get("exemple.music"));
	}

	@Test
	public void TestMusicDeuxFichiers() throws FileNotFoundException, IOException{
		RepositoryReader test= new RepositoryReaderImpl();
		HashMap<String,String> read = test.simpleReadRepository("C:/Users/adrien/Desktop/FI3/Java Academy/Maven/projet-javac/TestRepositoryReader/TestMusicDeuxFichiers");
		String in = "Contenu fichier un\nContenu fichier deux\n";
		String conc = read.get("exemple.music").toString();
		conc = conc.concat(read.get("exemple2.music").toString());
		assertEquals(in,conc);

	}

	@Test
	public void TestMusicDeuxMauvaisFichiers() throws FileNotFoundException, IOException{
		RepositoryReader test= new RepositoryReaderImpl();
		HashMap<String,String> read = test.simpleReadRepository("C:/Users/adrien/Desktop/FI3/Java Academy/Maven/projet-javac/TestRepositoryReader/TestMusicDeuxMauvaisFichiers");
		assertEquals(read.size(),0);	
	}

	@Test
	public void TestPlaylist() throws FileNotFoundException, IOException{
		RepositoryReader test= new RepositoryReaderImpl();
		HashMap<String,String> read = test.simpleReadRepository("C:/Users/adrien/Desktop/FI3/Java Academy/Maven/projet-javac/TestRepositoryReader/Playlist");
		//System.out.println(read.toString());
		assertTrue(true);
	}

	@Test
	public void TestCreateDirectory() throws FileNotFoundException, IOException{
		RepositoryReader test= new RepositoryReaderImpl();
		test.createDirectory("C:/Users/adrien/Desktop/FI3/Java Academy/Maven/projet-javac/TestRepositoryReader");
	}
	
}

