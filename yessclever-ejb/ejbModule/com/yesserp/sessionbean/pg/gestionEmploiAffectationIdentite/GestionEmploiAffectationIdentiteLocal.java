package com.yesserp.sessionbean.pg.gestionEmploiAffectationIdentite;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.pg.EmploiAffectationIdentite;

@Local
public interface GestionEmploiAffectationIdentiteLocal {
	public void ajouterEmploiAffectationIdentite(EmploiAffectationIdentite i);
	public void supprimerEmploiAffectationIdentite(EmploiAffectationIdentite i);
	public void modifierEmploiAffectationIdentite(EmploiAffectationIdentite i);
	public List<EmploiAffectationIdentite> findall();

}
