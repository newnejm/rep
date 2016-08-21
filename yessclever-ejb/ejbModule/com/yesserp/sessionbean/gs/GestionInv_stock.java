package com.yesserp.sessionbean.gs;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gs.Consomation;
import com.yesserp.domain.gs.Inventaire;
import com.yesserp.domain.gs.Inventaire_stock;
import com.yesserp.domain.gs.Inventaire_stock_pk;
import com.yesserp.domain.gs.Stock;

/**
 * Session Bean implementation class GestionInv_stock
 */
@Stateless
@LocalBean
public class GestionInv_stock implements GestionInv_stockLocal {

	@PersistenceContext
	EntityManager em;

	@EJB
	GestionStockLocal ejbs;

	@EJB
	GetionInvLocal ejbi;

	/**
	 * Default constructor.
	 */
	public GestionInv_stock() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Integer key, Double double1) {
		// TODO Auto-generated method stub
		Inventaire_stock is = new Inventaire_stock();
		is.setQte(double1);
		Stock s = ejbs.consulter(key.intValue());
		List<Inventaire> li = ejbi.consulter();
		Inventaire i = li.get(li.size() - 1);
		Inventaire_stock_pk pk = new Inventaire_stock_pk();
		pk.setIdinv(i.getId());
		pk.setIdstock(s.getId());
		is.setPk(pk);
		em.persist(is);
	}

	@Override
	public List<Inventaire_stock> consulter(Inventaire inv) {

		return (List<Inventaire_stock>) (em.createQuery(
				"SELECT i FROM Inventaire_stock i where i.inventaire = :inv")
				.setParameter("inv", inv).getResultList());
	}

	public Inventaire_stock consulter(Inventaire i, int id) {
		Stock s = ejbs.consulter(id);
		Query q = em
				.createQuery("SELECT ix FROM Inventaire_stock ix where ((ix.inventaire = :inv) and (ix.stock = :stock))");
		q.setParameter("inv", i);
		q.setParameter("stock", s);
		return (Inventaire_stock) (q.getSingleResult());
	}

	@Override
	public void update(Inventaire inv, Integer key, Double double1) {
		Inventaire_stock is=this.consulter(inv, key.intValue());
		System.out.println("ùùùùùùùùùùùùùùùùùùùùùùùùùùùùùù  in update with qte="+double1);
		is.setQte(double1);
		em.merge(is);
	}
}
