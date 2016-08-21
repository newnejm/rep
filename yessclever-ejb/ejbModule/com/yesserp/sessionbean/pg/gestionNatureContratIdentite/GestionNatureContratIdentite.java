package com.yesserp.sessionbean.pg.gestionNatureContratIdentite;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.NatureContratIdentite;
import com.yesserp.sessionbean.pg.gestionNatureContratIdentite.GestionNatureContratIdentiteLocal;

@Stateless
@LocalBean
public class GestionNatureContratIdentite implements GestionNatureContratIdentiteLocal{

	 @PersistenceContext(unitName="yessclever")
		private EntityManager em;
	
	@Override
	public void ajouterNatureContratIdentite(
			NatureContratIdentite i) {
		em.persist(i);
		
	}

	@Override
	public void supprimerNatureContratIdentite(
			NatureContratIdentite i) {
		i = em.merge(i);
		em.remove(i);
		
	}

	@Override
	public void modifierNatureContratIdentite(
			NatureContratIdentite i) {
		em.merge(i);
	}

	@Override
	public List<NatureContratIdentite> findall() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select i from NatureContratIdentite i");
		return query.getResultList();
	}

}

