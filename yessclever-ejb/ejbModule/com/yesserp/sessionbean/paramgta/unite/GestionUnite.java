package com.yesserp.sessionbean.paramgta.unite;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.Unite;

/**
 * Session Bean implementation class GestionLibelle
 */
@Stateless
@LocalBean
public class GestionUnite implements GestionUniteLocal {

	/**
	 * Default constructor.
	 */
	public GestionUnite() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajoutUnite(Unite unite) {
		entityManager.persist(unite);

	}

	@Override
	public void supprimerUnite(Unite unite) {
		entityManager.remove(entityManager.merge(unite));

	}

	@Override
	public void modifierUnite(Unite unite) {
		entityManager.merge(unite);

	}

	@Override
	public List<Unite> listerUnite() {
		Query query = entityManager.createQuery("SELECT l FROM Unite l");
		return query.getResultList();
	}

	@Override
	public Unite findUniteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
