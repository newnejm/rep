package com.yesserp.sessionbean.pg.gestionSituationCivileIdentite;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.SituationCivileIdentite;
import com.yesserp.sessionbean.pg.gestionSituationCivileIdentite.GestionSituationCivileIdentiteLocal;

@Stateless
@LocalBean
public class GestionSituationCivileIdentite implements GestionSituationCivileIdentiteLocal{

	 @PersistenceContext(unitName="yessclever")
		private EntityManager em;
	
	@Override
	public void ajouterSituationCivileIdentite(
			SituationCivileIdentite i) {
		em.persist(i);
		
	}

	@Override
	public void supprimerSituationCivileIdentite(
			SituationCivileIdentite i) {
		i = em.merge(i);
		em.remove(i);
		
	}

	@Override
	public void modifierSituationCivileIdentite(
			SituationCivileIdentite i) {
		em.merge(i);
	}

	@Override
	public List<SituationCivileIdentite> findall() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select i from SituationCivileIdentite i");
		return query.getResultList();
	}

}

