package com.yesserp.sessionbean.pg.gestionQualite;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.Qualite;


@Stateless
@LocalBean
public class GestionQualite implements GestionQualiteLocal{
	

	
    public GestionQualite() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterQualite(Qualite i) {
		em.persist(i);
	}


	@Override
	public void supprimerQualite(Qualite i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierQualite(Qualite i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<Qualite> AfficherTousQualite() {
		
		Query query = em.createQuery("SELECT c FROM pg_Qualitee c");
        return query.getResultList();
	}

	/*

	@Override
	public List<Qualite> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from Qualite i where nom = :nom");
		q.setParameter("nom",nom);
		List<Qualite> li=null;
		try {
			li= (List<Qualite>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<Qualite> trouverParNumQualite(String numQualite) {
		
		Query q=em.createQuery("select from Qualite i where numQualite = :numQualite");
		q.setParameter("numQualite",numQualite);
		List<Qualite> li=null;
		try {
			li= (List<Qualite>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
