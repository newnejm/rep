package com.yesserp.sessionbean.pg.gestionSexe;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.Sexe;


@Stateless
@LocalBean
public class GestionSexe implements GestionSexeLocal{
	

	
    public GestionSexe() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterSexe(Sexe i) {
		em.persist(i);
	}


	@Override
	public void supprimerSexe(Sexe i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierSexe(Sexe i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<Sexe> AfficherTousSexe() {
		
		Query query = em.createQuery("SELECT c FROM pg_Sexee c");
        return query.getResultList();
	}

	/*

	@Override
	public List<Sexe> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from Sexe i where nom = :nom");
		q.setParameter("nom",nom);
		List<Sexe> li=null;
		try {
			li= (List<Sexe>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<Sexe> trouverParNumSexe(String numSexe) {
		
		Query q=em.createQuery("select from Sexe i where numSexe = :numSexe");
		q.setParameter("numSexe",numSexe);
		List<Sexe> li=null;
		try {
			li= (List<Sexe>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
