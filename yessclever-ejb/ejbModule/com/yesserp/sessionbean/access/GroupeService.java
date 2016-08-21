package com.yesserp.sessionbean.access;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.yesserp.domain.access.Groupe;
import com.yesserp.domain.access.Habilitation;
import com.yesserp.domain.access.Utilisateur;

/**
 * Session Bean implementation class GroupeService
 */
@Stateless
public class GroupeService implements GroupeServiceRemote, GroupeServiceLocal {

	@PersistenceContext
	private EntityManager em;

	public GroupeService() {

	}

	@Override
	public void creeGroupe(Groupe groupe) {

		em.persist(groupe);

	}

	@Override
	public void modifierGroupe(Groupe groupe) {

		em.merge(groupe);

	}

	@Override
	public void supprimerGroupe(Groupe groupe) {

		em.remove(em.merge(groupe));
	}

	@Override
	public Groupe trouverGroupeById(int id) {
		return em.find(Groupe.class, id);

	}

	@Override
	public List<Groupe> listGroupes() {
		return em.createQuery("select g from Groupe g", Groupe.class)
				.getResultList();

	}



	public List<Groupe> findGroupesByUtilisateurs(Utilisateur utilisateur) {
		return em
				.createQuery(
						"select g from Groupe g join g.assignments a where a.utilisateur=:util",
						Groupe.class).setParameter("util", utilisateur)
				.getResultList();
	}
}
