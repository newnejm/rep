package com.yesserp.sessionbean.ga.salaire;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Embauche;
import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.Salaire;

/**
 * Session Bean implementation class GestionSalaire
 */
@Stateless
@LocalBean
public class GestionSalaire implements GestionSalaireLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public GestionSalaire() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterSalaire(Salaire salaire) {

		em.persist(salaire);
	}

	@Override
	public void supprimerSalaire(Salaire salaire) {

		em.remove(em.merge(salaire));
	}

	@Override
	public void modifierSalaire(Salaire salaire) {

		em.merge(salaire);
	}

	@Override
	public Salaire trouverParId(Long id) {
		return em.find(Salaire.class, id);
	}

	@Override
	public Salaire trouverSalaireParEmbauche(Embauche embauche) {
		Query q = em
				.createQuery("select i from Salaire i join i.embauche emba where emba.id = :id order by i.dateeffe desc");
		q.setParameter("id", embauche.getId());
		q.setMaxResults(1);

		List<Salaire> li = null;
		try {
			li = (List<Salaire>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li != null && li.size() > 0)
			return li.get(0);
		return new Salaire();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Salaire> trouverHistoriqueSalairesParEmbauche(
			Embauche embauche, int n) {
		Query q = em
				.createQuery("select i from Salaire i join i.embauche emba where emba.id = :id order by i.dateeffe desc");
		q.setParameter("id", embauche.getId());
		q.setMaxResults(n);
		List<Salaire> li = null;
		try {
			li = (List<Salaire>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Long trouverNombreOccurrencesParEmbauche(Embauche embauche) {
		Query q = em
				.createQuery("select count(i) from Salaire i join i.embauche emba where emba.id = :id");
		q.setParameter("id", embauche.getId());

		Long li = new Long(0);
		try {
			li = (Long) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Salaire trouverPrecedentSalaireParEmbauche(Embauche embauche,
			Date max) {
		Query q = em
				.createQuery("select i from Salaire i join i.embauche emba where emba.id = :id and i.dateeffe < :max order by i.dateeffe desc");
		q.setParameter("id", embauche.getId());
		q.setParameter("max", max);
		q.setMaxResults(1);

		List<Salaire> li = null;
		try {
			li = (List<Salaire>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li != null && li.size() > 0)
			return li.get(0);
		return new Salaire();
	}

	@Override
	public Salaire trouverSuivantSalaireParEmbauche(Embauche embauche, Date min) {
		Query q = em
				.createQuery("select i from Salaire i join i.embauche emba where emba.id = :id and i.dateeffe > :min order by i.dateeffe");
		q.setParameter("id", embauche.getId());
		q.setParameter("min", min);
		q.setMaxResults(1);

		List<Salaire> li = null;
		try {
			li = (List<Salaire>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li != null && li.size() > 0)
			return li.get(0);
		return new Salaire();
	}

	@Override
	public Salaire trouverPremierSalaireParEmbauche(Embauche embauche) {
		Query q = em
				.createQuery("select i from Salaire i join i.embauche emba where emba.id = :id order by i.dateeffe");
		q.setParameter("id", embauche.getId());
		q.setMaxResults(1);

		List<Salaire> li = null;
		try {
			li = (List<Salaire>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li != null && li.size() > 0)
			return li.get(0);
		return new Salaire();
	}

	@Override
	public Salaire trouverDernierSalaireParEmbauche(Embauche embauche) {
		Query q = em
				.createQuery("select i from Salaire i join i.embauche emba where emba.id = :id order by i.dateeffe desc");
		q.setParameter("id", embauche.getId());
		q.setMaxResults(1);

		List<Salaire> li = null;
		try {
			li = (List<Salaire>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li != null && li.size() > 0)
			return li.get(0);
		return new Salaire();
	}

}
