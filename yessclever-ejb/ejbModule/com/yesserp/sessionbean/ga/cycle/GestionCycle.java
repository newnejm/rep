package com.yesserp.sessionbean.ga.cycle;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Cycle;
import com.yesserp.domain.ga.Identite;

/**
 * Session Bean implementation class GestionCycle
 */
@Stateless
@LocalBean
public class GestionCycle implements GestionCycleLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public GestionCycle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterCycle(Cycle cycle) {

		em.persist(cycle);
	}

	@Override
	public void supprimerCycle(Cycle cycle) {
		em.remove(em.merge(cycle));

	}

	@Override
	public void modifierCycle(Cycle cycle) {
		em.merge(cycle);

	}

	@Override
	public Cycle trouverParId(Long id) {

		return em.find(Cycle.class, id);

	}

	@Override
	public Cycle trouverCycleParIdentite(Identite identite) {
		Query q = em
				.createQuery("select i from Cycle i join i.identite iden where iden.numedoss = :id and i.datefin IS NULL order by i.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(1);
		Cycle li = null;
		try {
			li = (Cycle) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cycle> trouverHistoriqueCyclesParIdentite(Identite identite,
			int n) {
		Query q = em
				.createQuery("select i from Cycle i join i.identite iden where iden.numedoss = :id order by i.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		List<Cycle> li = null;
		try {
			li = (List<Cycle>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Long trouverNombreOccurrencesParIdentite(Identite identite) {
		Query q = em
				.createQuery("select count(i) from Cycle i join i.identite iden where iden.numedoss = :id");
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
	public Cycle trouverPrecedentCycleParIdentite(Identite identite, Date max) {
		Query q = em
				.createQuery("select i from Cycle i join i.identite iden where iden.numedoss = :id and i.dateeffe < :max order by i.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("max", max);
		q.setMaxResults(1);

		Cycle li = null;
		try {
			li = (Cycle) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Cycle trouverSuivantCycleParIdentite(Identite identite, Date min) {
		Query q = em
				.createQuery("select i from Cycle i join i.identite iden where iden.numedoss = :id and i.dateeffe > :min order by i.dateeffe");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(1);

		Cycle li = null;
		try {
			li = (Cycle) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

}
