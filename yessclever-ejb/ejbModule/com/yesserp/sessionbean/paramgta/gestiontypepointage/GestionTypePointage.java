package com.yesserp.sessionbean.paramgta.gestiontypepointage;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.entities.RefPointage;
import com.yesserp.domain.gta.TypePointage;
import com.yesserp.domain.gtaparam.DescJourneeType;

/**
 * Session Bean implementation class GestionTypePointage
 */
@Stateless
@LocalBean
public class GestionTypePointage implements GestionTypePointageLocal {

	/**
	 * Default constructor.
	 */
	public GestionTypePointage() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajouterTypePointage(TypePointage typePointage) {
		entityManager.persist(typePointage);

	}

	@Override
	public void modifierTypePointage(TypePointage typePointage) {
		entityManager.merge(typePointage);

	}

	@Override
	public void supprimerTypePointage(TypePointage typePointage) {
		entityManager.remove(entityManager.merge(typePointage));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypePointage> findAll() {
		Query query = entityManager
				.createQuery("SELECT tp FROM TypePointage tp");
		return query.getResultList();
	}
	
}
