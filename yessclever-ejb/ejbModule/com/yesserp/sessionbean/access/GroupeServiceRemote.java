package com.yesserp.sessionbean.access;

import java.util.List;

import javax.ejb.Remote;

import com.yesserp.domain.access.Groupe;
import com.yesserp.domain.access.Habilitation;
import com.yesserp.domain.access.Utilisateur;

@Remote
public interface GroupeServiceRemote {

	public void creeGroupe(Groupe groupe);

	public void modifierGroupe(Groupe groupe);

	public void supprimerGroupe(Groupe groupe);

	public Groupe trouverGroupeById(int id);

	public List<Groupe> listGroupes();

	public List<Groupe> findGroupesByUtilisateurs(Utilisateur utilisateur);
}
