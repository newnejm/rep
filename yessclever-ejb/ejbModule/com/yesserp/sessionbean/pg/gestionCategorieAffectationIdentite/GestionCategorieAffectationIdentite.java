package com.yesserp.sessionbean.pg.gestionCategorieAffectationIdentite;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.CategorieAffectationIdentite;

@Stateless
@LocalBean
public class GestionCategorieAffectationIdentite implements GestionCategorieAffectationIdentiteLocal{

	 @PersistenceContext(unitName="yessclever")
		private EntityManager em;
	
	@Override
	public void ajouterCategorieAffectationIdentite(
			CategorieAffectationIdentite i) {
		em.persist(i);
		
	}

	@Override
	public void supprimerCategorieAffectationIdentite(
			CategorieAffectationIdentite i) {
		i = em.merge(i);
		em.remove(i);
		
	}

	@Override
	public void modifierCategorieAffectationIdentite(
			CategorieAffectationIdentite i) {
		em.merge(i);
	}

	@Override
	public List<CategorieAffectationIdentite> findall() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select i from CategorieAffectationIdentite i");
		return query.getResultList();
	}

}
