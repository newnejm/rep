package com.yesserp.sessionbean.gs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.yesserp.domain.gs.Lot;
import com.yesserp.domain.gs.Prod;
import com.yesserp.domain.gs.Stock;
import com.yesserp.type.gs.TypeEval;
import com.yesserp.type.gs.TypeLivr;

/**
 * Session Bean implementation class GestionStock
 */
@Stateless
@LocalBean
public class GestionStock implements GestionStockLocal {

	@PersistenceContext
	EntityManager em;

	@EJB
	GestionLotLocal ejbl;

	@EJB
	GestionProdLocal ejbp;

	/**
	 * Default constructor.
	 */
	public GestionStock() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Stock consulter(int id) {
		Stock s = (Stock) em
				.createQuery("SELECT s FROM Stock s where s.id = :id")
				.setParameter("id", id).getSingleResult();
		return s;
	}

	@Override
	public void update(Stock s, double nsec, TypeLivr t) {
		s.setN_sec(nsec);
		s.setTypeLiv(t);
		em.merge(s);
	}

	@Override
	public void update(Stock s, double qte) {
		// TODO Auto-generated method stub
		s.setQte(qte);
		em.merge(s);
	}

	@Override
	public double calc(Stock stock, TypeEval selectedTypeval) {
		double valeur = 0;
		System.out.println("################ in gestionStock.calc tt");
		switch (selectedTypeval.nom) {
		case "achat": {
			System.out.println("################ in achat");
			List<Lot> l = ejbl.consulter(stock);
			if (l.isEmpty()) {
				System.out.println("//////////////// llot videe");
				l = new ArrayList<Lot>();
			}
			for (Lot lot : l) {
				System.out.println("//////////////// in boucle with llot vide");
				valeur = valeur + lot.getCout_unitaire()
						* (lot.getQte() - lot.getQterebu());
			}
			System.out.println("//////////////// after boucle it works");
			break;
		}
		case "vente": {
			System.out.println("################ in vente");
			List<Lot> l = ejbl.consulter(stock);
			if (l.isEmpty()) {
				System.out.println("//////////////// llot vide");
				l = new ArrayList<Lot>();
			}
			for (Lot lot : l) {
				valeur = valeur + lot.getPrix_vente()
						* (lot.getQte() - lot.getQterebu());
			}
			break;
		}

		}

		return valeur;
	}

	@Override
	public List<Stock> consulter() {
		return (em.createQuery("SELECT s FROM Stock s").getResultList());
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		em.remove(this.consulter(id));
	}

}
