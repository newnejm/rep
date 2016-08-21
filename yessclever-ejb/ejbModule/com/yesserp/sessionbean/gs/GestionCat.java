package com.yesserp.sessionbean.gs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gs.Categorie;
import com.yesserp.domain.gs.Sous_Categorie;

/**
 * Session Bean implementation class GestionCat
 */
@Stateless
@LocalBean
public class GestionCat implements GestionCatLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public GestionCat() {
		// TODO Auto-generated constructor stub
	}

	public void create(String nom) {
		Categorie cat = new Categorie(nom);
		em.persist(cat);
	}

	public void delete(String nom) {
		Categorie cat = null;
		Query q = em
				.createQuery("SELECT c FROM Categorie c WHERE c.nom = :val");
		q.setParameter("val", nom);
		try {
			cat = (Categorie) q.getSingleResult();
			em.remove(cat);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public Categorie consulter(String nom) {
		Categorie c;
		try {
			c = (Categorie) em
					.createQuery("SELECT c FROM Categorie c where c.nom = :nom")
					.setParameter("nom", nom).getSingleResult();
		} catch (Exception e) {
			return null;
		}
		return c;

	}

	public void create(List<Categorie> lc) {
		for (Categorie c : lc) {
			this.create(c.getNom());
		}
	}

	public void delete(List<Categorie> lcd) {
		for (Categorie c : lcd) {
			this.delete(c.getNom());
		}

	}

	public List<Categorie> consulter() {
		ArrayList<Categorie> c = (ArrayList<Categorie>) em.createQuery(
				"SELECT c FROM  Categorie c").getResultList();
		return c;
	}

	@Override
	public void create(Categorie sc) {
		// TODO Auto-generated method stub
		em.persist(sc);
	}

	@Override
	public Categorie consulter(int id) {

		return (em.find(Categorie.class, id));
	}

}
