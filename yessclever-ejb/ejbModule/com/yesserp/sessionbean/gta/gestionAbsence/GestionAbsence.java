package com.yesserp.sessionbean.gta.gestionAbsence;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.Absence;

/**
 * Session Bean implementation class GestionAbsence
 */
@Stateless
@LocalBean
public class GestionAbsence implements GestionAbsenceLocal {

	/**
	 * Default constructor.
	 */

	@PersistenceContext
	EntityManager entityManager;

	public GestionAbsence() {
		// TODO Auto-generated constructor stub
	}

	public void ajouterAbsence(Absence absence) {
		entityManager.persist(absence);

	}

	public void modifierAbsence(Absence absence) {
		entityManager.merge(absence);

	}

	public void suprimerAbsence(Absence absence) {
		entityManager.remove(entityManager.merge(absence));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Absence> finAll(Identite identite) {
		Query query = entityManager
				.createQuery("select abs from Absence abs where abs.identite=:ident");
		query.setParameter("ident", identite);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Absence> findFromDateToDate(Identite identite, Date dateDebut,
			Date dateFin) {
		Query query = entityManager
				.createQuery("select abs from Absence abs where (abs.identite=:ident) and (abs.dateDebut between :datedeb and :datefin) and (abs.dateFin between :datedeb and :datefin)");
		query.setParameter("ident", identite);
		query.setParameter("datedeb", dateDebut);
		query.setParameter("datefin", dateFin);
		return query.getResultList();
	}

}
