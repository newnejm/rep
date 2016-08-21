package com.yesserp.domain.dao.impl;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.dao.BaseDao;
import com.yesserp.domain.entities.BaseEntity;

@Stateless
@LocalBean
public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

	@PersistenceContext
	protected EntityManager em;

	public T create(T t) {
		em.persist(t);
		return t;
	}

	public T find(Class type, Object id) {
		return (T) em.find(type, id);
	}

	public void delete(Class type, Object id) {
		Object ref = em.getReference(type, id);
		em.remove(ref);
	}

	public T update(T t) {
		return (T) em.merge(t);
	}

	@SuppressWarnings("rawtypes")
	public List findWithNamedQuery(String namedQueryName) {
		return em.createNamedQuery(namedQueryName).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findWithNamedQuery(String queryName, int resultLimit) {
		return em.createNamedQuery(queryName).setMaxResults(resultLimit)
				.getResultList();
	}

	@SuppressWarnings("rawtypes")
	public List findByNativeQuery(String sql, Class type) {
		return em.createNativeQuery(sql, type).getResultList();
	}
	
	@Override
	public List<T> findAll(){
		Query query = em.createQuery("SELECT c FROM T c");
		return query.getResultList();
	}

}
