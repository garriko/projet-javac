package org.jacademie.dao;

import org.hibernate.Session;
import org.jacademie.domain.Album;

public class AlbumDAO {
	public void ajouterAlbum(Album album, Session session){
		Album albumExistant = (Album) session.get(Album.class, album.getCodeAlbum());
		
		if(albumExistant == null){
			session.save(album);
		}
		else{
			albumExistant.setArtiste(album.getArtiste());
			albumExistant.setNom(album.getNom());
			//albumExistant.addNewChansons(album.getChansons());
			//albumExistant.removeChansons(album.getChansons());
			session.update(albumExistant);
		}
	}
}
