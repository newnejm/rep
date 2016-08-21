package com.yesserp.sessionbean.pg.gestionEmploie;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.Emploie;


@Stateless
@LocalBean
public class GestionEmploie implements GestionEmploieLocal {
	
	
	
    public GestionEmploie() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterEmploie(Emploie i) {
		em.persist(i);
	}


	@Override
	public void supprimerEmploie(Emploie i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierEmploie(Emploie i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<Emploie> AfficherTousEmploie() {
		
		Query query = em.createQuery("SELECT c FROM Emploie c");
        return query.getResultList();
	}

	/*

	@Override
	public List<Emploie> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from Emploie i where nom = :nom");
		q.setParameter("nom",nom);
		List<Emploie> li=null;
		try {
			li= (List<Emploie>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<Emploie> trouverParNumEmploie(String numEmploie) {
		
		Query q=em.createQuery("select from Emploie i where numEmploie = :numEmploie");
		q.setParameter("numEmploie",numEmploie);
		List<Emploie> li=null;
		try {
			li= (List<Emploie>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	

	

}
