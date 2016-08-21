package com.yesserp.sessionbean.wkf.demande;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.wkf.Demande;

@Local
public interface GestionDemandeLocal {
	public void ajouterDemande(Demande demande);

	public void supprimerDemande(Demande demande);

	public void modifierDemande(Demande demande);

	public Demande trouverParId(Long id);

}
