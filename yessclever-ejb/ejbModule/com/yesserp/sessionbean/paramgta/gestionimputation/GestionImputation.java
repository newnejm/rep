package com.yesserp.sessionbean.paramgta.gestionimputation;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.GroupeImputation;
import com.yesserp.domain.gtaparam.Imputation;

/**
 * Session Bean implementation class GestionImputation
 */
@Stateless
@LocalBean
public class GestionImputation implements GestionImputationLocal {

	/**
	 * Default constructor.
	 */
	public GestionImputation() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajouterImputation(Imputation imputation) {
		entityManager.persist(imputation);

	}

	@Override
	public void modifierImputation(Imputation imputation) {
		entityManager.merge(imputation);

	}

	@Override
	public void supprimerImputation(Imputation imputation) {
		entityManager.remove(entityManager.merge(imputation));

	}

	@Override
	public Imputation findImputationByCode(String code) {
		Query query = entityManager
				.createQuery("select imp from Imputation imp where imp.codei=:x");
		query.setParameter("x", code);
		return (Imputation) query.getSingleResult();
	}

	@Override
	public Imputation findImputationById(int id) {
		return entityManager.find(Imputation.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Imputation> listeImputation() {
		Query query = entityManager
				.createQuery("select imp from Imputation imp");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Imputation> getImputationNotInGroupe(
			GroupeImputation groupeImputation) {
		Query query = entityManager
				.createQuery("select a from Imputation a where a not in (select c from Imputation c inner join c.groupeImputations acv where acv=:x)");
		query.setParameter("x", groupeImputation);
		return query.getResultList();
	}

	@Override
	public List<Imputation> getImputationInGroupe(
			GroupeImputation groupeImputation) {
		// TODO Auto-generated method stub
		return null;
	}

}
