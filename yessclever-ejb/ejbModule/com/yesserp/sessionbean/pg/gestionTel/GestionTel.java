package com.yesserp.sessionbean.pg.gestionTel;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.Tel;


@Stateless
@LocalBean
public class GestionTel implements GestionTelLocal{
	

	
    public GestionTel() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterTel(Tel i) {
		em.persist(i);
	}


	@Override
	public void supprimerTel(Tel i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierTel(Tel i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<Tel> AfficherTousTel() {
		
		Query query = em.createQuery("SELECT c FROM pg_Tele c");
        return query.getResultList();
	}

	/*

	@Override
	public List<Tel> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from Tel i where nom = :nom");
		q.setParameter("nom",nom);
		List<Tel> li=null;
		try {
			li= (List<Tel>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<Tel> trouverParNumTel(String numTel) {
		
		Query q=em.createQuery("select from Tel i where numTel = :numTel");
		q.setParameter("numTel",numTel);
		List<Tel> li=null;
		try {
			li= (List<Tel>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
