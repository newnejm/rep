package com.yesserp.sessionbean.gf.modaliteConsommation;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gf.Frais;
import com.yesserp.domain.gf.ModaliteConsommation;

/**
 * Session Bean implementation class GestionModaliteConsommation
 */
@Stateless
@LocalBean
public class GestionModaliteConsommation implements
		GestionModaliteConsommationLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager entityManager;

	public GestionModaliteConsommation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterModaliteConsommation(
			ModaliteConsommation modaliteConsommation) {
		entityManager.persist(modaliteConsommation);

	}

	@Override
	public void supprimerModaliteConsommation(
			ModaliteConsommation modaliteConsommation) {
		entityManager.remove(entityManager.merge(modaliteConsommation));

	}

	@Override
	public void modifierModaliteConsommation(
			ModaliteConsommation modaliteConsommation) {
		entityManager.merge(modaliteConsommation);

	}

	@Override
	public ModaliteConsommation findById(Long id) {
		entityManager.find(ModaliteConsommation.class, id);
		return null;
	}

	@Override
	public List<ModaliteConsommation> findAll() {
		Query query = entityManager
				.createQuery("select m from ModaliteConsommation m");
		return query.getResultList();
	}

	@Override
	public void ajouterListeModaliteConsommation(
			List<ModaliteConsommation> modaliteConsommations) {

		try {
			ArrayList<ModaliteConsommation> modaliteArrayList = (ArrayList<ModaliteConsommation>) modaliteConsommations;
			for (int i = 0; i < modaliteArrayList.size(); i++) {
				ModaliteConsommation modaliteConsommation = modaliteArrayList
						.get(i);
				entityManager.persist(modaliteConsommation);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<ModaliteConsommation> findByFrais(Frais frais) {

		Query query = entityManager
				.createQuery("select m from ModaliteConsommation m join m.frais fr where fr.id = :id");
		query.setParameter("id", frais.getId());
		List<ModaliteConsommation> modalites = null;
		try {
			modalites = (List<ModaliteConsommation>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (modalites.size() > 0)
			return modalites;
		return null;
	}

	@Override
	public ModaliteConsommation findByType(String type) {
		Query query = entityManager
				.createQuery("select m from ModaliteConsommation m where type LIKE :type");
		query.setParameter("type", type);
		try {
			return (ModaliteConsommation) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<ModaliteConsommation> findByTypes(String type) {
		Query query = entityManager
				.createQuery("select m from ModaliteConsommation m where type LIKE :type");
		query.setParameter("type", type);
		List<ModaliteConsommation> modalites = null;
		try {
			modalites = (List<ModaliteConsommation>) query.getResultList();
		} catch (Exception e) {

		}
		if (modalites.size() > 0)
			return modalites;
		return null;
	}

}
