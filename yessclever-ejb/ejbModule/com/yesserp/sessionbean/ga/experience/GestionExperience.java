package com.yesserp.sessionbean.ga.experience;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Experience;
import com.yesserp.domain.ga.Identite;

/**
 * Session Bean implementation class gestionExperience
 */
@Stateless
@LocalBean
public class GestionExperience implements GestionExperienceLocal {

	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public GestionExperience() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterExperience(Experience experience) {
		em.persist(experience);

	}

	@Override
	public void supprimerExperience(Experience experience) {
		em.remove(em.merge(experience));

	}

	@Override
	public void modifierExperience(Experience experience) {
		em.merge(experience);

	}

	@Override
	public Experience trouverParId(Long id) {

		return em.find(Experience.class, id);
	}

	@Override
	public List<Experience> trouverExperiencesParIdentite(Identite identite,
			int n) {
		Query q = em
				.createQuery("select i from Experience i join i.identite iden where iden.numedoss = :id order by i.datedebu desc");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(n);
		List<Experience> li = null;
		try {
			li = (List<Experience>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Experience> trouverExperiencesParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = em
				.createQuery("select i from Experience i join i.identite iden where iden.numedoss = :id and i.datedebu > :min order by i.datedebu desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<Experience> li = null;
		try {
			li = (List<Experience>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Experience> trouverPremiersExperiencesParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = em
				.createQuery("select i from Experience i join i.identite iden where iden.numedoss = :id and i.datedebu > :min order by i.datedebu");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<Experience> li = null;
		try {
			li = (List<Experience>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);

		return li;
	}

	@Override
	public List<Experience> trouverExperiencesParIdentiteEtDateMax(
			Identite identite, Date max, int n) {
		Query q = em
				.createQuery("select i from Experience i join i.identite iden where iden.numedoss = :id and i.datedebu < :max order by i.datedebu desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("max", max);
		q.setMaxResults(n);
		List<Experience> li = null;
		try {
			li = (List<Experience>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Experience> trouverExperiencesParIdentiteEtDateMinMax(
			Identite identite, Date min, Date max, int n) {
		Query q = em
				.createQuery("select i from Experience i join i.identite iden where iden.numedoss = :id and i.datedebu > :min and i.datedebu < :max order by i.datedebu desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setParameter("max", max);
		q.setMaxResults(n);

		List<Experience> li = null;
		try {
			li = (List<Experience>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Long trouverNombreOccurrencesParIdentite(Identite identite) {
		Query q = em
				.createQuery("select count(i) from Experience i join i.identite iden where iden.numedoss = :id");
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
	public List<Experience> trouverPremiersExperiencesParIdentite(
			Identite identite, int n) {
		Query q = em
				.createQuery("select i from Experience i join i.identite iden where iden.numedoss = :id order by i.datedebu");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(n);
		List<Experience> li = null;
		try {
			li = (List<Experience>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Collections.reverse(li);
		return li;
	}

	@Override
	public List<Experience> findAll() {
		Query query = em.createQuery("select e from Experience e");
		return query.getResultList();
	}

}