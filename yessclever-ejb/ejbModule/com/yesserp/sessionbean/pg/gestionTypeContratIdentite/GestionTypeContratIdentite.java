package com.yesserp.sessionbean.pg.gestionTypeContratIdentite;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.TypeContratIdentite;
import com.yesserp.sessionbean.pg.gestionTypeContratIdentite.GestionTypeContratIdentiteLocal;

@Stateless
@LocalBean
public class GestionTypeContratIdentite implements GestionTypeContratIdentiteLocal{

	 @PersistenceContext(unitName="yessclever")
		private EntityManager em;
	
	@Override
	public void ajouterTypeContratIdentite(
			TypeContratIdentite i) {
		em.persist(i);
		
	}

	@Override
	public void supprimerTypeContratIdentite(
			TypeContratIdentite i) {
		i = em.merge(i);
		em.remove(i);
		
	}

	@Override
	public void modifierTypeContratIdentite(
			TypeContratIdentite i) {
		em.merge(i);
	}

	@Override
	public List<TypeContratIdentite> findall() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select i from TypeContratIdentite i");
		return query.getResultList();
	}

}


