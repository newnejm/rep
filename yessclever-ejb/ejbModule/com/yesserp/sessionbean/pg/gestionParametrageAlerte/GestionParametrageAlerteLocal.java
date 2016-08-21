package com.yesserp.sessionbean.pg.gestionParametrageAlerte;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.ActivitePresence;
import com.yesserp.domain.pg.ParametrageAlerte;



@Local
public interface GestionParametrageAlerteLocal {
	
	
	public void ajouterParametrageAlerte(ParametrageAlerte i);
	public void supprimerParametrageAlerte(ParametrageAlerte i);
	public void modifierParametrageAlerte(ParametrageAlerte i);
	public List<ParametrageAlerte> AfficherTousParametrageAlerte();	
	public ParametrageAlerte findParametrageAlerteByCode(String code);
/*
	
	public List<ParametrageAlerte> trouverParNumParametrageAlerte(String numParametrageAlerte);
	public List<ParametrageAlerte> trouverParNom(String nom);
	*/
	

	

}
