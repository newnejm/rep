package com.yesserp.sessionbean.access;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.access.Collaborateur;
import com.yesserp.domain.access.Company;
import com.yesserp.domain.access.Groupe;
import com.yesserp.domain.access.Manager;
import com.yesserp.domain.access.Role;
import com.yesserp.domain.access.Utilisateur;

@Local
public interface UtilisateurServiceLocal {

	public void creeUtilisateur(Utilisateur utilisateur);

	public void modifierUtilisateur(Utilisateur utilisateur);

	public void supprimerUtilisateur(Utilisateur utilisateur);

	public Utilisateur trouverUtilisateurById(int id);

	public List<Utilisateur> listUtilisateurs();

	public void assignUtilisateursToCompany(List<Utilisateur> utilisateurs,
			Company company);

	public List<Manager> listManager();

	public List<Collaborateur> listCollaborateur();

	
	public void assignUtilisateurToGroupe(Utilisateur utilisateur,
			Groupe groupe, String rol);

	public void removeUtilisteurToGroupe(Utilisateur utilisateur,
			Groupe groupe, String rol);

	public List<Utilisateur> findUtilisateursByGroupes(Groupe groupe);
	

    public Manager findManagerById(int id);
}
