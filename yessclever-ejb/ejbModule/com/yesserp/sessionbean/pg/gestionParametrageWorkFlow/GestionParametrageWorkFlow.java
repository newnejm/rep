package com.yesserp.sessionbean.pg.gestionParametrageWorkFlow;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.ParametrageWorkFlow;


@Stateless
@LocalBean
public class GestionParametrageWorkFlow implements GestionParametrageWorkFlowLocal{
	

	
    public GestionParametrageWorkFlow() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterParametrageWorkFlow(ParametrageWorkFlow i) {
		em.persist(i);
	}


	@Override
	public void supprimerParametrageWorkFlow(ParametrageWorkFlow i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierParametrageWorkFlow(ParametrageWorkFlow i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<ParametrageWorkFlow> AfficherTousParametrageWorkFlow() {
		
		Query query = em.createQuery("SELECT c FROM ParametrageWorkFlow c");
        return query.getResultList();
	}

	/*

	@Override
	public List<ParametrageWorkFlow> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from ParametrageWorkFlow i where nom = :nom");
		q.setParameter("nom",nom);
		List<ParametrageWorkFlow> li=null;
		try {
			li= (List<ParametrageWorkFlow>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<ParametrageWorkFlow> trouverParNumParametrageWorkFlow(String numParametrageWorkFlow) {
		
		Query q=em.createQuery("select from ParametrageWorkFlow i where numParametrageWorkFlow = :numParametrageWorkFlow");
		q.setParameter("numParametrageWorkFlow",numParametrageWorkFlow);
		List<ParametrageWorkFlow> li=null;
		try {
			li= (List<ParametrageWorkFlow>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
