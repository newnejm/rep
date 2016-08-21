package com.yesserp.sessionbean.ga.personneacharge;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.PersonneACharge;

/**
 * Session Bean implementation class GestionPersonneACharge
 */
@Stateless
@LocalBean
public class GestionPersonneACharge implements GestionPersonneAChargeLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public GestionPersonneACharge() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterPersonneACharge(PersonneACharge personneACharge) {
		em.persist(personneACharge);

	}

	@Override
	public void supprimerPersonneACharge(PersonneACharge personneACharge) {
		em.remove(em.merge(personneACharge));

	}

	@Override
	public void modifierPersonneACharge(PersonneACharge personneACharge) {
		em.merge(personneACharge);

	}

	@Override
	public PersonneACharge trouverParId(Long id) {
		return em.find(PersonneACharge.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PersonneACharge> trouverPersonnesAChargesActivesParIdentite(
			Identite identite) {
		Query q = em
				.createQuery("select i from PersonneACharge i join i.identite iden where iden.numedoss = :id and i.datefin IS NULL order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());
		List<PersonneACharge> li = null;
		try {
			li = (List<PersonneACharge>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PersonneACharge> trouverHistoriquePersonnesAChargesParIdentite(
			Identite identite, int n) {
		Query q = em
				.createQuery("select i from PersonneACharge i join i.identite iden where iden.numedoss = :id order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(n);

		List<PersonneACharge> li = null;
		try {
			li = (List<PersonneACharge>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PersonneACharge> trouverHistoriquePersonneAChargesParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = em
				.createQuery("select i from PersonneACharge i join i.identite iden where iden.numedoss = :id and i.datedeb > :min order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(n);

		List<PersonneACharge> li = null;
		try {
			li = (List<PersonneACharge>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PersonneACharge> trouverPremiersHistoriquePersonneAChargesParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = em
				.createQuery("select i from PersonneACharge i join i.identite iden where iden.numedoss = :id and i.datedeb > :min order by i.datedeb");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(n);

		List<PersonneACharge> li = null;
		try {
			li = (List<PersonneACharge>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);
		return li;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PersonneACharge> trouverHistoriquePersonneAChargesParIdentiteEtDateMax(
			Identite identite, Date max, int n) {
		Query q = em
				.createQuery("select i from PersonneACharge i join i.identite iden where iden.numedoss = :id and i.datedeb < :max order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("max", max);
		q.setMaxResults(n);

		List<PersonneACharge> li = null;
		try {
			li = (List<PersonneACharge>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PersonneACharge> trouverHistoriquePersonneAChargesParIdentiteEtDateMinMax(
			Identite identite, Date min, Date max, int n) {
		Query q = em
				.createQuery("select i from PersonneACharge i join i.identite iden where iden.numedoss = :id and i.datedeb > :min and i.datedeb < :max order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setParameter("max", max);

		q.setMaxResults(n);

		List<PersonneACharge> li = null;
		try {
			li = (List<PersonneACharge>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Long trouverNombreOccurrencesParIdentite(Identite identite) {
		Query q = em
				.createQuery("select count(i) from PersonneACharge i join i.identite iden where iden.numedoss = :id");
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
				.createQuery("select count(i) from PersonneACharge i join i.identite iden where iden.numedoss = :id and i.datefin IS NULL");
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
