package org.jacademie.dao;

import org.hibernate.Session;
import org.jacademie.domain.Album;
import org.jacademie.domain.Artiste;

public class ArtisteDAO {
	public void ajouterArtiste(Artiste artiste, Session session){
		
		AlbumDAO albumDAO = new AlbumDAO();
		
		
		for(Album album : artiste.getAlbums()){
			albumDAO.ajouterAlbum(album, session);
			
		}
		
		Artiste artisteExistant = (Artiste) session.get(Artiste.class, artiste.getCodeArtiste());
		
		if(artisteExistant == null){
			session.save(artiste);
		}
		else{
			artisteExistant.setNom(artiste.getNom());
			//albumExistant.setChansons(album.getChansons());
			session.update(artisteExistant);
		}
	
	}
}
