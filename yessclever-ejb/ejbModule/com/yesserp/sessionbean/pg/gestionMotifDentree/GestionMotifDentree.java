package com.yesserp.sessionbean.pg.gestionMotifDentree;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.MotifDentree;


@Stateless
@LocalBean
public class GestionMotifDentree implements GestionMotifDentreeLocal{
	

	
    public GestionMotifDentree() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterMotifDentree(MotifDentree i) {
		em.persist(i);
	}


	@Override
	public void supprimerMotifDentree(MotifDentree i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierMotifDentree(MotifDentree i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<MotifDentree> AfficherTousMotifDentree() {
		
		Query query = em.createQuery("SELECT c FROM pg_MotifDentreee c");
        return query.getResultList();
	}

	/*

	@Override
	public List<MotifDentree> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from MotifDentree i where nom = :nom");
		q.setParameter("nom",nom);
		List<MotifDentree> li=null;
		try {
			li= (List<MotifDentree>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<MotifDentree> trouverParNumMotifDentree(String numMotifDentree) {
		
		Query q=em.createQuery("select from MotifDentree i where numMotifDentree = :numMotifDentree");
		q.setParameter("numMotifDentree",numMotifDentree);
		List<MotifDentree> li=null;
		try {
			li= (List<MotifDentree>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
