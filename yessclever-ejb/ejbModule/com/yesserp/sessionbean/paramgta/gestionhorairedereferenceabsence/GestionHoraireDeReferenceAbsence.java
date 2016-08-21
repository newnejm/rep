package com.yesserp.sessionbean.paramgta.gestionhorairedereferenceabsence;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.HoraireDeReferenceAbsence;
import com.yesserp.domain.gtaparam.JourneeType;

/**
 * Session Bean implementation class GestionHoraireDeReferenceAbsence
 */
@Stateless
@LocalBean
public class GestionHoraireDeReferenceAbsence implements
		GestionHoraireDeReferenceAbsenceLocal {

	/**
	 * Default constructor.
	 */
	public GestionHoraireDeReferenceAbsence() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<HoraireDeReferenceAbsence> findByJourneeType(
			JourneeType journeeType) {
		Query query = entityManager
				.createQuery("select hr from HoraireDeReferenceAbsence hr where hr.journeeType=:x");
		query.setParameter("x", journeeType);
		return query.getResultList();
	}

}
