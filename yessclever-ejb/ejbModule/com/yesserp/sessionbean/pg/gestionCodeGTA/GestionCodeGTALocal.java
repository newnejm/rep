package com.yesserp.sessionbean.pg.gestionCodeGTA;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.CodeGTA;



@Local
public interface GestionCodeGTALocal {
	
	
	public void ajouterCodeGTA(CodeGTA i);
	public void supprimerCodeGTA(CodeGTA i);
	public void modifierCodeGTA(CodeGTA i);
	public List<CodeGTA> AfficherTousCodeGTA();
	
/*
	
	public List<CodeGTA> trouverParNumCodeGTA(String numCodeGTA);
	public List<CodeGTA> trouverParNom(String nom);
	*/
	

	

}
