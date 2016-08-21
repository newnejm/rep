package com.yesserp.sessionbean.pg.gestionParametres_fiscal;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.Parametres_fiscal;


@Stateless
@LocalBean
public class GestionParametres_fiscal implements GestionParametres_fiscalLocal{
	

	
    public GestionParametres_fiscal() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterParametres_fiscal(Parametres_fiscal i) {
		em.persist(i);
	}


	@Override
	public void supprimerParametres_fiscal(Parametres_fiscal i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierParametres_fiscal(Parametres_fiscal i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<Parametres_fiscal> AfficherTousParametres_fiscal() {
		
		Query query = em.createQuery("SELECT c FROM Parametres_fiscal c");
        return query.getResultList();
	}

	/*

	@Override
	public List<Parametres_fiscal> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from Parametres_fiscal i where nom = :nom");
		q.setParameter("nom",nom);
		List<Parametres_fiscal> li=null;
		try {
			li= (List<Parametres_fiscal>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<Parametres_fiscal> trouverParNumParametres_fiscal(String numParametres_fiscal) {
		
		Query q=em.createQuery("select from Parametres_fiscal i where numParametres_fiscal = :numParametres_fiscal");
		q.setParameter("numParametres_fiscal",numParametres_fiscal);
		List<Parametres_fiscal> li=null;
		try {
			li= (List<Parametres_fiscal>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
