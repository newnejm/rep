package com.yesserp.sessionbean.pg.gestionParametrageCompatibilite;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.ParametrageComptabilite;


@Stateless
@LocalBean
public class GestionParametrageCompatibilite implements GestionParametrageCompatibiliteLocal{
	

	
    public GestionParametrageCompatibilite() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterParametrageCompatibilite(ParametrageComptabilite i) {
		em.persist(i);
	}


	@Override
	public void supprimerParametrageCompatibilite(ParametrageComptabilite i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierParametrageCompatibilite(ParametrageComptabilite i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<ParametrageComptabilite> AfficherTousParametrageCompatibilite() {
		
		Query query = em.createQuery("SELECT c FROM ParametrageComptabilite c");
        return query.getResultList();
	}

	/*

	@Override
	public List<ParametrageComptabilite> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from ParametrageComptabilite i where nom = :nom");
		q.setParameter("nom",nom);
		List<ParametrageComptabilite> li=null;
		try {
			li= (List<ParametrageComptabilite>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<ParametrageComptabilite> trouverParNumParametrageCompatibilite(String numParametrageCompatibilite) {
		
		Query q=em.createQuery("select from ParametrageComptabilite i where numParametrageCompatibilite = :numParametrageCompatibilite");
		q.setParameter("numParametrageCompatibilite",numParametrageCompatibilite);
		List<ParametrageComptabilite> li=null;
		try {
			li= (List<ParametrageComptabilite>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
