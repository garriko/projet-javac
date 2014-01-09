package org.jacademie.domain;

import java.util.HashSet;
import java.util.Set;

public class Artiste {
	private Integer codeArtiste;
	private String nom;
	private Set<Album> albums;
	
	
	public Artiste() {
		super();

		this.albums = new HashSet<Album>();
	}

	public void addAlbum(Album album){
		this.albums.add(album);
	}
	
	public void removeAlbum(Album album){
		this.albums.remove(album);
	}
	

	public Integer getCodeArtiste() {
		return codeArtiste;
	}


	public void setCodeArtiste(Integer codeArtiste) {
		this.codeArtiste = codeArtiste;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Set<Album> getAlbums() {
		return albums;
	}


	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}
	
	@Override
	public String toString(){
		String res = "Artiste " + this.nom + "\n";
		res.concat("Code Artiste : " + this.codeArtiste + "\n\n");
		
		for(Album alb : this.albums){
			res.concat(alb.toString());
		}
		return res;
	}
	
}
