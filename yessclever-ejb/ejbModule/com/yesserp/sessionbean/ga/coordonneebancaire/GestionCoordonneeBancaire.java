package com.yesserp.sessionbean.ga.coordonneebancaire;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.CoordonneeBancaire;
import com.yesserp.domain.ga.Identite;

/**
 * Session Bean implementation class GestionCoordonneeBancaire
 */
@Stateless
@LocalBean
public class GestionCoordonneeBancaire implements
		GestionCoordonneeBancaireLocal {

	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public GestionCoordonneeBancaire() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterCoordonneeBancaire(CoordonneeBancaire coordonneeBancaire) {
		em.persist(coordonneeBancaire);

	}

	@Override
	public void supprimerCoordonneeBancaire(
			CoordonneeBancaire coordonneeBancaire) {
		em.remove(em.merge(coordonneeBancaire));
	}

	@Override
	public void modifierCoordonneeBancaire(CoordonneeBancaire coordonneeBancaire) {
		em.merge(coordonneeBancaire);

	}

	@Override
	public CoordonneeBancaire trouverParId(Long id) {
		return em.find(CoordonneeBancaire.class, id);
	}

	@Override
	public CoordonneeBancaire trouverCoordonneeBancaireActiveParIdentite(
			Identite identite) {
		Query q = em
				.createQuery("select i from CoordonneeBancaire i join i.identite iden where iden.numedoss = :id and i.datefin IS NULL order by i.dateffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(1);
		CoordonneeBancaire li = null;
		try {
			li = (CoordonneeBancaire) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CoordonneeBancaire> trouverHistoriqueCoordonneeBancairesParIdentite(
			Identite identite, int n) {
		Query q = em
				.createQuery("select i from CoordonneeBancaire i join i.identite iden where iden.numedoss = :id order by i.dateffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(n);
		List<CoordonneeBancaire> li = null;
		try {
			li = (List<CoordonneeBancaire>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}
	@Override
	public Long trouverNombreOccurrencesParIdentite(Identite identite) {
		Query q = em
				.createQuery("select count(i) from CoordonneeBancaire i join i.identite iden where iden.numedoss = :id");
		q.setParameter("id", identite.getNumedoss());

		Long li = new Long(0);
		try {
			li = (Long) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public CoordonneeBancaire trouverPrecedentCoordonneeBancaireParIdentite(Identite identite, Date max) {
		Query q = em
				.createQuery("select i from CoordonneeBancaire i join i.identite iden where iden.numedoss = :id and i.dateffet < :max order by i.dateffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("max", max);
		q.setMaxResults(1);

		CoordonneeBancaire li = null;
		try {
			li = (CoordonneeBancaire) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public CoordonneeBancaire trouverSuivantCoordonneeBancaireParIdentite(Identite identite, Date min) {
		Query q = em
				.createQuery("select i from CoordonneeBancaire i join i.identite iden where iden.numedoss = :id and i.dateffet > :min order by i.dateffet");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(1);

		CoordonneeBancaire li = null;
		try {
			li = (CoordonneeBancaire) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public CoordonneeBancaire trouverDerniereCoordonneeBancaireParIdentite(
			Identite identite) {
		Query q = em
				.createQuery("select i from CoordonneeBancaire i join i.identite iden where iden.numedoss = :id order by i.dateffet desc");
		q.setParameter("id", identite.getNumedoss());

		q.setMaxResults(1);

		CoordonneeBancaire li = null;
		try {
			li = (CoordonneeBancaire) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public CoordonneeBancaire trouverPremiereCoordonneeBancaireParIdentite(
			Identite identite) {
		Query q = em
				.createQuery("select i from CoordonneeBancaire i join i.identite iden where iden.numedoss = :id order by i.dateffet");
		q.setParameter("id", identite.getNumedoss());
	
		q.setMaxResults(1);

		CoordonneeBancaire li = null;
		try {
			li = (CoordonneeBancaire) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}
}
