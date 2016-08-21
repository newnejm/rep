package com.yesserp.sessionbean.gta.gestioncalendrier;

import java.sql.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.Calendrier;
import com.yesserp.domain.gta.CodeCalendrier;

/**
 * Session Bean implementation class GestionCalendrier
 */
@Stateless
@LocalBean
public class GestionCalendrier implements GestionCalendrierLocal {

	/**
	 * Default constructor.
	 */
	public GestionCalendrier() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void ajouterCalendrier(Calendrier calendrier) {
		entityManager.persist(calendrier);

	}

	@Override
	public void supprimerCalendrier(Calendrier calendrier) {
		entityManager.remove(entityManager.merge(calendrier));

	}

	@Override
	public void modifierCalendrier(Calendrier calendrier) {
		entityManager.merge(calendrier);

	}

	@Override
	public Calendrier findCalendrierById(int id) {

		return entityManager.find(Calendrier.class, id);
	}

	@Override
	public List<Calendrier> findAllCalendriers() {

		Query query = entityManager.createQuery("select c from Calendrier c ");
		return query.getResultList();
	}

	@Override
	public Calendrier trouverCalendrierParNom(String nom) {
		Query query = entityManager
				.createQuery("select c from Calendrier c where c.nomJourFerier=:x");
		query.setParameter("x", nom);
		return (Calendrier) query.getSingleResult();
	}

	@Override
	public List<CodeCalendrier> findCalendrierForIdentity(Identite identite ) {
		Query query =  entityManager.createQuery("select c from CodeCalendrier c join c.affectationCodeCals a where a.identite=:ide");
		query.setParameter("ide", identite);
		return query.getResultList();
	}

}
