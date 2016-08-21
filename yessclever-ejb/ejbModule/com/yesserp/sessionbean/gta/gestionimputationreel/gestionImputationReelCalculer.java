package com.yesserp.sessionbean.gta.gestionimputationreel;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gta.ImputationReelCalculer;
import com.yesserp.domain.gtaparam.Filtre;

/**
 * Session Bean implementation class ImputationReelCalculer
 */
@Stateless
@LocalBean
public class gestionImputationReelCalculer implements
		gestionImputationReelCalculerLocal {

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public gestionImputationReelCalculer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterImputationReelCalculer(
			ImputationReelCalculer imputationReelCalculer) {
		entityManager.persist(imputationReelCalculer);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ImputationReelCalculer> findImputationReel(Filtre filtre, Date d) {

		Query query = entityManager
				.createQuery("Select arc from ImputationReelCalculer arc inner join arc.imputation p  inner join p.filtres f  where f=:x  and   arc.date=:d");
		query.setParameter("x", filtre);
		query.setParameter("d", d);

		return (List<ImputationReelCalculer>) query.getResultList();

		// TODO Auto-generated method stub

	}

}
