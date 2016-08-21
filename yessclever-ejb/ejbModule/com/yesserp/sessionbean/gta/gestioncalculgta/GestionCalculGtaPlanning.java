package com.yesserp.sessionbean.gta.gestioncalculgta;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.CalculGta;
import com.yesserp.domain.gtaparam.JourneeType;

/**
 * Session Bean implementation class GestionCalculGtaPlanning
 */
@Stateless
@LocalBean
public class GestionCalculGtaPlanning implements GestionCalculGtaPlanningLocal {

	/**
	 * Default constructor.
	 */
	public GestionCalculGtaPlanning() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void ajouterPlanning(CalculGta calculGta) {
		entityManager.persist(calculGta);

	}

	@Override
	public void supprimerPlanningTheorique() {
		Query query = entityManager.createQuery("delete from CalculGta ");
		query.executeUpdate();

	}

	@Override
	public List<CalculGta> trouverPlanningPourEmployee(Identite identite) {
		Query query = entityManager.createQuery("select c from CalculGta c where identite=:id");
		query.setParameter("id",identite);
		return query.getResultList();
	}

	@Override
	public JourneeType trouverJourneeParDate(Date date) {
		Query query = entityManager.createQuery("select c.journeeType from CalculGta c where c.dateJour=:date");
		query.setParameter("date", date);
		return (JourneeType) query.getSingleResult();
	}

}
