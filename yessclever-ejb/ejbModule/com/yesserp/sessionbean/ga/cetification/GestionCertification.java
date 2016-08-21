package com.yesserp.sessionbean.ga.cetification;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Certification;
import com.yesserp.domain.ga.Identite;

/**
 * Session Bean implementation class gestionCertification
 */
@Stateless
@LocalBean
public class GestionCertification implements GestionCertificationLocal {

	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public GestionCertification() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void ajouterCertification(Certification certification) {
		em.persist(certification);
		
	}

	@Override
	public void supprimerCertification(Certification certification) {
		em.remove(em.merge(certification));
		
	}

	@Override
	public void modifierCertification(Certification certification) {
		em.merge(certification);
		
	}

	@Override
	public Certification trouverParId(Long id) {
		
		return em.find(Certification.class, id);
	}

	@Override
	public List<Certification> trouverCertificationsParIdentite(Identite identite, int n) {
		Query q = em
				.createQuery("select i from Certification i join i.identite iden where iden.numedoss = :id order by i.dateffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(n);
		List<Certification> li = null;
		try {
			li = (List<Certification>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Certification> trouverCertificationsParIdentiteEtDateMin(Identite identite,
			Date min, int n) {
		Query q = em
				.createQuery("select i from Certification i join i.identite iden where iden.numedoss = :id and i.dateffet > :min order by i.dateffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<Certification> li = null;
		try {
			li = (List<Certification>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Certification> trouverPremiersCertificationsParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = em
				.createQuery("select i from Certification i join i.identite iden where iden.numedoss = :id and i.dateffet > :min order by i.dateffet");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<Certification> li = null;
		try {
			li = (List<Certification>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);

		return li;
	}

	@Override
	public List<Certification> trouverCertificationsParIdentiteEtDateMax(Identite identite,
			Date max, int n) {
		Query q = em
				.createQuery("select i from Certification i join i.identite iden where iden.numedoss = :id and i.dateffet < :max order by i.dateffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("max", max);
		q.setMaxResults(n);
		List<Certification> li = null;
		try {
			li = (List<Certification>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Certification> trouverCertificationsParIdentiteEtDateMinMax(
			Identite identite, Date min, Date max, int n) {
		Query q = em
				.createQuery("select i from Certification i join i.identite iden where iden.numedoss = :id and i.dateffet > :min and i.dateffet < :max order by i.dateffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setParameter("max", max);
		q.setMaxResults(n);

		List<Certification> li = null;
		try {
			li = (List<Certification>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Long trouverNombreOccurrencesParIdentite(Identite identite) {
		Query q = em
				.createQuery("select count(i) from Certification i join i.identite iden where iden.numedoss = :id");
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
	public List<Certification> trouverPremiersCertificationsParIdentite(Identite identite,
			int n) {
		Query q = em
				.createQuery("select i from Certification i join i.identite iden where iden.numedoss = :id order by i.dateffet");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(n);
		List<Certification> li = null;
		try {
			li = (List<Certification>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Collections.reverse(li);
		return li;
	}

	@Override
	public List<Certification> findAll() {
		Query query = em.createQuery("select c from Certification c");
		return query.getResultList();
	}

}
