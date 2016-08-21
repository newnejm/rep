package com.yesserp.sessionbean.gta.valeurCompteur;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.yesserp.domain.gta.CalculCompteur;
import com.yesserp.domain.gtaparam.Compteur;
import com.yesserp.domain.gtaparam.ValeurCompteur;

/**
 * Session Bean implementation class valeurCompteur
 */
@Stateless
public class GestionValeurCompteur implements GestionValeurCompteurLocal {

	/**
	 * Default constructor.
	 */
	public GestionValeurCompteur() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext
	EntityManager entityManager;




	@Override
	public void ajoutervaleurCompteur(ValeurCompteur vc) {
		// TODO Auto-generated method stub
		entityManager.persist(vc);	
	}

	@Override
	public void supprimervaleurCompteur(ValeurCompteur vc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifiervaleurCompteur(ValeurCompteur vc) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.merge(vc));
	}

	@Override
	public List<ValeurCompteur> findAllvaleurCompteur() {
		Query query = entityManager
				.createQuery("select o from ValeurCompteur o ");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> rechercheValeurCompteurParCompteur(
			Compteur compteur) {
		// TODO Auto-generated method stub
		
		
		
		TypedQuery<Object[]> query = (TypedQuery<Object[]>) entityManager.createQuery("select v.dateCalc ,v.valeurHoraire,v.valeurNumerique from ValeurCompteur  v inner join v.compteur c  where c=:idc order by v.dateCalc");
		query.setParameter("idc", compteur);
		List<Object[]> results = query.getResultList();
		
		return results;

	}

	@Override
	public void supprimerTousLesLignes(Compteur cmp) {
		// TODO Auto-generated method stub
		Query q = entityManager
				.createQuery("Delete from ValeurCompteur c where compteur = :idc");
		q.setParameter("idc", cmp);	
		q.executeUpdate();
		
	}

	@Override
	public ValeurCompteur getValeurCompteurParCompteurEtParDate(Compteur cmp,
			Date d) {
		// 
		Query query = entityManager
				.createQuery("select v  from ValeurCompteur v inner join v.compteur c where c=:x and v.dateCalc=:d");
		query.setParameter("x", cmp);
		query.setParameter("d", d);
		query.setMaxResults(1);
		List<ValeurCompteur> results = query.getResultList();
		ValeurCompteur foundEntity = null;
		if(!results.isEmpty()){
		   
		    foundEntity = results.get(0);
		}
		
		return foundEntity;
	}

}
