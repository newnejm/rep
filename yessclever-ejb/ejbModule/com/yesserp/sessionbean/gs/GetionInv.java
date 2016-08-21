package com.yesserp.sessionbean.gs;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.yesserp.domain.gs.Categorie;
import com.yesserp.domain.gs.Inventaire;

/**
 * Session Bean implementation class GetionInv
 */
@Stateless
@LocalBean
public class GetionInv implements GetionInvLocal {

	/**
	 * Default constructor.
	 */

	@PersistenceContext
	EntityManager em;

	public GetionInv() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Inventaire> consulter() {
		return ((List<Inventaire>) em.createQuery("SELECT i FROM Inventaire i")
				.getResultList());
	}

	@Override
	public void update(Inventaire inventaire) {
		// TODO Auto-generated method stub
		inventaire = this.consulter(inventaire.getId());
		em.merge(inventaire);

	}

	@Override
	public Inventaire consulter(int id) {
		Inventaire i;
		try {
			i = (Inventaire) em
					.createQuery("SELECT i FROM Inventaire i where i.id = :id")
					.setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			return null;
		}
		return i;
	}

	@Override
	public void create() {
		Inventaire i = new Inventaire();
		java.sql.Date dateSQL = new java.sql.Date(new Date().getTime());
		java.util.Date d = new Date();
		i.setDate(d);
		em.persist(i);
	}

	@Override
	public void delete(int id) {
		em.remove(this.consulter(id));
	}
}
