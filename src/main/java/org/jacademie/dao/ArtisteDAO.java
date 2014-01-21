package org.jacademie.dao;

import org.hibernate.Session;
import org.jacademie.domain.Album;
import org.jacademie.domain.Artiste;

/**
 * DAO Artiste
 * Ajoute un nouvel artiste ou met a jour un artiste existant sur la database
 * 
 * @author Kevin Garrido
 *
 */
public class ArtisteDAO {
	
	/**
	 * 
	 * @param artiste Artiste a ajouter ou a mettre a jour
	 * @param session Session hibernate
	 */
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
