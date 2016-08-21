package com.yesserp.sessionbean.crm.gestionconcurrence;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.crm.*;

/**
 * Session Bean implementation class GestionIdentite
 */
@Stateless
@LocalBean
public class GestionConcurrence implements GestionConcurrenceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
	
    public GestionConcurrence() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void ajouterConcurrent(Concurrent i) {
		em.persist(i);
	}

    @Override
	public void ajouterCordonneeConcurrent(CordonneeConcurrent i) {
		// TODO Auto-generated method stub
    	em.persist(i);
    }
    
	@Override
	public void supprimerConcurrent(Concurrent i) {
		
		//em.remove(em.merge(i));
		
		Concurrent c = em.find(Concurrent.class, i.getId());
        if (c != null) 
        {
              em.remove(c);
       
        }
	}
	@Override
	public void supprimerCordonneeConcurrent(CordonneeConcurrent i) {
	//	em.remove(em.merge(i));
		

		CordonneeConcurrent c = em.find(CordonneeConcurrent.class, i.getId());
        if (c != null) 
        {
              em.remove(c);
       
        }
	}


	@Override
	public void modifierConcurrent(Concurrent i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	
	@Override
	public void modifierCordonneeConcurrent(CordonneeConcurrent i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	
	

	@Override
	public List<Concurrent> AfficherTousConcurrent() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM Concurrent c");
        return query.getResultList();
	}
	


	

	@Override
	public List<Concurrent> trouverParNom(String nom) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select from Concurrent i where nom = :nom");
		q.setParameter("nom",nom);
		List<Concurrent> li=null;
		try {
			li= (List<Concurrent>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		return li;
	}




	@Override
	public List<Produit> getTousProduit() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select t from Produit t");
        return query.getResultList();
	}

	@Override
	public List<TypeProduitConcurrent> getTousTypeProduitConcurrent() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select t from TypeProduitConcurrent t");
        return query.getResultList();
	}
	
	@Override
	public Produit ChercherProduit(String nomprod) {
		Query query = em.createQuery("select t from Produit t where t.nomprod = :nomprod");
		query.setParameter("nomprod",nomprod);


        return (Produit) query.getSingleResult();
	}


	@Override
	public List<CordonneeConcurrent> FindCordoneeByConcurrent(Concurrent Concurrent) {
		Query q=em.createQuery("select i from CordonneeConcurrent i join i.concurrent cn where cn.id = :id");
		q.setParameter("id",Concurrent.getId());
		List<CordonneeConcurrent> li=null;
		try {
			li= (List<CordonneeConcurrent>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return li;
	}
	

	@Override
	public CordonneeConcurrent FindOneCordoneeByConcurrent(Concurrent Concurrent) {
		Query q=em.createQuery("select i from CordonneeConcurrent i join i.concurrent iden where iden.id = :id");
		q.setParameter("id",Concurrent.getId());
		List<CordonneeConcurrent> li=null;
		try {
			li= (List<CordonneeConcurrent>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		if(li.size()>0)
			return li.get(li.size()-1);
			return null;
	}
	

	@Override
	public List<ProduitConcurrent> FindProduitConcurrentByConcurrent(Concurrent Concurrent) {
		Query q=em.createQuery("select i from ProduitConcurrent i join i.concurrent cn where cn.id = :id");
		q.setParameter("id",Concurrent.getId());
		List<ProduitConcurrent> li=null;
		try {
			li= (List<ProduitConcurrent>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return li;
	}
	

	@Override
	public ProduitConcurrent FindOneProduitConcurrentByConcurrent(Concurrent Concurrent) {
		Query q=em.createQuery("select i from ProduitConcurrent i join i.concurrent iden where iden.id = :id");
		q.setParameter("id",Concurrent.getId());
		List<ProduitConcurrent> li=null;
		try {
			li= (List<ProduitConcurrent>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		if(li.size()>0)
			return li.get(li.size()-1);
			return null;
	}
	

	
		
	}
	


