package com.yesserp.sessionbean.pg.gestionCategorie;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.Categorie;



@Local
public interface GestionCategorieLocal {
	
	
	public void ajouterCategorie(Categorie i);
	public void supprimerCategorie(Categorie i);
	public void modifierCategorie(Categorie i);
	public List<Categorie> AfficherTousCategorie();
	
/*
	
	public List<Categorie> trouverParNumCategorie(String numCategorie);
	public List<Categorie> trouverParNom(String nom);
	*/
	

	

}
