package com.yesserp.sessionbean.ga.contrat;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Contrat;
import com.yesserp.domain.ga.Embauche;
import com.yesserp.domain.gtaparam.TerminalMobile;

/**
 * Session Bean implementation class GestionContrat
 */
@Stateless
@LocalBean
public class GestionContrat implements GestionContratLocal {

	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public GestionContrat() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterContrat(Contrat contrat) {
		em.persist(contrat);

	}

	@Override
	public void supprimerContrat(Contrat contrat) {
		em.remove(em.merge(contrat));

	}

	@Override
	public void modifierContrat(Contrat contrat) {
		em.merge(contrat);

	}

	@Override
	public Contrat trouverParId(Long id) {
		return em.find(Contrat.class, id);
	}

	@Override
	public List<Contrat> trouverContratsActifsParEmbauche(Embauche embauche) {
		Query q = em
				.createQuery("select i from Contrat i join i.embauche emba where emba.id = :id and i.actif IS TRUE order by i.datedebu desc");
		q.setParameter("id", embauche.getId());
		List<Contrat> li = null;
		try {
			li = (List<Contrat>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li.size() > 0)
			return li;
		return null;
	}

	@Override
	public List<Contrat> trouverHistoriqueContratsParEmbauche(
			Embauche embauche, int n) {
		Query q = em
				.createQuery("select i from Contrat i join i.embauche emba where emba.id = :id order by i.datedebu desc");
		q.setParameter("id", embauche.getId());
		q.setMaxResults(n);
		List<Contrat> li = null;
		try {
			li = (List<Contrat>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Long trouverNombreOccurrencesParEmbauche(Embauche embauche) {
		Query q = em
				.createQuery("select count(i) from Contrat i join i.embauche emba where emba.id = :id and i.actif IS TRUE");
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
	public Long trouverNombreOccurrencesActivesParEmbauche(Embauche embauche) {
		Query q = em
				.createQuery("select count(i) from Contrat i join i.embauche emba where emba.id = :id");
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
	public List<Contrat> trouverHistoriqueContratsParEmbaucheEtDateMin(
			Embauche embauche, Date min, int n) {
		Query q = em
				.createQuery("select i from Contrat i join i.embauche emba where emba.id = :id and i.datedebu > :min order by i.datedebu desc");
		q.setParameter("id", embauche.getId());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<Contrat> li = null;
		try {
			li = (List<Contrat>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Contrat> trouverPremiersHistoriqueContratsParEmbaucheEtDateMin(
			Embauche embauche, Date min, int n) {
		Query q = em
				.createQuery("select i from Contrat i join i.embauche emba where emba.id = :id and i.datedebu > :min order by i.datedebu");
		q.setParameter("id", embauche.getId());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<Contrat> li = null;
		try {
			li = (List<Contrat>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);
		return li;
	}

	@Override
	public List<Contrat> trouverHistoriqueContratsParEmbaucheEtDateMax(
			Embauche embauche, Date max, int n) {
		Query q = em
				.createQuery("select i from Contrat i join i.embauche emba where emba.id = :id and i.datedebu < :max order by i.datedebu desc");
		q.setParameter("id", embauche.getId());
		q.setParameter("max", max);
		q.setMaxResults(n);

		List<Contrat> li = null;
		try {
			li = (List<Contrat>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Contrat> trouverHistoriqueContratsParEmbaucheEtDateMinMax(
			Embauche embauche, Date min, Date max, int n) {
		Query q = em
				.createQuery("select i from Contrat i join i.embauche emba where emba.id = :id and i.datedebu > :min and i.datedebu < :max order by i.datedebu desc");
		q.setParameter("id", embauche.getId());
		q.setParameter("min", min);
		q.setParameter("max", max);
		q.setMaxResults(n);

		List<Contrat> li = null;
		try {
			li = (List<Contrat>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Contrat> trouverPremiersHistoriqueContratsParEmbauche(
			Embauche embauche, int n) {
		Query q = em
				.createQuery("select i from Contrat i join i.embauche emba where emba.id = :id and order by i.datedebu");
		q.setParameter("id", embauche.getId());
		
		q.setMaxResults(n);

		List<Contrat> li = null;
		try {
			li = (List<Contrat>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);
		return li;
	}

	
		

	@Override
	public List<Contrat> findAll() {
		Query query = em.createQuery("select c from Contrat c");
		return query.getResultList();
	}

}
