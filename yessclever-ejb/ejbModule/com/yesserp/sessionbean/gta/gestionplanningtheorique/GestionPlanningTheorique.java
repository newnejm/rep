package com.yesserp.sessionbean.gta.gestionplanningtheorique;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.PlanningTheorique;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.PlageHoraire;

/**
 * Session Bean implementation class GestionPlanningTheorique
 */
@Stateless
@LocalBean
public class GestionPlanningTheorique implements GestionPlanningTheoriqueLocal {

	/**
	 * Default constructor.
	 */
	public GestionPlanningTheorique() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void ajouterPlanningTh(PlanningTheorique planningTheorique) {
		entityManager.persist(planningTheorique);

	}

	@Override
	public void supprimerPlanningTh(PlanningTheorique planningTheorique) {
		entityManager.remove(entityManager.merge(planningTheorique));

	}

	@Override
	public void modifierPlanningTh(PlanningTheorique planningTheorique) {
		entityManager.merge(planningTheorique);

	}

	@Override
	public PlanningTheorique findPlanningThById(int id) {

		return entityManager.find(PlanningTheorique.class, id);
	}

	@Override
	public List<PlanningTheorique> findAllPlanningThs() {
		Query query = entityManager
				.createQuery("select p from PlanningTheorique");
		return query.getResultList();
	}

	@Override
	public List<PlanningTheorique> findLastOne(Identite identite) {
		Query query = entityManager
				.createQuery("select p from PlanningTheorique p where p.identite=:ide order by p.id desc");
		query.setParameter("ide", identite);
		return query.setMaxResults(1).getResultList();
	}

	@Override
	public List<PlageHoraire> findPlageHorairessByJourneeType(
			JourneeType journeeType) {
		Query query = entityManager
				.createQuery("select p from PlageHoraire p join p.plageHoraireAssociateJourneeTypes h where h.journeeType=:jour");
		query.setParameter("jour", journeeType);
		return query.getResultList();
	}

	@Override
	public int findHeureDebutForPlageEtJournee(int idPlage, int idJournee) {
		// TODO Auto-generated method stub
		return 0;
	}

}
