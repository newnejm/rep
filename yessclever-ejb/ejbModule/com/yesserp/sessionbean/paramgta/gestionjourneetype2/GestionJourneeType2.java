package com.yesserp.sessionbean.paramgta.gestionjourneetype2;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.CycleTravail;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.JourneeType2;
import com.yesserp.domain.gtaparam.PlageHoraire2;
import com.yesserp.domain.gtaparam.PlageHoraireAssociateJourneeType;
import com.yesserp.domain.gtaparam.PlageHoraireAssociateJourneeType2;
import com.yesserp.domain.gtaparam.SemaineType;



@Stateless
@LocalBean
public class GestionJourneeType2   implements GestionJourneeType2Local   {

	public GestionJourneeType2() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@PersistenceContext(unitName = "yessclever")
	EntityManager  entityManager ;
	
	
	public void ajouterJourneeType( JourneeType2 journeeType2 )
	{
		entityManager.persist(journeeType2);
		
	}
	
	public void supprimerJourneeType(  JourneeType2 journeeType2 ) {
	entityManager.remove(journeeType2);
		
	}
	
	public void modifierJourneeType( JourneeType2 journeeType2     )  {
		entityManager.merge(journeeType2   );
	
	}
	
	public List<JourneeType2> listerJourneeType2() {
		
		Query query =entityManager.createQuery("SELECT it FROM JourneeType it" ) ;
		return  query.getResultList() ;
		
	}
	
	
	public JourneeType2 findJourneeTypeById(int idJourneeType)
	
	{
		return entityManager.find(JourneeType2.class , idJourneeType) ;
		
	}
	
	
	public JourneeType2 findJourneeTypeByCode(String code)
	{
	  Query query  = entityManager.createQuery("select jt from  JourneeType2 jt where codejt=: x") ;
	  query.setParameter("x", code) ;
	  return (JourneeType2) query.getSingleResult() ;
	
	}
	  
	public void associatePlageHoraireToJourneeType( int jt ,List<PlageHoraire2> plageHoraire2s,List<Integer> heures)
		{
	for (int i =0 ; i< plageHoraire2s.size() ; i++){
		
		Query query = entityManager.createNativeQuery("insert into PlageHoraireAssociateJourneeType2 (idjourneetype2, idplagehorraire2, heuredeb,heurefin)"+ "values(?,?,?,?)");
		query.setParameter(1, jt) ;
		query.setParameter(2 , plageHoraire2s.get(i).getIdph2());
		query.setParameter(3, heures.get(i)) ;
		query.setParameter(4, 1) ;
		query.executeUpdate() ;
		
    	}		
	}
	
	public List<JourneeType2> findJourness2ForCycle(CycleTravail cycleTravail) {
		Query query =entityManager.createQuery("select j from JourneeType2 j where:cycleTravail member of j.cycleTravails");
		query.setParameter("cycleTravail", cycleTravail ) ;
		return query.getResultList() ;
	}
		
		public List<JourneeType2> findJourneesForSemainType( SemaineType semaineType  )
		{
		  Query query2 =entityManager.createQuery("select j from JourneeType j where :semaineType member of j.semaineTypes") ;
		  query2.setParameter("semaineType", semaineType );
		  
		  return query2.getResultList();
		}

		@Override
		public List<JourneeType2> listerJourneeType() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public JourneeType2 findJouneeTypeById(int idJourneeType) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<JourneeType2> findJourneesForCycle(CycleTravail cycleTravail) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String findLibelle(String code) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void associatePlageHoraireToJourneeType(int idjt,
				List<PlageHoraire2> plageHoraire2s, List<Integer> heures,
				List<Integer> heuresFin) {
			// TODO Auto-generated method stub
			
		}

	
		
	
		
		@Override
		public List<PlageHoraireAssociateJourneeType2> findPlageAssociateJTByJt2(JourneeType2 journeeType2) {
			Query query = entityManager
					.createQuery("select pj from PlageHoraireAssociateJourneeType2 pj join pj.journeeType2 j where j.id = :id ");
			query.setParameter("id", journeeType2.getIdjt2());
			return query.getResultList();
		}
		
		
		
		
		
	
	}
	
	

