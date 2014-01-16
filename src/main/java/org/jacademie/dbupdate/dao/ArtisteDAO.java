package org.jacademie.dbupdate.dao;

import org.hibernate.Session;
import org.jacademie.domain.Album;
import org.jacademie.domain.Artiste;

public class ArtisteDAO {
	public void ajouterArtiste(Artiste artiste, Session session){
		
		AlbumDAO albumDAO = new AlbumDAO();
		for(Album album : artiste.getAlbums()){
			albumDAO.ajouterAlbum(album, session);
			
		}
		
		session.save(artiste);
	
	}
}
