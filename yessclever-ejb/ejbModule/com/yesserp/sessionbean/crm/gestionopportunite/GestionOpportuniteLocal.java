package com.yesserp.sessionbean.crm.gestionopportunite;


import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.crm.*;

@Local
public interface GestionOpportuniteLocal {

	public void ajouterOpportunite(Opportunite i);
	public void supprimerOpportunite(Opportunite i);
	public void modifierOpportunite(Opportunite i);
	public List<Opportunite> AfficherTousOpportunite();


	
	
	public List<Opportunite> trouverParNom(String nomopp);
	public List<Opportunite> trouverParType(String type);
	public List<Opportunite> trouverParDate(Date date);
	
	public List<Opportunite> trouverParCompte(Compte Compte);
	
	public List<Compte> getListeComptes();
	public Compagne ChercherCompagne(String nom);
	public List<Compagne> getListeCompagnes();

	
	
}
