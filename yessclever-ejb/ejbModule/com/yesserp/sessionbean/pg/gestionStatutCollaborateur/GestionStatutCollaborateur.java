package com.yesserp.sessionbean.pg.gestionStatutCollaborateur;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.StatutCollaborateur;


@Stateless
@LocalBean
public class GestionStatutCollaborateur implements GestionStatutCollaborateurLocal{
	

	
    public GestionStatutCollaborateur() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterStatutCollaborateur(StatutCollaborateur i) {
		em.persist(i);
	}


	@Override
	public void supprimerStatutCollaborateur(StatutCollaborateur i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierStatutCollaborateur(StatutCollaborateur i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<StatutCollaborateur> AfficherTousStatutCollaborateur() {
		
		Query query = em.createQuery("SELECT c FROM pg_StatutCollaborateure c");
        return query.getResultList();
	}

	/*

	@Override
	public List<StatutCollaborateur> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from StatutCollaborateur i where nom = :nom");
		q.setParameter("nom",nom);
		List<StatutCollaborateur> li=null;
		try {
			li= (List<StatutCollaborateur>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<StatutCollaborateur> trouverParNumStatutCollaborateur(String numStatutCollaborateur) {
		
		Query q=em.createQuery("select from StatutCollaborateur i where numStatutCollaborateur = :numStatutCollaborateur");
		q.setParameter("numStatutCollaborateur",numStatutCollaborateur);
		List<StatutCollaborateur> li=null;
		try {
			li= (List<StatutCollaborateur>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
