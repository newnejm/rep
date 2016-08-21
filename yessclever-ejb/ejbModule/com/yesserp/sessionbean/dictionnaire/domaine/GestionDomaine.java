package com.yesserp.sessionbean.dictionnaire.domaine;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.dictionnaire.Domaine;

@Stateless
@LocalBean
public class GestionDomaine implements GestionDomaineLocal {

	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;
	@Override
	public void ajouterDomaine(Domaine o) {
		// TODO Auto-generated method stub
		em.persist(o);
	}

	@Override
	public void modifierDomaine(Domaine o) {
		// TODO Auto-generated method stub
	em.merge(o);
	}

	@Override
	public void supprimerDomaine(Domaine o) {
		// TODO Auto-generated method stub
		em.remove(em.merge(o));
	}

	@Override
	public Domaine findById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Domaine.class, id);
	}

	@Override
	public List<Domaine> findAll() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select a from Domaine a");
		return query.getResultList();
		
	}

}
