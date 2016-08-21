package com.yesserp.sessionbean.pg.gestionParametrageFrais;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.ParametrageFrais;


@Stateless
@LocalBean
public class GestionParametrageFrais implements GestionParametrageFraisLocal{
	

	
    public GestionParametrageFrais() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterParametrageFrais(ParametrageFrais i) {
		em.persist(i);
	}


	@Override
	public void supprimerParametrageFrais(ParametrageFrais i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierParametrageFrais(ParametrageFrais i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<ParametrageFrais> AfficherTousParametrageFrais() {
		
		Query query = em.createQuery("SELECT c FROM ParametrageFrais c");
        return query.getResultList();
	}

	/*

	@Override
	public List<ParametrageFrais> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from ParametrageFrais i where nom = :nom");
		q.setParameter("nom",nom);
		List<ParametrageFrais> li=null;
		try {
			li= (List<ParametrageFrais>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<ParametrageFrais> trouverParNumParametrageFrais(String numParametrageFrais) {
		
		Query q=em.createQuery("select from ParametrageFrais i where numParametrageFrais = :numParametrageFrais");
		q.setParameter("numParametrageFrais",numParametrageFrais);
		List<ParametrageFrais> li=null;
		try {
			li= (List<ParametrageFrais>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
