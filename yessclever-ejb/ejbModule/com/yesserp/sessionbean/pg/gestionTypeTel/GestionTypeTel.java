package com.yesserp.sessionbean.pg.gestionTypeTel;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.TypeTel;


@Stateless
@LocalBean
public class GestionTypeTel implements GestionTypeTelLocal{
	

	
    public GestionTypeTel() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterTypeTel(TypeTel i) {
		em.persist(i);
	}


	@Override
	public void supprimerTypeTel(TypeTel i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierTypeTel(TypeTel i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<TypeTel> AfficherTousTypeTel() {
		
		Query query = em.createQuery("SELECT c FROM pg_TypeTele c");
        return query.getResultList();
	}

	/*

	@Override
	public List<TypeTel> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from TypeTel i where nom = :nom");
		q.setParameter("nom",nom);
		List<TypeTel> li=null;
		try {
			li= (List<TypeTel>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<TypeTel> trouverParNumTypeTel(String numTypeTel) {
		
		Query q=em.createQuery("select from TypeTel i where numTypeTel = :numTypeTel");
		q.setParameter("numTypeTel",numTypeTel);
		List<TypeTel> li=null;
		try {
			li= (List<TypeTel>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
