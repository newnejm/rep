package com.yesserp.sessionbean.pg.gestionSituationContratIdentite;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.SituationContratIdentite;
import com.yesserp.sessionbean.pg.gestionSituationContratIdentite.GestionSituationContratIdentiteLocal;

@Stateless
@LocalBean
public class GestionSituationContratIdentite implements GestionSituationContratIdentiteLocal{

	 @PersistenceContext(unitName="yessclever")
		private EntityManager em;
	
	@Override
	public void ajouterSituationContratIdentite(
			SituationContratIdentite i) {
		em.persist(i);
		
	}

	@Override
	public void supprimerSituationContratIdentite(
			SituationContratIdentite i) {
		i = em.merge(i);
		em.remove(i);
		
	}

	@Override
	public void modifierSituationContratIdentite(
			SituationContratIdentite i) {
		em.merge(i);
	}

	@Override
	public List<SituationContratIdentite> findall() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select i from SituationContratIdentite i");
		return query.getResultList();
	}

}


