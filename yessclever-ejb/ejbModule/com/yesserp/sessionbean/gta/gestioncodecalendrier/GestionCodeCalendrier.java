package com.yesserp.sessionbean.gta.gestioncodecalendrier;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.AffectationCycle;
import com.yesserp.domain.gta.AffectationCyclePK;
import com.yesserp.domain.gta.Calendrier;
import com.yesserp.domain.gta.CodeCalendrier;

/**
 * Session Bean implementation class GestionCodeCalendrier
 */
@Stateless
@LocalBean
public class GestionCodeCalendrier implements GestionCodeCalendrierLocal {

	/**
	 * Default constructor.
	 */
	public GestionCodeCalendrier() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void ajouterCodeCalendrier(CodeCalendrier codeCalendrier) {
		entityManager.persist(codeCalendrier);

	}

	@Override
	public void supprimerCodeCalendrier(CodeCalendrier codeCalendrier) {
		entityManager.remove(entityManager.merge(codeCalendrier));

	}

	@Override
	public void modifierCodeCalendrier(CodeCalendrier codeCalendrier) {
		entityManager.merge(codeCalendrier);

	}

	@Override
	public CodeCalendrier findCodeCalendrierById(int id) {
		return entityManager.find(CodeCalendrier.class, id);
	}

	@Override
	public List<CodeCalendrier> findAllCodeCalendriers() {
		Query query = entityManager
				.createQuery("select c from CodeCalendrier c ");
		return query.getResultList();
	}

	@Override
	public CodeCalendrier trouverCodeParCode(String code) {
		Query query = entityManager
				.createQuery("select c from CodeCalendrier c where c.code=:x");
		query.setParameter("x", code);
		return (CodeCalendrier) query.getSingleResult();
	}

	@Override
	public List<Calendrier> trouverJoursFerierParCalendrier(
			CodeCalendrier calendrier) {
		Query query = entityManager
				.createQuery("select c from Calendrier c where:calendrier member of c.calendriers");
		query.setParameter("calendrier", calendrier);
		return query.getResultList();
	}







}

	
	

	


