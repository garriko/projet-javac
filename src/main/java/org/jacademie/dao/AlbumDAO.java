package org.jacademie.dao;

import org.hibernate.Session;
import org.jacademie.domain.Album;

/**
 * DAO Album
 * Ajoute un nouvel album ou met a jour un album existant sur la database
 * 
 * @author Kevin Garrido
 *
 */
public class AlbumDAO {
	
	/**
	 * 
	 * @param album Album a ajouter ou a mettre a jour
	 * @param session Session hibernate 
	 */
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
