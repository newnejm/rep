package com.yesserp.sessionbean.paramgta.gestioncompteur;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gtaparam.Compteur;

@Local
public interface GestionCompteurLocal {

	public void ajouterCompteur(Compteur compteur);
	public void modifierCompteur(Compteur compteur);
	public Compteur findCompteurByCode(String code);
	public Compteur findCompteurById(int id);
	public List<Compteur> listeCompteurs();
	public List<Compteur> findAll();
	public List<Compteur> findCompteurByIdentite(Identite identite);
	public List<Integer> getFilsCompteur(Compteur cmp);
	
	public List<Compteur> getCompteurByUser(Identite identite ,Date d);
}
