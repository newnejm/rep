package com.yesserp.sessionbean.paramgta.gestionPlageHoraire2;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.DescJourneeType;
import com.yesserp.domain.gtaparam.DescJourneeType2;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.JourneeType2;
import com.yesserp.domain.gtaparam.PlageHoraire;
import com.yesserp.domain.gtaparam.PlageHoraire2;
import com.yesserp.domain.gtaparam.PlageHoraireDescJourneeType;
import com.yesserp.domain.gtaparam.PlageHoraireDescJourneeType2;



@Local
public interface GestionPlageHoraire2Local {
	
	public void ajouterPlageHoraire2(PlageHoraire2 plageHoraire2);

	public void supprimerPlageHoraire2(PlageHoraire2 plageHoraire2);

	public void modifierPlageHoraire2(PlageHoraire2 plageHoraire2);

	public List<PlageHoraire2> listerPlageHoraire2();

	public PlageHoraire2 findPlageHoraire2ById(int idPlageHoraire2);

	public PlageHoraire2 findPlageHoraire2ByCode(String code);

	public List<PlageHoraire2> findAllPlagesHoraire2ForJourneeType2(
			JourneeType2 journeeType2);
	public List<PlageHoraire2> findAllPlagesHoraire2();

	public int trouverHeureDeb(PlageHoraire2 plageHoraire2,JourneeType2 journeeType2);
	public int trouverHeureFin(PlageHoraire2 plageHoraire2,JourneeType2 journeeType2);
	public List<PlageHoraire2> findPlageHoraireByDescJourneeType2(DescJourneeType2 descJourneeType2);

	List<PlageHoraireDescJourneeType2> findPlageHoraireDescJourneeType2(
			DescJourneeType2 descJourneeType2);
	
	
	

}
