package com.yesserp.sessionbean.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class Gestion implements GestionLocal{

	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public Gestion() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void insert(Object o) {
	
		em.persist(o);
		
		
	}

	@Override
	public void update(Object o) {
		em.merge(o);
		
	}

	@Override
	public void delete(Object o) {
		em.remove(em.contains(o) ?o : em.merge(o));
		
	}

	@Override
	public Object findById(Object o,Long id) {
		return em.find(o.getClass(),id);
	}

	@Override
	public List<Object> findAll(Object o) {
		
		Query query = em.createQuery("select a from "+ o.getClass().getSimpleName() +" a");
		return query.getResultList();
	}

	@Override
	public Object getId(Object o) {
		Object id = em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(o);
		return id;
	}

}
