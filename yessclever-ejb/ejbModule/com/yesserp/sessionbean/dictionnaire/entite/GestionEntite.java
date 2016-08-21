package com.yesserp.sessionbean.dictionnaire.entite;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.dictionnaire.Domaine;
import com.yesserp.domain.dictionnaire.Entite;
import com.yesserp.domain.dictionnaire.Entite;
import com.yesserp.domain.ga.Affectation;

@Stateless
@LocalBean
public class GestionEntite implements GestionEntiteLocal{
	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	@Override
	public void ajouterEntite(Entite o) {
	em.persist(o);
		
	}

	@Override
	public void modifierEntite(Entite o) {
	em.merge(o);
		
	}

	@Override
	public void supprimerEntite(Entite o) {
	em.remove(em.merge(o));
		
	}

	@Override
	public List<Entite> findByDomaine(Domaine e) {
		// TODO Auto-generated method stub
		Query q = em
				.createQuery("select a from Entite a join a.domaine d  where d.id = :id");
		
		q.setParameter("id", e.getId());
		List<Entite> li = null;
		try {
			li = (List<Entite>) q.getResultList();
			return li;
		} catch (Exception ex) {
			return null;
		}
		
	}

	@Override
	public Entite findById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Entite.class,id);
	}

	@Override
	public List<Entite> findAll() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select a from Entite a");
		return query.getResultList();
		
	}
	
}
