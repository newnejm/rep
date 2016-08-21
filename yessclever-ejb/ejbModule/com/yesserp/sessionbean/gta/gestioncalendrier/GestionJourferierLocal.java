package com.yesserp.sessionbean.gta.gestioncalendrier;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gta.Calendrier;
import com.yesserp.domain.gta.Jourferier;

@Local
public interface GestionJourferierLocal {

	void ajoutJourFerier(Jourferier jourFerier);

	void supprimerJourFerier(Jourferier jourFerier);

	void modifierJourFerier(Jourferier jourFerier);

	List<Jourferier> listerJourFerier();

	Jourferier findJourFerierById(int id);

	List<Jourferier> consulter(Calendrier cal);

}
