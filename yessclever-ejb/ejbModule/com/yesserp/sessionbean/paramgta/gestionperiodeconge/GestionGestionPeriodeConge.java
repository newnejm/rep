package com.yesserp.sessionbean.paramgta.gestionperiodeconge;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.GestionPeriodeConge;

/**
 * Session Bean implementation class GestionLibelle
 */
@Stateless
@LocalBean
public class GestionGestionPeriodeConge implements GestionGestionPeriodeCongeLocal {

	/**
	 * Default constructor.
	 */
	public GestionGestionPeriodeConge() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajoutGestionPeriodeConge(GestionPeriodeConge gestionPeriodeConge) {
		entityManager.persist(gestionPeriodeConge);

	}

	@Override
	public void supprimerGestionPeriodeConge(GestionPeriodeConge gestionPeriodeConge) {
		entityManager.remove(entityManager.merge(gestionPeriodeConge));

	}

	@Override
	public void modifierGestionPeriodeConge(GestionPeriodeConge gestionPeriodeConge) {
		entityManager.merge(gestionPeriodeConge);

	}

	@Override
	public List<GestionPeriodeConge> listerGestionPeriodeConge() {
		Query query = entityManager.createQuery("SELECT l FROM GestionPeriodeConge l");
		return query.getResultList();
	}

	@Override
	public GestionPeriodeConge findGestionPeriodeCongeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
