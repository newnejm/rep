package com.yesserp.sessionbean.paramgta.gestionAnomalie;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.Anomalie;

/**
 * Session Bean implementation class GestionAnomalie
 */
@Stateless
@LocalBean
public class GestionAnomalie implements GestionAnomalieLocal {

	/**
	 * Default constructor.
	 */

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	public GestionAnomalie() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterAnomalie(Anomalie anomalie) {
		// TODO Auto-generated method stub
		entityManager.persist(anomalie);
	}

	@Override
	public void modifierAnomalie(Anomalie anomalie) {
		// TODO Auto-generated method stub
		entityManager.merge(anomalie);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Anomalie> listeAnomalies() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("select cpt from Anomalie cpt");
		return query.getResultList();
	}

}
