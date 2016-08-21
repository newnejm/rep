package com.yesserp.sessionbean.pg.gestionNatureContratIdentite;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.pg.NatureContratIdentite;

@Local
public interface GestionNatureContratIdentiteLocal {
	public void ajouterNatureContratIdentite(NatureContratIdentite i);
	public void supprimerNatureContratIdentite(NatureContratIdentite i);
	public void modifierNatureContratIdentite(NatureContratIdentite i);
	public List<NatureContratIdentite> findall();

}
