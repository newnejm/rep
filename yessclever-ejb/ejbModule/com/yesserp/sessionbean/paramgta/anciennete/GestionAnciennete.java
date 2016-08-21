package com.yesserp.sessionbean.paramgta.anciennete;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.Anciennete;


/**
 * Session Bean implementation class GestionLibelle
 */
@Stateless
@LocalBean
public class GestionAnciennete implements GestionAncienneteLocal {

	/**
	 * Default constructor.
	 */
	public GestionAnciennete() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajoutAnciennete(Anciennete anciennete) {
		entityManager.persist(anciennete);

	}

	@Override
	public void supprimerAnciennete(Anciennete anciennete) {
		entityManager.remove(entityManager.merge(anciennete));

	}

	@Override
	public void modifierAnciennete(Anciennete anciennete) {
		entityManager.merge(anciennete);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Anciennete> listerAnciennete() {
		Query query = entityManager.createQuery("SELECT l FROM Anciennete l");
		return query.getResultList();
	}

	// modification Anciennete <- AncienneteDroit by yassine
	@Override
	public Anciennete findAncienneteById(int id) {
		return entityManager.find(Anciennete.class, id);

	}

	

}
