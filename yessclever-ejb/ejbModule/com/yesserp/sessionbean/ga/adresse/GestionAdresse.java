package com.yesserp.sessionbean.ga.adresse;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Adresse;
import com.yesserp.domain.ga.Identite;

/**
 * Session Bean implementation class GestionAdresse
 */
@Stateless
@LocalBean
public class GestionAdresse implements GestionAdresseLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public GestionAdresse() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterAdresse(Adresse adresse) {

		em.persist(adresse);
	}

	@Override
	public void supprimerAdresse(Adresse adresse) {
		em.remove(em.merge(adresse));

	}

	@Override
	public void modifierAdresse(Adresse adresse) {
		em.merge(adresse);

	}

	@Override
	public Adresse trouverParId(Long id) {

		return em.find(Adresse.class, id);

	}

	@Override
	public List<Adresse> trouverAdressesParIdentite(Identite identite) {
		Query q = em
				.createQuery("select i from Adresse i join i.identite iden where iden.numedoss = :id and i.datefin IS NULL order by i.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		List<Adresse> li = null;
		try {
			li = (List<Adresse>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;

	}

	@Override
	public Adresse trouverAdressePrincipaleParIdentite(Identite identite) {
		Query q = em
				.createQuery("select i from Adresse i join i.identite iden where iden.numedoss = :id and i.datefin IS NULL and i.principa IS TRUE order by i.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		List<Adresse> li = null;
		try {
			li = (List<Adresse>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li.size() > 0)
			return li.get(0);
		return null;

	}

	@Override
	public Long trouverNombreOccurrencesParIdentite(Identite identite) {
		// TODO Auto-generated method stub
		Query q = em
				.createQuery("select count(i) from Adresse i join i.identite iden where iden.numedoss = :id");
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
		// TODO Auto-generated method stub
		Query q = em
				.createQuery("select count(i) from Adresse i join i.identite iden where iden.numedoss = :id and i.datefin is null");
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
	public List<Adresse> trouverHistoriqueAdressesParIdentite(
			Identite identite, int n) {
		Query q = em
				.createQuery("select i from Adresse i join i.identite iden where iden.numedoss = :id order by i.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());

		q.setMaxResults(n);

		List<Adresse> li = null;
		try {
			li = (List<Adresse>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public List<Adresse> trouverHistoriqueAdressesParIdentiteEtDateMinMax(
			Identite identite, Date min, Date max, int n) {

		Query q = em
				.createQuery("select i from Adresse i join i.identite iden where iden.numedoss = :id and i.dateeffe > :min and i.dateeffe < :max order by i.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setParameter("max", max);

		q.setMaxResults(n);

		List<Adresse> li = null;
		try {
			li = (List<Adresse>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Adresse> trouverHistoriqueAdressesParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = em
				.createQuery("select i from Adresse i join i.identite iden where iden.numedoss = :id and i.dateeffe > :min order by i.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<Adresse> li = null;
		try {
			li = (List<Adresse>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public List<Adresse> trouverHistoriqueAdressesParIdentiteEtDateMax(
			Identite identite, Date max, int n) {
		Query q = em
				.createQuery("select i from Adresse i join i.identite iden where iden.numedoss = :id and i.dateeffe < :max order by i.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("max", max);
		q.setMaxResults(n);

		List<Adresse> li = null;
		try {
			li = (List<Adresse>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Adresse> trouverPremiersHistoriqueAdressesParIdentiteEtDateMin(
			Identite identite, Date min, int n) {

		Query q = em
				.createQuery("select i from Adresse i join i.identite iden where iden.numedoss = :id and i.dateeffe > :min order by i.dateeffe");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);

		q.setMaxResults(n);

		List<Adresse> li = null;
		try {
			li = (List<Adresse>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);
		return li;

	}

	@Override
	public List<Adresse> trouverPremiersHistoriqueAdressesParIdentite(
			Identite identite, int n) {
		Query q = em
				.createQuery("select i from Adresse i join i.identite iden where iden.numedoss = :id order by i.dateeffe");
		q.setParameter("id", identite.getNumedoss());

		q.setMaxResults(n);

		List<Adresse> li = null;
		try {
			li = (List<Adresse>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);
		return li;
	}

}
