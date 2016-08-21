package com.yesserp.sessionbean.gta.gestiondatejournees;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gta.DateCalculGta;
import com.yesserp.domain.gta.PlanningTheorique;

@Local
public interface GestionDateJourneesLocal {
	public void ajouter(DateCalculGta dateJournees);

	public void supprimer(DateCalculGta dateJournees);

	public void modifier(DateCalculGta dateJournees);

	public DateCalculGta findById(int id);

	public List<DateCalculGta> findAll();

	public List<DateCalculGta> findDatesByPlanning(
			PlanningTheorique planningTheorique);

	public List<DateCalculGta> calculerPlanningEntre2Dates(Date dateDebut,
			Date dateFin, PlanningTheorique planningTheorique);

}
