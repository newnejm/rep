package com.yesserp.sessionbean.ga.cycle;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Cycle;
import com.yesserp.domain.ga.Identite;

@Local
public interface GestionCycleLocal {

	public void ajouterCycle(Cycle cycle);

	public void supprimerCycle(Cycle cycle);

	public void modifierCycle(Cycle cycle);

	public Cycle trouverParId(Long id);

	public Cycle trouverCycleParIdentite(Identite identite);

	public List<Cycle> trouverHistoriqueCyclesParIdentite(Identite identite,
			int n);

	public Long trouverNombreOccurrencesParIdentite(Identite identite);

	public Cycle trouverPrecedentCycleParIdentite(Identite identite, Date max);

	public Cycle trouverSuivantCycleParIdentite(Identite identite, Date min);
}
