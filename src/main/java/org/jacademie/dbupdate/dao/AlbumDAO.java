package org.jacademie.dbupdate.dao;

import org.hibernate.Session;
import org.jacademie.domain.Album;
import org.jacademie.domain.Artiste;

public class AlbumDAO {
	public void ajouterAlbum(Album album, Session session){
		
		session.save(album);

	}
}
