package com.yesserp.sessionbean.crm.gestionfournisseur;


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
public class GestionFournisseur implements GestionFournisseurLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    public GestionFournisseur() {
        // TODO Auto-generated constructor stub
    }
    
    
    
    
	
    @Override
    public void ajouterFournisseur(Fournisseur i) {
		em.persist(i);
	}


    @Override
	public void ajouterCordonne(CordonneeFournisseur i) {

		em.persist(i);
}
    
    
	@Override
	public void supprimerFournisseur(Fournisseur i) {
		Fournisseur c = em.find(Fournisseur.class, i.getId());
        if (c != null) 
        {
              em.remove(c);
       
        }
	}


	@Override
	public void supprimerCordonneeFournisseur(CordonneeFournisseur i) {
		CordonneeFournisseur c = em.find(CordonneeFournisseur.class, i.getId());
        if (c != null) 
        {
              em.remove(c);
       
        }

	}
	
	
	@Override
	public void modifierFournisseur(Fournisseur i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	
	@Override
	public void modifierCordonneeFournisseur(CordonneeFournisseur i) {
		// TODO Auto-generated method stub
		em.merge(i);
	}
	

	@Override
	public List<Fournisseur> AfficherTousFournisseur() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM Fournisseur c");
        return query.getResultList();
	}

	

	@Override
	public List<Fournisseur> trouverParNom(String nom) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select from Fournisseur i where nom = :nom");
		q.setParameter("nom",nom);
		List<Fournisseur> li=null;
		try {
			li= (List<Fournisseur>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		return li;
	}

	@Override
	public List<Fournisseur> trouverParPrenom(String prenom) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select from Fournisseur i where prenom = :prenom");
		q.setParameter("prenom",prenom);
		List<Fournisseur> li=null;
		try {
			li= (List<Fournisseur>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		return li;
	}

	@Override
	public List<Fournisseur> trouverParMatfiscal(String matfiscal) {
		// TODO Auto-generated method stub
				Query q=em.createQuery("select from Fournisseur i where matfiscal = :matfiscal");
				q.setParameter("matfiscal",matfiscal);
				List<Fournisseur> li=null;
				try {
					li= (List<Fournisseur>) q.getResultList();
				} catch (Exception e) {
					// TODO: handle exception
				}		return li;
	}

	@Override
	public List<CordonneeFournisseur> FindCordoneeByFournisseur(Fournisseur Fournisseur) {
		Query q=em.createQuery("select i from CordonneeFournisseur i join i.fournisseurs cn where cn.id = :id");
		q.setParameter("id",Fournisseur.getId());
		List<CordonneeFournisseur> li=null;
		try {
			li= (List<CordonneeFournisseur>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return li;
	}
	

	@Override
	public CordonneeFournisseur FindOneCordoneeByFournisseur(Fournisseur Fournisseur) {
		Query q=em.createQuery("select i from CordonneeFournisseur i join i.fournisseurs iden where iden.id = :id");
		q.setParameter("id",Fournisseur.getId());
		List<CordonneeFournisseur> li=null;
		try {
			li= (List<CordonneeFournisseur>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		if(li.size()>0)
			return li.get(li.size()-1);
			return null;
	}
	

	@Override
	public Fournisseur chercherFournisseur(String nom) {
		
		Query query = em.createQuery("select t from Fournisseur t where t.nom = :nom");
		query.setParameter("nom",nom);


        return (Fournisseur) query.getSingleResult();	
	}
	
	@Override
	public List<ContactFournisseur> FindContactsByFournisseur(Fournisseur Fournisseur) {
		Query q=em.createQuery("select i from ContactFournisseur i join i.fournisseur c where c.id = :id");
		q.setParameter("id",Fournisseur.getId());
		List<ContactFournisseur> li=null;
		try {
			li= (List<ContactFournisseur>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return li;
	}

}
