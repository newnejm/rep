package com.yesserp.sessionbean.crm.gestiondocumentcompte;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.crm.DocumentCompte;

@Local
public interface GestionDocumentCompteLocal {

	public void ajouterDocumentCompte(DocumentCompte i);

	public void supprimerDocumentCompte(DocumentCompte i);

	public void modifierDocumentCompte(DocumentCompte i);

	public List<DocumentCompte> AfficherTousDocumentCompte();

	public DocumentCompte trouverParNom(String nom);

	public DocumentCompte findById(int id);

}
