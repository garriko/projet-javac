package org.jacademie.service.parser.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.jacademie.domain.Album;
import org.jacademie.domain.Artiste;
import org.jacademie.domain.Chanson;
import org.jacademie.service.parser.Parser;


public class ParserImpl implements Parser{
	private static Logger logger = Logger.getLogger(ParserImpl.class);



	@Override
	public List<Artiste> parser(String texte) {
		List<Artiste> resultat = new ArrayList<>();	

		List<String> lignes = decomposerLignes(texte);

		for(String l : lignes){
			majResultat(resultat, l);
		}

		return resultat;
	}


	public List<String> decomposerLignes(String texte){
		List<String> lignes = new ArrayList<String>();

		int index = 0;

		int fin = texte.indexOf("\n", index);

		//logger.debug(fin);

		while(fin != -1){
			String ligne = texte.substring(index,fin);


			//logger.debug(ligne);

			if(ligne!=null){
				lignes.add(ligne);
			}

			index=fin+1;
			//logger.debug("index :" +index);
			fin = texte.indexOf("\n", index);
			//logger.debug("fin :" +fin);
		}

		return lignes;
	}


	public void majResultat(List<Artiste> liste, String ligne){
		int index = 0;
		int cursor = ligne.indexOf(",",index);

		//logger.info(ligne);
		
		Integer codeArtiste = Integer.parseInt(ligne.substring(index, cursor));

		index = cursor+2;
		cursor = ligne.indexOf(",",index);
		String nomArtiste = ligne.substring(index, cursor);

		index = cursor+2;
		cursor = ligne.indexOf(",",index);
		Integer codeAlbum = Integer.parseInt(ligne.substring(index, cursor));

		index = cursor+2;
		cursor = ligne.indexOf(",",index);
		String nomAlbum = ligne.substring(index, cursor);

		index = cursor+2;
		cursor = ligne.indexOf(",",index);
		Integer numeroChanson = Integer.parseInt(ligne.substring(index, cursor));

		index = cursor+2;
		cursor = ligne.indexOf(",",index);
		//logger.debug("Titre chanson : " + ligne.substring(index, cursor));
		String titreChanson = ligne.substring(index, cursor);

		index = cursor+2;
		//cursor = ligne.indexOf("\n",index);
		//logger.debug("duree chanson : " + ligne.substring(index));
		Integer dureeChanson = Integer.parseInt(ligne.substring(index));

		inserer(liste,codeArtiste,nomArtiste,codeAlbum,nomAlbum,numeroChanson,titreChanson,dureeChanson);

	}


	private void inserer(List<Artiste> liste, Integer codeArtiste,
			String nomArtiste, Integer codeAlbum, String nomAlbum,
			Integer numeroChanson, String titreChanson, Integer dureeChanson) {

		Chanson ch = new Chanson();
		ch.setNumeroChanson(numeroChanson);
		ch.setTitre(titreChanson);
		ch.setDuree(dureeChanson);

		Album alb = new Album();
		alb.setCodeAlbum(codeAlbum);
		alb.setNom(nomAlbum);

		Artiste art = new Artiste();
		art.setCodeArtiste(codeArtiste);
		art.setNom(nomArtiste);		

		if(!artisteExistant(liste,codeArtiste)){
			//logger.debug("nouvel artiste " + codeArtiste + " avec l'album "+ codeAlbum + " et la chanson " + numeroChanson);
			alb.addChanson(ch);
			alb.setArtiste(art);
			art.addAlbum(alb);

			liste.add(art);
		}

		else if(!albumExistant(liste, codeArtiste, codeAlbum)){
			//logger.debug("nouvel album " + codeAlbum + " pour l'artiste " + codeArtiste + " avec la chanson " + numeroChanson);
			alb.addChanson(ch);
			alb.setArtiste(art);

			Artiste artiste = getArtiste(liste, codeArtiste);

			artiste.addAlbum(alb);
		}

		else if(!chansonExistante(liste, codeArtiste, codeAlbum, numeroChanson)) {
			Album album = getAlbum(liste, codeArtiste, codeAlbum);
			//logger.debug("nouvelle chanson " + numeroChanson + " dans l'album " + codeAlbum);
			album.addChanson(ch);
		}
		
		else {
			logger.debug("Rien a mettre a jour");
		}
		//logger.debug(liste.get(0).toString());
	}


	private boolean chansonExistante(List<Artiste> liste, Integer codeArtiste,
			Integer codeAlbum, Integer numeroChanson) {
		Album album = getAlbum(liste, codeArtiste, codeAlbum);

		Set<Chanson> chansons = album.getChansons();
		boolean res=false;

		for(Chanson c : chansons){
			if(c.getNumeroChanson().equals(numeroChanson))
				res=true;
		}
		return res;
	}


	public Artiste getArtiste(List<Artiste> liste, Integer codeArtiste){
		Artiste art = new Artiste();
		
		for(Artiste artiste : liste){
			if(artiste.getCodeArtiste().equals(codeArtiste))
			{
				art=artiste;
				break;
			}
		}
		
		return art;
	}

	public Album getAlbum(List<Artiste> liste, Integer codeArtiste, Integer codeAlbum){
		//logger.info("Dans getAlbum");
		Artiste art = getArtiste(liste, codeArtiste);
		//logger.debug(art.toString());
		Set<Album> albums = art.getAlbums();
		Album res = new Album();
		//logger.info("Code album a trouver "+ codeAlbum);
		for(Album a : albums){
		//	logger.info("Code album liste "+ a.getCodeAlbum());
			
			if(a.getCodeAlbum().equals(codeAlbum))
				res = a;
			break;
		}
	//	logger.info("Album found "+ res.getNom());
		return res;

	}

	//TODO : ecrire le unit test
	private boolean albumExistant(List<Artiste> liste, Integer codeArtiste, Integer codeAlbum) {

		Artiste art = getArtiste(liste, codeArtiste);

		Set<Album> albums = art.getAlbums();
		boolean res=false;

		for(Album a : albums){
			if(a.getCodeAlbum().equals(codeAlbum))
				res=true;
		}
		return res;

	}


	//TODO : ecrire le unit test
	private boolean artisteExistant(List<Artiste> liste, Integer codeArtiste) {
		boolean res=false;
		for(Artiste arti : liste){
			if(arti.getCodeArtiste().equals(codeArtiste))
				res=true;
		}
		return res;
	}

}
