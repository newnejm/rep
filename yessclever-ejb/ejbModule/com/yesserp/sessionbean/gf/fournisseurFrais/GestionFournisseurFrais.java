package com.yesserp.sessionbean.gf.fournisseurFrais;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gf.FournisseurFrais;

/**
 * Session Bean implementation class GestionFournisseurFrais
 */
@Stateless
@LocalBean
public class GestionFournisseurFrais implements GestionFournisseurFraisLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager entityManager;

	public GestionFournisseurFrais() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterFournisseurFrais(FournisseurFrais fournisseurFrais) {
		entityManager.persist(fournisseurFrais);

	}

	@Override
	public void modifierFournisseurFrais(FournisseurFrais fournisseurFrais) {
		entityManager.merge(fournisseurFrais);

	}

	@Override
	public void supprimerFournisseurFrais(FournisseurFrais fournisseurFrais) {
		entityManager.remove(entityManager.merge(fournisseurFrais));

	}

	@Override
	public FournisseurFrais findById(Long id) {

		return entityManager.find(FournisseurFrais.class, id);
	}

	@Override
	public List<FournisseurFrais> findAll() {
		Query query = entityManager
				.createQuery("select f from FournisseurFrais f");
		return query.getResultList();
	}

	@Override
	public void ajouterListeFournisseurFrais(
			List<FournisseurFrais> fournisseurFraiss) {
		try {
			ArrayList<FournisseurFrais> fournisseurArrayList = (ArrayList<FournisseurFrais>) fournisseurFraiss;
			for (int i = 0; i < fournisseurArrayList.size(); i++) {
				FournisseurFrais fournisseurFrais = fournisseurArrayList.get(i);
				entityManager.persist(fournisseurFrais);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public FournisseurFrais findByNom(String nom) {
		Query query = entityManager
				.createQuery("select f from FournisseurFrais f where nom LIKE :nom");
		query.setParameter("nom", nom);
		try {
			return (FournisseurFrais) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<FournisseurFrais> findByNoms(String nom) {
		Query query = entityManager
				.createQuery("select f from FournisseurFrais f where nom LIKE :nom");
		query.setParameter("nom", nom);
		List<FournisseurFrais> fournisseurs = null;
		try {
			fournisseurs = (List<FournisseurFrais>) query.getResultList();
		} catch (Exception e) {

		}
		if (fournisseurs.size() > 0)
			return fournisseurs;
		return null;
	}

}
