package com.yesserp.sessionbean.pg.gestionCategorieAffectationIdentite;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.pg.CategorieAffectationIdentite;

@Local
public interface GestionCategorieAffectationIdentiteLocal {
	public void ajouterCategorieAffectationIdentite(CategorieAffectationIdentite i);
	public void supprimerCategorieAffectationIdentite(CategorieAffectationIdentite i);
	public void modifierCategorieAffectationIdentite(CategorieAffectationIdentite i);
	public List<CategorieAffectationIdentite> findall();

}
