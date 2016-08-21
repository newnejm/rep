package com.yesserp.sessionbean.pg.gestionPosteAffectationIdentite;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.PosteAffectationIdentite;
import com.yesserp.sessionbean.pg.gestionPosteAffectationIdentite.GestionPosteAffectationIdentiteLocal;

@Stateless
@LocalBean
public class GestionPosteAffectationIdentite implements GestionPosteAffectationIdentiteLocal{

	 @PersistenceContext(unitName="yessclever")
		private EntityManager em;
	
	@Override
	public void ajouterPosteAffectationIdentite(
			PosteAffectationIdentite i) {
		em.persist(i);
		
	}

	@Override
	public void supprimerPosteAffectationIdentite(
			PosteAffectationIdentite i) {
		i = em.merge(i);
		em.remove(i);
		
	}

	@Override
	public void modifierPosteAffectationIdentite(
			PosteAffectationIdentite i) {
		em.merge(i);
	}

	@Override
	public List<PosteAffectationIdentite> findall() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select i from PosteAffectationIdentite i");
		return query.getResultList();
	}

}

