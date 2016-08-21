package com.yesserp.sessionbean.paramgta.gestioncategoriedroit;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.yesserp.domain.gtaparam.CategorieDroit;

/**
 * Session Bean implementation class GestionCategorieDroit
 */
@Stateless
@LocalBean
public class GestionCategorieDroit implements GestionCategorieDroitLocal {

	/**
	 * Default constructor.
	 */
	public GestionCategorieDroit() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajouterCategorieDroit(CategorieDroit categorieDroit) {
		entityManager.persist(categorieDroit);

	}

	@Override
	public void modifierCategorieDroit(CategorieDroit categorieDroit) {
		entityManager.merge(categorieDroit);

	}

	@Override
	public CategorieDroit findCategorieDroitByCode(String code) {
		Query query = entityManager
				.createQuery("select cpt from CategorieDroit cpt where cpt.codec=:x");
		query.setParameter("x", code);
		return (CategorieDroit) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategorieDroit> listeCategorieDroits() {
		Query query = entityManager.createQuery("select cpt from CategorieDroit cpt");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategorieDroit> findAll() {
		Query query = entityManager.createQuery("select c from CategorieDroit c");
		return query.getResultList();
	}


}
