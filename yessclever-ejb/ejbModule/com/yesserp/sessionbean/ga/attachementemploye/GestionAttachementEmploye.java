package com.yesserp.sessionbean.ga.attachementemploye;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Affectation;
import com.yesserp.domain.ga.AttachementEmploye;

/**
 * Session Bean implementation class GestionAttachementEmploye
 */
@Stateless
@LocalBean
public class GestionAttachementEmploye implements
		GestionAttachementEmployeLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public GestionAttachementEmploye() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterAttachementEmploye(AttachementEmploye attachementEmploye) {
		em.persist(attachementEmploye);

	}

	@Override
	public void supprimerAttachementEmploye(
			AttachementEmploye attachementEmploye) {
		em.remove(em.merge(attachementEmploye));

	}

	@Override
	public void modifierAttachementEmploye(AttachementEmploye attachementEmploye) {
		em.merge(attachementEmploye);

	}

	@Override
	public AttachementEmploye trouverParId(Long id) {

		return em.find(AttachementEmploye.class, id);
	}

	@Override
	public List<AttachementEmploye> trouverAttachementsEmployersActifsParAffectation(
			Affectation affectation) {
		Query q = em
				.createQuery("select i from AttachementEmploye i join i.affectationEmploye aff where aff.id = :id and i.datefin IS NULL");
		q.setParameter("id", affectation.getId());
		List<AttachementEmploye> li = null;
		try {
			li = (List<AttachementEmploye>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li.size() > 0)
			return li;
		return null;
	}

	@Override
	public List<AttachementEmploye> trouverHistoriqueAttachementsEmployesParAffectation(
			Affectation affectation, int n) {
		Query q = em
				.createQuery("select i from AttachementEmploye i join i.affectea aff where aff.id = :id order by i.datedeb desc");
		q.setParameter("id", affectation.getId());
		q.setMaxResults(n);
		List<AttachementEmploye> li = null;
		try {
			li = (List<AttachementEmploye>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<AttachementEmploye> trouverHistoriqueAttachementsEmployesParAffectationEtDateMin(
			Affectation affectation, Date min, int n) {
		Query q = em
				.createQuery("select i from AttachementEmploye i join i.affectea aff where aff.id = :id and i.datedeb > :min order by i.datedeb desc");
		q.setParameter("id", affectation.getId());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<AttachementEmploye> li = null;
		try {
			li = (List<AttachementEmploye>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<AttachementEmploye> trouverPremiersHistoriqueAttachementsEmployesParAffectationEtDateMin(
			Affectation affectation, Date min, int n) {
		Query q = em
				.createQuery("select i from AttachementEmploye i join i.affectea aff where aff.id = :id and i.datedeb > :min order by i.datedeb");
		q.setParameter("id", affectation.getId());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<AttachementEmploye> li = null;
		try {
			li = (List<AttachementEmploye>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);
		return li;
	}

	@Override
	public List<AttachementEmploye> trouverPremiersHistoriqueAttachementsEmployesParAffectation(
			Affectation affectation, int n) {
		Query q = em
				.createQuery("select i from AttachementEmploye i join i.affectea aff where aff.id = :id order by i.datedeb");
		q.setParameter("id", affectation.getId());
		q.setMaxResults(n);

		List<AttachementEmploye> li = null;
		try {
			li = (List<AttachementEmploye>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);
		return li;
	}

	
	@Override
	public List<AttachementEmploye> trouverHistoriqueAttachementsEmployesParAffectationEtDateMax(
			Affectation affectation, Date max, int n) {
		Query q = em
				.createQuery("select i from AttachementEmploye i join i.affectea aff where aff.id = :id and i.datedeb < :max order by i.datedeb desc");
		q.setParameter("id", affectation.getId());
		q.setParameter("max", max);

		q.setMaxResults(n);

		List<AttachementEmploye> li = null;
		try {
			li = (List<AttachementEmploye>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<AttachementEmploye> trouverHistoriqueAttachementsEmployesParAffectationEtDateMinMax(
			Affectation affectation, Date min, Date max, int n) {
		Query q = em
				.createQuery("select i from AttachementEmploye i join i.affectea aff where aff.id = :id and i.datedeb > :min and i.datedeb < :max order by i.datedeb desc");
		q.setParameter("id", affectation.getId());
		q.setParameter("min", min);
		q.setParameter("max", max);

		q.setMaxResults(n);

		List<AttachementEmploye> li = null;
		try {
			li = (List<AttachementEmploye>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Long trouverNombreOccurrencesParAffectation(Affectation affectation) {
		Query q = em
				.createQuery("select count(i) from AttachementEmploye i join i.affectea aff where aff.id = :id");
		q.setParameter("id", affectation.getId());

		Long li = new Long(0);
		try {
			li = (Long) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Long trouverNombreOccurrencesActivesParAffectation(
			Affectation affectation) {
		Query q = em
				.createQuery("select count(i) from AttachementEmploye i join i.affectea aff where aff.id = :id and i.datefin IS NULL");
		q.setParameter("id", affectation.getId());

		Long li = new Long(0);
		try {
			li = (Long) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

}
