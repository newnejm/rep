package com.yesserp.sessionbean.pg.gestionParametrageGTA;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.ParametrageGTA;


@Stateless
@LocalBean
public class GestionParametrageGTA implements GestionParametrageGTALocal{
	

	
    public GestionParametrageGTA() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterParametrageGTA(ParametrageGTA i) {
		em.persist(i);
	}


	@Override
	public void supprimerParametrageGTA(ParametrageGTA i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierParametrageGTA(ParametrageGTA i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<ParametrageGTA> AfficherTousParametrageGTA() {
		
		Query query = em.createQuery("SELECT c FROM ParametrageGTA c");
        return query.getResultList();
	}

	/*

	@Override
	public List<ParametrageGTA> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from ParametrageGTA i where nom = :nom");
		q.setParameter("nom",nom);
		List<ParametrageGTA> li=null;
		try {
			li= (List<ParametrageGTA>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<ParametrageGTA> trouverParNumParametrageGTA(String numParametrageGTA) {
		
		Query q=em.createQuery("select from ParametrageGTA i where numParametrageGTA = :numParametrageGTA");
		q.setParameter("numParametrageGTA",numParametrageGTA);
		List<ParametrageGTA> li=null;
		try {
			li= (List<ParametrageGTA>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
