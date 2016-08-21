package com.yesserp.sessionbean.gta.gestionexceptionsemaine;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.ExceptionSemaineType;
import com.yesserp.domain.gtaparam.SemaineType;

/**
 * Session Bean implementation class GestionExceptionSemaine
 */
@Stateless
@LocalBean
public class GestionExceptionSemaine implements GestionExceptionSemaineLocal {

	/**
	 * Default constructor.
	 */
	public GestionExceptionSemaine() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void ajouterExceptionSemaineType(
			ExceptionSemaineType exceptionSemaineType) {
		entityManager.persist(exceptionSemaineType);

	}

	@Override
	public void supprimerExceptionSemaineType(
			ExceptionSemaineType exceptionSemaineType) {
		entityManager.remove(entityManager.merge(exceptionSemaineType));

	}

	@Override
	public void modifierExceptionSemaineType(
			ExceptionSemaineType exceptionSemaineType) {
		entityManager.merge(exceptionSemaineType);

	}

	@Override
	public ExceptionSemaineType findExceptionSemaineTypeById(int id) {
		return entityManager.find(ExceptionSemaineType.class, id);
	}

	@Override
	public List<ExceptionSemaineType> findAllExceptionSemaineType() {
		Query query = entityManager
				.createQuery("select s from ExceptionSemaineType s ");
		return query.getResultList();
	}

	@Override
	public SemaineType findExceptionForSemainetype(Identite identite, Date date) {
		SemaineType semaineType = new SemaineType();
		ExceptionSemaineType exceptionSemaineType = new ExceptionSemaineType();
		Query query = entityManager
				.createQuery("select e ExceptionSemaineType e where e.identite=:id and e.dateChangement=:date");
		query.setParameter("id", identite);
		query.setParameter("date", date);
		exceptionSemaineType = (ExceptionSemaineType) query.getSingleResult();
		semaineType = exceptionSemaineType.getSemaineType();
		return semaineType;
	}

	@Override
	public List<ExceptionSemaineType> findExceptionSemaineForEmployee(
			Identite identite) {
		Query query = entityManager
				.createQuery("select e ExceptionSemaineType e where e.identite=:id ");
		query.setParameter("id",identite);
		return query.getResultList();
	}

}
