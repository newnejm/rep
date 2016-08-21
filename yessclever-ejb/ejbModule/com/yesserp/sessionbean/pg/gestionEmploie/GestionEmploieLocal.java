package com.yesserp.sessionbean.pg.gestionEmploie;

import java.util.List;

import javax.ejb.Local;


import com.yesserp.domain.pg.Emploie;




@Local
public interface GestionEmploieLocal {
	
	
	

	public void ajouterEmploie(Emploie i);
	public void supprimerEmploie(Emploie i);
	public void modifierEmploie(Emploie i);
		public List<Emploie> AfficherTousEmploie();

/*
	
	public List<Emploie> trouverParNumEmploie(String numEmploie);
	public List<Emploie> trouverParNom(String nom);
	
	
	*/
	

	
	
	
	
	
	
	
	
	
	
	
	

}
