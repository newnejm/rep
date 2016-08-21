package com.yesserp.sessionbean.pg.gestionQualite;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.Qualite;



@Local
public interface GestionQualiteLocal {
	
	
	public void ajouterQualite(Qualite i);
	public void supprimerQualite(Qualite i);
	public void modifierQualite(Qualite i);
	public List<Qualite> AfficherTousQualite();
	
/*
	
	public List<Qualite> trouverParNumQualite(String numQualite);
	public List<Qualite> trouverParNom(String nom);
	*/
	

	

}
