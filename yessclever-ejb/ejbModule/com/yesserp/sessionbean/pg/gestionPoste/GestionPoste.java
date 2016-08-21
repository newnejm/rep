package com.yesserp.sessionbean.pg.gestionPoste;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import com.yesserp.domain.pg.Poste;






@Stateless
@LocalBean
public class GestionPoste implements GestionPosteLocal {
	
	
    public GestionPoste() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterPoste(Poste i) {
		em.persist(i);
	}


	@Override
	public void supprimerPoste(Poste i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierPoste(Poste i) {
		
		em.merge(i);
		
	}
	
	
	
	@Override
	public List<Poste> AfficherTousPoste() {
		
		Query query = em.createQuery("SELECT c FROM Poste c");
        return query.getResultList();
	}
/*
	

	@Override
	public List<Poste> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from Poste i where nom = :nom");
		q.setParameter("nom",nom);
		List<Poste> li=null;
		try {
			li= (List<Poste>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		return li;
	}

	@Override
	public List<Poste> trouverParNumPoste(String numPoste) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select from Poste i where numPoste = :numPoste");
		q.setParameter("numPoste",numPoste);
		List<Poste> li=null;
		try {
			li= (List<Poste>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}		return li;
	}

	

	*/

	

	
	
		

}
