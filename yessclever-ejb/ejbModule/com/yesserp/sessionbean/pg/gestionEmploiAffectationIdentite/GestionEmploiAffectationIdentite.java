package com.yesserp.sessionbean.pg.gestionEmploiAffectationIdentite;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.EmploiAffectationIdentite;
import com.yesserp.sessionbean.pg.gestionEmploiAffectationIdentite.GestionEmploiAffectationIdentiteLocal;

@Stateless
@LocalBean
public class GestionEmploiAffectationIdentite implements GestionEmploiAffectationIdentiteLocal{

	 @PersistenceContext(unitName="yessclever")
		private EntityManager em;
	
	@Override
	public void ajouterEmploiAffectationIdentite(
			EmploiAffectationIdentite i) {
		em.persist(i);
		
	}

	@Override
	public void supprimerEmploiAffectationIdentite(
			EmploiAffectationIdentite i) {
		i = em.merge(i);
		em.remove(i);
		
	}

	@Override
	public void modifierEmploiAffectationIdentite(
			EmploiAffectationIdentite i) {
		em.merge(i);
	}

	@Override
	public List<EmploiAffectationIdentite> findall() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select i from EmploiAffectationIdentite i");
		return query.getResultList();
	}

}

