package com.yesserp.sessionbean.crm.gestiondossierdocument;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.crm.DossierDocument;

@Local
public interface GestionDossierDocumentLocal {

	public void ajouterDossierDocument(DossierDocument i);

	public void supprimerDossierDocument(DossierDocument i);

	public void modifierDossierDocument(DossierDocument i);

	public List<DossierDocument> AfficherTousDossierDocument();

	public List<DossierDocument> trouverParNom(String nom);

	public DossierDocument chercherDossierDocument(String nom);

}
