package com.yesserp.sessionbean.gs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gs.Categorie;
import com.yesserp.domain.gs.Categorie;
import com.yesserp.domain.gs.Sous_Categorie;
import com.yesserp.type.gs.TypeLivr;

/**
 * Session Bean implementation class GestionSCat
 */
@Stateless
@LocalBean
public class GestionSCat implements GestionSCatLocal {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public GestionSCat() {
		// TODO Auto-generated constructor stub
	}

	public void create(String nom, Categorie c) {
		Sous_Categorie scat = new Sous_Categorie(nom);
		scat.setCat(c);
		em.persist(scat);
	}

	public void create(List<Sous_Categorie> lsc, Categorie c) {
		for (Sous_Categorie sc : lsc) {
			this.create(sc.getNom(), c);
		}
	}

	public void delete(String nom) {
		Sous_Categorie scat = null;
		Query q = em
				.createQuery("SELECT c FROM Sous_Categorie c WHERE c.nom = :val");
		q.setParameter("val", nom);
		try {
			scat = (Sous_Categorie) q.getSingleResult();
			em.remove(scat);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void delete(List<Sous_Categorie> lsd) {
		for (Sous_Categorie sc : lsd) {
			this.delete(sc.getNom());
		}
	}

	public Sous_Categorie consulter(String nom) {
		Sous_Categorie c;
		try {
			c = (Sous_Categorie) em
					.createQuery(
							"SELECT c FROM  Sous_Categorie c where c.nom = :nom")
					.setParameter("nom", nom).getSingleResult();
		} catch (Exception e) {
			return null;
		}
		return c;
	}

	public List<Sous_Categorie> consulter() {

		ArrayList<Sous_Categorie> c = (ArrayList<Sous_Categorie>) em
				.createQuery("SELECT c FROM  Sous_Categorie c").getResultList();
		return c;
	}

	public List<Sous_Categorie> consulter(Categorie cat) {
		ArrayList<Sous_Categorie> lsc = (ArrayList<Sous_Categorie>) em
				.createQuery(
						"SELECT c FROM  Sous_Categorie c where c.cat= :cat")
				.setParameter("cat", cat).getResultList();
		return lsc;
	}

	@Override
	public void delete(Sous_Categorie selectedScat) {

		selectedScat = em.find(Sous_Categorie.class, selectedScat.getId());
		em.remove(selectedScat);
	}

}
