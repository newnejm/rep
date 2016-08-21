package com.yesserp.sessionbean.paramgta.gestionimputasouscompte;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.ImputaSousCompte;

/**
 * Session Bean implementation class GestionImputaSousCompte
 */
@Stateless
@LocalBean
public class GestionImputaSousCompte implements GestionImputaSousCompteLocal {

	/**
	 * Default constructor.
	 */
	public GestionImputaSousCompte() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajouterSousCompte(ImputaSousCompte imputaSousCompte) {
		entityManager.persist(imputaSousCompte);

	}

	@Override
	public ImputaSousCompte findByCode(String code) {
		Query query = entityManager
				.createQuery("SELECT isc FROM ImputaSousCompte isc WHERE isc.code=:x");
		query.setParameter("x", code);
		return (ImputaSousCompte) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ImputaSousCompte> findAll() {
		Query query = entityManager
				.createQuery("SELECT isc FROM ImputaSousCompte isc");
		return query.getResultList();
	}

	@Override
	public void modifierSousCompte(ImputaSousCompte imputaSousCompte) {
		entityManager.merge(imputaSousCompte);

	}

	@Override
	public void supprimerSousCompte(ImputaSousCompte imputaSousCompte) {
		entityManager.remove(entityManager.merge(imputaSousCompte));

	}

}
