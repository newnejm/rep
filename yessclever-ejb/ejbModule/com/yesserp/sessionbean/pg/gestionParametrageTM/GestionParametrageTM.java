package com.yesserp.sessionbean.pg.gestionParametrageTM;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.ParametrageTM;


@Stateless
@LocalBean
public class GestionParametrageTM implements GestionParametrageTMLocal{
	

	
    public GestionParametrageTM() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterParametrageTM(ParametrageTM i) {
		em.persist(i);
	}


	@Override
	public void supprimerParametrageTM(ParametrageTM i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierParametrageTM(ParametrageTM i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<ParametrageTM> AfficherTousParametrageTM() {
		
		Query query = em.createQuery("SELECT c FROM ParametrageTM c");
        return query.getResultList();
	}

	/*

	@Override
	public List<ParametrageTM> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from ParametrageTM i where nom = :nom");
		q.setParameter("nom",nom);
		List<ParametrageTM> li=null;
		try {
			li= (List<ParametrageTM>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<ParametrageTM> trouverParNumParametrageTM(String numParametrageTM) {
		
		Query q=em.createQuery("select from ParametrageTM i where numParametrageTM = :numParametrageTM");
		q.setParameter("numParametrageTM",numParametrageTM);
		List<ParametrageTM> li=null;
		try {
			li= (List<ParametrageTM>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
