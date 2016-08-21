package com.yesserp.sessionbean.paramgta.gestionRefAbscence;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.DescJourneeType;
import com.yesserp.domain.gtaparam.RefAbscence;



@Local
public interface GestionRefAbscenceLocal {
	
	
	public void ajouterRefAbscence(RefAbscence i);
	public void supprimerRefAbscence(RefAbscence i);
	public void modifierRefAbscence(RefAbscence i);
	public List<RefAbscence> AfficherTousRefAbscence();
	public List<RefAbscence> findRefAbscenceByDescJourneeType(
			DescJourneeType descJourneeType);
	
/*
	
	public List<RefAbscence> trouverParNumRefAbscence(String numRefAbscence);
	public List<RefAbscence> trouverParNom(String nom);
	*/
	

	

}
