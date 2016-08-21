package com.yesserp.sessionbean.gs;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.yesserp.domain.gs.Consomation;
import com.yesserp.domain.gs.Consomation_lot;
import com.yesserp.domain.gs.Lot;

/**
 * Session Bean implementation class GestionCons
 */
@Stateless
@LocalBean
public class GestionCons implements GestionConsLocal {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public GestionCons() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Consomation c) {
		// TODO Auto-generated method stub
		em.persist(c);
	}

	@Override
	public List<Consomation> consulter() {

		return (List<Consomation>) (em
				.createQuery("SELECT c FROM Consomation c").getResultList());
	}

}
