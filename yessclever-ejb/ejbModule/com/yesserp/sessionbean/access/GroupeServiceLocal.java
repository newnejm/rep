package com.yesserp.sessionbean.access;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.access.Groupe;
import com.yesserp.domain.access.Habilitation;
import com.yesserp.domain.access.Utilisateur;

@Local
public interface GroupeServiceLocal {

	public void creeGroupe(Groupe groupe);

	public void modifierGroupe(Groupe groupe);

	public void supprimerGroupe(Groupe groupe);

	public Groupe trouverGroupeById(int id);

	public List<Groupe> listGroupes();

	public List<Groupe> findGroupesByUtilisateurs(Utilisateur utilisateur);
}
