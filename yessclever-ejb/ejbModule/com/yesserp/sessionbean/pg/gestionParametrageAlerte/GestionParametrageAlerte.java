package com.yesserp.sessionbean.pg.gestionParametrageAlerte;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import com.yesserp.domain.pg.ParametrageAlerte;


@Stateless
@LocalBean
public class GestionParametrageAlerte implements GestionParametrageAlerteLocal{
	

	
    public GestionParametrageAlerte() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterParametrageAlerte(ParametrageAlerte i) {
		em.persist(i);
	}


	@Override
	public void supprimerParametrageAlerte(ParametrageAlerte i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierParametrageAlerte(ParametrageAlerte i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<ParametrageAlerte> AfficherTousParametrageAlerte() {
		
		Query query = em.createQuery("SELECT c FROM pg_parametragealerte c");
        return query.getResultList();
	}

	
	
	@Override
	public ParametrageAlerte findParametrageAlerteByCode(String code) {

		Query query = em
				.createQuery("SELECT apre FROM pg_parametragealerte apre WHERE code=:x");
		query.setParameter("x", code);
		return (ParametrageAlerte) query.getSingleResult();
	}
	
	
	
	
	/*

	@Override
	public List<ParametrageAlerte> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from ParametrageAlerte i where nom = :nom");
		q.setParameter("nom",nom);
		List<ParametrageAlerte> li=null;
		try {
			li= (List<ParametrageAlerte>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<ParametrageAlerte> trouverParNumParametrageAlerte(String numParametrageAlerte) {
		
		Query q=em.createQuery("select from ParametrageAlerte i where numParametrageAlerte = :numParametrageAlerte");
		q.setParameter("numParametrageAlerte",numParametrageAlerte);
		List<ParametrageAlerte> li=null;
		try {
			li= (List<ParametrageAlerte>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
