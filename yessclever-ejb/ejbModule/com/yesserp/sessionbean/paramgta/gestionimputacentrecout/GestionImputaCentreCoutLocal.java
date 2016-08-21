package com.yesserp.sessionbean.paramgta.gestionimputacentrecout;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.ImputaCentreCout;

@Local
public interface GestionImputaCentreCoutLocal {
	public void ajouterCentreCout(ImputaCentreCout imputaCentreCout);
	
	public void modifierCentreCout(ImputaCentreCout imputaCentreCout);
	
	public void supprimerCentreCout(ImputaCentreCout imputaCentreCout);
	
	public ImputaCentreCout findByCode(String code);
	
	public List<ImputaCentreCout> findAll();
}
