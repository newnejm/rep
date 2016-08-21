package com.yesserp.sessionbean.paramgta.gestionactivitepresence;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.ActivitePresence;
import com.yesserp.domain.gtaparam.GroupeActivite;

/**
 * Session Bean implementation class GestionActivitePresence
 */
@Stateless
@LocalBean
public class GestionActivitePresence implements GestionActivitePresenceLocal {

	/**
	 * Default constructor.
	 */

	public GestionActivitePresence() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajouterActivitePresence(ActivitePresence activitePresence) {
		entityManager.persist(activitePresence);

	}

	@Override
	public void modifierActivitePresence(ActivitePresence activitePresence) {
		entityManager.merge(activitePresence);

	}

	@TransactionAttribute
	@Override
	public void supprimerActivitePresence(ActivitePresence activitePresence) {
		entityManager.remove(entityManager.merge(activitePresence));
	}

	@Override
	public ActivitePresence findActivitePresenceById(int id) {
		return entityManager.find(ActivitePresence.class, id);
	}

	@Override
	public ActivitePresence findActivitePresenceByCode(String code) {

		Query query = entityManager
				.createQuery("SELECT apre FROM ActivitePresence apre WHERE codeap=:x");
		query.setParameter("x", code);
		return (ActivitePresence) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActivitePresence> findAll() {
		Query query = entityManager
				.createQuery("SELECT apre FROM ActivitePresence apre");
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActivitePresence> getActivitePresencesNotInGroupe(
			GroupeActivite groupeActivite) {
		Query query = entityManager
				.createQuery("select a from ActivitePresence a where a not in (select c from ActivitePresence c inner join c.groupeActivites acv where acv=:x)");
		query.setParameter("x", groupeActivite);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActivitePresence> getActivitePresencesParGroupe(
			GroupeActivite ga) {

		Query query = entityManager
				.createQuery("select a from ActivitePresence a inner join a.groupeActivites ag where ag=:x");
		query.setParameter("x", ga);
		return query.getResultList();

	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<ActivitePresence> findByGroupeActivite(
//			GroupeActivite groupeActivite) {
//		Query query = entityManager
//				.createQuery("SELECT ap FROM ActivitePresence ap WHERE :groupeActivite MEMBER OF ap.groupeActivite");
//		query.setParameter("groupeActivite", groupeActivite);
//		return ((List<ActivitePresence>) query.getResultList());
//	}
}
