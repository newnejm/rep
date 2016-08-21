package com.yesserp.sessionbean.pg.gestionMotifDentree;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.MotifDentree;



@Local
public interface GestionMotifDentreeLocal {
	
	
	public void ajouterMotifDentree(MotifDentree i);
	public void supprimerMotifDentree(MotifDentree i);
	public void modifierMotifDentree(MotifDentree i);
	public List<MotifDentree> AfficherTousMotifDentree();
	
/*
	
	public List<MotifDentree> trouverParNumMotifDentree(String numMotifDentree);
	public List<MotifDentree> trouverParNom(String nom);
	*/
	

	

}
