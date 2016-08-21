package com.yesserp.sessionbean.ga.statut;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.Statut;

/**
 * Session Bean implementation class GestionStatut
 */
@Stateless
@LocalBean
public class GestionStatut implements GestionStatutLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public GestionStatut() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterStatut(Statut statut) {

		em.persist(statut);
	}

	@Override
	public void supprimerStatut(Statut statut) {

		em.remove(em.merge(statut));
	}

	@Override
	public void modifierStatut(Statut statut) {

		em.merge(statut);
	}

	@Override
	public Statut trouverParId(Long id) {
		return em.find(Statut.class, id);
	}

	@Override
	public Statut trouverStatutParIdentite(Identite identite) {
		Query q = em
				.createQuery("select i from Statut i join i.identite iden where iden.numedoss = :id order by i.dateffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(1);

		List<Statut> li = null;
		try {
			li = (List<Statut>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(li!=null && li.size()>0)
			return li.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Statut> trouverHistoriqueStatutsParIdentite(Identite identite,
			int n) {
		Query q = em
				.createQuery("select i from Statut i join i.identite iden where iden.numedoss = :id order by i.dateffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(n);
		List<Statut> li = null;
		try {
			li = (List<Statut>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Long trouverNombreOccurrencesParIdentite(Identite identite) {
		Query q = em
				.createQuery("select count(i) from Statut i join i.identite iden where iden.numedoss = :id");
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
	public Statut trouverPrecedentStatutParIdentite(Identite identite, Date max) {
		Query q = em
				.createQuery("select i from Statut i join i.identite iden where iden.numedoss = :id and i.dateffet < :max order by i.dateffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("max", max);
		q.setMaxResults(1);

		List<Statut> li = null;
		try {
			li = (List<Statut>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(li!=null && li.size()>0)
			return li.get(0);
		return null;
	}

	@Override
	public Statut trouverSuivantStatutParIdentite(Identite identite, Date min) {
		Query q = em
				.createQuery("select i from Statut i join i.identite iden where iden.numedoss = :id and i.dateffet > :min order by i.dateffet");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(1);

		List<Statut> li = null;
		try {
			li = (List<Statut>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(li!=null && li.size()>0)
			return li.get(0);
		return null;
	}

	@Override
	public Statut trouverPremierStatutParIdentite(Identite identite) {
		Query q = em
				.createQuery("select i from Statut i join i.identite iden where iden.numedoss = :id order by i.dateffet");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(1);
		List<Statut> li = null;
		try {
			li = (List<Statut>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(li!=null && li.size()>0)
			return li.get(0);
		return null;
	}

	@Override
	public List<Statut> trouverPremiersHStatutParIdentite(Identite identite,
			int n) {
		Query q = em
				.createQuery("select i from Statut i join i.identite iden where iden.numedoss = :id order by i.dateffet");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(n);

		List<Statut> li = null;
		try {
			li = (List<Statut>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(li!=null && li.size()>0)
			Collections.reverse(li);
		return li;
	}

	@Override
	public List<Statut> trouverPrecedentsHStatutParIdentiteEtDateMax(
			Identite identite, Date max, int n) {
		Query q = em
				.createQuery("select i from Statut i join i.identite iden where iden.numedoss = :id and i.dateffet < :max order by i.dateffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("max", max);
		q.setMaxResults(n);

		List<Statut> li = null;
		try {
			li = (List<Statut>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(li!=null && li.size()>0)
			return li;
		return null;
	}

	@Override
	public List<Statut> trouverSuivantsHStatutParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = em
				.createQuery("select i from Statut i join i.identite iden where iden.numedoss = :id and i.dateffet > :min order by i.dateffet");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<Statut> li = null;
		try {
			li = (List<Statut>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(li!=null && li.size()>0)
			Collections.reverse(li);
		return li;
	}

}
