package com.yesserp.sessionbean.pg.gestionSexe;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.Sexe;



@Local
public interface GestionSexeLocal {
	
	
	public void ajouterSexe(Sexe i);
	public void supprimerSexe(Sexe i);
	public void modifierSexe(Sexe i);
	public List<Sexe> AfficherTousSexe();
	
/*
	
	public List<Sexe> trouverParNumSexe(String numSexe);
	public List<Sexe> trouverParNom(String nom);
	*/
	

	

}
