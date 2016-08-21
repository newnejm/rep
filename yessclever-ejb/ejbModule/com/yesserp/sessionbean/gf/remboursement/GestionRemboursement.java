package com.yesserp.sessionbean.gf.remboursement;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gf.Frais;
import com.yesserp.domain.gf.Remboursement;

/**
 * Session Bean implementation class GestionRemboursement
 */
@Stateless
@LocalBean
public class GestionRemboursement implements GestionRemboursementLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager entityManager;

	public GestionRemboursement() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterRemboursement(Remboursement remboursement) {
		entityManager.persist(remboursement);

	}

	@Override
	public void modifierRemboursement(Remboursement remboursement) {
		entityManager.merge(remboursement);

	}

	@Override
	public void supprimerRemboursement(Remboursement remboursement) {
		entityManager.remove(entityManager.merge(remboursement));

	}

	@Override
	public Remboursement findById(Long id) {
		return entityManager.find(Remboursement.class, id);

	}

	@Override
	public List<Remboursement> findAll() {
		Query query = entityManager
				.createQuery("select r from Remboursement r");
		return query.getResultList();
	}

	@Override
	public void ajouterListeRemboursement(List<Remboursement> remboursements) {
		try {
			ArrayList<Remboursement> remboursementArrayList = (ArrayList<Remboursement>) remboursements;
			for (int i = 0; i < remboursementArrayList.size(); i++) {
				Remboursement remboursement = remboursementArrayList.get(i);
				entityManager.persist(remboursement);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public List<Remboursement> findByFrais(Frais frais) {
		Query query = entityManager
				.createQuery("select r from Remboursement r join r.frais fr where fr.id = :id");
		query.setParameter("id", frais.getId());
		List<Remboursement> remboursements = null;
		try {
			remboursements = (List<Remboursement>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (remboursements.size() > 0)
			return remboursements;
		return null;
	}

	@Override
	public Remboursement findByType(String type) {
		Query query = entityManager
				.createQuery("select r from Remboursement r where type LIKE :type");
		query.setParameter("type", type);
		try {
			return (Remboursement) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Remboursement> findByTypes(String type) {
		Query query = entityManager
				.createQuery("select r from Remboursement r where type LIKE :type");
		query.setParameter("type", type);
		List<Remboursement> remboursements = null;
		try {
			remboursements = (List<Remboursement>) query.getResultList();
		} catch (Exception e) {

		}
		if (remboursements.size() > 0)
			return remboursements;
		return null;
	}

}
