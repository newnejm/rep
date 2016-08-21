package com.yesserp.sessionbean.dictionnaire.attribut;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.dictionnaire.Attribut;
import com.yesserp.domain.dictionnaire.Entite;

@Stateless
@LocalBean
public class GestionAttribut implements GestionAttributLocal{

	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	@Override
	public void ajouterAttribut(Attribut o) {
		// TODO Auto-generated method stub
		em.persist(o);
	}

	@Override
	public void modifierAttribut(Attribut o) {
		// TODO Auto-generated method stub
		em.merge(o);
	}

	@Override
	public void supprimerAttribut(Attribut o) {
		// TODO Auto-generated method stub
		em.remove(em.merge(o));
	}

	@Override
	public List<Attribut> findByEntite(Entite e) {
		Query q = em
				.createQuery("select a from Attribut a join a.entite d  where d.nom = :nom");
		
		q.setParameter("nom", e.getNom());
		List<Attribut> li = null;
		try {
			li = (List<Attribut>) q.getResultList();
			return li;
		} catch (Exception ex) {
			return null;
		}
		
	}

	@Override
	public Attribut findById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Attribut.class, id);
	}

	@Override
	public List<Attribut> findAll() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select a from Attribut a");
		return query.getResultList();
		
	}

	@Override
	public List<Attribut> findByEntiteAndConstraint(Entite e, String contrainte) {
		Query q = em
				.createQuery("select a from Attribut a join a.entite d  where d.nom = :nom and a.contrainte= :ctr");
		
		q.setParameter("nom", e.getNom());
		q.setParameter("ctr", contrainte);
		List<Attribut> li = null;
		try {
			li = (List<Attribut>) q.getResultList();
			return li;
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public List<Attribut> findByEntiteAndComplexity(Entite e, String complexite) {
		Query q = em
				.createQuery("select a from Attribut a join a.entite d  where d.nom = :nom and a.complexite= :ctr");
		
		q.setParameter("nom", e.getNom());
		q.setParameter("ctr", complexite);
		List<Attribut> li = null;
		try {
			li = (List<Attribut>) q.getResultList();
			return li;
		} catch (Exception ex) {
			return null;
		}
	}
}
