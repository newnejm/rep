package com.yesserp.sessionbean.access;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.yesserp.domain.access.Assignment;
import com.yesserp.domain.access.Collaborateur;
import com.yesserp.domain.access.Company;
import com.yesserp.domain.access.Groupe;
import com.yesserp.domain.access.Manager;
import com.yesserp.domain.access.Role;
import com.yesserp.domain.access.Utilisateur;

/**
 * Session Bean implementation class UtilisateurService
 */
@Stateless
public class UtilisateurService implements UtilisateurServiceRemote,
		UtilisateurServiceLocal {

	@PersistenceContext
	private EntityManager em;

	public UtilisateurService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void creeUtilisateur(Utilisateur utilisateur) {
		em.persist(utilisateur);

	}

	@Override
	public void modifierUtilisateur(Utilisateur utilisateur) {

		em.merge(utilisateur);
	}

	@Override
	public void supprimerUtilisateur(Utilisateur utilisateur) {

		em.remove(em.merge(utilisateur));
	}

	@Override
	public Utilisateur trouverUtilisateurById(int id) {

		return em.find(Utilisateur.class, id);
	}

	@Override
	public List<Utilisateur> listUtilisateurs() {

		return em.createQuery("select u from Utilisateur u", Utilisateur.class)
				.getResultList();

	}

	public void assignUtilisateursToCompany(List<Utilisateur> utilisateurs,
			Company company) {
		for (Utilisateur utilisateur : utilisateurs) {
			company.addUtilisateur(utilisateur);
			em.merge(utilisateur);
		}
	}

	public List<Manager> listManager() {
		return em.createQuery("select m from Manager m", Manager.class)
				.getResultList();
	}

	public List<Collaborateur> listCollaborateur() {
		return em.createQuery("select c from Collaborateur c",
				Collaborateur.class).getResultList();
	}

	public void assignUtilisateurToGroupe(Utilisateur utilisateur,
			Groupe groupe, String rol) {
		Assignment assignment = new Assignment(utilisateur, groupe, rol);
		em.persist(assignment);
	}

	public void removeUtilisteurToGroupe(Utilisateur utilisateur,
			Groupe groupe, String rol) {
		Assignment assignment = new Assignment(utilisateur, groupe, rol);
		em.remove(em.merge(assignment));
	}

	public List<Utilisateur> findUtilisateursByGroupes(Groupe groupe) {
		return em
				.createQuery(
						"select u from Utilisateur u join u.assignments a where a.groupe=:g")
				.setParameter("p", groupe).getResultList();
	}

	public Manager findManagerById(int id) {
		return em.find(Manager.class, id);
	}

	

}
