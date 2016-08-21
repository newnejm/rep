package com.yesserp.sessionbean.gta.gestionplanningtheorique;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.PlanningTheorique;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.PlageHoraire;

@Local
public interface GestionPlanningTheoriqueLocal {

	public void ajouterPlanningTh(PlanningTheorique planningTheorique);
	public void supprimerPlanningTh(PlanningTheorique planningTheorique);
	public void modifierPlanningTh(PlanningTheorique planningTheorique);
	public PlanningTheorique findPlanningThById(int id);
	public List<PlanningTheorique> findAllPlanningThs();
	public List<PlanningTheorique> findLastOne(Identite identite);
	public List<PlageHoraire> findPlageHorairessByJourneeType(JourneeType journeeType);
	public int findHeureDebutForPlageEtJournee(int idPlage,int idJournee);
	
}
