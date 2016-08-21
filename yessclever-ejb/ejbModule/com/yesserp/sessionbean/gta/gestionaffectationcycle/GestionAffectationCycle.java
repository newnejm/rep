package com.yesserp.sessionbean.gta.gestionaffectationcycle;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.AffectationCycle;
import com.yesserp.domain.gtaparam.CycleTravail;

/**
 * Session Bean implementation class GestionAffectationCycle
 */
@Stateless
@LocalBean
public class GestionAffectationCycle implements GestionAffectationCycleLocal {

	/**
	 * Default constructor.
	 */
	public GestionAffectationCycle() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public CycleTravail findAffectationCycleForEmployeeEtCycle(Date date,
			Identite identite) {
		Query query = entityManager
				.createQuery("select c from CycleTravail  c join c.affectationCycles a where a.identite=:dev and a.affectationCyclePK.dateAffectation=:p");
		query.setParameter("dev", identite);
		query.setParameter("p", date);
		return (CycleTravail) query.getSingleResult();
	}

	@Override
	public List<Date> trouverDatesChangementDeCycle(Identite identite) {
		Query query = entityManager.createQuery("select a.affectationCyclePK.dateAffectation from AffectationCycle a where a.identite=:id");
		query.setParameter("id", identite);
		return query.getResultList();
	}

	@Override
	public List<Date> trouverDateDecycle(Identite identite, CycleTravail cycleTravail) {
		Query query = entityManager.createQuery("select a.affectationCyclePK.dateAffectation from AffectationCycle a where a.identite=:id and a.cycleTravailGTA=:cy");
		query.setParameter("id",identite);
		query.setParameter("cy", cycleTravail);
		return  query.getResultList();
	}


	@Override
	public void supprimerAffectationCycleTravail(AffectationCycle aff) {
		entityManager.remove(aff);
		
	}

	@Override
	public void modifierAffectationCycledeTravail(AffectationCycle affectationCycle) {
		entityManager.merge(affectationCycle);
		
	}

}
