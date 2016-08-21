package com.yesserp.sessionbean.paramgta.gestionactiviteabsence;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.ActiviteAbsence;
import com.yesserp.domain.gtaparam.ActivitePresence;
import com.yesserp.domain.gtaparam.Filtre;
import com.yesserp.domain.gtaparam.GroupeActivite;

/**
 * Session Bean implementation class GestionActiviteAbsence
 */
@Stateless
@LocalBean
public class GestionActiviteAbsence implements GestionActiviteAbsenceLocal {

	/**
	 * Default constructor.
	 */
	public GestionActiviteAbsence() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajouterActiviteAbsence(ActiviteAbsence activiteAbsence) {
		entityManager.persist(activiteAbsence);

	}

	@Override
	public void modifierActiviteAbsence(ActiviteAbsence activiteAbsence) {
		entityManager.merge(activiteAbsence);

	}

	@Override
	public void supprimerActiviteAbsence(ActiviteAbsence activiteAbsence) {
		entityManager.remove(entityManager.merge(activiteAbsence));

	}

	@Override
	public List<ActiviteAbsence> listerActiviteAbsence() {
		Query query = entityManager
				.createQuery("SELECT aabs FROM ActiviteAbsence aabs");
		return query.getResultList();
	}

	@Override
	public ActiviteAbsence findActiviteAbsenceById(int id) {
		return entityManager.find(ActiviteAbsence.class, id);
	}

	@Override
	public ActiviteAbsence findActiviteAbsenceByCode(String code) {
		Query query = entityManager
				.createQuery("SELECT aabs FROM ActiviteAbsence aabs WHERE codeaabs=:x");
		query.setParameter("x", code);
		return (ActiviteAbsence) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActiviteAbsence> getActivieAbsenceParFilter(Filtre f) {
		// TODO Auto-generated method stub
		Query query = entityManager
				.createQuery("select e from ActiviteAbsence e where:x member of e.filtres");
		query.setParameter("x", f);
		return query.getResultList();
	}

	@Override
	public List<ActiviteAbsence> getActiviteAbsencesParGroupe(GroupeActivite ga) {
		// TODO Auto-generated method stub

		Query query = entityManager
				.createQuery("select a from ActiviteAbsence a inner join a.groupeActivites ag where ag=:x");
		query.setParameter("x", ga);
		return query.getResultList();
	}

	@Override
	public List<ActiviteAbsence> getActiviteAbsencesNotInGroupe(
			GroupeActivite ga) {
		Query query = entityManager
				.createQuery("select a from ActiviteAbsence a where a not in (select c from ActiviteAbsence c inner join c.groupeActivites acv where acv=:x)");
		query.setParameter("x", ga);
		return query.getResultList();
	}

	@Override
	public List<ActiviteAbsence> findAll() {
		Query query = entityManager
				.createQuery("SELECT aabs FROM ActiviteAbsence aabs");
		return query.getResultList();
	}
	
	
	@Override
	public List<String> findALLCode() {
		
		Query query = entityManager.createQuery("SELECT aabs.codeaabs FROM ActiviteAbsence aabs") ;
		return query.getResultList();
	}
	
	
	
	
	
	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<ActiviteAbsence> findByGroupeActivite(
//			GroupeActivite groupeActivite) {
//		Query query = entityManager
//				.createQuery("SELECT abs FROM ActiviteAbsence abs WHERE :groupeActivite MEMBER OF abs.groupeActivite");
//		query.setParameter("groupeActivite", groupeActivite);
//		return ((List<ActiviteAbsence>) query.getResultList());
//	}

}
