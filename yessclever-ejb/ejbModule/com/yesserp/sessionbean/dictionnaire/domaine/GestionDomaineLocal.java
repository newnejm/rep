package com.yesserp.sessionbean.dictionnaire.domaine;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.dictionnaire.Domaine;

@Local
public interface GestionDomaineLocal {
	public void ajouterDomaine(Domaine o);
	public void modifierDomaine(Domaine o);
	public void supprimerDomaine(Domaine o);
	public Domaine findById(Long id);
	public List<Domaine> findAll();
}
