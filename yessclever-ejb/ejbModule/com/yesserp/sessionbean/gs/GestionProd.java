package com.yesserp.sessionbean.gs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gs.Categorie;
import com.yesserp.domain.gs.Prod;
import com.yesserp.domain.gs.STOK;
import com.yesserp.domain.gs.Stock;
import com.yesserp.type.gs.TypeEval;

/**
 * Session Bean implementation class GestionProd
 */
@Stateless
@LocalBean
public class GestionProd implements GestionProdLocal {

	@PersistenceContext
	EntityManager em;

	@EJB
	GestionSTOKLocal ejbS;

	public GestionProd() {

	}

	@Override
	public void create(Prod p) {
		em.persist(p);
		STOK s = ejbS.consulter();
		if (s == null) {
			s = new STOK();
			s.setDate_inv(new Date());
			s.setEvaluation(TypeEval.c_achat);
		}
		Stock stock = new Stock(p.getCode());
		stock.setStok(s);
		s.getLstock().add(stock);
		em.persist(stock);
		em.merge(s);
	}

	@Override
	public void delete(String code) {
		Prod p = null;
		Stock s = null;
		Query q = em.createQuery("SELECT p FROM Prod p WHERE p.code = :val");
		q.setParameter("val", code);
		Query qq = em.createQuery("SELECT s FROM Stock s WHERE s.code = :val");
		qq.setParameter("val", code);

		try {
			p = (Prod) q.getSingleResult();
			s = (Stock) qq.getSingleResult();
			em.remove(p);
			em.remove(s);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public void create(List<Prod> lpa) {
		for (Prod p : lpa) {
			this.create(p);
		}
	}

	@Override
	public void delete(List<Prod> lpd) {
		for (Prod p : lpd) {
			this.delete(p.getCode());
		}
	}

	@Override
	public List<Prod> consulter() {
		ArrayList<Prod> p = (ArrayList<Prod>) em.createQuery(
				"SELECT p FROM  Prod p").getResultList();
		return p;
	}

	@Override
	public Prod consulter(int id) {
		Prod p = (Prod) em
				.createQuery("SELECT p FROM Prod p where p.id = :id")
				.setParameter("id", id).getSingleResult();
		return p;
	}

	@Override
	public void delete(Prod selectedProd) {
		em.remove(this.consulter(selectedProd.getId()));
	}

}
