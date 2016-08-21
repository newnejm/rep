package com.yesserp.sessionbean.pg.gestionParametres_fiscal;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.Parametres_fiscal;



@Local
public interface GestionParametres_fiscalLocal {
	
	
	public void ajouterParametres_fiscal(Parametres_fiscal i);
	public void supprimerParametres_fiscal(Parametres_fiscal i);
	public void modifierParametres_fiscal(Parametres_fiscal i);
	public List<Parametres_fiscal> AfficherTousParametres_fiscal();
	
/*
	
	public List<Parametres_fiscal> trouverParNumParametres_fiscal(String numParametres_fiscal);
	public List<Parametres_fiscal> trouverParNom(String nom);
	*/
	

	

}
