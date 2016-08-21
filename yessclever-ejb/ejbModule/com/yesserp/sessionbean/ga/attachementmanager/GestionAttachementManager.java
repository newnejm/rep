package com.yesserp.sessionbean.ga.attachementmanager;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Affectation;
import com.yesserp.domain.ga.AttachementManager;

/**
 * Session Bean implementation class GestionAttachementManager
 */
@Stateless
@LocalBean
public class GestionAttachementManager implements
		GestionAttachementManagerLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public GestionAttachementManager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterAttachementManager(AttachementManager attachementManager) {
		em.persist(attachementManager);

	}

	@Override
	public void supprimerAttachementManager(
			AttachementManager attachementManager) {
		em.remove(em.merge(attachementManager));

	}

	@Override
	public void modifierAttachementManager(AttachementManager attachementManager) {
		em.merge(attachementManager);

	}

	@Override
	public AttachementManager trouverParId(Long id) {

		return em.find(AttachementManager.class, id);
	}

	@Override
	public List<AttachementManager> trouverAttachementsManagersActifsParAffectation(
			Affectation affectation) {

		Query q = em
				.createQuery("select i from AttachementManager i join i.affectationManager aff where aff.id = :id and i.datefin IS NULL");
		q.setParameter("id", affectation.getId());
		List<AttachementManager> li = null;
		try {
			li = (List<AttachementManager>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li.size() > 0)
			return li;
		return null;
	}

	@Override
	public List<AttachementManager> trouverHistoriqueAttachementsManagersParAffectation(
			Affectation affectation, int n) {
		Query q = em
				.createQuery("select i from AttachementManager i join i.affectationManager aff where aff.id = :id order by i.datedeb desc");
		q.setParameter("id", affectation.getId());
		q.setMaxResults(n);
		List<AttachementManager> li = null;
		try {
			li = (List<AttachementManager>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<AttachementManager> trouverHistoriqueAttachementsManagersParAffectationEtDateMin(
			Affectation affectation, Date min, int n) {
		Query q = em
				.createQuery("select i from AttachementManager i join i.affectationManager aff where aff.id = :id and i.datedeb > :min order by i.datedeb desc");
		q.setParameter("id", affectation.getId());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<AttachementManager> li = null;
		try {
			li = (List<AttachementManager>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<AttachementManager> trouverPremiersHistoriqueAttachementsManagersParAffectationEtDateMin(
			Affectation affectation, Date min, int n) {
		Query q = em
				.createQuery("select i from AttachementManager i join i.affectationManager aff where aff.id = :id and i.datedeb > :min order by i.datedeb");
		q.setParameter("id", affectation.getId());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<AttachementManager> li = null;
		try {
			li = (List<AttachementManager>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);
		return li;
	}
	
	@Override
	public List<AttachementManager> trouverPremiersHistoriqueAttachementsManagersParAffectation(
			Affectation affectation, int n) {
		Query q = em
				.createQuery("select i from AttachementManager i join i.affectationManager aff where aff.id = :id order by i.datedeb");
		q.setParameter("id", affectation.getId());
		
		q.setMaxResults(n);

		List<AttachementManager> li = null;
		try {
			li = (List<AttachementManager>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);
		return li;
	}

	@Override
	public List<AttachementManager> trouverHistoriqueAttachementsManagersParAffectationEtDateMax(
			Affectation affectation, Date max, int n) {
		Query q = em
				.createQuery("select i from AttachementManager i join i.affectationManager aff where aff.id = :id and i.datedeb < :max order by i.datedeb desc");
		q.setParameter("id", affectation.getId());
		q.setParameter("max", max);

		q.setMaxResults(n);

		List<AttachementManager> li = null;
		try {
			li = (List<AttachementManager>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<AttachementManager> trouverHistoriqueAttachementsManagersParAffectationEtDateMinMax(
			Affectation affectation, Date min, Date max, int n) {
		Query q = em
				.createQuery("select i from AttachementManager i join i.affectationManager aff where aff.id = :id and i.datedeb > :min and i.datedeb < :max order by i.datedeb desc");
		q.setParameter("id", affectation.getId());
		q.setParameter("min", min);
		q.setParameter("max", max);

		q.setMaxResults(n);

		List<AttachementManager> li = null;
		try {
			li = (List<AttachementManager>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Long trouverNombreOccurrencesParAffectation(Affectation affectation) {
		Query q = em
				.createQuery("select count(i) from AttachementManager i join i.affectationManager aff where aff.id = :id");
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
				.createQuery("select count(i) from AttachementManager i join i.affectationManager aff where aff.id = :id and i.datefin IS NULL");
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
