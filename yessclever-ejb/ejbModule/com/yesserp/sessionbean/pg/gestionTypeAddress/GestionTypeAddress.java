package com.yesserp.sessionbean.pg.gestionTypeAddress;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.TypeAddress;


@Stateless
@LocalBean
public class GestionTypeAddress implements GestionTypeAddressLocal{
	

	
    public GestionTypeAddress() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterTypeAddress(TypeAddress i) {
		em.persist(i);
	}


	@Override
	public void supprimerTypeAddress(TypeAddress i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierTypeAddress(TypeAddress i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<TypeAddress> AfficherTousTypeAddress() {
		
		Query query = em.createQuery("SELECT c FROM pg_TypeAddresse c");
        return query.getResultList();
	}

	/*

	@Override
	public List<TypeAddress> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from TypeAddress i where nom = :nom");
		q.setParameter("nom",nom);
		List<TypeAddress> li=null;
		try {
			li= (List<TypeAddress>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<TypeAddress> trouverParNumTypeAddress(String numTypeAddress) {
		
		Query q=em.createQuery("select from TypeAddress i where numTypeAddress = :numTypeAddress");
		q.setParameter("numTypeAddress",numTypeAddress);
		List<TypeAddress> li=null;
		try {
			li= (List<TypeAddress>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
