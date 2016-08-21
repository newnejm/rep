package com.yesserp.sessionbean.gta.gestionplanningreel;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.PlanningReel;

/**
 * Session Bean implementation class GestionPlanningReel
 */
@Stateless
@LocalBean
public class GestionPlanningReel implements GestionPlanningReelLocal {

	/**
	 * Default constructor.
	 */
	public GestionPlanningReel() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<PlanningReel> findByDate(Identite identite, Date date) {
		Query query = entityManager
				.createQuery("select planr from PlanningReel planr where planr.identite=:ident and planr.date =:date");
		query.setParameter("ident", identite);
		query.setParameter("date", date);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlanningReel> findAll(Identite identite) {
		Query query = entityManager
				.createQuery("select planr from PlanningReel planr where planr.identite=:ident");
		query.setParameter("ident", identite);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlanningReel> findFromDateToDate(Identite identite,
			Date dateDeb, Date dateFin) {
		Query query = entityManager
				.createQuery("select planr from PlanningReel planr where planr.identite=:ident and planr.date between :datedeb and :datefin");
		query.setParameter("ident", identite);
		query.setParameter("datedeb", dateDeb);
		query.setParameter("datefin", dateFin);
		return query.getResultList();
	}

	@Override
	public int findNumberOfSlices(Identite identite, Date date) {
		Query query = entityManager
				.createQuery("select count(*) from PlannigReel pr where pr.identite=:x and pr.date=:y and pr.plageHoraire.typePlage like 'obligatoire' ");
		query.setParameter("x", identite);
		query.setParameter("y", date);
		return (int) query.getSingleResult();
	}

	@Override
	public void AjouterPlaningReel(PlanningReel planingReel) {
		entityManager.persist(planingReel);
		
	}

}
