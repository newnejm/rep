package com.yesserp.sessionbean.paramgta.gestionDescJourneeType2;

import java.util.Date;
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



@Stateless
@LocalBean
public class GestionDescJourneeType2 implements GestionDescJourneeType2Local{

	public GestionDescJourneeType2() {
	
	}
	
	@PersistenceContext( unitName = "")
	private EntityManager em ;
	
//	public void ajouterDescJourneeType2(  DescJourneeType2 i) {
//		
//		configDateEffet(i.getDateEffet(),i.getJourneeType2() );
//		em.persist(i);
//	}
	
	public void supprimerDescJourneeType2( DescJourneeType2 i){
		
		i =em.merge(i);
		em.remove(i);
	}
	
	public void  modifierDescJourneeType2( DescJourneeType2 i ){
		
		em.merge(i);
	}
	
	@Override
	public List<DescJourneeType2> AfficherTousDescJourneeType2() {

		Query query = em.createQuery("SELECT c FROM DescJourneeType2 c");
		return query.getResultList();
	}
	
	public List<DescJourneeType2> getSortedDescJourneeType2() {

		Query query = em
				.createQuery("SELECT c FROM DescJourneeType2 c ORDER BY c.dateEffet ASC");
		return query.getResultList();
	}
	
	
	@Override
	public void updatePlageHoraireDescJourneeType2(PlageHoraire2 oldPlageHoraire2, DescJourneeType2 oldDescJourneeType2, PlageHoraire2 plageHoraire2, Date heure) {
		
		Query query = em
				.createNativeQuery("update PlageHoraireDescJourneeType2  set idPlageHoraire = ?"
						+ ", heure = ? WHERE idDescJourneetype = ? AND idPlageHoraire = ?");

		
		
		query.setParameter(1, plageHoraire2.getIdph2());
		query.setParameter(2, heure);
		query.setParameter(3, oldDescJourneeType2.getId());
		query.setParameter(4, oldPlageHoraire2.getIdph2());
		query.executeUpdate();
	}
	
	
	
	public void configDateEffet(Date newDateEffet, JourneeType2 journeeType2) {

		Query query = em
				.createQuery("SELECT c FROM DescJourneeType2 c where c.journeeType2 = :jt2  ORDER BY c.id ASC");
		query.setParameter("jt2", journeeType2);

		List<DescJourneeType2> descJourneeTypes2 = query.getResultList();

		DescJourneeType2 descJourneeType2 = null;
		if (descJourneeTypes2 != null && !descJourneeTypes2.isEmpty()) {
			descJourneeType2 = descJourneeTypes2.get(descJourneeTypes2.size() - 1);
		}
		if (descJourneeType2 != null) { // s'il n'est pas null alors on a
										// récuperé le dernier enregistrement
			descJourneeType2.setDateFin(new Date(
					newDateEffet.getTime() - 24 * 3600 * 1000));
		}
	}

	@Override
	public List<DescJourneeType2> getDescJourneeTypes2ByJourneeType2(
			JourneeType2 journeeType2) {
		Query query = em
				.createQuery("SELECT c FROM DescJourneeType2 c where c.journeeType2 = :jt");
		query.setParameter("jt", journeeType2);
		return query.getResultList();
	}

	
	
	
	
	

}
