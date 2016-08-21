package com.yesserp.sessionbean.pg.gestionTypeTel;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.TypeTel;



@Local
public interface GestionTypeTelLocal {
	
	
	public void ajouterTypeTel(TypeTel i);
	public void supprimerTypeTel(TypeTel i);
	public void modifierTypeTel(TypeTel i);
	public List<TypeTel> AfficherTousTypeTel();
	
/*
	
	public List<TypeTel> trouverParNumTypeTel(String numTypeTel);
	public List<TypeTel> trouverParNom(String nom);
	*/
	

	

}
