package com.yesserp.sessionbean.pg.gestionFiliale;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.Filiale;
import com.yesserp.domain.pg.Societe;


@Stateless
@LocalBean
public class GestionFiliale implements GestionFilialeLocal{
	

	
    public GestionFiliale() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterFiliale(Filiale i) {
		em.persist(i);
	}


	@Override
	public void supprimerFiliale(Filiale i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierFiliale(Filiale i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<Filiale> AfficherTousFiliale() {
		
		Query query = em.createQuery("SELECT c FROM Filiale c");
        return query.getResultList();
	}

	
	@Override
	public List<Filiale> findFilialeBySociete(
			Societe societe) {
		Query query = em
				.createQuery("SELECT lib FROM Filiale lib WHERE lib.societe=:x");
		query.setParameter("x", societe);
		return query.getResultList();
	
	}
	
	
	/*

	@Override
	public List<Filiale> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from Filiale i where nom = :nom");
		q.setParameter("nom",nom);
		List<Filiale> li=null;
		try {
			li= (List<Filiale>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<Filiale> trouverParNumFiliale(String numFiliale) {
		
		Query q=em.createQuery("select from Filiale i where numFiliale = :numFiliale");
		q.setParameter("numFiliale",numFiliale);
		List<Filiale> li=null;
		try {
			li= (List<Filiale>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
