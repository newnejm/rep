package com.yesserp.sessionbean.pg.gestionSexeIdentite;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.SexeIdentite;
import com.yesserp.sessionbean.pg.gestionSexeIdentite.GestionSexeIdentiteLocal;

@Stateless
@LocalBean
public class GestionSexeIdentite implements GestionSexeIdentiteLocal{

	 @PersistenceContext(unitName="yessclever")
		private EntityManager em;
	
	@Override
	public void ajouterSexeIdentite(
			SexeIdentite i) {
		em.persist(i);
		
	}

	@Override
	public void supprimerSexeIdentite(
			SexeIdentite i) {
	
		em.remove(em.merge(i));
		
	}

	@Override
	public void modifierSexeIdentite(
			SexeIdentite i) {
		em.merge(i);
	}

	@Override
	public List<SexeIdentite> findall() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select i from SexeIdentite i");
		return query.getResultList();
	}

}


