package com.yesserp.sessionbean.ga.profil;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.Profil;

/**
 * Session Bean implementation class GestionProfil
 */
@Stateless
@LocalBean
public class GestionProfil implements GestionProfilLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public GestionProfil() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterProfil(Profil profil) {

		em.persist(profil);
	}

	@Override
	public void supprimerProfil(Profil profil) {
		em.remove(em.merge(profil));

	}

	@Override
	public void modifierProfil(Profil profil) {
		em.merge(profil);

	}

	@Override
	public Profil trouverParId(Long id) {

		return em.find(Profil.class, id);

	}

	@Override
	public Profil trouverProfilParIdentite(Identite identite) {
		Query q = em
				.createQuery("select i from Profil i join i.identite iden where iden.numedoss = :id and i.datefin IS NULL order by i.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(1);
		Profil li = null;
		try {
			li = (Profil) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profil> trouverHistoriqueProfilsParIdentite(Identite identite,
			int n) {
		Query q = em
				.createQuery("select i from Profil i join i.identite iden where iden.numedoss = :id order by i.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		List<Profil> li = null;
		try {
			li = (List<Profil>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Long trouverNombreOccurrencesParIdentite(Identite identite) {
		Query q = em
				.createQuery("select count(i) from Profil i join i.identite iden where iden.numedoss = :id");
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
	public Profil trouverPrecedentProfilParIdentite(Identite identite, Date max) {
		Query q = em
				.createQuery("select i from Profil i join i.identite iden where iden.numedoss = :id and i.dateeffe < :max order by i.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("max", max);
		q.setMaxResults(1);

		Profil li = null;
		try {
			li = (Profil) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Profil trouverSuivantProfilParIdentite(Identite identite, Date min) {
		Query q = em
				.createQuery("select i from Profil i join i.identite iden where iden.numedoss = :id and i.dateeffe > :min order by i.dateeffe");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(1);

		Profil li = null;
		try {
			li = (Profil) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}
}
