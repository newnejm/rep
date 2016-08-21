package com.yesserp.sessionbean.pg.gestionUOAffectationIdentite;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.UOAffectationIdentite;
import com.yesserp.sessionbean.pg.gestionUOAffectationIdentite.GestionUOAffectationIdentiteLocal;

@Stateless
@LocalBean
public class GestionUOAffectationIdentite implements GestionUOAffectationIdentiteLocal{

	 @PersistenceContext(unitName="yessclever")
		private EntityManager em;
	
	@Override
	public void ajouterUOAffectationIdentite(
			UOAffectationIdentite i) {
		em.persist(i);
		
	}

	@Override
	public void supprimerUOAffectationIdentite(
			UOAffectationIdentite i) {
		i = em.merge(i);
		em.remove(i);
		
	}

	@Override
	public void modifierUOAffectationIdentite(
			UOAffectationIdentite i) {
		em.merge(i);
	}

	@Override
	public List<UOAffectationIdentite> findall() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select i from UOAffectationIdentite i");
		return query.getResultList();
	}

}

