package com.yesserp.sessionbean.gs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.yesserp.domain.gs.Consomation_lot;

/**
 * Session Bean implementation class GestionConso_lot
 */
@Stateless
@LocalBean
public class GestionConso_lot implements GestionConso_lotLocal {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public GestionConso_lot() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Consomation_lot cl) {
		em.persist(cl);
	}
}
