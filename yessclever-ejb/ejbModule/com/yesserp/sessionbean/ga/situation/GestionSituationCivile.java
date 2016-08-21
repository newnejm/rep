package com.yesserp.sessionbean.ga.situation;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.SituationCivile;

/**
 * Session Bean implementation class GestionSituation
 */
@Stateless
@LocalBean
public class GestionSituationCivile implements GestionSituationCivileLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public GestionSituationCivile() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterSituationCivile(SituationCivile situationCivile) {

		em.persist(situationCivile);
	}

	@Override
	public void supprimerSituationCivile(SituationCivile situationCivile) {
		em.remove(em.merge(situationCivile));

	}

	@Override
	public void modifierSituationCivile(SituationCivile situationCivile) {
		em.merge(situationCivile);

	}

	@Override
	public SituationCivile trouverParId(Long id) {

		return em.find(SituationCivile.class, id);

	}

	@SuppressWarnings("unchecked")
	@Override
	public SituationCivile trouverSituationCivileActiveParIdentite(Identite identite) {
		Query q = em
				.createQuery("select i from SituationCivile i join i.identite iden where iden.numedoss = :id and i.datefin IS NULL order by i.dateffet desc");
		q.setParameter("id", identite.getNumedoss());
		List<SituationCivile> li = null;
		try {
			li = (List<SituationCivile>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (li.size() > 0)
			return li.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SituationCivile> trouverHistoriqueSituationsCivilesParIdentite(
			Identite identite, int n) {
		Query q = em
				.createQuery("select i from SituationCivile i join i.identite iden where iden.numedoss = :id order by i.dateffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(n);

		List<SituationCivile> li = null;
		try {
			li = (List<SituationCivile>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Long trouverNombreOccurrencesParIdentite(Identite identite) {
		Query q = em
				.createQuery("select count(i) from SituationCivile i join i.identite iden where iden.numedoss = :id");
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
	public SituationCivile trouverPrecedentSituationCivileParIdentite(
			Identite identite, Date max) {
		Query q = em
				.createQuery("select i from SituationCivile i join i.identite iden where iden.numedoss = :id and i.dateffet < :max order by i.dateffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("max", max);
		q.setMaxResults(1);

		SituationCivile li = null;
		try {
			li = (SituationCivile) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			li=null;
		}
		return li;
	}
	
	@Override
	public List<SituationCivile> trouverPrecedentsHSituationCivileParIdentiteEtDateMax(
			Identite identite, Date max, int n) {
		Query q = em
				.createQuery("select i from SituationCivile i join i.identite iden where iden.numedoss = :id and i.dateffet < :max order by i.dateffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("max", max);
		q.setMaxResults(n);

		List<SituationCivile> li = null;
		try {
			li = (List<SituationCivile>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			li=null;
		}
		return li;
	}

	@Override
	public SituationCivile trouverSuivantSituationCivileParIdentite(
			Identite identite, Date min) {
		Query q = em
				.createQuery("select i from SituationCivile i join i.identite iden where iden.numedoss = :id and i.dateffet > :min order by i.dateffet");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(1);

		SituationCivile li = null;
		try {
			li = (SituationCivile) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}
	
	@Override
	public List<SituationCivile> trouverSuivantsHSituationCivileParIdentiteEtDateMin(
			Identite identite, Date min, int n){
		Query q = em
				.createQuery("select i from SituationCivile i join i.identite iden where iden.numedoss = :id and i.dateffet > :min order by i.dateffet");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<SituationCivile> li = null;
		try {
			li = (List<SituationCivile>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			li=null;
		}
		if(li!=null)
			Collections.reverse(li);
		return li;
	}
	
	@Override
	public SituationCivile trouverDerniereSituationCivileParIdentite(
			Identite identite) {
		Query q = em
				.createQuery("select i from SituationCivile i join i.identite iden where iden.numedoss = :id order by i.dateffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(1);

		SituationCivile li = null;
		try {
			li = (SituationCivile) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public SituationCivile trouverPremiereSituationCivileParIdentite(
			Identite identite) {
		Query q = em
				.createQuery("select i from SituationCivile i join i.identite iden where iden.numedoss = :id order by i.dateffet");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(1);

		SituationCivile li = null;
		try {
			li = (SituationCivile) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}


	@Override
	public List<SituationCivile> trouverPremieresHSituationCivileParIdentite(
			Identite identite, int n) {
		Query q = em
				.createQuery("select i from SituationCivile i join i.identite iden where iden.numedoss = :id order by i.dateffet");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(n);
		List<SituationCivile> li = null;
		try {
			li = (List<SituationCivile>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			li=null;
		}
		if(li!=null)
			Collections.reverse(li);
		return li;
	}

}
