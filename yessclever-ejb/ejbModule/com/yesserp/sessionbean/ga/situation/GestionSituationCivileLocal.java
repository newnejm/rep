package com.yesserp.sessionbean.ga.situation;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.SituationCivile;

@Local
public interface GestionSituationCivileLocal {

	public void ajouterSituationCivile(SituationCivile situationCivile);

	public void supprimerSituationCivile(SituationCivile situationCivile);

	public void modifierSituationCivile(SituationCivile situationCivile);

	public SituationCivile trouverParId(Long id);

	public SituationCivile trouverSituationCivileActiveParIdentite(Identite identite);
	
	public SituationCivile trouverDerniereSituationCivileParIdentite(Identite identite);
	
	public List<SituationCivile> trouverPremieresHSituationCivileParIdentite(Identite identite, int n);
	
	public SituationCivile trouverPremiereSituationCivileParIdentite(Identite identite);


	public List<SituationCivile> trouverHistoriqueSituationsCivilesParIdentite(
			Identite identite, int n);

	public Long trouverNombreOccurrencesParIdentite(Identite identite);
	
	public List<SituationCivile> trouverPrecedentsHSituationCivileParIdentiteEtDateMax(
			Identite identite, Date max, int n);

	public SituationCivile trouverPrecedentSituationCivileParIdentite(
			Identite identite, Date max);

	public List<SituationCivile> trouverSuivantsHSituationCivileParIdentiteEtDateMin(
			Identite identite, Date min, int n);
	
	public SituationCivile trouverSuivantSituationCivileParIdentite(
			Identite identite, Date min);

}
