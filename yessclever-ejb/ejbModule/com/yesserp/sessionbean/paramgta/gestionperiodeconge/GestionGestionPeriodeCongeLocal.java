package com.yesserp.sessionbean.paramgta.gestionperiodeconge;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.GestionPeriodeConge;

@Local
public interface GestionGestionPeriodeCongeLocal {
	
	public void ajoutGestionPeriodeConge(GestionPeriodeConge gestionPeriodeConge);

	public void supprimerGestionPeriodeConge(GestionPeriodeConge gestionPeriodeConge);

	public void modifierGestionPeriodeConge(GestionPeriodeConge gestionPeriodeConge);

	public List<GestionPeriodeConge> listerGestionPeriodeConge();

	public GestionPeriodeConge findGestionPeriodeCongeById(int id);
}
