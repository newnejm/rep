package com.yesserp.sessionbean.gta.GestionErreur;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gta.Erreur;



@Local
public interface GestionErreurLocal {
	
	public void ajouterErreur(Erreur erreur);
	public void modifierErreur(Erreur erreur);
	public void supprimerErreur(Erreur erreur);
	public Erreur trouverErreurParcode(String code);
	public List<Erreur> findAll();

}
