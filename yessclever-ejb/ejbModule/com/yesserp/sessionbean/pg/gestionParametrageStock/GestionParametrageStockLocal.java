package com.yesserp.sessionbean.pg.gestionParametrageStock;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.ParametrageStock;



@Local
public interface GestionParametrageStockLocal {
	
	
	public void ajouterParametrageStock(ParametrageStock i);
	public void supprimerParametrageStock(ParametrageStock i);
	public void modifierParametrageStock(ParametrageStock i);
	public List<ParametrageStock> AfficherTousParametrageStock();
	
/*
	
	public List<ParametrageStock> trouverParNumParametrageStock(String numParametrageStock);
	public List<ParametrageStock> trouverParNom(String nom);
	*/
	

	

}
