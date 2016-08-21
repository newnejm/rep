package com.yesserp.sessionbean.ga.nationalite;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.Nationalite;

/**
 * Session Bean implementation class GestionNationalite
 */
@Stateless
@LocalBean
public class GestionNationalite implements GestionNationaliteLocal {

	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public GestionNationalite() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterNationalite(Nationalite nationalite) {

		em.persist(nationalite);
	}

	@Override
	public void supprimerNationalite(Nationalite nationalite) {
		em.remove(em.merge(nationalite));

	}

	@Override
	public void modifierNationalite(Nationalite nationalite) {
		em.merge(nationalite);

	}

	@Override
	public Nationalite trouverParId(Long id) {
		return em.find(Nationalite.class, id);

	}

	@Override
	public List<Nationalite> trouverNationalitesActivesParIdentite(
			Identite identite) {
		Query q = em
				.createQuery("select i from Nationalite i join i.identite iden where iden.numedoss = :id and i.datefin IS NULL order by i.datedeb");
		q.setParameter("id", identite.getNumedoss());
		List<Nationalite> li = null;
		try {
			li = (List<Nationalite>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public Nationalite trouverNationalitePrincipaleParIdentite(Identite identite) {
		Query q = em
				.createQuery("select i from Nationalite i join i.identite iden where iden.numedoss = :id and i.datefin IS NULL and i.principa IS TRUE");
		q.setParameter("id", identite.getNumedoss());
		List<Nationalite> li = null;
		try {
			li = (List<Nationalite>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li.size() > 0)
			return li.get(li.size() - 1);
		return null;
	}

	@Override
	public List<Nationalite> trouverHistoriqueNationalitesParIdentite(
			Identite identite, int n) {
		Query q = em
				.createQuery("select i from Nationalite i join i.identite iden where iden.numedoss = :id order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());

		q.setMaxResults(n);

		List<Nationalite> li = null;
		try {
			li = (List<Nationalite>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Nationalite> trouverHistoriqueNationalitesParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = em
				.createQuery("select i from Nationalite i join i.identite iden where iden.numedoss = :id and i.datedeb > :min order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);

		q.setMaxResults(n);

		List<Nationalite> li = null;
		try {
			li = (List<Nationalite>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public List<Nationalite> trouverPremiersHistoriqueNationalitesParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = em
				.createQuery("select i from Nationalite i join i.identite iden where iden.numedoss = :id and i.datedeb > :min order by i.datedeb");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);

		q.setMaxResults(n);

		List<Nationalite> li = null;
		try {
			li = (List<Nationalite>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);
		return li;
	}

	@Override
	public List<Nationalite> trouverHistoriqueNationalitesParIdentiteEtDateMax(
			Identite identite, Date max, int n) {
		Query q = em
				.createQuery("select i from Nationalite i join i.identite iden where iden.numedoss = :id and i.datedeb < :max order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("max", max);
		q.setMaxResults(n);

		List<Nationalite> li = null;
		try {
			li = (List<Nationalite>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Nationalite> trouverHistoriqueNationalitesParIdentiteEtDateMinMax(
			Identite identite, Date min, Date max, int n) {
		Query q = em
				.createQuery("select i from Nationalite i join i.identite iden where iden.numedoss = :id and i.datedeb > :min and i.datedeb < :max order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setParameter("max", max);

		q.setMaxResults(n);

		List<Nationalite> li = null;
		try {
			li = (List<Nationalite>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Long trouverNombreOccurrencesParIdentite(Identite identite) {
		Query q = em
				.createQuery("select count(i) from Nationalite i join i.identite iden where iden.numedoss = :id");
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
	public Long trouverNombreOccurrencesActivesParIdentite(Identite identite) {
		Query q = em
				.createQuery("select count(i) from Nationalite i join i.identite iden where iden.numedoss = :id and i.datefin is null");
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
	public List<Nationalite> trouverPremiersHistoriqueNationalitesParIdentite(
			Identite identite, int n) {
		Query q = em
				.createQuery("select i from Nationalite i join i.identite iden where iden.numedoss = :id order by i.datedeb");
		q.setParameter("id", identite.getNumedoss());

		q.setMaxResults(n);

		List<Nationalite> li = null;
		try {
			li = (List<Nationalite>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);
		return li;
	}

	@Override
	public List<Nationalite> findAll() {
		Query query = em.createQuery("select n from Nationalite n");
		return query.getResultList();
	}

}
