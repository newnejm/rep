package com.yesserp.sessionbean.pg.gestionUO;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.pg.Societe;
import com.yesserp.domain.pg.Unite_organisationnelle;


@Local
public interface GestionUOLocal {
	
	
	


	public void ajouterUnite_organisationnelle(Unite_organisationnelle i);
	public void supprimerUnite_organisationnelle(Unite_organisationnelle i);
	public void modifierUnite_organisationnelle(Unite_organisationnelle i);
	public List<Unite_organisationnelle> AfficherTousUnite_organisationnelle();
	List<Unite_organisationnelle> findUnite_organisationnelleBySociete(Societe societe);
	

	/*
	public List<Unite_organisationnelle> trouverParNumUnite_organisationnelle(String numUnite_organisationnelle);
	public List<Unite_organisationnelle> trouverParNom(String nom);
	
	
	*/
	

}
