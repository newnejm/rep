package com.yesserp.sessionbean.crm.gestiontache;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.crm.Tache;

@Local
public interface GestionTacheLocal {

	public void ajouterTache(Tache i);

	public void supprimerTache(Tache i);

	public void modifierTache(Tache i);

	public List<Tache> AfficherTousTache();

	public Tache AfficherOneTache();

	public Tache FindTacheByName(String nom);

}
