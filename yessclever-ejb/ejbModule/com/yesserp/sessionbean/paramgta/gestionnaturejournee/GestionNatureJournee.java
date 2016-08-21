package com.yesserp.sessionbean.paramgta.gestionnaturejournee;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.NatureJournee;

/**
 * Session Bean implementation class GestionNatureJournee
 */
@Stateless
@LocalBean
public class GestionNatureJournee implements GestionNatureJourneeLocal {

	/**
	 * Default constructor.
	 */
	public GestionNatureJournee() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajouterNatureJournee(NatureJournee natureJournee) {
		entityManager.persist(natureJournee);

	}

	@Override
	public void modifierNatureJournee(NatureJournee natureJournee) {
		entityManager.merge(natureJournee);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NatureJournee> listeNatureJournee() {
		Query query = entityManager
				.createQuery("select nj from NatureJournee nj");
		return query.getResultList();
	}

	@Override
	public NatureJournee findNatureJourneeByCode(String code) {
		Query query = entityManager
				.createQuery("select nj from NatureJournee nj where codenj=:x");
		query.setParameter("x", code);
		return (NatureJournee) query.getSingleResult();
	}

	@Override
	public NatureJournee findNatureJourneeById(int id) {
		return entityManager.find(NatureJournee.class, id);
	}

}
