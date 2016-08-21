package com.yesserp.sessionbean.pg.gestionParametrageMail;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.ParametrageMail;


@Stateless
@LocalBean
public class GestionParametrageMail implements GestionParametrageMailLocal{
	

	
    public GestionParametrageMail() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterParametrageMail(ParametrageMail i) {
		em.persist(i);
	}


	@Override
	public void supprimerParametrageMail(ParametrageMail i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierParametrageMail(ParametrageMail i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<ParametrageMail> AfficherTousParametrageMail() {
		
		Query query = em.createQuery("SELECT c FROM ParametrageMail c");
        return query.getResultList();
	}

	/*

	@Override
	public List<ParametrageMail> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from ParametrageMail i where nom = :nom");
		q.setParameter("nom",nom);
		List<ParametrageMail> li=null;
		try {
			li= (List<ParametrageMail>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<ParametrageMail> trouverParNumParametrageMail(String numParametrageMail) {
		
		Query q=em.createQuery("select from ParametrageMail i where numParametrageMail = :numParametrageMail");
		q.setParameter("numParametrageMail",numParametrageMail);
		List<ParametrageMail> li=null;
		try {
			li= (List<ParametrageMail>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
