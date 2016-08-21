package com.yesserp.sessionbean.crm.gestioncompte;


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
public class GestionCompte implements GestionCompteLocal {

    /**
     * Default constructor. 
     */
	
	
    public GestionCompte() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterCompte(Compte i) {
		em.persist(i);
	}

    @Override
	public void ajouterTravailInterne(TravailInterne i)
    {		em.persist(i);

    }
    
    @Override
    public void ajouterTauxCompte(TauxCompte i) {
		em.persist(i);
	}

    @Override
    public void ajouterTypeCompte(TypeCompte i) {
		em.persist(i);
	}    
    
	@Override
	public void supprimerCompte(Compte i) {
		
		//em.remove(em.merge(i));
		
		Compte c = em.find(Compte.class, i.getId());
        if (c != null) 
        {
              em.remove(c);
       
        }
	}
	@Override
	public void supprimerCordonneeCompte(CordonneeCompte i) {
	//	em.remove(em.merge(i));
		

		CordonneeCompte c = em.find(CordonneeCompte.class, i.getId());
        if (c != null) 
        {
              em.remove(c);
       
        }
	}


	@Override
	public void modifierCompte(Compte i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	
	@Override
	public void modifierCordonneeCompte(CordonneeCompte i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	
	

	@Override
	public List<Compte> AfficherTousCompte() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM Compte c");
        return query.getResultList();
	}

	

	@Override
	public List<Compte> trouverParNom(String nom) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select from Compte i where nom = :nom");
		q.setParameter("nom",nom);
		List<Compte> li=null;
		try {
			li= (List<Compte>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		return li;
	}

	@Override
	public List<Compte> trouverParNumcompt(String numcompt) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select from Compte i where numcompt = :numcompt");
		q.setParameter("numcompt",numcompt);
		List<Compte> li=null;
		try {
			li= (List<Compte>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		return li;
	}

	

	@Override
	public List<Compte> trouverParMatFiscal(String matfiscl) {
		// TODO Auto-generated method stub
				Query q=em.createQuery("select from Compte i where matfiscl = :matfiscl");
				q.setParameter("matfiscl",matfiscl);
				List<Compte> li=null;
				try {
					li= (List<Compte>) q.getResultList();
				} catch (Exception e) {
					// TODO: handle exception
				}		return li;	}

	@Override
	public void ajouterCompteCordonnee(Compte Compte, Facture Facture) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouterCompteType(Compte Compte, TypeCompte TypeCompte) {
		// TODO Auto-generated method stub
		try {
			
			/*Compte.setCompte(TypeCompte);
			TypeCompte.getComptes().add(Compte);*/

			
			em.persist(Compte);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<TypeCompte> getType() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select t from TypeCompte t");
        return query.getResultList();
	}

	@Override
	public TypeCompte ChercherTypeCompte(String type) {
		Query query = em.createQuery("select t from TypeCompte t where t.nom = :type");
		query.setParameter("type",type);


        return (TypeCompte) query.getSingleResult();
	}


	@Override
	public TypeCompte findTypeCompteById(int id) {

      return em.find(TypeCompte.class,id);

	}

	@Override
	public CommercialInterne findById(Long i) {
		return em.find(CommercialInterne.class, i);
	}

	@Override
	public void ajouterCordonneeCompte(CordonneeCompte i) {
		em.persist(i);
	}
	
	@Override
	public CordonneeCompte FindOneCordoneeByCompte(Compte Compte) {
		Query q=em.createQuery("select i from CordonneeCompte i join i.compte iden where iden.id = :id");
		q.setParameter("id",Compte.getId());
		List<CordonneeCompte> li=null;
		try {
			li= (List<CordonneeCompte>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		if(li.size()>0)
			return li.get(li.size()-1);
			return null;
	}
	
	
	@Override
	public List<CordonneeCompte> FindCordoneeByCompte(Compte Compte) {
		Query q=em.createQuery("select i from CordonneeCompte i join i.compte c where c.id = :id");
		q.setParameter("id",Compte.getId());
		List<CordonneeCompte> li=null;
		try {
			li= (List<CordonneeCompte>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return li;
	}
	
	@Override
	public List<ContactCompte> FindContactsByCompte(Compte Compte) {
		Query q=em.createQuery("select i from ContactCompte i join i.compte c where c.id = :id");
		q.setParameter("id",Compte.getId());
		List<ContactCompte> li=null;
		try {
			li= (List<ContactCompte>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return li;
	}
	
	@Override
	public List<Opportunite> FindOpportunitesByCompte(Compte Compte) {
		Query q=em.createQuery("select i from Opportunite i join i.compte c where c.id = :id");
		q.setParameter("id",Compte.getId());
		List<Opportunite> li=null;
		try {
			li= (List<Opportunite>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return li;
	}
	
	public List<Origine> getListeTypeTravailInt() 
	{
		Query query = em.createQuery("SELECT c FROM Type_travail_interne c");
        return query.getResultList();
	}
	
	
	@Override
	public Origine ChercherTypeTravailInterne(String nom)
	{
		Query query = em.createQuery("select t from Type_travail_interne t where t.nom = :nom");
	query.setParameter("nom",nom);
    return (Origine) query.getSingleResult();	
	}
    
    
	@Override
	public Taux ChercherTaux(int type) {
		Query query = em.createQuery("select t from Taux t where t.nom = :type");
		query.setParameter("type",type);


        return (Taux) query.getSingleResult();
	}	
	
	@Override
	public TypeTaxe ChercherTypeTaxe(String type) {
		Query query = em.createQuery("select t from TypeTaxe t where t.typeTaxe = :type");
		query.setParameter("type",type);


        return (TypeTaxe) query.getSingleResult();
	}	
	
	

	
	
	@Override
	public List<Taux> AfficherTousTaux() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM Taux c");
        return query.getResultList();
	}
	
	
	@Override
	public Taux ChercherTauxFodec(int nom) {
		Query query = em.createQuery("select t from Taux t where t.nom = :nom and t.typeTaxe.nom LIKE '%Fodec%' ");
		query.setParameter("nom",nom);


        return (Taux) query.getSingleResult();
	}
	
	@Override
	public Taux ChercherTauxTVA(int nom) {
		Query query = em.createQuery("select t from Taux t where t.nom = :nom and t.typeTaxe.nom LIKE '%TVA%' ");
		query.setParameter("nom",nom);


        return (Taux) query.getSingleResult();
	}
	
	@Override
	public Taux ChercherTauxRetenu(int nom) {
		Query query = em.createQuery("select t from Taux t where t.nom = :nom and t.typeTaxe.nom LIKE '%Retenu%' ");
		query.setParameter("nom",nom);


        return (Taux) query.getSingleResult();
	}
		
	}
	


