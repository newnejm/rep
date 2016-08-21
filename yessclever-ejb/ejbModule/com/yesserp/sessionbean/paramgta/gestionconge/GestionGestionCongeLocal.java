package com.yesserp.sessionbean.paramgta.gestionconge;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.GestionConge;

@Local
public interface GestionGestionCongeLocal {

	public void ajoutGestionConge(GestionConge gestionconge);

	public void supprimerGestionConge(GestionConge gestionconge);

	public void modifierGestionConge(GestionConge gestionconge);

	public List<GestionConge> listerGestionConge();

	public GestionConge findGestionCongeById(int id);

}
