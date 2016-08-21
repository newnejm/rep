package com.yesserp.sessionbean.pg.gestionQualiteIdentite;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.QualiteIdentite;
import com.yesserp.sessionbean.pg.gestionQualiteIdentite.GestionQualiteIdentiteLocal;

@Stateless
@LocalBean
public class GestionQualiteIdentite implements GestionQualiteIdentiteLocal{

	 @PersistenceContext(unitName="yessclever")
		private EntityManager em;
	
	@Override
	public void ajouterQualiteIdentite(
			QualiteIdentite i) {
		em.persist(i);
		
	}

	@Override
	public void supprimerQualiteIdentite(
			QualiteIdentite i) {
		i = em.merge(i);
		em.remove(i);
		
	}

	@Override
	public void modifierQualiteIdentite(
			QualiteIdentite i) {
		em.merge(i);
	}

	@Override
	public List<QualiteIdentite> findall() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select i from QualiteIdentite i");
		return query.getResultList();
	}

}


