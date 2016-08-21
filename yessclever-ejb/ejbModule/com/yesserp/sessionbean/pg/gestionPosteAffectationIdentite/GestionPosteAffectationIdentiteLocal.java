package com.yesserp.sessionbean.pg.gestionPosteAffectationIdentite;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.pg.PosteAffectationIdentite;

@Local
public interface GestionPosteAffectationIdentiteLocal {
	public void ajouterPosteAffectationIdentite(PosteAffectationIdentite i);
	public void supprimerPosteAffectationIdentite(PosteAffectationIdentite i);
	public void modifierPosteAffectationIdentite(PosteAffectationIdentite i);
	public List<PosteAffectationIdentite> findall();

}
