package com.yesserp.sessionbean.gs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.yesserp.domain.gs.STOK;
import com.yesserp.domain.gs.Stock;
import com.yesserp.type.gs.TypeEval;

/**
 * Session Bean implementation class GestionSTOK
 */
@Stateless
@LocalBean
public class GestionSTOK implements GestionSTOKLocal {

	@PersistenceContext
	EntityManager em;

	@EJB
	GestionStockLocal ejbs;

	public GestionSTOK() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(STOK s) {
		em.persist(s);
	}

	@Override
	public void update(STOK s) {
		em.merge(s);
	}

	@Override
	public STOK consulter() {
		try {
			STOK s = (STOK) (em.createQuery("SELECT s FROM STOK s")
					.getSingleResult());
			return s;
		} catch (Exception E) {
			return null;
		}

	}

	@Override
	public double calc(TypeEval typeeval) {
		// TODO Auto-generated method stub
		double res = 0;
		List<Stock> lstock = ejbs.consulter();
		for (Stock s : lstock) {
			res = res + ejbs.calc(s, typeeval);
		}
		return res;
	}
}
