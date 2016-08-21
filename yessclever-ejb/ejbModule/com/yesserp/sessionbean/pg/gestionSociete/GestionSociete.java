package com.yesserp.sessionbean.pg.gestionSociete;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.Societe;


@Stateless
@LocalBean
public class GestionSociete implements GestionSocieteLocal{
	

	
    public GestionSociete() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterSociete(Societe i) {
		em.persist(i);
	}


	@Override
	public void supprimerSociete(Societe i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierSociete(Societe i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<Societe> AfficherTousSociete() {
		
		Query query = em.createQuery("SELECT c FROM Societe c");
        return query.getResultList();
	}

	/*

	@Override
	public List<Societe> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from Societe i where nom = :nom");
		q.setParameter("nom",nom);
		List<Societe> li=null;
		try {
			li= (List<Societe>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<Societe> trouverParNumSociete(String numSociete) {
		
		Query q=em.createQuery("select from Societe i where numSociete = :numSociete");
		q.setParameter("numSociete",numSociete);
		List<Societe> li=null;
		try {
			li= (List<Societe>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
