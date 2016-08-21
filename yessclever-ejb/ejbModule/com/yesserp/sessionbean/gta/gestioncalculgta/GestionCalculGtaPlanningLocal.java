package com.yesserp.sessionbean.gta.gestioncalculgta;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.CalculGta;
import com.yesserp.domain.gtaparam.JourneeType;

@Local
public interface GestionCalculGtaPlanningLocal {
	public void ajouterPlanning(CalculGta calculGta);
	public void supprimerPlanningTheorique();
	public List<CalculGta> trouverPlanningPourEmployee(Identite identite);
	public JourneeType trouverJourneeParDate(Date date);

}
