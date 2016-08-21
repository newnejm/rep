package com.yesserp.sessionbean.crm.gestionopportunite;


import java.util.Date;
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
public class GestionOpportunite implements GestionOpportuniteLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    public GestionOpportunite() {
        // TODO Auto-generated constructor stub
    }
	
    @Override
    public void ajouterOpportunite(Opportunite i) {
		em.persist(i);
	}


	@Override
	public void supprimerOpportunite(Opportunite i) {
		// TODO Auto-generated method stub		
		Opportunite c = em.find(Opportunite.class, i.getId());
        if (c != null) 
        {
              em.remove(c);
       
        }
		
	}


	@Override
	public void modifierOpportunite(Opportunite i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	
	

	@Override
	public List<Opportunite> AfficherTousOpportunite() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM Opportunite c");
        return query.getResultList();
	}

	@Override
	public List<Opportunite> trouverParCompte(Compte compte) {
		// TODO Auto-generated method stub
				Query q=em.createQuery("select from Opportunite i where compte.id = :compte.id");
				q.setParameter("compte",compte);
				List<Opportunite> li=null;
				try {
					li= (List<Opportunite>) q.getResultList();
				} catch (Exception e) {
					// TODO: handle exception
				}		return li;		
	}

	@Override
	public List<Opportunite> trouverParNom(String nomopp) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select from Opportunite i where nomopp = :nomopp");
		q.setParameter("nomopp",nomopp);
		List<Opportunite> li=null;
		try {
			li= (List<Opportunite>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		return li;
	}

	@Override
	public List<Opportunite> trouverParType(String type) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select from Opportunite i where type = :type");
		q.setParameter("type",type);
		List<Opportunite> li=null;
		try {
			li= (List<Opportunite>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		return li;
	}
	
	@Override
	public List<Opportunite> trouverParDate(Date date) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select from Opportunite i where date = :date");
		q.setParameter("date",date);
		List<Opportunite> li=null;
		try {
			li= (List<Opportunite>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		return li;
	}

	@Override
	public List<Compte> getListeComptes() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM Compte c");
        return query.getResultList();	}

	@Override
	public List<Compagne> getListeCompagnes() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM Compagne c");
        return query.getResultList();	}
	
	@Override
	public Compagne ChercherCompagne(String nom) {
		Query query = em.createQuery("select t from Compagne t where t.nom = :nom");
		query.setParameter("nom",nom);


        return (Compagne) query.getSingleResult();
	}
	

}
