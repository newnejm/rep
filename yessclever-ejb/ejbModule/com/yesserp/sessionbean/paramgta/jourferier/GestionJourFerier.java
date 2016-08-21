package com.yesserp.sessionbean.paramgta.jourferier;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.JourFerier;

/**
 * Session Bean implementation class GestionLibelle
 */
@Stateless
@LocalBean
public class GestionJourFerier implements GestionJourFerierLocal {

	/**
	 * Default constructor.
	 */
	public GestionJourFerier() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajoutJourFerier(JourFerier jourFerier) {
		entityManager.persist(jourFerier);

	}

	@Override
	public void supprimerJourFerier(JourFerier jourFerier) {
		entityManager.remove(entityManager.merge(jourFerier));

	}

	@Override
	public void modifierJourFerier(JourFerier jourFerier) {
		entityManager.merge(jourFerier);

	}

	@Override
	public List<JourFerier> listerJourFerier() {
		Query query = entityManager.createQuery("SELECT l FROM JourFerier l");
		return query.getResultList();
	}

	@Override
	public JourFerier findJourFerierById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
