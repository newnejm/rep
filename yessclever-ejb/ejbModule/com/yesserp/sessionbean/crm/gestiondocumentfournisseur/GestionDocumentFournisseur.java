package com.yesserp.sessionbean.crm.gestiondocumentfournisseur;


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
public class GestionDocumentFournisseur implements GestionDocumentFournisseurLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    public GestionDocumentFournisseur() {
        // TODO Auto-generated constructor stub
    }
    
    
    
    
	
    @Override
    public void ajouterDocumentFournisseur(DocumentFournisseur i) {
		em.persist(i);
	}


    
    
	@Override
	public void supprimerDocumentFournisseur(DocumentFournisseur i) {
		DocumentFournisseur c = em.find(DocumentFournisseur.class, i.getId());
        if (c != null) 
        {
              em.remove(c);
       
        }
	}


	
	
	
	@Override
	public void modifierDocumentFournisseur(DocumentFournisseur i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	
	
	

	@Override
	public List<DocumentFournisseur> AfficherTousDocumentFournisseur() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM DocumentFournisseur c");
        return query.getResultList();
	}

	



	


	@Override
	public DocumentFournisseur findById(int id) {
		
		Query query = em.createQuery("select t from DocumentFournisseur t where t.id = :id");
		query.setParameter("id",id);


        return (DocumentFournisseur) query.getSingleResult();	
	}





	@Override
	public DocumentFournisseur trouverParNom(String nom) {
		Query query = em.createQuery("select t from DocumentFournisseur t where t.nom = :nom");
		query.setParameter("nom",nom);


        return (DocumentFournisseur) query.getSingleResult();
	}
	

}
