package com.yesserp.sessionbean.pg.gestionParametrageModuleGlobale;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.ParametrageModuleGlobale;



@Local
public interface GestionParametrageModuleGlobaleLocal {
	
	
	public void ajouterParametrageModuleGlobale(ParametrageModuleGlobale i);
	public void supprimerParametrageModuleGlobale(ParametrageModuleGlobale i);
	public void modifierParametrageModuleGlobale(ParametrageModuleGlobale i);
	public List<ParametrageModuleGlobale> AfficherTousParametrageModuleGlobale();
	
/*
	
	public List<ParametrageModuleGlobale> trouverParNumParametrageModuleGlobale(String numParametrageModuleGlobale);
	public List<ParametrageModuleGlobale> trouverParNom(String nom);
	*/
	

	

}
