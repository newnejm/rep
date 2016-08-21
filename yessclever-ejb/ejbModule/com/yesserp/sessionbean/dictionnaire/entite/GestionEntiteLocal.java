package com.yesserp.sessionbean.dictionnaire.entite;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.dictionnaire.Domaine;
import com.yesserp.domain.dictionnaire.Entite;

@Local
public interface GestionEntiteLocal {
	public void ajouterEntite(Entite o);
	public void modifierEntite(Entite o);
	public void supprimerEntite(Entite o);
	public List<Entite> findByDomaine(Domaine e);
	public Entite findById(Long id);
	public List<Entite> findAll();
}
