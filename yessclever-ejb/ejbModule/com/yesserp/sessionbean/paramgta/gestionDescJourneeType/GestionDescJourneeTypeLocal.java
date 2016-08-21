package com.yesserp.sessionbean.paramgta.gestionDescJourneeType;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.DescJourneeType;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.PlageHoraire;
import com.yesserp.domain.gtaparam.RefAbscence;




@Local
public interface GestionDescJourneeTypeLocal {
	
	
	public void ajouterDescJourneeType(DescJourneeType i);
	public void supprimerDescJourneeType(DescJourneeType i);
	public void modifierDescJourneeType(DescJourneeType i);
	public List<DescJourneeType> AfficherTousDescJourneeType();
	public void associatePlageHoraireToDescJourneeType(Integer descJt, PlageHoraire plageHoraire, Date heure);
	public void associateRefAbscenceToDescJourneeType(Integer descJt,
			RefAbscence refAbscence, Date heure);
	public List<DescJourneeType> getDescJourneeTypesByJourneeType(
			JourneeType journeeType);
	void updatePlageHoraireDescJourneeType(PlageHoraire oldPlageHoraire, DescJourneeType oldDescJourneeType, PlageHoraire plageHoraire, Date heure);
	
/*
	
	public List<DescJourneeType> trouverParNumDescJourneeType(String numDescJourneeType);
	public List<DescJourneeType> trouverParNom(String nom);
	*/
	

	

}
