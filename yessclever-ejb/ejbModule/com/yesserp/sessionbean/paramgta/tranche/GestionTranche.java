package com.yesserp.sessionbean.paramgta.tranche;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gta.Absence;
import com.yesserp.domain.gta.Tranche;
import com.yesserp.domain.gtaparam.TrancheDroit;

/**
 * Session Bean implementation class GestionLibelle
 */
@Stateless
@LocalBean
public class GestionTranche implements GestionTrancheLocal {

	/**
	 * Default constructor.
	 */
	public GestionTranche() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajoutTranche(TrancheDroit tranche) {
		entityManager.persist(tranche);

	}

	@Override
	public void supprimerTranche(TrancheDroit tranche) {
		entityManager.remove(entityManager.merge(tranche));

	}

	@Override
	public void modifierTranche(TrancheDroit tranche) {
		entityManager.merge(tranche);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrancheDroit> listerTranche() {
		Query query = entityManager.createQuery("SELECT l FROM TrancheDroit l");
		return query.getResultList();
	}

	// modification Tranche <- TrancheDroit by yassine
	@Override
	public TrancheDroit findTrancheById(int id) {
		return entityManager.find(TrancheDroit.class, id);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tranche> findByAbsence(Absence absence, Date date) {
		Query query = entityManager
				.createQuery("select tr from Tranche tr where absence=:x and date=:y");
		query.setParameter("x", absence);
		query.setParameter("y", date);
		return query.getResultList();
	}

}
