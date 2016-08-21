package com.yesserp.sessionbean.paramgta.gestionimputacentrecout;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.ImputaCentreCout;

/**
 * Session Bean implementation class GestionImputaCentreCout
 */
@Stateless
@LocalBean
public class GestionImputaCentreCout implements GestionImputaCentreCoutLocal {

	/**
	 * Default constructor.
	 */
	public GestionImputaCentreCout() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajouterCentreCout(ImputaCentreCout imputaCentreCout) {
		entityManager.persist(imputaCentreCout);

	}

	@Override
	public ImputaCentreCout findByCode(String code) {
		Query query = entityManager
				.createQuery("SELECT icc FROM ImputaCentreCout icc WHERE icc.code=:x");
		query.setParameter("x", code);
		return (ImputaCentreCout) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ImputaCentreCout> findAll() {
		Query query = entityManager
				.createQuery("SELECT icc FROM ImputaCentreCout icc");
		return query.getResultList();
	}

	@Override
	public void modifierCentreCout(ImputaCentreCout imputaCentreCout) {
		entityManager.merge(imputaCentreCout);

	}

	@Override
	public void supprimerCentreCout(ImputaCentreCout imputaCentreCout) {
		entityManager.remove(entityManager.merge(imputaCentreCout));

	}

}
