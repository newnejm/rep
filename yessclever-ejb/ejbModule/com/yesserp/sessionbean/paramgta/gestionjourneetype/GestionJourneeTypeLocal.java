package com.yesserp.sessionbean.paramgta.gestionjourneetype;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.CycleTravail;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.PlageHAssociateJourneeTPK;
import com.yesserp.domain.gtaparam.PlageHoraire;
import com.yesserp.domain.gtaparam.PlageHoraireAssociateJourneeType;
import com.yesserp.domain.gtaparam.SemaineType;

@Local
public interface GestionJourneeTypeLocal {
	public void ajoutJourneeType(JourneeType journeeType);

	public void supprimerJourneeType(JourneeType journeeType);

	public void modifierJourneeType(JourneeType journeeType);

	public List<JourneeType> listerJourneeType();

	public JourneeType findJourneeTypeById(int idJourneeType);

	public JourneeType findJourneeTypeByCode(String code);
	
	public void associatePlageHoraireToJourneeType(int jt, List<PlageHoraire> plageHoraires, List<Integer> heures);
	
	public List<JourneeType> findJourneesForCycle(CycleTravail cycleTravail);
	
	public List<JourneeType> findJourneesForSemainType(SemaineType semaineType);
	
	public String findLibelle(String code);

	public void associatePlageHoraireToJourneeType(int idjt,
			List<PlageHoraire> plageHoraires, List<Integer> heures,
			List<Integer> heuresFin);
	
	public List<PlageHoraireAssociateJourneeType> findPlageAssociateJtByJt(JourneeType journeeType);
		
	
}
