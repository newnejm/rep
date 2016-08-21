package com.yesserp.sessionbean.gta.gestiontypecalcul;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gta.TypeCalucle;

/**
 * Session Bean implementation class GestionTypeCalcul
 */
@Stateless
@LocalBean
public class GestionTypeCalcul implements GestionTypeCalculLocal {

	/**
	 * Default constructor.
	 */
	public GestionTypeCalcul() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void ajouterTypeCalucle(TypeCalucle typeCalucle) {
		entityManager.persist(typeCalucle);

	}

	@Override
	public void supprimerTypeCalucle(TypeCalucle typeCalucle) {
		entityManager.remove(entityManager.merge(typeCalucle));

	}

	@Override
	public void modifierTypeCalucle(TypeCalucle typeCalucle) {
		entityManager.merge(typeCalucle);
	}

	@Override
	public TypeCalucle findTypeCalucleById(int id) {
		return entityManager.find(TypeCalucle.class, id);
	}

	@Override
	public List<TypeCalucle> findAllTypeCalucle() {
		Query query = entityManager.createQuery("select t from TypeCalucle t ");
		return query.getResultList();
	}

	@Override
	public TypeCalucle findTypeCalculParNom(String nom) {
		Query query = entityManager
				.createQuery("select t from TypeCalucle t where t.type=:x");
		query.setParameter("x", nom);
		return (TypeCalucle) query.getSingleResult();
	}

}
