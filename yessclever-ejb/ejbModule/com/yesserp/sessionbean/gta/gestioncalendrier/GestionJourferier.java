package com.yesserp.sessionbean.gta.gestioncalendrier;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gta.Calendrier;
import com.yesserp.domain.gta.Jourferier;

/**
 * Session Bean implementation class GestionJourferier
 */
@Stateless
@LocalBean
public class GestionJourferier implements GestionJourferierLocal {

	/**
	 * Default constructor.
	 */
	public GestionJourferier() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajoutJourFerier(Jourferier jourFerier) {
		entityManager.persist(jourFerier);

	}

	@Override
	public void supprimerJourFerier(Jourferier jourFerier) {
		entityManager.remove(entityManager.merge(jourFerier));

	}

	@Override
	public void modifierJourFerier(Jourferier jourFerier) {
		entityManager.merge(jourFerier);

	}

	@Override
	public List<Jourferier> listerJourFerier() {
		Query query = entityManager.createQuery("SELECT l FROM Jourferier l");
		return query.getResultList();
	}

	@Override
	public Jourferier findJourFerierById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jourferier> consulter(Calendrier cal) {
		return (entityManager.createQuery(
				"SELECT jf FROM Jourferier jf where jf.calendrier = :cal")
				.setParameter("cal", cal).getResultList());
	}
}
