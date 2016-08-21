package com.yesserp.sessionbean.crm.gestioncompagne;


import java.util.ArrayList;
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
public class GestionCompagne implements GestionCompagneLocal {

    /**
     * Default constructor. 
     */
	
	
    public GestionCompagne() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterCompagne(Compagne i) {
		em.persist(i);
	}

    @Override
	public void ajouterTravailInterne(TravailInterne i)
    {		em.persist(i);

    }

    @Override
    public void ajouterTypeCompagne(TypeCompagne i) {
		em.persist(i);
	}   
    

    
    @Override
    public void ajouterStatusCompagne(StatusCompagne status) {
		em.persist(status);
	}
    
	@Override
	public void supprimerCompagne(Compagne i) {
		
		//em.remove(em.merge(i));
		
		Compagne c = em.find(Compagne.class, i.getId());
        if (c != null) 
        {
              em.remove(c);
       
        }
	}
	


	@Override
	public void modifierCompagne(Compagne i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}


	@Override
	public List<Compagne> AfficherTousCompagne() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM Compagne c");
		
        return query.getResultList();
	}

	

	@Override
	public List<Compagne> trouverParNom(String nom) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select from Compagne i where nom = :nom");
		q.setParameter("nom",nom);
		List<Compagne> li=null;
		try {
			li= (List<Compagne>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		return li;
	}
	   @Override
		public  Compagne afficherCompagneParNom(String nom)
		{
			Query query = em.createQuery("select C from Compagne C where C.nom = :nom");
			query.setParameter("nom",nom);
	       return (Compagne) query.getSingleResult();	
		}



	@Override
	public List<TypeCompagne> getType() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select t from TypeCompagne t");
        return query.getResultList();
	}

	@Override
	public TypeCompagne ChercherTypeCompagne(String type) {
		Query query = em.createQuery("select t from TypeCompagne t where t.nom = :type");
		query.setParameter("type",type);


        return (TypeCompagne) query.getSingleResult();
	}
	
	@Override
	public StatusCompagne ChercherStatusCompagne(String status) {
		Query query = em.createQuery("select t from StatusCompagne t where t.libelle = :status");
		query.setParameter("status",status);
        return (StatusCompagne) query.getSingleResult();
	}


	@Override
	public TypeCompagne findTypeCompagneById(int id) {

      return em.find(TypeCompagne.class,id);

	}

	@Override
	public CommercialInterne findById(Long i) {
		return em.find(CommercialInterne.class, i);
	}


	
	@Override
	public Opportunite FindOneOpportuniteByCompagne(Compagne Compagne) {
		Query q=em.createQuery("select i from Opportunite i join i.compagne iden where iden.id = :id");
		q.setParameter("id",Compagne.getId());
		List<Opportunite> li=null;
		try {
			li= (List<Opportunite>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		if(li.size()>0)
			return li.get(li.size()-1);
			return null;
	}
	
	
	@Override
	public   List<Opportunite> FindOpportuniteByCompagne(Compagne Compagne) {
		Query q=em.createQuery("select i from Opportunite i join i.compagne c where c.id = :id");
		q.setParameter("id",Compagne.getId());
		List<Opportunite> li=null;
		try {
			li= (List<Opportunite>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return li;
	}
	
	@Override
	public   List<Action> FindActionByCompagne(Compagne Compagne) {
		System.out.println("\n!!!!!!!!!!!!!!!!!!!\n"+Compagne.getId()+"\n!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		Query q=em.createQuery("select a from Action a join a.compagne c where c.id = :id");
		
		q.setParameter("id",Compagne.getId());
		List<Action> li=null;
		try {
			li= (List<Action>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return li;
	}
	
	@Override
	public List<StatusCompagne> getStatus() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select t from StatusCompagne t");
        return query.getResultList();
	}

	}
	


