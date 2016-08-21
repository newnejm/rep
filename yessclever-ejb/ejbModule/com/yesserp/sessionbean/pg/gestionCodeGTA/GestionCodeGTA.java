package com.yesserp.sessionbean.pg.gestionCodeGTA;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.CodeGTA;


@Stateless
@LocalBean
public class GestionCodeGTA implements GestionCodeGTALocal{
	

	
    public GestionCodeGTA() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterCodeGTA(CodeGTA i) {
		em.persist(i);
	}


	@Override
	public void supprimerCodeGTA(CodeGTA i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierCodeGTA(CodeGTA i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<CodeGTA> AfficherTousCodeGTA() {
		
		Query query = em.createQuery("SELECT c FROM CodeGTA c");
        return query.getResultList();
	}

	/*

	@Override
	public List<CodeGTA> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from CodeGTA i where nom = :nom");
		q.setParameter("nom",nom);
		List<CodeGTA> li=null;
		try {
			li= (List<CodeGTA>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<CodeGTA> trouverParNumCodeGTA(String numCodeGTA) {
		
		Query q=em.createQuery("select from CodeGTA i where numCodeGTA = :numCodeGTA");
		q.setParameter("numCodeGTA",numCodeGTA);
		List<CodeGTA> li=null;
		try {
			li= (List<CodeGTA>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
