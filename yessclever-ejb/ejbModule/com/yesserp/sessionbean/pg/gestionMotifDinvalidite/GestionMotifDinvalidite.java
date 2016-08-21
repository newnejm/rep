package com.yesserp.sessionbean.pg.gestionMotifDinvalidite;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.MotifDinvalidite;


@Stateless
@LocalBean
public class GestionMotifDinvalidite implements GestionMotifDinvaliditeLocal{
	

	
    public GestionMotifDinvalidite() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterMotifDinvalidite(MotifDinvalidite i) {
		em.persist(i);
	}


	@Override
	public void supprimerMotifDinvalidite(MotifDinvalidite i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierMotifDinvalidite(MotifDinvalidite i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<MotifDinvalidite> AfficherTousMotifDinvalidite() {
		
		Query query = em.createQuery("SELECT c FROM pg_MotifDinvaliditee c");
        return query.getResultList();
	}

	/*

	@Override
	public List<MotifDinvalidite> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from MotifDinvalidite i where nom = :nom");
		q.setParameter("nom",nom);
		List<MotifDinvalidite> li=null;
		try {
			li= (List<MotifDinvalidite>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<MotifDinvalidite> trouverParNumMotifDinvalidite(String numMotifDinvalidite) {
		
		Query q=em.createQuery("select from MotifDinvalidite i where numMotifDinvalidite = :numMotifDinvalidite");
		q.setParameter("numMotifDinvalidite",numMotifDinvalidite);
		List<MotifDinvalidite> li=null;
		try {
			li= (List<MotifDinvalidite>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
