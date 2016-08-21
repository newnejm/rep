package com.yesserp.sessionbean.pg.gestionTempsDeService;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.TempsDeService;


@Stateless
@LocalBean
public class GestionTempsDeService implements GestionTempsDeServiceLocal{
	

	
    public GestionTempsDeService() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterTempsDeService(TempsDeService i) {
		em.persist(i);
	}


	@Override
	public void supprimerTempsDeService(TempsDeService i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierTempsDeService(TempsDeService i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<TempsDeService> AfficherTousTempsDeService() {
		
		Query query = em.createQuery("SELECT c FROM pg_TempsDeServicee c");
        return query.getResultList();
	}

	/*

	@Override
	public List<TempsDeService> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from TempsDeService i where nom = :nom");
		q.setParameter("nom",nom);
		List<TempsDeService> li=null;
		try {
			li= (List<TempsDeService>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<TempsDeService> trouverParNumTempsDeService(String numTempsDeService) {
		
		Query q=em.createQuery("select from TempsDeService i where numTempsDeService = :numTempsDeService");
		q.setParameter("numTempsDeService",numTempsDeService);
		List<TempsDeService> li=null;
		try {
			li= (List<TempsDeService>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
