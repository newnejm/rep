package com.yesserp.sessionbean.pg.gestionTel;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.Tel;



@Local
public interface GestionTelLocal {
	
	
	public void ajouterTel(Tel i);
	public void supprimerTel(Tel i);
	public void modifierTel(Tel i);
	public List<Tel> AfficherTousTel();
	
/*
	
	public List<Tel> trouverParNumTel(String numTel);
	public List<Tel> trouverParNom(String nom);
	*/
	

	

}
