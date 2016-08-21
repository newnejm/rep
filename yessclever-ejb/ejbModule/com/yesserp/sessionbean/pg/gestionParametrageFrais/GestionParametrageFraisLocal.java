package com.yesserp.sessionbean.pg.gestionParametrageFrais;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.ParametrageFrais;



@Local
public interface GestionParametrageFraisLocal {
	
	
	public void ajouterParametrageFrais(ParametrageFrais i);
	public void supprimerParametrageFrais(ParametrageFrais i);
	public void modifierParametrageFrais(ParametrageFrais i);
	public List<ParametrageFrais> AfficherTousParametrageFrais();
	
/*
	
	public List<ParametrageFrais> trouverParNumParametrageFrais(String numParametrageFrais);
	public List<ParametrageFrais> trouverParNom(String nom);
	*/
	

	

}
