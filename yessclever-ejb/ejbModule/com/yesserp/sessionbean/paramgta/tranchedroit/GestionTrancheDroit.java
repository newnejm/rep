package com.yesserp.sessionbean.paramgta.tranchedroit;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.TrancheDroit;

/**
 * Session Bean implementation class GestionLibelle
 */
@Stateless
@LocalBean
public class GestionTrancheDroit implements GestionTrancheDroitLocal {

	/**
	 * Default constructor.
	 */
	public GestionTrancheDroit() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajoutTrancheDroit(TrancheDroit trancheDroit) {
		entityManager.persist(trancheDroit);

	}

	@Override
	public void supprimerTrancheDroit(TrancheDroit trancheDroit) {
		entityManager.remove(entityManager.merge(trancheDroit));

	}

	@Override
	public void modifierTrancheDroit(TrancheDroit trancheDroit) {
		entityManager.merge(trancheDroit);

	}

	@Override
	public List<TrancheDroit> listerTrancheDroit() {
		Query query = entityManager.createQuery("SELECT l FROM TrancheDroit l");
		return query.getResultList();
	}

	@Override
	public TrancheDroit findTrancheDroitById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
