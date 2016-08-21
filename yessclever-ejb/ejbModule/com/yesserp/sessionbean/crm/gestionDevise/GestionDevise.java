package com.yesserp.sessionbean.crm.gestionDevise;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.crm.*;


/**
 * Session Bean implementation class GestionAction
 */
@Stateless
@LocalBean
public class GestionDevise {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext(unitName="yessclever")
	private EntityManager em;
    public GestionDevise() {
        // TODO Auto-generated constructor stub
    }
	public void ajouterDevise (Devise devise)
	{
		em.persist(devise);
	}
	public void supprimerDevise(Devise devise)
	{
		
		Devise deviseASupprimer = em.find(Devise.class, devise.getId());
        if (deviseASupprimer != null) 
        {
              em.remove(deviseASupprimer);
       
        } 
	}
	public void modifierDevise(Devise devise)
	{
		Devise deviseAModifier = em.find(Devise.class, devise.getId());
        if (deviseAModifier != null) 
        	
        {
		em.merge(deviseAModifier);
		}
	}
	public List<Devise> AfficherTousDevise()
	{
		Query query = em.createQuery("SELECT D FROM Devise D");
        return query.getResultList();
	}
	public Devise afficherDeviseParId(Long id)
	{
		Devise deviseChercher= new Devise();
		deviseChercher.setId(id);
       return em.find(Devise.class, deviseChercher.getId());
	}

	public Devise afficherDeviseParNom(String nom)
	{
		Query query = em.createQuery("select D from Devise D where D.description = :nom");
		query.setParameter("nom",nom);
       return (Devise) query.getSingleResult();	
	}
}
