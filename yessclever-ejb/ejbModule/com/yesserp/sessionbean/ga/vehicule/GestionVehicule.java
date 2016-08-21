package com.yesserp.sessionbean.ga.vehicule;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.Vehicule;

/**
 * Session Bean implementation class GestionVehicule
 */
@Stateless
@LocalBean
public class GestionVehicule implements GestionVehiculeLocal {

	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public GestionVehicule() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterVehicule(Vehicule vehicule) {
		em.persist(vehicule);

	}

	@Override
	public void supprimerVehicule(Vehicule vehicule) {
		em.remove(em.merge(vehicule));
	}

	@Override
	public void modifierVehicule(Vehicule vehicule) {
		em.merge(vehicule);

	}

	@Override
	public Vehicule trouverParId(Long id) {

		return em.find(Vehicule.class, id);
	}

	@Override
	public List<Vehicule> trouverVehiculesActifsParIdentite(Identite identite) {
		Query q = em
				.createQuery("select i from Vehicule i join i.identite iden where iden.numedoss = :id and i.datefin IS NULL order bya i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());
		List<Vehicule> li = null;
		try {
			li = (List<Vehicule>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public List<Vehicule> trouverHistoriqueVehiculesParIdentite(
			Identite identite, int n) {
		Query q = em
				.createQuery("select i from Vehicule i join i.identite iden where iden.numedoss = :id order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(n);
		List<Vehicule> li = null;
		try {
			li = (List<Vehicule>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Vehicule> trouverHistoriqueVehiculesParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = em
				.createQuery("select i from Vehicule i join i.identite iden where iden.numedoss = :id and i.datedeb > :min order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<Vehicule> li = null;
		try {
			li = (List<Vehicule>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Vehicule> trouverPremiersHistoriqueVehiculesParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = em
				.createQuery("select i from Vehicule i join i.identite iden where iden.numedoss = :id and i.datedeb > :min order by i.datedeb");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<Vehicule> li = null;
		try {
			li = (List<Vehicule>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);

		return li;
	}

	@Override
	public List<Vehicule> trouverHistoriqueVehiculesParIdentiteEtDateMax(
			Identite identite, Date max, int n) {
		Query q = em
				.createQuery("select i from Vehicule i join i.identite iden where iden.numedoss = :id and i.datedeb < :max order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("max", max);
		q.setMaxResults(n);
		List<Vehicule> li = null;
		try {
			li = (List<Vehicule>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Vehicule> trouverHistoriqueVehiculesParIdentiteEtDateMinMax(
			Identite identite, Date min, Date max, int n) {
		Query q = em
				.createQuery("select i from Vehicule i join i.identite iden where iden.numedoss = :id and i.datedeb > :min and i.datedeb < :max order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setParameter("max", max);
		q.setMaxResults(n);

		List<Vehicule> li = null;
		try {
			li = (List<Vehicule>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Long trouverNombreOccurrencesParIdentite(Identite identite) {
		Query q = em
				.createQuery("select count(i) from Vehicule i join i.identite iden where iden.numedoss = :id");
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
				.createQuery("select count(i) from Vehicule i join i.identite iden where iden.numedoss = :id and i.datefin is null");
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
	public List<Vehicule> trouverPremiersHistoriqueVehiculesParIdentite(
			Identite identite, int n) {

		Query q = em
				.createQuery("select i from Vehicule i join i.identite iden where iden.numedoss = :id order by i.datedeb");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(n);
		List<Vehicule> li = null;
		try {
			li = (List<Vehicule>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Collections.reverse(li);
		return li;
	}

}
