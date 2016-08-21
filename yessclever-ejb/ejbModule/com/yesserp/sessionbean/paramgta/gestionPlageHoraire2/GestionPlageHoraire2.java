package com.yesserp.sessionbean.paramgta.gestionPlageHoraire2;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.DescJourneeType;
import com.yesserp.domain.gtaparam.DescJourneeType2;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.JourneeType2;
import com.yesserp.domain.gtaparam.PlageHoraire;
import com.yesserp.domain.gtaparam.PlageHoraire2;
import com.yesserp.domain.gtaparam.PlageHoraireDescJourneeType;
import com.yesserp.domain.gtaparam.PlageHoraireDescJourneeType2;





@Stateless
@LocalBean
public class GestionPlageHoraire2     implements GestionPlageHoraire2Local {
	
	
	/**
	 * Default constructor.
	 */
	public GestionPlageHoraire2() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajouterPlageHoraire2(PlageHoraire2 plageHoraire2) {
		entityManager.persist(plageHoraire2);

	}

	
	@Override
	public void supprimerPlageHoraire2(PlageHoraire2 plageHoraire2) {

		
		
		entityManager.remove(entityManager.merge(plageHoraire2));
		

	}

	@Override
	public void modifierPlageHoraire2(PlageHoraire2 plageHoraire2) {
		entityManager.merge(plageHoraire2);

	}

	@Override
	public List<PlageHoraire2> listerPlageHoraire2() {
		Query query = entityManager
				.createQuery("SELECT pl FROM PlageHoraire2 pl");
		return query.getResultList();
	}

	@Override
	public PlageHoraire2 findPlageHoraire2ById(int idPlageHoraire2) {
		return entityManager.find(PlageHoraire2.class, idPlageHoraire2);
	}

	@Override
	public PlageHoraire2 findPlageHoraire2ByCode(String code) {
		Query query = entityManager
				.createQuery("SELECT pl FROM PlageHoraire2 pl WHERE idph2=:x");
		query.setParameter("x", code);
		return (PlageHoraire2) query.getSingleResult();
	}

	@Override
	public List<PlageHoraire2> findAllPlagesHoraire2ForJourneeType2(
			JourneeType2 journeeType2) {
		Query query = entityManager
				.createQuery("select p from PlageHoraire2 p join p.plageHoraireAssociateJourneeTypes2 r  where r.journeeType2=:journeeType2");
		query.setParameter("journeeType2", journeeType2);
		return query.getResultList();
	}

	@Override
	public List<PlageHoraire2> findAllPlagesHoraire2() {
		Query query = entityManager
				.createQuery("select p from PlageHoraire2 p order by idph2 desc");

		return query.getResultList();
	}

	@Override
	public int trouverHeureDeb(PlageHoraire2 plageHoraire2,
			JourneeType2 journeeType2) {
		Query query = entityManager
				.createQuery("select p.hAssociateJourneeTPK.heureDeb from PlageHoraireAssociateJourneeType2 p where p.plageHoraire2=:pl and p.journeeType2=:jo");
		query.setParameter("pl", plageHoraire2);
		query.setParameter("jo", journeeType2);
		return (int) query.getSingleResult();
	}

	@Override
	public int trouverHeureFin(PlageHoraire2 plageHoraire2,
			JourneeType2 journeeType2) {
		Query query = entityManager
				.createQuery("select p.heureFin from PlageHoraireAssociateJourneeType2 p where p.plageHoraire2=:pl and p.journeeType2=:jo");
		query.setParameter("pl", plageHoraire2);
		query.setParameter("jo", journeeType2);
		return (int) query.getSingleResult();
	}
	
	@Override
	public List<PlageHoraire2> findPlageHoraireByDescJourneeType2(DescJourneeType2 descJourneeType2){
		Query query = entityManager
				.createQuery("select p from PlageHoraire2 p where p.descJourneeType2= :dt");
		query.setParameter("dt", descJourneeType2);
		return query.getResultList();
	}
	
	@Override
	public List<PlageHoraireDescJourneeType2> findPlageHoraireDescJourneeType2(DescJourneeType2 descJourneeType2){
		if(descJourneeType2 != null){
			Query query = entityManager.createQuery("select p from PlageHoraireDescJourneeType2 p where p.descJourneeType2 = :djt");
			query.setParameter("djt", descJourneeType2);
			return query.getResultList();
		}
		return null;
	}
	
	
	
	
}
