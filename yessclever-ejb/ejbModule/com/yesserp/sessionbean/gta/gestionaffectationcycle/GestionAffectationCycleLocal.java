package com.yesserp.sessionbean.gta.gestionaffectationcycle;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.AffectationCycle;
import com.yesserp.domain.gtaparam.CycleTravail;

@Local
public interface GestionAffectationCycleLocal {
	
	
	public void supprimerAffectationCycleTravail(AffectationCycle affectationCycle );
	public CycleTravail findAffectationCycleForEmployeeEtCycle(Date date, Identite identite);
	public List<Date> trouverDatesChangementDeCycle(Identite identite);
	public List<Date> trouverDateDecycle(Identite identite,CycleTravail cycleTravail);
	public void modifierAffectationCycledeTravail(AffectationCycle affectationCycle);

}
