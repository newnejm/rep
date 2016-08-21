package com.yesserp.sessionbean.pg.gestionUOAffectationIdentite;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.pg.UOAffectationIdentite;

@Local
public interface GestionUOAffectationIdentiteLocal {
	public void ajouterUOAffectationIdentite(UOAffectationIdentite i);
	public void supprimerUOAffectationIdentite(UOAffectationIdentite i);
	public void modifierUOAffectationIdentite(UOAffectationIdentite i);
	public List<UOAffectationIdentite> findall();
}
