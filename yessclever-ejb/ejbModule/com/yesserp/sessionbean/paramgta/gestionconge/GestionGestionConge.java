package com.yesserp.sessionbean.paramgta.gestionconge;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.GestionConge;


/**
 * Session Bean implementation class GestionLibelle
 */
@Stateless
@LocalBean
public class GestionGestionConge implements GestionGestionCongeLocal {

	/**
	 * Default constructor.
	 */
	public GestionGestionConge() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajoutGestionConge(GestionConge gestionConge) {
		entityManager.persist(gestionConge);

	}

	@Override
	public void supprimerGestionConge(GestionConge gestionConge) {
		entityManager.remove(entityManager.merge(gestionConge));

	}

	@Override
	public void modifierGestionConge(GestionConge gestionConge) {
		entityManager.merge(gestionConge);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GestionConge> listerGestionConge() {
		Query query = entityManager.createQuery("SELECT l FROM GestionCongeDroit l");
		return query.getResultList();
	}

	// modification GestionConge <- GestionCongeDroit by yassine
	@Override
	public GestionConge findGestionCongeById(int id) {
		return entityManager.find(GestionConge.class, id);

	}

	

}
