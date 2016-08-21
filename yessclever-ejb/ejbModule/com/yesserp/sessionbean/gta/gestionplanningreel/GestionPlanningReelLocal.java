package com.yesserp.sessionbean.gta.gestionplanningreel;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.PlanningReel;

@Local
public interface GestionPlanningReelLocal {
 public void AjouterPlaningReel(PlanningReel planingReel);
	public List<PlanningReel> findByDate(Identite identite, Date date);

	public List<PlanningReel> findFromDateToDate(Identite identite,
			Date dateDeb, Date dateFin);

	public List<PlanningReel> findAll(Identite identite);

	public int findNumberOfSlices(Identite identite, Date date);
	

}
