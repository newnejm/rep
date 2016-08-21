package com.yesserp.sessionbean.ga.situationmedicale;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.SituationMedicale;

@Local
public interface GestionSituationMedicaleLocal {

	public void ajouterSituationMedicale(SituationMedicale situationMedicale);

	public void supprimerSituationMedicale(SituationMedicale situationMedicale);

	public void modifierSituationMedicale(SituationMedicale situationMedicale);

	public SituationMedicale trouverParId(Long id);

	public List<SituationMedicale> trouverSituationsMedicalesActivesParIdentite(
			Identite identite);

	public List<SituationMedicale> trouverHistoriqueSituationsMedicalesParIdentite(
			Identite identite, int n);

	public List<SituationMedicale> trouverHistoriqueSituationMedicalesParIdentiteEtDateMin(
			Identite identite, Date min, int n);

	public List<SituationMedicale> trouverPremiersHistoriqueSituationMedicalesParIdentiteEtDateMin(
			Identite identite, Date min, int n);

	public List<SituationMedicale> trouverHistoriqueSituationMedicalesParIdentiteEtDateMax(
			Identite identite, Date max, int n);

	public List<SituationMedicale> trouverHistoriqueSituationMedicalesParIdentiteEtDateMinMax(
			Identite identite, Date min, Date max, int n);

	public Long trouverNombreOccurrencesParIdentite(Identite identite);

	public Long trouverNombreOccurrencesActivesParIdentite(Identite identite);

	public List<SituationMedicale> trouverPremiersHistoriqueSituationsMedicalesParIdentite(
			Identite identite, int n);

}
