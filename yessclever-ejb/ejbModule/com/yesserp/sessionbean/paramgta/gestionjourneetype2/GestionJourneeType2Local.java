package com.yesserp.sessionbean.paramgta.gestionjourneetype2;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.CycleTravail;
import com.yesserp.domain.gtaparam.JourneeType2;
import com.yesserp.domain.gtaparam.PlageHoraire;
import com.yesserp.domain.gtaparam.PlageHoraire2;
import com.yesserp.domain.gtaparam.PlageHoraireAssociateJourneeType2;
import com.yesserp.domain.gtaparam.SemaineType;


@Local
public interface GestionJourneeType2Local {

	public void ajouterJourneeType(JourneeType2 journeeType2) ;
	public void supprimerJourneeType( JourneeType2  journeeType2 ) ;
	public void modifierJourneeType(JourneeType2 journeeType2   ) ;
	public  List<JourneeType2> listerJourneeType() ;
	public JourneeType2 findJouneeTypeById(int   idJourneeType);
	public JourneeType2 findJourneeTypeByCode(String code ) ;
	public void associatePlageHoraireToJourneeType(int jt , List<PlageHoraire2> plageHoraire2s , List<Integer> heures) ;
	public List<JourneeType2> findJourneesForCycle(CycleTravail cycleTravail ) ;
	
	public List<JourneeType2> findJourneesForSemainType(SemaineType semaineType) ;
	public String findLibelle(String code) ;
	
	public void associatePlageHoraireToJourneeType(int idjt, List<PlageHoraire2> plageHoraire2s, List<Integer> heures , List <Integer> heuresFin ) ;
	public List <PlageHoraireAssociateJourneeType2> findPlageAssociateJTByJt2(JourneeType2 journeeType2) ;
	
	
	
}
