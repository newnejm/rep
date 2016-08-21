package com.yesserp.sessionbean.ga.imputationga;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Affectation;
import com.yesserp.domain.ga.ImputationGa;

/**
 * Session Bean implementation class GestionImputationGa
 */
@Stateless
@LocalBean
public class GestionImputationGa implements GestionImputationGaLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public GestionImputationGa() {

	}

	@Override
	public void ajouterImputationGa(ImputationGa imputationGa) {
		em.persist(imputationGa);

	}

	@Override
	public void supprimerImputationGa(ImputationGa imputationGa) {
		em.remove(em.merge(imputationGa));

	}

	@Override
	public void modifierImputationGa(ImputationGa imputationGa) {
		em.merge(imputationGa);

	}

	@Override
	public ImputationGa trouverParId(Long id) {
		return em.find(ImputationGa.class, id);
	}

	@Override
	public List<ImputationGa> trouverImputationGasActifsParAffectation(
			Affectation affectation) {
		Query q = em
				.createQuery("select i from ImputationGa i join i.affectation aff where aff.id = :id and i.datefin IS NULL order by i.dateffet desc");
		q.setParameter("id", affectation.getId());
		List<ImputationGa> li = null;
		try {
			li = (List<ImputationGa>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li.size() > 0)
			return li;
		return null;
	}

	@Override
	public List<ImputationGa> trouverHistoriqueImputationGasParAffectation(
			Affectation affectation, int n) {
		Query q = em
				.createQuery("select i from ImputationGa i join i.affectation aff where aff.id = :id order by i.dateffet desc");
		q.setParameter("id", affectation.getId());
		q.setMaxResults(n);

		List<ImputationGa> li = null;
		try {
			li = (List<ImputationGa>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li.size() > 0)
			return li;
		return null;
	}

	@Override
	public List<ImputationGa> trouverHistoriqueImputationGasParAffectationEtDateMin(
			Affectation affectation, Date min, int n) {
		Query q = em
				.createQuery("select i from ImputationGa i join i.affectation aff where aff.id = :id and i.dateffet > :min order by i.dateffet desc");
		q.setParameter("id", affectation.getId());
		q.setMaxResults(n);
		q.setParameter("min", min);

		List<ImputationGa> li = null;
		try {
			li = (List<ImputationGa>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li.size() > 0)
			return li;
		return null;
	}

	@Override
	public List<ImputationGa> trouverPremiersHistoriqueImputationGasParAffectationEtDateMin(
			Affectation affectation, Date min, int n) {
		Query q = em
				.createQuery("select i from ImputationGa i join i.affectation aff where aff.id = :id and i.dateffet > :min order by i.dateffet");
		q.setParameter("id", affectation.getId());
		q.setMaxResults(n);
		q.setParameter("min", min);

		List<ImputationGa> li = null;
		try {
			li = (List<ImputationGa>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li.size() > 0) {
			Collections.reverse(li);
			return li;
		}
		return null;
	}

	@Override
	public List<ImputationGa> trouverPremiersHistoriqueImputationGasParAffectation(
			Affectation affectation, int n) {
		Query q = em
				.createQuery("select i from ImputationGa i join i.affectation aff where aff.id = :id order by i.dateffet");
		q.setParameter("id", affectation.getId());

		q.setMaxResults(n);

		List<ImputationGa> li = null;
		try {
			li = (List<ImputationGa>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li.size() > 0) {
			Collections.reverse(li);
			return li;
		}
		return null;
	}

	@Override
	public List<ImputationGa> trouverHistoriqueImputationGasParAffectationEtDateMax(
			Affectation affectation, Date max, int n) {
		Query q = em
				.createQuery("select i from ImputationGa i join i.affectation aff where aff.id = :id and i.dateffet < :max order by i.dateffet desc");
		q.setParameter("id", affectation.getId());
		q.setMaxResults(n);
		q.setParameter("max", max);

		List<ImputationGa> li = null;
		try {
			li = (List<ImputationGa>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li.size() > 0)
			return li;
		return null;
	}

	@Override
	public List<ImputationGa> trouverHistoriqueImputationGasParAffectationEtDateMinMax(
			Affectation affectation, Date min, Date max, int n) {
		Query q = em
				.createQuery("select i from ImputationGa i join i.affectation aff where aff.id = :id and i.dateffet > :min and i.dateffet < :max order by i.dateffet desc");
		q.setParameter("id", affectation.getId());
		q.setMaxResults(n);
		q.setParameter("max", max);
		q.setParameter("min", min);

		List<ImputationGa> li = null;
		try {
			li = (List<ImputationGa>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li.size() > 0)
			return li;
		return null;
	}

	@Override
	public Long trouverNombreOccurrencesParAffectation(Affectation affectation) {
		Query q = em
				.createQuery("select count(i) from ImputationGa i join i.affectation aff where aff.id = :id");
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
				.createQuery("select count(i) from ImputationGa i join i.affectation aff where aff.id = :id and i.datefin IS NULL");
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
