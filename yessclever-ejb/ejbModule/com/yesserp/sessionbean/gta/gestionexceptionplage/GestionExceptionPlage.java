package com.yesserp.sessionbean.gta.gestionexceptionplage;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gta.ExceptionPlageHoraire;

/**
 * Session Bean implementation class GestionExceptionPlage
 */
@Stateless
@LocalBean
public class GestionExceptionPlage implements GestionExceptionPlageLocal {

	/**
	 * Default constructor.
	 */
	public GestionExceptionPlage() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void ajouterExceptionPlageHoraire(
			ExceptionPlageHoraire exceptionPlageHoraire) {
		entityManager.persist(exceptionPlageHoraire);

	}

	@Override
	public void supprimerExceptionPlageHoraire(
			ExceptionPlageHoraire exceptionPlageHoraire) {
		entityManager.remove(entityManager.merge(exceptionPlageHoraire));

	}

	@Override
	public void modifierExceptionPlageHoraire(
			ExceptionPlageHoraire exceptionPlageHoraire) {
		entityManager.merge(exceptionPlageHoraire);

	}

	@Override
	public ExceptionPlageHoraire findExceptionPlageHoraireById(int id) {
		return entityManager.find(ExceptionPlageHoraire.class, id);
	}

	@Override
	public List<ExceptionPlageHoraire> findAllExceptionPlageHoraire() {
		Query query = entityManager
				.createQuery("select e from ExceptionPlageHoraire e ");
		return query.getResultList();
	}

}
