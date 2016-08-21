package com.yesserp.sessionbean.paramgta.gestiongroupeimputation;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gtaparam.GroupeImputation;
import com.yesserp.domain.gtaparam.Imputation;

/**
 * Session Bean implementation class GestionGroupeImputation
 */
@Stateless
@LocalBean
public class GestionGroupeImputation implements GestionGroupeImputationLocal {

	/**
	 * Default constructor.
	 */
	public GestionGroupeImputation() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajouterGroupeImputation(GroupeImputation groupeImputation) {
		entityManager.persist(groupeImputation);

	}

	@Override
	public void modifierGroupeImputation(GroupeImputation groupeImputation) {
		entityManager.merge(groupeImputation);

	}

	@Override
	public GroupeImputation findGroupeImputationByCode(String code) {
		Query query = entityManager
				.createQuery("select gi from GroupeImputation gi where codegrp=:x");
		query.setParameter("x", code);
		return (GroupeImputation) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupeImputation> listeGroupeImpuation() {
		Query query = entityManager
				.createQuery("select gi from GroupeImputation gi");
		return query.getResultList();
	}



	//
	@Override
	public List<GroupeImputation> trouverGroupesImputationsParIdentite(
			Identite identite) {
		Query q = entityManager
				.createQuery("select i from GroupeImputation i join i.identite iden where iden.numedoss = :id and i.datefin IS NULL order by i.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		List<GroupeImputation> li = null;
		try {
			li = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public List<GroupeImputation> trouverHistoriqueGroupesImputationsParIdentite(
			Identite identite, int n) {
		Query q = entityManager
				.createQuery("select i from GroupeImputation i join i.identite iden where iden.numedoss = :id order by i.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());

		q.setMaxResults(n);

		List<GroupeImputation> li = null;
		try {
			li = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public List<GroupeImputation> trouverHistoriqueGroupesImputationsParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = entityManager
				.createQuery("select i from GroupeImputation i join i.identite iden where iden.numedoss = :id and c.dateeffe > :min order by c.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<GroupeImputation> li = null;
		try {
			li = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public List<GroupeImputation> trouverPremiersHistoriqueGroupesImputationsParIdentiteEtDateMin(
			Identite identite, Date min, int n) {

		Query q = entityManager
				.createQuery("select i from GroupeImputation i join i.identite iden where iden.numedoss = :id and c.dateeffe > :min order by c.dateeffe");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);

		q.setMaxResults(n);

		List<GroupeImputation> li = null;
		try {
			li = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);
		return li;
	}

	@Override
	public List<GroupeImputation> trouverHistoriqueGroupesImputationsParIdentiteEtDateMax(
			Identite identite, Date max, int n) {
		Query q = entityManager
				.createQuery("select i from GroupeImputation i join i.identite iden where iden.numedoss = :id and c.dateeffe < :max order by c.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("max", max);
		q.setMaxResults(n);

		List<GroupeImputation> li = null;
		try {
			li = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<GroupeImputation> trouverHistoriqueGroupesImputationsParIdentiteEtDateMinMax(
			Identite identite, Date min, Date max, int n) {
		Query q = entityManager
				.createQuery("select i from GroupeImputation i join i.identite iden where iden.numedoss = :id and c.dateeffe > :min and c.dateeffe < :max order by c.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setParameter("max", max);

		q.setMaxResults(n);

		List<GroupeImputation> li = null;
		try {
			li = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<GroupeImputation> trouverPremiersHistoriqueGroupesImputationssParIdentite(
			Identite identite, int n) {
		Query q = entityManager
				.createQuery("select i from GroupeImputation i join i.identite iden where iden.numedoss = :id order by c.dateeffe");
		q.setParameter("id", identite.getNumedoss());

		q.setMaxResults(n);

		List<GroupeImputation> li = null;
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
				.createQuery("select count(i) from GroupeImputation i join i.identite iden where iden.numedoss = :id");
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
				.createQuery("select count(c) from  GroupeImputation i join i.identite iden where iden.numedoss = :id and c.datefin is null");
		q.setParameter("ide", identite.getNumedoss());

		Long li = new Long(0);
		try {
			li = (Long) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public void supprimerGroupeImputation(GroupeImputation groupeImputation) {
		GroupeImputation p = entityManager.find(GroupeImputation.class, groupeImputation.getIdgrp());
        if (p != null) 
        {
        	entityManager.remove(entityManager.merge(p));
       
        }	
        }

	
		

	@Override
	public List<Imputation> findImputationsByGroupeImputations(
			GroupeImputation groupeImputation) {
		Query query = entityManager
				.createQuery("SELECT imp FROM Imputation imp WHERE :groupeImputation MEMBER OF imp.groupeImputations");
		query.setParameter("groupeImputation", groupeImputation);
		return query.getResultList();
	}

	@Override
	public List<GroupeImputation> findAllImputationByIdentite(
			Identite identite, int n) {
		// TODO Auto-generated method stub
		return null;
	}

}
