package org.jacademie.dbupdate.parser;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.jacademie.domain.Album;
import org.jacademie.domain.Artiste;
import org.jacademie.domain.Chanson;


public class ParserImpl implements Parser{
	private static Logger logger = Logger.getLogger(TestParser.class);



	@Override
	public Set<Artiste> parser(String texte) {
		Set<Artiste> resultat = new HashSet<>();	

		Set<String> lignes = decomposerLignes(texte);

		for(String l : lignes){
			majResultat(resultat, l);
		}

		return resultat;
	}


	public Set<String> decomposerLignes(String texte){
		Set<String> lignes = new HashSet<String>();

		int index = 0;

		int fin = texte.indexOf("\n", index);

		logger.debug(fin);

		while(fin != -1){
			String ligne = texte.substring(index,fin);


			logger.debug(ligne);

			if(ligne!=null){
				lignes.add(ligne);
			}

			index=fin+1;
			logger.debug("index :" +index);
			fin = texte.indexOf("\n", index);
			logger.debug("fin :" +fin);
		}

		return lignes;
	}


	public void majResultat(Set<Artiste> liste, String ligne){
		int index = 0;
		int cursor = ligne.indexOf(",",index);

		Integer codeArtiste = Integer.valueOf(ligne.substring(index, cursor));

		index = cursor+1;
		cursor = ligne.indexOf(",",index);
		String nomArtiste = ligne.substring(index, cursor);

		index = cursor+1;
		cursor = ligne.indexOf(",",index);
		Integer codeAlbum = Integer.valueOf(ligne.substring(index, cursor));

		index = cursor+1;
		cursor = ligne.indexOf(",",index);
		String nomAlbum = ligne.substring(index, cursor);

		index = cursor+1;
		cursor = ligne.indexOf(",",index);
		Integer numeroChanson = Integer.valueOf(ligne.substring(index, cursor));

		index = cursor+1;
		cursor = ligne.indexOf(",",index);
		String titreChanson = ligne.substring(index, cursor);

		index = cursor+1;
		cursor = ligne.indexOf(",",index);
		Integer dureeChanson = Integer.valueOf(ligne.substring(index, cursor));

		inserer(liste,codeArtiste,nomArtiste,codeAlbum,nomAlbum,numeroChanson,titreChanson,dureeChanson);

	}


	private void inserer(Set<Artiste> liste, Integer codeArtiste,
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
			alb.addChanson(ch);
			alb.setArtiste(art);
			art.addAlbum(alb);

			liste.add(art);
		}

		else if(!albumExistant(liste, codeArtiste, codeAlbum)){

		}

	}

	private boolean albumExistant(Set<Artiste> liste, Integer codeArtiste, Integer codeAlbum) {
		Artiste art = new Artiste();
		
		for(Artiste artiste : liste){
			if(artiste.getCodeArtiste().equals(codeArtiste))
			{
				art=artiste;
				break;
			}
		}
			
		Set<Album> albums = art.getAlbums();
		
		
		
		return false;
	}


	//TODO : ecrire le unit test
	private boolean artisteExistant(Set<Artiste> liste, Integer codeArtiste) {
		boolean res=false;
		for(Artiste arti : liste){
			if(arti.getCodeArtiste().equals(codeArtiste))
				res=true;
		}
		return res;
	}

}
