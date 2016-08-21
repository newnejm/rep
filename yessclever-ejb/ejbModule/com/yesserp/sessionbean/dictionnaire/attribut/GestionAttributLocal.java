package com.yesserp.sessionbean.dictionnaire.attribut;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.dictionnaire.Attribut;
import com.yesserp.domain.dictionnaire.Entite;

@Local
public interface GestionAttributLocal {
	public void ajouterAttribut(Attribut o);
	public void modifierAttribut(Attribut o);
	public void supprimerAttribut(Attribut o);
	public List<Attribut> findByEntite(Entite e);
	public List<Attribut> findByEntiteAndConstraint(Entite e,String contrainte);
	public List<Attribut> findByEntiteAndComplexity(Entite e,String complexite);
	public Attribut findById(Long id);
	public List<Attribut> findAll();
}
