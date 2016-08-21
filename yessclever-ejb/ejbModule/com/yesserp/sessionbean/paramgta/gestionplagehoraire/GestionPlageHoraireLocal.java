package com.yesserp.sessionbean.paramgta.gestionplagehoraire;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.DescJourneeType;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.PlageHoraire;
import com.yesserp.domain.gtaparam.PlageHoraireDescJourneeType;

@Local
public interface GestionPlageHoraireLocal {
	public void ajouterPlageHoraire(PlageHoraire plageHoraire);

	public void supprimerPlageHoraire(PlageHoraire plageHoraire);

	public void modifierPlageHoraire(PlageHoraire plageHoraire);

	public List<PlageHoraire> listerPlageHoraire();

	public PlageHoraire findPlageHoraireById(int idPlageHoraire);

	public PlageHoraire findPlageHoraireByCode(String code);

	public List<PlageHoraire> findAllPlagesHoraireForJourneeType(
			JourneeType journeeType);
	public List<PlageHoraire> findAllPlagesHoraire();

	public int trouverHeureDeb(PlageHoraire plageHoraire,JourneeType journeeType);
	public int trouverHeureFin(PlageHoraire plageHoraire,JourneeType journeeType);
	public List<PlageHoraire> findPlageHoraireByDescJourneeType(DescJourneeType descJourneeType);

	List<PlageHoraireDescJourneeType> findPlageHoraireDescJourneeType(
			DescJourneeType descJourneeType);
}
