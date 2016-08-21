package com.yesserp.sessionbean.pg.gestionParametrageGTA;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.ParametrageGTA;



@Local
public interface GestionParametrageGTALocal {
	
	
	public void ajouterParametrageGTA(ParametrageGTA i);
	public void supprimerParametrageGTA(ParametrageGTA i);
	public void modifierParametrageGTA(ParametrageGTA i);
	public List<ParametrageGTA> AfficherTousParametrageGTA();
	
/*
	
	public List<ParametrageGTA> trouverParNumParametrageGTA(String numParametrageGTA);
	public List<ParametrageGTA> trouverParNom(String nom);
	*/
	

	

}
