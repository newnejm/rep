package com.yesserp.sessionbean.gta.gestiondatejournees;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gta.DateCalculGta;
import com.yesserp.domain.gta.PlanningTheorique;

/**
 * Session Bean implementation class GestionDateJournees
 */
@Stateless
@LocalBean
public class GestionDateJournees implements GestionDateJourneesLocal {

	/**
	 * Default constructor.
	 */
	public GestionDateJournees() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void ajouter(DateCalculGta dateJournees) {
		entityManager.persist(dateJournees);

	}

	@Override
	public void supprimer(DateCalculGta dateJournees) {
		entityManager.remove(entityManager.merge(dateJournees));

	}

	@Override
	public void modifier(DateCalculGta dateJournees) {
		entityManager.merge(dateJournees);

	}

	@Override
	public DateCalculGta findById(int id) {

		return entityManager.find(DateCalculGta.class, id);
	}

	@Override
	public List<DateCalculGta> findAll() {
		Query query = entityManager.createQuery("select d from DateJournees d");
		return query.getResultList();
	}

	@Override
	public List<DateCalculGta> findDatesByPlanning(
			PlanningTheorique planningTheorique) {
		Query query = entityManager.createQuery("select d from DateJournees d where d.planningTheorique=:pl");
		query.setParameter("pl",planningTheorique);
		return query.getResultList();
	}

	@Override
	public List<DateCalculGta> calculerPlanningEntre2Dates(Date dateDebut,
			Date dateFin, PlanningTheorique planningTheorique) {
		Query query = entityManager.createQuery("select d from DateJournees d where d.planningTheorique=:pl and d.dateJour BETWEEN :dateDebut and :dateFin");
		query.setParameter("pl",planningTheorique);
		query.setParameter("dateDebut",dateDebut);
		query.setParameter("dateFin",dateFin);
		return query.getResultList();
	}

}
