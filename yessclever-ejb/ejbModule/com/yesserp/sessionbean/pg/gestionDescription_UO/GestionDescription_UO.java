package com.yesserp.sessionbean.pg.gestionDescription_UO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.Description_UO;
import com.yesserp.domain.pg.Unite_organisationnelle;
import com.yesserp.sessionbean.pg.gestionUO.GestionUOLocal;

@Stateless
@LocalBean
public class GestionDescription_UO  implements  GestionDescription_UOLocal{
    public GestionDescription_UO() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterDescription_UO(Description_UO i) {
		em.persist(i);
	}


	@Override
	public void supprimerDescription_UO(Description_UO i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierDescription_UO(Description_UO i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<Description_UO> AfficherTousDescription_UO() {
		
		Query query = em.createQuery("SELECT c FROM Description_UO c");
        return query.getResultList();
	}

	
	/*
	@Override
	public List<Description_UO trouverParNom(String nom) {
		
		Query q=em.createQuery("select from Description_UO i where nom = :nom");
		q.setParameter("nom",nom);
		List<Description_UO> li=null;
		try {
			li= (List<Description_UO>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<Description_UO> trouverParNumDescription_UO(String numDescription_UO) {
		
		Query q=em.createQuery("select from Description_UO i where numDescription_UO = :numDescription_UO");
		q.setParameter("numDescription_UO",numDescription_UO);
		List<Description_UO> li=null;
		try {
			li= (List<Description_UO>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	*/
	
	
	
	

}
