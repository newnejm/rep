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
public class GestionProduitConcurrent implements GestionProduitConcurrentLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
	
    public GestionProduitConcurrent() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void ajouterProduitConcurrent(ProduitConcurrent i) {
		em.persist(i);
	}

    @Override
    public void ajouterTypeProduitConcurrent(TypeProduitConcurrent i) {
		em.persist(i);
	}
    
	@Override
	public void supprimerProduitConcurrent(ProduitConcurrent i) {
		
		//em.remove(em.merge(i));
		
		ProduitConcurrent c = em.find(ProduitConcurrent.class, i.getId());
        if (c != null) 
        {
              em.remove(c);
       
        }
	}
	


	@Override
	public void modifierProduitConcurrent(ProduitConcurrent i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	
@Override
	public List<ProduitConcurrent> AfficherTousProduitConcurrent() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM ProduitConcurrent c");
        return query.getResultList();
	}

	

	

	@Override
	public List<Concurrent> getTousConcurrent() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select t from Concurrent t");
        return query.getResultList();
	}

	@Override
	public Concurrent ChercherConcurrent(String nom) {
		Query query = em.createQuery("select t from Concurrent t where t.nom = :nom");
		query.setParameter("nom",nom);


        return (Concurrent) query.getSingleResult();
	}


	
	@Override
	public TypeProduitConcurrent ChercherTypeProduitConcurrent(String type) {
		Query query = em.createQuery("select t from TypeProduitConcurrent t where t.nom = :type");
		query.setParameter("type",type);


        return (TypeProduitConcurrent) query.getSingleResult();
	}
	
		
	}
	


