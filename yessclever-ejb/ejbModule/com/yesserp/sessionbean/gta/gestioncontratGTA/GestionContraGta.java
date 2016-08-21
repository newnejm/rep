package com.yesserp.sessionbean.gta.gestioncontratGTA;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.InfosIndividuelles;
import com.yesserp.domain.gta.ContratGta;
import com.yesserp.domain.gtaparam.CycleTravail;
import com.yesserp.domain.gtaparam.GroupeCompteur;
import com.yesserp.domain.gtaparam.TerminalMobile;

/**
 * Session Bean implementation class GestionContraGta
 */
@Stateless
@LocalBean
public class GestionContraGta implements GestionContraGtaLocal {

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public GestionContraGta() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addContratGta(ContratGta contratGta) {

		entityManager.persist(contratGta);
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteContratGta(ContratGta contratGta) {
		ContratGta p = entityManager.find(ContratGta.class, contratGta.getId());
        if (p != null) 
        {
        	entityManager.remove(entityManager.merge(p));
       
        }	
        }

	

	@Override
	public void modifierContratGta(ContratGta contratGta) {
		entityManager.merge(contratGta);

		// TODO Auto-generated method stub

	}

	@Override
	public ContratGta getContratGtaByUser(Identite identite) {
		Query query = entityManager
				.createQuery("select c from ContratGta c inner join c.identites i where i=:x");
		query.setParameter("x", identite);
		return (ContratGta) query.getSingleResult();
	}

	@Override
	public String getClassByContrat(ContratGta cg) {
		Query query = entityManager
				.createQuery("select c.codeClasse from ClasseEmp c inner join c.contratGta i where i=:x");
		query.setParameter("x", cg);
		return (String) query.getSingleResult();
	}

	@Override
	public Object findEntity(Identite identite) {
		TypedQuery<Object[]> query = entityManager.createQuery("select c.codect,c.dateff,c.index , c.code from CycleTravail,CodeCalendrier,ContratGta where c.identite ",Object[].class);
		query.setParameter("identite", identite);
		List<Object[] > results = query.getResultList();
		
		return results;
	}

	@Override
	public List<ContratGta> trouverContratGtaParIdentite(Identite identite) {
		Query q = entityManager
				.createQuery("select i from ContratGta i join i.identite iden where iden.numedoss = :id and i.datefin IS NULL order by i.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		List<ContratGta> li = null;
		try {
			li =  q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public List<ContratGta> trouverHistoriqueContratGtaParIdentite(
			Identite identite, int n) {
		Query q = entityManager
				.createQuery("select i from ContratGta i join i.identite iden where iden.numedoss = :id order by i.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());

		q.setMaxResults(n);

		List<ContratGta> li = null;
		try {
			li = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public List<ContratGta> trouverHistoriqueContratGtaParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = entityManager
				.createQuery("select i from GroupeCompteur i join i.identite iden where iden.numedoss = :id and c.dateeffe > :min order by c.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<ContratGta> li = null;
		try {
			li =  q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public List<ContratGta> trouverPremiersHistoriqueContratGtaParIdentiteEtDateMin(
			Identite identite, Date min, int n) {
		Query q = entityManager
				.createQuery("select i from ContratGta i join i.identite iden where iden.numedoss = :id and c.dateeffe > :min order by c.dateeffe");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);

		q.setMaxResults(n);

		List<ContratGta> li = null;
		try {
			li =  q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);
		return li;
	}

	@Override
	public List<ContratGta> trouverHistoriqueContratGtaParIdentiteEtDateMax(
			Identite identite, Date max, int n) {
		Query q = entityManager
				.createQuery("select i from ContratGta i join i.identite iden where iden.numedoss = :id and c.dateeffet < :max order by c.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("max", max);
		q.setMaxResults(n);

		List<ContratGta> li = null;
		try {
			li =  q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<ContratGta> trouverHistoriqueContratGtaParIdentiteEtDateMinMax(
			Identite identite, Date min, Date max, int n) {
		Query q = entityManager
				.createQuery("select i from ContratGta i join i.identite iden where iden.numedoss = :id and c.dateeffe > :min and c.dateeffe < :max order by c.dateeffe desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setParameter("max", max);

		q.setMaxResults(n);

		List<ContratGta> li = null;
		try {
			li = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<ContratGta> trouverPremiersHistoriqueContratGtaParIdentite(
			Identite identite, int n) {
		Query q = entityManager
				.createQuery("select i from ContratGta i join i.identite iden where iden.numedoss = :id order by c.dateeffe");
		q.setParameter("id", identite.getNumedoss());

		q.setMaxResults(n);

		List<ContratGta> li = null;
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
				.createQuery("select count(i) from ContratGta i join i.identite iden where iden.numedoss = :id");
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
				.createQuery("select count(c) from  ContratGta i join i.identite iden where iden.numedoss = :id and c.datefin is null");
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
	public List<TerminalMobile> listAllTerminal() {
		Query q = entityManager
				.createQuery("select i from TerminalMobile  i "); 
		
		List<TerminalMobile> li = null;
		try {
			li = (List<TerminalMobile>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	
	}

	@Override
	public List<TerminalMobile> listAllTerminalByIdentite(Identite identite) {
		Query q = entityManager
				.createQuery("select i from TerminalMobile i join i.identite iden where iden.numedoss = :id");
		q.setParameter("id", identite.getNumedoss());
		List<TerminalMobile> li = null;
		try {
			li = (List<TerminalMobile>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public void ajouterTerminalMobile(ContratGta contratGta,
			TerminalMobile terminalMobile) {
		try {
			terminalMobile.setContratGta(contratGta);;
			entityManager.persist(terminalMobile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



}
