package com.yesserp.sessionbean.pg.gestionParametrageStock;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.ParametrageStock;


@Stateless
@LocalBean
public class GestionParametrageStock implements GestionParametrageStockLocal{
	

	
    public GestionParametrageStock() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterParametrageStock(ParametrageStock i) {
		em.persist(i);
	}


	@Override
	public void supprimerParametrageStock(ParametrageStock i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierParametrageStock(ParametrageStock i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<ParametrageStock> AfficherTousParametrageStock() {
		
		Query query = em.createQuery("SELECT c FROM ParametrageStock c");
        return query.getResultList();
	}

	/*

	@Override
	public List<ParametrageStock> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from ParametrageStock i where nom = :nom");
		q.setParameter("nom",nom);
		List<ParametrageStock> li=null;
		try {
			li= (List<ParametrageStock>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<ParametrageStock> trouverParNumParametrageStock(String numParametrageStock) {
		
		Query q=em.createQuery("select from ParametrageStock i where numParametrageStock = :numParametrageStock");
		q.setParameter("numParametrageStock",numParametrageStock);
		List<ParametrageStock> li=null;
		try {
			li= (List<ParametrageStock>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
