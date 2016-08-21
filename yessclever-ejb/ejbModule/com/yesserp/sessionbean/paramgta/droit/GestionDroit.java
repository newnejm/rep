package com.yesserp.sessionbean.paramgta.droit;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.Droit;

/**
 * Session Bean implementation class GestionLibelle
 */
@Stateless
@LocalBean
public class GestionDroit implements GestionDroitLocal {

	/**
	 * Default constructor.
	 */
	public GestionDroit() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajoutDroit(Droit droit) {
		entityManager.persist(droit);

	}

	@Override
	public void supprimerDroit(Droit droit) {
		entityManager.remove(entityManager.merge(droit));

	}

	@Override
	public void modifierDroit(Droit droit) {
		entityManager.merge(droit);

	}

	@Override
	public List<Droit> listerDroit() {
		Query query = entityManager.createQuery("SELECT l FROM Unite l");
		return query.getResultList();
	}

	@Override
	public Droit findDroitById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
