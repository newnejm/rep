package com.yesserp.sessionbean.crm.gestionproduit;


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
public class GestionProduit implements GestionProduitLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    public GestionProduit() {
        // TODO Auto-generated constructor stub
    }
    
    
	
    @Override
    public void ajouterProduit(Produit i) {
		em.persist(i);
	}
    
    @Override
    public void ajouterTypeProduit(TypeProduit i) {
		em.persist(i);
	}
    
    @Override
    public void ajouterRemise(Remise i) {
		em.persist(i);
	}
    
	@Override
	public void supprimerProduit(Produit i) {
		// TODO Auto-generated method stub

		Produit p = em.find(Produit.class, i.getId());
          if (p != null) 
          {
                em.remove(p);
         
          }	}


	@Override
	public void modifierProduit(Produit i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	
	

	@Override
	public List<Produit> AfficherTousProduit() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM Produit c");
        return query.getResultList();
	}

	
	

	
	
	@Override
	public Produit trouverParNomprod(String nomprod) {
		return em.find(Produit.class, nomprod);

	}



	@Override
	public Produit trouverParCodeprod(String codeprod) {
		return em.find(Produit.class, codeprod);

	}



	@Override
	public Produit trouverPaRref(String ref) {
		return em.find(Produit.class, ref);
	}



	@Override
	public List<Opportunite> getListeOpportunite() {
		Query query = em.createQuery("SELECT c FROM Opportunite c");
        return query.getResultList();	
	}



	@Override
	public List<Remise> getListeRemise() {
		Query query = em.createQuery("SELECT c FROM Remise c");
        return query.getResultList();		

	}
	
	@Override
	public List<TypeProduit> getListeTypeProduit() {
		Query query = em.createQuery("SELECT c FROM TypeProduit c");
        return query.getResultList();		

	}
	




	@Override
	public Opportunite ChercherOpportunite(String nomopp) {
		Query query = em.createQuery("select t from Opportunite t where t.nomopp = :nomopp");
		query.setParameter("nomopp",nomopp);
        return (Opportunite) query.getSingleResult();		

	}



	@Override
	public Remise ChercherRemise(int valremis) {
		Query query = em.createQuery("select t from Remise t where t.valremis = :valremis");
		query.setParameter("valremis",valremis);
        return (Remise) query.getSingleResult();		
	}

	
	
	@Override
	public Concurrent FindOneConcurrentByProduit(Produit Produit) {
		Query q=em.createQuery("select i from Concurrent i join i.produit iden where iden.id = :id");
		q.setParameter("id",Produit.getId());
		List<Concurrent> li=null;
		try {
			li= (List<Concurrent>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		if(li.size()>0)
			return li.get(li.size()-1);
			return null;
	}
	
	
	@Override
	public List<Concurrent> FindConcurrentByProduit(Produit Produit) {
		Query q=em.createQuery("select i from Concurrent i join i.produit c where c.id = :id");
		q.setParameter("id",Produit.getId());
		List<Concurrent> li=null;
		try {
			li= (List<Concurrent>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return li;
	}
	
	@Override
	public TypeProduit ChercherTypeProduit(String type) {
		Query query = em.createQuery("select t from TypeProduit t where t.nom = :type");
		query.setParameter("type",type);


        return (TypeProduit) query.getSingleResult();
	}
	
	
	@Override
	public List<ProduitConcurrent> FindProduitConcurrentByProduit(Produit Produit) {
		Query q=em.createQuery("select i from ProduitConcurrent i where i.typeProduitConcurrent.nom = :nom");
		q.setParameter("nom",Produit.getTypeProduit().getNom());
		List<ProduitConcurrent> li=null;
		try {
			li= (List<ProduitConcurrent>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return li;
	}
	
	@Override
	public List<Taxe> AfficherTousTaxe() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM Taxe c");
        return query.getResultList();
	}
	
	@Override
	public Taxe ChercherTaxe(int type) {
		Query query = em.createQuery("select t from Taxe t where t.nom = :type");
		query.setParameter("type",type);


        return (Taxe) query.getSingleResult();
	}	
	
	@Override
	public TypeTaxe ChercherTypeTaxe(String type) {
		Query query = em.createQuery("select t from TypeTaxe t where t.nom = :type");
		query.setParameter("type",type);


        return (TypeTaxe) query.getSingleResult();
	}	

}
