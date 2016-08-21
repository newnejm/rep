package com.yesserp.sessionbean.pg.gestionCategorie;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.Categorie;


@Stateless
@LocalBean
public class GestionCategorie implements GestionCategorieLocal{
	

	
    public GestionCategorie() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterCategorie(Categorie i) {
		em.persist(i);
	}


	@Override
	public void supprimerCategorie(Categorie i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierCategorie(Categorie i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<Categorie> AfficherTousCategorie() {
		
		Query query = em.createQuery("SELECT c FROM pg_Categoriee c");
        return query.getResultList();
	}

	/*

	@Override
	public List<Categorie> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from Categorie i where nom = :nom");
		q.setParameter("nom",nom);
		List<Categorie> li=null;
		try {
			li= (List<Categorie>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<Categorie> trouverParNumCategorie(String numCategorie) {
		
		Query q=em.createQuery("select from Categorie i where numCategorie = :numCategorie");
		q.setParameter("numCategorie",numCategorie);
		List<Categorie> li=null;
		try {
			li= (List<Categorie>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
