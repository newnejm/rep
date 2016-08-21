package com.yesserp.sessionbean.crm.gestiondocumentfournisseur;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.crm.DocumentFournisseur;;

@Local
public interface GestionDocumentFournisseurLocal {
	
	public void ajouterDocumentFournisseur(DocumentFournisseur i);

	public void supprimerDocumentFournisseur(DocumentFournisseur i);

	public void modifierDocumentFournisseur(DocumentFournisseur i);

	public List<DocumentFournisseur> AfficherTousDocumentFournisseur();

	
	public DocumentFournisseur trouverParNom(String nom);

	public DocumentFournisseur findById(int id);


}
