package com.yesserp.sessionbean.paramgta.gestionjourneetype;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.CycleTravail;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.PlageHAssociateJourneeTPK;
import com.yesserp.domain.gtaparam.PlageHoraire;
import com.yesserp.domain.gtaparam.PlageHoraireAssociateJourneeType;
import com.yesserp.domain.gtaparam.SemaineType;

/**
 * Session Bean implementation class GestionJourneeType
 */
@Stateless
@LocalBean
public class GestionJourneeType implements GestionJourneeTypeLocal {

	/**
	 * Default constructor.
	 */
	public GestionJourneeType() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajoutJourneeType(JourneeType journeeType) {
		entityManager.persist(journeeType);

	}

	@Override
	public void supprimerJourneeType(JourneeType journeeType) {
		entityManager.remove(entityManager.merge(journeeType));

	}

	@Override
	public void modifierJourneeType(JourneeType journeeType) {
		entityManager.merge(journeeType);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JourneeType> listerJourneeType() {
		Query query = entityManager
				.createQuery("SELECT jt FROM JourneeType jt");
		return query.getResultList();
	}

	@Override
	public JourneeType findJourneeTypeById(int idJourneeType) {
		return entityManager.find(JourneeType.class, idJourneeType);
	}

	@Override
	public JourneeType findJourneeTypeByCode(String code) {
		Query query = entityManager
				.createQuery("select jt from JourneeType jt where codejt=:x");
		query.setParameter("x", code);
		return (JourneeType) query.getSingleResult();
	}

	@Override
	public void associatePlageHoraireToJourneeType(int jt,List<PlageHoraire> plageHoraires, List<Integer> heures) {
		for (int i = 0; i < plageHoraires.size(); i++) {
			Query query = entityManager
					.createNativeQuery("insert into PlageHoraireAssociateJourneeType (idjourneetype,idplagehorraire,heuredeb,heurefin)"
							+ "values(?,?,?,?)");
			query.setParameter(1, jt);
			query.setParameter(2, plageHoraires.get(i).getIdph());
			query.setParameter(3, heures.get(i));
			query.setParameter(4, 1);
			query.executeUpdate();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JourneeType> findJourneesForCycle(CycleTravail cycleTravail) {
		Query query = entityManager
				.createQuery("select j from JourneeType j where:cycleTravail member of j.cycleTravails");
		query.setParameter("cycleTravail", cycleTravail);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JourneeType> findJourneesForSemainType(SemaineType semaineType) {
		Query query = entityManager
				.createQuery("select j from JourneeType j where:semaineType member of j.semaineTypes");
		query.setParameter("semaineType", semaineType);
		return query.getResultList();
	}

	@Override
	public String findLibelle(String code) {
		Query query = entityManager.createQuery("select l.lib from Libelle l where l.journeeType.codejt=:x");
				query.setParameter("x", code);
		return (String) query.getSingleResult();
	}

	@Override
	public void associatePlageHoraireToJourneeType(int idjt,
			List<PlageHoraire> plageHoraires, List<Integer> heures,
			List<Integer> heuresFin) {
		for (int i = 0; i < plageHoraires.size(); i++) {
			Query query = entityManager
					.createNativeQuery("insert into PlageHoraireAssociateJourneeType (idjourneetype,idplagehorraire,heuredeb,heurefin)"
							+ "values(?,?,?,?)");
			query.setParameter(1, idjt);
			query.setParameter(2, plageHoraires.get(i).getIdph());
			query.setParameter(3, heures.get(i));
			query.setParameter(4, heuresFin.get(i));
			query.executeUpdate();
		}
		
	}

	@Override
	public List<PlageHoraireAssociateJourneeType> findPlageAssociateJtByJt(JourneeType journeeType) {
		Query query = entityManager
				.createQuery("select pj from PlageHoraireAssociateJourneeType pj join pj.journeeType j where j.id = :id ");
		query.setParameter("id", journeeType.getIdjt());
		return query.getResultList();
	}

}
