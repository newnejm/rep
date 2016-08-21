package com.yesserp.sessionbean.paramgta.gestiongroupeactivite;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gtaparam.GroupeActivite;
import com.yesserp.domain.gtaparam.GroupeCompteur;

/**
 * Session Bean implementation class GestionGroupeActivite
 */
@Stateless
@LocalBean
public class GestionGroupeActivite implements GestionGroupeActiviteLocal {

	/**
	 * Default constructor.
	 */
	private EntityManager em;

	public GestionGroupeActivite() {
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajouterGroupeActivite(GroupeActivite groupeActivite) {
		entityManager.persist(groupeActivite);

	}

	@Override
	public void modifierGroupeActivite(GroupeActivite groupeActivite) {
		entityManager.merge(groupeActivite);

	}

	@Override
	public void supprimerGroupeActivite(GroupeActivite i) {

		GroupeActivite p = entityManager.find(GroupeActivite.class, i.getIdgrpa());
        if (p != null) 
        {
        	entityManager.remove(entityManager.merge(p));
       
        }	}


	@Override
	public GroupeActivite findGroupeActiviteByCode(String code) {
		Query query = entityManager
				.createQuery("select ga from GroupeActivite ga where codegrpa=:x");
		query.setParameter("x", code);
		return (GroupeActivite) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupeActivite> listeGroupeActivite() {
		Query query = entityManager
				.createQuery("select ga from GroupeActivite ga");
		return query.getResultList();
	}



	@Override
	public List<GroupeActivite> trouverGroupesActivitesParIdentite(
			Identite identite) {

		Query q = entityManager
				.createQuery("select i from GroupeActivite i join i.identite iden where iden.numedoss = :id and i.datefin IS NULL order by i.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		List<GroupeActivite> li = null;
		try {
			li = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public List<GroupeActivite> trouverHistoriqueGroupesActivitesParIdentite(
			Identite identite, int n) {
		Query q = entityManager
				.createQuery("select i from GroupeActivite i join i.identite iden where iden.numedoss = :id order by i.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());

		q.setMaxResults(n);

		List<GroupeActivite> li = null;
		try {
			li = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public List<GroupeActivite> trouverHistoriqueGroupesActivitesParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = entityManager
				.createQuery("select i from GroupeActivite i join i.identite iden where iden.numedoss = :id and c.dateeffe > :min order by c.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<GroupeActivite> li = null;
		try {
			li = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public List<GroupeActivite> trouverPremiersHistoriqueGroupesActivitesParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = entityManager
				.createQuery("select i from GroupeActivite i join i.identite iden where iden.numedoss = :id and c.dateeffe > :min order by c.dateeffe");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);

		q.setMaxResults(n);

		List<GroupeActivite> li = null;
		try {
			li = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);
		return li;
	}

	@Override
	public List<GroupeActivite> trouverHistoriqueGroupesActivitesParIdentiteEtDateMax(
			Identite identite, Date max, int n) {
		Query q = entityManager
				.createQuery("select i from GroupeActivite i join i.identite iden where iden.numedoss = :id and c.dateeffe < :max order by c.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("max", max);
		q.setMaxResults(n);

		List<GroupeActivite> li = null;
		try {
			li = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<GroupeActivite> trouverHistoriqueGroupesActivitesParIdentiteEtDateMinMax(
			Identite identite, Date min, Date max, int n) {
		Query q = entityManager
				.createQuery("select i from GroupeActivite i join i.identite iden where iden.numedoss = :id and c.dateeffe > :min and c.dateeffe < :max order by c.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setParameter("max", max);

		q.setMaxResults(n);

		List<GroupeActivite> li = null;
		try {
			li = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<GroupeActivite> trouverPremiersHistoriqueGroupesActivitessParIdentite(
			Identite identite, int n) {
		Query q = entityManager
				.createQuery("select i from GroupeActivite i join i.identite iden where iden.numedoss = :id order by c.dateeffe");
		q.setParameter("id", identite.getNumedoss());

		q.setMaxResults(n);

		List<GroupeActivite> li = null;
		try {
			li = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);
		return li;
	}

	@Override
	public Long trouverNombreOccurrencesParIdentite(Identite identite) {
		Query q = entityManager
				.createQuery("select count(i) from GroupeActivite i join i.identite iden where iden.numedoss = :id");
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
		Query q = entityManager
				.createQuery("select count(c) from  GroupeActivite i join i.identite iden where iden.numedoss = :id and c.datefin is null");
		q.setParameter("id", identite.getNumedoss());

		Long li = new Long(0);
		try {
			li = (Long) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	

}
