package com.yesserp.sessionbean.gf.frais;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gf.Frais;

/**
 * Session Bean implementation class GestionFrais
 */
@Stateless
@LocalBean
public class GestionFrais implements GestionFraisLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager entityManager;

	public GestionFrais() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterFrais(Frais frais) {
		entityManager.persist(frais);

	}

	@Override
	public void supprimerFrais(Frais frais) {
		entityManager.remove(entityManager.merge(frais));

	}

	@Override
	public void modifierFrais(Frais frais) {
		entityManager.merge(frais);

	}

	@Override
	public Frais findById(Long id) {
		return entityManager.find(Frais.class, id);
	}

	@Override
	public List<Frais> findAll() {
		Query query = entityManager.createQuery("select f from Frais f");
		return query.getResultList();
	}

	@Override
	public Frais findByType(String type) {
		Query query = entityManager
				.createQuery("select f from Frais f where type LIKE :type");
		query.setParameter("type", type);

		try {
			return (Frais) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<Frais> findByTypes(String type) {
		Query query = entityManager
				.createQuery("select f from Frais f where type LIKE :type");
		query.setParameter("type", type);
		List<Frais> frais = null;
		try {
			frais = (List<Frais>) query.getResultList();
		} catch (Exception e) {

		}
		if (frais.size() > 0)
			return frais;
		return null;
	}

}
