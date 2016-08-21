package com.yesserp.sessionbean.gs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.yesserp.domain.gs.Lot;
import com.yesserp.domain.gs.Sous_Categorie;
import com.yesserp.domain.gs.Stock;
import com.yesserp.type.gs.TypeLivr;

/**
 * Session Bean implementation class GestionLot
 */
@Stateless
@LocalBean
public class GestionLot implements GestionLotLocal {

	@PersistenceContext
	EntityManager em;

	public GestionLot() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Lot lot) {
		// TODO Auto-generated method stub
		em.persist(lot);
	}

	@Override
	public void create(List<Lot> llot) {
		// TODO Auto-generated method stub
		for (Lot lot : llot) {
			this.create(lot);
		}
	}

	@Override
	public void delete(Lot lot) {

		if (em.contains(lot)) {
			em.remove(lot);
		} else {
			lot = em.find(Lot.class, lot.getId());
			em.remove(lot);
		}

	}

	@Override
	public void delete(List<Lot> llot) {
		// TODO Auto-generated method stub
		for (Lot lot : llot) {
			this.delete(lot);
		}
	}

	@Override
	public List<Lot> consulter(Stock s) {
		// TODO Auto-generated method stub
		List<Lot> llot = (List<Lot>) em
				.createQuery("SELECT l FROM  Lot l where l.stock = :stock")
				.setParameter("stock", s).getResultList();
		System.out.println("%%%%%%%%%%%%%%%%%" + llot);
		if (llot.isEmpty()) {
			System.out.println("%%%%%%%%liste lot is empty%%%%%%%%%");
			return (new ArrayList<Lot>());
		}
		return llot;
	}

	@Override
	public List<Lot> consulter() {
		ArrayList<Lot> llot = (ArrayList<Lot>) em.createQuery(
				"SELECT l FROM Lot l ").getResultList();
		return llot;
	}

	@Override
	public Lot consuler(String code) {
		return ((Lot) em
				.createQuery("SELECT l FROM Lot l WHERE l.code = :code")
				.setParameter("code", code).getSingleResult());
	}

	@Override
	public void update(Lot l, Date den, Date dlim, double lotqte,
			double qterebu, String descrebu) {
		l.setD_enreg(den);
		l.setD_limite(dlim);
		l.setQte(lotqte);
		l.setQterebu(qterebu);
		l.setDescrebu(descrebu);
		em.merge(l);
	}

	@Override
	public List<Lot> consulter(Stock stock, int x) {
		// TODO Auto-generated method stub
		List<Lot> llot = null;
		if (stock.getTypeLiv().name().equals("FIFO")) {
			System.out.println("************** fifo *******************");
			llot = ((List<Lot>) em
					.createQuery(
							"SELECT l FROM  Lot l where ((l.stock = :stock) AND (l.qte > (l.qteconso +l.qterebu))) ORDER BY l.d_enreg")
					.setParameter("stock", stock).getResultList());
		} else if (stock.getTypeLiv().name().equals("LIFO")) {
			System.out.println("************** lifo ************");
			llot = ((List<Lot>) em
					.createQuery(
							"SELECT l FROM  Lot l where ((l.stock = :stock) AND (l.qte > (l.qteconso +l.qterebu))) ORDER BY l.d_enreg DESC ")
					.setParameter("stock", stock).getResultList());
		}
		return llot;
	}

	@Override
	public void update(Lot l) {
		// TODO Auto-generated method stub
		em.merge(l);
	}
}
