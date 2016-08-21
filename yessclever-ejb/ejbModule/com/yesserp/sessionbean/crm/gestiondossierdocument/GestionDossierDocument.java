package com.yesserp.sessionbean.crm.gestiondossierdocument;


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
public class GestionDossierDocument implements GestionDossierDocumentLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    public GestionDossierDocument() {
        // TODO Auto-generated constructor stub
    }
    
    
    
    
	
    @Override
    public void ajouterDossierDocument(DossierDocument i) {
		em.persist(i);
	}
    
    
	@Override
	public void supprimerDossierDocument(DossierDocument i) {
		DossierDocument c = em.find(DossierDocument.class, i.getId());
        if (c != null) 
        {
              em.remove(c);
       
        }
	}


	
	
	@Override
	public void modifierDossierDocument(DossierDocument i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	
	
	

	@Override
	public List<DossierDocument> AfficherTousDossierDocument() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM DossierDocument c");
        return query.getResultList();
	}

	

	@Override
	public List<DossierDocument> trouverParNom(String nom) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select from DossierDocument i where nom = :nom");
		q.setParameter("nom",nom);
		List<DossierDocument> li=null;
		try {
			li= (List<DossierDocument>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		return li;
	}



	@Override
	public DossierDocument chercherDossierDocument(String nom) {
		
		Query query = em.createQuery("select t from DossierDocument t where t.nom = :nom");
		query.setParameter("nom",nom);


        return (DossierDocument) query.getSingleResult();	
	}
	

}
