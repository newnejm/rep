package com.yesserp.sessionbean.pg.gestionParametres_system;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.Parametres_system;
import com.yesserp.sessionbean.pg.gestionUO.GestionUOLocal;



@Stateless
@LocalBean
public class GestionParametres_system implements  GestionParametres_systemLocal
{
	public GestionParametres_system() {
	      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
    @Override
    public void ajouterParametres_system(Parametres_system i) {
		em.persist(i);
	}


	@Override
	public void supprimerParametres_system(Parametres_system i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierParametres_system(Parametres_system i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<Parametres_system> AfficherTousParametres_system() {
		Query query = em.createQuery("SELECT c FROM Parametres_system c");
        return query.getResultList();
	}

	
	/*
	@Override
	public List<Parametres_system> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from Parametres_system i where nom = :nom");
		q.setParameter("nom",nom);
		List<Parametres_system> li=null;
		try {
			li= (List<Parametres_system>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<Parametres_system> trouverParNumParametres_system(String numParametres_system) {
		
		Query q=em.createQuery("select from Parametres_system i where numParametres_system = :numParametres_system");
		q.setParameter("numParametres_system",numParametres_system);
		List<Parametres_system> li=null;
		try {
			li= (List<Parametres_system>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	*/
	
	
	
	
	
	
	
	
	

}
