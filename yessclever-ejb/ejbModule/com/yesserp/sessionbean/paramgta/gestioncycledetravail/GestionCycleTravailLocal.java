package com.yesserp.sessionbean.paramgta.gestioncycledetravail;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gtaparam.*;

@Local
public interface GestionCycleTravailLocal {
	public void ajoutCycleTravail(CycleTravail cycleTravail);
	public void supprimerCycleTravail(CycleTravail cycleTravail);
	public void modifierCycleTravail(CycleTravail cycleTravail);
	public List<CycleTravail> listerCycleTravail();
	public CycleTravail findCycleTravailById(int idCycleTravail);
	public CycleTravail findCycleDeTravailParCode(String code);
	public void affectcycledeTravailTojourneetype(CycleTravail cycleTravail,List<JourneeType> journeeTypes);
	public void affectCycleToSemaineType(CycleTravail cycleTravail,List<SemaineType> semaineTypes);
	
	
	//affectCycleTravailto employee
	void affectCycleToEmployee(Identite identite, CycleTravail cycleTravailGTA,		Date date);
	
	public List<CycleTravail> trouverCycleAffectePourEmployee(Identite identite);
	public List<JourneeType> findJourneesForCycle(CycleTravail cycleTravail);
	public void associateCycleTravailToJourneeType(int idct,
			List<JourneeType> journeeTypes, List<Integer> ordreJours);
	public List<CycleTravail> findCycleTravailByType(String type);

}
