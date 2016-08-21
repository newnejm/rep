package com.yesserp.sessionbean.pg.gestionModule;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.Module;


@Stateless
@LocalBean
public class GestionModule implements GestionModuleLocal{
	

	
    public GestionModule() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterModule(Module i) {
		em.persist(i);
	}


	@Override
	public void supprimerModule(Module i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierModule(Module i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<Module> AfficherTousModule() {
		
		Query query = em.createQuery("SELECT c FROM Module c");
        return query.getResultList();
	}

	/*

	@Override
	public List<Module> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from Module i where nom = :nom");
		q.setParameter("nom",nom);
		List<Module> li=null;
		try {
			li= (List<Module>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<Module> trouverParNumModule(String numModule) {
		
		Query q=em.createQuery("select from Module i where numModule = :numModule");
		q.setParameter("numModule",numModule);
		List<Module> li=null;
		try {
			li= (List<Module>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
