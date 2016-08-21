package com.yesserp.sessionbean.paramgta.gestionimputacompte;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.ImputaCompte;

/**
 * Session Bean implementation class GestionImputaCompte
 */
@Stateless
@LocalBean
public class GestionImputaCompte implements GestionImputaCompteLocal {

	/**
	 * Default constructor.
	 */
	public GestionImputaCompte() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajouterCompte(ImputaCompte imputaCompte) {
		entityManager.persist(imputaCompte);

	}

	@Override
	public ImputaCompte findByCode(String code) {
		Query query = entityManager
				.createQuery("SELECT ic FROM ImputaCompte ic WHERE ic.code=:x");
		query.setParameter("x", code);
		return (ImputaCompte) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ImputaCompte> findAll() {
		Query query = entityManager
				.createQuery("SELECT ic FROM ImputaCompte ic");
		return query.getResultList();
	}

	@Override
	public void modifierCompte(ImputaCompte imputaCompte) {
		entityManager.merge(imputaCompte);

	}

	@Override
	public void supprimerCompte(ImputaCompte imputaCompte) {
		entityManager.remove(entityManager.merge(imputaCompte));

	}

}
