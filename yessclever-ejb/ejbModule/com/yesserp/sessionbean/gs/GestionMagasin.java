package com.yesserp.sessionbean.gs;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.yesserp.domain.gs.Lot;
import com.yesserp.domain.gs.Magasin;
import com.yesserp.type.gs.TypeMagasin;

/**
 * Session Bean implementation class GestionMagasin
 */
@Stateless
@LocalBean
public class GestionMagasin implements GestionMagasinLocal {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public GestionMagasin() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Magasin m) {
		em.persist(m);
	}

	@Override
	public void delete(Magasin m) {
		if (em.contains(m)) {
			em.remove(m);
		} else {
			m = em.find(Magasin.class, m.getId());
			em.remove(m);
		}

	}

	@Override
	public Magasin consulter(String nom) {
		Magasin lm;
		try {
			lm = (Magasin) em
					.createQuery("SELECT m FROM Magasin m where m.nom = :nom")
					.setParameter("nom", nom).getSingleResult();

		} catch (Exception e) {
			return null;
		}
		return lm;
	}

	@Override
	public List<Magasin> consulter() {
		return ((List<Magasin>) em.createQuery("SELECT m FROM Magasin m")
				.getResultList());
	}

	@Override
	public void create(List<Magasin> lma) {
		// TODO Auto-generated method stub
		for (Magasin m : lma) {
			this.create(m);
		}
	}

	@Override
	public void delete(List<Magasin> lmd) {
		// TODO Auto-generated method stub
		for (Magasin m : lmd) {
			this.delete(m);
		}
	}

	@Override
	public void update(Magasin m, String editadres, String editdesc,
			TypeMagasin edittype) {
		m.setAdresse(editadres);
		m.setDescription(editdesc);
		m.setType(edittype);
		em.merge(m);

	}

}
