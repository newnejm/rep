package com.yesserp.sessionbean.crm.gestioncontact;


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
public class GestionContactFournisseur implements GestionContactFournisseurLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    public GestionContactFournisseur() {
        // TODO Auto-generated constructor stub
    }
    
    
	
    @Override
    public void ajouterContactFournisseur(ContactFournisseur i) {
		em.persist(i);
	}
    
    @Override
    public void ajouterCordonneeContactFournisseur(CordonneeContactFournisseur i) {
		em.persist(i);
	}


	@Override
	public void supprimerContactFournisseur(ContactFournisseur i) {
		// TODO Auto-generated method stub
	//	 em.remove(em.merge(i));
		
		ContactFournisseur c = em.find(ContactFournisseur.class, i.getId());
          if (c != null) 
          {
                em.remove(c);
         
          }
		

	}
	
	@Override
	public void supprimerCordonneeContactFournisseur(CordonneeContactFournisseur i) {
		
	//	 em.remove(i);
	    CordonneeContactFournisseur c = em.find(CordonneeContactFournisseur.class, i.getId());
        if (c != null) 
        {
              em.remove(c);
       
        }
		

	}


	@Override
	public void modifierContactFournisseur(ContactFournisseur i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	
	
	@Override
	public void modifierCordonneeContactFournisseur(CordonneeContactFournisseur i) {
		// TODO Auto-generated method stub
		em.merge(i);
	}
	
	
	
	@Override
	public void ajouterContactFournisseurCordonnee(ContactFournisseur Contact,
			CordonneeContactFournisseur CordonneeContact , Fournisseur Fournisseur) {

		try {
			
			
			em.persist(CordonneeContact);
			
			/*Fournisseur.getContacts().add(Contact);

			Contact.getCordonneeContacts().add(CordonneeContact);*/
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<ContactFournisseur> AfficherTousContactFournisseur() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM ContactFournisseur c");
        return query.getResultList();
	}

	@Override
	public List<ContactFournisseur> trouverParFournisseur(Fournisseur Fournisseur) {
		// TODO Auto-generated method stub
				Query q=em.createQuery("select from ContactFournisseur i where Fournisseur.id = :Fournisseur.id");
				q.setParameter("Fournisseur",Fournisseur);
				List<ContactFournisseur> li=null;
				try {
					li= (List<ContactFournisseur>) q.getResultList();
				} catch (Exception e) {
					// TODO: handle exception
				}		return li;		
	}

	@Override
	public List<ContactFournisseur> trouverParNom(String nom) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select from ContactFournisseur i where nom = :nom");
		q.setParameter("nom",nom);
		List<ContactFournisseur> li=null;
		try {
			li= (List<ContactFournisseur>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		return li;
	}


	@Override
	public List<Fournisseur> getListeFournisseurs() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM Fournisseur c");
        return query.getResultList();	}

	@Override
	public Fournisseur ChercherFournisseur(String nom) {
		
		Query query = em.createQuery("select t from Fournisseur t where t.nom = :nom");
		query.setParameter("nomcompt",nom);


        return (Fournisseur) query.getSingleResult();	
	}

	
	@Override
	public List<CordonneeContactFournisseur> FindCordoneeByContactFournisseur(ContactFournisseur Contact) {
		Query q=em.createQuery("select i from CordonneeContactFournisseur i join i.contacts cn where cn.id = :id");
		q.setParameter("id",Contact.getId());
		List<CordonneeContactFournisseur> li=null;
		try {
			li= (List<CordonneeContactFournisseur>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return li;
	}
	

	@Override
	public CordonneeContactFournisseur FindOneCordoneeByContactFournisseur(ContactFournisseur Contact) {
		Query q=em.createQuery("select i from CordonneeContactFournisseur i join i.contacts iden where iden.id = :id");
		q.setParameter("id",Contact.getId());
		List<CordonneeContactFournisseur> li=null;
		try {
			li= (List<CordonneeContactFournisseur>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		if(li.size()>0)
			return li.get(li.size()-1);
			return null;
	}
	
}
