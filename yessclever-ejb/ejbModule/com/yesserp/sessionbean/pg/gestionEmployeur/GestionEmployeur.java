package com.yesserp.sessionbean.pg.gestionEmployeur;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.Employeur;


@Stateless
@LocalBean
public class GestionEmployeur implements GestionEmployeurLocal{
	

	
    public GestionEmployeur() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterEmployeur(Employeur i) {
		em.persist(i);
	}


	@Override
	public void supprimerEmployeur(Employeur i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierEmployeur(Employeur i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<Employeur> AfficherTousEmployeur() {
		
		Query query = em.createQuery("SELECT c FROM Employeur c");
        return query.getResultList();
	}

	/*

	@Override
	public List<Employeur> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from Employeur i where nom = :nom");
		q.setParameter("nom",nom);
		List<Employeur> li=null;
		try {
			li= (List<Employeur>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<Employeur> trouverParNumEmployeur(String numEmployeur) {
		
		Query q=em.createQuery("select from Employeur i where numEmployeur = :numEmployeur");
		q.setParameter("numEmployeur",numEmployeur);
		List<Employeur> li=null;
		try {
			li= (List<Employeur>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
