package com.yesserp.sessionbean.pg.gestionMotifDinvalidite;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.MotifDinvalidite;



@Local
public interface GestionMotifDinvaliditeLocal {
	
	
	public void ajouterMotifDinvalidite(MotifDinvalidite i);
	public void supprimerMotifDinvalidite(MotifDinvalidite i);
	public void modifierMotifDinvalidite(MotifDinvalidite i);
	public List<MotifDinvalidite> AfficherTousMotifDinvalidite();
	
/*
	
	public List<MotifDinvalidite> trouverParNumMotifDinvalidite(String numMotifDinvalidite);
	public List<MotifDinvalidite> trouverParNom(String nom);
	*/
	

	

}
