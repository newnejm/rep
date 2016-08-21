package com.yesserp.sessionbean.pg.gestionParametrageModuleGlobale;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.ParametrageModuleGlobale;


@Stateless
@LocalBean
public class GestionParametrageModuleGlobale implements GestionParametrageModuleGlobaleLocal{
	

	
    public GestionParametrageModuleGlobale() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterParametrageModuleGlobale(ParametrageModuleGlobale i) {
		em.persist(i);
	}


	@Override
	public void supprimerParametrageModuleGlobale(ParametrageModuleGlobale i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierParametrageModuleGlobale(ParametrageModuleGlobale i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<ParametrageModuleGlobale> AfficherTousParametrageModuleGlobale() {
		
		Query query = em.createQuery("SELECT c FROM ParametrageModuleGlobale c");
        return query.getResultList();
	}

	/*

	@Override
	public List<ParametrageModuleGlobale> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from ParametrageModuleGlobale i where nom = :nom");
		q.setParameter("nom",nom);
		List<ParametrageModuleGlobale> li=null;
		try {
			li= (List<ParametrageModuleGlobale>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<ParametrageModuleGlobale> trouverParNumParametrageModuleGlobale(String numParametrageModuleGlobale) {
		
		Query q=em.createQuery("select from ParametrageModuleGlobale i where numParametrageModuleGlobale = :numParametrageModuleGlobale");
		q.setParameter("numParametrageModuleGlobale",numParametrageModuleGlobale);
		List<ParametrageModuleGlobale> li=null;
		try {
			li= (List<ParametrageModuleGlobale>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
