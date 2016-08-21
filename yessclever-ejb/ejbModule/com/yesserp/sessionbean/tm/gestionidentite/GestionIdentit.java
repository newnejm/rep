package com.yesserp.sessionbean.tm.gestionidentite;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;

import com.yesserp.domain.tm.Offre;

/**
 * Session Bean implementation class GestionIdentit
 */
@Stateless
public class GestionIdentit implements GestionIdentitLocal {

    /**
     * Default constructor. 
     */
    public GestionIdentit() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    EntityManager entityManager;

	@Override
	public List<Identite> findAll() {
		Query query = entityManager.createQuery("from Identite");
		return query.getResultList();
	}

	@Override
	public void delete(Identite iden) {
		entityManager.createQuery("delete from Identite o where o.numedoss= :code").setParameter("code",iden.getNumedoss()).executeUpdate();	

		
	}

	@Override
	public Identite findById(Offre of) {
		long id=of.getIdentite().getNumedoss();
		
		
		Query q=entityManager.createQuery("from Identite d where d.numedoss= :id").setParameter("id",id);

		
		return (Identite) q.getSingleResult(); 
	}

	@Override
	public Identite findManagerById(Identite idn) {
		long id=idn.getDemandesmanager().get(0).getManager().getNumedoss();
        Query q=entityManager.createQuery("from Identite d where d.numedoss= :id").setParameter("id",id);
		return (Identite) q.getSingleResult(); 
	}

	

	@Override
	public Identite findById(Identite iden) {
		Query q=entityManager.createQuery("from Identite d where d.numedoss= :id").setParameter("id",iden.getNumedoss());

		return (Identite) q.getSingleResult();
	}
	
	

	
}
