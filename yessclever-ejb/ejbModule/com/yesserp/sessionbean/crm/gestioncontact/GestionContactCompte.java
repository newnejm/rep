package com.yesserp.sessionbean.crm.gestioncontact;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sun.xml.internal.bind.v2.runtime.Coordinator;
import com.yesserp.domain.crm.*;
import com.yesserp.domain.ga.Embauche;
import com.yesserp.domain.ga.Identite;



/**
 * Session Bean implementation class GestionIdentite
 */
@Stateless
@LocalBean
public class GestionContactCompte implements GestionContactCompteLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    public GestionContactCompte() {
        // TODO Auto-generated constructor stub
    }
    
    
	
    @Override
    public void ajouterContactCompte(ContactCompte i) {
		em.persist(i);
	}
    
    @Override
    public void ajouterCordonneeContactCompte(CordonneeContactCompte i) {
		em.persist(i);
	}


	@Override
	public void supprimerContactCompte(ContactCompte i) {
		// TODO Auto-generated method stub
	//	 em.remove(em.merge(i));
		
		ContactCompte c = em.find(ContactCompte.class, i.getId());
          if (c != null) 
          {
                em.remove(c);
         
          }
		

	}
	
	@Override
	public void supprimerCordonneeContactCompte(CordonneeContactCompte i) {
		
	//	 em.remove(i);
	    CordonneeContactCompte c = em.find(CordonneeContactCompte.class, i.getId());
        if (c != null) 
        {
              em.remove(c);
       
        }
		

	}


	@Override
	public void modifierContactCompte(ContactCompte i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	
	
	@Override
	public void modifierCordonneeContactCompte(CordonneeContactCompte i) {
		// TODO Auto-generated method stub
		em.merge(i);
	}
	
	
	
	@Override
	public void ajouterContactCompteCordonnee(ContactCompte Contact,
			CordonneeContactCompte CordonneeContact , Compte Compte) {

		try {
			
			
			em.persist(CordonneeContact);
			
			/*Compte.getContacts().add(Contact);

			Contact.getCordonneeContacts().add(CordonneeContact);*/
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<ContactCompte> AfficherTousContactCompte() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM ContactCompte c");
        return query.getResultList();
	}

	@Override
	public List<ContactCompte> trouverParCompte(Compte compte) {
		// TODO Auto-generated method stub
				Query q=em.createQuery("select from ContactCompte i where compte.id = :compte.id");
				q.setParameter("compte",compte);
				List<ContactCompte> li=null;
				try {
					li= (List<ContactCompte>) q.getResultList();
				} catch (Exception e) {
					// TODO: handle exception
				}		return li;		
	}

	@Override
	public List<ContactCompte> trouverParNom(String nom) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select from ContactCompte i where nom = :nom");
		q.setParameter("nom",nom);
		List<ContactCompte> li=null;
		try {
			li= (List<ContactCompte>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		return li;
	}

	@Override
	public List<ContactCompte> trouverParPrenom(String prenom) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select from ContactCompte i where prenom = :prenom");
		q.setParameter("prenom",prenom);
		List<ContactCompte> li=null;
		try {
			li= (List<ContactCompte>) q.getResultList();
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
	public Compte ChercherCompte(String nomcompt) {
		
		Query query = em.createQuery("select t from Compte t where t.nomcompt = :nomcompt");
		query.setParameter("nomcompt",nomcompt);


        return (Compte) query.getSingleResult();	
	}

	
	@Override
	public List<CordonneeContactCompte> FindCordoneeByContactCompte(ContactCompte Contact) {
		Query q=em.createQuery("select i from CordonneeContactCompte i join i.contacts cn where cn.id = :id");
		q.setParameter("id",Contact.getId());
		List<CordonneeContactCompte> li=null;
		try {
			li= (List<CordonneeContactCompte>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return li;
	}
	

	@Override
	public CordonneeContactCompte FindOneCordoneeByContactCompte(ContactCompte Contact) {
		Query q=em.createQuery("select i from CordonneeContactCompte i join i.contacts iden where iden.id = :id");
		q.setParameter("id",Contact.getId());
		List<CordonneeContactCompte> li=null;
		try {
			li= (List<CordonneeContactCompte>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		if(li.size()>0)
			return li.get(li.size()-1);
			return null;
	}
	
}
