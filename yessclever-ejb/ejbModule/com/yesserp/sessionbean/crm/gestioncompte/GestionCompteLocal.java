package com.yesserp.sessionbean.crm.gestioncompte;


import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.crm.*;

@Local
public interface GestionCompteLocal {

	
	public void ajouterCompte(Compte i);
	public void ajouterTravailInterne(TravailInterne i);

	
	public void supprimerCompte(Compte i);
	public void modifierCompte(Compte i);
	public List<Compte> AfficherTousCompte();
	public void ajouterCompteCordonnee(Compte Compte, Facture Facture) ;
	
	public void ajouterCompteType( Compte Compte, TypeCompte TypeCompte);

	
	public List<Compte> trouverParNumcompt(String numcompt);
	public List<Compte> trouverParNom(String nom);
	public List<Compte> trouverParMatFiscal(String MatFiscal);
	
	public List<TypeCompte> getType();
	
	public TypeCompte findTypeCompteById(int id);
	
	public List<Origine> getListeTypeTravailInt() ;
	
	public Origine ChercherTypeTravailInterne(String nom);
	
	public TypeCompte ChercherTypeCompte(String type);
	public CommercialInterne findById(Long i);
	public void ajouterCordonneeCompte(CordonneeCompte i);
	public CordonneeCompte FindOneCordoneeByCompte(Compte Compte);
	void supprimerCordonneeCompte(CordonneeCompte i);
	void modifierCordonneeCompte(CordonneeCompte i);
	public List<CordonneeCompte> FindCordoneeByCompte(Compte Compte);
	public List<ContactCompte> FindContactsByCompte(Compte Compte);
	public List<Opportunite> FindOpportunitesByCompte(Compte Compte);
	public void ajouterTypeCompte(TypeCompte i);
	public Taux ChercherTaux(int type);
	public TypeTaxe ChercherTypeTaxe(String type);
	public List<Taux> AfficherTousTaux();
	public void ajouterTauxCompte(TauxCompte i);
	public Taux ChercherTauxFodec(int nom);
	public Taux ChercherTauxTVA(int nom);
	public Taux ChercherTauxRetenu(int nom);
}
