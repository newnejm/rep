package com.yesserp.sessionbean.pg.gestionTypeStatutIdentite;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.TypeStatutIdentite;
import com.yesserp.sessionbean.pg.gestionTypeStatutIdentite.GestionTypeStatutIdentiteLocal;

@Stateless
@LocalBean
public class GestionTypeStatutIdentite implements GestionTypeStatutIdentiteLocal{

	 @PersistenceContext(unitName="yessclever")
		private EntityManager em;
	
	@Override
	public void ajouterTypeStatutIdentite(
			TypeStatutIdentite i) {
		em.persist(i);
		
	}

	@Override
	public void supprimerTypeStatutIdentite(
			TypeStatutIdentite i) {
		i = em.merge(i);
		em.remove(i);
		
	}

	@Override
	public void modifierTypeStatutIdentite(
			TypeStatutIdentite i) {
		em.merge(i);
	}

	@Override
	public List<TypeStatutIdentite> findall() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select i from TypeStatutIdentite i");
		return query.getResultList();
	}

}

