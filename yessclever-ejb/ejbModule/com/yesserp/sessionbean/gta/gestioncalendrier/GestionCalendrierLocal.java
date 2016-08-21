package com.yesserp.sessionbean.gta.gestioncalendrier;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.Calendrier;
import com.yesserp.domain.gta.CodeCalendrier;

@Local
public interface GestionCalendrierLocal {

	public void ajouterCalendrier(Calendrier calendrier);

	public void supprimerCalendrier(Calendrier calendrier);

	public void modifierCalendrier(Calendrier calendrier);

	public Calendrier findCalendrierById(int id);

	public List<Calendrier> findAllCalendriers();

	public Calendrier trouverCalendrierParNom(String nom);

	public List<CodeCalendrier> findCalendrierForIdentity(Identite identite);

}
