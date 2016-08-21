package com.yesserp.sessionbean.gta.gestionClasseEmp;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.ClasseEmp;

/**
 * Session Bean implementation class GestionClasseEmp
 */
@Stateless
@LocalBean
public class GestionClasseEmp implements GestionClasseEmpLocal {

	@PersistenceContext(unitName = "yessclever")
	private EntityManager entityManager;
    
	
	public GestionClasseEmp() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void supprimerClasseEmp(ClasseEmp classeEmp) {
		ClasseEmp p = entityManager.find(ClasseEmp.class, classeEmp.getId());
        if (p != null) 
        {
        	entityManager.remove(entityManager.merge(p));
       
        }
		
	}

	@Override
	public void modifierClasseEmp(ClasseEmp classeEmp) {
		entityManager.merge(classeEmp);
		
	}

	@Override
	public List<ClasseEmp> trouverClasseEmpParIdentite(Identite identite) {
		Query q = entityManager
				.createQuery("select i from ClasseEmp i join i.identite iden where iden.numedoss = :id and i.dateFin IS NULL order by i.dateeffet desc  ");
		q.setParameter("id", identite.getNumedoss());
		List<ClasseEmp> li = null;
		try {
			li =  q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public List<ClasseEmp> trouverHistoriqueClasseEmpParIdentite(
			Identite identite, int n) {
		Query q = entityManager
				.createQuery("select i from ClasseEmp i join i.identite iden where iden.numedoss = :id order by i.dateeffet desc ");
		q.setParameter("id", identite.getNumedoss());

		q.setMaxResults(n);

		List<ClasseEmp> li = null;
		try {
			li = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public List<ClasseEmp> trouverHistoriqueClasseEmpParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = entityManager
				.createQuery("select i from ClasseEmp i join i.identite iden where iden.numedoss = :id and c.dateeffet > :min order by c.dateeffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<ClasseEmp> li = null;
		try {
			li =  q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public List<ClasseEmp> trouverPremiersHistoriqueClasseEmpParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = entityManager
				.createQuery("select i from ClasseEmp i join i.identite iden where iden.numedoss = :id and c.dateeffet > :min order by c.dateeffet");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);

		q.setMaxResults(n);

		List<ClasseEmp> li = null;
		try {
			li =  q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);
		return li;
	}

	@Override
	public List<ClasseEmp> trouverHistoriqueClasseEmpParIdentiteEtDateMax(
			Identite identite, Date max, int n) {
		Query q = entityManager
				.createQuery("select i from ClasseEmp i join i.identite iden where iden.numedoss = :id and c.dateeffet < :max order by c.dateeffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("max", max);
		q.setMaxResults(n);

		List<ClasseEmp> li = null;
		try {
			li =  q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<ClasseEmp> trouverHistoriqueClasseEmpParIdentiteEtDateMinMax(
			Identite identite, Date min, Date max, int n) {
		Query q = entityManager
				.createQuery("select i from ClasseEmp i join i.identite iden where iden.numedoss = :id and c.dateeffet > :min and c.dateeffet < :max order by c.dateeffet desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setParameter("max", max);

		q.setMaxResults(n);

		List<ClasseEmp> li = null;
		try {
			li = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<ClasseEmp> trouverPremiersHistoriqueGClasseEmpParIdentite(
			Identite identite, int n) {
		Query q = entityManager
				.createQuery("select i from ClasseEmp i join i.identite iden where iden.numedoss = :id order by c.dateeffet");
		q.setParameter("id", identite.getNumedoss());

		q.setMaxResults(n);

		List<ClasseEmp> li = null;
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
				.createQuery("select count(i) from ClasseEmp i join i.identite iden where iden.numedoss = :id ");
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
				.createQuery("select count(c) from  ClasseEmp i join i.identite iden where iden.numedoss = :id and c.dateFin is null ");
		q.setParameter("ide", identite.getNumedoss());

		Long li = new Long(0);
		try {
			li = (Long) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

}
