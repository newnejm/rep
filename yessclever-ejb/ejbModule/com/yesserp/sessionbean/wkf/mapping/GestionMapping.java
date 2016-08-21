package com.yesserp.sessionbean.wkf.mapping;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.wkf.Mapping;
import com.yesserp.sessionbean.wkf.mapping.GestionMappingLocal;

@Stateless
@LocalBean
public class GestionMapping implements GestionMappingLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public GestionMapping() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterMapping(Mapping mapping) {

		em.persist(mapping);
	}

	@Override
	public void supprimerMapping(Mapping mapping) {

		em.remove(em.merge(mapping));

	}

	@Override
	public void modifierMapping(Mapping mapping) {

		em.merge(mapping);

	}

	@Override
	public Mapping trouverParId(Long id) {

		return em.find(Mapping.class, id);
	}

	@Override
	public List<Mapping> trouverMappingsParEntite(String entite) {
		Query q = em
				.createQuery("select i from Mapping i where entite = :entite");
		q.setParameter("entite", entite);
		List<Mapping> li = null;
		try {
			li = (List<Mapping>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

}
