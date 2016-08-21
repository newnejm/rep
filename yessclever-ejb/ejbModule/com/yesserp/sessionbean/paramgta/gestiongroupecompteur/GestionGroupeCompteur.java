package com.yesserp.sessionbean.paramgta.gestiongroupecompteur;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gtaparam.GroupeCompteur;

/**
 * Session Bean implementation class GroupeCompteur
 */
@Stateless
@LocalBean
public class GestionGroupeCompteur implements GestionGroupeCompteurLocal {

	/**
	 * Default constructor.
	 */
	public GestionGroupeCompteur() {
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajouterGroupeCompteur(GroupeCompteur groupeCompteur) {

		entityManager.persist(groupeCompteur);
	}

	@Override
	public void modifierGroupeCompteur(GroupeCompteur groupeCompteur) {
		entityManager.merge(groupeCompteur);

	}





	@Override
	public List<GroupeCompteur> trouverGroupesCompteursParIdentite(
			Identite identite) {
		Query q = entityManager
				.createQuery("select i from GroupeCompteur i join i.identite iden where iden.numedoss = :id and i.datefin IS NULL order by i.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		List<GroupeCompteur> li = null;
		try {
			li =  q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public List<GroupeCompteur> trouverHistoriqueGroupesCompteursParIdentite(
			Identite identite, int n) {
		Query q = entityManager
				.createQuery("select i from GroupeCompteur i join i.identite iden where iden.numedoss = :id order by i.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());

		q.setMaxResults(n);

		List<GroupeCompteur> li = null;
		try {
			li = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public List<GroupeCompteur> trouverHistoriqueGroupesCompteursParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = entityManager
				.createQuery("select i from GroupeCompteur i join i.identite iden where iden.numedoss = :id and c.dateeffe > :min order by c.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<GroupeCompteur> li = null;
		try {
			li =  q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public List<GroupeCompteur> trouverPremiersHistoriqueGroupesCompteursParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = entityManager
				.createQuery("select i from GroupeCompteur i join i.identite iden where iden.numedoss = :id and c.dateeffe > :min order by c.dateeffe");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);

		q.setMaxResults(n);

		List<GroupeCompteur> li = null;
		try {
			li =  q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);
		return li;
	}

	@Override
	public List<GroupeCompteur> trouverHistoriqueGroupesCompteursParIdentiteEtDateMax(
			Identite identite, Date max, int n) {
		Query q = entityManager
				.createQuery("select i from GroupeCompteur i join i.identite iden where iden.numedoss = :id and c.dateeffe < :max order by c.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("max", max);
		q.setMaxResults(n);

		List<GroupeCompteur> li = null;
		try {
			li =  q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<GroupeCompteur> trouverHistoriqueGroupesCompteursParIdentiteEtDateMinMax(
			Identite identite, Date min, Date max, int n) {
		Query q = entityManager
				.createQuery("select i from GroupeCompteur i join i.identite iden where iden.numedoss = :id and c.dateeffe > :min and c.dateeffe < :max order by c.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setParameter("max", max);

		q.setMaxResults(n);

		List<GroupeCompteur> li = null;
		try {
			li = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<GroupeCompteur> trouverPremiersHistoriqueGroupesCompteurssParIdentite(
			Identite identite, int n) {
		Query q = entityManager
				.createQuery("select i from GroupeCompteur i join i.identite iden where iden.numedoss = :id order by c.dateeffe");
		q.setParameter("id", identite.getNumedoss());

		q.setMaxResults(n);

		List<GroupeCompteur> li = null;
		try {
			li =  q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);
		return li;
	}

	@Override
	public Long trouverNombreOccurrencesParIdentite(Identite identite) {
		Query q = entityManager
				.createQuery("select count(i) from GroupeCompteur i join i.identite iden where iden.numedoss = :id");
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
		Query q = entityManager
				.createQuery("select count(c) from  GroupeCompteur i join i.identite iden where iden.numedoss = :id and c.datefin is null");
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
	public void supprimerGroupeCompteur(GroupeCompteur groupeCompteur) {
		GroupeCompteur p = entityManager.find(GroupeCompteur.class, groupeCompteur.getIdgrpc());
        if (p != null) 
        {
        	entityManager.remove(entityManager.merge(p));
       
        }	
        }

	@Override
	public void affecterGroupetoIdentite(Identite identite,
			GroupeCompteur groupeCompteur, Date dateefet, Date datefin) {
		// TODO Auto-generated method stub
		
	}
		
	

}
