package com.yesserp.sessionbean.paramgta.gestionimputacodefacturation;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.ImputaCodeFact;

/**
 * Session Bean implementation class GestionImputaCodeFacturation
 */
@Stateless
@LocalBean
public class GestionImputaCodeFacturation implements
		GestionImputaCodeFacturationLocal {

	/**
	 * Default constructor.
	 */
	public GestionImputaCodeFacturation() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajouterCodeFacturation(ImputaCodeFact imputaCodeFact) {
		entityManager.persist(imputaCodeFact);

	}

	@Override
	public ImputaCodeFact findByCode(String code) {
		Query query = entityManager
				.createQuery("SELECT icf FROM ImputaCodeFact icf WHERE icf.code=:x");
		query.setParameter("x", code);
		return (ImputaCodeFact) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ImputaCodeFact> findAll() {
		Query query = entityManager
				.createQuery("SELECT icf FROM ImputaCodeFact icf");
		return query.getResultList();
	}

	@Override
	public void modifierCodeFacturation(ImputaCodeFact imputaCodeFact) {
		entityManager.merge(imputaCodeFact);

	}

	@Override
	public void supprimerCodeFacturation(ImputaCodeFact imputaCodeFact) {
		entityManager.remove(entityManager.merge(imputaCodeFact));

	}

}
