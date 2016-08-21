package com.yesserp.sessionbean.paramgta.gestionimputacodefacturation;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.ImputaCodeFact;

@Local
public interface GestionImputaCodeFacturationLocal {
	public void ajouterCodeFacturation(ImputaCodeFact imputaCodeFact);

	public void modifierCodeFacturation(ImputaCodeFact imputaCodeFact);

	public void supprimerCodeFacturation(ImputaCodeFact imputaCodeFact);

	public ImputaCodeFact findByCode(String code);

	public List<ImputaCodeFact> findAll();
}
