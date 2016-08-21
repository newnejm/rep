package com.yesserp.sessionbean.paramgta.gestionimputasouscompte;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.ImputaSousCompte;

@Local
public interface GestionImputaSousCompteLocal {
	public void ajouterSousCompte(ImputaSousCompte imputaSousCompte);

	public void modifierSousCompte(ImputaSousCompte imputaSousCompte);

	public void supprimerSousCompte(ImputaSousCompte imputaSousCompte);

	public ImputaSousCompte findByCode(String code);

	public List<ImputaSousCompte> findAll();
}
