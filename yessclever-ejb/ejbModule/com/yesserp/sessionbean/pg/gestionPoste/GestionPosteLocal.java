package com.yesserp.sessionbean.pg.gestionPoste;

import java.util.List;







import javax.ejb.Local;


import com.yesserp.domain.pg.Poste;




@Local
public interface GestionPosteLocal {

	

	public void ajouterPoste(Poste i);
	public void supprimerPoste(Poste i);
	public void modifierPoste(Poste i);
	public List<Poste> AfficherTousPoste();
	/*

	
	public List<Poste> trouverParNumPoste(String numPoste);
	public List<Poste> trouverParNom(String nom);
	
	
	
	*/
	
	
	
	
	
}
