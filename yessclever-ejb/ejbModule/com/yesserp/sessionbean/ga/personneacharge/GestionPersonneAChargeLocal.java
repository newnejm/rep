package com.yesserp.sessionbean.ga.personneacharge;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.PersonneACharge;

@Local
public interface GestionPersonneAChargeLocal {

	public void ajouterPersonneACharge(PersonneACharge personneACharge);

	public void supprimerPersonneACharge(PersonneACharge personneACharge);

	public void modifierPersonneACharge(PersonneACharge personneACharge);

	public PersonneACharge trouverParId(Long id);

	public List<PersonneACharge> trouverPersonnesAChargesActivesParIdentite(
			Identite identite);

	public List<PersonneACharge> trouverHistoriquePersonnesAChargesParIdentite(
			Identite identite, int n);

	public List<PersonneACharge> trouverHistoriquePersonneAChargesParIdentiteEtDateMin(
			Identite identite, Date min, int n);

	public List<PersonneACharge> trouverPremiersHistoriquePersonneAChargesParIdentiteEtDateMin(
			Identite identite, Date min, int n);

	public List<PersonneACharge> trouverHistoriquePersonneAChargesParIdentiteEtDateMax(
			Identite identite, Date max, int n);

	public List<PersonneACharge> trouverHistoriquePersonneAChargesParIdentiteEtDateMinMax(
			Identite identite, Date min, Date max, int n);

	public Long trouverNombreOccurrencesParIdentite(Identite identite);

	public Long trouverNombreOccurrencesActivesParIdentite(Identite identite);
}
