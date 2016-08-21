package com.yesserp.sessionbean.gta.gestionactivitereelsaisie;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.ActiviteReelSaisie;

/**
 * Session Bean implementation class GestionActiviteReelSaisie
 */
@Stateless
@LocalBean
public class GestionActiviteReelSaisie implements
		GestionActiviteReelSaisieLocal {

	/**
	 * Default constructor.
	 */
	public GestionActiviteReelSaisie() {

	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<ActiviteReelSaisie> findAll(Identite identite) {
		Query query = entityManager.createQuery("select act from ActiviteReelSaisie act where act.identite=:ident");
		query.setParameter("ident", identite);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActiviteReelSaisie> findByDate(Identite identite, Date date) {
		Query query = entityManager
				.createQuery("select acts from ActiviteReelSaisie acts where acts.identite=:ident and acts.date=:date");
		query.setParameter("ident", identite);
		query.setParameter("date", date);
		return query.getResultList();
	}

	@Override
	public void ajouterActiviteReelSaisie(ActiviteReelSaisie activiteReelSaisie) {
		entityManager.persist(activiteReelSaisie);

	}

	@Override
	public void modifierActiviteReelSaisie(ActiviteReelSaisie activiteReelSaisie) {
		entityManager.merge(activiteReelSaisie);

	}

	@Override
	public void supprimerActiviteReelSaisie(
			ActiviteReelSaisie activiteReelSaisie) {
		entityManager.remove(entityManager.merge(activiteReelSaisie));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActiviteReelSaisie> findFromDateToDate(Identite identite,
			Date dateDeb, Date dateFin) {
		Query query = entityManager
				.createQuery("select acts from ActiviteReelSaisie acts where acts.identite=:ident and acts.date between :datedeb and :datefin");
		query.setParameter("ident", identite);
		query.setParameter("datedeb", dateDeb);
		query.setParameter("datefin", dateFin);
		return query.getResultList();
	}

}
