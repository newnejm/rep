package com.yesserp.sessionbean.crm.gestioncontact;


import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.crm.*;

@Local
public interface GestionContactCompteLocal {

	public void ajouterContactCompte(ContactCompte i);

	public void ajouterCordonneeContactCompte(CordonneeContactCompte i);

	public void supprimerContactCompte(ContactCompte i);

	public void supprimerCordonneeContactCompte(CordonneeContactCompte i);

	public void modifierContactCompte(ContactCompte i);

	public void modifierCordonneeContactCompte(CordonneeContactCompte i);

	public void ajouterContactCompteCordonnee(ContactCompte Contact,
			CordonneeContactCompte CordonneeContact, Compte Compte);

	public List<ContactCompte> AfficherTousContactCompte();

	public List<ContactCompte> trouverParCompte(Compte compte);

	public List<ContactCompte> trouverParNom(String nom);

	public List<ContactCompte> trouverParPrenom(String prenom);

	public List<Compte> getListeComptes();

	public Compte ChercherCompte(String nomcompt);

	public List<CordonneeContactCompte> FindCordoneeByContactCompte(ContactCompte Contact);

	public CordonneeContactCompte FindOneCordoneeByContactCompte(ContactCompte Contact);

	
	
	
}
