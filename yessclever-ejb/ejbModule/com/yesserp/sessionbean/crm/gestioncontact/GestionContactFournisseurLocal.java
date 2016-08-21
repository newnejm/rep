package com.yesserp.sessionbean.crm.gestioncontact;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.crm.ContactFournisseur;
import com.yesserp.domain.crm.CordonneeContactFournisseur;
import com.yesserp.domain.crm.Fournisseur;

@Local
public interface GestionContactFournisseurLocal {

	public void ajouterContactFournisseur(ContactFournisseur i);

	public void ajouterCordonneeContactFournisseur(CordonneeContactFournisseur i);

	public void supprimerContactFournisseur(ContactFournisseur i);

	public void supprimerCordonneeContactFournisseur(CordonneeContactFournisseur i);

	public void modifierContactFournisseur(ContactFournisseur i);

	public void modifierCordonneeContactFournisseur(CordonneeContactFournisseur i);

	public void ajouterContactFournisseurCordonnee(ContactFournisseur Contact,
			CordonneeContactFournisseur CordonneeContact,
			Fournisseur Fournisseur);

	public List<ContactFournisseur> AfficherTousContactFournisseur();

	public List<ContactFournisseur> trouverParFournisseur(Fournisseur Fournisseur);

	public List<ContactFournisseur> trouverParNom(String nom);


	public List<Fournisseur> getListeFournisseurs();

	public Fournisseur ChercherFournisseur(String nomcompt);

	public List<CordonneeContactFournisseur> FindCordoneeByContactFournisseur(
			ContactFournisseur Contact);

	public CordonneeContactFournisseur FindOneCordoneeByContactFournisseur(
			ContactFournisseur Contact);

}
