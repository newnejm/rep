package com.yesserp.sessionbean.pg.gestionParametrageAbsence;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.ParametrageAbsence;


@Stateless
@LocalBean
public class GestionParametrageAbsence implements GestionParametrageAbsenceLocal{
	

	
    public GestionParametrageAbsence() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    @Override
    public void ajouterParametrageAbsence(ParametrageAbsence i) {
		em.persist(i);
	}


	@Override
	public void supprimerParametrageAbsence(ParametrageAbsence i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	@Override
	public void modifierParametrageAbsence(ParametrageAbsence i) {
		
		em.merge(i);
		
	}
	
	

	@Override
	public List<ParametrageAbsence> AfficherTousParametrageAbsence() {
		
		Query query = em.createQuery("SELECT c FROM ParametrageAbsence c");
        return query.getResultList();
	}

	/*

	@Override
	public List<ParametrageAbsence> trouverParNom(String nom) {
		
		Query q=em.createQuery("select from ParametrageAbsence i where nom = :nom");
		q.setParameter("nom",nom);
		List<ParametrageAbsence> li=null;
		try {
			li= (List<ParametrageAbsence>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	@Override
	public List<ParametrageAbsence> trouverParNumParametrageAbsence(String numParametrageAbsence) {
		
		Query q=em.createQuery("select from ParametrageAbsence i where numParametrageAbsence = :numParametrageAbsence");
		q.setParameter("numParametrageAbsence",numParametrageAbsence);
		List<ParametrageAbsence> li=null;
		try {
			li= (List<ParametrageAbsence>) q.getResultList();
		} catch (Exception e) {
			
		}		return li;
	}

	
*/
	

	
}
