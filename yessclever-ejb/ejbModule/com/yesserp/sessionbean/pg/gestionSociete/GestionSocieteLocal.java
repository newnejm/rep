package com.yesserp.sessionbean.pg.gestionSociete;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.Societe;



@Local
public interface GestionSocieteLocal {
	
	
	public void ajouterSociete(Societe i);
	public void supprimerSociete(Societe i);
	public void modifierSociete(Societe i);
	public List<Societe> AfficherTousSociete();
	
/*
	
	public List<Societe> trouverParNumSociete(String numSociete);
	public List<Societe> trouverParNom(String nom);
	*/
	

	

}
