package com.yesserp.sessionbean.paramgta.gestionimputacompte;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.ImputaCompte;

@Local
public interface GestionImputaCompteLocal {
	public void ajouterCompte(ImputaCompte imputaCompte);

	public void modifierCompte(ImputaCompte imputaCompte);

	public void supprimerCompte(ImputaCompte imputaCompte);

	public ImputaCompte findByCode(String code);

	public List<ImputaCompte> findAll();
}
