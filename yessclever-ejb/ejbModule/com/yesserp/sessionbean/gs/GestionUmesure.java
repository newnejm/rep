package com.yesserp.sessionbean.gs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.yesserp.domain.gs.Umesure;

@Stateless
@LocalBean
public class GestionUmesure implements GestionUmesureLocal {

	@PersistenceContext
	EntityManager em;

	public GestionUmesure() {
	}

	public void create(Umesure umes) {
		em.persist(umes);
	}

	public void delete(Umesure umes) {
		em.remove(umes);
	}

	public Umesure consult(String nom) {
		Umesure um;
		try {
			um = (Umesure) em
					.createQuery(
							"SELECT um FROM  Umesure um where um.nom = :nom")
					.setParameter("nom", nom).getSingleResult();
		} catch (Exception e) {
			return null;
		}
		return um;
	}

	public List<Umesure> consult() {
		List<Umesure> lum = (List<Umesure>) em.createQuery(
				"SELECT um FROM  Umesure um").getResultList();
		return lum;
	}
}
