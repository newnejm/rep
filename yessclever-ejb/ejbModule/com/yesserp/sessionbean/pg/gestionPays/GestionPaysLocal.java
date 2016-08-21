package com.yesserp.sessionbean.pg.gestionPays;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.Pays;



@Local
public interface GestionPaysLocal {
	
	
	public void ajouterPays(Pays i);
	public void supprimerPays(Pays i);
	public void modifierPays(Pays i);
	public List<Pays> AfficherTousPays();
	public void RemplireTablePays() ;
	
/*
	
	public List<Pays> trouverParNumPays(String numPays);
	public List<Pays> trouverParNom(String nom);
	*/
	

	

}
