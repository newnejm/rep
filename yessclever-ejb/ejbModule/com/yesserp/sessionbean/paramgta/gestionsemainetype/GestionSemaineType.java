package com.yesserp.sessionbean.paramgta.gestionsemainetype;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.CodeJour;
import com.yesserp.domain.gtaparam.CycleTravail;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.SemaineJournees;
import com.yesserp.domain.gtaparam.SemaineJourneesPK;
import com.yesserp.domain.gtaparam.SemaineType;

/**
 * Session Bean implementation class GestionSemaineType
 */
@Stateless
@LocalBean
public class GestionSemaineType implements GestionSemaineTypeLocal {

	/**
	 * Default constructor.
	 */
	public GestionSemaineType() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajouterSemaineType(SemaineType semaineType) {
		entityManager.persist(semaineType);

	}

	@Override
	public void modifierSemaineType(SemaineType semaineType) {
		entityManager.merge(semaineType);

	}

	@Override
	public void supprimerSemaineType(SemaineType semaineType) {
		entityManager.remove(entityManager.merge(semaineType));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SemaineType> listeSemaineType() {
		Query query = entityManager.createQuery("select s from SemaineType s");
		return query.getResultList();
	}

	@Override
	public void affectJourneeTypesTosemaineType(SemaineType semaineType,
			List<JourneeType> journeeTypes) {
		for (int i = 0; i < journeeTypes.size(); i++) {
			Query query = entityManager
					.createNativeQuery("insert into GTA_STP_JTP_UH01 (semainetypes_idst,journeetypes_idjt)"
							+ "values(?,?)");
			query.setParameter(1, semaineType.getIdst());
			query.setParameter(2, journeeTypes.get(i).getIdjt());
			query.executeUpdate();
		}

	}

	@Override
	public SemaineType trouverSemaineParCode(String code) {
		Query query = entityManager
				.createQuery("SELECT s FROM SemaineType s WHERE codest=:x");
		query.setParameter("x", code);
		return (SemaineType) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SemaineType> findSemaineTypeForCycle(CycleTravail cycleTravail) {
		Query query = entityManager
				.createQuery("select s from SemaineType s where:cycleTravail member of s.cycleTravails");
		query.setParameter("cycleTravail", cycleTravail);
		return query.getResultList();
	}

	@Override
	public void ajouterDesJourneesPourSemaineAvecCodeJour(
			SemaineType semaineType, JourneeType journeeType, CodeJour codeJour) {
		SemaineJournees semaineJournees = new SemaineJournees();
		semaineJournees.setSemaineType(semaineType);
		semaineJournees.setCodeJour(codeJour);
		semaineJournees.setJourneeType(journeeType);
		SemaineJourneesPK pk = new SemaineJourneesPK();
		pk.setIdCodejour(codeJour.getIdcj());
		pk.setIdSemaine(semaineType.getIdst());
		pk.setIdJournee(journeeType.getIdjt());
		semaineJournees.setSemaineJourneesPK(pk);
		entityManager.persist(semaineJournees);
	}

	@Override
	public JourneeType trouverJourneParCodeJourEtSemaineType(
			SemaineType semaineType, CodeJour codeJour) {
		Query query = entityManager
				.createQuery("select j from JourneeType j join j.semaineJournees s where s.codeJour=:co and s.semaineType=:se");
		query.setParameter("co", codeJour);
		query.setParameter("se", semaineType);
		return (JourneeType) query.getSingleResult();
	}

	@Override
	public SemaineType findSemaineByID(int id) {

		return entityManager.find(SemaineType.class, id);

	}

	@Override
	public List<JourneeType> trouverJourneesParSemaine(SemaineType semaineType) {
		Query query = entityManager
				.createQuery("select j from JourneeType j join j.semaineJournees s where s.semaineType=:se");
		query.setParameter("se", semaineType);
		return query.getResultList();
	}

	@Override
	public CodeJour trouverCodeParSemaineEtParJourneeType(
			SemaineType semaineType, JourneeType journeeType) {
		Query query = entityManager
				.createQuery("select j from CodeJour j join j.semaineJournees s where s.journeeType=:co and s.semaineType=:se");
		query.setParameter("co", journeeType);
		query.setParameter("se", semaineType);

		return (CodeJour) query.getSingleResult();

	}

}
