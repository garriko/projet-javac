package org.jacademie.domain;

/**
 * 
 * Objet Chanson
 * 
 * @author Kevin Garrido
 * @see Artiste, Album
 */
public class Chanson {
	private Integer id;
	private Integer numeroChanson;
	private String titre;
	private Integer duree;
	
	public Chanson() {
		super();
	}

	@Override
	public String toString(){
		String res = "Chanson " + this.titre + "\n";
		res = res.concat("Numero Chanson : " + this.numeroChanson + "\n");
		res = res.concat("Duree Chanson : " + this.duree + "\n\n");
		
		return res;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroChanson() {
		return numeroChanson;
	}

	public void setNumeroChanson(Integer numeroChanson) {
		this.numeroChanson = numeroChanson;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}
		
	
}
