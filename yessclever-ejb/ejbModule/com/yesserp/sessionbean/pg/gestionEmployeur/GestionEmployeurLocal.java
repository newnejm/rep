package com.yesserp.sessionbean.pg.gestionEmployeur;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.Employeur;



@Local
public interface GestionEmployeurLocal {
	
	
	public void ajouterEmployeur(Employeur i);
	public void supprimerEmployeur(Employeur i);
	public void modifierEmployeur(Employeur i);
	public List<Employeur> AfficherTousEmployeur();
	
/*
	
	public List<Employeur> trouverParNumEmployeur(String numEmployeur);
	public List<Employeur> trouverParNom(String nom);
	*/
	

	

}
