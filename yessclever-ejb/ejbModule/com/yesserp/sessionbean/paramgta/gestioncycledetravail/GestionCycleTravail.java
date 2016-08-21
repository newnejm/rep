package com.yesserp.sessionbean.paramgta.gestioncycledetravail;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.AffectationCycle;
import com.yesserp.domain.gta.AffectationCyclePK;
import com.yesserp.domain.gtaparam.CycleTravail;
import com.yesserp.domain.gtaparam.CycleTravailAssociateJourneeType;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.SemaineType;

/**
 * Session Bean implementation class GestionCycleTravail
 */
@Stateless
@LocalBean
public class GestionCycleTravail implements GestionCycleTravailLocal {

	/**
	 * Default constructor.
	 */
	public GestionCycleTravail() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajoutCycleTravail(CycleTravail cycleTravail) {
		entityManager.persist(entityManager.merge(cycleTravail));

	}

	@Override
	public void supprimerCycleTravail(CycleTravail cycleTravail) {
		entityManager.remove(entityManager.merge(cycleTravail));

	}

	@Override
	public void modifierCycleTravail(CycleTravail cycleTravail) {
		entityManager.merge(cycleTravail);

	}

	@Override
	public List<CycleTravail> listerCycleTravail() {
		Query query = entityManager
				.createQuery("SELECT ct FROM CycleTravail ct");
		return query.getResultList();
	}

	@Override
	public CycleTravail findCycleTravailById(int idCycleTravail) {
		return entityManager.find(CycleTravail.class, idCycleTravail);
	}

	@Override
	public CycleTravail findCycleDeTravailParCode(String code) {
		Query query = entityManager
				.createQuery("select c from CycleTravail c where c.codect=:x");
		query.setParameter("x", code);
		return (CycleTravail) query.getSingleResult();
	}

	@Override
	public void affectcycledeTravailTojourneetype(CycleTravail cycleTravail,
			List<JourneeType> journeeTypes) {
		for (int i = 0; i < journeeTypes.size(); i++) {
			Query query = entityManager
					.createNativeQuery("insert into gta_ctp_uh01_gta_jtp_uf01 (gta_ctp_uh01_idct,journeetypes_idjt)"
							+ "values(?,?)");
			query.setParameter(1, cycleTravail.getIdct());
			query.setParameter(2, journeeTypes.get(i).getIdjt());
			query.executeUpdate();
		}

	}

	@Override
	public void affectCycleToSemaineType(CycleTravail cycleTravail,
			List<SemaineType> semaineTypes) {

		for (int i = 0; i < semaineTypes.size(); i++) {
			Query query = entityManager
					.createNativeQuery("insert into GTA_CTP_STP_RH01 (cycletravails_idct,semainetypes_idst)"
							+ "values(?,?)");
			query.setParameter(1, cycleTravail.getIdct());
			query.setParameter(2, semaineTypes.get(i).getIdst());
			query.executeUpdate();
		}

	}

	@Override
	public void affectCycleToEmployee(Identite identite,CycleTravail cycleTravailGTA, Date date) {
		
		
		AffectationCycle affectationCycle = new AffectationCycle();
		AffectationCyclePK affectationCyclePK = new AffectationCyclePK();
		
		
		affectationCyclePK.setIdCycle(cycleTravailGTA.getIdct());
		affectationCyclePK.setIdIdentite(identite.getNumedoss());
		affectationCyclePK.setDateAffectation(date);
		affectationCycle.setAffectationCyclePK(affectationCyclePK);
		
		entityManager.merge(cycleTravailGTA);
		entityManager.persist(entityManager.merge(affectationCycle));

	}

	@Override
	public List<CycleTravail> trouverCycleAffectePourEmployee(Identite identite) {
		Query query = entityManager
				.createQuery("select c from CycleTravail c join c.affectationCycles a  where a.identite=:identite");
		query.setParameter("identite", identite);
		return query.getResultList();

	}

	@Override
	public List<JourneeType> findJourneesForCycle(CycleTravail cycleTravail) {
		Query query = entityManager
				.createQuery("select j from JourneeType j where:cycleTravail member of j.cycleTravails");
		query.setParameter("cycleTravail", cycleTravail);
		return query.getResultList();
	}

	@Override
	public void associateCycleTravailToJourneeType(int idct,
			List<JourneeType> journeeTypes, List<Integer> ordreJours) {
		for (int i = 0; i < journeeTypes.size(); i++) {
			Query query = entityManager
					.createNativeQuery("insert into CycleTravailAssociateJourneeType (idcycletravail,idjourneetype,ordrejournee)"
							+ "values(?,?,?)");
			query.setParameter(1, idct);
			query.setParameter(2, journeeTypes.get(i).getIdjt());
			query.setParameter(3, ordreJours.get(i));
		
			query.executeUpdate();
		}
		
		
	}

	@Override
	public List<CycleTravail> findCycleTravailByType(String type) {
		Query query = entityManager
				.createQuery("SELECT ct FROM CycleTravail ct where typeCycle= :type");
		query.setParameter("type", type);
		return query.getResultList();
	}

}
