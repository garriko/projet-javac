package org.jacademie.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Objet Album
 * 
 * @author Kevin Garrido
 * @see Artiste, Chanson
 */
public class Album {

	private Integer codeAlbum;
	private String nom;
	private Artiste artiste;
	private Set<Chanson> chansons;


	public Album() {
		super();

		this.chansons = new HashSet<Chanson>();
	}


	public void addChanson(Chanson chanson){
		this.chansons.add(chanson);
	}

	public void removeChanson(Chanson chanson){
		this.chansons.remove(chanson);
	}

	public void removeChansons(Set<Chanson> chansons2) {
		for(Chanson chanson : this.chansons){

			if(!chansons2.contains(chanson)){
				this.removeChanson(chanson);
			}
		}
	}

	public void addNewChansons(Set<Chanson> chansons) {
		for(Chanson chanson : chansons){

			if(!this.chansons.contains(chanson)){
				this.chansons.add(chanson);
			}
		}
	}


	@Override
	public String toString(){
		String res = "Album " + this.nom + "\n";
		res = res.concat("Code Album : " + this.codeAlbum + "\n\n");

		for(Chanson ch : this.chansons){
			res = res.concat(ch.toString());
		}
		return res;
	}


	public Integer getCodeAlbum() {
		return codeAlbum;
	}


	public void setCodeAlbum(Integer codeAlbum) {
		this.codeAlbum = codeAlbum;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Set<Chanson> getChansons() {
		return chansons;
	}


	public void setChansons(Set<Chanson> chansons) {
		this.chansons = chansons;
	}


	public Artiste getArtiste() {
		return artiste;
	}


	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}


	


}
