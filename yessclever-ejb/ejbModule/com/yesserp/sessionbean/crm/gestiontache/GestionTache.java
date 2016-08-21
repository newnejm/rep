package com.yesserp.sessionbean.crm.gestiontache;


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
public class GestionTache implements GestionTacheLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    public GestionTache() {
        // TODO Auto-generated constructor stub
    }
    
    
	
    @Override
    public void ajouterTache(Tache i) {
		em.persist(i);
	}
    

	@Override
	public void supprimerTache(Tache i) {
		// TODO Auto-generated method stub

		Tache p = em.find(Tache.class, i.getId());
          if (p != null) 
          {
                em.remove(p);
         
          }	}


	@Override
	public void modifierTache(Tache i) {
		// TODO Auto-generated method stub
		 em.merge(i);

		
	
	}
	

	@Override
	public List<Tache> AfficherTousTache() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM Tache c");
        return query.getResultList();
	}
	
	@Override
	public Tache AfficherOneTache() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("SELECT c FROM Tache c");
		List<Tache> li=null;
		try {
			li= (List<Tache>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		if(li.size()>0)
			return li.get(li.size()-1);
			return null;
	}

	@Override
	public Tache FindTacheByName(String title) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM Tache c where c.title = :title");
		query.setParameter("title",title);
		List<Tache> li=null;
		try {
			li= (List<Tache>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		
		if(li.size()>0)
			return li.get(li.size()-1);
			return null;	}
	
	
	
	
}
