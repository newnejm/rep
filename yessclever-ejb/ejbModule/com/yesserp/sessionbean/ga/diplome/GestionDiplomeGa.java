package com.yesserp.sessionbean.ga.diplome;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.DiplomeGa;
import com.yesserp.domain.ga.Identite;
/**
 * Session Bean implementation class gestionDiplomeGa
 */
@Stateless
@LocalBean
public class GestionDiplomeGa implements GestionDiplomeGaLocal {

	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public GestionDiplomeGa() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void ajouterDiplome(DiplomeGa diplome) {
		em.persist(diplome);
		
	}

	@Override
	public void supprimerDiplome(DiplomeGa diplome) {
		em.remove(em.merge(diplome));
		
	}

	@Override
	public void modifierDiplome(DiplomeGa diplome) {
		em.merge(diplome);
		
	}

	@Override
	public DiplomeGa trouverParId(Long id) {
		
		return em.find(DiplomeGa.class, id);
	}

	@Override
	public List<DiplomeGa> trouverDiplomesParIdentite(Identite identite, int n) {
		Query q = em
				.createQuery("select i from DiplomeGa i join i.identite iden where iden.numedoss = :id order by i.dateffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(n);
		List<DiplomeGa> li = null;
		try {
			li = (List<DiplomeGa>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<DiplomeGa> trouverDiplomesParIdentiteEtDateMin(Identite identite,
			Date min, int n) {
		Query q = em
				.createQuery("select i from DiplomeGa i join i.identite iden where iden.numedoss = :id and i.dateffet > :min order by i.dateffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<DiplomeGa> li = null;
		try {
			li = (List<DiplomeGa>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<DiplomeGa> trouverPremiersDiplomesParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = em
				.createQuery("select i from DiplomeGa i join i.identite iden where iden.numedoss = :id and i.dateffet > :min order by i.dateffet");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<DiplomeGa> li = null;
		try {
			li = (List<DiplomeGa>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);

		return li;
	}

	@Override
	public List<DiplomeGa> trouverDiplomesParIdentiteEtDateMax(Identite identite,
			Date max, int n) {
		Query q = em
				.createQuery("select i from DiplomeGa i join i.identite iden where iden.numedoss = :id and i.dateffet < :max order by i.dateffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("max", max);
		q.setMaxResults(n);
		List<DiplomeGa> li = null;
		try {
			li = (List<DiplomeGa>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<DiplomeGa> trouverDiplomesParIdentiteEtDateMinMax(
			Identite identite, Date min, Date max, int n) {
		Query q = em
				.createQuery("select i from DiplomeGa i join i.identite iden where iden.numedoss = :id and i.dateffet > :min and i.dateffet < :max order by i.dateffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setParameter("max", max);
		q.setMaxResults(n);

		List<DiplomeGa> li = null;
		try {
			li = (List<DiplomeGa>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Long trouverNombreOccurrencesParIdentite(Identite identite) {
		Query q = em
				.createQuery("select count(i) from DiplomeGa i join i.identite iden where iden.numedoss = :id");
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
	public List<DiplomeGa> trouverPremiersDiplomesParIdentite(Identite identite,
			int n) {
		Query q = em
				.createQuery("select i from DiplomeGa i join i.identite iden where iden.numedoss = :id order by i.dateffet");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(n);
		List<DiplomeGa> li = null;
		try {
			li = (List<DiplomeGa>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Collections.reverse(li);
		return li;
	}

	@Override
	public List<DiplomeGa> findAll() {
		Query query = em.createQuery("select d from DiplomeGa d");
		return query.getResultList();
		
	}

}
