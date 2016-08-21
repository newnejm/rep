package com.yesserp.sessionbean.pg.gestionParametres_system;


import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.pg.Parametres_system;


@Local
public interface GestionParametres_systemLocal {
	
	
	


	public void ajouterParametres_system(Parametres_system i);
	public void supprimerParametres_system(Parametres_system i);
	public void modifierParametres_system(Parametres_system i);
	public List<Parametres_system> AfficherTousParametres_system();
	

	/*
	public List<Parametres_system> trouverParNumParametres_system(String numParametres_system);
	public List<Parametres_system> trouverParNom(String nom);
	
	
	*/
	

}
