package com.yesserp.sessionbean.pg.gestionTypeContrat;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.TypeContrat;


@Stateless
@LocalBean
public class GestionTypeContrat implements GestionTypeContratLocal{
	

	
    public GestionTypeContrat() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterTypeContrat(TypeContrat i) {
		em.persist(i);
	}


	@Override
	public void supprimerTypeContrat(TypeContrat i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierTypeContrat(TypeContrat i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<TypeContrat> AfficherTousTypeContrat() {
		
		Query query = em.createQuery("SELECT c FROM pg_TypeContrate c");
        return query.getResultList();
	}

	/*

	@Override
	public List<TypeContrat> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from TypeContrat i where nom = :nom");
		q.setParameter("nom",nom);
		List<TypeContrat> li=null;
		try {
			li= (List<TypeContrat>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<TypeContrat> trouverParNumTypeContrat(String numTypeContrat) {
		
		Query q=em.createQuery("select from TypeContrat i where numTypeContrat = :numTypeContrat");
		q.setParameter("numTypeContrat",numTypeContrat);
		List<TypeContrat> li=null;
		try {
			li= (List<TypeContrat>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
