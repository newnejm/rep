package com.yesserp.sessionbean.crm.gestiondocumentcompte;


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
public class GestionDocumentCompte implements GestionDocumentCompteLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    public GestionDocumentCompte() {
        // TODO Auto-generated constructor stub
    }
    
    
    
    
	
    @Override
    public void ajouterDocumentCompte(DocumentCompte i) {
		em.persist(i);
	}


    
    
	@Override
	public void supprimerDocumentCompte(DocumentCompte i) {
		DocumentCompte c = em.find(DocumentCompte.class, i.getId());
        if (c != null) 
        {
              em.remove(c);
       
        }
	}


	
	
	
	@Override
	public void modifierDocumentCompte(DocumentCompte i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	
	
	

	@Override
	public List<DocumentCompte> AfficherTousDocumentCompte() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM DocumentCompte c");
        return query.getResultList();
	}

	



	


	@Override
	public DocumentCompte findById(int id) {
		
		Query query = em.createQuery("select t from DocumentCompte t where t.id = :id");
		query.setParameter("id",id);


        return (DocumentCompte) query.getSingleResult();	
	}





	@Override
	public DocumentCompte trouverParNom(String nom) {
		Query query = em.createQuery("select t from DocumentCompte t where t.nom = :nom");
		query.setParameter("nom",nom);


        return (DocumentCompte) query.getSingleResult();
	}
	

}
