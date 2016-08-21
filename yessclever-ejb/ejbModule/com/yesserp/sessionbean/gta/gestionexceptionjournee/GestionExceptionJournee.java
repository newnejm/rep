package com.yesserp.sessionbean.gta.gestionexceptionjournee;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.Exceptionjournee;
import com.yesserp.domain.gtaparam.JourneeType;

/**
 * Session Bean implementation class GestionExceptionJournee
 */
@Stateless
@LocalBean
public class GestionExceptionJournee implements GestionExceptionJourneeLocal {

	/**
	 * Default constructor.
	 */
	public GestionExceptionJournee() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void ajouterExceptionjournee(Exceptionjournee exceptionjournee) {
		entityManager.persist(exceptionjournee);

	}

	@Override
	public void supprimerExceptionjournee(Exceptionjournee exceptionjournee) {
		entityManager.remove(entityManager.merge(exceptionjournee));

	}

	@Override
	public void modifierExceptionjournee(Exceptionjournee exceptionjournee) {
		entityManager.merge(exceptionjournee);

	}

	@Override
	public Exceptionjournee findExceptionjourneeById(int id) {
		return entityManager.find(Exceptionjournee.class, id);
	}

	@Override
	public List<Exceptionjournee> findAllExceptionjournee() {
		Query query = entityManager
				.createQuery("select e from Exceptionjournee e");
		return query.getResultList();
	}

	@Override
	public List<Exceptionjournee> findJourneFromException(Identite identite) {
		Query query = entityManager
				.createQuery("select e from Exceptionjournee e where e.identite=:id");
		query.setParameter("id", identite);
		return query.getResultList();
		
	}

}
