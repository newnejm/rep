package com.yesserp.sessionbean.gta.gestionOccurence;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.ContratGta;

/**
 * Session Bean implementation class GestionOccurence
 */
@Stateless
@LocalBean
public class GestionOccurence implements GestionOccurenceLocal {

	/**
	 * Default constructor.
	 */
	public GestionOccurence() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void ajouterOccurence(ContratGta ContratGta) {
		entityManager.persist(ContratGta);

	}

	@Override
	public void supprimerOccurence(ContratGta ContratGta) {
		entityManager.remove(entityManager.merge(ContratGta));
	}

	@Override
	public void modifierOccurence(ContratGta ContratGta) {
		entityManager.merge(ContratGta);

	}

	@Override
	public ContratGta findOccurenceById(int id) {
		return entityManager.find(ContratGta.class, id);
	}

	@Override
	public List<ContratGta> findAllOccurences() {
		Query query = entityManager.createQuery("select o from ContratGta o ");
		return query.getResultList();
	}

	@Override
	public List<Identite> trouverEmployeesGereParLaGTA(boolean gere) {
		Query query = entityManager
				.createQuery("select i from Identite i join i.contratGta c where c.gta=:con");
		query.setParameter("con", gere);
		return query.getResultList();

	}

	@Override
	public List<ContratGta> findAllContratById(int id) {
		Query query = entityManager.createQuery("select i from ContratGta i where i.id=:id");
		query.setParameter("id", id);
		return query.getResultList();
	}

	@Override
	public List<ContratGta> findAllContratByIdentite(Identite identite) {
		Query query = entityManager.createQuery("select i from ContratGta i where i.identite=:id");
		query.setParameter("id", identite);
		return query.getResultList();
	}

	@Override
	public ContratGta findContratByIdentite(Identite identite) {
		Query query = entityManager.createQuery("select i from ContratGta i where i.identite=:id");
		query.setParameter("id", identite);
		return (ContratGta) query.getSingleResult();
	}



	

}
