package com.yesserp.sessionbean.ga.situationmedicale;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.SituationMedicale;

/**
 * Session Bean implementation class GestionSituationMedicale
 */
@Stateless
@LocalBean
public class GestionSituationMedicale implements GestionSituationMedicaleLocal {

	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public GestionSituationMedicale() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterSituationMedicale(SituationMedicale situationMedicale) {

		em.persist(situationMedicale);

	}

	@Override
	public void supprimerSituationMedicale(SituationMedicale situationMedicale) {
		em.remove(em.merge(situationMedicale));

	}

	@Override
	public void modifierSituationMedicale(SituationMedicale situationMedicale) {
		em.merge(situationMedicale);

	}

	@Override
	public SituationMedicale trouverParId(Long id) {

		return em.find(SituationMedicale.class, id);
	}

	@Override
	public List<SituationMedicale> trouverSituationsMedicalesActivesParIdentite(
			Identite identite) {
		Query q = em
				.createQuery("select i from SituationMedicale i join i.identite iden where iden.numedoss = :id and i.datefin IS NULL order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());
		List<SituationMedicale> li = null;
		try {
			li = (List<SituationMedicale>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public List<SituationMedicale> trouverHistoriqueSituationsMedicalesParIdentite(
			Identite identite, int n) {
		Query q = em
				.createQuery("select i from SituationMedicale i join i.identite iden where iden.numedoss = :id order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(n);

		List<SituationMedicale> li = null;
		try {
			li = (List<SituationMedicale>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<SituationMedicale> trouverHistoriqueSituationMedicalesParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = em
				.createQuery("select i from SituationMedicale i join i.identite iden where iden.numedoss = :id and i.datedeb > :min order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<SituationMedicale> li = null;
		try {
			li = (List<SituationMedicale>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<SituationMedicale> trouverPremiersHistoriqueSituationMedicalesParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = em
				.createQuery("select i from SituationMedicale i join i.identite iden where iden.numedoss = :id and i.datedeb > :min order by i.datedeb");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<SituationMedicale> li = null;
		try {
			li = (List<SituationMedicale>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(li!=null)
			Collections.reverse(li);
		return li;
	}

	@Override
	public List<SituationMedicale> trouverHistoriqueSituationMedicalesParIdentiteEtDateMax(
			Identite identite, Date max, int n) {
		Query q = em
				.createQuery("select i from SituationMedicale i join i.identite iden where iden.numedoss = :id and i.datedeb < :max order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("max", max);
		q.setMaxResults(n);

		List<SituationMedicale> li = null;
		try {
			li = (List<SituationMedicale>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<SituationMedicale> trouverHistoriqueSituationMedicalesParIdentiteEtDateMinMax(
			Identite identite, Date min, Date max, int n) {
		Query q = em
				.createQuery("select i from SituationMedicale i join i.identite iden where iden.numedoss = :id and i.datedeb > :min and i.datedeb < :max order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setParameter("max", max);

		q.setMaxResults(n);

		List<SituationMedicale> li = null;
		try {
			li = (List<SituationMedicale>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Long trouverNombreOccurrencesParIdentite(Identite identite) {
		Query q = em
				.createQuery("select count(i) from SituationMedicale i join i.identite iden where iden.numedoss = :id");
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
				.createQuery("select count(i) from SituationMedicale i join i.identite iden where iden.numedoss = :id and i.datefin IS NULL");
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
	public List<SituationMedicale> trouverPremiersHistoriqueSituationsMedicalesParIdentite(
			Identite identite, int n) {
		Query q = em
				.createQuery("select i from SituationMedicale i join i.identite iden where iden.numedoss = :id order by i.datedeb");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(n);

		List<SituationMedicale> li = null;
		try {
			li = (List<SituationMedicale>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);
		return li;
	}

}
