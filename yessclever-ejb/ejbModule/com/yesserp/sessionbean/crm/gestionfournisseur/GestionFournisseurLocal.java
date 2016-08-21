package com.yesserp.sessionbean.crm.gestionfournisseur;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.crm.ContactFournisseur;
import com.yesserp.domain.crm.CordonneeFournisseur;
import com.yesserp.domain.crm.Fournisseur;

@Local
public interface GestionFournisseurLocal {

	public void ajouterFournisseur(Fournisseur i);
	public void supprimerFournisseur(Fournisseur i);
	public void modifierFournisseur(Fournisseur i);
	
	public List<Fournisseur> AfficherTousFournisseur();


	
	
	public List<Fournisseur> trouverParNom(String nom);
	public List<Fournisseur> trouverParPrenom(String Prenom);
	public List<Fournisseur> trouverParMatfiscal(String matfiscal);
	public void ajouterCordonne(CordonneeFournisseur i);
	
	public void modifierCordonneeFournisseur(CordonneeFournisseur i);
	public void supprimerCordonneeFournisseur(CordonneeFournisseur i);
	public Fournisseur chercherFournisseur(String nom);
	public CordonneeFournisseur FindOneCordoneeByFournisseur(Fournisseur Fournisseur);
	public List<CordonneeFournisseur> FindCordoneeByFournisseur(Fournisseur Fournisseur);
	public List<ContactFournisseur> FindContactsByFournisseur(Fournisseur Fournisseur);
	
	
}
