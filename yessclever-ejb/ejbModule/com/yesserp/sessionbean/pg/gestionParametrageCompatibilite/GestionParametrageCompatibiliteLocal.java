package com.yesserp.sessionbean.pg.gestionParametrageCompatibilite;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.ParametrageComptabilite;



@Local
public interface GestionParametrageCompatibiliteLocal {
	
	
	public void ajouterParametrageCompatibilite(ParametrageComptabilite i);
	public void supprimerParametrageCompatibilite(ParametrageComptabilite i);
	public void modifierParametrageCompatibilite(ParametrageComptabilite i);
	public List<ParametrageComptabilite> AfficherTousParametrageCompatibilite();
	
/*
	
	public List<ParametrageComptabilite> trouverParNumParametrageCompatibilite(String numParametrageCompatibilite);
	public List<ParametrageComptabilite> trouverParNom(String nom);
	*/
	

	

}
