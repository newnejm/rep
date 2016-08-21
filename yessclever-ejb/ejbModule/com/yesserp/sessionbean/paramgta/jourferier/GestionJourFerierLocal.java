package com.yesserp.sessionbean.paramgta.jourferier;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.JourFerier;

@Local
public interface GestionJourFerierLocal {
	
	public void ajoutJourFerier(JourFerier jourFerier);

	public void supprimerJourFerier(JourFerier jourFerier);

	public void modifierJourFerier(JourFerier jourFerier);

	public List<JourFerier> listerJourFerier();

	public JourFerier findJourFerierById(int id);
}
