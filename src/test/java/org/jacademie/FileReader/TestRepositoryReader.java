package org.jacademie.FileReader;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.jacademie.service.filereader.RepositoryReader;
import org.jacademie.service.filereader.impl.RepositoryReaderImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Il faut changer le champ repository pour que ces tests fonctionnent
 * @author Adrien Blachere
 *
 */

public class TestRepositoryReader {

	private String repository;

	@Before
	public void initialize(){
		this.repository = "C:/Users/adrien/Desktop/FI3/Java Academy/Maven/projet-javac/TestRepositoryReader"; 
	}

	@Test
	public void TestMusicUnFichier() throws FileNotFoundException, IOException{
		RepositoryReader test= new RepositoryReaderImpl();
		HashMap<String,String> read = test.simpleReadRepository(repository+"/TestMusicUnFichier");
		String in = "CodeArtiste2, NomArtiste2, CodeAlbum2, NomAlbum2, NumeroChanson2, TitreChanson2, DureeChanson2\nCodeArtiste3, NomArtiste3, CodeAlbum3, NomAlbum3, NumeroChanson3, TitreChanson3, DureeChanson3\n";
		assertEquals(in,read.get("exemple.music"));
	}

	@Test
	public void TestMusicUnFichierEtUnMauvaisFichier() throws FileNotFoundException, IOException{
		RepositoryReader test= new RepositoryReaderImpl();
		HashMap<String,String> read = test.simpleReadRepository(repository+"/TestMusicUnFichierEtUnMauvaisFichier");
		String in = "CodeArtiste2, NomArtiste2, CodeAlbum2, NomAlbum2, NumeroChanson2, TitreChanson2, DureeChanson2\nCodeArtiste3, NomArtiste3, CodeAlbum3, NomAlbum3, NumeroChanson3, TitreChanson3, DureeChanson3\n";
		assertEquals(in,read.get("exemple.music"));
	}

	@Test
	public void TestMusicDeuxFichiers() throws FileNotFoundException, IOException{
		RepositoryReader test= new RepositoryReaderImpl();
		HashMap<String,String> read = test.simpleReadRepository(repository+"/TestMusicDeuxFichiers");
		String in = "Contenu fichier un\nContenu fichier deux\n";
		String conc = read.get("exemple.music").toString();
		conc = conc.concat(read.get("exemple2.music").toString());
		assertEquals(in,conc);

	}

	@Test
	public void TestMusicDeuxMauvaisFichiers() throws FileNotFoundException, IOException{
		RepositoryReader test= new RepositoryReaderImpl();
		HashMap<String,String> read = test.simpleReadRepository(repository+"/TestMusicDeuxMauvaisFichiers");
		assertEquals(read.size(),0);	
	}


	@Test
	public void TestCreateDirectory() throws FileNotFoundException, IOException{
		RepositoryReader test= new RepositoryReaderImpl();
		test.createDirectory(repository);
	}
	
}

